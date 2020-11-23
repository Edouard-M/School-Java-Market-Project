
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
    
    public void addOrderedProduct(OrderedProduct orderedProduct) throws Exception
    {
        boolean ordered = false;
        for(int i =0 ; i < orderedProducts.size() ; i++)
        {
            if(orderedProduct.getProductName().equals(orderedProducts.get(i).getProductName()))
            {
                orderedProducts.get(i).addQuantity(orderedProduct.getQuantity());
                ordered = true;
            }
        }
        if(ordered == false)
            orderedProducts.add(orderedProduct);
    }
    
    public void removeOrderedProduct(String name)
    {
        for(int i=0 ; i < orderedProducts.size() ; i++)
        {
            if(name.equals(orderedProducts.get(i).getProductName()))
                orderedProducts.remove(i);
        }
    }
    
    public double totalCost()
    {
        double cost=0;
        
        for(int i =0 ; i < orderedProducts.size() ; i++)
        {
            cost += orderedProducts.get(i).getPrice();
        }
        
        return cost;
    }
    

    public int getId()
    {
        return id;
    }
    
    public OrderedProduct getProduct(String name)
    {
        OrderedProduct product = null;
        
        for(int i = 0 ; i < orderedProducts.size() ; i++)
        {
            if(name.equals(orderedProducts.get(i).getProductName()))
                product = orderedProducts.get(i);
        }
        return product;
    }

    public ArrayList<OrderedProduct> getOrderedProducts()
    {
        return orderedProducts;
    }

    public String getEmail()
    {
        return email;
    }
    
    
    
}
