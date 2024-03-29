/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
 */
/**
 *  BASE DE DONNEES HEBERGEE EN LIGNE VIA  "AWS"
 * 
  * Classe DAO (gérant toutes les informations et recherches de la BDD)
  * Contient : - driver de connexion
  *            - l'url de connexion
  *            - le nom de l'utilisateur
  *            - le mot de passe de connexion à la BDD
  *            - la connexion "con"
  */
public class DAO
{
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://dbtest.cfuu3y9e8cbz.eu-west-3.rds.amazonaws.com:3306/DB";
    private final String username = "admin";
    private final String password = "Jolipuzzle";
    private  Connection con;


       // Ouverture de Connexion à la BDD
    public void getConnection()
    {
        try
        {
             Class.forName(driver);
             con = DriverManager.getConnection(url, username, password);
            //System.out.println("Connected to server !");
           
        } catch (ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }

    }
    
       // Fermeture de Connexion à la BDD
    public void closeConnection() 
    {
        try
        {
             
             con.close();
            //System.out.println("Connected to server !");
           
        } catch (SQLException e)
        {
            System.out.println(e);
        }

    }

       // Query d'update à envoyé à la BDD
    public  PreparedStatement query(String query)
    {
        try
        {
            boolean exist = false;
         
            PreparedStatement statement = con.prepareStatement(query);
            statement.executeUpdate();
            return statement;
        } catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

        // Création / Initialosation des Tables de la BDD
    public  void createAllTable() throws Exception
    {
        try
        {
            
            PreparedStatement create;
            create = con.prepareStatement("CREATE TABLE IF NOT EXISTS Product( name varchar(255), category varchar(255), description varchar(255), price double, stock int, discountId int, image varchar(255), PRIMARY KEY(name))");
            create.executeUpdate();
            create = con.prepareStatement("CREATE TABLE IF NOT EXISTS Orders( id int, email varchar(255), date date, total double, PRIMARY KEY(id))");
            create.executeUpdate();
            create = con.prepareStatement("CREATE TABLE IF NOT EXISTS OrderedProduct( orderID int, id int NOT NULL AUTO_INCREMENT, productName varchar(255), quantity int, PRIMARY KEY(id))");
            create.executeUpdate();
            create = con.prepareStatement("CREATE TABLE IF NOT EXISTS Customer( name varchar(255), firstName varchar(255), age int, phone varchar(255), address varchar(255), email varchar(255), password varchar(255), fidelityPoint int, PRIMARY KEY(email))");
            create.executeUpdate();
            create = con.prepareStatement("CREATE TABLE IF NOT EXISTS Employee( name varchar(255), firstName varchar(255), age int, phone varchar(255), address varchar(255), email varchar(255), password varchar(255), PRIMARY KEY(email))");
            create.executeUpdate();
            create = con.prepareStatement("CREATE TABLE IF NOT EXISTS Discount( name varchar(255), quantity int, price double, PRIMARY KEY(name))");
            create.executeUpdate();
            //("All Table Created");
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
        // Recherche d'un produit par sa clé primaire "son nom"
       // Return le Produit en question
       // Sinon return NULL
    public Product searchProduct(String search) throws Exception
    {
        String name, category, description, image;
        double price;
        int stock;
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Product WHERE name = '" + search + "'");
        ResultSet result = statement.executeQuery();
        if (result.next())
        {
            name = result.getString("name");
            category = result.getString("category");
            description = result.getString("description");
            image = result.getString("image");
            stock = result.getInt("stock");
            price = result.getDouble("price");

            //System.out.println("Result = " + name + " " + category + " " + description + " " + price + " " + stock + " " + image);
            Product product = new Product(name, category, description, price, stock, null, image);
            return product;
        } else
            return null;
    }
    
        // Suppression d'un Produit
    public void productDelete(String name) throws Exception
    {
        
        PreparedStatement statement = con.prepareStatement("DELETE FROM Product WHERE name = '" +name+ "'");
         statement.executeUpdate();
    }
    
        // Suppression d'une réduction
    public  void discountDelete(String name) throws Exception
    {
        
        PreparedStatement statement = con.prepareStatement("DELETE FROM Discount WHERE name = '" +name+ "'");
         statement.executeUpdate();
    }
    
      // Suppression d'un employé
    public void employeeDelete(String email) throws Exception
    {
       
        PreparedStatement statement = con.prepareStatement("DELETE FROM Employee WHERE email = '" +email+ "'");
         statement.executeUpdate();
    }
    
        // Diminution du Stock d'un Produit
     public  void productAddStock(String name,int addToStock) throws Exception
    {
        int stock;
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Product WHERE name = '" +name+ "'");
        ResultSet result = statement.executeQuery();
        if (result.next())
        {
            
            stock = result.getInt("stock");
          
           stock+=addToStock;
            statement = con.prepareStatement("UPDATE Product SET Stock='"+stock+"'  WHERE name = '"+name+"'");
        statement.executeUpdate();
        }
    }
        // Recherche d'une réduction en particulier (par le nom du produit en question)
    public Discount searchDiscount(String search) throws Exception
    {
        String name = "";
        int quantity = 0;
        double price = 0;

        
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Discount WHERE name = '" + search + "'");
        ResultSet result = statement.executeQuery();
        if (result.next())
        {
            name = result.getString("name");
            quantity = result.getInt("quantity");
            price = result.getDouble("price");

            //System.out.println("Result = " + name + " " + quantity + " " + price);
            Discount discount = new Discount(name, quantity, price);
            return discount;
        } else
            return null;
    }

        // Recherche si un Client existe
    public boolean searchCustomer(String enteredemail, String enteredpassword) throws Exception
    {
        
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Customer WHERE email = '" + enteredemail + "'");
        ResultSet result = statement.executeQuery();
        if (result.next())
            //System.out.println(enteredpassword);
            //System.out.println(result.getString("password"));
            if (enteredpassword.equals(result.getString("password")))
                return true;
            else
                return false;
        else
            return false;
    }

            // recherche si un employee existe
    public  boolean searchEmployee(String enteredemail, String enteredpassword) throws Exception
    {
        
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Employee WHERE email = '" + enteredemail + "'");
        ResultSet result = statement.executeQuery();
        if (result.next())
            if (enteredpassword.equals(result.getString("password")))
                return true;
            else
                return false;
        else
            return false;
    }
    
            // recherche d'un employé en question
    public Employee getEmployee(String email) throws Exception
    {
       
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Employee WHERE email = '" + email + "'");
        String name, firstName, phone, adress, mail, password;
        int age;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   
            name = result.getString("name");
            firstName = result.getString("firstname");
            phone = result.getString("phone");
            adress = result.getString("address");
            password = result.getString("password");
            mail = result.getString("email");
            age = result.getInt("age");
         return new Employee(name, firstName, age, phone, adress, email, password);
        }
        return null;
    }

            // recherche du nom d'un employé
    public  String getEmployeeName(String email) throws Exception
    {
        
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Employee WHERE email = '" + email + "'");
        String name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getString("name");
         return name;
        }
        return "";
    }

            // recherche du prénom d'un employé
    public String getEmployeeFirstName(String email) throws Exception
    {
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Employee WHERE email = '" + email + "'");
       String name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getString("firstname");
         return name;
        }
        return "";
    }

            // recherche de l'adresse d'un employé
    public String getEmployeeAddress(String email) throws Exception
    {
        
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Employee WHERE email = '" + email + "'");
          String name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getString("address");
         return name;
        }
        return "";
    }

        // recherche du téléphone d'un employé
    public String getEmployeePhone(String email) throws Exception
    {
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Employee WHERE email = '" + email + "'");
         String name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getString("phone");
         return name;
        }
        return "";
    }

            // recherche du mdp d'un employé
    public String getEmployeePassword(String email) throws Exception
    {

        PreparedStatement statement = con.prepareStatement("SELECT * FROM Employee WHERE email = '" + email + "'");
        String name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getString("password");
         return name;
        }
        return "";
    }

        // recherche de l'age d'un employé
    public int getEmployeeAge(String email) throws Exception
    {
        
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Employee WHERE email = '" + email + "'");
         int name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getInt("age");
         return name;
        }
        return 0;
    }
        // Update du compte de l'employé
    public void EditEmployee(String email,String firstname, String name,String address,String phone,int age,String password) throws Exception
    {
        PreparedStatement statement;
        statement = con.prepareStatement("SELECT firstname, name,address,phone,age,password FROM Employee WHERE email= '" + email + "'");
        statement.executeQuery();
        statement = con.prepareStatement("UPDATE Employee SET firstname = '"+firstname+"' ,name='"+name+"', address = '"+address+"', phone = '"+phone+"', age= "+age+" ,password = '"+password+"' WHERE email = '"+email+"'");
        statement.executeUpdate();
    }
    
    
        // Recherche d'un client par sa clée primaire
     public Customer getCustomer(String email) throws Exception
    {
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Customer WHERE email = '" + email + "'");
        String name, firstName, phone, adress, mail, password;
        int age;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   
            name = result.getString("name");
            firstName = result.getString("firstname");
            phone = result.getString("phone");
            adress = result.getString("address");
            password = result.getString("password");
            mail = result.getString("email");
            age = result.getInt("age");
         return new Customer(name, firstName, age, phone, adress, email, password);
        }
        return null;
    }
     
        // recherche du nom d'un client
    public String getCustomerName(String email) throws Exception
    {

        PreparedStatement statement = con.prepareStatement("SELECT * FROM Customer WHERE email = '" + email + "'");
        String name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getString("name");
         return name;
        }
        return "";
    }

            // recherche du prénom d'un client
    public String getCustomerFirstName(String email) throws Exception
    {
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Customer WHERE email = '" + email + "'");
       String name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getString("firstname");
         return name;
        }
        return "";
    }

        // recherche de l'adresse d'un client
    public String getCustomerAddress(String email) throws Exception
    {
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Customer WHERE email = '" + email + "'");
          String name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getString("address");
         return name;
        }
        return "";
    }

            // recherche du téléphone d'un client
    public String getCustomerPhone(String email) throws Exception
    {
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Customer WHERE email = '" + email + "'");
         String name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getString("phone");
         return name;
        }
        return "";
    }

            // recherche du mdp d'un client
    public String getCustomPassword(String email) throws Exception
    {
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Customer WHERE email = '" + email + "'");
        String name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getString("password");
         return name;
        }
        return "";
    }

            // recherche de l'age d'un client
    public int getCustomerAge(String email) throws Exception
    {
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Customer WHERE email = '" + email + "'");
         int name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getInt("age");
         return name;
        }
        return 0;
    }
    
            // Update des inforamtions d'un client
    public void EditCustomerdata(String email,String firstname, String name,String address,String phone,int age,String password) throws Exception
    {
        PreparedStatement statement;
        statement = con.prepareStatement("SELECT firstname, name,address,phone,age,password FROM Customer WHERE email= '" + email + "'");
        statement.executeQuery();
        statement = con.prepareStatement("UPDATE Customer SET firstname = '"+firstname+"' ,name='"+name+"', address = '"+address+"', phone = '"+phone+"', age= "+age+" ,password = '"+password+"' WHERE email = '"+email+"'");
        statement.executeUpdate();
    }
    
            // Recherche de tous les produits
    public ArrayList<Product> selectAllProducts() throws Exception
    {
        try
        {
            Product product;
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Product ORDER BY name");

            ResultSet result = statement.executeQuery();

            ArrayList<Product> array = new ArrayList<Product>();
            while (result.next())
            {

                product = new Product(result.getString("name"), result.getString("category"), result.getString("description"), result.getDouble("price"), result.getInt("stock"), null, result.getString("image"));
                array.add(product);
            }
            return array;

        } catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
            // recherche de toutes les réductions
        public ArrayList<Discount> selectAllDiscount() throws Exception
    {
        try
        {
            Discount discount;
            
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Discount ORDER BY name");

            ResultSet result = statement.executeQuery();

            ArrayList<Discount> array = new ArrayList<>();
            while (result.next())
            {

                discount = new Discount( result.getString("name"), result.getInt("quantity"), result.getDouble("price"));
                array.add(discount);
            }
            return array;

        } catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
            // recherche de tous les employés
    public  ArrayList<Employee> selectAllEmployees() throws Exception
    {
        try
        {
            Employee employee;
            
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Employee ORDER BY email");

            ResultSet result = statement.executeQuery();

            ArrayList<Employee> array = new ArrayList<>();
            while (result.next())
            {

                employee = new Employee(result.getString("name"), result.getString("firstName"), result.getInt("age"), result.getString("phone"), result.getString("address"), result.getString("email"), result.getString("password"));
                array.add(employee);
            }
            return array;

        } catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

            // recherche de la taille d'une jTable (taille des données)
    public  int getRowSize(String tableName) throws Exception
    {
        ArrayList<String> array = new ArrayList<>();
       
        PreparedStatement statement = con.prepareStatement("SELECT * FROM " + tableName);
        ResultSet result = statement.executeQuery();

        while (result.next())
        {
            array.add(result.getString("name"));
        }

        return array.size();
    }

    
            // recherche de la taille d'une jTable (taille des colonnes/ atributs)
    public  String[] getCol(String tableName) throws Exception
    {
        String[] col;

       
        PreparedStatement statement = con.prepareStatement("SELECT * FROM " + tableName + "");
        ResultSet result = statement.executeQuery();
        ResultSetMetaData meta = result.getMetaData();

        col = new String[meta.getColumnCount()];

        for (int i = 0; i < meta.getColumnCount(); i++)
            // Get a column name.
            col[i] = meta.getColumnLabel(i + 1);

        return col;
    }

        // recherche des données d'une jTable 
    public  String[][] getLines(String tableName) throws Exception
    {
        int numRows = getRowSize(tableName);
        String[][] lines;

        PreparedStatement statement = con.prepareStatement("SELECT * FROM " + tableName + "");
        ResultSet result = statement.executeQuery();
        ResultSetMetaData meta = result.getMetaData();

        lines = new String[numRows][meta.getColumnCount()];

        while (result.next())
        {
            for (int row = 0; row < numRows; row++)
            {
                for (int col = 0; col < meta.getColumnCount(); col++)
                    lines[row][col] = result.getString(col + 1);
                // Go to the next row in the ResultSet.
                result.next();
            }
        }

        return lines;
    }
    
        // Recherche du numéro ID d'une commande
    public int findIdOrder()
    {
         int id=0;
        try{
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Orders ORDER BY id");
            ResultSet result = statement.executeQuery();
        
            while(result.next())
            {
                int i = result.getInt("id");
                if(id < i)
                    id = i;
            }
            
         
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
         return id+1;
    }
    
         // recherche des commmande d'un client 
    public ArrayList<Order> getCustOrders(String email)
    {
        Order order=null;
        ArrayList<Order> list = new ArrayList<>();
        try{
            
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Orders WHERE email= '" + email + "'");
            ResultSet result = statement.executeQuery();
        
            while(result.next())
            {
                int id = result.getInt("id");
                Date date = result.getDate("date");
                
                order = new Order(email);
                order.setId(id);
                order.setDate(date);
                
                list.add(order);
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
            // Recherche des produits commandés lors d'une commande
    public ArrayList<OrderedProduct> getOrderedProducts(int orderId)
    {
        ArrayList<OrderedProduct> list = new ArrayList<>();
        OrderedProduct ordProduct=null;
        try{
            
            PreparedStatement statement = con.prepareStatement("SELECT * FROM OrderedProduct WHERE orderID= '" + orderId + "'");
            ResultSet result = statement.executeQuery();
        
            while(result.next())
            {
                String productName = result.getString("productName");
                int quantity = result.getInt("quantity");
                double unitPrice = searchProduct(productName).getPrice();
                ordProduct = new OrderedProduct(orderId, 0, productName, quantity, unitPrice);
                list.add(ordProduct);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return list;
    }
    
             // Recherche des catégories d'une jTable
    public ArrayList<String> getCategories()
    {
        ArrayList<String> list = new ArrayList<>();
        boolean duplicate = false;
        
        try{
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Product");
            ResultSet result = statement.executeQuery();
            
            while(result.next())
            {
                String category = result.getString("category");
                for(int i=0 ; i < list.size() ; i++)
                {
                    if(category.equals(list.get(i)))
                        duplicate = true;
                }
                if(duplicate == false)
                    list.add(category);
                duplicate = false;
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
             // recherche de tous les produits commandés 
    public ArrayList<OrderedProduct> getAllOrderedProducts()
    {
        ArrayList<OrderedProduct> list = new ArrayList<>();
        OrderedProduct product;
        
        try{
            PreparedStatement statement = con.prepareStatement("SELECT * FROM OrderedProduct");
            ResultSet result = statement.executeQuery();
            
            while(result.next())
            {
                int orderID = result.getInt("orderID");
                int id =result.getInt("id");
                String productName = result.getString("productName");
                int quantity =result.getInt("quantity");

                product = new OrderedProduct(orderID, id, productName, quantity, 0);
                list.add(product);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
             // recherche de toutes les commandes 
    public ArrayList<Order> getOrders()
    {
        ArrayList<Order> list = new ArrayList<>();
        Order order;
        
        try{
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Orders");
            ResultSet result = statement.executeQuery();
            
            while(result.next())
            {
                String email = result.getString("email");
                int orderID = result.getInt("id");
                Date date = result.getDate("date");
                double total = result.getDouble("total");
                order = new Order(email);
                order.setTotal(total);
                order.setId(orderID);
                order.setDate(date);
                //order.setArrayList(this.getOrderedProducts(orderID));
                list.add(order);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    
    

}
