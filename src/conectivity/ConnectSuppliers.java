/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conectivity;

import interfacegraphic.humanresources.JEmployees;
import interfacegraphicsuppliers.JSuppliers;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class ConnectSuppliers extends ConnectionDB{
    private static TreeModel TreeModel;
    private static DefaultMutableTreeNode root;
    private static DefaultMutableTreeNode proveedores;
    private static final ImageIcon ICON_ROOT = new ImageIcon("C:\\JPharmware_2.0\\src\\images\\Home.png");
    private static final ImageIcon ICON_FOLDER = new ImageIcon("C:\\JPharmware_2.0\\src\\images\\Browse1.png");
    private static final ImageIcon ICON_LEAF_ACTIVE = new ImageIcon("C:\\JPharmware_2.0\\src\\images\\Folder-User.png");
    
    
    public static void LoadSupplierData()
{
        try 
        {
            DefaultTableModel aModel = (DefaultTableModel) JSuppliers.TablaProveedores.getModel();
            
            ResultQuery = Query.executeQuery("select RazonSocial, NumRuc, Direccion, TelEmpresa, Contacto, PorcDesc from Proveedores");
            
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
            JSuppliers.TablaProveedores.setModel(aModel);  
        } 
         catch(SQLException e){}               
      }
    
   
    public static void LoadSupplierDataSearch(int CodProveedor)
{
    try {
        ResultSet rs = Query.executeQuery("select RazonSocial, NumRuc, Direccion, TelEmpresa, Contacto, PorcDesc from Proveedores where CodProveedor = "+CodProveedor);                       
        while(rs.next())
        {
        JSuppliers.TNombreProveedor.setText(rs.getString(1)); System.out.println("INDEX 1 "+rs.getString(1));
        
        JSuppliers.TNumRuc.setText(rs.getString(2)); System.out.println("INDEX 2 "+rs.getString(2));
        
        JSuppliers.TDireccion.setText(rs.getString(3)); System.out.println("INDEX 3 "+rs.getString(3));
        
        JSuppliers.JFTTelefono.setText(rs.getString(4)); System.out.println("INDEX 4 "+rs.getString(4));
        
        JSuppliers.TContacto.setText(rs.getString(5)); System.out.println("INDEX 5 "+rs.getString(5));
        
        JSuppliers.JFTPorcDesc.setText(rs.getString(6)); System.out.println("INDEX 6 "+rs.getString(6));
        
        }             
    } catch(SQLException e){e.getMessage();}
    
}
    
    public static TreeModel LoadSuppliersTree()
{
      String Resultado = null;
      
      proveedores = new DefaultMutableTreeNode( new IconData(ICON_FOLDER, null,"Proveedores"));
        try {            
            ResultQuery=Query.executeQuery("select RazonSocial from Proveedores");
            MetaDatas = ResultQuery.getMetaData();
            int colNo = MetaDatas.getColumnCount();
            String Datos[] =  new String[colNo];
            
            while(ResultQuery.next()){
            Object[] objects = new Object[colNo];             
                for(int i = 0 ;i < colNo; i++){
                    objects[i]=ResultQuery.getString(i+1);
                    Datos[i] = String.valueOf(objects[i]);
                    proveedores.add(new DefaultMutableTreeNode( new IconData(ICON_LEAF_ACTIVE, null,Datos[i])));               
                    
                }              
            } 
            
        } catch (SQLException ex) {ex.printStackTrace();}
      
      root = new DefaultMutableTreeNode( new IconData(ICON_ROOT, null,"Farmacia 'Allison'")); 
      root.add(proveedores);
      
      TreeModel = new DefaultTreeModel(root);
  
      return TreeModel;
 }
    
    public static void SaveDataSupplier(String RazonSocial, String NumRuc, String Direccion, String TelEmpresa, String Contacto, float PorcDesc)
  {       
         try
         {
             
             String sql = "AgregarProveedor "+RazonSocial+",'"+NumRuc+"','"+Direccion+"','"+TelEmpresa+"','"+Contacto+"','"+PorcDesc+"'";
             Query.executeUpdate(sql);
             CleanSupplierTable();
             LoadSupplierData();
             Utils.MyDialog("El Provedor ha sido agregado", "Confirmación del Sistema","Confirmacion.png","pullDown.wav");
             System.out.println("Guarde a una Empleado");  
             }
            catch(SQLException e)
            {
               JOptionPane.showMessageDialog( null,e,"Información del Sistema",JOptionPane.ERROR_MESSAGE,null);
            } 
      }
    
    public static void ModifyDataSuppliers(int CodProveedor,String RazonSocial, String NumRuc, String Direccion, String TelEmpresa, String Contacto, float PorcDesc)
  {       
         try
         { 
             String sql = "ModificarProveedor "+CodProveedor+",'"+RazonSocial+"','"+NumRuc+"','"+Direccion+"','"+TelEmpresa+"','"+Contacto+"',"+PorcDesc;
             Query.executeUpdate(sql);
             CleanSupplierTable();
             LoadSupplierData();
             JSuppliers.TablaProveedores.packAll();
             JSuppliers.TablaProveedores.packTable(40);
             Utils.MyDialog("Los Datos han sido modificados sastifactoriamente", "Confirmación del Sistema","icontexto-webdev-user-032x032.png","pullDown.wav");
             System.out.println("Guarde a una Empleado");  
             }
            catch(SQLException e)
            {
               JOptionPane.showMessageDialog( null,e,"Información del Sistema",JOptionPane.ERROR_MESSAGE,null);
            } 
      }
    
    public static void CleanSupplierTable()
     {
         JSuppliers.TablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Razón Social", "Num Ruc", "Dirección", "Teléfono Empresa", "Contacto proveedor", "Porcentaje Descuento"
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
    
    public static String VerifyExistence(String NumRuc)
    {   
        String Resultado = null;  
        try {
                       
            ResultQuery = Query.executeQuery("Select NumRuc from Proveedores where NumRuc = '"+NumRuc+"'");
            while (ResultQuery.next()) {
                Resultado = String.valueOf(ResultQuery.getString("NumRuc"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      return Resultado;
    }
    
    public static int getCodSuppliers(String Proveedor)
    {   
        int CodProv = 0;  
        try {                       
            ResultQuery = Query.executeQuery("select CodProveedor from Proveedores where RazonSocial = '"+Proveedor+"'");
            while (ResultQuery.next()) {
                CodProv = Integer.parseInt(ResultQuery.getString("CodProveedor"));
            }
        } catch (SQLException ex) {ex.printStackTrace();}
      return CodProv;
      
    }

}
