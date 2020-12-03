/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO;
import Model.Employee;

/**
 *
 * @author Edoua
 */
public class EmployeesConnectionController
{
    public DAO dao;
    
    public EmployeesConnectionController()
    {
        dao = new DAO();
    }
    
    
    public boolean isEmployee(String text1, String password)
    {
        boolean bool = false;
        dao.getConnection();
        try{
            if(dao.searchEmployee(text1,password))
                bool=true;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }  
        dao.closeConnection();
        
        return bool;
    }
    
    public Employee findEmployee(String text)
    {
        Employee emp=null;
        dao.getConnection();
        try{
            emp=dao.getEmployee(text);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        dao.closeConnection();
        
        return emp;
    }
    
}
