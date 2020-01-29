
package interfacegraphic.humanresources;


import conectivity.ConnectEmployees;
import interfacegraphic.PanelEmperador;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import pictureConfiguration.ExtensionFileFilter;
import pictureConfiguration.ImageFileView;
import pictureConfiguration.ImagePreview;
import utilities.Utils;
import utilities.Utils.*;




public class JEmployees extends javax.swing.JInternalFrame {
    
    private JFileChooser fileChooser;
    private static final int PREFERRED_WIDTH = 140;
    private static final int PREFERRED_HEIGHT = 125;
    public static String Name, LastName, Home, Charge, EntranceDate,FiredDate, Cedula, Phone, State, Sex, Photo, DateSQL;
    public static int CodEmployee, CodCharge;
    
    public JEmployees(){
        initComponents();
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empleados.png")));
        
        ConnectEmployees.LoadEmployeeData();
        TablaEmpleados.packAll();
        TablaEmpleados.packTable(35);
        
        LPath.setVisible(false);
        PanelDespido.setVisible(false);
        RBMasculino.setSelected(true); setSex("M");
        try
        {
        MaskFormatter Mask = new MaskFormatter("###-######-####U");
        Mask.setPlaceholderCharacter(' ');
        DefaultFormatterFactory df = new DefaultFormatterFactory(Mask);
        JFTCedula.setFormatterFactory(df);
        }catch(Exception e){}
        
        try
        {
        MaskFormatter Mask = new MaskFormatter("###-####");
        Mask.setPlaceholderCharacter(' ');
        DefaultFormatterFactory df = new DefaultFormatterFactory(Mask);
        JFTTelefono.setFormatterFactory(df);
        }
        catch(Exception e){}
	
        ConnectEmployees.CargarJCCargos();  BActualizar.setEnabled(false);
    }
        
    public String getDateCalendar()
    {
      setDateSQL(null);
      String Date = null; 
      String Day = CalendarCombo.getSelectedDay();
      String Month = null, MonthSQL = null; 
      String Year = CalendarCombo.getSelectedYear();
      int intDay = Integer.parseInt(Day);
      int intMonth = Integer.parseInt(CalendarCombo.getSelectedMonth());
      int intYear = Integer.parseInt(Year);
      
       if(intDay < 10)
        {
            Day = "0"+Day;
        }
      
       switch(intMonth)
       {
           case 1: Month = "Enero"; break;
           case 2: Month = "Febrero"; break;    
           case 3: Month = "Marzo"; break;
           case 4: Month = "Abril"; break;
           case 5: Month = "Mayo"; break;
           case 6: Month = "Junio"; break;
           case 7: Month = "Julio"; break;
           case 8: Month = "Agosto"; break;
           case 9: Month = "Septiembre"; break;
           case 10: Month = "Octubre"; break;
           case 11: Month = "Noviembre"; break;
           case 12: Month = "Diciembre"; break;          
       }        
      Date = Day+"-"+Month+"-"+Year; 
      MonthSQL = String.valueOf(CalendarCombo.getSelectedMonth());
      
      if(intMonth < 10)
        {
            MonthSQL = "0"+MonthSQL;
        }
      setDateSQL(Year+"-"+Day+"-"+MonthSQL);
      
      return Date; 
    }
    
    public void setDateSQL(String dateSQL)
    {
        this.DateSQL = dateSQL;
    }
    public static void setCodEmployee(int codEmployee)
    {
        CodEmployee = codEmployee;
    }
    
    public void setCodCharge(int codCharge)
    {
        this.CodCharge = codCharge;
    }
    public void setName(String name)
    {
        this.Name = name;     
    }
    
    public void setLastName(String lastName)
    {
        this.LastName = lastName;     
    }
    
    public void setHome(String home)
    {
        this.Home = home;     
    }
    public void setCharge(String charge)
    {
        this.Charge = charge;
    }
    
     public void setEntranceDate(String entranceDate)
    {
        this.EntranceDate = entranceDate;
    }
     
    public static void setFiredDate(String firedDate)
    {
        FiredDate = firedDate;
    }
    
    public void setCedula(String cedula)
    {
        this.Cedula = cedula;
    }
    
    public void setPhone(String phone)
    {
        this.Phone = phone;
    }
    
    public void setState(String state)
    {
    this.State = state;
    }
    
    public void setSex(String sex)
    {
        this.Sex = sex;
    }
    
    public void setPhoto(String photo)
    {
        this.Photo = photo;
    }
    
    public int getCodEmployee()
    {
        return CodEmployee;
    }
    
    public int getCodCharge()
    {
        return CodCharge;
    }
    public String getDateSQL()
    {
        getDateCalendar();
        return DateSQL;
    }
    public String getName()
    {
        return Name;
    }
    
    public String getLastName()
    {
        return LastName;
    }
    
    public String getHome()
    {
        return Home;
    }
    
    public String getCharge()
    {
        return Charge;
    }
    
    public String getEntranceDate()
    {
        return EntranceDate;
    }
    
    public String getFiredDate()
    {
        return FiredDate;
    }
    
    public String getCedula()
    {
        return Cedula;
    }
        
    public String getPhone()
    {
        return Phone;
    }
     
    public String getState()
    {
        return State;
    }
    
    public String getSex()
    {
        return Sex;
    }
    
    public String getPhoto()
    {
        return Photo = LPath.getText();
    }
    
    public void SavePhoto()
    {
    try
        {
        File file = fileChooser.getSelectedFile();            
        BufferedImage FOTO = new BufferedImage(140,125,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = FOTO.createGraphics();
        LFoto.paint(g2d);
        g2d.dispose();
        
        RenderedImage rendImage =  FOTO;
        File fileDestino = new File("C:\\JPharmware_2.0\\Fotos\\"+file.getName());
      
        ImageIO.write(rendImage, "png", fileDestino);
        setPhoto("C:\\JPharmware_2.0\\Fotos\\"+file.getName());
        }catch(Exception excepGuardar)
        {
        Utils.Console("Error al Crear la image");
        }
        
        fileChooser = null;
    }
    
    public void CleanObjects()
    {
    setName(null); setLastName(null); setCedula(null); 
    setCharge(null); setCodCharge(0); setCodEmployee(0); setDateSQL(null); setEntranceDate(null);
    setFiredDate(null); setHome(null); setPhone(null); setPhoto(null); setPhoto(null); 
    RBMasculino.setSelected(true); LPath.setText("a"); LPath.setVisible(false);
    BActualizar.setEnabled(false);
    }
    
    public void CleanComponents()
    {
    TApellidos.setText(" "); TNombres.setText(" "); JFTCedula.setValue(null);
    TDireccion.setText(" "); JFTTelefono.setValue(null); LFoto.setIcon(null);
    JCCargos.setSelectedIndex(0); RBMasculino.setSelected(true); RBFemenino.setSelected(false);
    LPath.setText("a"); LPath.setVisible(false); TFechaEgreso.setText(" "); PanelDespido.setVisible(false);
    
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DesktopEmployees = new javax.swing.JDesktopPane();
        PanelMain = new javax.swing.JPanel();
        TabbedPane = new javax.swing.JTabbedPane();
        Pane0 = new javax.swing.JPanel();
        PanelDatos = new javax.swing.JPanel();
        LNombres = new javax.swing.JLabel();
        LApellidos = new javax.swing.JLabel();
        LCedula = new javax.swing.JLabel();
        LDireccion = new javax.swing.JLabel();
        LFechaIng = new javax.swing.JLabel();
        LTelefono = new javax.swing.JLabel();
        LCargo = new javax.swing.JLabel();
        TApellidos = new javax.swing.JTextField();
        TNombres = new javax.swing.JTextField();
        JFTCedula = new javax.swing.JFormattedTextField();
        CalendarCombo = new org.gui.JCalendarCombo();
        SPDireccion = new javax.swing.JScrollPane();
        TDireccion = new javax.swing.JTextArea();
        JFTTelefono = new javax.swing.JFormattedTextField();
        JCCargos = new javax.swing.JComboBox();
        PanelDespido = new javax.swing.JPanel();
        LFechaEgreso = new javax.swing.JLabel();
        TFechaEgreso = new javax.swing.JTextField();
        PanelSexo = new org.jdesktop.swingx.JXTitledPanel();
        RBMasculino = new javax.swing.JRadioButton();
        RBFemenino = new javax.swing.JRadioButton();
        PanelBar = new javax.swing.JPanel();
        ButtonBar1 = new com.l2fprod.common.swing.JButtonBar();
        BGuardar = new javax.swing.JButton();
        BActualizar = new javax.swing.JButton();
        BEliminar = new javax.swing.JButton();
        PanelFoto = new javax.swing.JPanel();
        LFoto = new javax.swing.JLabel();
        BAgregarImagen = new javax.swing.JButton();
        BRemoverImagen = new javax.swing.JButton();
        LPath = new javax.swing.JLabel();
        lblfondo = new javax.swing.JLabel();
        Pane01 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ScrollPane = new javax.swing.JScrollPane();
        TablaEmpleados = new org.jdesktop.swingx.JXTable();
        LblFondo = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        MArchivo = new javax.swing.JMenu();
        MINuevo = new javax.swing.JMenuItem();
        MICargos = new javax.swing.JMenuItem();
        MISalir = new javax.swing.JMenuItem();

        setTitle("Administración de datos de Empleados");
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        PanelMain.setLayout(null);

        TabbedPane.setForeground(new java.awt.Color(0, 0, 204));
        TabbedPane.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));

        Pane0.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));
        Pane0.setLayout(null);

        PanelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos personales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("BankGothic Lt BT", 1, 12), new java.awt.Color(0, 0, 204)));
        PanelDatos.setOpaque(false);
        PanelDatos.setLayout(null);

        LNombres.setFont(new java.awt.Font("Verdana", 1, 12));
        LNombres.setText("Nombres");
        PanelDatos.add(LNombres);
        LNombres.setBounds(25, 30, 60, 25);

        LApellidos.setFont(new java.awt.Font("Verdana", 1, 12));
        LApellidos.setText("Apellidos");
        PanelDatos.add(LApellidos);
        LApellidos.setBounds(25, 70, 70, 25);

        LCedula.setFont(new java.awt.Font("Verdana", 1, 12));
        LCedula.setText("Cédula");
        PanelDatos.add(LCedula);
        LCedula.setBounds(25, 110, 60, 25);

        LDireccion.setFont(new java.awt.Font("Verdana", 1, 12));
        LDireccion.setText("Dirección");
        PanelDatos.add(LDireccion);
        LDireccion.setBounds(25, 200, 70, 25);

        LFechaIng.setFont(new java.awt.Font("Verdana", 1, 12));
        LFechaIng.setText("Fecha de Ingreso");
        PanelDatos.add(LFechaIng);
        LFechaIng.setBounds(25, 145, 120, 25);

        LTelefono.setFont(new java.awt.Font("Verdana", 1, 12));
        LTelefono.setText("Teléfono");
        PanelDatos.add(LTelefono);
        LTelefono.setBounds(25, 270, 60, 25);

        LCargo.setFont(new java.awt.Font("Verdana", 1, 12));
        LCargo.setText("Cargo");
        PanelDatos.add(LCargo);
        LCargo.setBounds(25, 315, 60, 25);

        TApellidos.setFont(new java.awt.Font("Verdana", 1, 10));
        TApellidos.setForeground(new java.awt.Color(0, 102, 0));
        TApellidos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TApellidosKeyTyped(evt);
            }
        });
        PanelDatos.add(TApellidos);
        TApellidos.setBounds(120, 70, 280, 25);

        TNombres.setFont(new java.awt.Font("Verdana", 1, 10));
        TNombres.setForeground(new java.awt.Color(0, 102, 0));
        TNombres.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TNombresKeyTyped(evt);
            }
        });
        PanelDatos.add(TNombres);
        TNombres.setBounds(120, 30, 280, 25);

        JFTCedula.setForeground(new java.awt.Color(0, 102, 0));
        JFTCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        JFTCedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JFTCedula.setFont(new java.awt.Font("Verdana", 1, 10));
        PanelDatos.add(JFTCedula);
        JFTCedula.setBounds(120, 110, 280, 25);

        CalendarCombo.setForeground(new java.awt.Color(0, 102, 0));
        CalendarCombo.setFont(new java.awt.Font("Verdana", 1, 10));
        CalendarCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CalendarComboMouseClicked(evt);
            }
        });
        PanelDatos.add(CalendarCombo);
        CalendarCombo.setBounds(145, 145, 140, 25);

        TDireccion.setColumns(20);
        TDireccion.setFont(new java.awt.Font("Verdana", 1, 10));
        TDireccion.setForeground(new java.awt.Color(0, 102, 0));
        TDireccion.setRows(5);
        TDireccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        SPDireccion.setViewportView(TDireccion);

        PanelDatos.add(SPDireccion);
        SPDireccion.setBounds(120, 180, 280, 70);

        JFTTelefono.setForeground(new java.awt.Color(0, 102, 0));
        JFTTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JFTTelefono.setFont(new java.awt.Font("Verdana", 1, 10));
        PanelDatos.add(JFTTelefono);
        JFTTelefono.setBounds(120, 270, 150, 25);

        JCCargos.setFont(new java.awt.Font("Verdana", 1, 10));
        JCCargos.setForeground(new java.awt.Color(0, 102, 0));
        JCCargos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hola" }));
        PanelDatos.add(JCCargos);
        JCCargos.setBounds(120, 315, 150, 25);

        PanelDespido.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dato de Egreso", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("BankGothic Lt BT", 1, 12), new java.awt.Color(0, 0, 204)));
        PanelDespido.setOpaque(false);
        PanelDespido.setLayout(null);

        LFechaEgreso.setFont(new java.awt.Font("Verdana", 1, 10));
        LFechaEgreso.setText("Fecha de Egreso");
        PanelDespido.add(LFechaEgreso);
        LFechaEgreso.setBounds(30, 25, 100, 25);

        TFechaEgreso.setEditable(false);
        TFechaEgreso.setFont(new java.awt.Font("Verdana", 1, 10));
        TFechaEgreso.setForeground(new java.awt.Color(0, 102, 0));
        TFechaEgreso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PanelDespido.add(TFechaEgreso);
        TFechaEgreso.setBounds(140, 25, 140, 25);

        PanelDatos.add(PanelDespido);
        PanelDespido.setBounds(65, 360, 320, 70);

        PanelSexo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelSexo.setTitle("Sexo");
        PanelSexo.setTitleFont(new java.awt.Font("Verdana", 1, 10));
        com.l2fprod.common.swing.PercentLayout percentLayout2 = new com.l2fprod.common.swing.PercentLayout();
        percentLayout2.setOrientation(1);
        PanelSexo.getContentContainer().setLayout(percentLayout2);

        RBMasculino.setFont(new java.awt.Font("Verdana", 1, 10));
        RBMasculino.setText("Masculino");
        RBMasculino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RBMasculino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RBMasculinoMouseClicked(evt);
            }
        });
        PanelSexo.getContentContainer().add(RBMasculino);

        RBFemenino.setFont(new java.awt.Font("Verdana", 1, 10));
        RBFemenino.setText("Femenino");
        RBFemenino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RBFemenino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RBFemeninoMouseClicked(evt);
            }
        });
        PanelSexo.getContentContainer().add(RBFemenino);

        PanelDatos.add(PanelSexo);
        PanelSexo.setBounds(280, 270, 120, 70);

        Pane0.add(PanelDatos);
        PanelDatos.setBounds(10, 10, 430, 440);

        PanelBar.setLayout(new java.awt.BorderLayout());

        com.l2fprod.common.swing.PercentLayout percentLayout1 = new com.l2fprod.common.swing.PercentLayout();
        percentLayout1.setOrientation(1);
        ButtonBar1.setLayout(percentLayout1);

        BGuardar.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));
        BGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/List.png"))); // NOI18N
        BGuardar.setText("Guardar");
        BGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGuardarActionPerformed(evt);
            }
        });
        ButtonBar1.add(BGuardar);

        BActualizar.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));
        BActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refresh.png"))); // NOI18N
        BActualizar.setText("Actualizar");
        BActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActualizarActionPerformed(evt);
            }
        });
        ButtonBar1.add(BActualizar);

        BEliminar.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));
        BEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Eliminar.png"))); // NOI18N
        BEliminar.setText("Dar Baja");
        BEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEliminarActionPerformed(evt);
            }
        });
        ButtonBar1.add(BEliminar);

        PanelBar.add(ButtonBar1, java.awt.BorderLayout.CENTER);

        Pane0.add(PanelBar);
        PanelBar.setBounds(460, 20, 160, 220);

        PanelFoto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Fotografía", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("BankGothic Lt BT", 1, 12), new java.awt.Color(0, 0, 204)));
        PanelFoto.setOpaque(false);
        PanelFoto.setLayout(new java.awt.BorderLayout());

        LFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelFoto.add(LFoto, java.awt.BorderLayout.CENTER);

        Pane0.add(PanelFoto);
        PanelFoto.setBounds(460, 250, 160, 150);

        BAgregarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search.png"))); // NOI18N
        BAgregarImagen.setToolTipText("Búsqueda de Foto");
        BAgregarImagen.setOpaque(false);
        BAgregarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAgregarImagenActionPerformed(evt);
            }
        });
        Pane0.add(BAgregarImagen);
        BAgregarImagen.setBounds(485, 405, 40, 38);

        BRemoverImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Recycle Bin Empty 4.png"))); // NOI18N
        BRemoverImagen.setToolTipText("Remover Foto (No asignar imagen)");
        BRemoverImagen.setOpaque(false);
        BRemoverImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRemoverImagenActionPerformed(evt);
            }
        });
        Pane0.add(BRemoverImagen);
        BRemoverImagen.setBounds(555, 405, 40, 38);

        LPath.setFont(new java.awt.Font("Verdana", 0, 10));
        LPath.setForeground(new java.awt.Color(102, 0, 51));
        LPath.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LPath.setText("a");
        Pane0.add(LPath);
        LPath.setBounds(0, 450, 645, 14);

        lblfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wallpapers/shell_bar.png"))); // NOI18N
        Pane0.add(lblfondo);
        lblfondo.setBounds(0, 0, 650, 500);

        TabbedPane.addTab("Gestión de datos", new javax.swing.ImageIcon(getClass().getResource("/images/GestorEmpleados.png")), Pane0); // NOI18N

        Pane01.setFont(new java.awt.Font("BankGothic Md BT", 1, 12));
        Pane01.setLayout(null);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/titles/EmpleadosLogo.png"))); // NOI18N
        Pane01.add(jLabel2);
        jLabel2.setBounds(0, 0, 640, 140);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/titles/Allison.png"))); // NOI18N
        Pane01.add(jLabel1);
        jLabel1.setBounds(10, 350, 630, 120);

        TablaEmpleados.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaEmpleados.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TablaEmpleados.setCellSelectionEnabled(true);
        TablaEmpleados.setColumnControlVisible(true);
        TablaEmpleados.setColumnMargin(10);
        TablaEmpleados.setEditable(false);
        TablaEmpleados.setFont(new java.awt.Font("Verdana", 0, 10));
        ScrollPane.setViewportView(TablaEmpleados);

        Pane01.add(ScrollPane);
        ScrollPane.setBounds(10, 150, 640, 190);

        LblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shell_bar.png"))); // NOI18N
        Pane01.add(LblFondo);
        LblFondo.setBounds(0, 0, 650, 470);

        TabbedPane.addTab("Lista de Empleados", new javax.swing.ImageIcon(getClass().getResource("/images/note_edit.png")), Pane01); // NOI18N

        PanelMain.add(TabbedPane);
        TabbedPane.setBounds(10, 10, 650, 500);

        PanelMain.setBounds(0, 0, 670, 540);
        DesktopEmployees.add(PanelMain, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(DesktopEmployees, java.awt.BorderLayout.CENTER);

        MenuBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        MArchivo.setForeground(new java.awt.Color(51, 102, 0));
        MArchivo.setText("Archivo");
        MArchivo.setFont(new java.awt.Font("Papyrus", 1, 12));

        MINuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        MINuevo.setFont(new java.awt.Font("Papyrus", 1, 12));
        MINuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MINuevo.png"))); // NOI18N
        MINuevo.setText("Nuevo Empleado");
        MINuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MINuevoActionPerformed(evt);
            }
        });
        MArchivo.add(MINuevo);

        MICargos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        MICargos.setFont(new java.awt.Font("Papyrus", 1, 12));
        MICargos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cargos.png"))); // NOI18N
        MICargos.setText("Búsqueda de Empleado");
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

        setJMenuBar(MenuBar);

        setBounds(150, 20, 682, 587);
    }// </editor-fold>//GEN-END:initComponents

    private void BRemoverImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRemoverImagenActionPerformed
       LFoto.setIcon(null);
    }//GEN-LAST:event_BRemoverImagenActionPerformed

    private void MINuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MINuevoActionPerformed
       CleanObjects(); CleanComponents();
       
}//GEN-LAST:event_MINuevoActionPerformed
   
    private void BAgregarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAgregarImagenActionPerformed
       fileChooser = new JFileChooser(".");
       ExtensionFileFilter jpegFilter = new ExtensionFileFilter(null, new String[] { "JPG", "JPEG","PNG","GIF","TIFF" });
      
       fileChooser.addChoosableFileFilter(jpegFilter);
       fileChooser.setFileView(new ImageFileView());       
       fileChooser.setAccessory(new ImagePreview(fileChooser));
      
        ActionListener actionListener = new ActionListener() {

            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser theFileChooser = (JFileChooser) actionEvent.getSource();
                String command = actionEvent.getActionCommand();
                
                if (command.equals(JFileChooser.APPROVE_SELECTION)) {
                    File selectedFile = theFileChooser.getSelectedFile();
                    LPath.setText(selectedFile.getParent()+"\\"+selectedFile.getName());
                    LPath.setVisible(true);
                    
                    ImageIcon icon = new ImageIcon(selectedFile.getPath());
                    
                    if (icon.getIconWidth() > PREFERRED_WIDTH) {
                        icon = new ImageIcon(icon.getImage().getScaledInstance(
                                PREFERRED_WIDTH, -1, Image.SCALE_DEFAULT));
                        if (icon.getIconHeight() > PREFERRED_HEIGHT) {
                            icon = new ImageIcon(icon.getImage().getScaledInstance(
                                    -1, PREFERRED_HEIGHT, Image.SCALE_DEFAULT));
                        }
                    }
                    LFoto.setIcon(icon);
                } else if (command.equals(JFileChooser.CANCEL_SELECTION)) {
                    LPath.setText(" ");
                    LPath.setVisible(true);
                }
            }
        };
   fileChooser.addActionListener(actionListener);
   int returnVal = fileChooser.showDialog(JEmployees.this, "Escoger Foto");
   
       
    }//GEN-LAST:event_BAgregarImagenActionPerformed

    private void BGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGuardarActionPerformed
    
     String Nombre = TNombres.getText(); String Apellido = TApellidos.getText();
     String Ced = JFTCedula.getText(); String Tel = JFTTelefono.getText();
     String Dir = TDireccion.getText();
     
     System.out.print(ConnectEmployees.VerifyExistence(JFTCedula.getText()));
    
        
        if(Nombre.length() == 0 || Apellido.length() == 0 || Dir.length() == 0 || Tel.length() == 0)
        {
          JOptionPane.showMessageDialog( null,"Complete todos los datos","Información del Sistema",JOptionPane.ERROR_MESSAGE ) ;  
        } 
        else 
        {
            if (ConnectEmployees.VerifyExistence(JFTCedula.getText()) != null) {
                Utils.MyDialog("Esta persona ya se encuentra registrada", "Error al Registrar", "Error.png", "Infected.wav");
                
            } 
            else 
            {
               SavePhoto();       
               setName(TNombres.getText()); setLastName(TApellidos.getText()); setCedula(JFTCedula.getText());             
               setHome(TDireccion.getText()); setPhone(JFTTelefono.getText()); setCodCharge(ConnectEmployees.getCodCargo(String.valueOf(JCCargos.getSelectedItem())));
               ConnectEmployees.SaveDataEmployees(CodCharge, getDateSQL(), Cedula, Name, LastName, Home, Sex, getPhoto(), Phone);
            }
     }
    
    }//GEN-LAST:event_BGuardarActionPerformed

    private void RBMasculinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RBMasculinoMouseClicked
        RBMasculino.setSelected(true); RBFemenino.setSelected(false);
        setSex("M");
    }//GEN-LAST:event_RBMasculinoMouseClicked

    private void RBFemeninoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RBFemeninoMouseClicked
        RBFemenino.setSelected(true); RBMasculino.setSelected(false);
        setSex("F");
    }//GEN-LAST:event_RBFemeninoMouseClicked

    private void CalendarComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalendarComboMouseClicked
      
    }//GEN-LAST:event_CalendarComboMouseClicked

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
      
    }//GEN-LAST:event_formMouseMoved

    private void BActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActualizarActionPerformed
     String Nombre = TNombres.getText(); String Apellido = TApellidos.getText();
     String Ced = JFTCedula.getText(); String Tel = JFTTelefono.getText();
     String Dir = TDireccion.getText();
     
     System.out.print(ConnectEmployees.VerifyExistence(JFTCedula.getText()));          
        if(Nombre.length() == 0 || Apellido.length() == 0 || Dir.length() == 0 || Tel.length() == 0)
        {
          JOptionPane.showMessageDialog( null,"Complete todos los datos","Información del Sistema",JOptionPane.ERROR_MESSAGE) ;  
        } 
        else 
        {
        SavePhoto();       
        setName(TNombres.getText()); setLastName(TApellidos.getText()); setCedula(JFTCedula.getText());             
        setHome(TDireccion.getText()); setPhone(JFTTelefono.getText()); setCodCharge(ConnectEmployees.getCodCargo(String.valueOf(JCCargos.getSelectedItem())));
        
        ConnectEmployees.ModifyDataEmployees(CodEmployee,CodCharge, getDateSQL(), Cedula, Name, LastName, Home, Sex, getPhoto(), Phone);       
        }  
    }//GEN-LAST:event_BActualizarActionPerformed

    private void MISalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MISalirActionPerformed
        this.dispose();
        PanelEmperador.HypEmpleados.setEnabled(true);
}//GEN-LAST:event_MISalirActionPerformed

    private void BEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEliminarActionPerformed
       FiredDate JD = new FiredDate();
       DesktopEmployees.add(JD);
       JD.setVisible(true);
       JD.setClosable(true);
       JD.setMaximizable(false);
       JD.toFront();
    }//GEN-LAST:event_BEliminarActionPerformed

    private void MICargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MICargosActionPerformed
       EmployeeTree ET = new EmployeeTree();
       DesktopEmployees.add(ET);      
       ET.setVisible(true);
       ET.setClosable(true);
       ET.setMaximizable(false);
       ET.toFront();
    }//GEN-LAST:event_MICargosActionPerformed

    private void TNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNombresKeyTyped
        char c = evt.getKeyChar();
         if (!((c >= 'a' && c <= 'z') || c == 'ñ' || c == ' '|| c == 'Ñ' || (c >= 'A' && c <= 'Z')))
              evt.consume();
    }//GEN-LAST:event_TNombresKeyTyped

    private void TApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TApellidosKeyTyped
        char c = evt.getKeyChar();
         if (!((c >= 'a' && c <= 'z') || c == 'ñ' || c == ' '|| c == 'Ñ' || (c >= 'A' && c <= 'Z')))
              evt.consume();
    }//GEN-LAST:event_TApellidosKeyTyped
  
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton BActualizar;
    private javax.swing.JButton BAgregarImagen;
    private javax.swing.JButton BEliminar;
    private javax.swing.JButton BGuardar;
    private javax.swing.JButton BRemoverImagen;
    private com.l2fprod.common.swing.JButtonBar ButtonBar1;
    public static org.gui.JCalendarCombo CalendarCombo;
    private javax.swing.JDesktopPane DesktopEmployees;
    public static javax.swing.JComboBox JCCargos;
    public static javax.swing.JFormattedTextField JFTCedula;
    public static javax.swing.JFormattedTextField JFTTelefono;
    private javax.swing.JLabel LApellidos;
    private javax.swing.JLabel LCargo;
    private javax.swing.JLabel LCedula;
    private javax.swing.JLabel LDireccion;
    public static javax.swing.JLabel LFechaEgreso;
    private javax.swing.JLabel LFechaIng;
    public static javax.swing.JLabel LFoto;
    private javax.swing.JLabel LNombres;
    public static javax.swing.JLabel LPath;
    private javax.swing.JLabel LTelefono;
    private javax.swing.JLabel LblFondo;
    private javax.swing.JMenu MArchivo;
    private javax.swing.JMenuItem MICargos;
    private javax.swing.JMenuItem MINuevo;
    private javax.swing.JMenuItem MISalir;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JPanel Pane0;
    private javax.swing.JPanel Pane01;
    private javax.swing.JPanel PanelBar;
    private javax.swing.JPanel PanelDatos;
    public static javax.swing.JPanel PanelDespido;
    private javax.swing.JPanel PanelFoto;
    private javax.swing.JPanel PanelMain;
    private org.jdesktop.swingx.JXTitledPanel PanelSexo;
    public static javax.swing.JRadioButton RBFemenino;
    public static javax.swing.JRadioButton RBMasculino;
    private javax.swing.JScrollPane SPDireccion;
    private javax.swing.JScrollPane ScrollPane;
    public static javax.swing.JTextField TApellidos;
    public static javax.swing.JTextArea TDireccion;
    public static javax.swing.JTextField TFechaEgreso;
    public static javax.swing.JTextField TNombres;
    private javax.swing.JTabbedPane TabbedPane;
    public static org.jdesktop.swingx.JXTable TablaEmpleados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblfondo;
    // End of variables declaration//GEN-END:variables
    
}
