--NOTAS DE CRÉDITO
create procedure AgregarNotaCredito
@CodEmpleado int, @CodProveedor int, @NumRecibo bigint, @FechaCompra datetime, @FechaCancelacion datetime
as
declare @PorcDesc as float
select @PorcDesc = dbo.ObtenerPorcDesc(@CodProveedor)
insert into NotasCredito values(@CodEmpleado,@CodProveedor,@NumRecibo,@FechaCompra,@FechaCancelacion,@PorcDesc,0,'0')


create procedure AgregarDetalleNotaCredito
@CodProducto int,@Cantidad as int, @FechaVenc as datetime
as
declare @CodNotaCred as int
declare @CodProveedor as int
declare @CodProdProv as int
declare @CodHistorialCosto as int
declare @CostoUnit as float
select @CodNotaCred = MAX(CodNotaCred) from NotasCredito
select @CodProveedor = CodProveedor from NotasCredito where CodNotaCred = @CodNotaCred
select @CodProdProv = dbo.ObtenerCodProdProv(@CodProducto, @CodProveedor)
select @CodHistorialCosto = dbo.ObtenerCodHistorialCosto(@CodProdProv)
select @CostoUnit = dbo.ObtenerCostoProducto(@CodHistorialCosto)
insert into DetalleNotaCredito values(@CodNotaCred,@CodHistorialCosto,@Cantidad)
EXEC AsignarVencimiento @CodProdProv,@FechaVenc,@Cantidad
update NotasCredito set Subtotal = Subtotal +  @Cantidad*@CostoUnit where CodNotaCred = @CodNotaCred

--VENTAS

create function ObtenerPrecioProducto(@CodProdProv int)
returns float
begin
	declare @Precio as float
	declare @CodProducto as float
	select @CodProducto = CodProducto from ProductoProveedor where CodProdProv = @CodProdProv
	select @Precio = PrecioVenta from HistorialPVUProductos where CodProducto = @CodProducto and Vigente = '1'
	return @Precio
end


create procedure AsignarVencimientoVentas
@CodVencimiento int, @Cantidad int
as 
	update VencimientoProductos set ExistenciasDetalle = ExistenciasDetalle - @Cantidad where CodVencimiento = @CodVencimiento
	EXEC ActualizarExistVentas @CodVencimiento

create procedure ActualizarExistVentas
@CodVencimiento int
as
declare @ExistenciasDetalle as int
declare @UndsContenido as int
declare @CodProdProv as int
declare @CodProducto as int
declare @Existencias as int 
select @ExistenciasDetalle = ExistenciasDetalle from VencimientoProductos where CodVencimiento = @CodVencimiento
select @CodProdProv = CodProdProv from VencimientoProductos where CodVencimiento = @CodVencimiento
select @CodProducto = CodProducto from 	ProductoProveedor where CodProdProv = @CodProdProv
select @UndsContenido = UndsContenido from Productos where CodProducto = @CodProducto
select @Existencias = @ExistenciasDetalle/@UndsContenido
update VencimientoProductos set Existencias = @Existencias where CodVencimiento = @CodVencimiento


create procedure AgregarVentas
@CodEmpleado int, @Fecha datetime
as
insert into Ventas values(@CodEmpleado,@Fecha,0)


create procedure AgregarDetalleVenta
@CodProdProv int, @Cantidad int
as
declare @Precio as float
declare @CodVencimiento as int
declare @CodVenta as int
declare @CodCategoria as int
select @Precio = dbo.ObtenerPrecioProducto(@CodProdProv)
select @CodVenta = MAX(CodVenta) from Ventas
select @CodCategoria = dbo.ObtenerCodCategoria(@CodProdProv)
if (@CodCategoria <> 1)
	begin
		select @CodVencimiento = dbo.ObtenerCodVencimiento(@CodProdProv)		
	end
else
	begin   
		select @CodVencimiento = dbo.ObtenerCodVencProdMisc(@CodProdProv)	
	end
insert into DetalleVenta values(@CodVenta,@CodProdProv,@Cantidad,@Precio)
update Ventas set Total = Total + @Precio*@Cantidad where CodVenta = @CodVenta
EXEC AsignarVencimientoVentas @CodVencimiento, @Cantidad


create function ObtenerCodVencimiento(@CodProdProv int)
returns int
begin
	declare @CodVencimiento as int
	declare @FechaMinima as datetime
	select @FechaMinima = MIN(FechaVenc) from VencimientoProductos where CodProdProv = @CodProdProv and Vencido = '0'
	select @CodVencimiento = CodVencimiento from VencimientoProductos where CodProdProv = @CodProdProv and FechaVenc = @FechaMinima
	return @CodVencimiento
end


create function ObtenerCodVencProdMisc(@CodProdProv int)
returns int
begin
	declare @CodVencimiento as int
	select @CodVencimiento = CodVencimiento from VencimientoProductos where CodProdProv = @CodProdProv
	return @CodVencimiento
end


Print dbo.ObtenerCodVencimiento(4)

select MIN(FechaVenc) from VencimientoProductos where CodProdProv = 1
select * from VencimientoProductos

