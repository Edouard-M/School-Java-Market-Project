package Controller;

import static Model.DAO.*;
import Model.*;
import View.Window2;
import View.MyFrame;
import java.net.PasswordAuthentication;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.text.DateFormatter;
//import javax.mail.*;

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
        init.dropAllTable();
        dao.getConnection();
        dao.createAllTable();
        dao.closeConnection();

        init.testDB();
        
        MyFrame frame = new MyFrame();
        
    }

    

}
