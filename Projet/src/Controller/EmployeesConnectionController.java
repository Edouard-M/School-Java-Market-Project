/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO;
import Model.Employee;

/**
  * Classe controller pour le Panel "EmployeesConnection" (page de connection du compte employé)
  * Contient : - Le DAO
  */
public class EmployeesConnectionController
{
    private DAO dao;
    
    // Constructeur initiant le DAO
    public EmployeesConnectionController()
    {
        dao = new DAO();
    }
    
    // Recherche de la connection d'un employé par son email et mdp
    // Return le boolean de connexion (true si les donneés rentrées sont bonnes)
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
    
    // Recherche un employé par son email
    // Return l'employé en question
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
