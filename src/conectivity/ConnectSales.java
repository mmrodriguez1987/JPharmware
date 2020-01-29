
package conectivity;

import interfacegraphic.sales.JSales;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilities.Utils;

public class ConnectSales extends ConnectionDB {

    public static void LoadEmployeesCombo() {
        Vector id = new Vector();
        JSales.JCVendedor.removeAllItems();
        try
        {

            ResultQuery = Query.executeQuery("select Nombres, Apellidos from Empleados where Estado = 1 and CodCargo = 3 or CodCargo = 1");

            while (ResultQuery.next()) {
                id.add(ResultQuery.getString(1));
               JSales.JCVendedor.addItem(ResultQuery.getString(1) + " " + ResultQuery.getString(2));
            }
        } 
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }       
    }
    
  public static int getCodVenta()
    {   
        int CodVenta = 0;  
        try {                       
            ResultQuery = Query.executeQuery("select MAX(CodVenta) as 'CodVenta' from Ventas");
            while (ResultQuery.next()) {
                CodVenta = Integer.parseInt(ResultQuery.getString("CodVenta"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      System.out.println(CodVenta);
      CodVenta += 1;      
      return CodVenta;      
    }   
  
  public static void SaveSale(int CodEmpleado, String FechaVenta)
  {
        try {
            String sql = "AgregarVentas " + CodEmpleado + ",'" + FechaVenta + "'";
            Query.executeUpdate(sql);           
            Utils.MyDialog("La Venta fue registrada sastifactoriamente", "Confirmación del Sistema", "Confirmacion.png", "pullDown.wav");
        } catch (SQLException e) { }
    }
  public static void SaveDetailSale(int CodProdProv,int Cantidad)
  {
        try {
            String sql = "AgregarDetalleVenta " + CodProdProv + "," + Cantidad ;
            Query.executeUpdate(sql);
            } catch (SQLException e) { }
    }
  
  public static void LoadDataSale(int CodVenta)
  {
     try {  
            int CodEmpleado = 0;
            String Fecha = null, Subtotal = null;
            
            ResultQuery = Query.executeQuery("select * from Ventas where CodVenta = "+CodVenta);
            while (ResultQuery.next()) {
                CodEmpleado = Integer.parseInt(ResultQuery.getString("CodVenta"));
                Fecha = ResultQuery.getString("FechaVenta");
                Subtotal = ResultQuery.getString("Total");
            }
            Fecha = Fecha.substring(0,10);
            LoadVendedor(CodEmpleado);
            JSales.TFechaVenta.setText(Fecha);
            JSales.LSubTotalText.setText(Subtotal); JSales.LTotalText.setText(Subtotal);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Utils.MyDialog("No existe este Número de Venta", "Información del Sistema - Ventas", "icontexto-webdev-alert-032x032.png", "Infected.wav");
        }
     LoadDetailSale(CodVenta);
  }
  
  
  public static void LoadDetailSale(int CodVenta)
  {
    CleanTableDetailSale();
    try {  
            DefaultTableModel aModel = (DefaultTableModel) JSales.TablaDetalleVenta.getModel();                 
             
            ResultQuery = Query.executeQuery("select NombreProd,Presentacion, Precio,Cantidad from Productos"
                                            +" inner join ProductoProveedor on Productos.CodProducto = ProductoProveedor.CodProducto"
                                            +" inner join DetalleVenta on ProductoProveedor.CodProdProv  = DetalleVenta.CodProdProv"
                                            +" where CodVenta = "+ CodVenta);            
            MetaDatas = ResultQuery.getMetaData();
            int colNo = MetaDatas.getColumnCount(); 
            while (ResultQuery.next()) {
                Object[] objects = new Object[colNo];
                for(int i = 0 ;i < colNo; i++){
                    objects[i] = ResultQuery.getString(i+1);
                    System.out.println(objects[i]);
                }
                 
                 aModel.addRow(objects);
            }
             ResultQuery.close();
             JSales.TablaDetalleVenta.setModel(aModel);          
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Utils.MyDialog("No existe este Número de Venta", "Información del Sistema - Ventas", "icontexto-webdev-alert-032x032.png", "Infected.wav");
        }
  }
  public Object LoadCodProdProvTable(int CodVenta)
  {
      Object[] objects = new Object[1];
    try
    {
//        DefaultTableModel aModel = (DefaultTableModel) JSales.TablaDetalleVenta.getModel();            
        ResultSet rst = Query.executeQuery("select CodProdProv from DetalleVenta where CodVenta = "+CodVenta);
        MetaDatas = ResultQuery.getMetaData();
            int colNo = MetaDatas.getColumnCount();
            
            while (rst.next()) {            
              
                for(int i = 0 ;i < colNo; i++){
                    objects[i]=ResultQuery.getString(i+1);
                }
//                aModel.addRow(objects);
            }           
             rst.close();
    }
    catch (SQLException ex)
    {
       ex.printStackTrace();
    }
    return objects;
  }
  public static void LoadVendedor(int CodEmpleado)
{
      String Nombre = null;
      
        try 
        {            
            ResultQuery=Query.executeQuery("select (Nombres+' '+Apellidos) as 'Name' from Empleados where CodEmpleado = "+CodEmpleado);
            
            while(ResultQuery.next())
            {         
              Nombre = ResultQuery.getString("Name");
            } 
            JSales.JCVendedor.setSelectedItem(Nombre);
        } catch (SQLException ex) {ex.printStackTrace();}   
 }
  
    public static void CleanTableDetailSale() {
        JSales.TablaDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Presentación", "Precio", "Cantidad", "Sub Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }
  
}
