---Jueves 31/07/2008 al Viernes 01/08/2008
select * from Cargos
AgregarCargos 'Responsable de Ventas',500,850,11.5
AgregarCargos 'Responsable de Bodega',200,700,5.75
AgregarCargos 'Vendedor',200,700,11.5,92

ModificarCargos 1,'Responsable de Ventas',500,850,11.5,92
ModificarCargos 2,'Responsable de Bodega',200,700,5.75,64
ModificarCargos 3,'Vendedor',200,700,11.5,92

select * from Empleados
AgregarEmpleados 1,'2000-01-01','001-200287-0023B','Noel Armando','Rodríguez','Barrio San Judas','880-7916'
AgregarEmpleados 2,'2002-06-01','001-011086-0023N','Carlos Frederick','García','Barrio San Judas','845-9623'
AgregarEmpleados 3,'2003-01-06','002-101283-0263Z','Ana Sofía','Martínez','Barrio Camilo Ortega','670-2035'
AgregarEmpleados 2,'2005-05-02','012-040685-014O','David José','García','Barrio San Judas','260-4531'

select * from Deducciones
AgregarDeduccion 1,'2008-20-07','Adelanto',20
AgregarDeduccion 3,'2008-20-07','Adelanto',200

Print dbo.ObtenerSalarioBasico(1) - dbo.TotalDeducciones(1)
Print dbo.TotalDeducciones(2)

delete ControlAsistencia where CodPlanilla = 4
select CodPlanilla from Planilla where EstadoCancelacion = '1' and EstadoAnulacion = '1'
select FechaInicio,FechaFinal from Planilla where EstadoCancelacion = '1' and EstadoAnulacion = '1'
select sum(Monto) from Deducciones where  CodEmpleado like 2 and FechaDeduccion between '2008-16-07' and '2008-31-07'
update Deducciones set FechaDeduccion = '2008-23-07' where CodEmpleado = 2


select * from ControlAsistencia
--PRIMER DIA
AgregarHoraEntrada 1,'2008-16-07','07:00:000','0'
AgregarHoraSalida 1,'2008-16-07','16:30:000'

AgregarHoraEntrada 2,'2008-16-07','08:00:000','0'
AgregarHoraSalida 2,'2008-16-07','16:00:000'

AgregarHoraEntrada 3,'2008-16-07','12:00:000','0'
AgregarHoraSalida 3,'2008-16-07','20:00:000'


--SEGUNDO DIA
AgregarHoraEntrada 1,'2008-17-07','07:00:000','1'
AgregarHoraSalida 1,'2008-17-07','17:30:000'

AgregarHoraEntrada 2,'2008-17-07','08:00:000','1'
AgregarHoraSalida 2,'2008-17-07','17:00:000'

AgregarHoraEntrada 3,'2008-17-07','12:00:000','1'
AgregarHoraSalida 3,'2008-17-07','22:00:000'

--TERCER DIA
AgregarHoraEntrada 1,'2008-18-07','07:00:000','0'
AgregarHoraSalida 1,'2008-18-07','15:00:000'

AgregarHoraEntrada 2,'2008-18-07','08:00:000','0'
AgregarHoraSalida 2,'2008-18-07','15:00:000'

AgregarHoraEntrada 3,'2008-18-07','12:00:000','0'
AgregarHoraSalida 3,'2008-18-07','20:00:000'

--CUARTO DIA
AgregarInasistencia 1,'2008-19-07','0'

AgregarHoraEntrada 2,'2008-19-07','08:00:000','0'
AgregarHoraSalida 2,'2008-19-07','19:00:000'

AgregarHoraEntrada 3,'2008-19-07','12:00:000','0'
AgregarHoraSalida 3,'2008-19-07','20:00:000'

--QUINTO DIA 
AgregarHoraEntrada 1,'2008-20-07','07:00:000','1'
AgregarHoraSalida 1,'2008-20-07','15:00:000'

AgregarInasistencia 2,'2008-20-07','1'

AgregarHoraEntrada 3,'2008-20-07','12:00:000','1'
AgregarHoraSalida 3,'2008-20-07','19:00:000'

--SEXTO DIA
AgregarHoraEntrada 1,'2008-21-07','07:00:000','1'
AgregarHoraSalida 1,'2008-21-07','15:10:000'

AgregarInasistencia 2,'2008-21-07','1'

AgregarHoraEntrada 3,'2008-21-07','12:00:000','1'
AgregarHoraSalida 3,'2008-21-07','20:30:000' 

select CodEmpleado = 2,Nombres,Apellidos from Empleados 
INNER JOIN ControlAsistencia on Empleados.CodEmpleado = ControlAsistencia.CodEmpleado 
where CodEmpleado = 2 Laboro = '0' and 


Print dbo.TotalDeducciones(1)
Print dbo.DiasNoTrabajados(1)
Print dbo.TotalHorasExtras(1)

Print dbo.TotalPagadoPlanilla(4)

Print dbo.Redondear(4.169999999999)
AgregarDetallePlanilla 1
AgregarDetallePlanilla 2
AgregarDetallePlanilla 3

AgregarDeduccion 3,'2008-10-07','Adelanto',200
LiquidarPlanilla '2008-31-07'


Print dbo.TotalHorasExtras(1)
Print dbo.DiasNoTrabajados(3)

select sum(MinutosExtras) from ControlAsistencia where CodEmpleado = 3
select * from DetallePlanilla
select * from Planilla
select * from Deducciones where CodEmpleado = 1
update Deducciones set Estado = '1' where CodDeduccion = 7
--delete DetallePlanilla where CodPlanilla = 4 and CodEmpleado = 3
select * from Empleados
DarBajaEmpleado 7,'2008-15-08'
update Empleados set Estado = '0' where CodEmpleado = 7
EliminarCargos 3

@RazonSocial nvarchar(70), @NumRuc char(20),@Direccion nvarchar(70),
@TelEmpresa char(15), @Contacto nvarchar(50), @TelContacto char(15),
@PorcDesc float

select * from Proveedores
AgregarProveedor 'Suministros Internacional',null,'Reparto San Juan','222-2635','José Luis Chávez',10
AgregarProveedor 'DICEGSA',null,'Carretera Norte','249-8574','Juan Pérez',5
AgregarProveedor 'CEGUEL',null,'Linda Vista','268-4567','Wilfredo Altamirano',7
AgregarProveedor 'IFC',null,'Bº Monseñor Lezcano','263-8641','Carlos Ortiz',5
AgregarProveedor 'Dispan S.A',null,'Col. Rafaela Herrera','249-4112','Oscar Argüello',5
AgregarProveedor 'Argüello Dávila',null,'Col. "EL Periodista"','250-3656','Manuel Argüello Dávila',2

select * from CategoriaProducto
AgregarCategoria 'MISCELANEO'
AgregarCategoria 'FARM-REGULADO'
AgregarCategoria 'FARM-NOREGULADO'

AgregarProducto
@CodProveedor int, @CodCategoria int, @NombreProd nvarchar(50), @Presentacion nvarchar(50), @UndsContenido int, @FechaAsignacion datetime, @PrecioVenta float,@CostoUnit float, @DiasVenc int

AgregarProducto 1,3,'Pepto-Bismol','Frasco 236 ml',1,'2008-12-08',65,49.10,30
AgregarProducto 1,3,'Espaven Enzimático','Caja/Sobres',50,'2008-12-08',2.5,10,30
AgregarProducto 1,3,'Vitapyrena 5 gr','Caja/Sobres',50,'2008-12-08',3.5,3,50

AgregarProducto 2,2,'Viro Grip','Caja/Sobres',100,'2008-13-08',20,15,30
AgregarProducto 2,1,'Gaseosa 12 onz','Cajillas',24,'2008-13-08',7,5.1,0

AgregarProducto 1,'Papel Higiénico Scott','Bolsón','Rollo 300 Hojas',24,'2008-18-09',7.5

AsignarCostoProducto 1,'2008-12-08',49.10
AgregarProductoProveedor 2,1
AsignarCostoProducto 2,'2008-12-08',100

DarBajaProducto 6

ModificarProducto 6,1,'Papel Higiénico Velvet','Bolsón','Rollo 300 Hojas',24,'2008-18-09',6.5

update Productos set DadoDeBaja = '0' where CodProducto = 6

update ProductoProveedor set DiasVenc = 30 where CodProdProv = 2
select * from HistorialCostosProductos
select * from HistorialPVUProductos
select * from ProductoProveedor


select CodProdProv,FechaAsignacion,FechaReemplazo,CostoUnit,Vigente from ProductoProveedor
inner join HistorialCostosProductos on HistorialCostosProductos.NumProdProv = ProductoProveedor.CodProdProv


ReemplazarCostoProducto 1,50.5

ReemplazarPVUProducto 6,'2009-12-08'

ReemplazarPVUProducto 6,7.5

ModificarProducto 4,2,'Viro Gato','Caja/Sobres',100
ModificarProducto 5,1,'Gaseosa','Cajilla/Botella 12 onz',24

update HistorialPVUProductos set FechaReemplazo = null where CodProducto = 1

create rule CantidadPositiva 
as
@Cantidad >= 0

create rule MayorQueCero
as
@Num > 0

sp_bindrule 'CantidadPositiva','VencimientoProductos.Existencias'
sp_bindrule 'MayorQueCero','HistorialCostosProductos.CostoUnit'
sp_bindrule 'MayorQueCero','HistorialPVUProductos.PrecioVenta'

ModificarProveedor 5,'Dispan S.A',null,'Col. Rafaela Herrera','249-4112','Carlos Sánchez',5



AgregarCompraContado 1,2,69389,'2008-13-08'
AgregarDetalleCompraContado 'Viro Gato','Caja/Sobres',25,'2010-13-08'
AgregarDetalleCompraContado 'Gaseosa','Cajilla/Botella 12 onz',5,'2010-13-08'


select * from Empleados
select (Nombres+' '+Apellidos) as 'Nombre' from Empleados 
Print dbo.ObtenerCodCategoria(1)

select CodEmpleado from Empleados where (Nombres+' '+Apellidos) = 'Noel Armando Rodríguez'

AgregarNotaCredito 1,1,14700,'2008-13-08','2008-31-08'

AgregarDetalleNotaCredito 'Vitapyrena 5 gr','Caja/Sobres',10,'2011-20-01'

update NotasCredito set FechaCancelacion = '2008-13-09'

 
AsignarVencimiento 2,'2011-01-09',15

select * from Proveedores
select * from Productos
select * from CategoriaProducto
select * from Proveedores
select * from ComprasContado
select * from HistorialCostosProductos
select * from DetalleCompraContado
select * from NotasCredito
select * from DetalleNotaCredito
select * from VencimientoProductos

select * from Ventas
select * from DetalleVenta
select * from HistorialPVUProductos
select * from Productos 
select * from ProductoProveedor


inner join CategoriaProducto on Productos.CodCategoria = CategoriaProducto.CodCategoria
inner join HistorialPVUProductos on Productos.CodProducto = HistorialPVUProductos.CodProducto
inner join ProductoProveedor on Productos.CodProducto = ProductoProveedor.CodProducto
inner join VencimientoProductos on ProductoProveedor.CodProdProv = ProductoProveedor.CodProdProv

AgregarVentas 1,'2008-19-08'

AgregarDetalleVenta 4,75

AgregarProductoProveedor 6,6,0,4.90
delete ProductoProveedor where CodProdProv = 7

AgregarCompraContado 6,6,56765,'2008-18-08'
AgregarDetalleCompraContado 6,20,null

AgregarVentas 1,'2008-19-08'
AgregarDetalleVenta 8,15


select * from D


select NombreProd, Presentacion,Descripcion, PrecioVenta, Existencias, ExistenciasDetalle, FechaVenc from Productos
inner join CategoriaProducto on Productos.CodCategoria = CategoriaProducto.CodCategoria
inner join ProductoProveedor on Productos.CodProducto = ProductoProveedor.CodProducto
inner join HistorialPVUProductos on Productos.CodProducto =  HistorialPVUProductos.CodProducto
inner join VencimientoProductos on VencimientoProductos.CodProdProv  = ProductoProveedor.CodProdProv
where CodProveedor = 1 and Vigente = '1' and Vencido = '0' and DadoDeBaja = '0'          
            