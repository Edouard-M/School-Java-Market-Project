
package View;

import Model.DAO;
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
    private DAO dao;
    
    
    public Window2() throws Exception
    {
        dao=new DAO();
        setTitle("Table Products");
        setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanelProduit();
        setVisible(true);
    }
    
    public void buildPanelProduit() throws Exception
    {
        dao.getConnection();
        panel = new JPanel();
        
        String [] colNames = dao.getCol("Discount");
        String [][] data = dao.getLines("Discount");
        dao.closeConnection();
        table = new JTable(data,colNames);
        scrollTable = new JScrollPane(table);
        //table.getColumnModel().getColumn(6).setCellRenderer(new ImageCellRenderer());
        //URL url = window.class.getResource("/res/images/animated.gif");
        panel.add(scrollTable);
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