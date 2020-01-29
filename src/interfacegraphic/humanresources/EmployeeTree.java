/*
 * EmployeeTree.java
 *
 * Created on 13 de agosto de 2008, 11:18 AM
 */

package interfacegraphic.humanresources;

import conectivity.ConnectEmployees;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import treeConfiguration.treeIcon.IconCellRenderer;
import utilities.Utils;

/**
 *
 * @author  Elvin Gregorio
 */
public class EmployeeTree extends javax.swing.JInternalFrame {
    
    public static String NameEmployee = null;
    public static int CodEmployee = 0;

    public EmployeeTree() {
        initComponents();
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cargos.png")));
        TreeEmpleado.setModel(ConnectEmployees.LoadEmployeesTree());               
  
        TreeCellRenderer renderer = new IconCellRenderer();
        TreeEmpleado.setCellRenderer(renderer);
        TreeEmpleado.setShowsRootHandles(true);   
        
        TreeEmpleado.addTreeSelectionListener(new TreeSelectionListener() 
        {
         public void valueChanged(TreeSelectionEvent e)
         {
         DefaultMutableTreeNode Nodo = (DefaultMutableTreeNode)(e.getPath().getLastPathComponent());
         Object NameNodo = Nodo.getUserObject();
         
         if(Nodo.isLeaf())
             {              
               setNameEmployee(String.valueOf(NameNodo));
               LCodEmpleado.setText("Cód Empleado: "+ConnectEmployees.getCodEmpleado(getNameEmployee()));
             }
         }     
        });
        
        setNameEmployee(null);
    }
    
    public void setNameEmployee(String name)
    {
        this.NameEmployee = name;
    }
    
   public static String getNameEmployee()
   {
    return NameEmployee;
   }
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMain = new javax.swing.JPanel();
        ScrollPane = new javax.swing.JScrollPane();
        TreeEmpleado = new javax.swing.JTree();
        BAceptar = new javax.swing.JButton();
        BCancelar = new javax.swing.JButton();
        LCodEmpleado = new javax.swing.JLabel();
        LBLfondo = new javax.swing.JLabel();

        setTitle("Búsqueda de Empleados");

        PanelMain.setLayout(null);

        ScrollPane.setForeground(new java.awt.Color(0, 0, 204));

        TreeEmpleado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TreeEmpleado.setFont(new java.awt.Font("Verdana", 1, 12));
        TreeEmpleado.setForeground(new java.awt.Color(0, 0, 204));
        ScrollPane.setViewportView(TreeEmpleado);

        PanelMain.add(ScrollPane);
        ScrollPane.setBounds(0, 0, 210, 190);

        BAceptar.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));
        BAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/aceptar.png"))); // NOI18N
        BAceptar.setText("Aceptar");
        BAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAceptarActionPerformed(evt);
            }
        });
        PanelMain.add(BAceptar);
        BAceptar.setBounds(225, 40, 120, 30);

        BCancelar.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));
        BCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.png"))); // NOI18N
        BCancelar.setLabel("Cancelar");
        BCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelarActionPerformed(evt);
            }
        });
        PanelMain.add(BCancelar);
        BCancelar.setBounds(225, 90, 120, 30);

        LCodEmpleado.setFont(new java.awt.Font("Verdana", 1, 12));
        LCodEmpleado.setForeground(new java.awt.Color(0, 0, 204));
        LCodEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelMain.add(LCodEmpleado);
        LCodEmpleado.setBounds(210, 150, 150, 30);

        LBLfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shell_bar.png"))); // NOI18N
        LBLfondo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelMain.add(LBLfondo);
        LBLfondo.setBounds(190, 0, 190, 190);

        getContentPane().add(PanelMain, java.awt.BorderLayout.CENTER);

        setBounds(100, 100, 375, 218);
    }// </editor-fold>//GEN-END:initComponents

    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed
        this.dispose();
        setNameEmployee(null);
}//GEN-LAST:event_BCancelarActionPerformed

    private void BAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAceptarActionPerformed
        
        if(getNameEmployee() == null)
        {
            Utils.MyDialog("Selecione un Empleado","Información del Sistema","Error.png","Infected.wav");
        }
         else
         { 
            this.dispose();
            ConnectEmployees.LoadDataSearch(ConnectEmployees.getCodEmpleado(getNameEmployee()));
            JEmployees.setCodEmployee(ConnectEmployees.getCodEmpleado(getNameEmployee()));
            JEmployees.BActualizar.setEnabled(true);
         }   
    }//GEN-LAST:event_BAceptarActionPerformed
 
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAceptar;
    private javax.swing.JButton BCancelar;
    private javax.swing.JLabel LBLfondo;
    private javax.swing.JLabel LCodEmpleado;
    private javax.swing.JPanel PanelMain;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTree TreeEmpleado;
    // End of variables declaration//GEN-END:variables
    
}
