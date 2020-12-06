/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.EditEmpController;
import Model.Employee;
import javax.swing.ImageIcon;


/**
 *
 * @author Edoua
 */
public class EditEmployeesProfile extends javax.swing.JPanel
{
    private String email;
    private final FrameEmployee eFrame;
    public EditEmpController controller;

    /**
     * Creates new form EditEmployeesProfile
     */
    public EditEmployeesProfile(String email, FrameEmployee eFrame)
    {
        controller=new EditEmpController();
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
            Employee employee=controller.findEmployee(email);
            jComboBox1.setSelectedIndex(employee.getAge()-13);
            
            jTextField1.setText(employee.getFirstName());

            jTextField2.setText(employee.getAddress());

            jTextField3.setText(employee.getPhone());

           jTextField4.setText("");
           //jTextField.set

            jTextField6.setText(employee.getName());

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
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField4 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setBackground(new java.awt.Color(53, 63, 74));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, -1, -1));

        jTextField1.setBackground(new java.awt.Color(53, 63, 74));
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
        panel.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 130, -1));

        jTextField6.setBackground(new java.awt.Color(53, 63, 74));
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
        panel.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 130, -1));

        jTextField2.setBackground(new java.awt.Color(53, 63, 74));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setText("Address");
        jTextField2.setBorder(null);
        panel.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 390, -1));

        jTextField3.setBackground(new java.awt.Color(53, 63, 74));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setText("Phone");
        jTextField3.setBorder(null);
        panel.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, 120, -1));

        jComboBox1.setBackground(new java.awt.Color(53, 63, 74));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setBorder(null);
        panel.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, -1, -1));

        jTextField4.setBackground(new java.awt.Color(53, 63, 74));
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
        panel.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, 120, -1));

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
        jLabel6.setText("Edit Profile");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(20, 10, 150, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/button.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jLabel2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jLabel2MousePressed(evt);
            }
        });
        jPanel3.add(jLabel2);
        jLabel2.setBounds(20, 10, 150, 50);

        panel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 540, 210, 70));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Your Profile");
        panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        panel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 130, -1));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 500, 120, 10));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        panel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, 130, 10));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        panel.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, 390, -1));

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        panel.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, 120, 10));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Password");
        panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("First name");
        panel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Name");
        panel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Address");
        panel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Phone");
        panel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Age");
        panel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, -1, -1));

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
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel3MouseExited
    {//GEN-HEADEREND:event_jPanel3MouseExited
    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel3MousePressed
    {//GEN-HEADEREND:event_jPanel3MousePressed

      
    }//GEN-LAST:event_jPanel3MousePressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField1ActionPerformed
    {//GEN-HEADEREND:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField4ActionPerformed
    {//GEN-HEADEREND:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel2MouseEntered
    {//GEN-HEADEREND:event_jLabel2MouseEntered
       jLabel2.setIcon(new ImageIcon("src/Image/buttonClicked.png")); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel2MousePressed
    {//GEN-HEADEREND:event_jLabel2MousePressed
        try
        {
            controller.EditEmployee(email,jTextField1.getText(),jTextField6.getText(),jTextField2.getText(),jTextField3.getText() ,jComboBox1.getSelectedIndex()+13,jTextField4.getText());
            
          
            eFrame.setEmployee(controller.findEmployee(email));
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel2MouseExited
    {//GEN-HEADEREND:event_jLabel2MouseExited
       jLabel2.setIcon(new ImageIcon("src/Image/button.png")); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
