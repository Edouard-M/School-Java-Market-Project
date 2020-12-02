/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author dwans
 */
public class Employee extends Person
{

    private DAO dao;

    public Employee(String name, String firstName, int age, String phone, String address, String email, String password) throws Exception
    {
        super(name, firstName, age, phone, address, email, password);
        dao = new DAO();
    }

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

    public String getEmail()
    {
        return email;
    }

}
