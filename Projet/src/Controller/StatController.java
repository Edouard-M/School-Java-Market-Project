/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO;
import Model.Order;
import Model.OrderedProduct;
import Model.Product;
import java.util.ArrayList;

/**
  * Classe controller pour le Panel "StatPanel" (page coté employé permettant voir les statistiques
  *                                               sous forme de JFreeChart )
  * Contient : - Le DAO
  *            - la liste de toutes les commandes sur la plateforme
  */
public class StatController
{
    
    // DAO
    private final DAO dao;
    // Liste de toutes les commandes
    private ArrayList<Order> allOrders;
    
    // Constructeur initiant le DAO
    public StatController()
    {
        dao = new DAO();
    }
    
    
    // Recherche des catégories pour le JFreeChart
    public String[] getCategories()
    {
        ArrayList<String> list;
        String[] categories;
        
        dao.getConnection();
        list = dao.getCategories();
        dao.closeConnection();
        if(list.size() > 0)
            categories = (String[]) list.toArray(new String[list.size()]);
        else
            categories = null;
        
        return categories;
    }
    
    
    // REcherche des produits commandés pour le camembert
    
    public ArrayList<OrderedProduct> getPieData(String category, boolean load)
    {
        ArrayList<Product> productList = new ArrayList<>();
        ArrayList<OrderedProduct> allList = new ArrayList<>();
        ArrayList<OrderedProduct> filterList = new ArrayList<>();
        
        System.out.println("1");
        dao.getConnection();
        try{
            //if(load)
                allList = dao.getAllOrderedProducts();
            productList = dao.selectAllProducts();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        dao.closeConnection();
        
        System.out.println("2");
        for(int i=0 ; i < productList.size() ; i++)
        {
            if(productList.get(i).getCategory().equals(category))
                for(int j=0 ; j < allList.size() ; j++)
                {
                    if(productList.get(i).getName().equals(allList.get(j).getProductName()))
                        filterList.add(allList.get(j));
                }
        }
        System.out.println("3");
        
        return filterList;
    }
    
    // Getter des orders vis la BDD
    public void getOrders()
    {
        dao.getConnection();
        allOrders = dao.getOrders();
        dao.closeConnection();
    }
    
    // Recherche des commandes pour le graphique 
    public ArrayList<Order> getAreaOrders(int month)
    {
        ArrayList<Order> list= new ArrayList<>();
        Order ord;
        
        for(int i=0 ; i < allOrders.size() ; i++)
        {
            String date = allOrders.get(i).getDate().toString();
            String monthS = String.valueOf(date.charAt(5)) + String.valueOf(date.charAt(6));
            
            if(monthS.equals(String.valueOf(month)))
            {
                list.add(allOrders.get(i));
            }
        }
        
        return list;
    }
    
    // Recherche du mois en question
    public String findMonth(int month)
    {
        String monthName="";
        
        switch (month) {
            case 1 :
                monthName = "January";
            break;
            case 2 :
                monthName = "February";
            break;
            case 3 :
                monthName = "March";
            break;    
            case 4 :
                monthName = "April";
            break;
            case 5 :
                monthName = "May";
            break;
            case 6 :
                monthName = "June";
            break;
            case 7 :
                monthName = "July";
            break;
            case 8 :
                monthName = "August";
            break;
            case 9 :
                monthName = "September";
            break;    
            case 10 :
                monthName = "October";
            break;
            case 11 :
                monthName = "November";
            break;
            case 12 :
                monthName = "December";
            break;
        }
        return monthName;
    }
    
    
    
    
    
    
}
