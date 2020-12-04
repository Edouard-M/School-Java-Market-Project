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
public class DAO
{
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://dbtest.cfuu3y9e8cbz.eu-west-3.rds.amazonaws.com:3306/DB";
    private final String username = "admin";
    private final String password = "Jolipuzzle";
    private  Connection con;



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

    public  void createAllTable() throws Exception
    {
        try
        {
            
            PreparedStatement create;
            create = con.prepareStatement("CREATE TABLE IF NOT EXISTS Product( name varchar(255), category varchar(255), description varchar(255), price double, stock int, discountId int, image varchar(255), PRIMARY KEY(name))");
            create.executeUpdate();
            create = con.prepareStatement("CREATE TABLE IF NOT EXISTS Orders( id int, email varchar(255), date date, PRIMARY KEY(id))");
            create.executeUpdate();
            create = con.prepareStatement("CREATE TABLE IF NOT EXISTS OrderedProduct( orderID int, id int NOT NULL AUTO_INCREMENT, productName varchar(255), quantity int, PRIMARY KEY(id))");
            create.executeUpdate();
            create = con.prepareStatement("CREATE TABLE IF NOT EXISTS Customer( name varchar(255), firstName varchar(255), age int, phone varchar(255), address varchar(255), email varchar(255), password varchar(255), fidelityPoint int, PRIMARY KEY(email))");
            create.executeUpdate();
            create = con.prepareStatement("CREATE TABLE IF NOT EXISTS Employee( name varchar(255), firstName varchar(255), age int, phone varchar(255), address varchar(255), email varchar(255), password varchar(255), PRIMARY KEY(email))");
            create.executeUpdate();
            create = con.prepareStatement("CREATE TABLE IF NOT EXISTS Discount( name varchar(255), quantity int, price double, PRIMARY KEY(name))");
            create.executeUpdate();
            System.out.println("All Table Created");
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

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
    public void productDelete(String name) throws Exception
    {
        
        PreparedStatement statement = con.prepareStatement("DELETE FROM Product WHERE name = '" +name+ "'");
         statement.executeUpdate();
    }
    public  void discountDelete(String name) throws Exception
    {
        
        PreparedStatement statement = con.prepareStatement("DELETE FROM Discount WHERE name = '" +name+ "'");
         statement.executeUpdate();
    }
    public void employeeDelete(String email) throws Exception
    {
       
        PreparedStatement statement = con.prepareStatement("DELETE FROM Employee WHERE email = '" +email+ "'");
         statement.executeUpdate();
    }
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
    public void EditEmployee(String email,String firstname, String name,String address,String phone,int age,String password) throws Exception
    {
        PreparedStatement statement;
        statement = con.prepareStatement("SELECT firstname, name,address,phone,age,password FROM Employee WHERE email= '" + email + "'");
        statement.executeQuery();
        statement = con.prepareStatement("UPDATE Employee SET firstname = '"+firstname+"' ,name='"+name+"', address = '"+address+"', phone = '"+phone+"', age= "+age+" ,password = '"+password+"' WHERE email = '"+email+"'");
        statement.executeUpdate();
    }
    
    
    
     public Customer getCustomer(String email) throws Exception
    {
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Customer WHERE email = '" + email + "'");
        String name, firstName, phone, adress, mail, password;
        int age;
        System.out.println("ebGRQINIJBQPOFNBQJ");
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
    public void EditCustomerdata(String email,String firstname, String name,String address,String phone,int age,String password) throws Exception
    {
        PreparedStatement statement;
        statement = con.prepareStatement("SELECT firstname, name,address,phone,age,password FROM Customer WHERE email= '" + email + "'");
        statement.executeQuery();
        statement = con.prepareStatement("UPDATE Customer SET firstname = '"+firstname+"' ,name='"+name+"', address = '"+address+"', phone = '"+phone+"', age= "+age+" ,password = '"+password+"' WHERE email = '"+email+"'");
        statement.executeUpdate();
    }
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
    
    

}
