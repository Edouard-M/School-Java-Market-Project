/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ManageDiscountController;
import Model.Discount;
import Model.Product;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author dwans
 */
public class ManageDiscount extends javax.swing.JPanel
{
private DefaultTableModel tableModel1;
private DefaultTableModel tableModel2;
private ArrayList<Product> allProductsList;
private ArrayList<Discount> allDiscountList;
private String productName;
private String discountName;
private TableColumnModel columnModel;
private ManageDiscountController controller;

    /**
     * Creates new form ManageDiscount
     */
    public ManageDiscount()
    {
      controller = new ManageDiscountController();
        initComponents();
    }
  public void buildPanel() throws Exception
    {
       
        
        
        String[][] data = controller.findDataProduct();
            String[] colNamesFilter =
            {
                "Name", "Category", "Description", "Price", "Stock"
            };
            String[][] dataFilter = new String[data.length][5];
            for (int i = 0; i < data.length; i++)
            {
                dataFilter[i][0] = data[i][0];
                dataFilter[i][1] = data[i][1];
                dataFilter[i][2] = data[i][2];
                dataFilter[i][3] = data[i][3];
                dataFilter[i][4] = data[i][4];
                
            }
            
          
        
     
        
        tableModel1 =  (DefaultTableModel) jTable1.getModel();
   
        
        tableModel1.setDataVector(data, colNamesFilter);

        jTable1.getSelectionModel().addListSelectionListener(new ManageDiscount.TableListener());
        
        columnModel = jTable1.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(220);
        columnModel.getColumn(3).setPreferredWidth(50);
        columnModel.getColumn(4).setPreferredWidth(50);
        
       
        setTableStyle(jTable1);
         jScrollPane1.setBackground(new Color(53,63,74));
        
        jTable1.setPreferredSize(new Dimension(310, 285));
        jTable1.getTableHeader().setBackground(new Color(53,63,74));
        jTable1.getTableHeader().setForeground(new Color(255,255,255));
        jTable1.getTableHeader().setFont(new Font("Sergoe UI", Font.PLAIN, 14));
        
       
        String [] colNames2 = controller.findColNameDiscount();
        String [][] data2 = controller.findDataDiscount();
       
     
        
        tableModel2 =  (DefaultTableModel) jTable2.getModel();
        
        
        tableModel2.setDataVector(data2, colNames2);
        
        jTable2.getSelectionModel().addListSelectionListener(new ManageDiscount.TableListener2());
        
        TableColumnModel columnModel2 = jTable2.getColumnModel();
        columnModel2.getColumn(0).setPreferredWidth(100);
        columnModel2.getColumn(1).setPreferredWidth(50);
        columnModel2.getColumn(2).setPreferredWidth(150);
        //("iciiii");
       
        setTableStyle(jTable2);
        jScrollPane2.setBackground(new Color(49,91,111));
        
        jTable2.setPreferredSize(new Dimension(310, 295));
        jTable2.getTableHeader().setBackground(new Color(49,91,111));
        jTable2.getTableHeader().setForeground(new Color(255,255,255));
        jTable2.getTableHeader().setFont(new Font("Sergoe UI", Font.PLAIN, 14));
       
    }
  
   public void setTableStyle(JTable tableStyle)
    {
        JTableHeader tableHeader=tableStyle.getTableHeader();
        tableHeader.setOpaque(true);
        tableHeader.setBackground(new Color(255, 255, 255));
        tableHeader.setForeground(new Color(0, 0, 0));
        Border lineborder = BorderFactory.createLineBorder(Color.WHITE, 1); 
        Border border = BorderFactory.createRaisedSoftBevelBorder();
        Border border2 = BorderFactory.createBevelBorder(1, new Color(235,235,235), new Color(255,255,255));
        Border border3 = BorderFactory.createEtchedBorder(new Color(235,235,235), new Color(255,255,255));
        
        tableHeader.setFont(new Font("Sergoe UI", Font.PLAIN, 12));
        tableStyle.setFont(new Font("Sergeo UI", Font.PLAIN, 12));
      
       
        tableHeader.setBorder(border3);
    }
  public class TableListener implements ListSelectionListener 
    {
       
        @Override
        public void valueChanged(ListSelectionEvent e)
        {
           int viewRow = jTable1.getSelectedRow();
           if(viewRow>=0)
           { productName = (String) jTable1.getValueAt(viewRow, 0);}    
        }
    }
  public class TableListener2 implements ListSelectionListener 
    {
       
        @Override
        public void valueChanged(ListSelectionEvent e)
        {
           int viewRow = jTable2.getSelectedRow();
           if(viewRow>=0)
           {discountName = (String) jTable2.getValueAt(viewRow, 0);}
        }
    }
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1130, 650));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(49, 91, 111));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(53, 63, 74)));

        jTable1.setBackground(new java.awt.Color(53, 63, 74));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4", "null"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionBackground(new java.awt.Color(49, 91, 111));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(610, 140, 452, 310);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Price");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(720, 480, 100, 20);

        jPanel3.setBackground(new java.awt.Color(53, 63, 74));
        jPanel3.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Create Discount");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(0, 0, 150, 50);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/button.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jLabel5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jLabel5MousePressed(evt);
            }
        });
        jPanel3.add(jLabel5);
        jLabel5.setBounds(0, 0, 150, 50);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(880, 490, 150, 60);

        jPanel2.setBackground(new java.awt.Color(49, 91, 111));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Delete");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 0, 150, 50);

        jLabel3.setBackground(new java.awt.Color(49, 91, 111));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/button.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jLabel3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jLabel3MousePressed(evt);
            }
        });
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, 0, 150, 50);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(350, 500, 150, 50);

        jTextField2.setBackground(new java.awt.Color(53, 63, 74));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setBorder(null);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(590, 500, 90, 33);

        jTextField3.setBackground(new java.awt.Color(53, 63, 74));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setBorder(null);
        jTextField3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3);
        jTextField3.setBounds(720, 500, 100, 33);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(720, 538, 80, 2);

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(590, 540, 90, 2);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Delete Discount");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(90, 40, 320, 60);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Select a product to add discount");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(590, 560, 360, 30);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(49, 91, 111)));

        jTable2.setBackground(new java.awt.Color(49, 91, 111));
        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jTable2.setSelectionBackground(new java.awt.Color(53, 63, 74));
        jTable2.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable2.setShowHorizontalLines(false);
        jTable2.setShowVerticalLines(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(70, 140, 370, 320);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Quantity");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(590, 480, 100, 20);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Create Discount");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(660, 40, 320, 60);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Select a discount to delete");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(50, 520, 290, 20);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/fondEmployee.png"))); // NOI18N
        jPanel1.add(jLabel10);
        jLabel10.setBounds(50, 0, 1130, 650);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 650));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField3ActionPerformed
    {//GEN-HEADEREND:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel3MouseEntered
    {//GEN-HEADEREND:event_jLabel3MouseEntered
        jLabel3.setIcon(new ImageIcon("src/Image/buttonClicked.png"));// TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel3MouseExited
    {//GEN-HEADEREND:event_jLabel3MouseExited
        jLabel3.setIcon(new ImageIcon("src/Image/button.png")); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel3MousePressed
    {//GEN-HEADEREND:event_jLabel3MousePressed
    try
    {
        
        controller.EraseDiscount(discountName);// TODO add your handling code here:
         String[] colNames = controller.findColNameDiscount();
            String[][] data = controller.findDataDiscount();
            
            tableModel2.setDataVector(data, colNames);
            columnModel = jTable2.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(100);
            columnModel.getColumn(1).setPreferredWidth(50);
            columnModel.getColumn(2).setPreferredWidth(150);
            columnModel.getColumn(3).setPreferredWidth(50);
            columnModel.getColumn(4).setPreferredWidth(50);
            
    } catch (Exception ex)
    {
        System.out.println(ex);
    }
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel5MouseEntered
    {//GEN-HEADEREND:event_jLabel5MouseEntered
        jLabel5.setIcon(new ImageIcon("src/Image/buttonClicked.png"));// TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel5MouseExited
    {//GEN-HEADEREND:event_jLabel5MouseExited
         jLabel5.setIcon(new ImageIcon("src/Image/button.png"));
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel5MousePressed
    {//GEN-HEADEREND:event_jLabel5MousePressed
    try
    {
       
        Discount discount=new Discount(productName, Integer.parseInt(jTextField2.getText()),Double.parseDouble(jTextField3.getText()));
    discount.insertDiscount();
    String[] colNames = controller.findColNameDiscount();
            String[][] data = controller.findDataDiscount();
           
            tableModel2.setDataVector(data, colNames);
            columnModel = jTable2.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(100);
            columnModel.getColumn(1).setPreferredWidth(50);
            columnModel.getColumn(2).setPreferredWidth(150);
            columnModel.getColumn(3).setPreferredWidth(50);
            columnModel.getColumn(4).setPreferredWidth(50);
    //Window2 wind = new Window2();
// TODO add your handling code here:
    } catch (Exception ex)
    {
        System.out.println(ex);
    }
    }//GEN-LAST:event_jLabel5MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
