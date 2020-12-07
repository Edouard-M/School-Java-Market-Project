package Controller;


import Model.*;
import View.MyFrame;

/**
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
 */
public class Projet
{
    
    public  static void main(String[] args) throws Exception
    {
        
        Initialisation init = new Initialisation();
        
        DAO dao = new DAO();
       // init.dropAllTable();
        //dao.getConnection();
        //dao.createAllTable();
        //dao.closeConnection();

       // init.testDB();
        
        MyFrame frame = new MyFrame();
        
    }

    

}
