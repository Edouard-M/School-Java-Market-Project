/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.DAO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author dwans
 */
public class Employee extends Person
{

    public Employee(String name, String firstName, int age, String phone, String address, String email, String password) throws Exception
    {
        super(name, firstName, age, phone, address, email, password);
        insertEmployee();
    }
        public void insertEmployee() throws Exception
    {
        try{
            query("INSERT INTO Employee (name, firstName, age, phone, address, email, password) VALUES ('"+name+"', '"+firstName+"', '"+age+"', '"+phone+"', '"+address+"', '"+email+"', '"+password+"')");
        } catch(Exception e){System.out.println(e);}
    }
    
}
