/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.DAO;

import static Model.DAO.*;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author dwans
 */
public class EditCustomer extends javax.swing.JPanel
{
private String email;
private MyFrame eFrame;
    /**
     * Creates new form EditCustomer
     */
 
    public EditCustomer(MyFrame eFrame)
    {
        this.eFrame=eFrame;
        initComponents();
    }

   
    public void setEmail(String email)
    {
        this.email=email;
        buildPanel();
    }
private void buildPanel()
    {
        jLabel1.setText(email);
        try
        {
            String[]ageselector = new String[88];
            for(int i=13 ; i <= 100 ; i++)
            {
                ageselector[i-13] = "" + i;
            }
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(ageselector));  
            jComboBox1.setSelectedIndex(DAO.getCustomerAge(email)-13);
            
            jTextField1.setText(getCustomerFirstName(email));

            jTextField2.setText(getCustomerAddress(email));

            jTextField3.setText(getCustomerPhone(email));

           jTextField4.setText("");
           //jTextField.set

            jTextField6.setText(getCustomerName(email));

        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
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
        jLabel1 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1130, 650));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(62, 120, 207));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(62, 120, 207));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("Firstname");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, 120, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, -1, -1));

        jTextField6.setBackground(new java.awt.Color(62, 120, 207));
        jTextField6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setText("jTextField6");
        jTextField6.setBorder(null);
        jTextField6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 120, -1));

        jTextField2.setBackground(new java.awt.Color(62, 120, 207));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setText("Address");
        jTextField2.setBorder(null);
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 390, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("First Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Phone");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, -1, -1));

        jTextField3.setBackground(new java.awt.Color(62, 120, 207));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setText("Phone");
        jTextField3.setBorder(null);
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 120, -1));

        jComboBox1.setBackground(new java.awt.Color(62, 120, 207));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setBorder(null);
        jComboBox1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Age");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, -1, -1));

        jTextField4.setBackground(new java.awt.Color(62, 120, 207));
        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setText("Password");
        jTextField4.setBorder(null);
        jTextField4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, 120, -1));

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
        jLabel6.setText("Edit Profile");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(30, 20, 90, 25);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/button.png"))); // NOI18N
        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            public void mouseMoved(java.awt.event.MouseEvent evt)
            {
                jLabel3MouseMoved(evt);
            }
        });
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jLabel3MouseExited(evt);
            }
        });
        jPanel3.add(jLabel3);
        jLabel3.setBounds(0, 0, 150, 60);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 150, 60));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Password");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 460, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Your Profile");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(62, 120, 207));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, 120, 10));

        jSeparator2.setBackground(new java.awt.Color(62, 120, 207));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 120, 10));

        jSeparator3.setBackground(new java.awt.Color(62, 120, 207));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 390, 10));

        jSeparator4.setBackground(new java.awt.Color(62, 120, 207));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 120, 10));

        jSeparator5.setBackground(new java.awt.Color(62, 120, 207));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 120, 10));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Address");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Name");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 650));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField6ActionPerformed
    {//GEN-HEADEREND:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

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
      jLabel2.setIcon(new ImageIcon("src/Image/buttonClicked.png"));
    }//GEN-LAST:event_jPanel3MousePressed

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel3MouseExited
    {//GEN-HEADEREND:event_jLabel3MouseExited
        jLabel3.setIcon(new ImageIcon("src/Image/button.png"));// TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel3MouseEntered
    {//GEN-HEADEREND:event_jLabel3MouseEntered
       jLabel3.setIcon(new ImageIcon("src/Image/buttonClicked.png")); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel3MouseClicked
    {//GEN-HEADEREND:event_jLabel3MouseClicked
        try
        {
            if(!"".equals(jTextField4.getText()))
            {
                EditCustomerdata(email,jTextField1.getText(),jTextField6.getText(),jTextField2.getText(),jTextField3.getText() ,jComboBox1.getSelectedIndex()+13,jTextField4.getText());
                eFrame.setCustomer(getCustomer(email));
            }
            else
            {
             EditCustomerdata(email,jTextField1.getText(),jTextField6.getText(),jTextField2.getText(),jTextField3.getText() ,jComboBox1.getSelectedIndex()+13,getEmployeePassword(email));
               eFrame.setCustomer(getCustomer(email));
            }

        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        } // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBox1ActionPerformed
    {//GEN-HEADEREND:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField4ActionPerformed
    {//GEN-HEADEREND:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField1ActionPerformed
    {//GEN-HEADEREND:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jLabel3MouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel3MouseMoved
    {//GEN-HEADEREND:event_jLabel3MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
