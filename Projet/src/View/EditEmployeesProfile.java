/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static Model.DAO.*;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Edoua
 */
public class EditEmployeesProfile extends javax.swing.JPanel
{
    private String email;
    private FrameEmployee eFrame;
    /**
     * Creates new form EditEmployeesProfile
     */
    public EditEmployeesProfile(String email, FrameEmployee eFrame)
    {
        this.eFrame = eFrame;
        this.email = email;
        initComponents();
        //buildPanel();
        setVisible(true);
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
            jComboBox1.setSelectedIndex(getEmployeeAge(email)-13);
            System.out.println(" zdzdzdzdzd");
            jTextField1.setText(getEmployeeFirstName(email));

            jTextField2.setText(getEmployeeAddress(email));

            jTextField3.setText(getEmployeePhone(email));

           jTextField4.setText("");
           //jTextField.set

            jTextField6.setText(getEmployeeName(email));

        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
    
    public void setEmail(String email)
    {
        this.email = email;
        buildPanel();
    }
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setBackground(new java.awt.Color(53, 63, 74));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, -1, -1));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setText("Firstname");
        jTextField1.setBorder(null);
        panel.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 270, 100, -1));

        jTextField6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField6.setText("jTextField6");
        jTextField6.setBorder(null);
        jTextField6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextField6ActionPerformed(evt);
            }
        });
        panel.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 120, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Address");
        panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, -1, -1));

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField2.setText("Address");
        jTextField2.setBorder(null);
        panel.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 310, 120, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Phone");
        panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, -1, -1));

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField3.setText("Phone");
        jTextField3.setBorder(null);
        panel.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 360, 120, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Age");
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 410, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setBorder(null);
        panel.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 410, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, -1, -1));

        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField4.setText("Password");
        jTextField4.setBorder(null);
        panel.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 450, 120, -1));

        jPanel3.setBackground(new java.awt.Color(23, 35, 55));
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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Edit Profile");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        panel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 490, 100, 30));

        add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 650));
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
        try
        {
            if(!"".equals(jTextField4.getText()))
            {
                EditEmployee(email,jTextField1.getText(),jTextField6.getText(),jTextField2.getText(),jTextField3.getText() ,jComboBox1.getSelectedIndex()+13,jTextField4.getText());
                eFrame.setEmployee(getEmployee(email));
            }
            else
            {
                EditEmployee(email,jTextField1.getText(),jTextField6.getText(),jTextField2.getText(),jTextField3.getText() ,jComboBox1.getSelectedIndex()+13,getEmployeePassword(email));
                eFrame.setEmployee(getEmployee(email));
            }

        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jPanel3MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}