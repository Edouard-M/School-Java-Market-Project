
package Controller;

import Model.Person;
import Model.Customer;
import Model.DAO;
import Model.Order;

/**
  * Classe controller pour le Panel "Checkout"
  * Contient : - Le DAO
  *            - Le Customer de la commande
  */
public class CheckoutController
{
    private final DAO dao;
    private Customer cust;
    
    //Constructeur initiant le DAO
    public CheckoutController()
    {
        dao = new DAO();
    }
    
    // Recherche d'un customer particulier par son mail (clé primaire)
    // Return un boolean (true) si le customer exist
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
    
    // Ajout de la commande complète dans la BDD via le DAO
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
    
    // Change le stock d'un produit après sa commande via le DAO
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
    
    // GETTER :
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
