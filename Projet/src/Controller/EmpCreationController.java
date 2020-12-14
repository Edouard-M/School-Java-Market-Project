
package Controller;

import Model.DAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
  * Classe controller pour le Panel "EmpCreationController" (Création d'un nouvel employé)
  * Contient : - Le DAO
  */
public class EmpCreationController
{

    private DAO dao;

    // Constructeur initiant le DAO
    public EmpCreationController()
    {
        dao = new DAO();
    }

    // Recherche des attributs de la jTable
    // Return un tableau de ces attributs
    // Passe par le DAO
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
    
    // Recherche les données de la jTable
    // Return un tableau à 2 dimensions de ces données
    // Passe par le DAO
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
 
 // Suppression d'un employé par la recherche de son email (clé primaire)
 // Appel le DAO
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
