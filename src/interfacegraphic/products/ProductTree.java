/*
 * ProductTree.java
 *
 * Created on 19 de agosto de 2008, 11:12 PM
 */

package interfacegraphic.products;

import conectivity.ConnectProducts;
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
public class ProductTree extends javax.swing.JInternalFrame {
    public static String NameProduct = null, Presentation = null;
    public static int CodProduct = 0;
    
  
    public ProductTree() {
        initComponents();
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WindowsExplorer.png")));
        TreeProducto.setModel(ConnectProducts.LoadProductsTree());               
  
        TreeCellRenderer renderer = new IconCellRenderer();
        TreeProducto.setCellRenderer(renderer);
        TreeProducto.setShowsRootHandles(true);   
        
        TreeProducto.addTreeSelectionListener(new TreeSelectionListener() 
        {
         public void valueChanged(TreeSelectionEvent e)
         {
         DefaultMutableTreeNode Nodo = (DefaultMutableTreeNode)(e.getPath().getLastPathComponent());
         Object NameNodo = Nodo.getUserObject();
         
         if(Nodo.isLeaf())
             {                             
               LCodproducto.setText("Cód Producto: "+ConnectProducts.getCodProducto(getNameProduct(String.valueOf(NameNodo)),getNamePresentation(String.valueOf(NameNodo))));
               setNameProduct(getNameProduct(String.valueOf(NameNodo)));
               setPresentation(getNamePresentation(String.valueOf(NameNodo)));
         }
         }     
        });
        
     setNameProduct(null);
    }
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMain = new javax.swing.JPanel();
        ScrollPane = new javax.swing.JScrollPane();
        TreeProducto = new javax.swing.JTree();
        BAceptar = new javax.swing.JButton();
        BCancelar = new javax.swing.JButton();
        LCodproducto = new javax.swing.JLabel();
        LBLfondo = new javax.swing.JLabel();

        setTitle("Búsqueda de Producto en el Sistema");

        PanelMain.setLayout(null);

        ScrollPane.setForeground(new java.awt.Color(0, 0, 204));

        TreeProducto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TreeProducto.setFont(new java.awt.Font("Verdana", 1, 12));
        TreeProducto.setForeground(new java.awt.Color(0, 0, 204));
        ScrollPane.setViewportView(TreeProducto);

        PanelMain.add(ScrollPane);
        ScrollPane.setBounds(0, 0, 230, 190);

        BAceptar.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));
        BAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/aceptar.png"))); // NOI18N
        BAceptar.setText("Aceptar");
        BAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAceptarActionPerformed(evt);
            }
        });
        PanelMain.add(BAceptar);
        BAceptar.setBounds(235, 40, 120, 30);

        BCancelar.setFont(new java.awt.Font("BankGothic Lt BT", 1, 12));
        BCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.png"))); // NOI18N
        BCancelar.setLabel("Cancelar");
        BCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelarActionPerformed(evt);
            }
        });
        PanelMain.add(BCancelar);
        BCancelar.setBounds(235, 90, 120, 30);

        LCodproducto.setFont(new java.awt.Font("Verdana", 1, 12));
        LCodproducto.setForeground(new java.awt.Color(0, 0, 204));
        LCodproducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelMain.add(LCodproducto);
        LCodproducto.setBounds(240, 150, 120, 30);

        LBLfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shell_bar.png"))); // NOI18N
        LBLfondo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelMain.add(LBLfondo);
        LBLfondo.setBounds(190, 0, 190, 190);

        getContentPane().add(PanelMain, java.awt.BorderLayout.CENTER);

        setBounds(100, 100, 375, 218);
    }// </editor-fold>//GEN-END:initComponents

    private void BAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAceptarActionPerformed
        if(getNameProduct() == null) {
            Utils.MyDialog("Selecione un Producto","Información del Sistema","Error.png","Infected.wav");
        } else {
            this.dispose();
            ConnectProducts.LoadDataSearch(getNameProduct(),getPresentation());
            JProducts.setCodProducto(ConnectProducts.getCodProducto(getNameProduct(),getPresentation()));
            JProducts.BActualizar.setEnabled(true);
        }
    }//GEN-LAST:event_BAceptarActionPerformed
    
    public String getNamePresentation(String name)
    {
        String Pres = null; int index = 0, lenght = 0;
        index = name.indexOf(":");
        lenght = name.length();
        Pres = name.substring(index + 1,lenght);
        return Pres;
    }
    
    public String getNameProduct(String product)
    {
        String Prod = null; int index = 0, lenght = 0;
        index = product.indexOf(":");
        lenght = product.length();
        Prod = product.substring(0,index);
        return Prod;
    }
    
    public void setNameProduct(String name)
    {
        this.NameProduct = name;
    }
    
    public void setPresentation(String name)
    {
        this.Presentation = name;
    }
    
   public static String getNameProduct()
   {
    return NameProduct;
   }
    
    public static String getPresentation()
   {
    return Presentation;
   }
   
    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed
        this.dispose();
        setNameProduct(null);
    }//GEN-LAST:event_BCancelarActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAceptar;
    private javax.swing.JButton BCancelar;
    private javax.swing.JLabel LBLfondo;
    private javax.swing.JLabel LCodproducto;
    private javax.swing.JPanel PanelMain;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTree TreeProducto;
    // End of variables declaration//GEN-END:variables
    
}
