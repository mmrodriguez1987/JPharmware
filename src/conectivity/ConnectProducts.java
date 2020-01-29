/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conectivity;

import interfacegraphic.products.DeleteProduct;
import interfacegraphic.products.JProducts;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import treeConfiguration.treeIcon.IconData;
import utilities.Utils;

/**
 *
 * @author Elvin Gregorio
 */
public class ConnectProducts extends ConnectionDB{
    private static DefaultTreeModel TreeModel;
    private static DefaultMutableTreeNode root,activo, inactivo;
    private static final ImageIcon ICON_ROOT = new ImageIcon("C:\\JPharmware_2.0\\src\\images\\Home.png");
    private static final ImageIcon ICON_FOLDER = new ImageIcon("C:\\JPharmware_2.0\\src\\images\\Browse1.png");
    private static final ImageIcon ICON_LEAF_NO_ACTIVE = new ImageIcon("C:\\JPharmware_2.0\\src\\images\\shopping_cart_remove.png");
    private static final ImageIcon ICON_LEAF_ACTIVE = new ImageIcon("C:\\JPharmware_2.0\\src\\images\\shopping_cart_accept.png");
   
    
    public static void CargarComboCategoria() {
        JProducts.Combocategoria.removeAllItems();
        try {
            ResultQuery = Query.executeQuery("select Descripcion from CategoriaProducto");
            while (ResultQuery.next()) {
                JProducts.Combocategoria.addItem(ResultQuery.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void SaveDataProducts(int CodCategoria, String NombreProducto, String Lote, String Presentacion, int UndsContenido, float PrecioVenta)
  {       
         try
         {
             String sql = "AgregarProducto "+CodCategoria+",'"+NombreProducto+"','"+Lote+"','"+Presentacion+"',"+UndsContenido+","+PrecioVenta;
             Query.executeUpdate(sql);
             CleanProductTable();
             LoadProductData();
             JProducts.TablaProductos.packAll();
             Utils.MyDialog("Se ha agregado un nuevo producto al sistema", "Confirmación del Sistema","Confirmacion.png","pullDown.wav");
             System.out.println("Guarde a una Producto");  
             }
            catch(SQLException e)
            {
               JOptionPane.showMessageDialog( null,e,"Información del Sistema",JOptionPane.ERROR_MESSAGE,null);
            } 
      }
    
    public static TreeModel LoadProductsTree()
{
      String Resultado = null;
      
      activo = new DefaultMutableTreeNode( new IconData(ICON_FOLDER, null,"Productos Existentes"));
      inactivo = new DefaultMutableTreeNode( new IconData(ICON_FOLDER, null,"Productos No Existentes"));
        try {            
            ResultQuery=Query.executeQuery("select (NombreProd+':'+Presentacion) as 'Name' from Productos where DadoDeBaja = '0'");
            MetaDatas = ResultQuery.getMetaData();
            int colNo = MetaDatas.getColumnCount();
            String Datos[] =  new String[colNo];
            
            while(ResultQuery.next()){
            Object[] objects = new Object[colNo];             
                for(int i = 0 ;i < colNo; i++){
                    objects[i]=ResultQuery.getString(i+1);
                    Datos[i] = String.valueOf(objects[i]);
                    activo.add(new DefaultMutableTreeNode( new IconData(ICON_LEAF_ACTIVE, null,Datos[i])));               
                    
                }              
            } 
            
        } catch (SQLException ex) {ex.printStackTrace();}
      
      try {            
            ResultQuery=Query.executeQuery("select (NombreProd+':'+Presentacion) as 'Name' from Productos where DadoDeBaja = '1'");
            MetaDatas = ResultQuery.getMetaData();
            int colNo = MetaDatas.getColumnCount();
            String Datos[] =  new String[colNo];
            
            while(ResultQuery.next()){
            Object[] objects = new Object[colNo];             
                for(int i = 0 ;i < colNo; i++){
                    objects[i]=ResultQuery.getString(i+1);
                    Datos[i] = String.valueOf(objects[i]);
                    inactivo.add(new DefaultMutableTreeNode( new IconData(ICON_LEAF_NO_ACTIVE, null,Datos[i])));                               
                    
                }              
            } 
            
        } catch (SQLException ex) {ex.printStackTrace();}
      
      root = new DefaultMutableTreeNode( new IconData(ICON_ROOT, null,"Farmacia 'Allison'")); 
      root.add(activo); root.add(inactivo);
      
      TreeModel = new DefaultTreeModel(root);
  
      return TreeModel;
 }
    
    public static void LoadDataSearch(String Nombre, String Presentacion)
{
    try {
        ResultSet rs = Query.executeQuery("select NombreProd, Lote, Presentacion, UndsContenido, PrecioVenta, Descripcion from Productos" +
                " inner join CategoriaProducto on Productos.CodCategoria = CategoriaProducto.CodCategoria " +
                "inner join HistorialPVUProductos on HistorialPVUProductos.CodProducto = Productos.CodProducto where NombreProd = '"+Nombre+"' and Presentacion = '"+Presentacion+"'");                       
        while(rs.next())
        {
        JProducts.TNombreProducto.setText(rs.getString(1)); System.out.println("INDEX 1 "+rs.getString(1));
        
        JProducts.TLote.setText(rs.getString(2)); System.out.println("INDEX 2 "+rs.getString(2));
        
        JProducts.TPresentacion.setText(rs.getString(3)); System.out.println("INDEX 3 "+rs.getString(3));
        
        JProducts.TUnds.setText(rs.getString(4)); System.out.println("INDEX 4 "+rs.getString(4));
         
        JProducts.TPrecioVta.setText(rs.getString(5)); System.out.println("INDEX 5 "+rs.getString(5));
        
           rs.close();
        }             
    } catch(SQLException e){e.getMessage();}
    
    LoadCategorySearch(Nombre, Presentacion);
}
    
    public static void LoadCategorySearch(String Nombre, String Presentacion)
    {
        
   int CodigoCategoria = 0;  String Descripcion = null;   
        try {
                         
            ResultSet rst = Query.executeQuery("select CodCategoria from Productos where NombreProd = '"+Nombre+"' and Presentacion = '"+Presentacion+"'");
            while (rst.next()) {
                CodigoCategoria = Integer.parseInt(rst.getString("CodCategoria"));
            }
           } catch (SQLException ex) {
            ex.printStackTrace();}
            
       JProducts.Combocategoria.setSelectedItem(getDescriptionCategory(CodigoCategoria));    
    }
    public static int getCodCategory(String Descripcion)
    {   
        int CodigoCategoria = 0;  
        try {
                       
            ResultQuery = Query.executeQuery("select CodCategoria from CategoriaProducto where Descripcion = '"+Descripcion+"'");
            while (ResultQuery.next()) {
                CodigoCategoria = Integer.parseInt(ResultQuery.getString("CodCategoria"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      System.out.println(CodigoCategoria);
      return CodigoCategoria;
      
    }
    
//    public static void QueryLoadCategory(int CodCate)
//{
//    try {
//     ResultSet rst = Query.executeQuery("select CodCategoria from Productos where CodCategoria = "+CodCate);                       
//        
//        while(rst.next())
//        {
//          JProducts.Combocategoria.setSelectedItem(Integer.parseInt(rst.getString(1)));
//          System.out.println("INDEX 1 "+rst.getString(1));
//        } 
//     }catch(SQLException e){e.getMessage();}
//}
//    
    public static Object getDescriptionCategory(int CodCate)
    {   
        Object Descripcion = null;  
        try {
                       
            ResultQuery = Query.executeQuery("select Descripcion from CategoriaProducto where CodCategoria = "+CodCate);
            while (ResultQuery.next()) {
                Descripcion = ResultQuery.getString("Descripcion");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      return Descripcion;     
    }
    
    public static void ModifyDataProducts(int CodProducto,int CodCategoria, String NombreProducto, String Lote, String Presentacion, int UndsContenido, String FechaAsig, float PrecioVta)
  {       
         try
         {
             String sql = "ModificarProducto "+CodProducto+","+CodCategoria+",'"+NombreProducto+"','"+Lote+"','"+Presentacion+"',"+UndsContenido+",'"+FechaAsig+"','"+PrecioVta+"'";
             Query.executeUpdate(sql);
             CleanProductTable();
             LoadProductData();
             JProducts.TablaProductos.packAll();
             Utils.MyDialog("Los Datos han sido modificados sastifactoriamente", "Confirmación del Sistema","icontexto-webdev-user-032x032.png","pullDown.wav");
             System.out.println("Guarde a un Producto");  
             }
            catch(SQLException e)
            {
               JOptionPane.showMessageDialog( null,e,"Información del Sistema",JOptionPane.ERROR_MESSAGE,null);
            } 
      }
    
    public static String VerifyExistence(String Nombre,String Presentacion)
    {   
        String Resultado = null;  
        try {          
            ResultQuery = Query.executeQuery("Select NombreProd, Presentacion from Productos where NombreProd = '"+Nombre+"'and Presentacion = '"+Presentacion+"'");
            while (ResultQuery.next()) {
                Resultado = String.valueOf(ResultQuery.getString("NombreProd"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      return Resultado;
    }
    
    public static void CleanProductTable()
     {
         JProducts.TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Producto", "Presentación Lote", "Detalle Producto", "Unidades por Lote", "Categoría", "Precio de Venta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
     }
    
     public static void DeleteProduct(int CodProducto)
    {
        try
         {             
             String sql = "DarBajaProducto "+CodProducto;
             Query.executeUpdate(sql);
             Utils.MyDialog("El producto ha sido dado de baja del Sistema", "Confirmación del Sistema","despedido.png","removeDevice.wav");
             System.out.println("Quite un producto");  
         }
         catch(SQLException e){ }         
    }
    
    public static void LoadProductsCombo()
{
      Vector id = new Vector();
      DeleteProduct.Comboproducto.removeAllItems();
        try {
            
            ResultQuery=Query.executeQuery("select NombreProd, Presentacion from Productos where DadoDeBaja = 0");
            
            while(ResultQuery.next()){
            id.add(ResultQuery.getString(1));
            DeleteProduct.Comboproducto.addItem(ResultQuery.getString(1)+" "+ResultQuery.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

 }
    
    public static int getCodProducto(String Nombre, String Presentacion)
    {   
        int CodigoProd = 0;  
        try {                       
            ResultQuery = Query.executeQuery("select CodProducto from Productos where NombreProd = '"+Nombre+"' and Presentacion = '"+Presentacion+"'");
            while (ResultQuery.next()) {
                CodigoProd = Integer.parseInt(ResultQuery.getString("CodProducto"));
            }
        } catch (SQLException ex) {ex.printStackTrace();}
      return CodigoProd;
      
    }
    
    public static void LoadProductData()
{
        try 
        {
            DefaultTableModel aModel = (DefaultTableModel) JProducts.TablaProductos.getModel();
            
            ResultQuery = Query.executeQuery("select NombreProd, Lote, Presentacion, UndsContenido, Descripcion, PrecioVenta from Productos inner join CategoriaProducto on Productos.CodCategoria = CategoriaProducto.CodCategoria inner join HistorialPVUProductos on HistorialPVUProductos.CodProducto = Productos.CodProducto where Vigente = '1'");
            
            MetaDatas = ResultQuery.getMetaData();
            int colNo = MetaDatas.getColumnCount();
            
            System.out.println("  "+colNo);
            
            while(ResultQuery.next()){
                Object[] objects = new Object[colNo];
              
                for(int i = 0 ;i < colNo; i++){
                    objects[i]=ResultQuery.getString(i+1);
                }
                aModel.addRow(objects);
            }
            JProducts.TablaProductos.setModel(aModel);  
        } 
         catch(SQLException e){}               
      }

}
