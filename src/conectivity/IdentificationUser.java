
package conectivity;
import interfacegraphic.FrameEmperador;
import javax.swing.ImageIcon;
import utilities.Utils;
import utilities.Utils.*;
import javax.swing.UIManager;
import com.l2fprod.common.swing.plaf.LookAndFeelAddons;
import com.l2fprod.common.swing.plaf.windows.WindowsLookAndFeelAddons;
import interfacegraphic.PanelEmperador;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import net.java.balloontip.BalloonTip;

public class IdentificationUser extends javax.swing.JFrame {
public static String login = null, password = null, server = null;
BalloonTip balloonTip; 

    public IdentificationUser() {
        initComponents();
        ImageIcon Icon = new ImageIcon(getClass().getResource("/images/connect.png"));
        setIconImage(Icon.getImage());
        setUndecorated(true);
        tx_server.setText(ConnectionDB.getServerName());
        balloonTip = new BalloonTip(tx_login, new Color(255, 255, 225), 5,5);
        balloonTip.setIcon(new ImageIcon(getClass().getResource("/images/Antivirus.png")));        
        balloonTip.setText("Digite caracteres válidos");
        balloonTip.setVisible(true);
        PanelCenter.add(balloonTip);
       
    }   
   public void setLogin(String l)
   {
     this.login = l;
   }
   
   public void setPassword(String p)
   {
    this.password = p;
   }
   
   public void setServer(String s)
   {
    this.server = s;
   }
   
   public String getLogin()
   {
    return login;
   }
   
   public String getPassword()
   {
   return password;
   }
   
   public String getServer()
   {
    return server;
   }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMain = new javax.swing.JPanel();
        TabbedPane = new javax.swing.JTabbedPane();
        Tab1 = new javax.swing.JPanel();
        PanelNorth = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PanelCenter = new javax.swing.JPanel();
        lb_login = new javax.swing.JLabel();
        lb_pass = new javax.swing.JLabel();
        lb_server = new javax.swing.JLabel();
        tx_server = new javax.swing.JTextField();
        LPC = new javax.swing.JLabel();
        tx_pass = new javax.swing.JPasswordField();
        tx_login = new javax.swing.JTextField();
        PanelSouth = new javax.swing.JPanel();
        bt_connect = new javax.swing.JButton();
        bt_cancel = new javax.swing.JButton();
        LFondo = new javax.swing.JLabel();
        LbFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Farmacia Allison - JPharmware 2.0");
        setBackground(new java.awt.Color(204, 204, 255));
        setResizable(false);

        PanelMain.setLayout(null);

        TabbedPane.setBackground(new java.awt.Color(255, 255, 255));
        TabbedPane.setForeground(new java.awt.Color(0, 0, 153));
        TabbedPane.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        TabbedPane.setFont(new java.awt.Font("Papyrus", 1, 12));

        Tab1.setFont(new java.awt.Font("Sony Sketch EF", 1, 12));
        Tab1.setLayout(null);

        PanelNorth.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelNorth.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Papyrus", 1, 12));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Vista_icons_08.png"))); // NOI18N
        jLabel1.setText("Información de Ingresos de Usuarios");
        PanelNorth.add(jLabel1);

        Tab1.add(PanelNorth);
        PanelNorth.setBounds(30, 10, 410, 46);

        PanelCenter.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelCenter.setForeground(new java.awt.Color(255, 255, 255));
        PanelCenter.setOpaque(false);
        PanelCenter.setLayout(null);

        lb_login.setFont(new java.awt.Font("Papyrus", 1, 12));
        lb_login.setForeground(new java.awt.Color(255, 255, 255));
        lb_login.setText("Login");
        PanelCenter.add(lb_login);
        lb_login.setBounds(40, 20, 70, 25);

        lb_pass.setFont(new java.awt.Font("Papyrus", 1, 12));
        lb_pass.setForeground(new java.awt.Color(255, 255, 255));
        lb_pass.setText("Password");
        PanelCenter.add(lb_pass);
        lb_pass.setBounds(40, 60, 70, 25);

        lb_server.setFont(new java.awt.Font("Papyrus", 1, 12));
        lb_server.setForeground(new java.awt.Color(255, 255, 255));
        lb_server.setText("Servidor");
        PanelCenter.add(lb_server);
        lb_server.setBounds(40, 100, 70, 25);

        tx_server.setEditable(false);
        tx_server.setFont(new java.awt.Font("Råttpick", 1, 10));
        tx_server.setForeground(new java.awt.Color(0, 0, 153));
        tx_server.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_server.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tx_serverActionPerformed(evt);
            }
        });
        PanelCenter.add(tx_server);
        tx_server.setBounds(130, 100, 260, 25);

        LPC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LPC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Satellite Internet.png"))); // NOI18N
        PanelCenter.add(LPC);
        LPC.setBounds(310, 20, 90, 70);

        tx_pass.setFont(new java.awt.Font("Verdana", 1, 12));
        tx_pass.setForeground(new java.awt.Color(0, 0, 153));
        tx_pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PanelCenter.add(tx_pass);
        tx_pass.setBounds(130, 60, 170, 25);

        tx_login.setFont(new java.awt.Font("Verdana", 1, 12));
        tx_login.setForeground(new java.awt.Color(0, 0, 153));
        tx_login.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tx_loginMouseExited(evt);
            }
        });
        PanelCenter.add(tx_login);
        tx_login.setBounds(130, 20, 170, 25);

        Tab1.add(PanelCenter);
        PanelCenter.setBounds(30, 60, 410, 140);

        PanelSouth.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelSouth.setOpaque(false);
        PanelSouth.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        bt_connect.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));
        bt_connect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/_active__yes.png"))); // NOI18N
        bt_connect.setText("Conectar");
        bt_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_connectActionPerformed(evt);
            }
        });
        PanelSouth.add(bt_connect);

        bt_cancel.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));
        bt_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/_disabled__cancel.png"))); // NOI18N
        bt_cancel.setText("Cancelar");
        bt_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelActionPerformed(evt);
            }
        });
        PanelSouth.add(bt_cancel);

        Tab1.add(PanelSouth);
        PanelSouth.setBounds(30, 210, 410, 50);

        LFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wallpapers/FondoIdentificacionUsuario.jpg"))); // NOI18N
        Tab1.add(LFondo);
        LFondo.setBounds(0, 0, 480, 270);

        TabbedPane.addTab("General", new javax.swing.ImageIcon(getClass().getResource("/images/PeopleConnection.png")), Tab1); // NOI18N

        PanelMain.add(TabbedPane);
        TabbedPane.setBounds(10, 10, 480, 310);

        LbFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wallpapers/shell_bar.png"))); // NOI18N
        PanelMain.add(LbFondo);
        LbFondo.setBounds(0, 0, 510, 330);

        getContentPane().add(PanelMain, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-511)/2, (screenSize.height-355)/2, 511, 355);
    }// </editor-fold>//GEN-END:initComponents

    private void tx_serverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tx_serverActionPerformed
     
    }//GEN-LAST:event_tx_serverActionPerformed

    private void bt_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_connectActionPerformed
    
    String loginnull = tx_login.getText(), passwordnull = tx_pass.getText();
   
    if ( loginnull.isEmpty()== true || passwordnull.isEmpty() == true)
    {                                     
       Utils.MyDialog("Por favor, complete todos los datos", "Información del Sistema","Emoticon.gif","Infected.wav");					                                       
    }
   else {
      ConnectionDB connect = new ConnectionDB("jdbc:odbc:FarmaciaAllisonRevolution",tx_login.getText(),tx_pass.getText());
      if (connect.ConectadoBD ==true) {
         this.dispose();      
         FrameEmperador frameEmperador = new FrameEmperador();
         frameEmperador.setVisible(true);
         PanelEmperador.LUser.setText("Usuario: "+ tx_login.getText());
      } 
   }
    }//GEN-LAST:event_bt_connectActionPerformed

    private void bt_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bt_cancelActionPerformed

    private void tx_loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tx_loginMouseExited
      
    }//GEN-LAST:event_tx_loginMouseExited
    
   
    public static void main(String args[]) {
     try{//com.jtattoo.plaf.acryl.AcrylLookAndFeel com.jtattoo.plaf.luna.LunaLookAndFeel com.jtattoo.plaf.smart.SmartLookAndFeel // homestead luna metallic
        Class.forName("com.jtattoo.plaf.luna.LunaLookAndFeel");   
      	UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
        LookAndFeelAddons.setAddon(LookAndFeelAddons.getBestMatchAddonClassName()); 
        UIManager.put("win.xpstyle.name", "luna");
        LookAndFeelAddons.setAddon(WindowsLookAndFeelAddons.class);  
             
      	}
       catch(Exception e)
        {
          e.printStackTrace();
        }
        
        
        SplashJNeuroSoft splash = new SplashJNeuroSoft();
        splash.showSplash(17000);
        splash.setVisible(true);
        
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IdentificationUser().setVisible(true);
            }
        });
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LFondo;
    private javax.swing.JLabel LPC;
    private javax.swing.JLabel LbFondo;
    private javax.swing.JPanel PanelCenter;
    private javax.swing.JPanel PanelMain;
    private javax.swing.JPanel PanelNorth;
    private javax.swing.JPanel PanelSouth;
    private javax.swing.JPanel Tab1;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JButton bt_cancel;
    private javax.swing.JButton bt_connect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb_login;
    private javax.swing.JLabel lb_pass;
    private javax.swing.JLabel lb_server;
    private javax.swing.JTextField tx_login;
    private javax.swing.JPasswordField tx_pass;
    private javax.swing.JTextField tx_server;
    // End of variables declaration//GEN-END:variables
    
}
