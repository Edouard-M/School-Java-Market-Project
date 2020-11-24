/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static Model.DAO.getEmployee;
import static Model.DAO.searchCustomer;
import static Model.DAO.searchEmployee;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Edoua
 */
public class EmployeesConnection extends javax.swing.JPanel
{
    private boolean connected;
    private FrameEmployee eFrame;
    /**
     * Creates new form EmployeesConnection
     */
    public EmployeesConnection(FrameEmployee eframe)
    {
        eFrame = eframe;
        initComponents();
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

        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(53, 63, 74));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 90, 50));

        jTextField1.setText("Email");
        jTextField1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextField1ActionPerformed(evt);
            }
        });
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 140, -1));

        jPasswordField1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jPasswordField1ActionPerformed(evt);
            }
        });
        add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 140, -1));

        jButton1.setText("Connect");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField1ActionPerformed
    {//GEN-HEADEREND:event_jTextField1ActionPerformed

        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jPasswordField1ActionPerformed
    {//GEN-HEADEREND:event_jPasswordField1ActionPerformed
        
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        try
        {

            if(searchEmployee(jTextField1.getText(),jPasswordField1.getText())==true)
            {
                connected=true;
                eFrame.connection();
                eFrame.setEmployee(getEmployee(jTextField1.getText()));
                System.out.println("Get EMployee");
                System.out.println("Employee Connection Accepted");
            }
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
