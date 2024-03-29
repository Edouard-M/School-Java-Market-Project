/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Customer;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

/**
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
 */
public class MyFrame extends javax.swing.JFrame
{
   private Customer customer;
   private final GridBagLayout layout = new GridBagLayout();
   private final NewCustomer panel0; 
   private final Connection panel1; 
   private final Home panel2;
   private final EditCustomer panel3;
   private final Checkout panel4;
   private final MyOrders panel5;
   
   //private Test2 panel2;
    
    
    
    public MyFrame() throws Exception
    {
        setTitle("Wondershop");
        initComponents();
        setVisible(true);
        
        
        resetColor();
        setColor(button1, bt1);
        
        
        panel.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        
        panel1 = new Connection(this);
        panel0 = new NewCustomer(this, panel1);
        panel2 = new Home(this);
        panel3 = new EditCustomer(this);
        panel4 = new Checkout(this);
        panel5 = new MyOrders(this);

        panel0.setVisible(false);
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        
        panel.add(panel0, c);
        panel.add(panel1, c);
        panel.add(panel2, c);
        panel.add(panel3, c);
        panel.add(panel4, c);
        panel.add(panel5, c);
        
        panel1.setVisible(true);
        
        
    }
    public void setCustomer(Customer customer)
    {
        this.customer=customer;
        System.out.println("Customer set to = " + customer.getEmail());
    }
            
    public void createAccount()
    {
        panel0.setVisible(true);
        panel1.setVisible(false);
    }
    
    public void checkout()
    {
        //menu.setVisible(false);
        panel4.setOrder(panel2.getOrder());
        panel4.setVisible(true);
        panel2.setVisible(false);
    }
    public void checkoutComplete()
    {
        resetColor();
        setColor(button4, bt4);
        panel2.setNewOrder(customer.getEmail());
        
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        
        panel5.setVisible(true);
        panel5.buildTable();
    }
    
    public void connection()
    {
        resetColor();
        setColor(button2,bt2);
        
            
        
        
        
        
       // System.out.println("Ca bug ?");
        //System.out.println("Customer email = " + customer.getEmail());
        panel2.setNewOrder(customer.getEmail());
        try
        {
            panel2.updateTable();
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        //("Customer email = " + customer.getEmail());
        panel1.setVisible(false);
        panel0.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel2.setVisible(true);
        jLabel1.setText("Disconnect");
        
    }
    
    public void setColor(JPanel panelbutton,JPanel panelbt)
    {
        panelbutton.setBackground(new Color(39,57,82));
        panelbt.setBackground(new Color(250,250,250));
    }
    
    public void resetColor()
    {
        button1.setBackground(new Color(23,35,55));
        button2.setBackground(new Color(23,35,55));
        button3.setBackground(new Color(23,35,55));
        button4.setBackground(new Color(23,35,55));
        
        bt1.setBackground(new Color(23,35,55));
        bt2.setBackground(new Color(23,35,55));
        bt3.setBackground(new Color(23,35,55));
        bt4.setBackground(new Color(23,35,55));
    }

    public Connection getPanel1()
    {
        return panel1;
    }
    
    public Customer getCustomer()
    {
        return customer;
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        menu = new javax.swing.JPanel();
        button1 = new javax.swing.JPanel();
        bt1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        button2 = new javax.swing.JPanel();
        bt2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        button3 = new javax.swing.JPanel();
        bt3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        button4 = new javax.swing.JPanel();
        bt4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu.setBackground(new java.awt.Color(23, 35, 55));
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button1.setBackground(new java.awt.Color(39, 57, 82));
        button1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            public void mouseDragged(java.awt.event.MouseEvent evt)
            {
                button1MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt)
            {
                button1MouseMoved(evt);
            }
        });
        button1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                button1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                button1MousePressed(evt);
            }
        });

        bt1.setBackground(new java.awt.Color(250, 250, 250));

        javax.swing.GroupLayout bt1Layout = new javax.swing.GroupLayout(bt1);
        bt1.setLayout(bt1Layout);
        bt1Layout.setHorizontalGroup(
            bt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        bt1Layout.setVerticalGroup(
            bt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(250, 250, 250));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(250, 250, 250));
        jLabel1.setText("Connection");

        javax.swing.GroupLayout button1Layout = new javax.swing.GroupLayout(button1);
        button1.setLayout(button1Layout);
        button1Layout.setHorizontalGroup(
            button1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button1Layout.createSequentialGroup()
                .addComponent(bt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        button1Layout.setVerticalGroup(
            button1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bt1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(button1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        menu.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 150, -1));

        button2.setBackground(new java.awt.Color(39, 57, 82));
        button2.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                button2MousePressed(evt);
            }
        });

        bt2.setBackground(new java.awt.Color(250, 250, 250));

        javax.swing.GroupLayout bt2Layout = new javax.swing.GroupLayout(bt2);
        bt2.setLayout(bt2Layout);
        bt2Layout.setHorizontalGroup(
            bt2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        bt2Layout.setVerticalGroup(
            bt2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel2.setBackground(new java.awt.Color(250, 250, 250));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(250, 250, 250));
        jLabel2.setText("Home");

        javax.swing.GroupLayout button2Layout = new javax.swing.GroupLayout(button2);
        button2.setLayout(button2Layout);
        button2Layout.setHorizontalGroup(
            button2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button2Layout.createSequentialGroup()
                .addComponent(bt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        button2Layout.setVerticalGroup(
            button2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bt2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(button2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        menu.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 150, -1));

        button3.setBackground(new java.awt.Color(39, 57, 82));
        button3.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                button3MousePressed(evt);
            }
        });

        bt3.setBackground(new java.awt.Color(250, 250, 250));

        javax.swing.GroupLayout bt3Layout = new javax.swing.GroupLayout(bt3);
        bt3.setLayout(bt3Layout);
        bt3Layout.setHorizontalGroup(
            bt3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        bt3Layout.setVerticalGroup(
            bt3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel3.setBackground(new java.awt.Color(250, 250, 250));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(250, 250, 250));
        jLabel3.setText("Account");

        javax.swing.GroupLayout button3Layout = new javax.swing.GroupLayout(button3);
        button3.setLayout(button3Layout);
        button3Layout.setHorizontalGroup(
            button3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button3Layout.createSequentialGroup()
                .addComponent(bt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        button3Layout.setVerticalGroup(
            button3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bt3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(button3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        menu.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 150, -1));

        button4.setBackground(new java.awt.Color(39, 57, 82));
        button4.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                button4MousePressed(evt);
            }
        });

        bt4.setBackground(new java.awt.Color(250, 250, 250));

        javax.swing.GroupLayout bt4Layout = new javax.swing.GroupLayout(bt4);
        bt4.setLayout(bt4Layout);
        bt4Layout.setHorizontalGroup(
            bt4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        bt4Layout.setVerticalGroup(
            bt4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel4.setBackground(new java.awt.Color(250, 250, 250));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(250, 250, 250));
        jLabel4.setText("My Orders");

        javax.swing.GroupLayout button4Layout = new javax.swing.GroupLayout(button4);
        button4.setLayout(button4Layout);
        button4Layout.setHorizontalGroup(
            button4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button4Layout.createSequentialGroup()
                .addComponent(bt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        button4Layout.setVerticalGroup(
            button4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bt4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(button4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        menu.add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 150, -1));

        jPanel1.setBackground(new java.awt.Color(23, 35, 55));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            public void mouseMoved(java.awt.event.MouseEvent evt)
            {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jPanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jPanel1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jPanel1MousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Employee");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel5)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        menu.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 150, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logoh3.gif"))); // NOI18N
        menu.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 90));

        getContentPane().add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 650));

        panel.setBackground(new java.awt.Color(62, 120, 207));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1130, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 1130, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1MouseDragged(java.awt.event.MouseEvent evt)//GEN-FIRST:event_button1MouseDragged
    {//GEN-HEADEREND:event_button1MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_button1MouseDragged

    private void button1MouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_button1MouseMoved
    {//GEN-HEADEREND:event_button1MouseMoved

    }//GEN-LAST:event_button1MouseMoved

    private void button1MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_button1MouseClicked
    {//GEN-HEADEREND:event_button1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_button1MouseClicked

    private void button1MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_button1MousePressed
    {//GEN-HEADEREND:event_button1MousePressed
        resetColor();
        setColor(button1, bt1);
        
        panel0.setVisible(false);
        panel1.setVisible(true);
        
        if(panel1.isConnected())
        {
            jLabel1.setText("Connection");
            panel1.disconnect();
            
            panel2.setVisible(false);
            panel3.setVisible(false);
            panel4.setVisible(false);
            panel5.setVisible(false);
        }
        
    }//GEN-LAST:event_button1MousePressed

    private void button2MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_button2MousePressed
    {//GEN-HEADEREND:event_button2MousePressed
        if(panel1.isConnected())
        {
            resetColor();
            setColor(button2, bt2);
            /// TEST
            panel2.setNewOrder(customer.getEmail());
            /// TEST
        
            try
            {
                panel2.updateTable();
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            
            panel1.setVisible(false);
            panel2.setVisible(true);
            panel3.setVisible(false);
            panel4.setVisible(false);
            panel5.setVisible(false);
        }
        
    }//GEN-LAST:event_button2MousePressed

    private void button3MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_button3MousePressed
    {//GEN-HEADEREND:event_button3MousePressed
        if(panel1.isConnected())
        {
            resetColor();
            setColor(button3, bt3);
        
            panel1.setVisible(false);
            panel2.setVisible(false);
            panel5.setVisible(false);
            panel3.setEmail(customer.getEmail());
            panel3.setVisible(true);
            panel4.setVisible(false);
        }
        
    }//GEN-LAST:event_button3MousePressed

    private void button4MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_button4MousePressed
    {//GEN-HEADEREND:event_button4MousePressed
        if(panel1.isConnected())
        {
            resetColor();
            setColor(button4, bt4);
            panel5.update();
        
            panel1.setVisible(false);
            panel2.setVisible(false);
            panel3.setVisible(false);
            panel4.setVisible(false);
            panel5.setVisible(true);
            //panel5.buildTable();
        }
        
    }//GEN-LAST:event_button4MousePressed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel1MousePressed
    {//GEN-HEADEREND:event_jPanel1MousePressed
        FrameEmployee wind =new FrameEmployee();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel1MouseMoved
    {//GEN-HEADEREND:event_jPanel1MouseMoved
       //  jPanel1.setBackground(new Color(39,57,82)); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseMoved

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel1MouseEntered
    {//GEN-HEADEREND:event_jPanel1MouseEntered
       jPanel1.setBackground(new Color(39,57,82)); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel1MouseExited
    {//GEN-HEADEREND:event_jPanel1MouseExited
        jPanel1.setBackground(new Color(23,35,55)); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseExited

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bt1;
    private javax.swing.JPanel bt2;
    private javax.swing.JPanel bt3;
    private javax.swing.JPanel bt4;
    private javax.swing.JPanel button1;
    private javax.swing.JPanel button2;
    private javax.swing.JPanel button3;
    private javax.swing.JPanel button4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
