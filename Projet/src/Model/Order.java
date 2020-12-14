package Model;

import Model.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
//import sun.util.calendar.LocalGregorianCalendar.*;

/**
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
 */
/**
  * Classe Order (Classe modele, d'une commande)
  * Contient : - le DAO
  *            - un identifiant id (clé primaire)
  *            - un email
  *            - un total dépensé
  *            - une liste des produits achetés
  */
public class Order
{

    private int id;
    private String email;
    //private Date date;
    private Date date;
    private double total;
    private ArrayList<OrderedProduct> orderedProducts;
    private DAO dao;
    
    // Constructeur (l'email correspondant à un client)
    public Order(String Email)
    {
        dao = new DAO();
        
        dao.getConnection();
        id = dao.findIdOrder();
        dao.closeConnection();
        
        email = Email;
        date = getTodayDate();
        orderedProducts = new ArrayList<>();
      
       
        //insertOrder();
    }
    
    // Setter de l'arrayList de produits commandés
    public void setArrayList(ArrayList<OrderedProduct> list)
    {
        orderedProducts = list;
    }
    
         // Setter de l'ID
    public void setId(int id)
    {
        this.id = id;
    }
        // Setter de la date
    public void setDate(Date date)
    {
        this.date = date;
    }
        
           // Obtenir la date actuelle
    public Date getTodayDate()  // Methode pour obtenir la date actuelle
    {  
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        java.util.Date date = new java.util.Date();  
        Date theDate=null;
        try
        {
            //return formatter.format(date);
            date = new SimpleDateFormat("dd/MM/yyyy").parse(formatter.format(date));
            
            theDate = new java.sql.Date(date.getTime());
                    
        } catch (ParseException ex)
        {
            System.out.println(ex.getMessage());
        }
        return theDate;
    }
        
        //Getter de date
    public Date getDate()
    {
        return date;
    }

        // Insert la commande dans la BDD
    public void insertOrder()
    {
        try
        {
            this.total = totalCost();
            dao.getConnection();
            dao.query("INSERT INTO Orders ( id, email, date, total) VALUES ('" + id + "', '" + email + "','" + date + "', '" + total + "')");
            dao.closeConnection();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
            
        // Insert toutes les commandes dans la BDD
    public void insertAllOrder()
    {
        try
        {
            this.total = totalCostCalcul();
            dao.getConnection();
            dao.query("INSERT INTO Orders ( id, email, date, total) VALUES ('" + id + "', '" + email + "','" + date + "', '" + total + "')");
            dao.closeConnection();
            dao.getConnection();
            for(int i=0 ; i < orderedProducts.size() ; i++)
            {
                orderedProducts.get(i).insertQuery(dao);
            }
            dao.closeConnection();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    
        // Ajoute un produit commandé dans la commande en cours
    public void addOrderedProduct(OrderedProduct orderedProduct) throws Exception
    {
        boolean ordered = false;
        for (int i = 0; i < orderedProducts.size(); i++)
            if (orderedProduct.getProductName().equals(orderedProducts.get(i).getProductName()))
            {
                orderedProducts.get(i).addQuantity(orderedProduct.getQuantity());
                ordered = true;
            }
        if (ordered == false)
            orderedProducts.add(orderedProduct);
    }

    
        // Retire un prduit de la liste de commande
    public void removeOrderedProduct(String name)
    {
        for (int i = 0; i < orderedProducts.size(); i++)
            if (name.equals(orderedProducts.get(i).getProductName()))
                orderedProducts.remove(i);
    }

        // Calcul le prix total de la commande
    public double totalCost()
    {
        double totalCost = 0;

        for (int i = 0; i < orderedProducts.size(); i++)
            totalCost += orderedProducts.get(i).getPrice();
         totalCost = Math.round(totalCost * 100.0) / 100.0;
         

        return totalCost;
    }
    
        // Calcul le prix total de la commande
    public double totalCostCalcul()
    {
        double totalCost = 0;
        try{

        for (int i = 0; i < orderedProducts.size(); i++)
            totalCost += orderedProducts.get(i).calculatePrice();
         totalCost = Math.round(totalCost * 100.0) / 100.0;
         
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return totalCost;
    }
    
        // Getters
    public double getTotal()
    {
        return total;
    }

    public int getId()
    {
        return id;
    }

    public OrderedProduct getProduct(String name)
    {
        OrderedProduct product = null;

        for (int i = 0; i < orderedProducts.size(); i++)
            if (name.equals(orderedProducts.get(i).getProductName()))
                product = orderedProducts.get(i);
        return product;
    }

    public ArrayList<OrderedProduct> getOrderedProducts()
    {
        return orderedProducts;
    }
    
    public void setTotal(double total)
    {
        this.total = total;
    }

    public String getEmail()
    {
        return email;
    }

}
