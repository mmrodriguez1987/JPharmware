
package interfacegraphic;
import com.jpackages.jflashplayer.FlashPanel;
import com.jpackages.jflashplayer.FlashPanelListener;
import com.jpackages.jflashplayer.JFlashLibraryLoadFailedException;
import info.clearthought.layout.TableLayout;
import interfacegraphic.products.JProducts;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.noos.xing.mydoggy.Content;
import org.noos.xing.mydoggy.ContentManager;
import org.noos.xing.mydoggy.ContentManagerUIListener;
import org.noos.xing.mydoggy.DockedTypeDescriptor;
import org.noos.xing.mydoggy.FloatingTypeDescriptor;
import org.noos.xing.mydoggy.SlidingTypeDescriptor;
import org.noos.xing.mydoggy.TabbedContentManagerUI;
import org.noos.xing.mydoggy.TabbedContentUI;
import org.noos.xing.mydoggy.ToolWindow;
import org.noos.xing.mydoggy.ToolWindowActionHandler;
import org.noos.xing.mydoggy.ToolWindowAnchor;
import org.noos.xing.mydoggy.ToolWindowManager;
import org.noos.xing.mydoggy.ToolWindowType;
import org.noos.xing.mydoggy.event.ContentManagerUIEvent;
import org.noos.xing.mydoggy.plaf.MyDoggyToolWindowManager;
import utilities.Utils;

public class FrameEmperador extends javax.swing.JFrame implements FlashPanelListener{
public static ToolWindowManager toolWindowManager;
     
    public FrameEmperador() {
        initComponents();
        ImageIcon Icon = new ImageIcon(getClass().getResource("/images/JNeuroSoft.png"));
        setIconImage(Icon.getImage());
        setUndecorated(true);        
        setLayout(new TableLayout(new double[][]{{0, -1, 0}, {0, -1, 0}}));

        Image imageAlternative = getImageOfString("No Flash", Color.black);
        FlashPanel flashPanel = new FlashPanel(new File("C:\\JPharmware_2.0\\src\\images\\flash\\clock77.swf"), imageAlternative, true);
        
        
        MyDoggyToolWindowManager myDoggyToolWindowManager = new MyDoggyToolWindowManager(this);
        toolWindowManager = myDoggyToolWindowManager;
        
        toolWindowManager.registerToolWindow("Hora del Sistema","Reloj",new javax.swing.ImageIcon(getClass().getResource("/images/Ventas.png")),flashPanel,ToolWindowAnchor.RIGHT);                      
       
        
        for(ToolWindow window : toolWindowManager.getToolWindows())
        window.setAvailable(true);          
      
        this.getContentPane().add(myDoggyToolWindowManager, "1, 1");
        
        initContentManager();
        
        setExtendedState(FrameEmperador.MAXIMIZED_BOTH);
        
    }

   protected void initContentManager() {
        PanelEmperador panelEmperador = new PanelEmperador();
        ContentManager contentManager = toolWindowManager.getContentManager();
        Content content = contentManager.addContent("Súper Tree", "Módulos del Sistema", new javax.swing.ImageIcon(getClass().getResource("/images/task/Usuario.png")), panelEmperador);       
        content.setToolTipText("JPharmware 2.0");       
        setupContentManagerUI();
    }  
    
   protected void setupContentManagerUI() {
        TabbedContentManagerUI tabbedContentManagerUI = (TabbedContentManagerUI) toolWindowManager.getContentManager().getContentManagerUI();
        tabbedContentManagerUI.setShowAlwaysTab(true);
        tabbedContentManagerUI.setTabPlacement(TabbedContentManagerUI.TabPlacement.TOP);
        tabbedContentManagerUI.addContentManagerUIListener(new ContentManagerUIListener() {
           public boolean contentUIRemoving(ContentManagerUIEvent event) {
               return javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure?") == javax.swing.JOptionPane.OK_OPTION;
           }
           
           public void contentUIDetached(ContentManagerUIEvent event) {
           }
        });
        
        TabbedContentUI tabbedContentUI = tabbedContentManagerUI.getContentUI(toolWindowManager.getContentManager().getContent(0));
        
        tabbedContentUI.setCloseable(false);
        tabbedContentUI.setDetachable(false);
        tabbedContentUI.setTransparentMode(true);
        tabbedContentUI.setTransparentRatio(0.7f);
        tabbedContentUI.setTransparentDelay(1000);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXTaskPaneContainer1 = new org.jdesktop.swingx.JXTaskPaneContainer();
        jXTaskPane1 = new org.jdesktop.swingx.JXTaskPane();
        jXHyperlink1 = new org.jdesktop.swingx.JXHyperlink();
        jXHyperlink2 = new org.jdesktop.swingx.JXHyperlink();
        jXHyperlink3 = new org.jdesktop.swingx.JXHyperlink();
        jXTaskPane2 = new org.jdesktop.swingx.JXTaskPane();
        jXTaskPane3 = new org.jdesktop.swingx.JXTaskPane();
        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        jXStatusBar1 = new org.jdesktop.swingx.JXStatusBar();
        MenuBar = new javax.swing.JMenuBar();
        MenuUsers = new javax.swing.JMenu();
        MIAdmonUsers = new javax.swing.JMenuItem();
        MIExit2 = new javax.swing.JMenuItem();
        MenuInform = new javax.swing.JMenu();
        MIAnalysis = new javax.swing.JMenuItem();
        MenuAbout = new javax.swing.JMenu();
        MIAcerca = new javax.swing.JMenuItem();

        jXTaskPane1.setTitle("Generalidades");

        jXHyperlink1.setText("Inventario");
        jXTaskPane1.getContentPane().add(jXHyperlink1);

        jXHyperlink2.setText("Planilla");
        jXTaskPane1.getContentPane().add(jXHyperlink2);

        jXHyperlink3.setText("Control de Asistencia");
        jXTaskPane1.getContentPane().add(jXHyperlink3);

        jXTaskPaneContainer1.add(jXTaskPane1);

        jXTaskPane2.setTitle("Herrramientas");
        jXTaskPaneContainer1.add(jXTaskPane2);

        jXTaskPane3.setTitle("Acerca de ...");
        jXTaskPaneContainer1.add(jXTaskPane3);

        jXTitledPanel1.setTitle("Prueba");

        javax.swing.GroupLayout jXTitledPanel1Layout = new javax.swing.GroupLayout(jXTitledPanel1.getContentContainer());
        jXTitledPanel1.getContentContainer().setLayout(jXTitledPanel1Layout);
        jXTitledPanel1Layout.setHorizontalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jXTitledPanel1Layout.setVerticalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jXStatusBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jXStatusBar1.setToolTipText("Hola Mundo de JNeuroSoft\n");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Control de Inventario. PLanilla y Flujo de Efectivo \"FARMACIA ALLISON\"");
        setBackground(new java.awt.Color(204, 204, 255));
        setName("FrameEmp"); // NOI18N
        getContentPane().setLayout(null);

        MenuBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MenuBar.setBorderPainted(false);

        MenuUsers.setForeground(new java.awt.Color(51, 102, 0));
        MenuUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/UserMenu.png"))); // NOI18N
        MenuUsers.setText("Usuarios");
        MenuUsers.setFont(new java.awt.Font("Papyrus", 1, 12));

        MIAdmonUsers.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        MIAdmonUsers.setFont(new java.awt.Font("Papyrus", 1, 12));
        MIAdmonUsers.setForeground(new java.awt.Color(51, 102, 0));
        MIAdmonUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AdmonUsers.png"))); // NOI18N
        MIAdmonUsers.setText("Administrar Usuarios");
        MenuUsers.add(MIAdmonUsers);

        MIExit2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        MIExit2.setFont(new java.awt.Font("Papyrus", 1, 12));
        MIExit2.setForeground(new java.awt.Color(51, 102, 0));
        MIExit2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Energy.png"))); // NOI18N
        MIExit2.setText("Salir del Sistema");
        MIExit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIExit2ActionPerformed(evt);
            }
        });
        MenuUsers.add(MIExit2);

        MenuBar.add(MenuUsers);

        MenuInform.setForeground(new java.awt.Color(51, 102, 0));
        MenuInform.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/folder32x32.png"))); // NOI18N
        MenuInform.setText("Informes Ejecutivos");
        MenuInform.setFont(new java.awt.Font("Papyrus", 1, 12));

        MIAnalysis.setFont(new java.awt.Font("Papyrus", 1, 12));
        MIAnalysis.setForeground(new java.awt.Color(51, 102, 0));
        MIAnalysis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Archivo.png"))); // NOI18N
        MIAnalysis.setText("Análisis Financiero");
        MIAnalysis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIAnalysisActionPerformed(evt);
            }
        });
        MenuInform.add(MIAnalysis);

        MenuBar.add(MenuInform);

        MenuAbout.setBorder(null);
        MenuAbout.setForeground(new java.awt.Color(51, 102, 0));
        MenuAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Hour.png"))); // NOI18N
        MenuAbout.setText("Acerca de ..");
        MenuAbout.setFont(new java.awt.Font("Papyrus", 1, 12));
        MenuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAboutActionPerformed(evt);
            }
        });

        MIAcerca.setFont(new java.awt.Font("Papyrus", 1, 12));
        MIAcerca.setForeground(new java.awt.Color(51, 102, 0));
        MIAcerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/community_users.png"))); // NOI18N
        MIAcerca.setText("Autores");
        MIAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIAcercaActionPerformed(evt);
            }
        });
        MenuAbout.add(MIAcerca);

        MenuBar.add(MenuAbout);

        setJMenuBar(MenuBar);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1023)/2, (screenSize.height-736)/2, 1023, 736);
    }// </editor-fold>//GEN-END:initComponents

    
     protected void setupDebugTool() {
        ToolWindow debugTool = toolWindowManager.getToolWindow("Ventas");
        DockedTypeDescriptor dockedTypeDescriptor = (DockedTypeDescriptor) debugTool.getTypeDescriptor(ToolWindowType.DOCKED);

        dockedTypeDescriptor.setDockLength(800);
        dockedTypeDescriptor.setPopupMenuEnabled(true);
        JMenu toolsMenu = dockedTypeDescriptor.getToolsMenu();
        toolsMenu.add(new AbstractAction("Hello World!!!") {
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(FrameEmp, "Hello World!!!");
            }
        });
        dockedTypeDescriptor.setToolWindowActionHandler(new ToolWindowActionHandler() {
            public void onHideButtonClick(ToolWindow toolWindow) {
//                JOptionPane.showMessageDialog(frame, "Hiding...");
                toolWindow.setVisible(false);
            }
        });
        dockedTypeDescriptor.setAnimating(true);
        dockedTypeDescriptor.setPreviewEnabled(true);
        dockedTypeDescriptor.setPreviewDelay(1500);
        dockedTypeDescriptor.setPreviewTransparentRatio(0.4f);

        SlidingTypeDescriptor slidingTypeDescriptor = (SlidingTypeDescriptor) debugTool.getTypeDescriptor(ToolWindowType.SLIDING);
        slidingTypeDescriptor.setEnabled(false);
        slidingTypeDescriptor.setTransparentMode(true);
        slidingTypeDescriptor.setTransparentRatio(0.8f);
        slidingTypeDescriptor.setTransparentDelay(0);
        slidingTypeDescriptor.setAnimating(true);

        FloatingTypeDescriptor floatingTypeDescriptor = (FloatingTypeDescriptor) debugTool.getTypeDescriptor(ToolWindowType.FLOATING);
        floatingTypeDescriptor.setEnabled(true);
        floatingTypeDescriptor.setLocation(150,200);
        floatingTypeDescriptor.setSize(1000,1000);
        floatingTypeDescriptor.setModal(false);
        floatingTypeDescriptor.setTransparentMode(true);
        floatingTypeDescriptor.setTransparentRatio(0.2f);
        floatingTypeDescriptor.setTransparentDelay(1000);
        floatingTypeDescriptor.setAnimating(true);
    }

   public void FSCommand(String command, String arg) {
    System.out.println("java FSCommand " + command + " " + arg);

    if (command.equals("javaLink")) {
      try {
        Runtime.getRuntime().exec("explorer " + arg);
      } catch (Exception e) {}
    }
    else if (command.equals("javaExecute")) {
      JOptionPane.showMessageDialog(this, "Flash events can be passed along to java");
    }    
  }  
    private void MIExit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIExit2ActionPerformed
       String objButtons[] = {"Si","No"};
       Utils.PlaySound("popUp.wav");
	int message = JOptionPane.showOptionDialog(this, "Está Seguro que Desea Cerrar la Aplicacion??", "JPharmware_2.0", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			new ImageIcon(getClass().getResource("/images/Interrogacion.png")), objButtons, objButtons[1]);
		
		if(message == 0) 
                {
                    System.exit(0);
                }
                else
                {
                    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
    }//GEN-LAST:event_MIExit2ActionPerformed

    private void MenuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAboutActionPerformed
       
    }//GEN-LAST:event_MenuAboutActionPerformed

    
    private void MIAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIAcercaActionPerformed
       try {
      if (!FlashPanel.hasFlashVersion("6")) {
        boolean b = FlashPanel.installFlash(new File("Flash9b.ocx"));
        System.out.println("installed flash: " + b);
      }
    } catch (JFlashLibraryLoadFailedException e) {
      System.out.println(e);
    }

    // before constructing a FlashPanel, specify the required flash version for the flash animation
    FlashPanel.setRequiredFlashVersion("5");
    // create an alternate image to display on any errors
    Image imageWelcome = getImageOfString("Welcome", Color.blue);
    // construct a FlashPanel displaying the welcome.swf flash animation
    FlashPanel welcomePanel = new FlashPanel(new File("C:\\JPharmware_2.0\\src\\images\\flash\\AcercaDe.swf"), imageWelcome);
    // disable animation looping
    welcomePanel.setLoop(false);
    JPanel jPanelWelcome = new JPanel(new BorderLayout());
    jPanelWelcome.add(welcomePanel, BorderLayout.CENTER);
    jPanelWelcome.setPreferredSize(new Dimension(600, 400));
    JOptionPane.showMessageDialog(this, jPanelWelcome, "Acerca de los Autores de JPharmware 2.0", JOptionPane.PLAIN_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/images/dialogs/health_care_shield.png")));

    }//GEN-LAST:event_MIAcercaActionPerformed

    private void MIAnalysisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIAnalysisActionPerformed
       JProducts ET = new JProducts();
       PanelEmperador.desktopPane.add(ET);      
       ET.setVisible(true);
       ET.setClosable(false);
       ET.setMaximizable(false);
       ET.toFront();
    }//GEN-LAST:event_MIAnalysisActionPerformed

    static Image getImageOfString(String s, Color c) {
      BufferedImage myDemoImage = new BufferedImage(300,200,BufferedImage.TYPE_INT_ARGB);
      Graphics2D mygD = (Graphics2D)myDemoImage.getGraphics();
      mygD.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
      mygD.setColor(c);
      Font DemoTopFont = new Font("Dialog",Font.BOLD,60);
      mygD.setFont(DemoTopFont);
      mygD.drawString(s,20,120);
      return myDemoImage;
  }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MIAcerca;
    private javax.swing.JMenuItem MIAdmonUsers;
    private javax.swing.JMenuItem MIAnalysis;
    private javax.swing.JMenuItem MIExit2;
    private javax.swing.JMenu MenuAbout;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu MenuInform;
    private javax.swing.JMenu MenuUsers;
    private org.jdesktop.swingx.JXHyperlink jXHyperlink1;
    private org.jdesktop.swingx.JXHyperlink jXHyperlink2;
    private org.jdesktop.swingx.JXHyperlink jXHyperlink3;
    private org.jdesktop.swingx.JXStatusBar jXStatusBar1;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane1;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane2;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane3;
    private org.jdesktop.swingx.JXTaskPaneContainer jXTaskPaneContainer1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    // End of variables declaration//GEN-END:variables
    
}
