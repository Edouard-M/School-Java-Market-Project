
package Model;

import static Model.DAO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import sun.util.calendar.LocalGregorianCalendar.*;
/**
 *
 * @author Edoua
 */
public class Order
{
    
    private int id;
    private String email;
    private Date date;
    private ArrayList<OrderedProduct> orderedProducts;
    
    public Order(int ID, String Email, Date Date)
    {
        id = ID;
        email = Email;
        date = Date;
        orderedProducts = new ArrayList<>();
        //insertOrder();
    }
    
    public void insertOrder()
    {
        try{
            query("INSERT INTO Orders ( id, email) VALUES ('"+id+"', '"+email+"')");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void addOrderedProduct(OrderedProduct orderedProduct)
    {
        orderedProducts.add(orderedProduct);
    }

    public int getId()
    {
        return id;
    }

    public ArrayList<OrderedProduct> getOrderedProducts()
    {
        return orderedProducts;
    }
    
    
    
}
