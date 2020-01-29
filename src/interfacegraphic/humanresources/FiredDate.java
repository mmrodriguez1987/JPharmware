/*
 * FiredDate.java
 *
 * Created on 13 de agosto de 2008, 01:11 AM
 */

package interfacegraphic.humanresources;

import conectivity.ConnectEmployees;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import utilities.Utils;

/**
 *
 * @author  Elvin Gregorio
 */
public class FiredDate extends javax.swing.JInternalFrame {
    private String DateSQL;
    private int p;
    /** Creates new form FiredDate */
    public FiredDate() {
        initComponents();
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lista.png")));
        ConnectEmployees.LoadEmployeesCombo();
    }
    
   public String getDateCalendar()
    {
      setDateSQL(null);
      String Day = combofecha.getSelectedDay();
      String Month = combofecha.getSelectedMonth();      
      String Year = combofecha.getSelectedYear();
     
      setDateSQL(Year+"-"+Day+"-"+Month);
      return Day+"-"+Month+"-"+Year;
     }
   
   public void setDateSQL(String dateSQL)
    {
        this.DateSQL = dateSQL;
    }
   
   public String getDateSQL()
   {
        return DateSQL; 
   }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panelfondo = new javax.swing.JPanel();
        lblselccionempleado = new javax.swing.JLabel();
        combofecha = new org.gui.JCalendarCombo();
        lblfecha = new javax.swing.JLabel();
        JCEmpleado = new javax.swing.JComboBox();
        BAceptar = new javax.swing.JButton();
        BCancelar = new javax.swing.JButton();
        lblfondo1 = new javax.swing.JLabel();

        setResizable(true);
        setTitle("Dar de Baja Empleado");

        Panelfondo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Panelfondo.setLayout(null);

        lblselccionempleado.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));
        lblselccionempleado.setText("Seleccione el Empleado");
        Panelfondo.add(lblselccionempleado);
        lblselccionempleado.setBounds(10, 15, 180, 25);

        combofecha.setFont(new java.awt.Font("Verdana", 1, 12));
        Panelfondo.add(combofecha);
        combofecha.setBounds(260, 55, 102, 25);

        lblfecha.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));
        lblfecha.setText("Seleccione la Fecha de Despido");
        Panelfondo.add(lblfecha);
        lblfecha.setBounds(10, 55, 240, 25);

        Panelfondo.add(JCEmpleado);
        JCEmpleado.setBounds(190, 15, 170, 25);

        BAceptar.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));
        BAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/aceptar.png"))); // NOI18N
        BAceptar.setText("Aceptar");
        BAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAceptarActionPerformed(evt);
            }
        });
        Panelfondo.add(BAceptar);
        BAceptar.setBounds(50, 95, 120, 30);

        BCancelar.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));
        BCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.png"))); // NOI18N
        BCancelar.setText("Cancelar");
        BCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelarActionPerformed(evt);
            }
        });
        Panelfondo.add(BCancelar);
        BCancelar.setBounds(200, 95, 120, 30);

        lblfondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shell_bar.png"))); // NOI18N
        Panelfondo.add(lblfondo1);
        lblfondo1.setBounds(0, 0, 390, 150);

        getContentPane().add(Panelfondo, java.awt.BorderLayout.CENTER);

        setBounds(100, 100, 396, 165);
    }// </editor-fold>//GEN-END:initComponents

    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed
       this.dispose();
}//GEN-LAST:event_BCancelarActionPerformed

    private void BAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAceptarActionPerformed
          String objButtons[] = {"Si","No"};
       Utils.PlaySound("popUp.wav");
	int message = JOptionPane.showOptionDialog(this, "Está Seguro de Despedir a esta persona??", "JPharmware_2.0", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			new ImageIcon(getClass().getResource("/images/Interrogacion.png")), objButtons, objButtons[1]);
		
		if(message == 0)
                {
                    int CodEmpleado = ConnectEmployees.getCodEmpleado(String.valueOf(JCEmpleado.getSelectedItem()));     
                    ConnectEmployees.LoadDataSearch(CodEmpleado);
                    JEmployees.PanelDespido.setVisible(true);
                    JEmployees.TFechaEgreso.setText(getDateCalendar());
                    ConnectEmployees.FireEmployee(CodEmpleado,getDateSQL());
                    this.dispose();
                }
                else
                    this.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);          
}//GEN-LAST:event_BAceptarActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAceptar;
    private javax.swing.JButton BCancelar;
    public static javax.swing.JComboBox JCEmpleado;
    private javax.swing.JPanel Panelfondo;
    public static org.gui.JCalendarCombo combofecha;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblfondo1;
    private javax.swing.JLabel lblselccionempleado;
    // End of variables declaration//GEN-END:variables
    
}
