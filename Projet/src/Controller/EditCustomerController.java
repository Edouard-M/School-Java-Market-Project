/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
import Model.DAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dwans
 */
public class EditCustomerController
{

    DAO dao;

    public EditCustomerController()
    {
        dao = new DAO();
    }

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

    public void EditCustomer(String email, String text1, String text6, String text2, String text3,int index1,String text4)
    {
        dao.getConnection();
        try
        {
            if(!"".equals(text4))
            dao.EditCustomerdata(email, text1, text6, text2, text3, index1, text4);
            else 
                dao.EditCustomerdata(email, text1, text6, text2, text3, index1, dao.getEmployeePassword(email));
        } catch (Exception ex)
        {
            Logger.getLogger(EditCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        dao.closeConnection();
    }
}
