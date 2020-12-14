
package Controller;

import Model.Customer;
import Model.DAO;

/**
  * Classe controller pour le Panel "Connection" (page d'accueil de connection client)
  * Contient : - Le DAO
  */
public class ConnectionController
{
private final DAO dao;
     // Constructeur
    public ConnectionController()
    {
        dao = new DAO();
    }
    
    // Verifie si le customer est présent dans la BDD par (email + mdp)
    public boolean ConnectButton(String text1,String text2)
    {
        boolean bool=false;
        try
        {
            
            dao.getConnection();
            if(dao.searchCustomer(text2,text1)==true)
            {
               
               bool=true;
                //Window wind =new Window(jTextField2.getText());
            }
            dao.closeConnection();
           
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
           return bool;
    }
    
    // Recherche du customer en particulier dans la BDD
    public Customer findCustomer(String text2)
    {
        dao.getConnection();
        Customer customer=null;
    try
    {
        customer= dao.getCustomer(text2);
    } catch (Exception ex)
    {
        System.out.println(ex.getMessage());
    }
                dao.closeConnection();
    return customer;
    }
    
}
