package conectivity;

import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import utilities.Utils;
import utilities.Utils.*;

public class ConnectionDB {
public static Connection Conect;
public static Statement Query;
public static ResultSet ResultQuery;
public static boolean ConectadoBD = false;
public static ResultSetMetaData MetaDatas; 
public static long star, end;
public static Vector vector;
String path;

 public ConnectionDB() { }
 
 public ConnectionDB(String ODBC,String usuer,String password)
 {      
     Conect = null;
     star = System.currentTimeMillis();
         try
         {
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         }       
         catch( Exception ex )
         {}    
         
         try   	
         {
            Conect = DriverManager.getConnection(ODBC,usuer,password );
            Query= Conect.createStatement(ResultQuery.TYPE_SCROLL_SENSITIVE,ResultQuery.CONCUR_READ_ONLY);
            
            Utils.MyDialog("Bienvenido a JPharmware 2.0:\n","Conexión Satisfactoria","UsuarioConectado.png","connected.wav");
            ConectadoBD = true;
          }
         
         catch( Exception e )
         {
             Utils.MyDialog("Conexión fallida, por favor comuníquese \n con el Administrado del Sistema", "Error de Conección","Emoticon.gif","Infected.wav");					                                           
         }  
     end = System.currentTimeMillis() - star;
     Utils.Console("El tiempo total transcurrido en conectar es: "+end);  
   
    }       
 
 public static String getServerName()
 {
   String servername = null;
   try
         {
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         }       
         catch( Exception ex )
         {}    
         
         try   	
         {
            Conect = DriverManager.getConnection("jdbc:odbc:FarmaciaAllisonRevolution","sa","sa" );
            Query= Conect.createStatement(ResultQuery.TYPE_SCROLL_SENSITIVE,ResultQuery.CONCUR_READ_ONLY);                          
            ResultQuery=Query.executeQuery("select @@SERVERNAME");
            
            while(ResultQuery.next()){
                servername = ResultQuery.getString(1);
            } 
         }         
         catch( Exception e )
         {
            Utils.MyDialog(e.getMessage(),"Error de Conexión","Emoticon.gif","Infected.wav");
         }   
   return servername; 
 }
 
    public static ResultSet CreateStatementSQL(String SetenceSQL) {
        try {
            ResultQuery = Query.executeQuery(SetenceSQL);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ResultQuery;
    }
}
