

package View;

import Controller.MyOrdersController;
import Model.Discount;
import Model.Order;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 * @author Edoua
 */
public class MyOrders extends javax.swing.JPanel
{
    private MyOrdersController controller;
    private MyFrame myFrame;
    private Order[] orders;
    
    public MyOrders(MyFrame myFrame)
    {
        this.myFrame = myFrame;
        controller = new MyOrdersController();
        initComponents();
        setVisible(true);
        
        setTableStyle(jTable1, jScrollPane1, new Color(0,51,102), new Color(77,128,216));
        setTableStyle(jTable2, jScrollPane2, new Color(62,120,207), new Color(0,51,102));
        
        jTable2.getSelectionModel().addListSelectionListener(new MyOrders.TableListener());
    }
    
    public void buildTable()
    {
        
        orders = controller.findOrders(myFrame.getCustomer().getEmail());
        
        buildOrderTable();
        
        
        
    }
    
    public void buildOrderTable()
    {
        String [] colNames = new String[] {"Id","Date","Cost (€)"};
        String [][] data = new String [orders.length][3];
        
        for(int i=0 ; i < orders.length ; i++)
        {
            data[i][0] = String.valueOf(orders[i].getId());
            data[i][1] = String.valueOf(orders[i].getDate());
            data[i][2] = String.valueOf(orders[i].totalCost());
        }
        DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
        tableModel.setDataVector(data, colNames);
        TableColumnModel ColumnModel = jTable2.getColumnModel();
        ColumnModel.getColumn(0).setPreferredWidth(70);
        ColumnModel.getColumn(1).setPreferredWidth(100);
        ColumnModel.getColumn(2).setPreferredWidth(75);
        
        
    }
    
    public void buildProductTable(Order order)
    {
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        try
        {
            String [] colNames = new String[] {"Quantity","Product","Cost (€)"};
            String [][] data = new String [order.getOrderedProducts().size()][3];
            
            for(int i=0 ; i < order.getOrderedProducts().size() ; i++)
            {
                data[i][0] = String.valueOf(order.getOrderedProducts().get(i).getQuantity());
                data[i][1] = String.valueOf(order.getOrderedProducts().get(i).getProductName());
                data[i][2] = String.valueOf(order.getOrderedProducts().get(i).getPrice());
            }
            tableModel.setDataVector(data, colNames);
            TableColumnModel cartColumnModel = jTable1.getColumnModel();
            cartColumnModel.getColumn(0).setPreferredWidth(70);
            cartColumnModel.getColumn(1).setPreferredWidth(100);
            cartColumnModel.getColumn(2).setPreferredWidth(75);       
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        jLabelTotal.setText(String.valueOf(order.totalCost()) + " €");
    }
    
    
    
    public void setTableStyle(JTable tableStyle, JScrollPane scrollStyle, Color colorFond, Color colorHeader)
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
        tableStyle.getTableHeader().setBackground(colorHeader);
        //tableStyle.getTableHeader().setBackground(new Color(23,35,55));
        tableStyle.getTableHeader().setForeground(new Color(255,255,255));
        tableStyle.getTableHeader().setFont(new Font("Sergoe UI", Font.PLAIN, 12));
        
        tableStyle.setPreferredSize(new Dimension(310, 310-22));
        scrollStyle.setBackground(colorFond);
    }
    
    public class TableListener implements ListSelectionListener 
    {
        @Override
        public void valueChanged(ListSelectionEvent e)
        {
            int viewRow = jTable2.getSelectedRow();
            int quantity = 0;
            System.out.println("VIEWING : " + viewRow);
            if(viewRow >= 0)
                buildProductTable(orders[viewRow]);

        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jLabelTotal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1130, 650));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(62, 120, 207));
        jPanel1.setPreferredSize(new java.awt.Dimension(1130, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTotal.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabelTotal.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 490, 190, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("My Orders");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Orders");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Products");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 120, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 102), 1, true));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTable1.setBackground(new java.awt.Color(0, 51, 102));
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
        jTable1.setSelectionBackground(new java.awt.Color(62, 120, 207));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 170, 310, 310));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(62, 120, 207), 1, true));
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTable2.setBackground(new java.awt.Color(62, 120, 207));
        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.setGridColor(new java.awt.Color(23, 35, 55));
        jTable2.setRowHeight(22);
        jTable2.setSelectionBackground(new java.awt.Color(23, 35, 55));
        jTable2.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable2.setShowHorizontalLines(false);
        jTable2.setShowVerticalLines(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 310, 310));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/testFond.png"))); // NOI18N
        jLabel9.setText("jLabel7");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 1130, 650));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
