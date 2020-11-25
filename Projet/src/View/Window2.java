
package View;

import static Model.DAO.*;
import Model.Product;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import static java.awt.SystemColor.window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
 */
public class Window2 extends JFrame
{
    final int WIDTH_WINDOW = 800;
    final int HEIGHT_WINDOW = 700;
    
    private JPanel panel;
    private JTable table;
    private JLabel label;
    private ImageIcon imageIcon;
    JScrollPane scrollTable;
    
    private JLabel currentLabel;
    private ImageIcon currentImageIcon;
    private String currentImage;
    
    
    public Window2() throws Exception
    {
        setTitle("Table Products");
        setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanelProduit();
        setVisible(true);
    }
    
    public void buildPanelProduit() throws Exception
    {
        panel = new JPanel();
        
        String [] colNames = getCol("Product");
        System.out.println("test 1");
        String [][] data = getLines("Product");
        System.out.println("test 2");
        

        table = new JTable(data,colNames);
        scrollTable = new JScrollPane(table);
        //table.getColumnModel().getColumn(6).setCellRenderer(new ImageCellRenderer());
        //URL url = window.class.getResource("/res/images/animated.gif");
        imageIcon = new ImageIcon("src/path.gif");
        label = new JLabel(imageIcon);
        
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        
        panel1.add(label);
        panel2.add(scrollTable);
        panel.setLayout(new GridLayout(3,1));
        
        
        panel.add(panel1);
        panel.add(panel2);
        add(panel);
        //add(label);
        //add(scrollTable);
        
        //panel.add(scrollTable);
        //add(panel);
    }
    
    
     public void buildPanel() throws Exception
    {
        panel = new JPanel();
        
      
        //URL url = window.class.getResource("/res/images/animated.gif");
        imageIcon = new ImageIcon("src/Image/path.gif");
        label = new JLabel(imageIcon);
        JTextField password= new JTextField("password");
        JTextField email =new JTextField("email");
        JButton connect =new JButton("Connect");
        JButton newAccount =new JButton("create account");
        JButton employee= new JButton("I'm an Employee");
       
        
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        
        panel1.add(employee);
        panel2.add(label);
        panel3.add(email);
        panel4.add(password);
        panel5.add(connect);
        panel5.add(newAccount);
        panel.setLayout(new GridLayout(5,1));
        
        
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
         panel.add(panel4);
        panel.add(panel5);
        add(panel);
        //add(label);
        //add(scrollTable);
        
        //panel.add(scrollTable);
        //add(panel);
    }
     
    public class TableListener implements ListSelectionListener
    {
        
        @Override
        public void valueChanged(ListSelectionEvent e)
        {
            int viewRow = table.getSelectedRow();
            String name = (String) table.getValueAt(viewRow, 0);
            currentImage = (String) table.getValueAt(viewRow, 6);
            System.out.println("Selected : " + name);
            System.out.println("Selected image : " + currentImage);
            

            panel.remove(2);
            currentImageIcon = new ImageIcon("src/Image/"+currentImage);
            currentLabel = new JLabel(currentImageIcon);
            JPanel newPanel = new JPanel();
            newPanel.add(currentLabel);
            panel.add(newPanel);
            add(panel);
            revalidate();
            repaint();
        }
    }
         
    public class Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("test");
            //if(e.getSource() == calcButton)
         
        }
    }
     
    public final static class ImageCellRenderer extends DefaultTableCellRenderer {
 
		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
 
			Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
 
			JLabel label = (JLabel)component;
			String cheminImage = String.valueOf(value);
 
			ImageIcon icon = new ImageIcon(cheminImage);
 
			if ( icon.getImageLoadStatus()==java.awt.MediaTracker.COMPLETE ) {
				label.setIcon(icon);
				table.setRowHeight(row, icon.getIconHeight());
			}
			else {
				label.setIcon(null);
				table.setRowHeight(row, table.getRowHeight());
			}
			label.setText(""); // on efface le texte
 
                            System.out.println("Non test");
			return component;
		}
 
 
	}
    
    
}