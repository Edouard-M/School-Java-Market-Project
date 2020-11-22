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
public class OrderedProduct
{
    private int orderID;
    private int id;
    private String productName;
    private int quantity;
    private double price;
 

    public OrderedProduct(int OrderID, int ID, String ProductName, int Quantity, double Price) throws Exception
    {
        this.orderID = OrderID;
        this.id= ID;
        this.productName = ProductName;
        this.quantity = Quantity;
        this.price = Price;
        //price=findprice();
        insertOrderedProduct();
    }
    /*public double findprice()
    {
        // A FAIRE
        return 0;
    }*/
    
    public void insertOrderedProduct() throws Exception
    {
        try{
            query("INSERT INTO OrderedProduct ( orderID, productName, quantity) VALUES ('"+orderID+"', '"+productName+"', '"+quantity+"')");
        } 
        catch(Exception e){System.out.println(e);}
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
