/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Person;
import Model.Customer;
import Model.DAO;
import Model.Order;

/**
 *
 * @author Edoua
 */
public class CheckoutController
{
    private final DAO dao;
    private Customer cust;
    
    public CheckoutController()
    {
        dao = new DAO();
    }
    
    public boolean findCustomer(String email)
    {
        boolean bool=false;
        cust=null;
        dao.getConnection();
        try{
            cust = dao.getCustomer(email);
            bool=true;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        dao.closeConnection();
        return bool;
    }
    
    public void insertAllOrder(Order order)
    {
        order.insertOrder();
        
        dao.getConnection();
        for(int i=0 ; i < order.getOrderedProducts().size() ; i++)
        {
            dao.query("INSERT INTO OrderedProduct ( orderID, productName, quantity) VALUES ('" + order.getId() + "', '" + order.getOrderedProducts().get(i).getProductName() + "', '" + order.getOrderedProducts().get(i).getQuantity() + "')");
        }
        dao.closeConnection();
    }
    
    public void updateStock(Order order)
    {
        dao.getConnection();
        
        for(int i=0 ; i < order.getOrderedProducts().size() ; i++)
        {
            try
            {
                dao.productAddStock(order.getOrderedProducts().get(i).getProductName(), -order.getOrderedProducts().get(i).getQuantity());
            } 
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        dao.closeConnection();
    }
    
    public String getCustName()
    {
        return cust.getName();
    }
    public String getCustFirstName()
    {
        return cust.getFirstName();
    }
    public String getCustAdress()
    {
        return cust.getAddress();
    }
    public String getCustPhone()
    {
        return cust.getPhone();
    }
}
