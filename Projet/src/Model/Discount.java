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
  * Classe Discount (CLasse modele, d'une réduction)
  * Contient : - une quantitée
  *            - un prix de réuction
  *            - un nom de produit
  *            - le DAO
  */
public class Discount
{
    // quantitée
    private int quantity;
    // un prix de réuction
    private double price;
    // nom de produit
    private String name;
    // DAO
    private DAO dao;

    // Constructeur
    public Discount(String Name, int Quantity, double Price) throws Exception
    {
        dao = new DAO();
        quantity = Quantity;
        price = Price;
        name = Name;
        //insertDiscount();
    }

    // Insertion de la réduction dans la BDD
    public void insertDiscount() throws Exception
    {
        try
        {
            dao.getConnection();
            dao.query("INSERT INTO Discount (name, quantity, price) VALUES ('" + name + "', '" + quantity + "', '" + price + "')");
            dao.closeConnection();
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    // Getters
    public int getQuantity()
    {
        return quantity;
    }

    public double getPrice()
    {
        return price;
    }

    public String getName()
    {
        return name;
    }
}
