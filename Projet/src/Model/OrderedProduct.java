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
public class OrderedProduct
{

    private int orderID;
    private int id;
    private String productName;
    private int quantity;
    private double price;
    private double unitPrice;
    private DAO dao;

    public OrderedProduct(int OrderID, int ID, String ProductName, int Quantity, double UnitPrice) throws Exception
    {
        dao = new DAO();
        this.orderID = OrderID;
        this.id = ID;
        this.productName = ProductName;
        this.quantity = Quantity;
        this.unitPrice = UnitPrice;
        price = calculatePrice();
        //insertOrderedProduct();
    }

    public double calculatePrice() throws Exception
    {
        dao.getConnection();
        Discount discount = dao.searchDiscount(productName);
        dao.closeConnection();
        double total;

        if (discount != null && discount.getQuantity() <= quantity)
        {

            int dQuantity = discount.getQuantity();
            double dPrice = discount.getPrice();
            total = ((quantity % dQuantity) * unitPrice) + ((quantity - (quantity % dQuantity)) / dQuantity * dPrice);
        } else
            total = quantity * unitPrice;

        return total;
    }

    public void addQuantity(int quantityToAdd) throws Exception
    {
        quantity += quantityToAdd;
        price = calculatePrice();
    }

    public void insertOrderedProduct() throws Exception
    {
        try
        {
            dao.getConnection();
            dao.query("INSERT INTO OrderedProduct ( orderID, productName, quantity) VALUES ('" + orderID + "', '" + productName + "', '" + quantity + "')");
            dao.closeConnection();
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public String getProductName()
    {
        return productName;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public double getPrice()
    {
        return price;
    }

}
