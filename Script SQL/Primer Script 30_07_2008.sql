
--EMPLEADOS
create procedure AgregarEmpleados
@CodCargo int,@FechaIngreso datetime,
@Cedula char(16), @Nombres nvarchar(25),
@Apellidos nvarchar(25), @Domicilio nvarchar(50),
@Sexo char(1),@Foto as nvarchar(300), @Telefono char(10),@NoInss char(7)
as
if EXISTS(select Cedula from Empleados where Cedula = @Cedula)
begin
	Print 'Ya se encuentra registrado esta persona'
end
else
begin
	insert into Empleados values(@CodCargo,@FechaIngreso,null,@Cedula,@Nombres,@Apellidos,@Domicilio,@Telefono,@Sexo,@Foto,'1',@NoInss)
end


create procedure ModificarDatosEmpleados
@CodEmpleado int,@CodCargo int,@FechaIngreso datetime,
@Cedula char(16), @Nombres nvarchar(25),@Apellidos nvarchar(25),
@Domicilio nvarchar(50),@Sexo char(1), @Foto as nvarchar(255), @Telefono char(10)
as
update Empleados set CodCargo = @CodCargo where CodEmpleado = @CodEmpleado
update Empleados set FechaIngreso = @FechaIngreso where CodEmpleado = @CodEmpleado
update Empleados set Cedula = @Cedula where CodEmpleado = @CodEmpleado
update Empleados set Nombres = @Nombres where CodEmpleado = @CodEmpleado
update Empleados set Apellidos = @Apellidos where CodEmpleado = @CodEmpleado
update Empleados set Domicilio = @Domicilio where CodEmpleado = @CodEmpleado
update Empleados set Telefono = @Telefono where CodEmpleado = @CodEmpleado 
update Empleados set Sexo = @Sexo where CodEmpleado = @CodEmpleado  
update Empleados set Foto = @Foto where CodEmpleado = @CodEmpleado


create procedure DarBajaEmpleado
@CodEmpleado int, @FechaDespido datetime
as 
if EXISTS(select Estado from Empleados where CodEmpleado = @CodEmpleado and Estado = '0')
begin
	Print 'El empleado ya fue despedido'
end
else
begin
	update Empleados set Estado = '0' where CodEmpleado = @CodEmpleado
	update Empleados set FechaDespido = @FechaDespido where CodEmpleado = @CodEmpleado
end

--CARGOS
create procedure AgregarCargos
@Descripcion nvarchar(30),@Viatico float,@SalarioBasico float
as
declare @CodCargo as int
if exists(select Descripcion from Cargos where Descripcion = @Descripcion)
begin
	Print 'Ya existe el Cargo'
end
else
begin
	insert into Cargos values(@Descripcion)
	select @CodCargo= max (CodCargo)from Cargos 
        insert into HistorialCargos values (@CodCargo,getdate(),null,@SalarioBasico,@Viatico,'1')
	insert into DetalleVigenciaCargo values(@CodCargo,getdate(),null,'1')
end



create procedure ModificarCargos
@CodCargo int,@SalarioBasico float,@Viatico float,@Estado bit
as
declare @SalarioBasico2 as float
declare @Viatico2 as float
select @SalarioBasico2= SalarioBasico from HistorialCargos where CodCargo=@CodCargo and Estado=1
select @Viatico2= Viatico from HistorialCargos where CodCargo=@CodCargo and Estado=1
if(@SalarioBasico2<>@SalarioBasico or @Viatico2<>@Viatico)
begin
	--se insertara una nueva tupla
	update HistorialCargos set FechaRemplazo=getdate()
	update HistorialCargos set HistorialCargos.Estado=0
	insert into HistorialCargo values (@CodCargo,getdate(),null,@SalarioBasico,@Viatico,'1')
	end
update DetalleVigenciaCargo set DetalleVigenciaCargo.Estado=@Estado


create procedure EliminarCargos
@CodCargo int
as
if EXISTS(select CodCargo from Cargos where  CodCargo = @CodCargo)
begin
	delete from Cargos where CodCargo = @CodCargo
end
else
begin
	Print 'No existe el Cargo o ya fue eliminado'
end


--DEDUCCIONES
create procedure AgregarDeduccion
@CodEmpleado int, @FechaDeduccion datetime,
@Motivo nvarchar(50),@TipoDeduccion char(9),@Monto float
as
declare @SaldoDisponible as float
declare @TotalDeducciones as float
declare @SalarioBasico  as float
set @SalarioBasico = dbo.ObtenerSalarioBasico(@CodEmpleado)
select @TotalDeducciones = dbo.TotalDeducciones(@CodEmpleado)
set @SaldoDisponible = @SalarioBasico - @TotalDeducciones
if @Monto > @SaldoDisponible
begin
	Print 'Su saldo es insuficiente, espere la otra quincena'
end
else 
begin
	insert into Deducciones values(@CodEmpleado,@FechaDeduccion,@Motivo,@TipoDeduccion,@Monto,'0')
end

create procedure AnularDeduccion
@CodDeduccion int
as 
update Deducciones set Estado = '1' where CodDeduccion = @CodDeduccion

create procedure AgregarDetalleDeduccion
@CodDeduccion int, @CodProdProv int,@Cantidad float,@Precio float
as
insert into DetalleDeduccion values(@CodDeduccion,@CodProdProv,@Cantidad,@Precio)
update Deduccion set Monto = Monto + (@Cantidad*@Precio)


create trigger DisminuirProdProvDeduccion
on DetalleDeduccion after insert
as update ProductoProveedor set Existencias = Existencias - (select Cantidad from inserted)
from inserted i,ProductoProveedor p
where p.CodProdProv = i.CodProdProv


--PLANILLA
create procedure AgregarPlanilla
@FechaInicio datetime,@FechaFinal datetime
as
insert into Planilla values(@FechaInicio,@FechaFinal,null,0.0,'0','0')

--La Planilla puede estar cancelada, pero no anulada

create procedure LiquidarPlanilla
@FechaCancelacion datetime
as
declare @CodPlanilla as int
declare @TotalPagado as float
select @CodPlanilla = CodPlanilla from Planilla where EstadoCancelacion = '0' and EstadoAnulacion = '0'
set @TotalPagado = dbo.TotalPagadoPlanilla(@CodPlanilla)
update Planilla set FechaCancelacion = @FechaCancelacion where CodPlanilla = @CodPlanilla
update Planilla set EstadoCancelacion = '1' where CodPlanilla = @CodPlanilla
update Planilla set TotalPagado = @TotalPagado where CodPlanilla = @CodPlanilla


create procedure AnularPlanilla
@CodPlanilla int
as
update Planilla set EstadoAnulacion = '1' where CodPlanilla = @CodPlanilla
update Planilla set EstadoCancelacion = '1' where CodPlanilla = @CodPlanilla
 

--CONTROL DE ASISTENCIA
create procedure AgregarHoraEntrada
@CodEmpleado int, @Fecha datetime, @HoraEntrada datetime, @DiaFeriado bit
as
declare @CodPlanilla as int
select @CodPlanilla = CodPlanilla from Planilla where EstadoCancelacion = '0' and EstadoAnulacion = '0'
if EXISTS(select CodEmpleado from ControlAsistencia where CodEmpleado = @CodEmpleado and Fecha = @Fecha)
	begin
		Print 'HoraEntrada: Ya existe un registro con esta fecha'
	end
else
	begin
		insert into ControlAsistencia values(@CodPlanilla,@CodEmpleado,@Fecha,'1',@HoraEntrada,null,0,@DiaFeriado)
	end


create procedure AgregarHoraSalida
@CodEmpleado int,@Fecha datetime, @HoraSalida datetime
as
declare @CodPlanilla as int
declare @MinutosExtras as int
declare @HoraEntrada as datetime
select @CodPlanilla = CodPlanilla from Planilla where EstadoCancelacion = '0' and EstadoAnulacion = '0'
select @HoraEntrada = HoraEntrada from ControlAsistencia where CodPlanilla = @CodPlanilla and CodEmpleado = @CodEmpleado and Fecha = @Fecha
if EXISTS(select DiaFeriado from ControlAsistencia where DiaFeriado = '0' and CodEmpleado = @CodEmpleado and CodPlanilla = @CodPlanilla and Fecha = @Fecha)
	begin 
		set @MinutosExtras = dbo.MinutosExtras(@HoraEntrada,@HoraSalida)
	end
if EXISTS(select DiaFeriado from ControlAsistencia where DiaFeriado = '1' and CodEmpleado = @CodEmpleado and CodPlanilla = @CodPlanilla and Fecha = @Fecha)
	begin
		set @MinutosExtras = dbo.MinutosTrabajados(@HoraEntrada,@HoraSalida)
	end
update ControlAsistencia set HoraSalida = @HoraSalida where CodPlanilla  = @CodPlanilla and CodEmpleado = @CodEmpleado and Fecha = @Fecha 
update ControlAsistencia set MinutosExtras = @MinutosExtras where CodPlanilla  = @CodPlanilla and CodEmpleado = @CodEmpleado and Fecha = @Fecha 


create procedure AgregarInasistencia
@CodEmpleado int,@Fecha datetime, @DiaFeriado as bit
as
declare @CodPlanilla as int
select @CodPlanilla = CodPlanilla from Planilla where EstadoCancelacion = '0' and EstadoAnulacion = '0'
if EXISTS(select CodEmpleado from ControlAsistencia where CodEmpleado = @CodEmpleado and Fecha = @Fecha)
	begin
		Print 'Inasistencia: Ya existe un registro con esta fecha de este Empleado'
	end
else
	begin
		insert into ControlAsistencia values(@CodPlanilla,@CodEmpleado,@Fecha,'0',null,null,0,@DiaFeriado)
	end


create procedure EliminarControlAsistencia
@CodEmpleado int, @Fecha datetime
as
declare @CodPlanilla as int
select @CodPlanilla = CodPlanilla from Planilla where EstadoCancelacion = '0' and EstadoAnulacion = '0'
delete from ControlAsistencia where CodEmpleado = @CodEmpleado and CodPlanilla = @CodPlanilla and Fecha = @Fecha

select CodCargo from Cargos where Descripcion = 'Vendedor'
select * from Empleados

create function ValidarExistenciaEmpleado(@Cedula char(16))
returns char(2)
begin
declare @resultado as char(2)
if EXISTS(select Cedula from Empleados where Cedula = @Cedula)
	begin
		set @resultado = 'Si'
	end
else
	begin
		set @resultado = 'No'
	end
return @resultado
end

Print dbo.ValidarExistenciaEmpleado('001-010489-0019U')


create procedure ValidarCedula
@Cedula char(16)
as
if EXISTS(select Cedula from Empleados where Cedula = @Cedula)
	begin
		Print 'Si'
	end
else
	begin
		Print 'No'
	end

delete Empleados where CodEmpleado = 28

