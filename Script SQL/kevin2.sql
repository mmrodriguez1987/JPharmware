create procedure AgregarDeduccion
@CodEmpleado int, @FechaDeduccion datetime,
@Motivo nvarchar(50),@TipoDeduccion char(9),@Monto float
as
declare @SaldoDisponible as float
declare @TotalDeducciones as float
declare @SalarioBasico  as float
declare @Viatico  as float
set @SalarioBasico = dbo.ObtenerSalarioBasico(@CodEmpleado)
set @Viatico = dbo.ObtenerViatico(@CodEmpleado)
select @TotalDeducciones = dbo.TotalDeducciones(@CodEmpleado)
set @SaldoDisponible = @SalarioBasico + @Viatico - @TotalDeducciones
if @Monto > @SaldoDisponible
	begin
		Print 'Su saldo es insuficiente, espere la otra quincena'
	end
	else 
	begin
		insert into Deducciones values(@CodEmpleado,@FechaDeduccion,@Motivo,@TipoDeduccion,@Monto,'0')
end

create function VerificarSaldo(@CodEmpleado int,@Monto float)
returns int
begin
	declare @SaldoDisponible as float		--0=No hay suficiente saldo
	declare @TotalDeducciones as float		--1=Suficiente saldo
	declare @SalarioBasico  as float
	declare @Viatico  as float
	declare @resultado as int
	set @SalarioBasico = dbo.ObtenerSalarioBasico(@CodEmpleado)
	set @Viatico = dbo.ObtenerViatico(@CodEmpleado)
	select @TotalDeducciones = dbo.TotalDeducciones(@CodEmpleado)
	set @SaldoDisponible = @SalarioBasico + @Viatico - @TotalDeducciones
	if @Monto > @SaldoDisponible
	begin
		set @resultado=0
	end
	else 
	begin
		set @resultado=1
	end
return @resultado
end

drop function VerificarSaldo
SELECT FarmaciaAllisonRevolution.dbo.VerificarSaldo(1,90.01) AS 'RESULTADO'

AgregarDeducProd 1,'2008-25-09 00:22:36.477','Pidio Pastillas','prod',3,100,3,1
create procedure AgregarDeducProd
@CodEmpleado int, @FechaDeduccion datetime,
@Motivo nvarchar(50),@TipoDeduccion char(9),@CodProdProv int,
@Cantidad int,@Precio float, @Trick as int
as
declare @SaldoDisponible as float
declare @TotalDeducciones as float
declare @SalarioBasico  as float
declare @Viatico  as float
declare @Monto as float
set @SalarioBasico = dbo.ObtenerSalarioBasico(@CodEmpleado)
set @Viatico = dbo.ObtenerViatico(@CodEmpleado)
select @TotalDeducciones = dbo.TotalDeducciones(@CodEmpleado)
set @SaldoDisponible = @SalarioBasico + @Viatico - @TotalDeducciones
set @Monto=@Cantidad*@Precio
if @Monto > @SaldoDisponible
begin
	Print 'Su saldo es insuficiente, espere la otra quincena'
end
else 
begin
	if @Trick=0
		begin
			--significa que es la primera vez que entra al detalle, ojo esta variable se manipulara desde java
			insert into Deducciones values(@CodEmpleado,@FechaDeduccion,@Motivo,@TipoDeduccion,@Monto,'0')
			declare @CodDeduccion as int
			select @CodDeduccion= max (CodDeduccion)from Deducciones
			insert into DetalleDeduccion values(@CodDeduccion,@CodProdProv,@Cantidad,@Precio)
			EXEC ReducirInventario @CodProdProv,@Cantidad,@Monto
		end
		else
		begin
			--significa que se esta mandando a llamar al menos la 2da vez, o sea que se pide mas de un producto 
			declare @CodDeduccion2 as int
			select @CodDeduccion2= max (CodDeduccion)from Deducciones
			insert into DetalleDeduccion values(@CodDeduccion2,@CodProdProv,@Cantidad,@Precio)
			EXEC ReducirInventario @CodProdProv,@Cantidad,@Monto			
		end
end

create procedure RevisarExistenciaProductos



create procedure ReducirInventario
@CodProdProv int,@Cantidad int,@Monto float
as
declare @CodVencimiento as int
declare @CodCategoria as int
declare @CodDeduccion as int
declare @Cantidad2 as int
select @CodDeduccion = MAX(CodDeduccion) from Deducciones
select @CodCategoria = dbo.ObtenerCodCategoria(@CodProdProv)
if (@CodCategoria <> 1)
begin
	select @CodVencimiento = dbo.ObtenerCodVencimiento(@CodProdProv)		
end
else
begin   
	select @CodVencimiento = dbo.ObtenerCodVencProdMisc(@CodProdProv)	
end
	update Deducciones set Monto = Monto + @Monto where CodDeduccion = @CodDeduccion
EXEC AsignarVencimientoVentas @CodVencimiento, @Cantidad



create function ObtenerSalarioBasico(@CodEmpleado int)
returns float
begin
	declare @SalarioBasico as float
	declare @CodCargo as int
	select @CodCargo = CodCargo from Empleados where CodEmpleado = @CodEmpleado
	select @SalarioBasico = SalarioBasico from HistorialCargos where CodCargo = @CodCargo and Estado='1'
	return @SalarioBasico
end


create function ObtenerViatico(@CodEmpleado int)
returns float
begin
	declare @Viatico as float
	declare @CodCargo as int
	select @CodCargo = CodCargo from Empleados where CodEmpleado = @CodEmpleado
	select @Viatico = Viatico from HistorialCargos where CodCargo = @CodCargo and Estado='1'
	return @Viatico
end


create function TotalDeducciones(@CodEmpleado int)
returns float
begin
	declare @CodPlanilla as int
	declare @TotalDeducciones as float
	declare @FechaInicial as datetime
	declare @FechaFinal as datetime
	select @CodPlanilla = CodPlanilla from Planilla where EstadoCancelacion = '0' and EstadoAnulacion = '0'
	select @FechaInicial = dbo.FechaInicialPlanilla()
	select @FechaFinal = dbo.FechaFinalPlanilla()
	if EXISTS(select CodEmpleado from Deducciones where CodEmpleado = @CodEmpleado and FechaDeduccion between @FechaInicial and @FechaFinal)
	begin
		select @TotalDeducciones = sum(Monto) from Deducciones where  CodEmpleado = @CodEmpleado and Estado = '0' and FechaDeduccion between @FechaInicial and @FechaFinal
	end
	else
	begin
		select @TotalDeducciones = 0
	end
	return @TotalDeducciones
end


create function FechaFinalPlanilla()
returns datetime
begin
	declare @FechaFinal as datetime
	select @FechaFinal = FechaFinal from Planilla where EstadoAnulacion = '0' and EstadoCancelacion = '0'
	return @FechaFinal
end


create function FechaInicialPlanilla()
returns datetime
begin
	declare @FechaInicio as datetime
	select @FechaInicio = FechaInicio from Planilla where EstadoAnulacion = '0' and EstadoCancelacion = '0'
	return @FechaInicio
end