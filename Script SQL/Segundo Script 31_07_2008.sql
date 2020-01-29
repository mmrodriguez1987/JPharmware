
--DETALLE DE PLANILLA
create procedure AgregarDetallePlanilla
@CodEmpleado int
as
declare @CodPlanilla as int
declare @PrecioHora as float
declare @Viatico as float
declare @Deducciones as float
declare @SalarioBasico as float
declare @NetoARecibir as float
declare @HorasExtras as float
select @CodPlanilla = CodPlanilla from Planilla where EstadoCancelacion = '0' and EstadoAnulacion = '0'
select @PrecioHora = dbo.ObtenerPrecioHora(@CodEmpleado)
select @Viatico = dbo.ObtenerViatico(@CodEmpleado)
select @Deducciones = dbo.TotalDeducciones(@CodEmpleado) + dbo.DiasNoTrabajados(@CodEmpleado)
select @HorasExtras = dbo.TotalHorasExtras(@CodEmpleado)
select @SalarioBasico = dbo.ObtenerSalarioBasico(@CodEmpleado) 
set @NetoARecibir = @SalarioBasico + @HorasExtras*@PrecioHora + @Viatico - @Deducciones
if EXISTS(select CodEmpleado from DetallePlanilla where CodEmpleado = @CodEmpleado and CodPlanilla = @CodPlanilla)
begin 
	Print 'Ya se agrego el empleado al Detalle de Planilla'
end
else
begin
	insert into DetallePlanilla values(@CodPlanilla,@CodEmpleado,@SalarioBasico,@HorasExtras,@PrecioHora,@Viatico,@Deducciones,@NetoARecibir)
end 


--FUNCIONES PARA OBTENER CAMPOS DEL DETALLE DE PLANILLA
create function TotalDeducciones(@CodEmpleado int)
returns float
begin
	declare @CodPlanilla as int
	declare @TotalDeducciones as float
	declare @Deducciones as float
	declare @DiasNoTrabajados as float
	declare @FechaInicial as datetime
	declare @FechaFinal as datetime
	select @CodPlanilla = CodPlanilla from Planilla where EstadoCancelacion = '0' and EstadoAnulacion = '0'
	select @FechaInicial = dbo.FechaInicialPlanilla()
	select @FechaFinal = dbo.FechaFinalPlanilla()
	if EXISTS(select CodEmpleado from Deducciones where CodEmpleado = @CodEmpleado and FechaDeduccion between @FechaInicial and @FechaFinal)
	begin
		select @Deducciones = sum(Monto) from Deducciones where  CodEmpleado = @CodEmpleado and Estado = '0' and FechaDeduccion between @FechaInicial and @FechaFinal
	end
	else
	begin
		select @Deducciones = 0
	end	
	return @TotalDeducciones
end


create function DiasNoTrabajados(@CodEmpleado int)
returns float
begin
	declare @CodPlanilla as int
	declare @Deducciones as float
	declare @DiasNoLaborados as int
	declare @CostoDia as float
	declare @FechaInicial as datetime
	declare @FechaFinal as datetime
	select @CodPlanilla = CodPlanilla from Planilla where EstadoCancelacion = '0' and EstadoAnulacion = '0'
	select @FechaInicial = dbo.FechaInicialPlanilla()
	select @FechaFinal = dbo.FechaFinalPlanilla()
	if EXISTS(select CodEmpleado from ControlAsistencia where CodEmpleado = @CodEmpleado and CodPlanilla = @CodPlanilla and Laboro = '0' and Fecha between @FechaInicial and @FechaFinal)
	begin
		select @DiasNoLaborados= COUNT(Laboro) from ControlAsistencia where  CodEmpleado = @CodEmpleado and CodPlanilla = @CodPlanilla and Laboro = '0' and Fecha between @FechaInicial and @FechaFinal
	end
	else
	begin
		select @DiasNoLaborados = 0
	end
	set @CostoDia = dbo.ObtenerCostoDia(@CodEmpleado)
	set @Deducciones = @DiasNoLaborados*@CostoDia
	return @Deducciones
end


create function ObtenerCostoDia(@CodEmpleado int)
returns float
begin
	declare @CodCargo as int
	declare @CostoDia as float
	select @CodCargo = CodCargo from Empleados where CodEmpleado = @CodEmpleado
	select @CostoDia = CostoNTD from Cargos where CodCargo = @CodCargo
	return @CostoDia
end


create function TotalHorasExtras(@CodEmpleado int)
returns float
begin
	declare @CodPlanilla as int
	declare @FechaInicial as datetime
	declare @FechaFinal as datetime
	declare @HorasExtras as float
	declare @MinutosExtras as float 
	select @CodPlanilla = CodPlanilla from Planilla where EstadoCancelacion = '0' and EstadoAnulacion = '0'
	select @FechaInicial = dbo.FechaInicialPlanilla()
	select @FechaFinal = dbo.FechaFinalPlanilla()
	select @MinutosExtras = sum(MinutosExtras) from ControlAsistencia where CodEmpleado = @CodEmpleado and CodPlanilla = @CodPlanilla and Fecha between @FechaInicial and @FechaFinal
	set @HorasExtras = ROUND(@MinutosExtras/60,2)
	return @HorasExtras
end


create function ObtenerSalarioBasico(@CodEmpleado int)
returns float
begin
	declare @SalarioBasico as float
	declare @CodCargo as int
	select @CodCargo = CodCargo from Empleados where CodEmpleado = @CodEmpleado
	select @SalarioBasico = SalarioBasico from Cargos where CodCargo = @CodCargo
	return @SalarioBasico
end


create function ObtenerPrecioHora(@CodEmpleado int)
returns float
begin
	declare @PrecioHora as float
	declare @CodCargo as float
	select @CodCargo = CodCargo from Empleados where CodEmpleado = @CodEmpleado
	select @PrecioHora = PrecioHora from Cargos where CodCargo = @CodCargo
	return @PrecioHora
end


create function ObtenerViatico(@CodEmpleado int)
returns float
begin
	declare @Viatico as float
	declare @CodCargo as float
	select @CodCargo = CodCargo from Empleados where CodEmpleado = @CodEmpleado
	select @Viatico = Viatico from Cargos where CodCargo = @CodCargo
	return @Viatico
end


create function FechaInicialPlanilla()
returns datetime
begin
	declare @FechaInicio as datetime
	select @FechaInicio = FechaInicio from Planilla where EstadoAnulacion = '0' and EstadoCancelacion = '0'
	return @FechaInicio
end


create function FechaFinalPlanilla()
returns datetime
begin
	declare @FechaFinal as datetime
	select @FechaFinal = FechaFinal from Planilla where EstadoAnulacion = '0' and EstadoCancelacion = '0'
	return @FechaFinal
end


--FUNCIONES PARA EL CONTROL DE ASISTENCIA (HORAS EXTRAS)
create function MinutosExtras(@HoraEntrada datetime, @HoraSalida datetime)
returns int
begin
	declare @MinutosExtras as int
	select @MinutosExtras = dbo.MinutosTrabajados(@HoraEntrada, @HoraSalida) - 480
	return @MinutosExtras
end


create function MinutosTrabajados(@HoraEntrada datetime, @HoraSalida datetime)
returns int
begin
	declare @Minutos as int
	select @Minutos = DATEDIFF(minute,@HoraEntrada,@HoraSalida)
	return @Minutos
end

create function Redondear(@Cantidad float)
returns float
begin
	declare @CantidadRedondeada as float
	select @CantidadRedondeada = ROUND(@Cantidad,2)
	return @CantidadRedondeada
end

--FUNCION PARA CANCELAR LA PLANILLA
create function TotalPagadoPlanilla(@CodPlanilla int)
returns float
begin
	declare @TotalPagado as float
	select @TotalPagado = sum(NetoARecibir) from DetallePlanilla where CodPlanilla = @CodPlanilla
	return @TotalPagado
end