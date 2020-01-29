

package interfacegraphic.sales;

import conectivity.ConnectEmployees;
import conectivity.ConnectSales;
import interfacegraphic.PanelEmperador;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilities.Utils;


public class JSales extends javax.swing.JInternalFrame implements Runnable{
public static int CodProdProv, CantidadVendida, Existencias, CodEmpleado, CodVenta;
public static String NombreProd, Presentacion, FechaVenta, cant;
public static float PrecioVenta, SubTotal;
public  Thread SuperThread;  
Calendar calendar;
int x = 580; 

    public JSales() {
        initComponents();
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ventas.png")));
        ConnectSales.LoadEmployeesCombo();        
        TNumVenta.setText(String.valueOf(ConnectSales.getCodVenta()));
        TFechaVenta.setText(getDate(1));
        JCAnulado.setVisible(false);
        SuperThread = new Thread(this);
        SuperThread.start();
    }
    
     public void run(){
        while(true){
            try{
                changePositionTopLeft();
                Thread.sleep(50);             
            }catch(InterruptedException e) {
                System.out.println("Exception de SuperHilo");}
        }
    }
     
     public static void MostrarSubtotal()
     {
        int NumCol = TablaDetalleVenta.getRowCount();          
        SubTotal = 0; 
        for(int i = 0; i < NumCol; i++)
        {
            SubTotal += Float.parseFloat(String.valueOf(TablaDetalleVenta.getValueAt(i,5)));
        }
        LSubTotalText.setText(String.valueOf(SubTotal)); LIVAText.setText("0"); LTotalText.setText(String.valueOf(SubTotal));
     }
     
     public void setCodProdProv(int cod)
    {
        this.CodProdProv = cod;
    }
    
    public int getCodProdProv()
    {
        return CodProdProv;
    }
    
    public void setNombreProd(String nombre)
    {
        this.NombreProd = nombre;
    }
    
    public String getNombreProd()
    {
        return NombreProd;
    }
    
    public void setPresentacion(String presentacion)
    {
        this.Presentacion = presentacion;
    }
    
    public String getPresentacion()
    {
        return Presentacion;
    } 
    
    public void setCantidad(int cant)
    {
        this.CantidadVendida = cant;
    }
    
    public int getCantidad()
    {
        return CantidadVendida;
    }
    
    public void setPrecioVenta(float precio)
    {
        this.PrecioVenta = precio;
    }
    
    public float getPrecioVenta()
    {
        return PrecioVenta;
    }
    
    public void setSubTotal(float subtotal)
    {
        this.SubTotal = subtotal;
    }
    
    public float getSubTotal()
    {
        return SubTotal;
    }
    
     public void setCodEmpleado(int cod)
    {
        this.CodEmpleado = cod;
    }
    
    public int getCodEmpleado()
    {
        return CodEmpleado;
    }
    
    public void setFechaVenta(String fechaVenta)
    {
        this.FechaVenta = fechaVenta;
    }
    
    public String getFechaVenta()
    {
        return FechaVenta;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMain = new javax.swing.JPanel();
        PanelDatos = new javax.swing.JPanel();
        LNumVenta = new javax.swing.JLabel();
        LNombreVendedor = new javax.swing.JLabel();
        TNumVenta = new javax.swing.JTextField();
        LFechaVenta = new javax.swing.JLabel();
        TFechaVenta = new javax.swing.JTextField();
        JCVendedor = new javax.swing.JComboBox();
        JCAnulado = new javax.swing.JCheckBox();
        PanelDetalleVenta = new javax.swing.JPanel();
        ScrollPane = new javax.swing.JScrollPane();
        TablaDetalleVenta = new org.jdesktop.swingx.JXTable();
        PanelButtons = new javax.swing.JPanel();
        BAgregar = new javax.swing.JButton();
        BEliminarFila = new javax.swing.JButton();
        BElminarTodo = new javax.swing.JButton();
        PanelDetalleCostos = new org.jdesktop.swingx.JXTitledPanel();
        LSubtotal = new javax.swing.JLabel();
        LSubTotalText = new javax.swing.JLabel();
        LIVA = new javax.swing.JLabel();
        LIVAText = new javax.swing.JLabel();
        LTotal = new javax.swing.JLabel();
        LTotalText = new javax.swing.JLabel();
        PaneXButtons = new javax.swing.JPanel();
        BNuevo = new javax.swing.JButton();
        BGuardar = new javax.swing.JButton();
        Anular = new javax.swing.JButton();
        LLogoVentas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        LFondo = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        MArchivo = new javax.swing.JMenu();
        MINuevo = new javax.swing.JMenuItem();
        MICargos = new javax.swing.JMenuItem();
        MISalir = new javax.swing.JMenuItem();

        setTitle("Ventas");

        PanelMain.setLayout(null);

        PanelDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelDatos.setOpaque(false);
        PanelDatos.setLayout(null);

        LNumVenta.setFont(new java.awt.Font("Verdana", 1, 10));
        LNumVenta.setText("Venta Número ");
        PanelDatos.add(LNumVenta);
        LNumVenta.setBounds(20, 10, 115, 25);

        LNombreVendedor.setFont(new java.awt.Font("Verdana", 1, 10));
        LNombreVendedor.setText("Nombre Vendedor");
        PanelDatos.add(LNombreVendedor);
        LNombreVendedor.setBounds(20, 40, 115, 25);

        TNumVenta.setEditable(false);
        TNumVenta.setFont(new java.awt.Font("Verdana", 1, 12));
        TNumVenta.setForeground(new java.awt.Color(0, 0, 204));
        TNumVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PanelDatos.add(TNumVenta);
        TNumVenta.setBounds(130, 10, 160, 22);

        LFechaVenta.setFont(new java.awt.Font("Verdana", 1, 10));
        LFechaVenta.setText("Fecha de la Venta");
        PanelDatos.add(LFechaVenta);
        LFechaVenta.setBounds(305, 10, 101, 25);

        TFechaVenta.setEditable(false);
        TFechaVenta.setFont(new java.awt.Font("Verdana", 1, 12));
        TFechaVenta.setForeground(new java.awt.Color(0, 0, 204));
        TFechaVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PanelDatos.add(TFechaVenta);
        TFechaVenta.setBounds(410, 10, 110, 22);

        JCVendedor.setFont(new java.awt.Font("Verdana", 1, 12));
        JCVendedor.setForeground(new java.awt.Color(0, 0, 204));
        JCVendedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1" }));
        PanelDatos.add(JCVendedor);
        JCVendedor.setBounds(130, 40, 240, 25);

        JCAnulado.setFont(new java.awt.Font("Verdana", 1, 10));
        JCAnulado.setText("Anulada");
        JCAnulado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JCAnulado.setOpaque(false);
        JCAnulado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCAnuladoActionPerformed(evt);
            }
        });
        PanelDatos.add(JCAnulado);
        JCAnulado.setBounds(370, 40, 140, 23);

        PanelMain.add(PanelDatos);
        PanelDatos.setBounds(20, 20, 540, 90);

        PanelDetalleVenta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Detalle de Venta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("BankGothic Lt BT", 1, 12), new java.awt.Color(0, 0, 204)));
        PanelDetalleVenta.setOpaque(false);
        PanelDetalleVenta.setLayout(null);

        TablaDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód Product", "Nombre", "Presentación", "Precio", "Cantidad", "Sub Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaDetalleVenta.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TablaDetalleVenta.setFont(new java.awt.Font("Verdana", 0, 11));
        ScrollPane.setViewportView(TablaDetalleVenta);

        PanelDetalleVenta.add(ScrollPane);
        ScrollPane.setBounds(30, 30, 480, 180);

        PanelButtons.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelButtons.setOpaque(false);

        BAgregar.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));
        BAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        BAgregar.setText("Agregar");
        BAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAgregarActionPerformed(evt);
            }
        });
        PanelButtons.add(BAgregar);

        BEliminarFila.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));
        BEliminarFila.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editdelete.png"))); // NOI18N
        BEliminarFila.setText("Eliminar");
        BEliminarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEliminarFilaActionPerformed(evt);
            }
        });
        PanelButtons.add(BEliminarFila);

        BElminarTodo.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));
        BElminarTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shoppingRemove.png"))); // NOI18N
        BElminarTodo.setText("Eliminar Todo");
        BElminarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BElminarTodoActionPerformed(evt);
            }
        });
        PanelButtons.add(BElminarTodo);

        PanelDetalleVenta.add(PanelButtons);
        PanelButtons.setBounds(30, 230, 480, 40);

        PanelMain.add(PanelDetalleVenta);
        PanelDetalleVenta.setBounds(20, 130, 540, 300);

        PanelDetalleCostos.setTitle("Detalle de Costo");
        PanelDetalleCostos.setTitleFont(new java.awt.Font("Verdana", 1, 10));
        PanelDetalleCostos.getContentContainer().setLayout(null);

        LSubtotal.setFont(new java.awt.Font("Verdana", 1, 10));
        LSubtotal.setText("Sub Total C$");
        PanelDetalleCostos.getContentContainer().add(LSubtotal);
        LSubtotal.setBounds(10, 10, 80, 25);

        LSubTotalText.setFont(new java.awt.Font("Verdana", 1, 10));
        LSubTotalText.setForeground(new java.awt.Color(102, 102, 102));
        LSubTotalText.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelDetalleCostos.getContentContainer().add(LSubTotalText);
        LSubTotalText.setBounds(100, 10, 90, 25);

        LIVA.setFont(new java.awt.Font("Verdana", 1, 10));
        LIVA.setText("IVA %");
        PanelDetalleCostos.getContentContainer().add(LIVA);
        LIVA.setBounds(201, 10, 39, 25);

        LIVAText.setFont(new java.awt.Font("Verdana", 1, 10));
        LIVAText.setForeground(new java.awt.Color(102, 102, 102));
        LIVAText.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelDetalleCostos.getContentContainer().add(LIVAText);
        LIVAText.setBounds(250, 10, 90, 25);

        LTotal.setFont(new java.awt.Font("Verdana", 1, 10));
        LTotal.setText("Total C$");
        PanelDetalleCostos.getContentContainer().add(LTotal);
        LTotal.setBounds(360, 10, 50, 25);

        LTotalText.setFont(new java.awt.Font("Verdana", 1, 10));
        LTotalText.setForeground(new java.awt.Color(102, 102, 102));
        LTotalText.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelDetalleCostos.getContentContainer().add(LTotalText);
        LTotalText.setBounds(410, 10, 90, 25);

        PanelMain.add(PanelDetalleCostos);
        PanelDetalleCostos.setBounds(180, 440, 540, 80);

        PaneXButtons.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PaneXButtons.setOpaque(false);
        com.l2fprod.common.swing.PercentLayout percentLayout1 = new com.l2fprod.common.swing.PercentLayout();
        percentLayout1.setOrientation(1);
        percentLayout1.setGap(5);
        PaneXButtons.setLayout(percentLayout1);

        BNuevo.setFont(new java.awt.Font("Verdana", 1, 10));
        BNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DocumentBlank.png"))); // NOI18N
        BNuevo.setText("Nuevo");
        BNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNuevoActionPerformed(evt);
            }
        });
        PaneXButtons.add(BNuevo);

        BGuardar.setFont(new java.awt.Font("Verdana", 1, 10));
        BGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        BGuardar.setText("Guardar");
        BGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGuardarActionPerformed(evt);
            }
        });
        PaneXButtons.add(BGuardar);

        Anular.setFont(new java.awt.Font("Verdana", 1, 10));
        Anular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.png"))); // NOI18N
        Anular.setText("Anular");
        PaneXButtons.add(Anular);

        PanelMain.add(PaneXButtons);
        PaneXButtons.setBounds(580, 20, 140, 90);

        LLogoVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LLogoVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/titles/VentasLogo.png"))); // NOI18N
        PanelMain.add(LLogoVentas);
        LLogoVentas.setBounds(620, 140, 60, 290);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Technical Support.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelMain.add(jLabel1);
        jLabel1.setBounds(24, 440, 130, 80);

        LFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wallpapers/shell_bar.png"))); // NOI18N
        PanelMain.add(LFondo);
        LFondo.setBounds(0, 0, 740, 550);

        getContentPane().add(PanelMain, java.awt.BorderLayout.CENTER);

        MenuBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        MArchivo.setForeground(new java.awt.Color(51, 102, 0));
        MArchivo.setText("Archivo");
        MArchivo.setFont(new java.awt.Font("Papyrus", 1, 12));

        MINuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        MINuevo.setFont(new java.awt.Font("Papyrus", 1, 12));
        MINuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DocumentBlank.png"))); // NOI18N
        MINuevo.setText("Nuevo Venta");
        MINuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MINuevoActionPerformed(evt);
            }
        });
        MArchivo.add(MINuevo);

        MICargos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        MICargos.setFont(new java.awt.Font("Papyrus", 1, 12));
        MICargos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WindowsExplorer.png"))); // NOI18N
        MICargos.setText("Búsqueda de Venta");
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

        setBounds(100, 20, 749, 601);
    }// </editor-fold>//GEN-END:initComponents
    
     public void setCodVenta(int cod)
    {
        this.CodVenta = cod;
    }
    
    public int getCodVenta()
    {
        return CodVenta;
    }
    
    public void changePositionTopLeft()
    {
     if(x == 680) {
            x = 580;
            changePositionTopLeft();
        } else {
            x += 1;
            LLogoVentas.setBounds(x,140,60,290);           
        }
    }
    
    public String getDate(int i)
    {
    String Fecha = null; 
    int dia = 0, mes = 0, año = 0;
    calendar= Calendar.getInstance();
    dia = calendar.get(calendar.DAY_OF_MONTH); mes = calendar.get(calendar.MONTH) + 1; año = calendar.get(calendar.YEAR);
    
    if( i == 0)
        Fecha = año+"-"+ValidarFecha(dia)+"-"+ValidarFecha(mes);
    else
        Fecha = ValidarFecha(dia)+"-"+ValidarFecha(mes)+"-"+año;
    return Fecha;
    }
    
    public String ValidarFecha(int fecha)
    {
        String fechavalida = null;
        if(fecha < 10)
            fechavalida = "0"+fecha; 
        else
            fechavalida = String.valueOf(fecha);
        return fechavalida;
    }

    
    private void JCAnuladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCAnuladoActionPerformed
        
}//GEN-LAST:event_JCAnuladoActionPerformed

    private void BAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAgregarActionPerformed
        JDetailSales detalleVenta = new JDetailSales();
        PanelEmperador.desktopPane.add(detalleVenta);
        detalleVenta.setVisible(true);
        detalleVenta.setClosable(true);
        detalleVenta.toFront();
        
    }//GEN-LAST:event_BAgregarActionPerformed

    private void MINuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MINuevoActionPerformed
        
    }//GEN-LAST:event_MINuevoActionPerformed

    private void MICargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MICargosActionPerformed
        
        int confir = 0; 
        cant = null;
        do {
            try {

                cant = null;
                confir = 0;
                do {
                    cant = JOptionPane.showInputDialog(null, "Digite el Número de la Venta : ", " Requerimientos de Datos", JOptionPane.QUESTION_MESSAGE);
                } while (cant.length() == 0);
            } catch (Exception p) {
            }

            char[] cadena = cant.toCharArray();

            for (int i = 0; i <= (cant.length() - 1); i++) {
                if ((cadena[i] == '0' || cadena[i] == '1' || cadena[i] == '2' || cadena[i] == '3' || cadena[i] == '4' || cadena[i] == '5' || cadena[i] == '6' || cadena[i] == '7' || cadena[i] == '8' || cadena[i] == '9')) {
                    confir = confir + 1;
                }

                System.out.println("Caracter[ " + i + " ]=" + cadena[i]);
            }
        } while (confir != cant.length());
        
        setCodVenta(Integer.parseInt(cant));
        ConnectSales.LoadDataSale(getCodVenta());
        int fila = JSales.TablaDetalleVenta.getRowCount(); 
                     
        for(int i = 0; i < fila; i++)
             {
                 Float subtotal = Float.parseFloat(String.valueOf(TablaDetalleVenta.getValueAt(i, 2)))*Float.parseFloat(String.valueOf(TablaDetalleVenta.getValueAt(i, 3)));
                 TablaDetalleVenta.setValueAt(String.valueOf(subtotal), i, 4);
                 System.out.println("Subtotal"+subtotal);
             }            
             JSales.TablaDetalleVenta.packAll();
             JSales.TablaDetalleVenta.packTable(20);
        
    }//GEN-LAST:event_MICargosActionPerformed

    private void MISalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MISalirActionPerformed
    PanelEmperador.HypVentas.setEnabled(true);
    this.dispose();
    }//GEN-LAST:event_MISalirActionPerformed

    private void BEliminarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEliminarFilaActionPerformed
        DefaultTableModel  model = (DefaultTableModel)TablaDetalleVenta.getModel();       
        model.removeRow(TablaDetalleVenta.getRowCount() - 1);
        TablaDetalleVenta.setModel(model);
        MostrarSubtotal();
        
    }//GEN-LAST:event_BEliminarFilaActionPerformed

    private void BElminarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BElminarTodoActionPerformed
        TablaDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
            "Código Producto", "Nombre", "Presentación", "Precio", "Cantidad", "Sub Total"
        }) {

            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        
        setSubTotal(0);
        LSubTotalText.setText(" "); LIVAText.setText(" "); LTotalText.setText(String.valueOf(" "));
    }//GEN-LAST:event_BElminarTodoActionPerformed

    private void BGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGuardarActionPerformed
        int NumFilas = TablaDetalleVenta.getRowCount();
        
        if(NumFilas == 0)
        {
            Utils.MyDialog("Por favor agregue un Producto al Detalle de Venta", "Información del Sistema - Ventas", "icontexto-webdev-alert-032x032.png", "Infected.wav");
        }
        else
        {
             setCodEmpleado(ConnectEmployees.getCodEmpleado(String.valueOf(JCVendedor.getSelectedItem())));
             setFechaVenta(getDate(0));
             System.out.println("Cod Empleado "+getCodEmpleado()+"  Fecha : "+getFechaVenta()+" Fila "+NumFilas);
             ConnectSales.SaveSale(getCodEmpleado(), getFechaVenta());
             
             for(int i = 0; i < NumFilas; i++)
             {
                 ConnectSales.SaveDetailSale(Integer.parseInt(String.valueOf(TablaDetalleVenta.getValueAt(i, 0))), Integer.parseInt(String.valueOf(TablaDetalleVenta.getValueAt(i, 4))));
             }   
        }      
       
    }//GEN-LAST:event_BGuardarActionPerformed

    private void BNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNuevoActionPerformed
       TablaDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
            "Código Producto", "Nombre", "Presentación", "Precio", "Cantidad", "Sub Total"
        }) {

            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        
        setSubTotal(0);
        LSubTotalText.setText(" "); LIVAText.setText(" "); LTotalText.setText(String.valueOf(" "));
    }//GEN-LAST:event_BNuevoActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Anular;
    private javax.swing.JButton BAgregar;
    private javax.swing.JButton BEliminarFila;
    private javax.swing.JButton BElminarTodo;
    private javax.swing.JButton BGuardar;
    private javax.swing.JButton BNuevo;
    private javax.swing.JCheckBox JCAnulado;
    public static javax.swing.JComboBox JCVendedor;
    private javax.swing.JLabel LFechaVenta;
    private javax.swing.JLabel LFondo;
    private javax.swing.JLabel LIVA;
    public static javax.swing.JLabel LIVAText;
    private javax.swing.JLabel LLogoVentas;
    private javax.swing.JLabel LNombreVendedor;
    private javax.swing.JLabel LNumVenta;
    public static javax.swing.JLabel LSubTotalText;
    private javax.swing.JLabel LSubtotal;
    private javax.swing.JLabel LTotal;
    public static javax.swing.JLabel LTotalText;
    private javax.swing.JMenu MArchivo;
    private javax.swing.JMenuItem MICargos;
    private javax.swing.JMenuItem MINuevo;
    private javax.swing.JMenuItem MISalir;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JPanel PaneXButtons;
    private javax.swing.JPanel PanelButtons;
    private javax.swing.JPanel PanelDatos;
    private org.jdesktop.swingx.JXTitledPanel PanelDetalleCostos;
    private javax.swing.JPanel PanelDetalleVenta;
    private javax.swing.JPanel PanelMain;
    private javax.swing.JScrollPane ScrollPane;
    public static javax.swing.JTextField TFechaVenta;
    public static javax.swing.JTextField TNumVenta;
    public static org.jdesktop.swingx.JXTable TablaDetalleVenta;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    
}
