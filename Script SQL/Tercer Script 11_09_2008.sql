--REGISTRO DE PRODUCTOS
create procedure AgregarProveedor
@RazonSocial nvarchar(70), @NumRuc char(20),@Direccion nvarchar(70),
@TelEmpresa char(15), @Contacto nvarchar(50), @PorcDesc float
as
if EXISTS(select RazonSocial from Proveedores where RazonSocial = @RazonSocial)
	begin
		Print 'Ya existe el Proveedor'
	end
else
	begin
		insert into Proveedores values(@RazonSocial,@NumRuc,@Direccion,@TelEmpresa,@Contacto,@PorcDesc)
	end

create procedure ModificarProveedor
@CodProveedor int,@RazonSocial nvarchar(70), @NumRuc char(20),@Direccion nvarchar(70),
@TelEmpresa char(15), @Contacto nvarchar(50),@PorcDesc float
as
update Proveedores set RazonSocial = @RazonSocial where CodProveedor = @CodProveedor
update Proveedores set NumRuc = @NumRuc where CodProveedor = @CodProveedor
update Proveedores set Direccion = @Direccion where CodProveedor = @CodProveedor
update Proveedores set TelEmpresa = @TelEmpresa where CodProveedor = @CodProveedor
update Proveedores set Contacto = @Contacto where CodProveedor = @CodProveedor
update Proveedores set PorcDesc = @PorcDesc where CodProveedor = @CodProveedor

create procedure AgregarCategoria
@Descripcion char(15)
as
if EXISTS(select Descripcion from CategoriaProducto where Descripcion = @Descripcion)
	begin
		Print 'Ya existe esta Categoría'
	end
else
	begin
		insert into CategoriaProducto values(@Descripcion)
	end 


create procedure ModificarCategoria
@CodCategoria int,@Descripcion char(15)
as
update CategoriaProducto set Descripcion = @Descripcion where CodCategoria = @CodCategoria

create procedure AsignarPVUProducto
@CodProducto int, @FechaAsignacion datetime, @PrecioVenta float
as 
if EXISTS(select Vigente from HistorialPVUProductos where Vigente = '1' and CodProducto = @CodProducto)
	begin
		Print 'Este producto tiene un precio vigente'
	end
else
	begin
		insert into HistorialPVUProductos values(@CodProducto,@FechaAsignacion,null,@PrecioVenta,'1')
	end

create procedure ReemplazarPVUProducto
@CodProducto int, @PrecioVenta float
as 
declare @Fecha as datetime
select @Fecha = getDate()
update HistorialPVUProductos set FechaReemplazo = @Fecha where CodProducto = @CodProducto and Vigente = '1'
update HistorialPVUProductos set Vigente = '0' where CodProducto = @CodProducto and Vigente = '1'
EXEC AsignarPVUProducto @CodProducto, @Fecha, @PrecioVenta


create procedure  
@NumProdProv int, @FechaAsignacion datetime, @CostoUnit float
as 
if EXISTS(select Vigente from HistorialCostosProductos where Vigente = '1' and NumProdProv = @NumProdProv)
	begin
		Print 'Existe un costo vigente'
	end
else
	begin
		insert into HistorialCostosProductos values(@NumProdProv,@FechaAsignacion,null,@CostoUnit,'1')
	end


create procedure ReemplazarCostoProducto
@NumProdProv int, @CostoUnit float
as 
declare @Fecha as datetime
select @Fecha = getDate()
update HistorialCostosProductos set FechaReemplazo = @Fecha where NumProdProv = @NumProdProv and Vigente = '1'
update HistorialCostosProductos set Vigente = '0' where NumProdProv = @NumProdProv and Vigente = '1'
EXEC AsignarCostoProducto @NumProdProv, @Fecha, @CostoUnit

create procedure AsignarVencimiento
@CodProdProv int, @FechaVenc datetime, @Cantidad int
as 
declare @CodCategoria as int
select @CodCategoria = dbo.ObtenerCodCategoria(@CodProdProv)
if (@CodCategoria = 1)
	begin
		if EXISTS(select CodProdProv from VencimientoProductos where CodProdProv = @CodProdProv)
			begin 
				update VencimientoProductos set Existencias = Existencias + @Cantidad where CodProdProv = @CodProdProv and Vencido = '0'
				update VencimientoProductos set ExistenciasDetalle = ExistenciasDetalle + dbo.IngresoExistenciaDetalle(@CodProdProv,@Cantidad) where FechaVenc = @FechaVenc and CodProdProv = @CodProdProv and Vencido = '0'
			end
		else
			begin
				insert into VencimientoProductos values(@CodProdProv,null,@Cantidad,dbo.IngresoExistenciaDetalle(@CodProdProv,@Cantidad),'0')	
			end
	end
else
	begin
			if EXISTS(select FechaVenc from VencimientoProductos where FechaVenc = @FechaVenc and CodProdProv = @CodProdProv)
				begin
					update VencimientoProductos set Existencias = Existencias + @Cantidad where FechaVenc = @FechaVenc and CodProdProv = @CodProdProv and Vencido = '0'
					update VencimientoProductos set ExistenciasDetalle = ExistenciasDetalle + dbo.IngresoExistenciaDetalle(@CodProdProv,@Cantidad) where FechaVenc = @FechaVenc and CodProdProv = @CodProdProv and Vencido = '0'
				end
			else
				begin
					insert into VencimientoProductos values(@CodProdProv,@FechaVenc,@Cantidad,dbo.IngresoExistenciaDetalle(@CodProdProv,@Cantidad),'0')
				end
	end


	
create procedure AgregarProductoProveedor
@CodProducto int, @CodProveedor int, @DiasVenc int, @CostoUnit float
as
declare @CodProdProv as int
declare @Fecha as datetime
select @Fecha = getDate()
if EXISTS(select CodProducto from ProductoProveedor where CodProducto = @CodProducto and CodProveedor = @CodProveedor)
	begin
		Print 'Este Producto y Proveedor, ya se encuentran relacionado'
	end
else
	begin		
		insert into ProductoProveedor values(@CodProducto,@CodProveedor,@DiasVenc)
		select @CodProdProv = MAX(CodProdProv) from ProductoProveedor
		EXEC AsignarCostoProducto @CodProdProv, @Fecha, @CostoUnit
	end


create procedure AgregarProducto
@CodCategoria int, @NombreProd nvarchar(50),@Lote nvarchar(50), @Presentacion nvarchar(50), @UndsContenido int,@PrecioVenta float
as
declare @CodProducto as int
declare @FechaAsignacion as datetime
select @FechaAsignacion = getDate()
if EXISTS(select NombreProd, Presentacion from Productos where CodProducto is not null and NombreProd = @NombreProd and Presentacion = @Presentacion)
	begin
		Print 'Ya existe este Producto con este tipo de Presentación'
	end
else 
	begin
		insert into Productos values(@CodCategoria,@NombreProd,@Lote,@Presentacion,@UndsContenido,'0')
		select @CodProducto = MAX(CodProducto) from Productos
		EXEC AsignarPVUProducto @CodProducto,@FechaAsignacion, @PrecioVenta
	end

select NombreProd, Lote, Presentacion, UndsContenido, Descripcion, PrecioVenta from Productos
inner join CategoriaProducto on Productos.CodCategoria = CategoriaProducto.CodCategoria
inner join HistorialPVUProductos on HistorialPVUProductos.CodProducto = Productos.CodProducto where Vigente = '1'

create procedure DarBajaProducto
@CodProducto int
as
update Productos set DadoDeBaja = '1' where CodProducto = @CodProducto


create procedure ModificarProducto
@CodProducto int, @CodCategoria int, @NombreProd nvarchar(50),@Lote nvarchar(50), @Presentacion nvarchar(50), @UndsContenido int,@FechaAsignacion datetime,@PrecioVenta float
as
update Productos set CodCategoria = @CodCategoria where CodProducto = @CodProducto
update Productos set NombreProd = @NombreProd where CodProducto = @CodProducto
update Productos set Lote = @Lote where CodProducto = @CodProducto
update Productos set Presentacion = @Presentacion where CodProducto = @CodProducto
update Productos set UndsContenido = @UndsContenido where CodProducto = @CodProducto
update HistorialPVUProductos set FechaAsignacion = @FechaAsignacion where CodProducto = @CodProducto and Vigente = '1'
update HistorialPVUProductos set PrecioVenta = @PrecioVenta where CodProducto = @CodProducto and Vigente = '1'


--COMPRAS AL CONTADO

create procedure AgregarCompraContado
@CodEmpleado int, @CodProveedor int, @NumRecibo bigint, @FechaCompra datetime
as
declare @PorcDesc as float
select @PorcDesc = dbo.ObtenerPorcDesc(@CodProveedor)
insert into ComprasContado values(@CodEmpleado,@CodProveedor,@NumRecibo,@FechaCompra,@PorcDesc,0)


create procedure AgregarDetalleCompraContado
@CodProducto int,@Cantidad as int, @FechaVenc as datetime
as
declare @CodCompraCont as int
declare @CodProveedor as int
declare @CodProdProv as int
declare @CodHistorialCosto as int
declare @CostoUnit as float
select @CodCompraCont = MAX(CodCompraCont) from ComprasContado
select @CodProveedor = CodProveedor from ComprasContado where CodCompraCont = @CodCompraCont
select @CodProdProv = dbo.ObtenerCodProdProv(@CodProducto, @CodProveedor)
select @CodHistorialCosto = dbo.ObtenerCodHistorialCosto(@CodProdProv)
select @CostoUnit = dbo.ObtenerCostoProducto(@CodHistorialCosto)
insert into DetalleCompraContado values(@CodCompraCont,@CodHistorialCosto,@Cantidad)
EXEC AsignarVencimiento @CodProdProv,@FechaVenc,@Cantidad
update ComprasContado set Subtotal = Subtotal +  @Cantidad*@CostoUnit where CodCompraCont = @CodCompraCont


create function ObtenerCostoProducto(@CodHistorialCosto int)
returns float
begin
	declare @CostoUnit as float
	select @CostoUnit = CostoUnit from HistorialCostosProductos where CodHistorialCosto = @CodHistorialCosto
	return @CostoUnit
end


Print dbo.ObtenerCodProdProv(2,1)
create function ObtenerCodProdProv(@CodProducto int, @CodProveedor int)
returns int
begin
	declare @CodProdProv as int
	select @CodProdProv = CodProdProv from ProductoProveedor where CodProducto = @CodProducto and CodProveedor = @CodProveedor
	return @CodProdProv
end


create function ObtenerCodHistorialCosto(@CodProdProv int)
returns int
begin
	declare @CodHistorialCosto as int
	select @CodHistorialCosto = CodHistorialCosto from HistorialCostosProductos where NumProdProv = @CodProdProv and Vigente = '1'
	return @CodHistorialCosto		
end

Print dbo.ObtenerCodHistorialCosto(3)

create function ObtenerPorcDesc(@CodProveedor int)
returns float
as
begin
declare @PorcDesc as float
select @PorcDesc = PorcDesc from Proveedores where CodProveedor = @CodProveedor
return @PorcDesc
end

create function ObtenerCodCategoria(@CodProdProv int)
returns int
begin
	declare @CodCategoria as int
	declare @CodProducto as int
	select @CodProducto =  CodProducto from ProductoProveedor where CodProdProv = @CodProdProv
	select @CodCategoria = CodCategoria from Productos where CodProducto = @CodProducto
	return @CodCategoria
end

create  function IngresoExistenciaDetalle(@CodProdProv int, @Cantidad int)
returns int
begin 
	declare @CodProducto as int
	declare @UndsContenido as int
	declare @Existencias as int
	declare @ExistenciasDetalle as int
	declare @CantidadIngreso as int
	select @CodProducto = CodProducto from ProductoProveedor where CodProdProv = @CodProdProv
	select @UndsContenido = UndsContenido from Productos where CodProducto = @CodProducto
	select @CantidadIngreso = @Cantidad*@UndsContenido
	return @CantidadIngreso
end


select * from Productos
Print dbo.ObtenerPorcDesc(2)

