
package Controller;

import Model.Customer;
import Model.DAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
  * Classe controller pour le Panel "EditCustomer" (page d'édition du du compte client)
  * Contient : - Le DAO
  */
public class EditCustomerController
{

    private DAO dao;

    // Constructeur initiant le DAO
    public EditCustomerController()
    {
        dao = new DAO();
    }

    // Recherche d'un Customer par son mail
    // return le client en question
    // passe par le DAO
    public Customer findCustomer(String email)
    {
        dao.getConnection();

        Customer customer = null;
        try
        {
            customer = dao.getCustomer(email);
        } catch (Exception ex)
        {
            Logger.getLogger(EditCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }

        dao.closeConnection();
        return customer;
    }
    
    // Edit les informations du customer, en appelant le DAO
    public void EditCustomer(String email, String text1, String text6, String text2, String text3,int index1,String text4)
    {
        dao.getConnection();
        try
        {
            if(!"".equals(text4))
            dao.EditCustomerdata(email, text1, text6, text2, text3, index1, text4);
            else 
                dao.EditCustomerdata(email, text1, text6, text2, text3, index1, dao.getCustomPassword(email));
        } catch (Exception ex)
        {
            Logger.getLogger(EditCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        dao.closeConnection();
    }
}
