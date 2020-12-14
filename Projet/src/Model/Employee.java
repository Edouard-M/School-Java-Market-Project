

package Model;

import Model.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
 */
/**
  * Classe Employee (Classe modele, d'un employee) extends Person : une employé est une Personne
  * Contient : - le DAO
  */
public class Employee extends Person
{

    private DAO dao;

     // Constructeur initiant le DAO et créant une personne "Person"
    public Employee(String name, String firstName, int age, String phone, String address, String email, String password) throws Exception
    {
        super(name, firstName, age, phone, address, email, password);
        dao = new DAO();
    }

    // Insert un employee dans la BDD
    public void insertEmployee() throws Exception
    {
        try
        {
            dao.getConnection();
            dao.query("INSERT INTO Employee (name, firstName, age, phone, address, email, password) VALUES ('" + name + "', '" + firstName + "', '" + age + "', '" + phone + "', '" + address + "', '" + email + "', '" + password + "')");
            dao.closeConnection();
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    // Getter
    public String getEmail()
    {
        return email;
    }

}
