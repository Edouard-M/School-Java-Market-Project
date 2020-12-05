/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//GIT PROJET
package View;

import Controller.HomeController;
import Model.Discount;
import Model.Order;
import Model.OrderedProduct;
import Model.Product;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.util.Map;
/**
 *
 * @author Edoua
 */
public class Home extends javax.swing.JPanel implements ActionListener
{

    final int WIDTH_WINDOW = 800;
    final int HEIGHT_WINDOW = 700;
    

    private Order order;
    private String customerEmail;
    private ArrayList<Product> allProductsList;
    private DefaultTableModel cartModel;
    private DefaultTableModel tableModel;

    private MyFrame myFrame;
    private JPanel panel;
    //private JTable table;
    private JLabel label;
    private ImageIcon imageIcon;
    JScrollPane scrollTable;

    private ImageIcon currentImageIcon;
    private String currentImage;
    private String currentName;

    private final Timer timer = new Timer(1, this);
    private boolean onlydiscount;
    private String selectedCategroy;
    private boolean clicked;

    private int p21;
    private int p22;
    private int p23;
    private int p24;
    private int p25;
    private int tableSize;

    private int viewRow;

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3;
    private int x4;
    private int y4;
    private int x5;
    private int y5;

    private Object[][] allData;
    private HomeController controller;

    /**
     * Creates new form Home
     */
    public Home(MyFrame myFrame) throws Exception
    {
        this.myFrame = myFrame;
        controller = new HomeController();
        initComponents();

        //jLabel1.setIcon(new ImageIcon("src/Image/path.gif"));
        selectedCategroy = "all";
        onlydiscount = false;
        buildPanel();

        //cartTable.setAutoResizeMode(1);
        //cartTable.setSize(310, 50);
        x1 = (int) jPanel21.getLocation().getX();
        y1 = (int) jPanel21.getLocation().getY();
        x2 = (int) jPanel22.getLocation().getX();
        y2 = (int) jPanel22.getLocation().getY();
        x3 = (int) jPanel23.getLocation().getX();
        y3 = (int) jPanel23.getLocation().getY();
        x4 = (int) jPanel24.getLocation().getX();
        y4 = (int) jPanel24.getLocation().getY();
        x5 = (int) jPanel25.getLocation().getX();
        y5 = (int) jPanel25.getLocation().getY();
        System.out.println("X1 = " + x1);
        System.out.println("Y1 = " + y1);

    }

    public Order getOrder()
    {
        return order;
    }

    public void resetPosition()
    {
        jPanel21.setLocation(90, 16);
        jPanel22.setLocation(90, 162);
        jPanel23.setLocation(90, 308);
        jPanel24.setLocation(90, 454);
        jPanel25.setLocation(90, 600);
    }

    public void setClicked(boolean state)
    {
        clicked = state;
    }

    public boolean isOnTop()
    {
        boolean top = false;

        if (p21 == -1 || p22 == -1 || p23 == -1 || p24 == -1 || p25 == -1)
            top = true;

        return top;
    }

    public boolean isOnBottom()
    {
        boolean bottom = false;
        int bot = tableSize;

        if (p21 == tableSize || p22 == tableSize || p23 == tableSize || p24 == tableSize || p25 == tableSize)
            bottom = true;

        return bottom;
    }

    public void setNewOrder(String email)
    {
        this.customerEmail = email;
        order = new Order(email);
    }

    public void buildPanel() throws Exception
    {

        viewRow = 1;

        order = new Order("");
        System.out.println("Date : " + order.getDate());
        labelDate.setText(order.getDate().toString());

        timer.start();

        panel = new JPanel();
        allProductsList = controller.searchAllProductsList();
        p21 = 0;
        p22 = 1;
        p23 = 2;
        p24 = 3;
        p25 = 4;

        updateTable();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[]
        {
        }));

        table.getSelectionModel().addListSelectionListener(new Home.TableListener());

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(50);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(50);
        columnModel.getColumn(4).setPreferredWidth(50);
        columnModel.getColumn(5).setPreferredWidth(50);

        TableColumnModel cartColumnModel = cartTable.getColumnModel();
        cartColumnModel.getColumn(0).setPreferredWidth(70);
        cartColumnModel.getColumn(1).setPreferredWidth(100);
        cartColumnModel.getColumn(2).setPreferredWidth(75);

        setTableStyle(table);
        setTableStyle(cartTable);

        jScrollPane3.setBackground(new Color(62, 120, 207));

        //cartTable.setPreferredSize(new Dimension(310, 288));
        cartTable.setPreferredSize(new Dimension(310, 250));
        cartTable.getTableHeader().setBackground(new Color(77, 128, 216));
        cartTable.getTableHeader().setForeground(new Color(255, 255, 255));
        cartTable.getTableHeader().setFont(new Font("Sergoe UI", Font.PLAIN, 12));

        //jScrollPane3.resize(310, 50);
        //jScrollPane3.setPreferredSize(new Dimension(310, 50));
        //jScrollPane3.setSize(new Dimension(310, 50));
        setScrollItem();
        resetColor();

        table.setVisible(false);
        table.getTableHeader().setVisible(false);

    }

    public void deleteCart()
    {
        //cartTable.removeAll();

        order = new Order("");
        try
        {
            String[] colNames = new String[]
            {
                "Quantity", "Product", "Cost (€)"
            };
            String[][] data = new String[order.getOrderedProducts().size()][3];
            String[][] data2 = new String[3][order.getOrderedProducts().size()];
            for (int i = 0; i < order.getOrderedProducts().size(); i++)
            {
                data[i][0] = String.valueOf(order.getOrderedProducts().get(i).getQuantity());
                data[i][1] = String.valueOf(order.getOrderedProducts().get(i).getProductName());
                data[i][2] = String.valueOf(order.getOrderedProducts().get(i).getPrice());

                data2[0][i] = data[i][0];
                data2[1][i] = data[i][1];
                data2[2][i] = data[i][2];
            }

            cartModel.setDataVector(data, colNames);

            //jList1.setListData(data2[0]);
            //jList1.setListData(data2[0]);
            TableColumnModel cartColumnModel = cartTable.getColumnModel();
            cartColumnModel.getColumn(0).setPreferredWidth(70);
            cartColumnModel.getColumn(1).setPreferredWidth(100);
            cartColumnModel.getColumn(2).setPreferredWidth(75);
            jLabel12.setText(String.valueOf(order.totalCost()) + " €");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public void researchUpdate(String recherche) throws Exception
    {
        p21 = 0;
        p22 = 1;
        p23 = 2;
        p24 = 3;
        p25 = 4;

        String[][] data = controller.getData();

        String[] colNamesFilter =
        {
            "Name", "Category", "Description", "Stock", "Price (€)", "Image"
        };
        String[][] dataFilter = new String[data.length][6];
        allData = new Object[data.length][7];
        int j = 0;
        //allData =  "Name", "Category", "Description", "Stock", "Price (€)", "Image", "Discount"
        if (!("".equals(recherche) || "Research".equals(recherche)))
        {

            for (int i = 0; i < data.length; i++)
                if (selectedCategroy.equals("all"))
                {
                    if (data[i][0].contains(recherche))
                    {
                        dataFilter[j][0] = data[i][0];
                        dataFilter[j][1] = data[i][1];
                        dataFilter[j][2] = data[i][2];
                        dataFilter[j][3] = data[i][4];
                        dataFilter[j][4] = data[i][3];
                        dataFilter[j][5] = data[i][6];

                        allData[j][0] = data[i][0];
                        allData[j][1] = data[i][1];
                        allData[j][2] = data[i][2];
                        allData[j][3] = data[i][4];
                        allData[j][4] = data[i][3];
                        allData[j][5] = resize((String) dataFilter[j][5], 100, 100);
                        allData[j][6] = controller.findDiscount((String) allData[j][0]);
                        j++;
                    }
                } else if (data[i][0].contains(recherche) && data[i][1].equals(selectedCategroy))
                {
                    dataFilter[j][0] = data[i][0];
                    dataFilter[j][1] = data[i][1];
                    dataFilter[j][2] = data[i][2];
                    dataFilter[j][3] = data[i][4];
                    dataFilter[j][4] = data[i][3];
                    dataFilter[j][5] = data[i][6];

                    allData[j][0] = data[i][0];
                    allData[j][1] = data[i][1];
                    allData[j][2] = data[i][2];
                    allData[j][3] = data[i][4];
                    allData[j][4] = data[i][3];
                    allData[j][5] = resize((String) dataFilter[j][5], 100, 100);
                    allData[j][6] = controller.findDiscount((String) allData[j][0]);
                    j++;
                }

            tableSize = j;
        } else
        {

            //allData =  "Name", "Category", "Description", "Stock", "Price (€)", "Image", "Discount"
            for (int i = 0; i < data.length; i++)
                if (selectedCategroy.equals("all"))
                {

                    dataFilter[j][0] = data[i][0];
                    dataFilter[j][1] = data[i][1];
                    dataFilter[j][2] = data[i][2];
                    dataFilter[j][3] = data[i][4];
                    dataFilter[j][4] = data[i][3];
                    dataFilter[j][5] = data[i][6];

                    allData[j][0] = data[i][0];
                    allData[j][1] = data[i][1];
                    allData[j][2] = data[i][2];
                    allData[j][3] = data[i][4];
                    allData[j][4] = data[i][3];
                    allData[j][5] = resize((String) dataFilter[j][5], 100, 100);
                    allData[j][6] = controller.findDiscount((String) allData[j][0]);
                    j++;

                } else
                    if (data[i][1].equals(selectedCategroy))
                    {
                        dataFilter[j][0] = data[i][0];
                        dataFilter[j][1] = data[i][1];
                        dataFilter[j][2] = data[i][2];
                        dataFilter[j][3] = data[i][4];
                        dataFilter[j][4] = data[i][3];
                        dataFilter[j][5] = data[i][6];

                        allData[j][0] = data[i][0];
                        allData[j][1] = data[i][1];
                        allData[j][2] = data[i][2];
                        allData[j][3] = data[i][4];
                        allData[j][4] = data[i][3];
                        allData[j][5] = resize((String) dataFilter[j][5], 100, 100);
                        allData[j][6] = controller.findDiscount((String) allData[j][0]);
                        j++;
                    }
            tableSize = j;
        }

        tableModel = (DefaultTableModel) table.getModel();

        tableModel.setDataVector(dataFilter, colNamesFilter);

        if (tableSize < 5)
        {
            if (p21 < tableSize && p21 >= 0)
                enablePanel(jPanel21);
            else
                disablePanel(jPanel21);

            if (p22 < tableSize && p22 >= 0)
                enablePanel(jPanel22);
            else
                disablePanel(jPanel22);

            if (p23 < tableSize && p23 >= 0)
                enablePanel(jPanel23);
            else
                disablePanel(jPanel23);

            if (p24 < tableSize && p24 >= 0)
                enablePanel(jPanel24);
            else
                disablePanel(jPanel24);

            if (p25 < tableSize && p25 >= 0)
                enablePanel(jPanel25);
            else
                disablePanel(jPanel25);
        } else
        {
            if (p21 < tableSize && p21 >= 0)
                enablePanel(jPanel21);
            if (p22 < tableSize && p22 >= 0)
                enablePanel(jPanel22);
            if (p23 < tableSize && p23 >= 0)
                enablePanel(jPanel23);
            if (p24 < tableSize && p24 >= 0)
                enablePanel(jPanel24);
            if (p25 < tableSize && p25 >= 0)
                enablePanel(jPanel25);
        }

        setScrollItem();
        resetColor();
        resetPosition();
        table.setVisible(false);
        table.getTableHeader().setVisible(false);
    }

    public void discountUpdate() throws Exception
    {
        p21 = 0;
        p22 = 1;
        p23 = 2;
        p24 = 3;
        p25 = 4;

        String[][] data = controller.getData();
        String[][] dataDiscount = controller.getDataDiscount();
        String[] colNamesFilter =
        {
            "Name", "Category", "Description", "Stock", "Price (€)", "Image"
        };
        String[][] dataFilter = new String[dataDiscount.length][6];
        allData = new Object[data.length][7];

        //allData =  "Name", "Category", "Description", "Stock", "Price (€)", "Image", "Discount"
        for (int j = 0; j < dataDiscount.length; j++)
            for (int i = 0; i < data.length; i++)
                if (dataDiscount[j][0].equals(data[i][0]))
                {
                    dataFilter[j][0] = data[i][0];
                    dataFilter[j][1] = data[i][1];
                    dataFilter[j][2] = data[i][2];
                    dataFilter[j][3] = data[i][4];
                    dataFilter[j][4] = data[i][3];
                    dataFilter[j][5] = data[i][6];

                    allData[j][0] = data[i][0];
                    allData[j][1] = data[i][1];
                    allData[j][2] = data[i][2];
                    allData[j][3] = data[i][4];
                    allData[j][4] = data[i][3];
                    allData[j][5] = resize((String) dataFilter[j][5], 100, 100);
                    allData[j][6] = controller.findDiscount((String) allData[j][0]);

                }

        tableSize = dataDiscount.length;

        tableModel = (DefaultTableModel) table.getModel();

        tableModel.setDataVector(dataFilter, colNamesFilter);

        if (tableSize < 5)
        {
            if (p21 < tableSize && p21 >= 0)
                enablePanel(jPanel21);
            else
                disablePanel(jPanel21);

            if (p22 < tableSize && p22 >= 0)
                enablePanel(jPanel22);
            else
                disablePanel(jPanel22);

            if (p23 < tableSize && p23 >= 0)
                enablePanel(jPanel23);
            else
                disablePanel(jPanel23);

            if (p24 < tableSize && p24 >= 0)
                enablePanel(jPanel24);
            else
                disablePanel(jPanel24);

            if (p25 < tableSize && p25 >= 0)
                enablePanel(jPanel25);
            else
                disablePanel(jPanel25);
        } else
        {
            if (p21 < tableSize && p21 >= 0)
                enablePanel(jPanel21);
            if (p22 < tableSize && p22 >= 0)
                enablePanel(jPanel22);
            if (p23 < tableSize && p23 >= 0)
                enablePanel(jPanel23);
            if (p24 < tableSize && p24 >= 0)
                enablePanel(jPanel24);
            if (p25 < tableSize && p25 >= 0)
                enablePanel(jPanel25);
        }

        setScrollItem();
        resetColor();
        resetPosition();
        table.setVisible(false);
        table.getTableHeader().setVisible(false);
    }

    public void updateTable() throws Exception
    {
        //resetPosition();
        /*p21=0;
        p22=1;
        p23=2;
        p24=3;
        p25=4;*/
        onlydiscount = false;
        selectedCategroy = "all";
        Font font = jLabel5.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        jLabel2.setFont(font.deriveFont(attributes));
        attributes.clear();
        jLabel4.setFont(font.deriveFont(attributes));
        jLabel3.setFont(font.deriveFont(attributes));
        jLabel7.setFont(font.deriveFont(attributes));
        String[][] data = controller.getData();

        String[] colNamesFilter =
        {
            "Name", "Category", "Description", "Stock", "Price (€)", "Image"
        };
        String[][] dataFilter = new String[data.length][6];
        allData = new Object[data.length][7];
        //allData =  "Name", "Category", "Description", "Stock", "Price (€)", "Image", "Discount"
        for (int i = 0; i < data.length; i++)
        {
            dataFilter[i][0] = data[i][0];
            dataFilter[i][1] = data[i][1];
            dataFilter[i][2] = data[i][2];
            dataFilter[i][3] = data[i][4];
            dataFilter[i][4] = data[i][3];
            dataFilter[i][5] = data[i][6];

            allData[i][0] = data[i][0];
            allData[i][1] = data[i][1];
            allData[i][2] = data[i][2];
            allData[i][3] = data[i][4];
            allData[i][4] = data[i][3];
            allData[i][5] = resize((String) dataFilter[i][5], 100, 100);
            allData[i][6] = controller.findDiscount((String) allData[i][0]);

            /* System.out.println("AllData [i][0] = " + (String) allData[i][0]);
            if(controller.findDiscount((String) allData[i][0]) != null)
                System.out.println("Quantity Discount = " + controller.findDiscount((String) allData[i][0]).getQuantity());
            
            if(allData[i][6]==null)
                System.out.println(allData[i][0] + " Pas Discount");
            else
                System.out.println(allData[i][0] + " Discount");*/
        }

        tableSize = data.length;

        cartModel = (DefaultTableModel) cartTable.getModel();
        tableModel = (DefaultTableModel) table.getModel();

        tableModel.setDataVector(dataFilter, colNamesFilter);

        if (tableSize < 5)
        {
            if (p21 < tableSize && p21 >= 0)
                enablePanel(jPanel21);
            else
                disablePanel(jPanel21);

            if (p22 < tableSize && p22 >= 0)
                enablePanel(jPanel22);
            else
                disablePanel(jPanel22);

            if (p23 < tableSize && p23 >= 0)
                enablePanel(jPanel23);
            else
                disablePanel(jPanel23);

            if (p24 < tableSize && p24 >= 0)
                enablePanel(jPanel24);
            else
                disablePanel(jPanel24);

            if (p25 < tableSize && p25 >= 0)
                enablePanel(jPanel25);
            else
                disablePanel(jPanel25);
        } else
        {
            if (p21 < tableSize && p21 >= 0)
                enablePanel(jPanel21);
            if (p22 < tableSize && p22 >= 0)
                enablePanel(jPanel22);
            if (p23 < tableSize && p23 >= 0)
                enablePanel(jPanel23);
            if (p24 < tableSize && p24 >= 0)
                enablePanel(jPanel24);
            if (p25 < tableSize && p25 >= 0)
                enablePanel(jPanel25);
        }
        setScrollItem();
        resetColor();

        table.setVisible(false);
        table.getTableHeader().setVisible(false);

        deleteCart();

    }

    public ImageIcon resize(String imagei, int width, int height)
    {
        ImageIcon imageIcon = new ImageIcon("src/Image/" + imagei); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back

        return imageIcon;
    }

    public void setDiscount(JLabel discountTriangle, JLabel dTexte1, JLabel dTexte2, JLabel dTexte3, Discount discount)
    {
        try
        {

            if (discount != null)
            {
                discountTriangle.setVisible(true);
                dTexte1.setVisible(true);
                dTexte2.setVisible(true);
                dTexte3.setVisible(true);

                dTexte1.setText(Integer.toString(discount.getQuantity()));
                dTexte3.setText(Double.toString(discount.getPrice())+" €");

            } else
            {
                discountTriangle.setVisible(false);
                dTexte1.setVisible(false);
                dTexte2.setVisible(false);
                dTexte3.setVisible(false);
            }
        } catch (Exception ex)
        {
            ex.getMessage();
        }
    }

    public void setScrollItem()
    {
        if (p21 >= 0 && p21 < tableSize)
        {
            //image21.setIcon(resize((String) (table.getValueAt(p21, 5)), 100, 100));
            image21.setIcon((ImageIcon) allData[p21][5]);
            jLabel21.setText((String) table.getValueAt(p21, 0));
            jLabel211.setText((String) table.getValueAt(p21, 4) + " €");
            jLabel21D.setText((String) table.getValueAt(p21, 2));
            if (!allData[p21][0].equals(currentName))
                jPanel21.setBackground(new Color(113, 168, 255));
            else
                jPanel21.setBackground(new Color(23, 35, 55));

            setDiscount(discountTriangle1, d21Text1, d21Text2, d21Text3, (Discount) allData[p21][6]);
            
            if(Integer.parseInt( String.valueOf(table.getValueAt(p21,3))) == 0)
                jLabel21OUTOFSTOCK.setVisible(true);
            else
                jLabel21OUTOFSTOCK.setVisible(false);
            
        }
        if (p22 >= 0 && p22 < tableSize)
        {
            //image22.setIcon(resize((String) (table.getValueAt(p22, 5)), 100, 100));
            image22.setIcon((ImageIcon) allData[p22][5]);
            jLabel22.setText((String) table.getValueAt(p22, 0));
            jLabel222.setText((String) table.getValueAt(p22, 4) + " €");
            jLabel22D.setText((String) table.getValueAt(p22, 2));
            if (!allData[p22][0].equals(currentName))
                jPanel22.setBackground(new Color(113, 168, 255));
            else
                jPanel22.setBackground(new Color(23, 35, 55));

            setDiscount(discountTriangle2, d22Text1, d22Text2, d22Text3, (Discount) allData[p22][6]);
            
            if(Integer.parseInt( String.valueOf(table.getValueAt(p22,3))) == 0)
                jLabel22OUTOFSTOCK.setVisible(true);
            else
                jLabel22OUTOFSTOCK.setVisible(false);
        }
        if (p23 >= 0 && p23 < tableSize)
        {
            //image23.setIcon(resize((String) (table.getValueAt(p23, 5)), 100, 100));
            image23.setIcon((ImageIcon) allData[p23][5]);
            jLabel23.setText((String) table.getValueAt(p23, 0));
            jLabel233.setText((String) table.getValueAt(p23, 4) + " €");
            jLabel23D.setText((String) table.getValueAt(p23, 2));
            if (!allData[p23][0].equals(currentName))
                jPanel23.setBackground(new Color(113, 168, 255));
            else
                jPanel23.setBackground(new Color(23, 35, 55));

            setDiscount(discountTriangle3, d23Text1, d23Text2, d23Text3, (Discount) allData[p23][6]);
            
            if(Integer.parseInt( String.valueOf(table.getValueAt(p23,3))) == 0)
                jLabel23OUTOFSTOCK.setVisible(true);
            else
                jLabel23OUTOFSTOCK.setVisible(false);
        }
        if (p24 >= 0 && p24 < tableSize)
        {
            //image24.setIcon(resize((String) (table.getValueAt(p24, 5)), 100, 100));
            image24.setIcon((ImageIcon) allData[p24][5]);
            jLabel24.setText((String) table.getValueAt(p24, 0));
            jLabel244.setText((String) table.getValueAt(p24, 4) + " €");
            jLabel24D.setText((String) table.getValueAt(p24, 2));
            if (!allData[p24][0].equals(currentName))
                jPanel24.setBackground(new Color(113, 168, 255));
            else
                jPanel24.setBackground(new Color(23, 35, 55));

            setDiscount(discountTriangle4, d24Text1, d24Text2, d24Text3, (Discount) allData[p24][6]);
            
            if(Integer.parseInt( String.valueOf(table.getValueAt(p24,3))) == 0)
                jLabel24OUTOFSTOCK.setVisible(true);
            else
                jLabel24OUTOFSTOCK.setVisible(false);
        }
        if (p25 >= 0 && p25 < tableSize)
        {
            //image25.setIcon(resize((String) (table.getValueAt(p25, 5)), 100, 100));
            image25.setIcon((ImageIcon) allData[p25][5]);
            jLabel25.setText((String) table.getValueAt(p25, 0));
            jLabel255.setText((String) table.getValueAt(p25, 4) + " €");
            jLabel25D.setText((String) table.getValueAt(p25, 2));
            if (!allData[p25][0].equals(currentName))
                jPanel25.setBackground(new Color(113, 168, 255));
            else
                jPanel25.setBackground(new Color(23, 35, 55));

            setDiscount(discountTriangle5, d25Text1, d25Text2, d25Text3, (Discount) allData[p25][6]);
            
            if(Integer.parseInt( String.valueOf(table.getValueAt(p25,3))) == 0)
                jLabel25OUTOFSTOCK.setVisible(true);
            else
                jLabel25OUTOFSTOCK.setVisible(false);
        }

        //ImageIcon imageIcon = new ImageIcon("src/Image/BananeImg.jpg");
        //image21.setIcon(imageIcon);
    }

    public void setTableStyle(JTable tableStyle)
    {
        JTableHeader tableHeader = tableStyle.getTableHeader();
        tableHeader.setOpaque(true);
        tableHeader.setBackground(new Color(255, 255, 255));
        tableHeader.setForeground(new Color(0, 0, 0));
        Border lineborder = BorderFactory.createLineBorder(Color.WHITE, 1);
        Border border = BorderFactory.createRaisedSoftBevelBorder();
        Border border2 = BorderFactory.createBevelBorder(1, new Color(235, 235, 235), new Color(255, 255, 255));
        Border border3 = BorderFactory.createEtchedBorder(new Color(235, 235, 235), new Color(255, 255, 255));

        tableHeader.setFont(new Font("Sergoe UI", Font.PLAIN, 12));
        tableStyle.setFont(new Font("Sergeo UI", Font.PLAIN, 12));

        tableHeader.setBorder(border3);
    }

    public void selectionUpdate()
    {
        int quantity = 0;

        currentName = (String) table.getValueAt(viewRow, 0);
        //jTextPane1.setText((String) table.getValueAt(viewRow, 2));
        //currentImage = (String) table.getValueAt(viewRow, 5);

        for (int i = 0; i < allProductsList.size(); i++)
            if (currentName.equals(allProductsList.get(i).getName()))
                currentImage = allProductsList.get(i).getImage();

        quantity = Integer.parseInt((String) table.getValueAt(viewRow, 3));
        Discount discount = null;

        String[] comboBox = new String[quantity + 1];
        for (int i = 0; i <= quantity; i++)
            comboBox[i] = "" + i;
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(comboBox));

        jLabel10.setText("0 €");

//            try
//            {
//                discount = searchDiscount(currentName);
//                if(discount != null)
//                {
//                    jLabel4.setText("BUY "+ discount.getQuantity() + " " + discount.getName());
//                    jLabel3.setText("FOR");
//                    jLabel5.setText("" + discount.getPrice() + " € !!");
//                }
//                else
//                {
//                    jLabel4.setText("NO DISCOUNT");
//                    jLabel3.setText("");
//                    jLabel5.setText("");
//                }
//            } catch (Exception ex)
//            {
//                ex.getMessage();
//            }
    }

    public class TableListener implements ListSelectionListener
    {

        @Override
        public void valueChanged(ListSelectionEvent e)
        {
            int viewRow = table.getSelectedRow();
            int quantity = 0;

            currentName = (String) table.getValueAt(viewRow, 0);
            jTextPane1.setText((String) table.getValueAt(viewRow, 2));
            //currentImage = (String) table.getValueAt(viewRow, 5);

            for (int i = 0; i < allProductsList.size(); i++)
                if (currentName.equals(allProductsList.get(i).getName()))
                    currentImage = allProductsList.get(i).getImage();

            quantity = Integer.parseInt((String) table.getValueAt(viewRow, 3));
            Discount discount = null;

            String[] comboBox = new String[quantity + 1];
            for (int i = 0; i <= quantity; i++)
                comboBox[i] = "" + i;
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(comboBox));

            jLabel10.setText("0 €");

            /*ImageIcon imageIcon = new ImageIcon("src/Image/" + currentImage); // load the image to a imageIcon
            Image image = imageIcon.getImage(); // transform it 
            Image newimg = image.getScaledInstance(314, 110,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            imageIcon = new ImageIcon(newimg);  // transform it back
     
            currentLabel.setIcon(imageIcon);*/
        }
    }

    public void resetColor()
    {
        jPanel21.setBackground(new Color(113, 168, 255));
        jPanel22.setBackground(new Color(113, 168, 255));
        jPanel23.setBackground(new Color(113, 168, 255));
        jPanel24.setBackground(new Color(113, 168, 255));
        jPanel25.setBackground(new Color(113, 168, 255));

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        /*if(clicked == true)
        {
            jPanel2.setSize(0, jPanel2.getHeight());
            //jPanel4.setSize(0, jPanel4.getHeight());
            jPanel7.setLocation(( (int) jPanel7.getLocation().getX()), ((int) jPanel7.getLocation().getY())+jPanel7.getHeight());
            clicked = false;
        }
        
        if(jPanel2.getWidth() < 370)
            jPanel2.setSize(jPanel2.getWidth()+10, jPanel2.getHeight());
        //if(jPanel2.getWidth() >= 370)
           // jPanel4.setSize(jPanel4.getWidth()+20, jPanel4.getHeight());
        if(jPanel7.getLocation().getY() > 50)
            jPanel7.setLocation((int) (jPanel7.getLocation().getX()), (int) jPanel7.getLocation().getY()-8);
         */
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel6 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        image21 = new javax.swing.JLabel();
        jLabel21OUTOFSTOCK = new javax.swing.JLabel();
        d21Text2 = new javax.swing.JLabel();
        d21Text3 = new javax.swing.JLabel();
        d21Text1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel211 = new javax.swing.JLabel();
        jLabel21D = new javax.swing.JLabel();
        discountTriangle1 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        image22 = new javax.swing.JLabel();
        jLabel22OUTOFSTOCK = new javax.swing.JLabel();
        d22Text2 = new javax.swing.JLabel();
        d22Text3 = new javax.swing.JLabel();
        d22Text1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel222 = new javax.swing.JLabel();
        jLabel22D = new javax.swing.JLabel();
        discountTriangle2 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        image23 = new javax.swing.JLabel();
        jLabel23OUTOFSTOCK = new javax.swing.JLabel();
        d23Text2 = new javax.swing.JLabel();
        d23Text3 = new javax.swing.JLabel();
        d23Text1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel233 = new javax.swing.JLabel();
        jLabel23D = new javax.swing.JLabel();
        discountTriangle3 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        image24 = new javax.swing.JLabel();
        jLabel24OUTOFSTOCK = new javax.swing.JLabel();
        d24Text2 = new javax.swing.JLabel();
        d24Text3 = new javax.swing.JLabel();
        d24Text1 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel244 = new javax.swing.JLabel();
        jLabel24D = new javax.swing.JLabel();
        discountTriangle4 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        image25 = new javax.swing.JLabel();
        jLabel25OUTOFSTOCK = new javax.swing.JLabel();
        d25Text2 = new javax.swing.JLabel();
        d25Text3 = new javax.swing.JLabel();
        d25Text1 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel255 = new javax.swing.JLabel();
        jLabel25D = new javax.swing.JLabel();
        discountTriangle5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel4 = new javax.swing.JPanel();
        labelDate = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(77, 128, 216));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setBackground(new java.awt.Color(23, 35, 55));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(23, 35, 55), 1, true));
        jComboBox1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel6.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Quantity :");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Price :");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText(" 0 €");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, 30));

        jButton1.setBackground(new java.awt.Color(62, 120, 207));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("add to cart");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 80, 150, -1));

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 360, 130));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.addMouseWheelListener(new java.awt.event.MouseWheelListener()
        {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt)
            {
                jPanel8MouseWheelMoved(evt);
            }
        });
        jPanel8.setLayout(null);

        jPanel21.setBackground(new java.awt.Color(23, 35, 55));
        jPanel21.addMouseWheelListener(new java.awt.event.MouseWheelListener()
        {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt)
            {
                jPanel21MouseWheelMoved(evt);
            }
        });
        jPanel21.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jPanel21MousePressed(evt);
            }
        });
        jPanel21.setLayout(null);

        jPanel12.setBackground(new java.awt.Color(113, 168, 255));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image21, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image21, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel21.add(jPanel12);
        jPanel12.setBounds(25, 14, 100, 100);

        jLabel21OUTOFSTOCK.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel21OUTOFSTOCK.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21OUTOFSTOCK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21OUTOFSTOCK.setText("OUT OF STOCK");
        jPanel21.add(jLabel21OUTOFSTOCK);
        jLabel21OUTOFSTOCK.setBounds(270, 80, 230, 50);

        d21Text2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        d21Text2.setForeground(new java.awt.Color(255, 51, 51));
        d21Text2.setText("for");
        jPanel21.add(d21Text2);
        d21Text2.setBounds(550, 80, 30, 16);

        d21Text3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        d21Text3.setForeground(new java.awt.Color(255, 51, 51));
        d21Text3.setText("25 €");
        jPanel21.add(d21Text3);
        d21Text3.setBounds(530, 100, 70, 16);

        d21Text1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        d21Text1.setForeground(new java.awt.Color(255, 51, 51));
        d21Text1.setText("10");
        jPanel21.add(d21Text1);
        d21Text1.setBounds(570, 70, 30, 16);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("ITEM 1");
        jPanel21.add(jLabel21);
        jLabel21.setBounds(160, 10, 270, 60);

        jLabel211.setBackground(new java.awt.Color(204, 204, 204));
        jLabel211.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel211.setForeground(new java.awt.Color(255, 255, 255));
        jLabel211.setText("ITEM 1");
        jPanel21.add(jLabel211);
        jLabel211.setBounds(440, 40, 150, 60);

        jLabel21D.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21D.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21D.setText("jLabel2");
        jPanel21.add(jLabel21D);
        jLabel21D.setBounds(160, 66, 240, 50);

        discountTriangle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/triangleDiscount.png"))); // NOI18N
        jPanel21.add(discountTriangle1);
        discountTriangle1.setBounds(500, 30, 100, 100);

        jPanel8.add(jPanel21);
        jPanel21.setBounds(90, 16, 600, 130);

        jPanel22.setBackground(new java.awt.Color(113, 168, 255));
        jPanel22.addMouseWheelListener(new java.awt.event.MouseWheelListener()
        {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt)
            {
                jPanel22MouseWheelMoved(evt);
            }
        });
        jPanel22.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jPanel22MousePressed(evt);
            }
        });
        jPanel22.setLayout(null);

        jPanel13.setBackground(new java.awt.Color(113, 168, 255));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image22, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image22, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel22.add(jPanel13);
        jPanel13.setBounds(26, 18, 100, 100);

        jLabel22OUTOFSTOCK.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel22OUTOFSTOCK.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22OUTOFSTOCK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22OUTOFSTOCK.setText("OUT OF STOCK");
        jPanel22.add(jLabel22OUTOFSTOCK);
        jLabel22OUTOFSTOCK.setBounds(270, 80, 230, 50);

        d22Text2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        d22Text2.setForeground(new java.awt.Color(255, 51, 51));
        d22Text2.setText("for");
        jPanel22.add(d22Text2);
        d22Text2.setBounds(550, 80, 30, 16);

        d22Text3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        d22Text3.setForeground(new java.awt.Color(255, 51, 51));
        d22Text3.setText("25 €");
        jPanel22.add(d22Text3);
        d22Text3.setBounds(530, 100, 70, 16);

        d22Text1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        d22Text1.setForeground(new java.awt.Color(255, 51, 51));
        d22Text1.setText("10");
        jPanel22.add(d22Text1);
        d22Text1.setBounds(570, 70, 30, 16);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("ITEM 2");
        jPanel22.add(jLabel22);
        jLabel22.setBounds(160, 10, 270, 60);

        jLabel222.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel222.setForeground(new java.awt.Color(255, 255, 255));
        jLabel222.setText("ITEM 2");
        jPanel22.add(jLabel222);
        jLabel222.setBounds(440, 40, 150, 60);

        jLabel22D.setBackground(new java.awt.Color(187, 187, 187));
        jLabel22D.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22D.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22D.setText("jLabel2");
        jPanel22.add(jLabel22D);
        jLabel22D.setBounds(160, 66, 240, 50);

        discountTriangle2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/triangleDiscount.png"))); // NOI18N
        jPanel22.add(discountTriangle2);
        discountTriangle2.setBounds(500, 30, 100, 100);

        jPanel8.add(jPanel22);
        jPanel22.setBounds(90, 162, 600, 130);

        jPanel23.setBackground(new java.awt.Color(113, 168, 255));
        jPanel23.addMouseWheelListener(new java.awt.event.MouseWheelListener()
        {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt)
            {
                jPanel23MouseWheelMoved(evt);
            }
        });
        jPanel23.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jPanel23MousePressed(evt);
            }
        });
        jPanel23.setLayout(null);

        jPanel14.setBackground(new java.awt.Color(113, 168, 255));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image23, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image23, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel23.add(jPanel14);
        jPanel14.setBounds(30, 19, 100, 100);

        jLabel23OUTOFSTOCK.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel23OUTOFSTOCK.setForeground(new java.awt.Color(255, 0, 0));
        jLabel23OUTOFSTOCK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23OUTOFSTOCK.setText("OUT OF STOCK");
        jPanel23.add(jLabel23OUTOFSTOCK);
        jLabel23OUTOFSTOCK.setBounds(270, 80, 230, 50);

        d23Text2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        d23Text2.setForeground(new java.awt.Color(255, 51, 51));
        d23Text2.setText("for");
        jPanel23.add(d23Text2);
        d23Text2.setBounds(550, 80, 30, 16);

        d23Text3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        d23Text3.setForeground(new java.awt.Color(255, 51, 51));
        d23Text3.setText("25 €");
        jPanel23.add(d23Text3);
        d23Text3.setBounds(530, 100, 70, 16);

        d23Text1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        d23Text1.setForeground(new java.awt.Color(255, 51, 51));
        d23Text1.setText("10");
        jPanel23.add(d23Text1);
        d23Text1.setBounds(570, 70, 30, 16);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("ITEM 3");
        jPanel23.add(jLabel23);
        jLabel23.setBounds(160, 10, 270, 60);

        jLabel233.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel233.setForeground(new java.awt.Color(255, 255, 255));
        jLabel233.setText("ITEM 3");
        jPanel23.add(jLabel233);
        jLabel233.setBounds(440, 40, 150, 60);

        jLabel23D.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23D.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23D.setText("jLabel2");
        jPanel23.add(jLabel23D);
        jLabel23D.setBounds(160, 66, 240, 50);

        discountTriangle3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/triangleDiscount.png"))); // NOI18N
        jPanel23.add(discountTriangle3);
        discountTriangle3.setBounds(500, 30, 100, 100);

        jPanel8.add(jPanel23);
        jPanel23.setBounds(90, 308, 600, 130);

        jPanel24.setBackground(new java.awt.Color(113, 168, 255));
        jPanel24.addMouseWheelListener(new java.awt.event.MouseWheelListener()
        {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt)
            {
                jPanel24MouseWheelMoved(evt);
            }
        });
        jPanel24.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jPanel24MousePressed(evt);
            }
        });
        jPanel24.setLayout(null);

        jPanel15.setBackground(new java.awt.Color(113, 168, 255));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image24, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image24, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel24.add(jPanel15);
        jPanel15.setBounds(30, 19, 100, 100);

        jLabel24OUTOFSTOCK.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel24OUTOFSTOCK.setForeground(new java.awt.Color(255, 0, 0));
        jLabel24OUTOFSTOCK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24OUTOFSTOCK.setText("OUT OF STOCK");
        jPanel24.add(jLabel24OUTOFSTOCK);
        jLabel24OUTOFSTOCK.setBounds(270, 80, 230, 50);

        d24Text2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        d24Text2.setForeground(new java.awt.Color(255, 51, 51));
        d24Text2.setText("for");
        jPanel24.add(d24Text2);
        d24Text2.setBounds(550, 80, 30, 16);

        d24Text3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        d24Text3.setForeground(new java.awt.Color(255, 51, 51));
        d24Text3.setText("25 €");
        jPanel24.add(d24Text3);
        d24Text3.setBounds(530, 100, 70, 16);

        d24Text1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        d24Text1.setForeground(new java.awt.Color(255, 51, 51));
        d24Text1.setText("10");
        jPanel24.add(d24Text1);
        d24Text1.setBounds(570, 70, 30, 16);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("ITEM 4");
        jPanel24.add(jLabel24);
        jLabel24.setBounds(160, 10, 270, 60);

        jLabel244.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel244.setForeground(new java.awt.Color(255, 255, 255));
        jLabel244.setText("ITEM 4");
        jPanel24.add(jLabel244);
        jLabel244.setBounds(440, 40, 150, 60);

        jLabel24D.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24D.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24D.setText("jLabel2");
        jPanel24.add(jLabel24D);
        jLabel24D.setBounds(160, 66, 240, 50);

        discountTriangle4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/triangleDiscount.png"))); // NOI18N
        jPanel24.add(discountTriangle4);
        discountTriangle4.setBounds(500, 30, 100, 100);

        jPanel8.add(jPanel24);
        jPanel24.setBounds(90, 454, 600, 130);

        jPanel25.setBackground(new java.awt.Color(113, 168, 255));
        jPanel25.addMouseWheelListener(new java.awt.event.MouseWheelListener()
        {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt)
            {
                jPanel25MouseWheelMoved(evt);
            }
        });
        jPanel25.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jPanel25MousePressed(evt);
            }
        });
        jPanel25.setLayout(null);

        jPanel17.setBackground(new java.awt.Color(113, 168, 255));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image25, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image25, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel25.add(jPanel17);
        jPanel17.setBounds(30, 19, 100, 100);

        jLabel25OUTOFSTOCK.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel25OUTOFSTOCK.setForeground(new java.awt.Color(255, 0, 0));
        jLabel25OUTOFSTOCK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25OUTOFSTOCK.setText("OUT OF STOCK");
        jPanel25.add(jLabel25OUTOFSTOCK);
        jLabel25OUTOFSTOCK.setBounds(270, 80, 230, 50);

        d25Text2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        d25Text2.setForeground(new java.awt.Color(255, 51, 51));
        d25Text2.setText("for");
        jPanel25.add(d25Text2);
        d25Text2.setBounds(550, 80, 30, 16);

        d25Text3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        d25Text3.setForeground(new java.awt.Color(255, 51, 51));
        d25Text3.setText("25 €");
        jPanel25.add(d25Text3);
        d25Text3.setBounds(530, 100, 70, 16);

        d25Text1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        d25Text1.setForeground(new java.awt.Color(255, 51, 51));
        d25Text1.setText("10");
        jPanel25.add(d25Text1);
        d25Text1.setBounds(570, 70, 30, 16);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("ITEM 5");
        jPanel25.add(jLabel25);
        jLabel25.setBounds(160, 10, 270, 60);

        jLabel255.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel255.setForeground(new java.awt.Color(255, 255, 255));
        jLabel255.setText("ITEM 5");
        jPanel25.add(jLabel255);
        jLabel255.setBounds(440, 40, 150, 60);

        jLabel25D.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25D.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25D.setText("jLabel2");
        jPanel25.add(jLabel25D);
        jLabel25D.setBounds(160, 66, 240, 50);

        discountTriangle5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/triangleDiscount.png"))); // NOI18N
        jPanel25.add(discountTriangle5);
        discountTriangle5.setBounds(500, 30, 100, 100);

        jPanel8.add(jPanel25);
        jPanel25.setBounds(90, 600, 600, 130);

        add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 50, 770, 800));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        table.setBackground(new java.awt.Color(255, 255, 255));
        table.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        table.setForeground(new java.awt.Color(0, 0, 0));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String []
            {
                "0", "1", "2", "3", "4", "5", "6"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(255, 255, 255));
        table.setRowHeight(22);
        table.setSelectionBackground(new java.awt.Color(62, 120, 207));
        table.setSelectionForeground(new java.awt.Color(255, 255, 255));
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 320, 730, 320));

        jPanel2.setBackground(new java.awt.Color(62, 120, 207));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(62, 120, 207), 1, true));
        jScrollPane3.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        cartTable.setBackground(new java.awt.Color(62, 120, 207));
        cartTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cartTable.setForeground(new java.awt.Color(255, 255, 255));
        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Quantity", "Product", "Price"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        cartTable.setGridColor(new java.awt.Color(23, 35, 55));
        cartTable.setRowHeight(22);
        cartTable.setSelectionBackground(new java.awt.Color(23, 35, 55));
        cartTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        cartTable.setShowHorizontalLines(false);
        cartTable.setShowVerticalLines(false);
        cartTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(cartTable);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 310, 272));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cart Total :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, 20));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("0 €");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Remove From Cart");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, -1, -1));

        jPanel5.setBackground(new java.awt.Color(113, 168, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Good deals only");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jLabel5MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jLabel5MousePressed(evt);
            }
        });
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 80));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 360, 80));

        jTextField1.setBackground(new java.awt.Color(62, 120, 207));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("Research");
        jTextField1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 290, 30));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Checkout");
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 600, 150, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 370, 650));

        jPanel3.setBackground(new java.awt.Color(245, 247, 253));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(245, 247, 253));
        jScrollPane2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(245, 247, 253), 1, true));
        jScrollPane2.setForeground(new java.awt.Color(245, 247, 253));

        jTextPane1.setEditable(false);
        jTextPane1.setBackground(new java.awt.Color(245, 247, 253));
        jTextPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(245, 247, 253), 1, true));
        jTextPane1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(jTextPane1);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 610, 100));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 770, 140));

        jPanel4.setBackground(new java.awt.Color(62, 120, 207));
        jPanel4.setLayout(null);

        labelDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelDate.setForeground(new java.awt.Color(255, 255, 255));
        labelDate.setText("Date");
        jPanel4.add(labelDate);
        labelDate.setBounds(650, 10, 110, 25);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Greek groceries");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jLabel3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jLabel3MousePressed(evt);
            }
        });
        jPanel4.add(jLabel3);
        jLabel3.setBounds(160, 0, 140, 50);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Greek alcohol");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jLabel4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jLabel4MousePressed(evt);
            }
        });
        jPanel4.add(jLabel4);
        jLabel4.setBounds(310, 0, 140, 50);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Fresh products");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jLabel7MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jLabel7MousePressed(evt);
            }
        });
        jPanel4.add(jLabel7);
        jLabel7.setBounds(460, 0, 150, 50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("All products");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jLabel2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jLabel2MousePressed(evt);
            }
        });
        jPanel4.add(jLabel2);
        jLabel2.setBounds(0, 0, 150, 50);

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 770, 50));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 650));
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBox1ActionPerformed
    {//GEN-HEADEREND:event_jComboBox1ActionPerformed

        if (jComboBox1.getSelectedIndex() >= 0)
            try
            {
                currentName = (String) table.getValueAt(viewRow, 0);
                double unitPrice = Double.parseDouble((String) table.getValueAt(viewRow, 4));
                int quantity = jComboBox1.getSelectedIndex();

                Discount discount = controller.findDiscount(currentName);
                double total;
                
                if (discount != null && discount.getQuantity() <= quantity)
                {

                    int dQuantity = discount.getQuantity();
                    double dPrice = discount.getPrice();
                    total = ((quantity % dQuantity) * unitPrice) + ((quantity - (quantity % dQuantity)) / dQuantity * dPrice);
                } else
                    total = quantity * unitPrice;
                total = Math.round(total * 100.0) / 100.0;
                
                jLabel10.setText(String.valueOf(total) + " €");
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed

        int quantity = jComboBox1.getSelectedIndex();
        if (quantity > 0 && tableSize > 0)
        {
            int id = 0;
            int orderID = order.getId();
            String name = (String) table.getValueAt(viewRow, 0);

            double cost = (Double.parseDouble((String) table.getValueAt(viewRow, 4)));
            cost = Math.round(cost * 100.0) / 100.0;
            if (order.getProduct(name) != null)
                if ((quantity + order.getProduct(name).getQuantity()) > Integer.parseInt((String) table.getValueAt(viewRow, 3)))
                    quantity = Integer.parseInt((String) table.getValueAt(viewRow, 3)) - order.getProduct(name).getQuantity();

            if (quantity != 0)
            {
                try
                {
                    order.addOrderedProduct(new OrderedProduct(orderID, id, name, quantity, cost));
                } catch (Exception ex)
                {
                    System.out.println(ex.getMessage());
                }

                try
                {
                    String[] colNames = new String[]
                    {
                        "Quantity", "Product", "Cost (€)"
                    };
                    String[][] data = new String[order.getOrderedProducts().size()][3];
                    String[][] data2 = new String[3][order.getOrderedProducts().size()];
                    for (int i = 0; i < order.getOrderedProducts().size(); i++)
                    {
                        data[i][0] = String.valueOf(order.getOrderedProducts().get(i).getQuantity());
                        data[i][1] = String.valueOf(order.getOrderedProducts().get(i).getProductName());
                        data[i][2] = String.valueOf(order.getOrderedProducts().get(i).getPrice());

                        data2[0][i] = data[i][0];
                        data2[1][i] = data[i][1];
                        data2[2][i] = data[i][2];
                    }

                    cartModel.setDataVector(data, colNames);
                    //jList1.setListData(data2[0]);
                    //jList1.setListData(data2[0]);

                    TableColumnModel cartColumnModel = cartTable.getColumnModel();
                    cartColumnModel.getColumn(0).setPreferredWidth(70);
                    cartColumnModel.getColumn(1).setPreferredWidth(100);
                    cartColumnModel.getColumn(2).setPreferredWidth(75);

                } catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }

                jLabel12.setText(String.valueOf(order.totalCost()) + " €");

            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed

        if (order.getOrderedProducts().size() > 0 && cartTable.getSelectedRow() >= 0)
        {
            viewRow = cartTable.getSelectedRow();
            currentName = (String) cartTable.getValueAt(viewRow, 1);
            order.removeOrderedProduct(currentName);

            try
            {
                String[] colNames = new String[]
                {
                    "Quantity", "Product", "Cost (€)"
                };
                String[][] data = new String[order.getOrderedProducts().size()][3];
                String[][] data2 = new String[3][order.getOrderedProducts().size()];
                for (int i = 0; i < order.getOrderedProducts().size(); i++)
                {
                    data[i][0] = String.valueOf(order.getOrderedProducts().get(i).getQuantity());
                    data[i][1] = String.valueOf(order.getOrderedProducts().get(i).getProductName());
                    data[i][2] = String.valueOf(order.getOrderedProducts().get(i).getPrice());

                    data2[0][i] = data[i][0];
                    data2[1][i] = data[i][1];
                    data2[2][i] = data[i][2];
                }

                cartModel.setDataVector(data, colNames);

                //jList1.setListData(data2[0]);
                //jList1.setListData(data2[0]);
                TableColumnModel cartColumnModel = cartTable.getColumnModel();
                cartColumnModel.getColumn(0).setPreferredWidth(70);
                cartColumnModel.getColumn(1).setPreferredWidth(100);
                cartColumnModel.getColumn(2).setPreferredWidth(75);
                jLabel12.setText(String.valueOf(order.totalCost()) + " €");
            } catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel21MouseWheelMoved(java.awt.event.MouseWheelEvent evt)//GEN-FIRST:event_jPanel21MouseWheelMoved
    {//GEN-HEADEREND:event_jPanel21MouseWheelMoved
        jPanel8MouseWheelMoved(evt);
    }//GEN-LAST:event_jPanel21MouseWheelMoved

    private void jPanel22MouseWheelMoved(java.awt.event.MouseWheelEvent evt)//GEN-FIRST:event_jPanel22MouseWheelMoved
    {//GEN-HEADEREND:event_jPanel22MouseWheelMoved
        jPanel8MouseWheelMoved(evt);
    }//GEN-LAST:event_jPanel22MouseWheelMoved

    private void jPanel23MouseWheelMoved(java.awt.event.MouseWheelEvent evt)//GEN-FIRST:event_jPanel23MouseWheelMoved
    {//GEN-HEADEREND:event_jPanel23MouseWheelMoved
        jPanel8MouseWheelMoved(evt);
    }//GEN-LAST:event_jPanel23MouseWheelMoved

    private void jPanel24MouseWheelMoved(java.awt.event.MouseWheelEvent evt)//GEN-FIRST:event_jPanel24MouseWheelMoved
    {//GEN-HEADEREND:event_jPanel24MouseWheelMoved
        jPanel8MouseWheelMoved(evt);
    }//GEN-LAST:event_jPanel24MouseWheelMoved

    private void jPanel25MouseWheelMoved(java.awt.event.MouseWheelEvent evt)//GEN-FIRST:event_jPanel25MouseWheelMoved
    {//GEN-HEADEREND:event_jPanel25MouseWheelMoved
        jPanel8MouseWheelMoved(evt);
    }//GEN-LAST:event_jPanel25MouseWheelMoved

    public void setItemPanel(JLabel label, int p)
    {
        label.setText("Item " + p);

    }

    private void jPanel8MouseWheelMoved(java.awt.event.MouseWheelEvent evt)//GEN-FIRST:event_jPanel8MouseWheelMoved
    {//GEN-HEADEREND:event_jPanel8MouseWheelMoved
        //déplacement
        if (!isOnTop() && evt.getWheelRotation() > 0)
        {
            jPanel21.setLocation((int) jPanel21.getLocation().getX(), (int) jPanel21.getLocation().getY() - 20);
            jPanel22.setLocation((int) jPanel22.getLocation().getX(), (int) jPanel22.getLocation().getY() - 20);
            jPanel23.setLocation((int) jPanel23.getLocation().getX(), (int) jPanel23.getLocation().getY() - 20);
            jPanel24.setLocation((int) jPanel24.getLocation().getX(), (int) jPanel24.getLocation().getY() - 20);
            jPanel25.setLocation((int) jPanel25.getLocation().getX(), (int) jPanel25.getLocation().getY() - 20);
        }
        if (evt.getWheelRotation() < 0 && !isOnBottom())
        {
            jPanel21.setLocation((int) jPanel21.getLocation().getX(), (int) jPanel21.getLocation().getY() + 20);
            jPanel22.setLocation((int) jPanel22.getLocation().getX(), (int) jPanel22.getLocation().getY() + 20);
            jPanel23.setLocation((int) jPanel23.getLocation().getX(), (int) jPanel23.getLocation().getY() + 20);
            jPanel24.setLocation((int) jPanel24.getLocation().getX(), (int) jPanel24.getLocation().getY() + 20);
            jPanel25.setLocation((int) jPanel25.getLocation().getX(), (int) jPanel25.getLocation().getY() + 20);
        }

        // Boucle infini vers le bas (panel tp de haut en bas)
        if (!isOnBottom())
        {
            if (jPanel21.getLocation().getY() <= -130)
            {
                jPanel21.setLocation((int) jPanel21.getLocation().getX(), (int) jPanel25.getLocation().getY() + 146);
                p21 += 5;
                setItemPanel(jLabel21, p21);
                setScrollItem();
            }
            if (jPanel22.getLocation().getY() <= -130)
            {
                jPanel22.setLocation((int) jPanel22.getLocation().getX(), (int) jPanel21.getLocation().getY() + 146);
                p22 += 5;
                setItemPanel(jLabel22, p22);
                setScrollItem();
            }
            if (jPanel23.getLocation().getY() <= -130)
            {
                jPanel23.setLocation((int) jPanel23.getLocation().getX(), (int) jPanel22.getLocation().getY() + 146);
                p23 += 5;
                setItemPanel(jLabel23, p23);
                setScrollItem();
            }
            if (jPanel24.getLocation().getY() <= -130)
            {
                jPanel24.setLocation((int) jPanel24.getLocation().getX(), (int) jPanel23.getLocation().getY() + 146);
                p24 += 5;
                setItemPanel(jLabel24, p24);
                setScrollItem();
            }
            if (jPanel25.getLocation().getY() <= -130)
            {
                jPanel25.setLocation((int) jPanel25.getLocation().getX(), (int) jPanel24.getLocation().getY() + 146);
                p25 += 5;
                setItemPanel(jLabel25, p25);
                setScrollItem();
            }
        }

        if (!isOnTop())
        {
            // Boucle infini vers le haut (panel tp de bas en haut)
            if (jPanel21.getLocation().getY() > 600)
            {
                jPanel21.setLocation((int) jPanel21.getLocation().getX(), (int) jPanel22.getLocation().getY() - 146);
                p21 -= 5;
                setItemPanel(jLabel21, p21);
                setScrollItem();
            }
            if (jPanel22.getLocation().getY() > 600)
            {
                jPanel22.setLocation((int) jPanel22.getLocation().getX(), (int) jPanel23.getLocation().getY() - 146);
                p22 -= 5;
                setItemPanel(jLabel22, p22);
                setScrollItem();
            }
            if (jPanel23.getLocation().getY() > 600)
            {
                jPanel23.setLocation((int) jPanel23.getLocation().getX(), (int) jPanel24.getLocation().getY() - 146);
                p23 -= 5;
                setItemPanel(jLabel23, p23);
                setScrollItem();
            }
            if (jPanel24.getLocation().getY() > 600)
            {
                jPanel24.setLocation((int) jPanel24.getLocation().getX(), (int) jPanel25.getLocation().getY() - 146);
                p24 -= 5;
                setItemPanel(jLabel24, p24);
                setScrollItem();
            }
            if (jPanel25.getLocation().getY() > 600)
            {
                jPanel25.setLocation((int) jPanel25.getLocation().getX(), (int) jPanel21.getLocation().getY() - 146);
                p25 -= 5;
                setItemPanel(jLabel25, p25);
                setScrollItem();
            }
        }

        if (isOnTop())
        {
            jPanel21.setLocation((int) jPanel21.getLocation().getX(), (int) jPanel21.getLocation().getY() - 20);
            jPanel22.setLocation((int) jPanel22.getLocation().getX(), (int) jPanel22.getLocation().getY() - 20);
            jPanel23.setLocation((int) jPanel23.getLocation().getX(), (int) jPanel23.getLocation().getY() - 20);
            jPanel24.setLocation((int) jPanel24.getLocation().getX(), (int) jPanel24.getLocation().getY() - 20);
            jPanel25.setLocation((int) jPanel25.getLocation().getX(), (int) jPanel25.getLocation().getY() - 20);
        }

        if (isOnBottom())
        {
            jPanel21.setLocation((int) jPanel21.getLocation().getX(), (int) jPanel21.getLocation().getY() + 20);
            jPanel22.setLocation((int) jPanel22.getLocation().getX(), (int) jPanel22.getLocation().getY() + 20);
            jPanel23.setLocation((int) jPanel23.getLocation().getX(), (int) jPanel23.getLocation().getY() + 20);
            jPanel24.setLocation((int) jPanel24.getLocation().getX(), (int) jPanel24.getLocation().getY() + 20);
            jPanel25.setLocation((int) jPanel25.getLocation().getX(), (int) jPanel25.getLocation().getY() + 20);
        }

    }//GEN-LAST:event_jPanel8MouseWheelMoved

    public void enablePanel(JPanel panel1)
    {
        panel1.setVisible(true);
    }

    public void disablePanel(JPanel panel1)
    {
        panel1.setVisible(false);
    }

    private void jPanel21MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel21MousePressed
    {//GEN-HEADEREND:event_jPanel21MousePressed
        if (p21 < tableSize && p21 >= 0)
        {
            enablePanel(jPanel21);
            viewRow = p21;
            resetColor();
            jPanel21.setBackground(new Color(23, 35, 55));
            jLabel21D.setForeground(new Color(255, 255, 255));
            selectionUpdate();
        } else
            disablePanel(jPanel21);
    }//GEN-LAST:event_jPanel21MousePressed

    private void jPanel22MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel22MousePressed
    {//GEN-HEADEREND:event_jPanel22MousePressed
        if (p22 < tableSize && p22 >= 0)
        {
            enablePanel(jPanel22);
            viewRow = p22;
            resetColor();
            jPanel22.setBackground(new Color(23, 35, 55));
            jLabel22D.setForeground(new Color(255, 255, 255));
            selectionUpdate();
        } else
            disablePanel(jPanel22);
    }//GEN-LAST:event_jPanel22MousePressed

    private void jPanel23MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel23MousePressed
    {//GEN-HEADEREND:event_jPanel23MousePressed
        if (p23 < tableSize && p23 >= 0)
        {
            enablePanel(jPanel23);
            viewRow = p23;
            resetColor();
            jPanel23.setBackground(new Color(23, 35, 55));
            jLabel23D.setForeground(new Color(255, 255, 255));
            selectionUpdate();
        } else
            disablePanel(jPanel23);
    }//GEN-LAST:event_jPanel23MousePressed

    private void jPanel24MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel24MousePressed
    {//GEN-HEADEREND:event_jPanel24MousePressed
        if (p24 < tableSize && p24 >= 0)
        {
            enablePanel(jPanel24);
            viewRow = p24;
            resetColor();
            jPanel24.setBackground(new Color(23, 35, 55));
            jLabel24D.setForeground(new Color(255, 255, 255));
            selectionUpdate();
        } else
            disablePanel(jPanel24);
    }//GEN-LAST:event_jPanel24MousePressed

    private void jPanel25MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPanel25MousePressed
    {//GEN-HEADEREND:event_jPanel25MousePressed
        if (p25 < tableSize && p25 >= 0)
        {
            enablePanel(jPanel25);
            viewRow = p25;
            resetColor();
            jPanel25.setBackground(new Color(23, 35, 55));
            jLabel25D.setForeground(new Color(255, 255, 255));
            selectionUpdate();
        } else
            disablePanel(jPanel25);
    }//GEN-LAST:event_jPanel25MousePressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField1ActionPerformed
    {//GEN-HEADEREND:event_jTextField1ActionPerformed
        try
        {
            jPanel5.setBackground(new Color(113, 168, 255));
            onlydiscount = false;
            System.out.println(evt.getActionCommand());

            researchUpdate(evt.getActionCommand());

        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        System.out.println("Finish Order");
        myFrame.checkout();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel5MouseClicked
    {//GEN-HEADEREND:event_jLabel5MouseClicked
    
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel2MouseClicked
    {//GEN-HEADEREND:event_jLabel2MouseClicked
    
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel3MouseClicked
    {//GEN-HEADEREND:event_jLabel3MouseClicked
         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel4MouseClicked
    {//GEN-HEADEREND:event_jLabel4MouseClicked
         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel7MouseClicked
    {//GEN-HEADEREND:event_jLabel7MouseClicked
       // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel2MousePressed
    {//GEN-HEADEREND:event_jLabel2MousePressed
         try
        {
            Font font = jLabel5.getFont();
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            jLabel2.setFont(font.deriveFont(attributes));
            attributes.clear();
            jLabel4.setFont(font.deriveFont(attributes));
            jLabel3.setFont(font.deriveFont(attributes));
            jLabel7.setFont(font.deriveFont(attributes));
            jPanel5.setBackground(new Color(113, 168, 255));
            onlydiscount = false;
            selectedCategroy = "all";
            researchUpdate(jTextField1.getText());
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }   
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel3MousePressed
    {//GEN-HEADEREND:event_jLabel3MousePressed
     try
        {
            Font font = jLabel5.getFont();
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            jLabel3.setFont(font.deriveFont(attributes));
            attributes.clear();
            jLabel2.setFont(font.deriveFont(attributes));
            jLabel4.setFont(font.deriveFont(attributes));
            jLabel7.setFont(font.deriveFont(attributes));
            jPanel5.setBackground(new Color(113, 168, 255));
            onlydiscount = false;
            selectedCategroy = "grocery";
            researchUpdate(jTextField1.getText());// TODO add your handling code here:
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel4MousePressed
    {//GEN-HEADEREND:event_jLabel4MousePressed
       try
        {
            Font font = jLabel5.getFont();
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            jLabel4.setFont(font.deriveFont(attributes));
            attributes.clear();
            jLabel2.setFont(font.deriveFont(attributes));
            jLabel3.setFont(font.deriveFont(attributes));
            jLabel7.setFont(font.deriveFont(attributes));
            jPanel5.setBackground(new Color(113, 168, 255));
            onlydiscount = false;
            selectedCategroy = "alcohol";
            researchUpdate(jTextField1.getText());// TODO add your handling code here:
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel7MousePressed
    {//GEN-HEADEREND:event_jLabel7MousePressed
     try
        {
            Font font = jLabel5.getFont();
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            jLabel7.setFont(font.deriveFont(attributes));
            attributes.clear();
            jLabel2.setFont(font.deriveFont(attributes));
            jLabel3.setFont(font.deriveFont(attributes));
            jLabel4.setFont(font.deriveFont(attributes));
            jPanel5.setBackground(new Color(113, 168, 255));
            onlydiscount = false;
            selectedCategroy = "fresh";
            researchUpdate(jTextField1.getText());// TODO add your handling code here:
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MousePressed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel5MousePressed
    {//GEN-HEADEREND:event_jLabel5MousePressed
        if (onlydiscount == false)
            try
            {
                onlydiscount = true;
                jPanel5.setBackground(new Color(23, 35, 55));
                discountUpdate();
                Font font = jLabel5.getFont();
                Map attributes = font.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                jLabel2.setFont(font.deriveFont(attributes));
                attributes.clear();
                jLabel4.setFont(font.deriveFont(attributes));
                jLabel3.setFont(font.deriveFont(attributes));
                jLabel7.setFont(font.deriveFont(attributes));
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        else
            try
            {
                onlydiscount = false;
                selectedCategroy = "all";
                researchUpdate("");
                jPanel5.setBackground(new Color(113, 168, 255));
                //updateTable();
            } catch (Exception e)
            {
                System.out.println(e.getMessage());
            } // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable cartTable;
    private javax.swing.JLabel d21Text1;
    private javax.swing.JLabel d21Text2;
    private javax.swing.JLabel d21Text3;
    private javax.swing.JLabel d22Text1;
    private javax.swing.JLabel d22Text2;
    private javax.swing.JLabel d22Text3;
    private javax.swing.JLabel d23Text1;
    private javax.swing.JLabel d23Text2;
    private javax.swing.JLabel d23Text3;
    private javax.swing.JLabel d24Text1;
    private javax.swing.JLabel d24Text2;
    private javax.swing.JLabel d24Text3;
    private javax.swing.JLabel d25Text1;
    private javax.swing.JLabel d25Text2;
    private javax.swing.JLabel d25Text3;
    private javax.swing.JLabel discountTriangle1;
    private javax.swing.JLabel discountTriangle2;
    private javax.swing.JLabel discountTriangle3;
    private javax.swing.JLabel discountTriangle4;
    private javax.swing.JLabel discountTriangle5;
    private javax.swing.JLabel image21;
    private javax.swing.JLabel image22;
    private javax.swing.JLabel image23;
    private javax.swing.JLabel image24;
    private javax.swing.JLabel image25;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel21D;
    private javax.swing.JLabel jLabel21OUTOFSTOCK;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel22D;
    private javax.swing.JLabel jLabel22OUTOFSTOCK;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel23D;
    private javax.swing.JLabel jLabel23OUTOFSTOCK;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel244;
    private javax.swing.JLabel jLabel24D;
    private javax.swing.JLabel jLabel24OUTOFSTOCK;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel255;
    private javax.swing.JLabel jLabel25D;
    private javax.swing.JLabel jLabel25OUTOFSTOCK;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel labelDate;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
