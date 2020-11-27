
package Model;

import static Model.DAO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
 */
public class Product
{
    private String name;
    private String category;
    private String description;
    private double price;
    private int stock;
    private String image;
    private Discount discount;
    
    public Product(String Name, String Category, String Description, double Price, int Stock, Discount Discount, String Image) throws Exception
    {
        name = Name;
        category = Category;
        description = Description;
        price = Price;
        stock = Stock;
        discount = Discount;
        image = Image;
    }
    
    public void addDiscount(int discountQuantity, double discountPrice) throws Exception
    {
        discount = new Discount(name, discountQuantity, discountPrice);
        discount.insertDiscount();
    }
    
    public void insertProduct() throws Exception
    {
        try{
            query("INSERT INTO Product (name, category, description, price, stock, image) VALUES ('"+name+"', '"+category+"', '"+description+"', '"+price+"', '"+stock+"', '"+image+"')");
        }
        catch(Exception e){System.out.println(e);}
    }
    
    
    
    public String getName()
    {
        return name;
    }
    public String getCategory()
    {
        return category;
    }
    public String getDescription()
    {
        return description;
    }
    public double getPrice()
    {
        return price;
    }
    public int getStock()
    {
        return stock;
    }
    public Discount getDiscount()
    {
        return discount;
    }
    public String getImage()
    {
        return image;
    }
    
    
}