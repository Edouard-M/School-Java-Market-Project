/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.EmpPanelController;
import Model.Product;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
 */
public class EmployeesPanel extends javax.swing.JPanel
{

    private ArrayList<Product> allProductsList;
    private DefaultTableModel tableModel;
    private String currentName;
    private int quantity;
    private TableColumnModel columnModel;
    private JTableHeader tableHeader;
    private final EmpPanelController controller;

    /**
     * Creates new form EmployeesPanel
     */
    public EmployeesPanel()
    {
        controller=new EmpPanelController();
        initComponents();

    }

    public void buildPanel() throws Exception
    {



        String[][] data = controller.findData();

        String[] colNamesFilter =
        {
            "Name", "Category", "Description", "Price", "Stock", "Image"
        };
        String[][] dataFilter = new String[data.length][6];
        for (int i = 0; i < data.length; i++)
        {
            dataFilter[i][0] = data[i][0];
            dataFilter[i][1] = data[i][1];
            dataFilter[i][2] = data[i][2];
            dataFilter[i][3] = data[i][3];
            dataFilter[i][4] = data[i][4];
            dataFilter[i][5] = data[i][6];
        }

        tableModel = (DefaultTableModel) jTable1.getModel();

        tableModel.setDataVector(dataFilter, colNamesFilter);

        jTable1.getSelectionModel().addListSelectionListener(new EmployeesPanel.TableListener());

        columnModel = jTable1.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(220);
        columnModel.getColumn(3).setPreferredWidth(50);
        columnModel.getColumn(4).setPreferredWidth(50);

        setTableStyle(jTable1, jScrollPane1, new Color(49,91,111), new Color(0,0,0));
        //setTableStyle(jTable1);
         jScrollPane1.setBackground(new Color(49,91,111));
        
        //jTable1.setPreferredSize(new Dimension(310, 390-22));
        jTable1.getTableHeader().setBackground(new Color(49,91,111));
        jTable1.getTableHeader().setForeground(new Color(255,255,255));
        jTable1.getTableHeader().setFont(new Font("Sergoe UI", Font.PLAIN, 14));

    }

    /*public void setTableStyle(JTable tableStyle)
    {
        tableHeader = tableStyle.getTableHeader();
        tableHeader.setOpaque(true);
        tableHeader.setBackground(new Color(255, 255, 255));
        tableHeader.setForeground(new Color(0, 0, 0));
        Border lineborder = BorderFactory.createLineBorder(Color.WHITE, 1);
        Border border = BorderFactory.createRaisedSoftBevelBorder();
        Border border2 = BorderFactory.createBevelBorder(1, new Color(235, 235, 235), new Color(255, 255, 255));
        Border border3 = BorderFactory.createEtchedBorder(new Color(235, 235, 235), new Color(255, 255, 255));

        tableHeader.setFont(new Font("Sergoe UI", Font.PLAIN, 12));
        tableStyle.setFont(new Font("Sergeo UI", Font.PLAIN, 12));

        tableHeader.setBorder(border3);
    }*/
    
    public void setTableStyle(JTable tableStyle, JScrollPane scrollStyle, Color colorFond, Color colorHeader)
    {
        TableColumnModel cartColumnModel = tableStyle.getColumnModel();
        cartColumnModel.getColumn(0).setPreferredWidth(70);
        cartColumnModel.getColumn(1).setPreferredWidth(100);
        cartColumnModel.getColumn(2).setPreferredWidth(75);
        
        tableHeader=tableStyle.getTableHeader();
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
        tableStyle.getTableHeader().setBackground(colorHeader);
        //tableStyle.getTableHeader().setBackground(new Color(23,35,55));
        tableStyle.getTableHeader().setForeground(new Color(255,255,255));
        tableStyle.getTableHeader().setFont(new Font("Sergoe UI", Font.PLAIN, 12));
        
        tableStyle.setPreferredSize(new Dimension(310, 387-22));
        scrollStyle.setBackground(colorFond);
    }

    public class TableListener implements ListSelectionListener
    {

        @Override
        public void valueChanged(ListSelectionEvent e)
        {

            int viewRow = jTable1.getSelectedRow();
            if (viewRow >= 0)
            {
                currentName = (String) jTable1.getValueAt(viewRow, 0);
                quantity = Integer.parseInt((String) jTable1.getValueAt(viewRow, 4));
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        quantityRestock = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        newProductImage = new javax.swing.JTextField();
        newProductStock = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        newProductDescription = new javax.swing.JTextArea();
        newProductPrice = new javax.swing.JTextField();
        newProductName = new javax.swing.JTextField();
        newProductCategory = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(49, 91, 111));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Image file");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 540, 90, 30));

        jPanel3.setBackground(new java.awt.Color(53, 63, 74));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            public void mouseMoved(java.awt.event.MouseEvent evt)
            {
                jPanel3MouseMoved(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jPanel3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jPanel3MousePressed(evt);
            }
        });
        jPanel3.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Add Product");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(0, 0, 150, 50);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/button.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jLabel15MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jLabel15MousePressed(evt);
            }
        });
        jPanel3.add(jLabel15);
        jLabel15.setBounds(0, 0, 150, 50);

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 570, 150, 50));

        jPanel5.setBackground(new java.awt.Color(53, 63, 74));
        jPanel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            public void mouseMoved(java.awt.event.MouseEvent evt)
            {
                jPanel5MouseMoved(evt);
            }
        });
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jPanel5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jPanel5MousePressed(evt);
            }
        });
        jPanel5.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Add Stock");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(0, 0, 150, 50);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/button.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jLabel16MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jLabel16MousePressed(evt);
            }
        });
        jPanel5.add(jLabel16);
        jLabel16.setBounds(0, 0, 150, 50);

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 140, 150, 50));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        quantityRestock.setBackground(new java.awt.Color(53, 63, 74));
        quantityRestock.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        quantityRestock.setForeground(new java.awt.Color(255, 255, 255));
        quantityRestock.setText("0");
        quantityRestock.setBorder(null);
        quantityRestock.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                quantityRestockMousePressed(evt);
            }
        });
        quantityRestock.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                quantityRestockActionPerformed(evt);
            }
        });
        add(quantityRestock, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 70, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Product Management");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 360, 60));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Create A New Product ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, 260, 30));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(49, 91, 111)));

        jTable1.setBackground(new java.awt.Color(49, 91, 111));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4", "null", "null"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionBackground(new java.awt.Color(53, 63, 74));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 450, 390));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Quantity");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 70, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Name");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 300, 60, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Description");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 100, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Price");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 300, 60, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Stock");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 540, 60, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Category");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 300, 90, 30));

        newProductImage.setBackground(new java.awt.Color(53, 63, 74));
        newProductImage.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        newProductImage.setForeground(new java.awt.Color(255, 255, 255));
        newProductImage.setBorder(null);
        newProductImage.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newProductImageActionPerformed(evt);
            }
        });
        add(newProductImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 570, 160, -1));

        newProductStock.setBackground(new java.awt.Color(53, 63, 74));
        newProductStock.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        newProductStock.setForeground(new java.awt.Color(255, 255, 255));
        newProductStock.setBorder(null);
        newProductStock.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newProductStockActionPerformed(evt);
            }
        });
        add(newProductStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 570, 80, 20));

        newProductDescription.setBackground(new java.awt.Color(53, 63, 74));
        newProductDescription.setColumns(20);
        newProductDescription.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        newProductDescription.setForeground(new java.awt.Color(255, 255, 255));
        newProductDescription.setRows(5);
        newProductDescription.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jScrollPane2.setViewportView(newProductDescription);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 470, 110));

        newProductPrice.setBackground(new java.awt.Color(53, 63, 74));
        newProductPrice.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        newProductPrice.setForeground(new java.awt.Color(255, 255, 255));
        newProductPrice.setBorder(null);
        newProductPrice.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newProductPriceActionPerformed(evt);
            }
        });
        add(newProductPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 330, 80, -1));

        newProductName.setBackground(new java.awt.Color(53, 63, 74));
        newProductName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        newProductName.setForeground(new java.awt.Color(255, 255, 255));
        newProductName.setBorder(null);
        newProductName.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newProductNameActionPerformed(evt);
            }
        });
        add(newProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, 150, -1));

        newProductCategory.setBackground(new java.awt.Color(53, 63, 74));
        newProductCategory.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        newProductCategory.setForeground(new java.awt.Color(255, 255, 255));
        newProductCategory.setBorder(null);
        newProductCategory.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newProductCategoryActionPerformed(evt);
            }
        });
        add(newProductCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 330, 170, -1));

        jPanel4.setBackground(new java.awt.Color(53, 63, 74));
        jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            public void mouseMoved(java.awt.event.MouseEvent evt)
            {
                jPanel4MouseMoved(evt);
            }
        });
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jPanel4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jPanel4MousePressed(evt);
            }
        });
        jPanel4.setLayout(null);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Delete Product");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(jLabel14);
        jLabel14.setBounds(0, 0, 150, 50);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/button.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jLabel17MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jLabel17MousePressed(evt);
            }
        });
        jPanel4.add(jLabel17);
        jLabel17.setBounds(0, 0, 150, 50);

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 140, 150, 50));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 360, 170, 20));

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, 70, 20));

        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 360, 160, 20));

        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 600, 80, 20));

        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 360, 80, 20));

        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 600, 160, 20));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/fondEmployee.png"))); // NOI18N
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, -10, 1130, 660));
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel3MouseMoved
    {//GEN-HEADEREND:event_jPanel3MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseMoved

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel3MouseEntered
    {//GEN-HEADEREND:event_jPanel3MouseEntered

    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel3MouseExited
    {//GEN-HEADEREND:event_jPanel3MouseExited

    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel3MousePressed
    {//GEN-HEADEREND:event_jPanel3MousePressed

    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel5MouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel5MouseMoved
    {//GEN-HEADEREND:event_jPanel5MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MouseMoved

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel5MouseEntered
    {//GEN-HEADEREND:event_jPanel5MouseEntered

    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel5MouseExited
    {//GEN-HEADEREND:event_jPanel5MouseExited

    }//GEN-LAST:event_jPanel5MouseExited

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel5MousePressed
    {//GEN-HEADEREND:event_jPanel5MousePressed

    }//GEN-LAST:event_jPanel5MousePressed

    private void quantityRestockActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_quantityRestockActionPerformed
    {//GEN-HEADEREND:event_quantityRestockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityRestockActionPerformed

    private void newProductImageActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_newProductImageActionPerformed
    {//GEN-HEADEREND:event_newProductImageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newProductImageActionPerformed

    private void newProductStockActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_newProductStockActionPerformed
    {//GEN-HEADEREND:event_newProductStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newProductStockActionPerformed

    private void newProductPriceActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_newProductPriceActionPerformed
    {//GEN-HEADEREND:event_newProductPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newProductPriceActionPerformed

    private void newProductNameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_newProductNameActionPerformed
    {//GEN-HEADEREND:event_newProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newProductNameActionPerformed

    private void newProductCategoryActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_newProductCategoryActionPerformed
    {//GEN-HEADEREND:event_newProductCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newProductCategoryActionPerformed

    private void jPanel4MouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel4MouseMoved
    {//GEN-HEADEREND:event_jPanel4MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseMoved

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel4MouseEntered
    {//GEN-HEADEREND:event_jPanel4MouseEntered

    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel4MouseExited
    {//GEN-HEADEREND:event_jPanel4MouseExited

    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel4MousePressed
    {//GEN-HEADEREND:event_jPanel4MousePressed


    }//GEN-LAST:event_jPanel4MousePressed

    private void quantityRestockMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_quantityRestockMousePressed
    {//GEN-HEADEREND:event_quantityRestockMousePressed
        quantityRestock.setText("");  // TODO add your handling code here:
    }//GEN-LAST:event_quantityRestockMousePressed

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel15MouseEntered
    {//GEN-HEADEREND:event_jLabel15MouseEntered
        jLabel15.setIcon(new ImageIcon("src/Image/buttonClicked.png"));// TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel15MouseExited
    {//GEN-HEADEREND:event_jLabel15MouseExited
        jLabel15.setIcon(new ImageIcon("src/Image/button.png"));   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel15MousePressed
    {//GEN-HEADEREND:event_jLabel15MousePressed
        try
        {
            Product product = new Product(newProductName.getText(), newProductCategory.getText(), newProductDescription.getText(), Double.parseDouble(newProductPrice.getText()), Integer.parseInt(newProductStock.getText()), null, newProductImage.getText());

            product.insertProduct();
            String[][] data = controller.findData();
            
            String[] colNamesFilter =
            {
                "Name", "Category", "Description", "Price", "Stock", "Image"
            };
            String[][] dataFilter = new String[data.length][6];
            for (int i = 0; i < data.length; i++)
            {
                dataFilter[i][0] = data[i][0];
                dataFilter[i][1] = data[i][1];
                dataFilter[i][2] = data[i][2];
                dataFilter[i][3] = data[i][3];
                dataFilter[i][4] = data[i][4];
                dataFilter[i][5] = data[i][6];
            }
            tableModel.setDataVector(dataFilter, colNamesFilter);
          columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(220);
        columnModel.getColumn(3).setPreferredWidth(50);
        columnModel.getColumn(4).setPreferredWidth(50);
            newProductName.setText("");
            newProductCategory.setText("");
            newProductDescription.setText("");
            newProductPrice.setText("");
            newProductStock.setText("");
            newProductImage.setText("");

        } catch (Exception ex)
        {
            System.out.println(ex);
        }  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MousePressed

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel16MouseEntered
    {//GEN-HEADEREND:event_jLabel16MouseEntered
        jLabel16.setIcon(new ImageIcon("src/Image/buttonClicked.png")); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel16MouseExited
    {//GEN-HEADEREND:event_jLabel16MouseExited
        jLabel16.setIcon(new ImageIcon("src/Image/button.png"));// TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel16MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel16MousePressed
    {//GEN-HEADEREND:event_jLabel16MousePressed
        try
        {
            
            controller.AddStock(currentName,Integer.parseInt(quantityRestock.getText()) );
            String[][] data = controller.findData();

            String[] colNamesFilter =
            {
                "Name", "Category", "Description", "Price", "Stock", "Image"
            };
            String[][] dataFilter = new String[data.length][6];
            for (int i = 0; i < data.length; i++)
            {
                dataFilter[i][0] = data[i][0];
                dataFilter[i][1] = data[i][1];
                dataFilter[i][2] = data[i][2];
                dataFilter[i][3] = data[i][3];
                dataFilter[i][4] = data[i][4];
                dataFilter[i][5] = data[i][6];
            }
            tableModel.setDataVector(dataFilter, colNamesFilter);
           columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(220);
        columnModel.getColumn(3).setPreferredWidth(50);
        columnModel.getColumn(4).setPreferredWidth(50);

        } catch (Exception ex)
        {
            System.out.println(ex);
            // Logger.getLogger(EmployeesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MousePressed

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel17MouseEntered
    {//GEN-HEADEREND:event_jLabel17MouseEntered
        jLabel17.setIcon(new ImageIcon("src/Image/buttonClicked.png"));// TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel17MouseExited
    {//GEN-HEADEREND:event_jLabel17MouseExited
        jLabel17.setIcon(new ImageIcon("src/Image/button.png"));// TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseExited

    private void jLabel17MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel17MousePressed
    {//GEN-HEADEREND:event_jLabel17MousePressed
        try
        {

            controller.EraseProduct(currentName);
            String[][] data = controller.findData();

            String[] colNamesFilter =
            {
                "Name", "Category", "Description", "Price", "Stock", "Image"
            };
            String[][] dataFilter = new String[data.length][6];
            for (int i = 0; i < data.length; i++)
            {
                dataFilter[i][0] = data[i][0];
                dataFilter[i][1] = data[i][1];
                dataFilter[i][2] = data[i][2];
                dataFilter[i][3] = data[i][3];
                dataFilter[i][4] = data[i][4];
                dataFilter[i][5] = data[i][6];
            }
            tableModel.setDataVector(dataFilter, colNamesFilter);
           columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(220);
        columnModel.getColumn(3).setPreferredWidth(50);
        columnModel.getColumn(4).setPreferredWidth(50);

        } catch (Exception ex)
        {
            System.out.println(ex);
        }    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField newProductCategory;
    private javax.swing.JTextArea newProductDescription;
    private javax.swing.JTextField newProductImage;
    private javax.swing.JTextField newProductName;
    private javax.swing.JTextField newProductPrice;
    private javax.swing.JTextField newProductStock;
    private javax.swing.JTextField quantityRestock;
    // End of variables declaration//GEN-END:variables
}
