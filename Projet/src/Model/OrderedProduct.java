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
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
 */
/**
  * Classe OrderedProduct (Classe modele, d'une produit commandé)
  *     Utilisé pour la BDD stocker les produits liés aux commandes sans avoir à recharger les images etc.. contrairement à la classe "Produit"
  * Contient : - le DAO
  *            - un identifiant id (clé primaire)
  *            - un identifiant de commande auquel le produit est lié
  *            - un nom de produit
  *            - une quantité de ce produit commandé
  *            - un prix total (calcule par rapport à la quantitié)
  *            - un prix unitaire
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

    
    // Constructeur
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

    // Calcul du prix
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
         total = Math.round(total * 100.0) / 100.0;

        return total;
    }

    // Ajout d'une quantité de produit commandé
    public void addQuantity(int quantityToAdd) throws Exception
    {
        quantity += quantityToAdd;
        price = calculatePrice();
    }

    // Insert du produit dans la BDD
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
    
    // Insert du produit dans la BDD
    public void insertQuery(DAO daos) throws Exception
    {
        try
        {
            daos.query("INSERT INTO OrderedProduct ( orderID, productName, quantity) VALUES ('" + orderID + "', '" + productName + "', '" + quantity + "')");
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    // Getter
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
