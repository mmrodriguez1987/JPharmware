
package conectivity;

import interfacegraphic.sales.JDetailSales;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ConnectDetailSales extends ConnectionDB{
    
public static void CargarJCProveedor() {
        JDetailSales.JCProveedor.removeAllItems();
        try {
            ResultQuery = Query.executeQuery("select RazonSocial from Proveedores");
            while (ResultQuery.next()) {
                JDetailSales.JCProveedor.addItem(ResultQuery.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
public static int getCodProveedor(String Proveedor)
    {   
        int CodigoProveedor = 0;  
        try {                       
            ResultQuery = Query.executeQuery("select CodProveedor from Proveedores where RazonSocial = '"+Proveedor+"'");
            while (ResultQuery.next()) {
                CodigoProveedor = Integer.parseInt(ResultQuery.getString("CodProveedor"));
            }
        } catch (SQLException ex) {ex.printStackTrace();}
      return CodigoProveedor;      
    }

public static void CargarTablaDatosProd(int CodProveedor)
{
    try 
        {
            CleanTableDetailProd();
            DefaultTableModel aModel = (DefaultTableModel) JDetailSales.TablaDatosProd.getModel();            
            ResultQuery = Query.executeQuery("select NombreProd, Presentacion,Descripcion, PrecioVenta, Existencias, ExistenciasDetalle, FechaVenc from Productos"
                                            +" inner join CategoriaProducto on Productos.CodCategoria = CategoriaProducto.CodCategoria"
                                            +" inner join ProductoProveedor on Productos.CodProducto = ProductoProveedor.CodProducto"
                                            +" inner join HistorialPVUProductos on Productos.CodProducto =  HistorialPVUProductos.CodProducto"
                                            +" inner join VencimientoProductos on VencimientoProductos.CodProdProv  = ProductoProveedor.CodProdProv"
                                            +" where CodProveedor = "+CodProveedor+" and Vigente = '1' and Vencido = '0' and DadoDeBaja = '0'");            
            MetaDatas = ResultQuery.getMetaData();
            int colNo = MetaDatas.getColumnCount();
            
            while(ResultQuery.next()){
                Object[] objects = new Object[colNo];
              
                for(int i = 0 ;i < colNo; i++){
                    objects[i] = ResultQuery.getString(i+1);                    
                }
                aModel.addRow(objects);
            }
            JDetailSales.TablaDatosProd.setModel(aModel);
            JDetailSales.TablaDatosProd.packAll();
            JDetailSales.TablaDatosProd.packTable(20);
        } 
         catch(SQLException e){} 
}

 public static int getCodProdProv(int CodProducto, int CodProveedor)
    {   
        int CodigoProdProv = 0;  
        try {                       
            ResultQuery = Query.executeQuery("select CodProdProv from ProductoProveedor where CodProducto = "+CodProducto+" and CodProveedor = "+CodProveedor);
            while (ResultQuery.next()) {
                CodigoProdProv = Integer.parseInt(ResultQuery.getString("CodProdProv"));
            }
        } catch (SQLException ex) {ex.printStackTrace();}
      return CodigoProdProv;      
    }

public static void CleanTableDetailProd()
{
   JDetailSales.TablaDatosProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Producto", "Presentación", "Categoría", "Precio de Venta", "Existencias de Lotes", "Existencias al Detalles", "Fecha Vencimiento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
}
}
