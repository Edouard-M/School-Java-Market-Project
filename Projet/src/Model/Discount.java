package Model;

import Model.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
 */
public class Discount
{

    private int quantity;
    private double price;
    private String name;
    private DAO dao;

    public Discount(String Name, int Quantity, double Price) throws Exception
    {
        dao = new DAO();
        quantity = Quantity;
        price = Price;
        name = Name;
        //insertDiscount();
    }

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
