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
  * Classe Customer (un Client de l'application)
  * Contient : - Le DAO
  *            - des points de fidélité
  * Extends de la classe "Person"
  */
public class Customer extends Person
{

    private int fidelityPoint;
    private DAO dao;

    // Constructeur initialisant le nom/ prénom/ age/ téléphone/ l'adresse/ l'email/ le mdp du client
    public Customer(String name, String firstName, int age, String phone, String address, String email, String password) throws Exception
    {
        super(name, firstName, age, phone, address, email, password);
        fidelityPoint = 0;
        dao = new DAO();
        //insertCustomer();
    }

    // Insert un client dans la BDD
    public void insertCustomer() throws Exception
    {
        try
        {
            dao.getConnection();
            dao.query("INSERT INTO Customer (name, firstName, age, phone, address, email, password, fidelityPoint) VALUES ('" + name + "', '" + firstName + "', '" + age + "', '" + phone + "', '" + address + "', '" + email + "', '" + password + "', '" + fidelityPoint + "')");
            dao.closeConnection();
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    // Getters
    public String getName()
    {
        return name;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public int getAge()
    {
        return age;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getAddress()
    {
        return address;
    }

    public String getEmail()
    {
        return email;
    }
}
