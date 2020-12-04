/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO;
import Model.Order;
import java.util.ArrayList;

/**
 * @author Edoua
 */
public class MyOrdersController
{
    private DAO dao;
    
    public MyOrdersController()
    {
        dao = new DAO();
    }
    
    public Order[] findOrders(String email)
    {
        Order[] orders=null;
        ArrayList<Order> list = new ArrayList<>();
        
        dao.getConnection();
        list = dao.getCustOrders(email);
        orders = new Order[list.size()];
        for(int i=0 ; i < list.size() ; i++)
        {
            orders[i] = list.get(i);
        }
        dao.closeConnection();
        
        
        dao.getConnection();
        for(int i=0 ; i < orders.length ; i++)
        {
            orders[i].setArrayList(dao.getOrderedProducts(orders[i].getId()));
        }
        dao.closeConnection();
        
        
        
        return orders;
    }
    
}
