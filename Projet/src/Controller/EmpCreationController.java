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
public class EmpCreationController
{

    DAO dao;

    public EmpCreationController()
    {
        dao = new DAO();
    }

    public String[] findColName()
    {
        String[] colNames = null;
        dao.getConnection();
        try
        {
            colNames = dao.getCol("Employee");
            
        } catch (Exception ex)
        {
            Logger.getLogger(EmpCreationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        dao.closeConnection();
        return colNames;
    }
 public String[][] findData()
    {
        String[][] data = null;
        dao.getConnection();
        try
        {
            data = dao.getLines("Employee");
        } catch (Exception ex)
        {
            Logger.getLogger(EmpCreationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        dao.closeConnection();
        return data;
    }
 public void deleteEmp(String mail)
 {
     dao.getConnection();
        try
        {
            dao.employeeDelete(mail);
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        dao.closeConnection();
        
 }

}
