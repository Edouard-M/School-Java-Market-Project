package Controller;

import static Model.DAO.*;
import Model.*;
import View.Window2;
import View.MyFrame;
import java.net.PasswordAuthentication;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.text.DateFormatter;
//import javax.mail.*;

/**
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
 */
public class Projet
{

    private static ArrayList<Product> allProducts;
    
    public  static void main(String[] args) throws Exception
    {
        
        
        DAO dao = new DAO();
        dropAllTable();
        dao.getConnection();
        dao.createAllTable();
        dao.closeConnection();

        testDB();

        MyFrame frame = new MyFrame();
        //Window wind = new Window("marc.damp@gmail.com");
        //Window2 wind2 = new Window2();
        //CreateCustomer wind3 = new CreateCustomer();
    }

    public static void testDB() throws Exception
    {
        Product banane = new Product("banane", "fresh", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane.insertProduct();
        Product banane2 = new Product("orange", "alcohol", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane2.insertProduct();
        Product banane3 = new Product("poire", "grocery", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane3.insertProduct();
        Product banane4 = new Product("peche", "alcohol", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane4.insertProduct();
        Product banane5 = new Product("pomme", "fresh", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane5.insertProduct();
        /*Product banane6 = new Product("Banane5", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane6.insertProduct();
         Product banane7 = new Product("Banane6", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane7.insertProduct();
        Product banane8 = new Product("Banane7", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane8.insertProduct();
        Product banane9 = new Product("Banane8", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane9.insertProduct();
        Product banane10 = new Product("Banane9", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane10.insertProduct();
        Product banane1 = new Product("Banane10", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane1.insertProduct();
        Product banane12 = new Product("Banane11", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane12.insertProduct();
         Product banane13 = new Product("Banane12", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane13.insertProduct();
        Product banane14 = new Product("Banane13", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane14.insertProduct();
        Product banane15 = new Product("Banane14", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane15.insertProduct();
        Product banane16 = new Product("Banane15", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane16.insertProduct();
        Product banane17 = new Product("Banane16", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane17.insertProduct();
        Product banane18 = new Product("Banane17", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane18.insertProduct();*/
        //Product banane4 = new Product("Banane3", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        //Product banane5 = new Product("Banane4", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        //Product banane6 = new Product("Banane5", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        //Product banane7 = new Product("Banane6", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        //Product banane8 = new Product("Banane7", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        //Product banane9 = new Product("Banane8", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        Product kiwi = new Product("Kiwi", "grocery", "Un bon gros Kiwi !", 3.99, 35, null, "KiwiImg.jpg");
        kiwi.insertProduct();
        //Product kiwi2 = new Product("Kiwi2", "Fruit", "Un bon gros Kiwi !", 3.99, 35, null, "KiwiImg.jpg");
        //kiwi2.insertProduct();
        //Product kiwi3 = new Product("Kiwi3", "Fruit", "Un bon gros Kiwi !", 3.99, 35, null, "KiwiImg.jpg");
        //kiwi3.insertProduct();
        Customer Marc = new Customer("Marc", "Dampierre", 23, "0640787637", " 6 rue jean mermoz rueil-malmaison 92500", "", "");
        Marc.insertCustomer();
        Employee Fred = new Employee("Fred", "Blanchard", 33, "0678964572", "3 rue des moulins maison lafittes", "", "");
        Fred.insertEmployee();
        Employee admin = new Employee("Fredo", "Blanchard", 33, "0678964572", "3 rue des moulins maison lafittes", "admin@gmail.com", "ADMIN");
        admin.insertEmployee();
        //Discount DiscountBanane = new Discount("Banane", 10, 9);
        kiwi.addDiscount(10, 25);
        //banane5.addDiscount(12, 20);

       // Order order1 = new Order("marc.damp@gmail.com");
        
        
        
        
        
        
        addOrdersDefault();
    }

    public static void dropAllTable()
    {
        DAO dao = new DAO();
        dao.getConnection();
        dao.query("DROP TABLE Product");
        dao.query("DROP TABLE Discount");
        dao.query("DROP TABLE Customer");
        dao.query("DROP TABLE Employee");
        dao.query("DROP TABLE OrderedProduct");
        dao.query("DROP TABLE Orders");
        dao.closeConnection();
       // System.out.println("All Table Droped");
    }
    
    
    
    public static void addOrdersDefault()
    {
        try{
            /*
            Order order = new Order("DefaultEmail");
            order.setDate(createDate("02/11/2020"));
            ArrayList<OrderedProduct> list1 = new ArrayList<>();
            list1.add(new OrderedProduct(order.getId(), 0, "Banane", 10, 0));
            list1.add(new OrderedProduct(order.getId(), 0, "Kiwi", 10, 0));
            order.setArrayList(list1);
            order.insertAllOrder();
            */
            
            /*Order order2 = new Order("DefaultEmail");
            order2.setDate(createDate("03/10/2020"));
            ArrayList<OrderedProduct> list2 = new ArrayList<>();
            list2.add(new OrderedProduct(order2.getId(), 0, "Banane", 10, 0));
            list2.add(new OrderedProduct(order2.getId(), 0, "Kiwi", 11, 0));
            order2.setArrayList(list2);
            order2.insertAllOrder();*/
            DAO dao = new DAO();  
            dao.getConnection();
            allProducts = dao.selectAllProducts();
            dao.closeConnection();
            
            for(int i=1 ; i<=30 ; i++)
            {
                int or = 0 + (int)(Math.random() * ((2 - 0) + 1));
                if(or == 0)
                {
                Order ord = new Order("DefaultEmail");
                if(i<10)
                    ord.setDate(createDate("0" + String.valueOf(i) + "/10/2020"));
                else
                    ord.setDate(createDate(String.valueOf(i) + "/10/2020"));
                
                ord.setArrayList(aleaProduct(ord));
                ord.insertAllOrder();
                }
            }
            for(int i=1 ; i<=30 ; i++)
            {
                int or = 0 + (int)(Math.random() * ((2 - 0) + 1));
                if(or == 0)
                {
                Order ord = new Order("DefaultEmail");
                if(i<10)
                    ord.setDate(createDate("0" + String.valueOf(i) + "/11/2020"));
                else
                    ord.setDate(createDate(String.valueOf(i) + "/11/2020"));
                
                ord.setArrayList(aleaProduct(ord));
                ord.insertAllOrder();
                }
            }
            
        
            
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public  static ArrayList<OrderedProduct> aleaProduct(Order ord)
    {
        ArrayList<OrderedProduct> list = new ArrayList<>();
        int orderAmount = 0 + (int)(Math.random() * ((2 - 0) + 1));
        
        try{
        
            for(int i=0 ; i<orderAmount ; i++)
            {
                int productNum = 0 + (int)(Math.random() * (((allProducts.size()-1) - 0) + 1));
                int quantity = 1 + (int)(Math.random() * (((10) - 1) + 1));
                list.add(new OrderedProduct(ord.getId(), 0, allProducts.get(productNum).getName(), quantity, 0));
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return list;
    }
    
    public static Date createDate(String str)
    {
        java.util.Date date = null;
        try
        {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(str);
        } 
        catch (ParseException e)
        {
            System.out.println("Error date");
            System.out.println(e.getMessage());
        }
        
        Date dateSQL = new java.sql.Date(date.getTime()); 
        
        return dateSQL;
    }

}
