/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static Model.DAO.*;
import Model.Discount;
import Model.Order;
import Model.OrderedProduct;
import Model.Product;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import static java.awt.SystemColor.window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Edoua
 */
public class Home extends javax.swing.JPanel
{
    
    final int WIDTH_WINDOW = 800;
    final int HEIGHT_WINDOW = 700;
    
    private Order order;
    private ArrayList<Product> allProductsList;
    private DefaultTableModel cartModel;
    private DefaultTableModel tableModel;
    
    private JPanel panel;
    //private JTable table;
    private JLabel label;
    private ImageIcon imageIcon;
    JScrollPane scrollTable;
    
    private ImageIcon currentImageIcon;
    private String currentImage;
    private String currentName;

    /**
     * Creates new form Home
     */
    public Home() throws Exception
    {
        initComponents();
        
        order = new Order(1, "", null);
        
        //jLabel1.setIcon(new ImageIcon("src/Image/path.gif"));
        
        buildPanel();
        
        
    }
    
    public void buildPanel() throws Exception
    {
        panel = new JPanel();
        
        allProductsList = selectAllProducts();
        
        jLabel4.setText("");
        jLabel3.setText("");
        jLabel5.setText("");
        
        
        String [] colNames = getCol("Product");
        String [][] data = getLines("Product");
        
        String [] colNamesFilter = {"Name", "Category", "Description", "Stock", "Price (€)"};
        String [][] dataFilter = new String[data.length][5];
        for(int i=0 ; i < data.length ; i++)
        {
            dataFilter[i][0] = data[i][0];
            dataFilter[i][1] = data[i][1];
            dataFilter[i][2] = data[i][2];
            dataFilter[i][3] = data[i][4];
            dataFilter[i][4] = data[i][3];
        }
        
        
        cartModel = (DefaultTableModel) cartTable.getModel();
        tableModel = (DefaultTableModel) table.getModel();
        
        
        tableModel.setDataVector(dataFilter, colNamesFilter);        
        
        
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        
        table.getSelectionModel().addListSelectionListener(new Home.TableListener());
        
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(50);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(50);
        columnModel.getColumn(4).setPreferredWidth(50);
        
        TableColumnModel cartColumnModel = cartTable.getColumnModel();
        cartColumnModel.getColumn(0).setPreferredWidth(70);
        cartColumnModel.getColumn(1).setPreferredWidth(100);
        cartColumnModel.getColumn(2).setPreferredWidth(75);
        
        setTableStyle(table);
        setTableStyle(cartTable);
       
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
            int viewRow = table.getSelectedRow();
            int quantity = 0;
            
            currentName = (String) table.getValueAt(viewRow, 0);
            jTextPane1.setText((String) table.getValueAt(viewRow, 2));
            //currentImage = (String) table.getValueAt(viewRow, 5);
    
            for(int i=0 ; i < allProductsList.size() ; i++)
            {
                if(currentName.equals(allProductsList.get(i).getName()))
                    currentImage = allProductsList.get(i).getImage();
            }
            
            quantity = Integer.parseInt((String) table.getValueAt(viewRow, 3));
            Discount discount = null;
            
            
            String[] comboBox = new String[quantity+1];
            for(int i=0 ; i <= quantity ; i++)
            {
                comboBox[i] = "" + i;
            }
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(comboBox));
            
            jLabel10.setText("0 €");
            
            try
            {
                discount = searchDiscount(currentName);
                if(discount != null)
                {
                    jLabel4.setText("BUY "+ discount.getQuantity() + " " + discount.getName());
                    jLabel3.setText("FOR");
                    jLabel5.setText("" + discount.getPrice() + " € !!");
                }
                else
                {
                    jLabel4.setText("NO DISCOUNT");
                    jLabel3.setText("");
                    jLabel5.setText("");
                }
            } catch (Exception ex)
            {
                ex.getMessage();
            }
            
            


            ImageIcon imageIcon = new ImageIcon("src/Image/" + currentImage); // load the image to a imageIcon
            Image image = imageIcon.getImage(); // transform it 
            Image newimg = image.getScaledInstance(314, 110,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            imageIcon = new ImageIcon(newimg);  // transform it back
     
            currentLabel.setIcon(imageIcon);
        }
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        currentLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(62, 120, 207));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBackground(new java.awt.Color(62, 120, 207));
        jScrollPane4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(62, 120, 207), 1, true));
        jScrollPane4.setForeground(new java.awt.Color(62, 120, 207));

        jList1.setBackground(new java.awt.Color(62, 120, 207));
        jList1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList1.setForeground(new java.awt.Color(255, 255, 255));
        jList1.setModel(new javax.swing.AbstractListModel()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jList1.setName(""); // NOI18N
        jList1.setVerifyInputWhenFocusTarget(false);
        jScrollPane4.setViewportView(jList1);

        jPanel9.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 90, 210));

        jScrollPane5.setBackground(new java.awt.Color(62, 120, 207));
        jScrollPane5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(62, 120, 207), 1, true));
        jScrollPane5.setForeground(new java.awt.Color(62, 120, 207));
        jPanel9.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jScrollPane6.setBackground(new java.awt.Color(62, 120, 207));
        jScrollPane6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(62, 120, 207), 1, true));
        jScrollPane6.setForeground(new java.awt.Color(62, 120, 207));

        jList2.setBackground(new java.awt.Color(62, 120, 207));
        jList2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList2.setForeground(new java.awt.Color(255, 255, 255));
        jList2.setModel(new javax.swing.AbstractListModel()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(jList2);

        jPanel9.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 90, 210));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cost (€)");
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 90, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Quantity");
        jPanel9.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 90, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Product");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 90, -1));

        jScrollPane7.setBackground(new java.awt.Color(62, 120, 207));
        jScrollPane7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(62, 120, 207), 1, true));
        jScrollPane7.setForeground(new java.awt.Color(62, 120, 207));

        jList3.setBackground(new java.awt.Color(62, 120, 207));
        jList3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList3.setForeground(new java.awt.Color(255, 255, 255));
        jList3.setModel(new javax.swing.AbstractListModel()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane7.setViewportView(jList3);

        jPanel9.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 90, 210));

        add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 320, 320));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        table.setBackground(new java.awt.Color(255, 255, 255));
        table.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        table.setForeground(new java.awt.Color(0, 0, 0));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String []
            {
                "0", "1", "2", "3", "4", "5", "6"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(255, 255, 255));
        table.setRowHeight(22);
        table.setSelectionBackground(new java.awt.Color(62, 120, 207));
        table.setSelectionForeground(new java.awt.Color(255, 255, 255));
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 320, 730, 320));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Quantity :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, -1, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, -1, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Price :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 280, -1, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText(" 0 €");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 280, -1, 30));

        jButton1.setBackground(new java.awt.Color(62, 120, 207));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("add to cart");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 280, -1, -1));

        jPanel2.setBackground(new java.awt.Color(62, 120, 207));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(62, 120, 207), 1, true));
        jScrollPane3.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        cartTable.setBackground(new java.awt.Color(255, 255, 255));
        cartTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cartTable.setForeground(new java.awt.Color(0, 0, 0));
        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Quantity", "Product", "Price"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        cartTable.setGridColor(new java.awt.Color(255, 255, 255));
        cartTable.setRowHeight(22);
        cartTable.setSelectionBackground(new java.awt.Color(23, 35, 55));
        cartTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(cartTable);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 310, 310));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cart Total :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, 20));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("0 €");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Remove From Cart");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, -1, -1));

        jPanel5.setBackground(new java.awt.Color(113, 168, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(23, 35, 55));
        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("FOR");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 60, 80));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("0 €");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 160, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("10");
        jLabel1.setIconTextGap(9);
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 80));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 360, 80));

        jPanel6.setBackground(new java.awt.Color(77, 128, 216));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        currentLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        currentLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        currentLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.add(currentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 314, 110));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 360, 130));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 370, 650));

        jPanel3.setBackground(new java.awt.Color(245, 247, 253));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(245, 247, 253));
        jScrollPane2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(245, 247, 253), 1, true));
        jScrollPane2.setForeground(new java.awt.Color(245, 247, 253));

        jTextPane1.setEditable(false);
        jTextPane1.setBackground(new java.awt.Color(245, 247, 253));
        jTextPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(245, 247, 253), 1, true));
        jTextPane1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(jTextPane1);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 610, 100));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 770, 140));

        jPanel4.setBackground(new java.awt.Color(62, 120, 207));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 770, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("No Discount");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 85, 30));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 650));
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBox1ActionPerformed
    {//GEN-HEADEREND:event_jComboBox1ActionPerformed

        if(jComboBox1.getSelectedIndex() >= 0)
        {
            try
            {
                String currentName = (String) table.getValueAt(table.getSelectedRow(), 0);
                double unitPrice = Double.parseDouble((String) table.getValueAt(table.getSelectedRow(), 4));
                int quantity = jComboBox1.getSelectedIndex();

                Discount discount = searchDiscount(currentName);
                double total;

                if(discount != null && discount.getQuantity() <= quantity)
                {

                    int dQuantity = discount.getQuantity();
                    double dPrice = discount.getPrice();
                    total = ((quantity%dQuantity)*unitPrice) + ((quantity-(quantity%dQuantity)) / dQuantity * dPrice);
                }
                else
                total = quantity * unitPrice;

                jLabel10.setText(String.valueOf(total) + " €");
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed

        int quantity= jComboBox1.getSelectedIndex();
        if(quantity > 0)
        {
            int viewRow = table.getSelectedRow();
            int id=0;
            int orderID=order.getId();
            String name= (String) table.getValueAt(viewRow, 0);

            double cost= (Double.parseDouble((String) table.getValueAt(table.getSelectedRow(), 4)));

            if(order.getProduct(name)!=null)
            if((quantity + order.getProduct(name).getQuantity()) > Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 3)))
            quantity = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 3)) - order.getProduct(name).getQuantity();

            if(quantity != 0)
            {
                try
                {
                    order.addOrderedProduct(new OrderedProduct(orderID, id, name, quantity, cost));
                } catch (Exception ex)
                {
                    System.out.println(ex.getMessage());
                }

                try
                {
                    String [] colNames = new String[] {"Quantity","Product","Cost (€)"};
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

                    cartModel.setDataVector(data, colNames);
                    jList1.setListData(data2[0]);
                    jList1.setListData(data2[0]);
                    

                    TableColumnModel cartColumnModel = cartTable.getColumnModel();
                    cartColumnModel.getColumn(0).setPreferredWidth(70);
                    cartColumnModel.getColumn(1).setPreferredWidth(100);
                    cartColumnModel.getColumn(2).setPreferredWidth(75);
                    
                    

                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }

                jLabel12.setText(String.valueOf(order.totalCost()) + " €");
                
                

            }
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed

        if(order.getOrderedProducts().size() > 0 && cartTable.getSelectedRow() >= 0)
        {
            int viewRow = cartTable.getSelectedRow();
            currentName = (String) cartTable.getValueAt(viewRow, 1);
            order.removeOrderedProduct(currentName);

            try
            {
                String [] colNames = new String[] {"Quantity","Product","Cost (€)"};
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
                

                cartModel.setDataVector(data, colNames);
                
                jList1.setListData(data2[0]);
                jList1.setListData(data2[0]);
                

                TableColumnModel cartColumnModel = cartTable.getColumnModel();
                cartColumnModel.getColumn(0).setPreferredWidth(70);
                cartColumnModel.getColumn(1).setPreferredWidth(100);
                cartColumnModel.getColumn(2).setPreferredWidth(75);
                jLabel12.setText(String.valueOf(order.totalCost()) + " €");
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable cartTable;
    private javax.swing.JLabel currentLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JList jList3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
