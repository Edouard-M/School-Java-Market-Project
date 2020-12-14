/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.util.ArrayList;

/**
  * Classe controller pour le Panel "Home" (page Home, page principale de recherche de produits, faire une commande)
  * Contient : - Le DAO
  */
public class HomeController
{
    private DAO dao;
    
    // Constructeur initiant le DAO
    public HomeController()
    {
        dao = new DAO();
    }
    
    // Recherche de tous les produits dans le DAO pour les afficher à l'ecran sans nouveau chargement
    // Return une ArrayList de tous les produits 
    public ArrayList<Product> searchAllProductsList()
    {
        ArrayList<Product> list=null;
        
        dao.getConnection();
        try{
            list=dao.selectAllProducts();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        dao.closeConnection();
        
        return list;
    }
    
    // Recherche des données d'un jTable
    // Return une ArrayList de la jTable
    // Passant par le DAO
    public String[][] getData()
    {
        String[][]datas=null;
        dao.getConnection();
        try{
            datas=dao.getLines("Product");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        dao.closeConnection();
        
        return datas;
    }
    
    // Recherche des données d'un jTable (cette fois-ci Discount)
    // Return une ArrayList pour la jTable
    // Passant par le DAO
     public String[][] getDataDiscount()
    {
        String[][]datas=null;
        dao.getConnection();
        try{
            datas=dao.getLines("Discount");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        dao.closeConnection();
        
        return datas;
    }
    
     // Recherche si une discount exist pour un produit
     // Return la réduction en question (si existe)
    public Discount findDiscount(String text)
    {
        Discount discount=null;
        
        dao.getConnection();
        try{
            discount=dao.searchDiscount(text);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
                
        dao.closeConnection();
                
        return discount;
    }
    
    
    
}
