
package Controller;
import static Model.DAO.*;
import Model.*;
import View.Window2;
import View.MyFrame;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
 */
public class Projet
{
    public static void main(String[] args) throws Exception
    {
        dropAllTable();
        createAllTable();
        
        testDB();
        
        MyFrame frame = new MyFrame();
        //Window wind = new Window("marc.damp@gmail.com");
        //Window2 wind2 = new Window2();
        //CreateCustomer wind3 = new CreateCustomer();
    }
    
    public static void testDB() throws Exception
    {
        Product banane = new Product("Banane", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane.insertProduct();
        Product banane2 = new Product("Banane1", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane2.insertProduct();
        Product banane3 = new Product("Banane2", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane3.insertProduct();
        Product banane4 = new Product("Banane3", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane4.insertProduct();
        Product banane5 = new Product("Banane4", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
        banane5.insertProduct();
        Product banane6 = new Product("Banane5", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "BananeImg.jpg");
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
        banane18.insertProduct();
        //Product banane4 = new Product("Banane3", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        //Product banane5 = new Product("Banane4", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        //Product banane6 = new Product("Banane5", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        //Product banane7 = new Product("Banane6", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        //Product banane8 = new Product("Banane7", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        //Product banane9 = new Product("Banane8", "Fruit", "Une banane de 22cm !", 2.50, 45, null, "image");
        Product kiwi = new Product("Kiwi", "Fruit", "Un bon gros Kiwi !", 3.99, 35, null, "KiwiImg.jpg");
        kiwi.insertProduct();
        Product kiwi2 = new Product("Kiwi2", "Fruit", "Un bon gros Kiwi !", 3.99, 35, null, "KiwiImg.jpg");
        kiwi2.insertProduct();
        Product kiwi3 = new Product("Kiwi3", "Fruit", "Un bon gros Kiwi !", 3.99, 35, null, "KiwiImg.jpg");
        kiwi3.insertProduct();
        Customer Marc = new Customer("Marc", "Dampierre", 23, "0640787637", " 6 rue jean mermoz rueil-malmaison 92500", "", "");
        Employee Fred =new Employee("Fred", "Blanchard", 33, "0678964572", "3 rue des moulins maison lafittes", "", "");
        Fred.insertEmployee();
        Employee admin =new Employee("Fredo", "Blanchard", 33, "0678964572", "3 rue des moulins maison lafittes", "admin@gmail.com", "ADMIN");
        admin.insertEmployee();
        OrderedProduct OrderedBanane= new OrderedProduct(1,1,"Banane", 10,12);
        OrderedProduct OrderedKiwi= new OrderedProduct(1,2,"Kiwi", 5,12);
        //Discount DiscountBanane = new Discount("Banane", 10, 9);
        kiwi.addDiscount(10, 25);
        banane5.addDiscount(12, 20);
        
        Order order1 = new Order(1, "marc.damp@gmail.com", null);
        System.out.println("test");
    }
    
    public static void dropAllTable()
    {
        query("DROP TABLE Product");
        query("DROP TABLE Discount");
        query("DROP TABLE Customer");
        query("DROP TABLE Employee");
        query("DROP TABLE OrderedProduct");
        query("DROP TABLE Orders");
        System.out.println("All Table Droped");
    }
    
    
}