
package Controller;
import static Model.DAO.*;
import Model.*;
import View.CreateCustomer;
import View.Window;
import View.Window2;
import View.Window3;
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
        
        
        //Window wind = new Window();
        Window3 wind2 = new Window3();
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
        Customer Marc = new Customer("Marc", "Dampierre", 23, "0640787637", " 6 rue jean mermoz rueil-malmaison 92500", "marc.damp@gmail.com", "pass123");
        Employee Fred =new Employee("Fred", "Blanchard", 33, "0678964572", "3 rue des moulins maison lafittes", "fredbla@laposte.net", "pass123");
        OrderedProduct OrderedBanane= new OrderedProduct(1,1,"Banane", 10,12);
        OrderedProduct OrderedKiwi= new OrderedProduct(1,2,"Kiwi", 5,12);
        Discount DiscountBanane = new Discount("DiscountBanane", 10, 9);
        kiwi.addDiscount(10, 25);
        kiwi.getDiscount().insertDiscount();
        
        Order order1 = new Order(1, "marc.damp@gmail.com", null);
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