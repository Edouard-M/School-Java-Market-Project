/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CheckoutController;
import Model.Order;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Edoua
 */
public class Checkout extends javax.swing.JPanel
{
    private MyFrame myFrame;
    private Order order;
    private CheckoutController controller;
    /**
     * Creates new form Checkout
     */
    public Checkout(MyFrame myFrame)
    {
        controller = new CheckoutController();
        this.myFrame = myFrame;
        initComponents();
        setVisible(true);
        
        setTableStyle(jTable1, jScrollPane1); 
        
    }
    
    public void buildTable(JTable table)
    {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        try
        {
            String [] colNames = new String[] {"Quantity","Product","Cost (€)"};
            //System.out.println("Size : " + order.getOrderedProducts().size());
            String [][] data = new String [order.getOrderedProducts().size()][3];
            String [][] data2 = new String [3][order.getOrderedProducts().size()];
            
            for(int i=0 ; i < order.getOrderedProducts().size() ; i++)
            {
                data[i][0] = String.valueOf(order.getOrderedProducts().get(i).getQuantity());
                data[i][1] = String.valueOf(order.getOrderedProducts().get(i).getProductName());
                data[i][2] = String.valueOf(order.getOrderedProducts().get(i).getPrice());
                        
                data2[0][i] = data[i][0];
                data2[1][i] = data[i][1];
                data2[2][i] = data[i][2];
            }
            tableModel.setDataVector(data, colNames);
            TableColumnModel cartColumnModel = table.getColumnModel();
            cartColumnModel.getColumn(0).setPreferredWidth(70);
            cartColumnModel.getColumn(1).setPreferredWidth(100);
            cartColumnModel.getColumn(2).setPreferredWidth(75);       
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        labelTotal.setText(String.valueOf(order.totalCost()) + " €");
    }
    
    
    
    public void setTableStyle(JTable tableStyle, JScrollPane scrollStyle)
    {
        TableColumnModel cartColumnModel = tableStyle.getColumnModel();
        cartColumnModel.getColumn(0).setPreferredWidth(70);
        cartColumnModel.getColumn(1).setPreferredWidth(100);
        cartColumnModel.getColumn(2).setPreferredWidth(75);
        
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
        tableStyle.getTableHeader().setBackground(new Color(77,128,216));
        //tableStyle.getTableHeader().setBackground(new Color(23,35,55));
        tableStyle.getTableHeader().setForeground(new Color(255,255,255));
        tableStyle.getTableHeader().setFont(new Font("Sergoe UI", Font.PLAIN, 12));
        
        tableStyle.setPreferredSize(new Dimension(310, 310-22));
        scrollStyle.setBackground(new Color(62,120,207));
    }
    
    public void setOrder(Order ord)
    {
        this.order = ord;
        buildTable(jTable1);
        
        labelCost.setText(labelTotal.getText());
        labelEmail.setText(order.getEmail());
        boolean bool = controller.findCustomer(order.getEmail());
        if(bool)
        {
            labelFirstname.setText(controller.getCustFirstName());
            labelName.setText(controller.getCustName());
            labelPhone.setText(controller.getCustPhone());
            labelAdress.setText(controller.getCustAdress());
        }
    }

  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        paypal = new javax.swing.JLabel();
        paypal1 = new javax.swing.JLabel();
        labelCost = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelFirstname = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        labelAdress = new javax.swing.JLabel();
        labelPhone = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1130, 650));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(62, 120, 207));
        jPanel1.setPreferredSize(new java.awt.Dimension(1130, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paypal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paypal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/paypalB.png"))); // NOI18N
        paypal.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                paypalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                paypalMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                paypalMousePressed(evt);
            }
        });
        jPanel1.add(paypal, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 450, 230, 48));

        paypal1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paypal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/payement.png"))); // NOI18N
        jPanel1.add(paypal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 520, 300, 90));

        labelCost.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        labelCost.setForeground(new java.awt.Color(255, 255, 255));
        labelCost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCost.setText("0 €");
        jPanel1.add(labelCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 380, 320, 30));

        labelEmail.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        labelEmail.setForeground(new java.awt.Color(255, 255, 255));
        labelEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEmail.setText("Email");
        jPanel1.add(labelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 520, 30));

        labelFirstname.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        labelFirstname.setForeground(new java.awt.Color(255, 255, 255));
        labelFirstname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFirstname.setText("FirstName");
        jPanel1.add(labelFirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 320, 30));

        labelName.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        labelName.setForeground(new java.awt.Color(255, 255, 255));
        labelName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelName.setText("Name");
        jPanel1.add(labelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, 320, 30));

        labelAdress.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        labelAdress.setForeground(new java.awt.Color(255, 255, 255));
        labelAdress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAdress.setText("Adress");
        jPanel1.add(labelAdress, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, 520, 30));

        labelPhone.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        labelPhone.setForeground(new java.awt.Color(255, 255, 255));
        labelPhone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPhone.setText("Phone");
        jPanel1.add(labelPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, 320, 30));

        labelTotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(255, 255, 255));
        labelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTotal.setText("50 €");
        jPanel1.add(labelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 530, 140, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Wondershop");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 320, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Checkout");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 320, 40));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(62, 120, 207), 1, true));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 402));

        jTable1.setBackground(new java.awt.Color(62, 120, 207));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Quantity", "Product", "Price"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(23, 35, 55));
        jTable1.setRowHeight(22);
        jTable1.setSelectionBackground(new java.awt.Color(23, 35, 55));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0)
        {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 310, 310));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total cost :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 530, -1, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Your current cart");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/testFond.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 650));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Checkout");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 320, 50));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void paypalMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_paypalMousePressed
    {//GEN-HEADEREND:event_paypalMousePressed

        try
        {
            Desktop.getDesktop().browse(new URI("https://www.paypal.com/signin"));
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        
        
        controller.insertAllOrder(order);
        controller.updateStock(order);
        
        myFrame.checkoutComplete();     
    }//GEN-LAST:event_paypalMousePressed

    private void paypalMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_paypalMouseEntered
    {//GEN-HEADEREND:event_paypalMouseEntered
        paypal.setIcon(new ImageIcon("src/Image/paypalJ.png"));  
    }//GEN-LAST:event_paypalMouseEntered

    private void paypalMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_paypalMouseExited
    {//GEN-HEADEREND:event_paypalMouseExited
        paypal.setIcon(new ImageIcon("src/Image/paypalB.png"));  
    }//GEN-LAST:event_paypalMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelAdress;
    private javax.swing.JLabel labelCost;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelFirstname;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelPhone;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel paypal;
    private javax.swing.JLabel paypal1;
    // End of variables declaration//GEN-END:variables
}
