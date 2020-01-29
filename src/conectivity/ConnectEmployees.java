package conectivity;

import interfacegraphic.humanresources.FiredDate;
import interfacegraphic.humanresources.JEmployees;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector; 
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import treeConfiguration.treeIcon.IconData;
import utilities.Utils;

public class ConnectEmployees extends ConnectionDB {
    
    private static DefaultTreeModel TreeModel;
    private static DefaultMutableTreeNode root,activo, inactivo;
    private static final ImageIcon ICON_ROOT = new ImageIcon("C:\\JPharmware_2.0\\src\\images\\Home.png");
    private static final ImageIcon ICON_FOLDER = new ImageIcon("C:\\JPharmware_2.0\\src\\images\\Browse1.png");
    private static final ImageIcon ICON_LEAF_NO_ACTIVE = new ImageIcon("C:\\JPharmware_2.0\\src\\images\\user_remove.png");
    private static final ImageIcon ICON_LEAF_ACTIVE = new ImageIcon("C:\\JPharmware_2.0\\src\\images\\user_accept.png");
   
    public static JTree tree;
    public static void CargarJCCargos() {
        JEmployees.JCCargos.removeAllItems();
        try {
            ResultQuery = Query.executeQuery("select Descripcion from Cargos");
            while (ResultQuery.next()) {
                JEmployees.JCCargos.addItem(ResultQuery.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static int getCodCargo(String Descripcion)
    {   
        int CodigoCargo = 0;  
        try {
                       
            ResultQuery = Query.executeQuery("select CodCargo from Cargos where Descripcion = '"+Descripcion+"'");
            while (ResultQuery.next()) {
                CodigoCargo = Integer.parseInt(ResultQuery.getString("CodCargo"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      System.out.println(CodigoCargo);
      return CodigoCargo;
      
    }
    
     public static Object getDescriptionCharge(int CodCargo)
    {   
        Object Descripcion = null;  
        try {
                       
            ResultQuery = Query.executeQuery("select Descripcion from Cargos where CodCargo = "+CodCargo);
            while (ResultQuery.next()) {
                Descripcion = ResultQuery.getString("Descripcion");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      return Descripcion;     
    }
    
    public static int getCodEmpleado(String Nombre)
    {   
        int CodigoEmple = 0;  
        try {                       
            ResultQuery = Query.executeQuery("select CodEmpleado from Empleados where (Nombres+' '+Apellidos )= '"+Nombre+"'");
            while (ResultQuery.next()) {
                CodigoEmple = Integer.parseInt(ResultQuery.getString("CodEmpleado"));
            }
        } catch (SQLException ex) {ex.printStackTrace();}
      return CodigoEmple;      
    }
    
    public static String getStateEmployee(int CodEmpleado)
    {
        String Estado = null;
        try {                       
            ResultQuery = Query.executeQuery("select Estado from Empleados where CodEmpleado = "+CodEmpleado+"");
            while (ResultQuery.next()) {
                Estado = ResultQuery.getString("Estado");
            }
        } catch (SQLException ex) {ex.printStackTrace();}
        
        return Estado;
    }

    public static void SaveDataEmployees(int CodCargo, String FechaIngreso, String Cedula, String Nombres, String Apellidos, String Domicilio, String Telefono, String Sexo, String Foto)
  {       
         try
         {
             
             String sql = "AgregarEmpleados "+CodCargo+",'"+FechaIngreso+"','"+Cedula+"','"+Nombres+"','"+Apellidos+"','"+Domicilio+"','"+Telefono+"','"+Sexo+"','"+Foto+"'";
             Query.executeUpdate(sql);
             CleanEmployeeTable();
             LoadEmployeeData();
             Utils.MyDialog("Un nuevo trabajador ha sido agregado", "Confirmación del Sistema","Confirmacion.png","pullDown.wav");
             System.out.println("Guarde a una Empleado");  
             }
            catch(SQLException e)
            {
               JOptionPane.showMessageDialog( null,e,"Información del Sistema",JOptionPane.ERROR_MESSAGE,null);
            } 
      }
    public static void ModifyDataEmployees(int CodEmpleado,int CodCargo, String FechaIngreso, String Cedula, String Nombres, String Apellidos, String Domicilio, String Telefono, String Sexo, String Foto)
  {       
         try
         {
             String sql = "ModificarDatosEmpleados "+CodEmpleado+","+CodCargo+",'"+FechaIngreso+"','"+Cedula+"','"+Nombres+"','"+Apellidos+"','"+Domicilio+"','"+Telefono+"','"+Sexo+"','"+Foto+"'";
             Query.executeUpdate(sql);
             CleanEmployeeTable();
             LoadEmployeeData();
             JEmployees.TablaEmpleados.packAll();
             JEmployees.TablaEmpleados.packTable(35);
             Utils.MyDialog("Los Datos han sido modificados sastifactoriamente", "Confirmación del Sistema","icontexto-webdev-user-032x032.png","pullDown.wav");
             System.out.println("Guarde a una Empleado");  
             }
            catch(SQLException e)
            {
               JOptionPane.showMessageDialog( null,e,"Información del Sistema",JOptionPane.ERROR_MESSAGE,null);
            } 
      }
    
    public static void FireEmployee(int CodEmpleado, String FechaEgreso)
    {
        try
         {             
             String sql = "DarBajaEmpleado "+CodEmpleado+",'"+FechaEgreso+"'";
             Query.executeUpdate(sql);
             Utils.MyDialog("El empleado ha sido dado de baja del Sistema", "Confirmación del Sistema","despedido.png","removeDevice.wav");
             System.out.println("Despedi a una Empleado");  
         }
         catch(SQLException e){ }         
    }
     public static void LoadEmployeesCombo()
{
      Vector id = new Vector();
      FiredDate.JCEmpleado.removeAllItems();
        try {
            
            ResultQuery=Query.executeQuery("select Nombres, Apellidos from Empleados where Estado = 1");
            
            while(ResultQuery.next()){
            id.add(ResultQuery.getString(1));
            FiredDate.JCEmpleado.addItem(ResultQuery.getString(1)+" "+ResultQuery.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

 }
     
     public static void LoadReport()
     {
      try {  
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\JPharmware_2.0\\src\\Reportes\\ReporteEmpleados.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            
            Map p = new HashMap();
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, p,Conect);
            JasperViewer.viewReport(jasperPrint,false);
            
        } catch (JRException e) {
            e.printStackTrace();
        }
     }
     
     public static TreeModel LoadEmployeesTree()
{
      String Resultado = null;
      
      activo = new DefaultMutableTreeNode( new IconData(ICON_FOLDER, null,"Empleados Activos"));
      inactivo = new DefaultMutableTreeNode( new IconData(ICON_FOLDER, null,"Empleados Despedidos"));
        try {            
            ResultQuery=Query.executeQuery("select (Nombres+' '+Apellidos) as 'Name' from Empleados where Estado = '1'");
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
            ResultQuery=Query.executeQuery("select (Nombres+' '+Apellidos) as 'Name' from Empleados where Estado = '0'");
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
     
     public static void CleanEmployeeTable()
     {
         JEmployees.TablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombres", "Apellidos", "Cédula", "Domicilio", "Teléfono", "Sexo", "Cargo", "Precio Hora", "Estado", "Salario Básico", "Viático", "Fecha de Ingreso", "Fecha Despido", "Costo de no Trab."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
     }

     public static void LoadDataSearch(int CodEmpleado)
{
//    JEmployees.PanelDespido.setVisible(false);
    try {
        ResultSet rs = Query.executeQuery("select Nombres,Apellidos,Cedula,Domicilio,Telefono,Sexo,CodCargo,FechaIngreso from Empleados where CodEmpleado = "+CodEmpleado);                       
        while(rs.next())
        {
        JEmployees.TNombres.setText(rs.getString(1)); System.out.println("INDEX 1 "+rs.getString(1));
        
        JEmployees.TApellidos.setText(rs.getString(2)); System.out.println("INDEX 2 "+rs.getString(2));
        
        JEmployees.JFTCedula.setText(rs.getString(3)); System.out.println("INDEX 3 "+rs.getString(3));
        
        JEmployees.TDireccion.setText(rs.getString(4)); System.out.println("INDEX 4 "+rs.getString(4));
        
        JEmployees.JFTTelefono.setText(rs.getString(5)); System.out.println("INDEX 5 "+rs.getString(5));
        
        LoadJCSexo(rs.getString(6));  System.out.println("INDEX 6 "+rs.getString(6)); 
        
        JEmployees.JCCargos.setSelectedItem(getDescriptionCharge(Integer.parseInt(rs.getString(7))));    
        rs.close();
        }             
    } catch(SQLException e){e.getMessage();}
    
    QueryLoadDate(CodEmpleado); QueryLoadPhoto(CodEmpleado); QueryLoadStateEmployee(CodEmpleado);    
    System.out.println(getStateEmployee(CodEmpleado));
}
 
 public static void QueryLoadStateEmployee(int CodEmpleado)
 {
     String Fecha = null;
     if (getStateEmployee(CodEmpleado).compareTo("0") == 0) {
        try {
            ResultSet rst = Query.executeQuery("select FechaDespido from Empleados where CodEmpleado = "+CodEmpleado);
            while(rst.next()) 
            {Fecha = rst.getString(rst.findColumn("FechaDespido"));}
            } catch (SQLException e) {e.getMessage();
        }
         Fecha = Fecha.substring(8,10)+"-"+ Fecha.substring(5,7)+"-"+Fecha.substring(0,4);
         JEmployees.PanelDespido.setVisible(true);  JEmployees.TFechaEgreso.setText(Fecha);   System.out.println(Fecha);        
      } 
     else {
        JEmployees.PanelDespido.setVisible(false);
    }        
  }
public static void QueryLoadDate(int CodEmpleado)
{
    try {
     ResultSet rst = Query.executeQuery("select FechaIngreso from Empleados where CodEmpleado = "+CodEmpleado);                       
        
        while(rst.next())
        {
          LoadDate(rst.getString(rst.findColumn("FechaIngreso"))); System.out.println("FechaIngreso "+rst.getString(rst.findColumn("FechaIngreso"))); 
        } 
     }catch(SQLException e){e.getMessage();}
}

public static void QueryLoadPhoto(int CodEmpleado)
{
    ImageIcon icon;  String path;
    try {
     ResultSet rs = Query.executeQuery("select Foto from Empleados where CodEmpleado = "+CodEmpleado);                       
        
        while(rs.next())
        {
         path = rs.getString(rs.findColumn("Foto")); System.out.println(path);
         if(path != null)
         {
           JEmployees.LPath.setText(path);        
           JEmployees.LPath.setVisible(true);
           icon = new ImageIcon(path);         
           JEmployees.LFoto.setIcon(icon);
         }
         else
         {
            JEmployees.LPath.setText(" "); icon = null; JEmployees.LFoto.setIcon(icon);
         }
        } 
     }catch(SQLException e){e.getMessage();}
    icon = null; path = null;
}
    public static void LoadEmployeeData()
{
        try 
        {
            DefaultTableModel aModel = (DefaultTableModel) JEmployees.TablaEmpleados.getModel();
            
            ResultQuery = Query.executeQuery("select Nombres, Apellidos, Cedula, Domicilio, Telefono, Sexo, Descripcion, PrecioHora, Estado, SalarioBasico, Viatico, FechaIngreso, FechaDespido, CostoNTD from Empleados inner join Cargos  on Cargos.CodCargo = Empleados.Codcargo");
            
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
            JEmployees.TablaEmpleados.setModel(aModel);  
        } 
         catch(SQLException e){}               
      }
    
    public static void LoadJCSexo(String Sexo)
    {
      
       String Genero [] = {"M","F"};
        if(Sexo.compareTo(Genero[0]) == 0)
        {
            JEmployees.RBMasculino.setSelected(true); JEmployees.RBFemenino.setSelected(false);        
        }
        else
        {
            JEmployees.RBFemenino.setSelected(true); JEmployees.RBMasculino.setSelected(false);
        }
    }
    
    public static String VerifyExistence(String Cedula)
    {   
        String Resultado = null;  
        try {
                       
            ResultQuery = Query.executeQuery("Select Cedula from Empleados where Cedula = '"+Cedula+"'");
            while (ResultQuery.next()) {
                Resultado = String.valueOf(ResultQuery.getString("Cedula"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      return Resultado;
    }
 
    public static void LoadDate(String datesql)
    {
     String year = datesql.substring(0,4);
     String month = datesql.substring(5,7);
     String day = datesql.substring(8,10);
     
     System.out.println(year+" "+month+" "+day);
     JEmployees.CalendarCombo.setSelectedDate(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));
    }
}
