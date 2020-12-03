/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.util.ArrayList;

/**
 * @author Edoua
 */
public class HomeController
{
    public DAO dao;
    
    public HomeController()
    {
        dao = new DAO();
    }
    
    
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
    
    public Discount findDiscount(String text)
    {
        Discount discount=null;
        
        dao.getConnection();
        try{
            dao.searchDiscount(text);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
                
        dao.closeConnection();
                
        return discount;
    }
    
    
    
}
