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
  * Classe controller pour le Panel "ManageDiscount" (page coté employé permettant de gérer (ajouter / supprimer) les réductions)
  * Contient : - Le DAO
  */
public class ManageDiscountController
{
    private DAO dao;
    
    // Constructeur initiant le DAO
    public ManageDiscountController()
    {
        dao=new DAO();
    }
    
    // Recherche des produits construisant le jTable product
    // return un tableau de String à 2 dimensions
    public String[][] findDataProduct()
    {
        String[][] data = null;
        dao.getConnection();
        try
        {
            data = dao.getLines("Product");
        } catch (Exception ex)
        {
            Logger.getLogger(EmpCreationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        dao.closeConnection();
        return data;
    }
    
    // Recherche des produits construisant le jTable de discount
    // return un tableau de String à 2 dimensions
     public String[][] findDataDiscount()
    {
        String[][] data = null;
        dao.getConnection();
        try
        {
            data = dao.getLines("Discount");
        } catch (Exception ex)
        {
            Logger.getLogger(EmpCreationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        dao.closeConnection();
        return data;
    }
     
     // Recherche des attributs construisant le jTable de discount
    // return un tableau de String à 1 dimension
      public String[] findColNameDiscount()
    {
        String[] colNames = null;
        dao.getConnection();
        try
        {
            colNames = dao.getCol("Discount");
            
        } catch (Exception ex)
        {
            Logger.getLogger(EmpCreationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        dao.closeConnection();
        return colNames;
    }
      
      // Supprime une discount (choisie par clé primaire : cson nom)
        public void EraseDiscount(String name)
    {
        dao.getConnection();
        try
        {
           dao.discountDelete(name);
        } catch (Exception ex)
        {
            Logger.getLogger(EmpPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        dao.closeConnection();
    }
}
