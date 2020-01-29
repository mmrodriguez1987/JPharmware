
package interfacegraphic.sales;

import conectivity.ConnectDetailSales;
import conectivity.ConnectProducts;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import utilities.Utils;

public class JDetailSales extends javax.swing.JInternalFrame {
public static int CodProveedor, CodProducto, CodProdProv, FilaSeleccionada = 0, CantidadVendida, Existencias;
public static String NombreProd, Presentacion,FechaVencimiento;
public static float PrecioVenta;

    public JDetailSales() {
        initComponents();
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fullbasket.png")));
        ConnectDetailSales.CargarJCProveedor();
        TablaDatosProd.packAll();
        TablaDatosProd.packTable(40);
    }
    
    public void setCodProveedor(int cod)
    {
        this.CodProveedor = cod;
    }
    
    public int getCodProveedor()
    {
        return CodProveedor;
    }
  
    public void setCodProducto(int cod)
    {
        this.CodProducto = cod;
    }
    
    public int getCodProducto()
    {
        return CodProducto;
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
    
    public void setFilaSeleccionada(int fila)
    {
        this.FilaSeleccionada = fila;
    }
    
    public int getFilaSeleccionada()
    {
        return FilaSeleccionada;
    }
    
    public void setCantidadVendida(int cant)
    {
        this.CantidadVendida = cant;
    }
    
    public int getCantidadVendida()
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
    
    public void setExistencias(int exist)
    {
        this.Existencias = exist;
    }
    
    public int getExistencias()
    {
        return Existencias;
    }
    
    public void setFechaVencimiento(String fecha)
    {
        this.FechaVencimiento = fecha;
    }
    
    public String getFechaVencimiento()
    {
        return FechaVencimiento;
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMain = new javax.swing.JPanel();
        PanelProvProd = new org.jdesktop.swingx.JXTitledPanel();
        LProv = new javax.swing.JLabel();
        JCProveedor = new javax.swing.JComboBox();
        BCargarDatos = new javax.swing.JButton();
        PanelButtons = new javax.swing.JPanel();
        LCodProducto = new javax.swing.JLabel();
        TCodProv = new javax.swing.JTextField();
        LCantidad = new javax.swing.JLabel();
        TCantidad = new javax.swing.JTextField();
        BAgregarDetalle = new javax.swing.JButton();
        BSalir = new javax.swing.JButton();
        PanelDatosProd = new org.jdesktop.swingx.JXTitledPanel();
        ScrollPane = new javax.swing.JScrollPane();
        TablaDatosProd = new org.jdesktop.swingx.JXTable();
        LFondo = new javax.swing.JLabel();

        setTitle("Búsqueda de Productos ");

        PanelMain.setLayout(null);

        PanelProvProd.setTitle("Seleccione un Producto y el Proveedor que lo oferta");
        PanelProvProd.setTitleFont(new java.awt.Font("Verdana", 1, 10));
        PanelProvProd.getContentContainer().setLayout(null);

        LProv.setFont(new java.awt.Font("Verdana", 1, 10));
        LProv.setText("Proveedor");
        PanelProvProd.getContentContainer().add(LProv);
        LProv.setBounds(10, 25, 80, 25);

        JCProveedor.setFont(new java.awt.Font("Verdana", 1, 10));
        JCProveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1" }));
        PanelProvProd.getContentContainer().add(JCProveedor);
        JCProveedor.setBounds(90, 25, 220, 25);

        BCargarDatos.setFont(new java.awt.Font("Verdana", 1, 10));
        BCargarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WindowsExplorer.png"))); // NOI18N
        BCargarDatos.setText("Cargar Productos");
        BCargarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCargarDatosActionPerformed(evt);
            }
        });
        PanelProvProd.getContentContainer().add(BCargarDatos);
        BCargarDatos.setBounds(65, 70, 220, 25);

        PanelMain.add(PanelProvProd);
        PanelProvProd.setBounds(20, 25, 330, 150);

        PanelButtons.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelButtons.setOpaque(false);
        PanelButtons.setLayout(null);

        LCodProducto.setFont(new java.awt.Font("Verdana", 1, 10));
        LCodProducto.setText("Código Proveedor:");
        PanelButtons.add(LCodProducto);
        LCodProducto.setBounds(10, 15, 110, 25);

        TCodProv.setEditable(false);
        TCodProv.setFont(new java.awt.Font("Verdana", 1, 10));
        TCodProv.setForeground(new java.awt.Color(0, 0, 204));
        TCodProv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PanelButtons.add(TCodProv);
        TCodProv.setBounds(120, 15, 80, 25);

        LCantidad.setFont(new java.awt.Font("Verdana", 1, 10));
        LCantidad.setText("Cantidad");
        PanelButtons.add(LCantidad);
        LCantidad.setBounds(210, 15, 60, 25);

        TCantidad.setEditable(false);
        TCantidad.setFont(new java.awt.Font("Verdana", 1, 10));
        TCantidad.setForeground(new java.awt.Color(0, 0, 204));
        TCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TCantidadKeyTyped(evt);
            }
        });
        PanelButtons.add(TCantidad);
        TCantidad.setBounds(270, 15, 150, 25);

        BAgregarDetalle.setFont(new java.awt.Font("Verdana", 1, 10));
        BAgregarDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/aceptar.png"))); // NOI18N
        BAgregarDetalle.setText("Agregar Detalle");
        BAgregarDetalle.setEnabled(false);
        BAgregarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAgregarDetalleActionPerformed(evt);
            }
        });
        PanelButtons.add(BAgregarDetalle);
        BAgregarDetalle.setBounds(440, 15, 160, 25);

        BSalir.setFont(new java.awt.Font("Verdana", 1, 10));
        BSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Shutdown.png"))); // NOI18N
        BSalir.setText("Salir");
        BSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSalirActionPerformed(evt);
            }
        });
        PanelButtons.add(BSalir);
        BSalir.setBounds(610, 15, 120, 25);

        PanelMain.add(PanelButtons);
        PanelButtons.setBounds(20, 190, 740, 60);

        PanelDatosProd.setTitle("Detalle de los Datos del Producto");
        PanelDatosProd.setTitleFont(new java.awt.Font("Verdana", 1, 10));
        PanelDatosProd.getContentContainer().setLayout(new java.awt.BorderLayout());

        ScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        ScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        TablaDatosProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Producto", "Presentación", "Categoría", "Precio de Venta", "Existencias de Lotes", "Existencias al Detalles", "Fecha Vencimiento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaDatosProd.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TablaDatosProd.setFont(new java.awt.Font("Verdana", 0, 10));
        TablaDatosProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDatosProdMouseClicked(evt);
            }
        });
        ScrollPane.setViewportView(TablaDatosProd);

        PanelDatosProd.getContentContainer().add(ScrollPane, java.awt.BorderLayout.CENTER);

        PanelMain.add(PanelDatosProd);
        PanelDatosProd.setBounds(370, 25, 390, 150);

        LFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wallpapers/shell_bar.png"))); // NOI18N
        PanelMain.add(LFondo);
        LFondo.setBounds(0, 0, 800, 270);

        getContentPane().add(PanelMain, java.awt.BorderLayout.CENTER);

        setBounds(80, 140, 791, 295);
    }// </editor-fold>//GEN-END:initComponents

    private void BCargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCargarDatosActionPerformed
       TCodProv.setText(String.valueOf(ConnectDetailSales.getCodProveedor(String.valueOf(JCProveedor.getSelectedItem()))));
       setCodProveedor(ConnectDetailSales.getCodProveedor(String.valueOf(JCProveedor.getSelectedItem())));//GEN-LAST:event_BCargarDatosActionPerformed
       ConnectDetailSales.CargarTablaDatosProd(getCodProveedor());  
       BAgregarDetalle.setEnabled(true); 
}

    private void BSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSalirActionPerformed
      this.dispose();
}//GEN-LAST:event_BSalirActionPerformed

    private void TCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCantidadKeyTyped
       char c = evt.getKeyChar();       
        if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE)))
            evt.consume();
    }//GEN-LAST:event_TCantidadKeyTyped

    private void TablaDatosProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDatosProdMouseClicked
       TCantidad.setEditable(true);
       setFilaSeleccionada(TablaDatosProd.getSelectedRow()); 
       setNombreProd(String.valueOf(TablaDatosProd.getValueAt(getFilaSeleccionada(),0)));
       setPresentacion(String.valueOf(TablaDatosProd.getValueAt(getFilaSeleccionada(),1)));
       setCodProducto(ConnectProducts.getCodProducto(getNombreProd(), getPresentacion()));
       setCodProdProv(ConnectDetailSales.getCodProdProv(getCodProducto(), getCodProveedor()));
       setPrecioVenta(Float.parseFloat(String.valueOf(TablaDatosProd.getValueAt(getFilaSeleccionada(),3))));
       setExistencias(Integer.parseInt(String.valueOf(TablaDatosProd.getValueAt(getFilaSeleccionada(),5))));
       setFechaVencimiento(String.valueOf(TablaDatosProd.getValueAt(getFilaSeleccionada(),6)));
//       System.out.println(getFilaSeleccionada()+"    "+getNombreProd()+"     "+getPresentacion()+" Prov "+getCodProveedor()+" Prod "+getCodProducto()+" ProdProv "+getCodProdProv()+" Precio de Venta "+getPrecioVenta()+" Existencias "+getExistencias());
    }//GEN-LAST:event_TablaDatosProdMouseClicked

    private void BAgregarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAgregarDetalleActionPerformed
        String Cantidad = TCantidad.getText();
        
        if(Cantidad.length() == 0)
        {
            Utils.MyDialog("Por favor digite la cantidad a vender", "Información del Sistema", "Error.png", "Infected.wav");
        }
        else
        {
            setCantidadVendida(Integer.parseInt(TCantidad.getText()));
            if(getCantidadVendida() > getExistencias())
            {
             Utils.MyDialog("La cantidad a vender no puede mayor que las exitencias del Producto", "Información del Sistema - Inventario", "Error.png", "Infected.wav");
            }
            else
            {
                DefaultTableModel  model = (DefaultTableModel)JSales.TablaDetalleVenta.getModel();
                Vector vector = new Vector();
                vector.add(getCodProdProv());
                vector.add(getNombreProd());
                vector.add(getPresentacion());
                vector.add(getPrecioVenta());
                vector.add(getCantidadVendida());
                vector.add(Float.parseFloat(String.valueOf(getCantidadVendida()))*getPrecioVenta());
                model.addRow(vector);
                JSales.TablaDetalleVenta.setModel(model);
                JSales.TablaDetalleVenta.packAll();
                JSales.TablaDetalleVenta.packTable(20);
                JSales.MostrarSubtotal();          
                this.dispose();
            }
            System.out.println(getCantidadVendida());        
        }
        
    }//GEN-LAST:event_BAgregarDetalleActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAgregarDetalle;
    private javax.swing.JButton BCargarDatos;
    private javax.swing.JButton BSalir;
    public static javax.swing.JComboBox JCProveedor;
    private javax.swing.JLabel LCantidad;
    private javax.swing.JLabel LCodProducto;
    private javax.swing.JLabel LFondo;
    private javax.swing.JLabel LProv;
    private javax.swing.JPanel PanelButtons;
    private org.jdesktop.swingx.JXTitledPanel PanelDatosProd;
    private javax.swing.JPanel PanelMain;
    private org.jdesktop.swingx.JXTitledPanel PanelProvProd;
    private javax.swing.JScrollPane ScrollPane;
    public javax.swing.JTextField TCantidad;
    public javax.swing.JTextField TCodProv;
    public static org.jdesktop.swingx.JXTable TablaDatosProd;
    // End of variables declaration//GEN-END:variables
    
}
