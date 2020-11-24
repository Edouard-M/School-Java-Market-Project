/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

/**
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
 */
public class DAO
{

    private final Connection connect;

    public DAO() throws Exception
    {
        connect = getConnection();
    }

    public static Connection getConnection() throws Exception
    {
        try
        {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://dbtest.cfuu3y9e8cbz.eu-west-3.rds.amazonaws.com:3306/DB";
            String username = "admin";
            String password = "Jolipuzzle";

            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
            //System.out.println("Connected to server !");
            return con;
        } catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

    public static PreparedStatement query(String query)
    {
        try
        {
            boolean exist = false;
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.executeUpdate();
            return statement;
        } catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

    public static void createAllTable() throws Exception
    {
        try
        {
            Connection con = getConnection();
            PreparedStatement create;
            create = con.prepareStatement("CREATE TABLE IF NOT EXISTS Product( name varchar(255), category varchar(255), description varchar(255), price double, stock int, discountId int, image varchar(255), PRIMARY KEY(name))");
            create.executeUpdate();
            create = con.prepareStatement("CREATE TABLE IF NOT EXISTS Orders( id int, email varchar(255), PRIMARY KEY(id))");
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

    public static Product searchProduct(String search) throws Exception
    {
        String name, category, description, image;
        double price;
        int stock;

        Connection con = getConnection();
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

    public static Discount searchDiscount(String search) throws Exception
    {
        String name = "";
        int quantity = 0;
        double price = 0;

        Connection con = getConnection();
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

    public static boolean searchCustomer(String enteredemail, String enteredpassword) throws Exception
    {
        Connection con = getConnection();
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

    public static boolean searchEmployee(String enteredemail, String enteredpassword) throws Exception
    {
        Connection con = getConnection();
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
    
    public static Employee getEmployee(String email) throws Exception
    {
        Connection con = getConnection();
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

    public static String getEmployeeName(String email) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Employee WHERE email = '" + email + "'");
        String name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getString("name");
         return name;
        }
        return "";
    }

    public static String getEmployeeFirstName(String email) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Employee WHERE email = '" + email + "'");
       String name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getString("firstname");
         return name;
        }
        return "";
    }

    public static String getEmployeeAddress(String email) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Employee WHERE email = '" + email + "'");
          String name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getString("address");
         return name;
        }
        return "";
    }

    public static String getEmployeePhone(String email) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Employee WHERE email = '" + email + "'");
         String name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getString("phone");
         return name;
        }
        return "";
    }

    public static String getEmployeePassword(String email) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Employee WHERE email = '" + email + "'");
        String name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getString("password");
         return name;
        }
        return "";
    }

    public static int getEmployeeAge(String email) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Employee WHERE email = '" + email + "'");
         int name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getInt("age");
         return name;
        }
        return 0;
    }
    public static void EditEmployee(String email,String firstname, String name,String address,String phone,int age,String password) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement statement;
        statement = con.prepareStatement("SELECT firstname, name,address,phone,age,password FROM Employee WHERE email= '" + email + "'");
        statement.executeQuery();
        statement = con.prepareStatement("UPDATE Employee SET firstname = '"+firstname+"' ,name='"+name+"', address = '"+address+"', phone = '"+phone+"', age= "+age+" ,password = '"+password+"' WHERE email = '"+email+"'");
        statement.executeUpdate();
    }
    
    
    
     public static Customer getCustomer(String email) throws Exception
    {
        Connection con = getConnection();
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
    public static String getCustomerName(String email) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Customer WHERE email = '" + email + "'");
        String name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getString("name");
         return name;
        }
        return "";
    }

    public static String getCustomerFirstName(String email) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Customer WHERE email = '" + email + "'");
       String name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getString("firstname");
         return name;
        }
        return "";
    }

    public static String getCustomerAddress(String email) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Customer WHERE email = '" + email + "'");
          String name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getString("address");
         return name;
        }
        return "";
    }

    public static String getCustomerPhone(String email) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Customer WHERE email = '" + email + "'");
         String name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getString("phone");
         return name;
        }
        return "";
    }

    public static String getCustomPassword(String email) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Customer WHERE email = '" + email + "'");
        String name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getString("password");
         return name;
        }
        return "";
    }

    public static int getCustomerAge(String email) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Customer WHERE email = '" + email + "'");
         int name;
        ResultSet result = statement.executeQuery();
        if (result.next())
        {   name = result.getInt("age");
         return name;
        }
        return 0;
    }
    public static void EditCustomerdata(String email,String firstname, String name,String address,String phone,int age,String password) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement statement;
        statement = con.prepareStatement("SELECT firstname, name,address,phone,age,password FROM Customer WHERE email= '" + email + "'");
        statement.executeQuery();
        statement = con.prepareStatement("UPDATE Customer SET firstname = '"+firstname+"' ,name='"+name+"', address = '"+address+"', phone = '"+phone+"', age= "+age+" ,password = '"+password+"' WHERE email = '"+email+"'");
        statement.executeUpdate();
    }
    public static ArrayList<Product> selectAllProducts() throws Exception
    {
        try
        {
            Product product;
            Connection con = getConnection();
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

    public static int getRowSize(String tableName) throws Exception
    {
        ArrayList<String> array = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM " + tableName);
        ResultSet result = statement.executeQuery();

        while (result.next())
        {
            array.add(result.getString("name"));
        }

        return array.size();
    }

    public static String[] getCol(String tableName) throws Exception
    {
        String[] col;

        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM " + tableName + "");
        ResultSet result = statement.executeQuery();
        ResultSetMetaData meta = result.getMetaData();

        col = new String[meta.getColumnCount()];

        for (int i = 0; i < meta.getColumnCount(); i++)
            // Get a column name.
            col[i] = meta.getColumnLabel(i + 1);

        return col;
    }

    public static String[][] getLines(String tableName) throws Exception
    {
        int numRows = getRowSize(tableName);
        String[][] lines;

        Connection con = getConnection();
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

}
