/*
 * PanelEmperador.java
 *
 * Created on 03 de agosto de 2008, 05:13 PM
 */

package interfacegraphic;

import interfacegraphic.humanresources.JEmployees;
import interfacegraphic.products.JProducts;
import interfacegraphic.sales.JSales;
import interfacegraphicsuppliers.JSuppliers;
import java.util.Calendar;
import javax.swing.JInternalFrame;
import org.jdesktop.swingx.JXHyperlink;


public class PanelEmperador extends javax.swing.JPanel implements Runnable {
    public Calendar calendar;
    public String time;
    public int hours, minutes, seconds;
    public  Thread SuperThread;
    int x = 0, x1 = 420;
    public PanelEmperador() {
        initComponents();       
        SuperThread = new Thread(this);
        SuperThread.start();
    }
  
    public void run() {
        while (true) {
            try {
                changePositionTop();
                changePositionLow();
                Thread.sleep(10);
                calendar = Calendar.getInstance();

                hours = calendar.get(calendar.HOUR_OF_DAY);
                minutes = calendar.get(calendar.MINUTE);
                seconds = calendar.get(calendar.SECOND);

                time = validateHour() + ":" + validateMinutes() + ":" + validateSeconds();
                LTime.setText(time);

            } catch (InterruptedException e) {
                System.out.println("Exception de SuperHilo");
            }
        }
    }

    public void changePositionTop() {

        if (x == LFarmacia.getWidth() + 110) {
            x = -20;
            changePositionTop();
            LFarmacia.setForeground(new java.awt.Color(102, 102, 255));
        } else {
            x += 1;
            LFarmacia.setBounds(x, 10, 310, 100);
            if (x > 100 && x < 300) {
                LFarmacia.setForeground(new java.awt.Color(102, 0, 0));
            } else if (x > 300) {
                LFarmacia.setForeground(new java.awt.Color(51, 102, 0));
            }
            LFarmacia.setOpaque(false);
        }
    }
     
    public void changePositionLow() {

        if (x1 == 0) {
            x1 = 420;
            changePositionLow();
            LJNeuroSoft.setForeground(new java.awt.Color(102, 102, 255));
        } else {
            x1 -= 1;
            LJNeuroSoft.setBounds(x1, 50, 310, 60);
            if (x1 > 100 && x1 < 300) {
                LJNeuroSoft.setForeground(new java.awt.Color(102, 0, 0));
            } else if (x1 > 300) {
                LJNeuroSoft.setForeground(new java.awt.Color(51, 102, 0));
            }
            LJNeuroSoft.setOpaque(false);
        }
    }

    public int validateHour() {
        if (hours == 0) {
            this.hours = 12;
        } else if (hours > 12) {
            this.hours = hours - 12;
        }
        return hours;
    }

    public String validateSeconds() {
        String second;
        if (seconds < 10) {
            second = "0" + seconds;
        } else {
            second = String.valueOf(seconds);
        }
        return second;
    }    
    
    public String validateMinutes()
    {
      String minute;
        if (minutes < 10) {
            minute = "0" + minutes;
        } else {
            minute = String.valueOf(minutes);
        }
        return minute;
    } 
    
    public void ConfigurationJInternal(JInternalFrame internalFrame, JXHyperlink link) {
        PanelEmperador.desktopPane.add(internalFrame);
        internalFrame.setVisible(true);
        internalFrame.setClosable(false);
        internalFrame.setMaximizable(false);
        internalFrame.toFront();
        link.setEnabled(false);
    }
     
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SplitMayor = new javax.swing.JSplitPane();
        SplitMenor = new javax.swing.JSplitPane();
        PanelTaskPane = new javax.swing.JPanel();
        TaskPaneContainer = new org.jdesktop.swingx.JXTaskPaneContainer();
        TaskPaneRRHH = new org.jdesktop.swingx.JXTaskPane();
        HypEmpleados = new org.jdesktop.swingx.JXHyperlink();
        HypPlanilla = new org.jdesktop.swingx.JXHyperlink();
        HypControlAsistencia = new org.jdesktop.swingx.JXHyperlink();
        HypDeducciones = new org.jdesktop.swingx.JXHyperlink();
        TaskPaneInventario = new org.jdesktop.swingx.JXTaskPane();
        HypProveedores = new org.jdesktop.swingx.JXHyperlink();
        HypProductos = new org.jdesktop.swingx.JXHyperlink();
        HypCompraCont = new org.jdesktop.swingx.JXHyperlink();
        HypNotasCred = new org.jdesktop.swingx.JXHyperlink();
        HypVentas = new org.jdesktop.swingx.JXHyperlink();
        HypDevoluciones = new org.jdesktop.swingx.JXHyperlink();
        HypReposiciones = new org.jdesktop.swingx.JXHyperlink();
        HypVencimientoProd = new org.jdesktop.swingx.JXHyperlink();
        TaskPaneFlujoCaja = new org.jdesktop.swingx.JXTaskPane();
        HypIngresos = new org.jdesktop.swingx.JXHyperlink();
        HypGastos = new org.jdesktop.swingx.JXHyperlink();
        HypPagos = new org.jdesktop.swingx.JXHyperlink();
        LogoFarmacia = new javax.swing.JLabel();
        desktopPane = new javax.swing.JDesktopPane();
        DesktopPanel = new javax.swing.JPanel();
        LFarmacia = new javax.swing.JLabel();
        LJNeuroSoft = new javax.swing.JLabel();
        StatusBar = new org.jdesktop.swingx.JXStatusBar();
        LTime = new javax.swing.JLabel();
        LUser = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        LFondoFrame = new javax.swing.JLabel();
        RightPanel = new javax.swing.JPanel();
        RightLabel = new javax.swing.JLabel();

        setLayout(null);

        SplitMayor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        SplitMayor.setDividerLocation(260);
        SplitMayor.setForeground(new java.awt.Color(51, 51, 51));
        SplitMayor.setAutoscrolls(true);
        SplitMayor.setContinuousLayout(true);
        SplitMayor.setOneTouchExpandable(true);

        SplitMenor.setBackground(new java.awt.Color(255, 255, 255));
        SplitMenor.setDividerLocation(520);
        SplitMenor.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        PanelTaskPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelTaskPane.setLayout(null);

        TaskPaneContainer.setPreferredSize(new java.awt.Dimension(135, 500));
        com.l2fprod.common.swing.PercentLayout percentLayout1 = new com.l2fprod.common.swing.PercentLayout();
        percentLayout1.setGap(14);
        percentLayout1.setOrientation(1);
        TaskPaneContainer.setLayout(percentLayout1);

        TaskPaneRRHH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/task/Login Manager.png"))); // NOI18N
        TaskPaneRRHH.setTitle("Recursos Humanos");

        HypEmpleados.setForeground(new java.awt.Color(51, 51, 51));
        HypEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hyperlink/Empleados.png"))); // NOI18N
        HypEmpleados.setText("Empleados");
        HypEmpleados.setClickedColor(new java.awt.Color(51, 51, 51));
        HypEmpleados.setFont(new java.awt.Font("Papyrus", 1, 12));
        HypEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HypEmpleadosMouseClicked(evt);
            }
        });
        HypEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HypEmpleadosActionPerformed(evt);
            }
        });
        TaskPaneRRHH.getContentPane().add(HypEmpleados);

        HypPlanilla.setForeground(new java.awt.Color(51, 51, 51));
        HypPlanilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hyperlink/Planilla.png"))); // NOI18N
        HypPlanilla.setText("Planilla");
        HypPlanilla.setClickedColor(new java.awt.Color(51, 51, 51));
        HypPlanilla.setFont(new java.awt.Font("Papyrus", 1, 12));
        HypPlanilla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HypPlanillaMouseClicked(evt);
            }
        });
        TaskPaneRRHH.getContentPane().add(HypPlanilla);

        HypControlAsistencia.setForeground(new java.awt.Color(51, 51, 51));
        HypControlAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hyperlink/Asistencia.png"))); // NOI18N
        HypControlAsistencia.setText("Control de Asistencia");
        HypControlAsistencia.setClickedColor(new java.awt.Color(51, 51, 51));
        HypControlAsistencia.setFont(new java.awt.Font("Papyrus", 1, 12));
        HypControlAsistencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HypControlAsistenciaMouseClicked(evt);
            }
        });
        TaskPaneRRHH.getContentPane().add(HypControlAsistencia);

        HypDeducciones.setForeground(new java.awt.Color(51, 51, 51));
        HypDeducciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hyperlink/Deducciones.png"))); // NOI18N
        HypDeducciones.setText("Deducciones");
        HypDeducciones.setClickedColor(new java.awt.Color(51, 51, 51));
        HypDeducciones.setFont(new java.awt.Font("Papyrus", 1, 12));
        HypDeducciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HypDeduccionesMouseClicked(evt);
            }
        });
        TaskPaneRRHH.getContentPane().add(HypDeducciones);

        TaskPaneContainer.add(TaskPaneRRHH);

        TaskPaneInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/task/outlook-outbox.gif"))); // NOI18N
        TaskPaneInventario.setTitle("Control de Inventario");

        HypProveedores.setForeground(new java.awt.Color(51, 51, 51));
        HypProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hyperlink/Proveedores.png"))); // NOI18N
        HypProveedores.setText("Proveedores");
        HypProveedores.setClickedColor(new java.awt.Color(51, 51, 51));
        HypProveedores.setFont(new java.awt.Font("Papyrus", 1, 12));
        HypProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HypProveedoresActionPerformed(evt);
            }
        });
        TaskPaneInventario.getContentPane().add(HypProveedores);

        HypProductos.setForeground(new java.awt.Color(51, 51, 51));
        HypProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hyperlink/Productos.png"))); // NOI18N
        HypProductos.setText("Productos");
        HypProductos.setClickedColor(new java.awt.Color(51, 51, 51));
        HypProductos.setFont(new java.awt.Font("Papyrus", 1, 12));
        HypProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HypProductosActionPerformed(evt);
            }
        });
        TaskPaneInventario.getContentPane().add(HypProductos);

        HypCompraCont.setForeground(new java.awt.Color(51, 51, 51));
        HypCompraCont.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hyperlink/Compra Contado.PNG"))); // NOI18N
        HypCompraCont.setText("Compras al Contado");
        HypCompraCont.setClickedColor(new java.awt.Color(51, 51, 51));
        HypCompraCont.setFont(new java.awt.Font("Papyrus", 1, 12));
        TaskPaneInventario.getContentPane().add(HypCompraCont);

        HypNotasCred.setForeground(new java.awt.Color(51, 51, 51));
        HypNotasCred.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hyperlink/Nota Credito.png"))); // NOI18N
        HypNotasCred.setText("Notas de Créditos");
        HypNotasCred.setClickedColor(new java.awt.Color(51, 51, 51));
        HypNotasCred.setFont(new java.awt.Font("Papyrus", 1, 12));
        TaskPaneInventario.getContentPane().add(HypNotasCred);

        HypVentas.setForeground(new java.awt.Color(51, 51, 51));
        HypVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hyperlink/Ventas.png"))); // NOI18N
        HypVentas.setText("Ventas");
        HypVentas.setClickedColor(new java.awt.Color(51, 51, 51));
        HypVentas.setFont(new java.awt.Font("Papyrus", 1, 12));
        HypVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HypVentasActionPerformed(evt);
            }
        });
        TaskPaneInventario.getContentPane().add(HypVentas);

        HypDevoluciones.setForeground(new java.awt.Color(51, 51, 51));
        HypDevoluciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hyperlink/Devoluciones.png"))); // NOI18N
        HypDevoluciones.setText("Devoluciones");
        HypDevoluciones.setClickedColor(new java.awt.Color(51, 51, 51));
        HypDevoluciones.setFont(new java.awt.Font("Papyrus", 1, 12));
        TaskPaneInventario.getContentPane().add(HypDevoluciones);

        HypReposiciones.setForeground(new java.awt.Color(51, 51, 51));
        HypReposiciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hyperlink/OtrasEntradas.png"))); // NOI18N
        HypReposiciones.setText("Otras Entradas Productos");
        HypReposiciones.setClickedColor(new java.awt.Color(51, 51, 51));
        HypReposiciones.setFont(new java.awt.Font("Papyrus", 1, 12));
        TaskPaneInventario.getContentPane().add(HypReposiciones);

        HypVencimientoProd.setForeground(new java.awt.Color(51, 51, 51));
        HypVencimientoProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hyperlink/VencimientoProductos.png"))); // NOI18N
        HypVencimientoProd.setText("Productos Próximo a Vencer");
        HypVencimientoProd.setClickedColor(new java.awt.Color(51, 51, 51));
        HypVencimientoProd.setFont(new java.awt.Font("Papyrus", 1, 12));
        TaskPaneInventario.getContentPane().add(HypVencimientoProd);

        TaskPaneContainer.add(TaskPaneInventario);

        TaskPaneFlujoCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/task/medical+money.png"))); // NOI18N
        TaskPaneFlujoCaja.setTitle("Flujo de Dinero en Caja");

        HypIngresos.setForeground(new java.awt.Color(51, 51, 51));
        HypIngresos.setText("Ingresos");
        HypIngresos.setClickedColor(new java.awt.Color(51, 51, 51));
        HypIngresos.setFont(new java.awt.Font("Papyrus", 1, 12));
        TaskPaneFlujoCaja.getContentPane().add(HypIngresos);

        HypGastos.setForeground(new java.awt.Color(51, 51, 51));
        HypGastos.setText("Gastos");
        HypGastos.setClickedColor(new java.awt.Color(51, 51, 51));
        HypGastos.setFont(new java.awt.Font("Papyrus", 1, 12));
        TaskPaneFlujoCaja.getContentPane().add(HypGastos);

        HypPagos.setForeground(new java.awt.Color(51, 51, 51));
        HypPagos.setText("Pagos de Notas de Créditos");
        HypPagos.setClickedColor(new java.awt.Color(51, 51, 51));
        HypPagos.setFont(new java.awt.Font("Papyrus", 1, 12));
        TaskPaneFlujoCaja.getContentPane().add(HypPagos);

        TaskPaneContainer.add(TaskPaneFlujoCaja);

        PanelTaskPane.add(TaskPaneContainer);
        TaskPaneContainer.setBounds(0, 0, 260, 520);

        SplitMenor.setLeftComponent(PanelTaskPane);

        LogoFarmacia.setBackground(new java.awt.Color(255, 255, 255));
        LogoFarmacia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoFarmacia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wallpapers/Logo Farmacia.PNG"))); // NOI18N
        LogoFarmacia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255), 3));
        SplitMenor.setRightComponent(LogoFarmacia);

        SplitMayor.setLeftComponent(SplitMenor);

        DesktopPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DesktopPanel.setLayout(null);

        LFarmacia.setFont(new java.awt.Font("Zrnic", 1, 36));
        LFarmacia.setForeground(new java.awt.Color(102, 102, 255));
        LFarmacia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LFarmacia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blockdevice.png"))); // NOI18N
        LFarmacia.setText("Farmacia \"Allison\"");
        DesktopPanel.add(LFarmacia);
        LFarmacia.setBounds(0, 0, 290, 60);

        LJNeuroSoft.setFont(new java.awt.Font("Zrnic", 1, 36));
        LJNeuroSoft.setForeground(new java.awt.Color(102, 102, 255));
        LJNeuroSoft.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LJNeuroSoft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Medico.png"))); // NOI18N
        LJNeuroSoft.setText("JPharmware 2.0 ");
        DesktopPanel.add(LJNeuroSoft);
        LJNeuroSoft.setBounds(420, 0, 300, 60);

        StatusBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        StatusBar.setForeground(new java.awt.Color(102, 102, 0));
        StatusBar.setToolTipText("");

        LTime.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));
        LTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LTime.setIcon(new javax.swing.ImageIcon("C:\\JPharmware_2.0\\src\\images\\Time.png")); // NOI18N

        LUser.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));
        LUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LUser.setIcon(new javax.swing.ImageIcon("C:\\JPharmware_2.0\\src\\images\\Usuario.png")); // NOI18N
        LUser.setText("Usuario");

        jProgressBar1.setIndeterminate(true);
        jProgressBar1.setMaximumSize(new java.awt.Dimension(32767, 10));
        jProgressBar1.setMinimumSize(new java.awt.Dimension(130, 19));
        jProgressBar1.setOpaque(true);
        jProgressBar1.setPreferredSize(new java.awt.Dimension(146, 10));

        javax.swing.GroupLayout StatusBarLayout = new javax.swing.GroupLayout(StatusBar);
        StatusBar.setLayout(StatusBarLayout);
        StatusBarLayout.setHorizontalGroup(
            StatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StatusBarLayout.createSequentialGroup()
                .addComponent(LTime)
                .addGap(20, 20, 20)
                .addComponent(LUser)
                .addGap(18, 18, 18)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(330, 330, 330))
        );
        StatusBarLayout.setVerticalGroup(
            StatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StatusBarLayout.createSequentialGroup()
                .addGroup(StatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(LTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addComponent(LUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                    .addGroup(StatusBarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(2, Short.MAX_VALUE))
        );

        DesktopPanel.add(StatusBar);
        StatusBar.setBounds(5, 580, 690, 35);

        LFondoFrame.setFont(new java.awt.Font("Zrnic", 1, 36));
        LFondoFrame.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LFondoFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wallpapers/3D403.png"))); // NOI18N
        DesktopPanel.add(LFondoFrame);
        LFondoFrame.setBounds(5, 5, 690, 570);

        DesktopPanel.setBounds(0, 5, 700, 620);
        desktopPane.add(DesktopPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        RightPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        RightPanel.setLayout(new java.awt.BorderLayout());

        RightLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        RightLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wallpapers/RightImages.jpg"))); // NOI18N
        RightLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        RightPanel.add(RightLabel, java.awt.BorderLayout.CENTER);

        RightPanel.setBounds(705, 5, 520, 620);
        desktopPane.add(RightPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        SplitMayor.setRightComponent(desktopPane);

        add(SplitMayor);
        SplitMayor.setBounds(10, 5, 1500, 630);
    }// </editor-fold>//GEN-END:initComponents

    private void HypPlanillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HypPlanillaMouseClicked
        HypEmpleados.setSelected(false); HypPlanilla.setSelected(true); HypControlAsistencia.setSelected(false); HypDeducciones.setSelected(false);
    }//GEN-LAST:event_HypPlanillaMouseClicked

    private void HypControlAsistenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HypControlAsistenciaMouseClicked
        HypEmpleados.setSelected(false); HypPlanilla.setSelected(false); HypControlAsistencia.setSelected(true); HypDeducciones.setSelected(false);
    }//GEN-LAST:event_HypControlAsistenciaMouseClicked

    private void HypDeduccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HypDeduccionesMouseClicked
        HypEmpleados.setSelected(false); HypPlanilla.setSelected(false); HypControlAsistencia.setSelected(false); HypDeducciones.setSelected(true);
    }//GEN-LAST:event_HypDeduccionesMouseClicked

    private void HypProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HypProveedoresActionPerformed
        JSuppliers Suppliers = new JSuppliers();
        ConfigurationJInternal(Suppliers,HypProveedores);
    }//GEN-LAST:event_HypProveedoresActionPerformed

    private void HypProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HypProductosActionPerformed
       JProducts Products = new JProducts();
       ConfigurationJInternal(Products,HypProductos);     
}//GEN-LAST:event_HypProductosActionPerformed

    private void HypVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HypVentasActionPerformed
       JSales Sales = new JSales();
       ConfigurationJInternal(Sales,HypVentas);           
    }//GEN-LAST:event_HypVentasActionPerformed

    private void HypEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HypEmpleadosMouseClicked
        // TODO add your handling code here:
}//GEN-LAST:event_HypEmpleadosMouseClicked

    private void HypEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HypEmpleadosActionPerformed
       JEmployees Employees = new JEmployees();
       ConfigurationJInternal(Employees,HypEmpleados);
}//GEN-LAST:event_HypEmpleadosActionPerformed
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DesktopPanel;
    public static org.jdesktop.swingx.JXHyperlink HypCompraCont;
    public static org.jdesktop.swingx.JXHyperlink HypControlAsistencia;
    public static org.jdesktop.swingx.JXHyperlink HypDeducciones;
    public static org.jdesktop.swingx.JXHyperlink HypDevoluciones;
    public static org.jdesktop.swingx.JXHyperlink HypEmpleados;
    private org.jdesktop.swingx.JXHyperlink HypGastos;
    private org.jdesktop.swingx.JXHyperlink HypIngresos;
    public static org.jdesktop.swingx.JXHyperlink HypNotasCred;
    private org.jdesktop.swingx.JXHyperlink HypPagos;
    public static org.jdesktop.swingx.JXHyperlink HypPlanilla;
    public static org.jdesktop.swingx.JXHyperlink HypProductos;
    public static org.jdesktop.swingx.JXHyperlink HypProveedores;
    public static org.jdesktop.swingx.JXHyperlink HypReposiciones;
    public static org.jdesktop.swingx.JXHyperlink HypVencimientoProd;
    public static org.jdesktop.swingx.JXHyperlink HypVentas;
    public static javax.swing.JLabel LFarmacia;
    public static javax.swing.JLabel LFondoFrame;
    public static javax.swing.JLabel LJNeuroSoft;
    private javax.swing.JLabel LTime;
    public static javax.swing.JLabel LUser;
    private javax.swing.JLabel LogoFarmacia;
    private javax.swing.JPanel PanelTaskPane;
    private javax.swing.JLabel RightLabel;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JSplitPane SplitMayor;
    private javax.swing.JSplitPane SplitMenor;
    private org.jdesktop.swingx.JXStatusBar StatusBar;
    private org.jdesktop.swingx.JXTaskPaneContainer TaskPaneContainer;
    private org.jdesktop.swingx.JXTaskPane TaskPaneFlujoCaja;
    private org.jdesktop.swingx.JXTaskPane TaskPaneInventario;
    private org.jdesktop.swingx.JXTaskPane TaskPaneRRHH;
    public static javax.swing.JDesktopPane desktopPane;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
    
}
