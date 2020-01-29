/*
 * JSuppliers.java
 *
 * Created on 17 de agosto de 2008, 04:50 PM
 */

package interfacegraphicsuppliers;

import conectivity.ConnectSuppliers;
import interfacegraphic.PanelEmperador;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import utilities.Utils;

/**
 *
 * @author  Elvin Gregorio
 */
public class JSuppliers extends javax.swing.JInternalFrame {
    private static int CodSupplier;
    private String NameSupplier;
    private String NumRuc;
    private String Address;
    private String Phone;
    private Float DiscountPorc;
    private String SupplierContact;
    
    /** Creates new form JSuppliers */
    public JSuppliers() {
        initComponents();
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Proveedores.png")));
        ConnectSuppliers.LoadSupplierData();
        TablaProveedores.packTable(40);
        TablaProveedores.packAll();
        
        try
        {
        MaskFormatter Mask = new MaskFormatter("###-####");
        Mask.setPlaceholderCharacter(' ');
        DefaultFormatterFactory df = new DefaultFormatterFactory(Mask);
        JFTTelefono.setFormatterFactory(df);
        }
        catch(Exception e){}
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DesktopSuppliers = new javax.swing.JDesktopPane();
        PanelMain = new javax.swing.JPanel();
        TabbedPane = new javax.swing.JTabbedPane();
        Pane0 = new javax.swing.JPanel();
        PanelDatos = new javax.swing.JPanel();
        LNombreProveedor = new javax.swing.JLabel();
        LNumRuc = new javax.swing.JLabel();
        LPorDesc = new javax.swing.JLabel();
        LDireccion = new javax.swing.JLabel();
        LTelefono = new javax.swing.JLabel();
        LContacto = new javax.swing.JLabel();
        TNumRuc = new javax.swing.JTextField();
        TNombreProveedor = new javax.swing.JTextField();
        SPDireccion = new javax.swing.JScrollPane();
        TDireccion = new javax.swing.JTextArea();
        JFTTelefono = new javax.swing.JFormattedTextField();
        ButtonBar1 = new com.l2fprod.common.swing.JButtonBar();
        BGuardar = new javax.swing.JButton();
        LBlImagen = new javax.swing.JLabel();
        BActualizar = new javax.swing.JButton();
        TContacto = new javax.swing.JTextField();
        JFTPorcDesc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblfondo = new javax.swing.JLabel();
        Pane01 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ScrollPane = new javax.swing.JScrollPane();
        TablaProveedores = new org.jdesktop.swingx.JXTable();
        LblFondo = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        MArchivo = new javax.swing.JMenu();
        MINuevo = new javax.swing.JMenuItem();
        MICargos = new javax.swing.JMenuItem();
        MISalir = new javax.swing.JMenuItem();
        MHerramientas = new javax.swing.JMenu();

        setTitle("Administración de Datos de Proveedores");

        PanelMain.setLayout(null);

        TabbedPane.setForeground(new java.awt.Color(0, 0, 204));
        TabbedPane.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));

        Pane0.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));
        Pane0.setLayout(null);

        PanelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos Generales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("BankGothic Lt BT", 1, 12), new java.awt.Color(0, 0, 204)));
        PanelDatos.setOpaque(false);
        PanelDatos.setLayout(null);

        LNombreProveedor.setFont(new java.awt.Font("Verdana", 1, 12));
        LNombreProveedor.setText("Nombre Proveedor");
        PanelDatos.add(LNombreProveedor);
        LNombreProveedor.setBounds(25, 30, 130, 25);

        LNumRuc.setFont(new java.awt.Font("Verdana", 1, 12));
        LNumRuc.setText("Num Ruc");
        PanelDatos.add(LNumRuc);
        LNumRuc.setBounds(25, 70, 70, 25);

        LPorDesc.setFont(new java.awt.Font("Verdana", 1, 12));
        LPorDesc.setText("Porc Desc");
        PanelDatos.add(LPorDesc);
        LPorDesc.setBounds(225, 200, 70, 25);

        LDireccion.setFont(new java.awt.Font("Verdana", 1, 12));
        LDireccion.setText("Dirección");
        PanelDatos.add(LDireccion);
        LDireccion.setBounds(25, 130, 70, 25);

        LTelefono.setFont(new java.awt.Font("Verdana", 1, 12));
        LTelefono.setText("Teléfono");
        PanelDatos.add(LTelefono);
        LTelefono.setBounds(25, 200, 60, 25);

        LContacto.setFont(new java.awt.Font("Verdana", 1, 12));
        LContacto.setText("Contacto Proveedor");
        PanelDatos.add(LContacto);
        LContacto.setBounds(150, 255, 140, 25);

        TNumRuc.setFont(new java.awt.Font("Verdana", 1, 10));
        TNumRuc.setForeground(new java.awt.Color(0, 102, 0));
        TNumRuc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TNumRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TNumRucKeyTyped(evt);
            }
        });
        PanelDatos.add(TNumRuc);
        TNumRuc.setBounds(120, 70, 280, 25);

        TNombreProveedor.setFont(new java.awt.Font("Verdana", 1, 10));
        TNombreProveedor.setForeground(new java.awt.Color(0, 102, 0));
        TNombreProveedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TNombreProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TNombreProveedorKeyTyped(evt);
            }
        });
        PanelDatos.add(TNombreProveedor);
        TNombreProveedor.setBounds(160, 30, 240, 25);

        TDireccion.setColumns(20);
        TDireccion.setFont(new java.awt.Font("Verdana", 1, 10));
        TDireccion.setForeground(new java.awt.Color(0, 102, 0));
        TDireccion.setRows(5);
        TDireccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        SPDireccion.setViewportView(TDireccion);

        PanelDatos.add(SPDireccion);
        SPDireccion.setBounds(120, 110, 280, 70);

        JFTTelefono.setForeground(new java.awt.Color(0, 102, 0));
        JFTTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JFTTelefono.setFont(new java.awt.Font("Verdana", 1, 10));
        PanelDatos.add(JFTTelefono);
        JFTTelefono.setBounds(120, 200, 100, 25);

        ButtonBar1.setOpaque(false);
        com.l2fprod.common.swing.PercentLayout percentLayout1 = new com.l2fprod.common.swing.PercentLayout();
        percentLayout1.setGap(12);
        ButtonBar1.setLayout(percentLayout1);

        BGuardar.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));
        BGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add Card.png"))); // NOI18N
        BGuardar.setText("Guardar");
        BGuardar.setPreferredSize(new java.awt.Dimension(85, 71));
        BGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGuardarActionPerformed(evt);
            }
        });
        ButtonBar1.add(BGuardar);

        LBlImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/health_care_shield.png"))); // NOI18N
        LBlImagen.setPreferredSize(new java.awt.Dimension(40, 40));
        ButtonBar1.add(LBlImagen);

        BActualizar.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));
        BActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reload.png"))); // NOI18N
        BActualizar.setText("Actualizar");
        BActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActualizarActionPerformed(evt);
            }
        });
        ButtonBar1.add(BActualizar);

        PanelDatos.add(ButtonBar1);
        ButtonBar1.setBounds(100, 353, 240, 70);

        TContacto.setFont(new java.awt.Font("Verdana", 1, 10));
        TContacto.setForeground(new java.awt.Color(0, 102, 0));
        TContacto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TContacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TContactoKeyTyped(evt);
            }
        });
        PanelDatos.add(TContacto);
        TContacto.setBounds(100, 290, 240, 25);

        JFTPorcDesc.setFont(new java.awt.Font("Verdana", 1, 10));
        JFTPorcDesc.setForeground(new java.awt.Color(0, 102, 0));
        JFTPorcDesc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JFTPorcDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JFTPorcDescKeyTyped(evt);
            }
        });
        PanelDatos.add(JFTPorcDesc);
        JFTPorcDesc.setBounds(300, 200, 100, 25);

        Pane0.add(PanelDatos);
        PanelDatos.setBounds(10, 10, 430, 440);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/titles/ProveedoresLogo.png"))); // NOI18N
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pane0.add(jLabel4);
        jLabel4.setBounds(440, -20, 200, 490);

        lblfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wallpapers/shell_bar.png"))); // NOI18N
        Pane0.add(lblfondo);
        lblfondo.setBounds(0, 0, 650, 500);

        TabbedPane.addTab("Gestión de datos", new javax.swing.ImageIcon(getClass().getResource("/images/GestorProveedore.png")), Pane0); // NOI18N

        Pane01.setFont(new java.awt.Font("BankGothic Md BT", 1, 12));
        Pane01.setLayout(null);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/titles/ProvedoresLogoH.png"))); // NOI18N
        Pane01.add(jLabel2);
        jLabel2.setBounds(0, 0, 640, 140);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/titles/Allison.png"))); // NOI18N
        Pane01.add(jLabel1);
        jLabel1.setBounds(10, 350, 630, 120);

        TablaProveedores.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaProveedores.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TablaProveedores.setCellSelectionEnabled(true);
        TablaProveedores.setColumnControlVisible(true);
        TablaProveedores.setColumnMargin(10);
        TablaProveedores.setEditable(false);
        TablaProveedores.setFont(new java.awt.Font("Verdana", 0, 10));
        ScrollPane.setViewportView(TablaProveedores);

        Pane01.add(ScrollPane);
        ScrollPane.setBounds(15, 150, 610, 190);

        LblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shell_bar.png"))); // NOI18N
        Pane01.add(LblFondo);
        LblFondo.setBounds(0, 0, 650, 470);

        TabbedPane.addTab("Lista de Proveedores", new javax.swing.ImageIcon(getClass().getResource("/images/note_edit.png")), Pane01); // NOI18N

        PanelMain.add(TabbedPane);
        TabbedPane.setBounds(10, 10, 650, 500);

        PanelMain.setBounds(0, 0, 670, 540);
        DesktopSuppliers.add(PanelMain, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(DesktopSuppliers, java.awt.BorderLayout.CENTER);

        MenuBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        MArchivo.setForeground(new java.awt.Color(51, 102, 0));
        MArchivo.setText("Archivo");
        MArchivo.setFont(new java.awt.Font("Papyrus", 1, 12));

        MINuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        MINuevo.setFont(new java.awt.Font("Papyrus", 1, 12));
        MINuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DocumentBlank.png"))); // NOI18N
        MINuevo.setText("Nuevo Proveedor");
        MINuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MINuevoActionPerformed(evt);
            }
        });
        MArchivo.add(MINuevo);

        MICargos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        MICargos.setFont(new java.awt.Font("Papyrus", 1, 12));
        MICargos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WindowsExplorer.png"))); // NOI18N
        MICargos.setText("Búsqueda de Proveedor");
        MICargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MICargosActionPerformed(evt);
            }
        });
        MArchivo.add(MICargos);

        MISalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        MISalir.setFont(new java.awt.Font("Papyrus", 1, 12));
        MISalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Shutdown.png"))); // NOI18N
        MISalir.setText("Cerrar Módulo");
        MISalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MISalirActionPerformed(evt);
            }
        });
        MArchivo.add(MISalir);

        MenuBar.add(MArchivo);

        MHerramientas.setForeground(new java.awt.Color(51, 102, 0));
        MHerramientas.setText("Herramientas");
        MHerramientas.setFont(new java.awt.Font("Papyrus", 1, 12));
        MenuBar.add(MHerramientas);

        setJMenuBar(MenuBar);

        setBounds(150, 20, 682, 587);
    }// </editor-fold>//GEN-END:initComponents

    private void MINuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MINuevoActionPerformed
        CleanObjects(); 
        CleanComponents();
    }//GEN-LAST:event_MINuevoActionPerformed

    private void MICargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MICargosActionPerformed
        SupplierTree ET = new SupplierTree();
        DesktopSuppliers.add(ET);
        ET.setVisible(true);
        ET.setClosable(true);
        ET.setMaximizable(false);
        ET.toFront();
    }//GEN-LAST:event_MICargosActionPerformed

    private void MISalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MISalirActionPerformed
        this.dispose();
        PanelEmperador.HypProveedores.setEnabled(true);
    }//GEN-LAST:event_MISalirActionPerformed

     public void CleanObjects()
    {
    setNameSupplier(null); setNumRuc(null); setAddress(null); 
    setPhone(null); setDiscountPorc(null);  setSupplierContact(null);
    BActualizar.setEnabled(false);
    }
    
    public void CleanComponents()
    {
    TNumRuc.setText(" "); TNombreProveedor.setText(" "); JFTPorcDesc.setText("");
    TDireccion.setText(" "); JFTTelefono.setValue(null); TContacto.setText(" ");
    }
    
    public void setNameSupplier(String name)
    {
        this.NameSupplier = name;     
    }
    public static void setCodSupplier(int codsupplier)
    {
        CodSupplier = codsupplier;
    }
    public void setNumRuc(String numruc)
    {
        this.NumRuc = numruc;     
    }
    public void setAddress(String address)
    {
        this.Address = address;     
    }
    public void setPhone(String phone)
    {
        this.Phone = phone;
    }
    public void setDiscountPorc(Float disc)
    {
        this.DiscountPorc = disc;
    }
    public void setSupplierContact(String contact)
    {
        this.SupplierContact = contact;
    }
    private void BGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGuardarActionPerformed
        String NombreProveedor = TNombreProveedor.getText(); String NumRuc = TNumRuc.getText();
        String DiscountPorc = JFTPorcDesc.getText(); String Tel = JFTTelefono.getText();
        String Dir = TDireccion.getText();  String Contacto = TContacto.getText();
        
        System.out.print(ConnectSuppliers.VerifyExistence(TNumRuc.getText()));
        
        
        if(NombreProveedor.length() == 0 || DiscountPorc.length() == 0 || Tel.length() == 0 || Dir.length() == 0 || Contacto.length() == 0)
        {
           Utils.MyDialog("Complete todos los datos", "Información del Sistema", "Error.png", "Infected.wav");
        } 
        else
        {
            if(Float.parseFloat(DiscountPorc) < 2 || Float.parseFloat(DiscountPorc) > 100)
            {
               Utils.MyDialog("El Descuento debe estar en el rango de 0 -100", "Error al Registrar", "Error.png", "Infected.wav"); 
            }
            else
            {
            if (ConnectSuppliers.VerifyExistence(TNumRuc.getText()) != null) 
            {
                Utils.MyDialog("Este proveedor ya existe en el sistema", "Error al Registrar", "Error.png", "Infected.wav");
            } 
            else 
            {
                setNameSupplier(TNombreProveedor.getText()); setNumRuc(TNumRuc.getText()); setDiscountPorc(Float.parseFloat(JFTPorcDesc.getText()));
                setAddress(TDireccion.getText()); setPhone(JFTTelefono.getText());
                ConnectSuppliers.SaveDataSupplier(NameSupplier, NumRuc, Address, Phone, SupplierContact, Float.parseFloat(DiscountPorc));
            }
            }
        }
    }//GEN-LAST:event_BGuardarActionPerformed

    private void BActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActualizarActionPerformed
        String NombreProveedor = TNombreProveedor.getText(); //String NumRuc = TNumRuc.getText();
        String PorcDesc = JFTPorcDesc.getText(); 
        String Tel = JFTTelefono.getText();
        String Dir = TDireccion.getText();  String Contacto = TContacto.getText();
        
        System.out.print(ConnectSuppliers.VerifyExistence(JFTPorcDesc.getText()));
        if(NombreProveedor.length() == 0 || PorcDesc.length() == 0 || Tel.length() == 0 || Dir.length() == 0 || Contacto.length() == 0) {
           Utils.MyDialog("Complete todos los datos", "Información del Sistema", "Error.png", "Infected.wav");
        } else {
            setNameSupplier(TNombreProveedor.getText()); setNumRuc(String.valueOf(TNumRuc.getText())); setDiscountPorc(Float.parseFloat(JFTPorcDesc.getText()));
            setAddress(TDireccion.getText()); setPhone(JFTTelefono.getText());
            
            ConnectSuppliers.ModifyDataSuppliers(CodSupplier,NameSupplier, NumRuc, Address, Phone, SupplierContact, DiscountPorc);
        }
    }//GEN-LAST:event_BActualizarActionPerformed

    private void TNombreProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNombreProveedorKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= 'a' && c <= 'z') || c == 'ñ' || c == ' '|| c == 'Ñ' || (c >= 'A' && c <= 'Z') || (c == '-') || (c == '.')))
               evt.consume();
    }//GEN-LAST:event_TNombreProveedorKeyTyped

    private void TContactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TContactoKeyTyped
        char c = evt.getKeyChar();
         if (!((c >= 'a' && c <= 'z') || c == 'ñ' || c == ' '|| c == 'Ñ' || (c >= 'A' && c <= 'Z')))
              evt.consume();
    }//GEN-LAST:event_TContactoKeyTyped

    private void TNumRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNumRucKeyTyped
        char c = evt.getKeyChar();
       
        if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE)))
            evt.consume();
    }//GEN-LAST:event_TNumRucKeyTyped

    private void JFTPorcDescKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JFTPorcDescKeyTyped
        char c = evt.getKeyChar();
       
        if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == '.')))
            evt.consume();
}//GEN-LAST:event_JFTPorcDescKeyTyped
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton BActualizar;
    private javax.swing.JButton BGuardar;
    private com.l2fprod.common.swing.JButtonBar ButtonBar1;
    private javax.swing.JDesktopPane DesktopSuppliers;
    public static javax.swing.JTextField JFTPorcDesc;
    public static javax.swing.JFormattedTextField JFTTelefono;
    private javax.swing.JLabel LBlImagen;
    private javax.swing.JLabel LContacto;
    private javax.swing.JLabel LDireccion;
    private javax.swing.JLabel LNombreProveedor;
    private javax.swing.JLabel LNumRuc;
    private javax.swing.JLabel LPorDesc;
    private javax.swing.JLabel LTelefono;
    private javax.swing.JLabel LblFondo;
    private javax.swing.JMenu MArchivo;
    private javax.swing.JMenu MHerramientas;
    private javax.swing.JMenuItem MICargos;
    private javax.swing.JMenuItem MINuevo;
    private javax.swing.JMenuItem MISalir;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JPanel Pane0;
    private javax.swing.JPanel Pane01;
    private javax.swing.JPanel PanelDatos;
    private javax.swing.JPanel PanelMain;
    private javax.swing.JScrollPane SPDireccion;
    private javax.swing.JScrollPane ScrollPane;
    public static javax.swing.JTextField TContacto;
    public static javax.swing.JTextArea TDireccion;
    public static javax.swing.JTextField TNombreProveedor;
    public static javax.swing.JTextField TNumRuc;
    private javax.swing.JTabbedPane TabbedPane;
    public static org.jdesktop.swingx.JXTable TablaProveedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblfondo;
    // End of variables declaration//GEN-END:variables
    
}
