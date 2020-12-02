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
 *
 * @author dwans
 */
public class ManageDiscountController
{
    public DAO dao;
    public ManageDiscountController()
    {
        dao=new DAO();
    }
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
