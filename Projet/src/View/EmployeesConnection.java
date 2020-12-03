/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.EmployeesConnectionController;
import javax.swing.ImageIcon;
/**
 *
 * @author Edoua
 */
public class EmployeesConnection extends javax.swing.JPanel
{
    private boolean connected;
    private FrameEmployee eFrame;
    private EmployeesConnectionController controller;
    /**
     * Creates new form EmployeesConnection
     */
    public EmployeesConnection(FrameEmployee eframe)
    {
        controller = new EmployeesConnectionController();
        this.eFrame = eframe;
        initComponents();
        jLabel3.setIcon(new ImageIcon("src/Image/logoGifHermes.gif"));
        connected=false;
        setVisible(true);
    }
    
    public boolean isConnected()
    {
        return connected;
    }
    public void disconnect()
    {
        connected = false;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(53, 63, 74));
        setMinimumSize(new java.awt.Dimension(1130, 650));
        setPreferredSize(new java.awt.Dimension(1130, 650));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(53, 63, 74));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("Enter email");
        jTextField1.setBorder(null);
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jTextField1MousePressed(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextField1ActionPerformed(evt);
            }
        });
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, 250, 30));

        jPasswordField1.setBackground(new java.awt.Color(53, 63, 74));
        jPasswordField1.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setText("supermotdepass");
        jPasswordField1.setBorder(null);
        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jPasswordField1MousePressed(evt);
            }
        });
        jPasswordField1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jPasswordField1ActionPerformed(evt);
            }
        });
        add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 490, 260, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Email");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 60, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 460, -1, -1));

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
        jLabel6.setText("Connect");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(40, 10, 70, 25);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/button.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jLabel4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jLabel4MousePressed(evt);
            }
        });
        jPanel3.add(jLabel4);
        jLabel4.setBounds(0, 0, 150, 50);

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 550, 150, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logoGifHermes.gif"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, -40, 690, 520));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, 260, 20));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 530, 260, 10));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField1ActionPerformed
    {//GEN-HEADEREND:event_jTextField1ActionPerformed

        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jPasswordField1ActionPerformed
    {//GEN-HEADEREND:event_jPasswordField1ActionPerformed
        
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jPanel3MouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel3MouseMoved
    {//GEN-HEADEREND:event_jPanel3MouseMoved

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

    private void jTextField1MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTextField1MousePressed
    {//GEN-HEADEREND:event_jTextField1MousePressed
    jTextField1.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1MousePressed

    private void jPasswordField1MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPasswordField1MousePressed
    {//GEN-HEADEREND:event_jPasswordField1MousePressed
    jPasswordField1.setText("");           // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1MousePressed

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel4MouseEntered
    {//GEN-HEADEREND:event_jLabel4MouseEntered
       jLabel4.setIcon(new ImageIcon("src/Image/buttonClicked.png")); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel4MouseExited
    {//GEN-HEADEREND:event_jLabel4MouseExited
          jLabel4.setIcon(new ImageIcon("src/Image/button.png"));// TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel4MousePressed
    {//GEN-HEADEREND:event_jLabel4MousePressed
         if(controller.isEmployee(jTextField1.getText(),jPasswordField1.getText()))
        {
            connected=true;
            eFrame.connection();
            eFrame.setEmployee(controller.findEmployee(jTextField1.getText()));
            System.out.println("Get EMployee");
            System.out.println("Employee Connection Accepted");
        }
    }//GEN-LAST:event_jLabel4MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
