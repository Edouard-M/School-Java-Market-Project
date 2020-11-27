/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.DAO;
import static Model.DAO.employeeDelete;
import static Model.DAO.getCol;
import static Model.DAO.getLines;
import static Model.DAO.selectAllEmployees;
import static Model.DAO.selectAllProducts;
import Model.Employee;
import Model.Product;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author dwans
 */
public class CreateEmployee extends javax.swing.JPanel
{
    private ArrayList<Employee> allEmployeesList;
       private DefaultTableModel tableModel;
    private String currentMail;
    private FrameEmployee eFrame;
    private Employee employee;
    /**
     * Creates new form CreateEmployee
     */
    public CreateEmployee(FrameEmployee eFrame)
    {
        this.eFrame=eFrame;
        initComponents();
        String[]ageselector = new String[83];
        for(int i=18 ; i <= 100 ; i++)
            {
                ageselector[i-18] = "" + i;
            }
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(ageselector)); 
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
        if(!"admin@gmail.com".equals(employee.getEmail()))            
       { jPanel4.setVisible(false);}
        else
            jPanel4.setVisible(true);
    }
    
     public void buildPanel() throws Exception
    {
       
        allEmployeesList = selectAllEmployees();
        String [] colNames = getCol("Employee");
        String [][] data = getLines("Employee");
        String [] colNamesFilter = {"Name", "First Name", "Age", "Phone", "Address","Email"};
        String [][] dataFilter = new String[data.length][6];
        for(int i=0 ; i < data.length ; i++)
        {
            dataFilter[i][0] = data[i][0];
            dataFilter[i][1] = data[i][1];
            dataFilter[i][2] = data[i][2];
            dataFilter[i][3] = data[i][3];
            dataFilter[i][4] = data[i][4];
            dataFilter[i][5] = data[i][5];
        }
     
        
        tableModel =  (DefaultTableModel) jTable1.getModel();
        
        if("admin@gmail.com".equals(employee.getEmail()))  
        { tableModel.setDataVector(data, colNames);}
        else 
            tableModel.setDataVector(dataFilter, colNamesFilter);
        jTable1.getSelectionModel().addListSelectionListener(new CreateEmployee.TableListener());
        
        TableColumnModel columnModel = jTable1.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(50);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(50);
        columnModel.getColumn(4).setPreferredWidth(50);
        
       
        setTableStyle(jTable1);
        jScrollPane1.setBackground(new Color(49,91,111));
        
        jTable1.setPreferredSize(new Dimension(310, 324));
        jTable1.getTableHeader().setBackground(new Color(49,91,111));
        jTable1.getTableHeader().setForeground(new Color(255,255,255));
        jTable1.getTableHeader().setFont(new Font("Sergoe UI", Font.PLAIN, 14));
       
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
           { currentMail = (String) jTable1.getValueAt(viewRow, 5);
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

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1130, 650));
        setPreferredSize(new java.awt.Dimension(1130, 650));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(49, 91, 111));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(53, 63, 74));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 120, -1));

        jTextField2.setBackground(new java.awt.Color(53, 63, 74));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 420, 150, -1));

        jTextField3.setBackground(new java.awt.Color(53, 63, 74));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setBorder(null);
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, 120, -1));

        jTextField4.setBackground(new java.awt.Color(53, 63, 74));
        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setBorder(null);
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 310, 170, -1));

        jTextField6.setBackground(new java.awt.Color(53, 63, 74));
        jTextField6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setBorder(null);
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 480, 390, -1));

        jComboBox1.setBackground(new java.awt.Color(53, 63, 74));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setBorder(null);
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 250, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Address");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Age");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("First name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Password");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 360, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Phone");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, -1, -1));

        jPasswordField1.setBackground(new java.awt.Color(53, 63, 74));
        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setBorder(null);
        jPasswordField1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, 170, -1));

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

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Create");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(50, 30, 60, 16);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/button.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jLabel1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jLabel1MousePressed(evt);
            }
        });
        jPanel3.add(jLabel1);
        jLabel1.setBounds(0, 10, 153, 51);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 540, 160, 70));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("New Profile");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 120, -1));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, 120, 10));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, 390, 30));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, 170, 30));

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 390, 170, 30));

        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 450, 150, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/fondEmployee.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 1130, 650));

        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jTable1.setBackground(new java.awt.Color(49, 91, 111));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        ));
        jTable1.setSelectionBackground(new java.awt.Color(53, 63, 74));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, 350));

        jPanel4.setBackground(new java.awt.Color(49, 91, 111));
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

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Delete");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(50, 30, 60, 16);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/button.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jLabel14MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jLabel14MousePressed(evt);
            }
        });
        jPanel4.add(jLabel14);
        jLabel14.setBounds(0, 10, 153, 51);

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 540, 160, 70));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 650));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField1ActionPerformed
    {//GEN-HEADEREND:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField2ActionPerformed
    {//GEN-HEADEREND:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jPasswordField1ActionPerformed
    {//GEN-HEADEREND:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jPanel3MouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel3MouseMoved
    {//GEN-HEADEREND:event_jPanel3MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseMoved

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel3MouseEntered
    {//GEN-HEADEREND:event_jPanel3MouseEntered
       // jPanel3.setBackground(new Color(39,57,82));
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel3MouseExited
    {//GEN-HEADEREND:event_jPanel3MouseExited
       // jPanel3.setBackground(new Color(23,35,55));
    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel3MousePressed
    {//GEN-HEADEREND:event_jPanel3MousePressed
     
    }//GEN-LAST:event_jPanel3MousePressed

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel1MouseEntered
    {//GEN-HEADEREND:event_jLabel1MouseEntered
       jLabel1.setIcon(new ImageIcon("src/Image/buttonClicked.png")); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel1MouseExited
    {//GEN-HEADEREND:event_jLabel1MouseExited
       jLabel1.setIcon(new ImageIcon("src/Image/button.png")); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel1MousePressed
    {//GEN-HEADEREND:event_jLabel1MousePressed
       try
        {
         
            Employee createdEmployee = new Employee(jTextField3.getText(),jTextField1.getText(),jComboBox1.getSelectedIndex()+18  ,jTextField2.getText(),jTextField6.getText(),jTextField4.getText(),jPasswordField1.getText());
           createdEmployee.insertEmployee();
            String[] colNames = getCol("Employee");
            String[][] data = getLines("Employee");
            tableModel.setDataVector(data, colNames);
            TableColumnModel columnModel = jTable1.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(100);
            columnModel.getColumn(1).setPreferredWidth(50);
            columnModel.getColumn(2).setPreferredWidth(150);
            columnModel.getColumn(3).setPreferredWidth(50);
            columnModel.getColumn(4).setPreferredWidth(50);
        } catch (Exception ex)
        {
            
            
         
            System.out.println(ex.getMessage());
            
        }
         jTextField3.setText("");
            jTextField2.setText("");
            jTextField1.setText("");
            jTextField4.setText("");
            jTextField6.setText("");
            jPasswordField1.setText("");
            jComboBox1.setSelectedIndex(0); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel14MouseEntered
    {//GEN-HEADEREND:event_jLabel14MouseEntered
        jLabel14.setIcon(new ImageIcon("src/Image/buttonClicked.png")); 
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel14MouseExited
    {//GEN-HEADEREND:event_jLabel14MouseExited
        jLabel14.setIcon(new ImageIcon("src/Image/button.png"));         
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel14MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel14MousePressed
    {//GEN-HEADEREND:event_jLabel14MousePressed
        try
        {
            if(!"admin@gmail.com".equals(currentMail)&&!employee.getEmail().equals(currentMail))
            { 
            employeeDelete(currentMail);
            String[] colNames = getCol("Employee");
            String[][] data = getLines("Employee");
            tableModel.setDataVector(data, colNames);
            TableColumnModel columnModel = jTable1.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(100);
            columnModel.getColumn(1).setPreferredWidth(50);
            columnModel.getColumn(2).setPreferredWidth(150);
            columnModel.getColumn(3).setPreferredWidth(50);
            columnModel.getColumn(4).setPreferredWidth(50);
            }// TODO add your handling code here:
        } catch (Exception ex)
        {
            Logger.getLogger(CreateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel14MousePressed

    private void jPanel4MouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel4MouseMoved
    {//GEN-HEADEREND:event_jPanel4MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseMoved

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel4MouseEntered
    {//GEN-HEADEREND:event_jPanel4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel4MouseExited
    {//GEN-HEADEREND:event_jPanel4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel4MousePressed
    {//GEN-HEADEREND:event_jPanel4MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
