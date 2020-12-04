/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Customer;
import java.awt.Color;
import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.swing.ImageIcon;
/**
 *
 * @author Edoua
 */
public class NewCustomer extends javax.swing.JPanel
{
    private MyFrame myframe;
    private Connection panelConnection;

    /**
     * Creates new form NewCustomer
     */
    public NewCustomer(MyFrame myFrame, Connection panelconnection)
    {
        initComponents();
        panelConnection = panelconnection;
        myframe = myFrame;
         String[]ageselector = new String[88];
            for(int i=13 ; i <= 100 ; i++)
            {
                ageselector[i-13] = "" + i;
            }
                 jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(ageselector));  
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        panel = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        panel1 = new javax.swing.JPanel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jTextField5 = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jSeparator8 = new javax.swing.JSeparator();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setBackground(new java.awt.Color(62, 120, 207));
        panel.setMinimumSize(new java.awt.Dimension(1130, 650));
        panel.setPreferredSize(new java.awt.Dimension(1130, 650));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(62, 120, 207));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setBorder(null);
        panel.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 183, -1));

        jTextField2.setBackground(new java.awt.Color(62, 120, 207));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextField2ActionPerformed(evt);
            }
        });
        panel.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 200, -1));

        jTextField3.setBackground(new java.awt.Color(62, 120, 207));
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
        panel.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 183, -1));

        jTextField4.setBackground(new java.awt.Color(62, 120, 207));
        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setBorder(null);
        jTextField4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextField4ActionPerformed(evt);
            }
        });
        panel.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 183, 20));

        jPasswordField1.setBackground(new java.awt.Color(62, 120, 207));
        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setBorder(null);
        panel.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, 183, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Name");
        panel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("First name");
        panel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Age");
        panel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Email");
        panel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Phone");
        panel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Address");
        panel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("New Profile");
        panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(62, 120, 207));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        panel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 200, -1));

        jSeparator3.setBackground(new java.awt.Color(62, 120, 207));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        panel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 180, 10));

        panel1.setBackground(new java.awt.Color(62, 120, 207));
        panel1.setMinimumSize(new java.awt.Dimension(1130, 650));
        panel1.setPreferredSize(new java.awt.Dimension(1130, 650));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPasswordField2.setEditable(false);
        jPasswordField2.setBackground(new java.awt.Color(62, 120, 207));
        jPasswordField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPasswordField2.setBorder(null);
        panel1.add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, 183, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Name");
        panel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("First name");
        panel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Age");
        panel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Email");
        panel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Phone");
        panel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Address");
        panel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("New Profile");
        panel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, -1, -1));

        jSeparator4.setBackground(new java.awt.Color(62, 120, 207));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        panel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 200, -1));

        jSeparator5.setBackground(new java.awt.Color(62, 120, 207));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        panel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 180, 10));

        jSeparator6.setBackground(new java.awt.Color(62, 120, 207));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        panel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 180, 10));

        jSeparator7.setBackground(new java.awt.Color(62, 120, 207));
        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        panel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 180, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(62, 120, 207));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        panel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, 180, 10));

        jTextField5.setBackground(new java.awt.Color(62, 120, 207));
        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setBorder(null);
        jTextField5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextField5ActionPerformed(evt);
            }
        });
        panel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 183, -1));

        jSeparator9.setBackground(new java.awt.Color(62, 120, 207));
        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        panel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 180, 10));

        jPanel3.setBackground(new java.awt.Color(62, 120, 207));
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
        jLabel6.setText("Create");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(50, 10, 60, 25);

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
        jLabel1.setBounds(0, 0, 150, 50);

        panel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 520, 150, 50));

        jComboBox1.setBackground(new java.awt.Color(62, 120, 207));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, -1, -1));

        panel.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 660));

        jSeparator8.setBackground(new java.awt.Color(62, 120, 207));
        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        panel.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 180, 10));

        add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 660));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField3ActionPerformed
    {//GEN-HEADEREND:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField4ActionPerformed
    {//GEN-HEADEREND:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField5ActionPerformed
    {//GEN-HEADEREND:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jPanel3MouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel3MouseMoved
    {//GEN-HEADEREND:event_jPanel3MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseMoved

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel3MouseEntered
    {//GEN-HEADEREND:event_jPanel3MouseEntered
        jPanel3.setBackground(new Color(39,57,82));
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel3MouseExited
    {//GEN-HEADEREND:event_jPanel3MouseExited
        jPanel3.setBackground(new Color(23,35,55));
    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel3MousePressed
    {//GEN-HEADEREND:event_jPanel3MousePressed
   
    }//GEN-LAST:event_jPanel3MousePressed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField2ActionPerformed
    {//GEN-HEADEREND:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel1MousePressed
    {//GEN-HEADEREND:event_jLabel1MousePressed
           
      try
        {

            int age=jComboBox1.getSelectedIndex()+13;
            Customer customer =  new Customer(jTextField2.getText(),jTextField1.getText(),age,jTextField4.getText(),jTextField5.getText(),jTextField3.getText(),jPasswordField1.getText()) ;
            myframe.connection();
            panelConnection.connect();
            System.out.println("Connection Accepted");
//Window3 wind= new Window3();
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        } // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel1MouseEntered
    {//GEN-HEADEREND:event_jLabel1MouseEntered
        jLabel1.setIcon(new ImageIcon("src/Image/buttonClicked.png"));// TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel1MouseExited
    {//GEN-HEADEREND:event_jLabel1MouseExited
       jLabel1.setIcon(new ImageIcon("src/Image/button.png")); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel1;
    // End of variables declaration//GEN-END:variables
}
