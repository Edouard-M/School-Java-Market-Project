/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
  * Classe controller pour le Panel "EditCustomer" (page d'édition du du compte client)
  * Contient : - Le DAO
  */
public class EmpPanelController
{
    private DAO dao;
    
    // Constructeur initiant le DAO
    public EmpPanelController()
    {
        dao=new DAO();
    }
    public String[][] findData()
    {
       dao.getConnection();
       String[][]data=null;
        try
        {
           data= dao.getLines("Product");
        } catch (Exception ex)
        {
            Logger.getLogger(EmpPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        dao.closeConnection();
        return data;
    }
    public void AddStock(String name,int addstock)
    {
        dao.getConnection();
        try
        {
            dao.productAddStock(name, addstock);
        } catch (Exception ex)
        {
            Logger.getLogger(EmpPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        dao.closeConnection();
    }
      public void EraseProduct(String name)
    {
        dao.getConnection();
        try
        {
            dao.productDelete(name);
        } catch (Exception ex)
        {
            Logger.getLogger(EmpPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        dao.closeConnection();
    }
}
