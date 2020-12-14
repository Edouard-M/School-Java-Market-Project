package Controller;


import Model.*;
import View.MyFrame;

/**
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
 */
public class Projet
{
    
  /**
  * Main général du projet
  */
    public  static void main(String[] args) throws Exception
    {
        
        // Décommenter pour reset la base de données
        // Ne pas le faire avant la soutenance
        /*
        Initialisation init = new Initialisation(); 
        DAO dao = new DAO();
        init.dropAllTable();
        dao.getConnection();
        dao.createAllTable();
        dao.closeConnection();
        init.testDB();
        */
        MyFrame frame = new MyFrame();
        
    }

    

}
