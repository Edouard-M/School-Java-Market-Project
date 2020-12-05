/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
import Model.DAO;
import View.MyFrame;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dwans
 */
public class ConnectionController
{
private DAO dao;
    public ConnectionController()
    {
        dao = new DAO();
    }
    
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
