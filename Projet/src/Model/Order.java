package Model;

import Model.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
//import sun.util.calendar.LocalGregorianCalendar.*;

/**
 *
 * @author Edoua
 */
public class Order
{

    private int id;
    private String email;
    //private Date date;
    private Date date;
    private ArrayList<OrderedProduct> orderedProducts;
    private DAO dao;
    

    public Order(String Email)
    {
        dao = new DAO();
        
        dao.getConnection();
        id = dao.findIdOrder();
        dao.closeConnection();
        
        email = Email;
        date = getTodayDate();
        orderedProducts = new ArrayList<>();
      
       
        //insertOrder();
    }
    
    public void setArrayList(ArrayList<OrderedProduct> list)
    {
        orderedProducts = list;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public void setDate(Date date)
    {
        this.date = date;
    }
    
    public Date getTodayDate()  // Methode pour obtenir la date actuelle
    {  
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        java.util.Date date = new java.util.Date();  
        Date theDate=null;
        try
        {
            //return formatter.format(date);
            date = new SimpleDateFormat("dd/MM/yyyy").parse(formatter.format(date));
            
            theDate = new java.sql.Date(date.getTime());
                    
        } catch (ParseException ex)
        {
            System.out.println(ex.getMessage());
        }
        return theDate;
    }
    
    public Date getDate()
    {
        return date;
    }

    public void insertOrder()
    {
        try
        {
            dao.getConnection();
            dao.query("INSERT INTO Orders ( id, email, date) VALUES ('" + id + "', '" + email + "','" + date + "')");
            dao.closeConnection();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void addOrderedProduct(OrderedProduct orderedProduct) throws Exception
    {
        boolean ordered = false;
        for (int i = 0; i < orderedProducts.size(); i++)
            if (orderedProduct.getProductName().equals(orderedProducts.get(i).getProductName()))
            {
                orderedProducts.get(i).addQuantity(orderedProduct.getQuantity());
                ordered = true;
            }
        if (ordered == false)
            orderedProducts.add(orderedProduct);
    }

    public void removeOrderedProduct(String name)
    {
        for (int i = 0; i < orderedProducts.size(); i++)
            if (name.equals(orderedProducts.get(i).getProductName()))
                orderedProducts.remove(i);
    }

    public double totalCost()
    {
        double totalCost = 0;

        for (int i = 0; i < orderedProducts.size(); i++)
            totalCost += orderedProducts.get(i).getPrice();
        

        return totalCost;
    }

    public int getId()
    {
        return id;
    }

    public OrderedProduct getProduct(String name)
    {
        OrderedProduct product = null;

        for (int i = 0; i < orderedProducts.size(); i++)
            if (name.equals(orderedProducts.get(i).getProductName()))
                product = orderedProducts.get(i);
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
