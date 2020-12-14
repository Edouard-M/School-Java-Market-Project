/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
import Model.DAO;
import Model.Employee;
import Model.Order;
import Model.OrderedProduct;
import Model.Product;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
  * Classe d'Initialisation
  * Détruit et réinitialise la Base De données
  * Permet de générer aléatoirement des commandes (pour les graphes jolis)
  */
public class Initialisation
{
    private static ArrayList<Product> allProducts;
    
    // Constructeur 
    public Initialisation()
    {
    }
    
    // Remplissage de le BDD
    public void testDB() throws Exception
    {
        Product banane = new Product("biere volkan", "alcohol", "<html>seigle grillé et miel léger<br> une palette savoureuse 5%</html>", 3.9, 226, null, "biere.png");
        banane.insertProduct();
        Product banane2 = new Product("tsipouro", "alcohol", "<html>le tsipouro sans anis Apostolaki<br> est sans doute le plus connu.40%<html>", 21.90, 33, null, "tsipouro.png");
        banane2.insertProduct();
        Product banane3 = new Product("mastic tears", "alcohol", "<html>version classique de la liqueur <br>de mastika traditionelles 47%</html>", 19.90, 52, null, "mastictears.png");
        banane3.insertProduct();
        Product banane4 = new Product("ouzo", "alcohol", "<html>La véritable âme de la Grèce,<br> c est L ouzo le plus ivre du monde</html>", 16.00, 44, null, "ouzo.png");
        banane4.insertProduct();
        Product banane5 = new Product("vin Blanc Assyrtiko", "alcohol", "<html>Canava du domaine de<br> Tselepos santorin 13.5%</html>", 38.00, 50, null, "vinblanc.png");
        banane5.insertProduct();
        Product banane6 = new Product("huile extra vierge", "grocery", "Lucius l excellence de l huile grec 5L", 24.00, 32, null, "huile.png");
        banane6.insertProduct();
        Product banane7 = new Product("miel de fleurs", "grocery", "Le miel de fleurs sauvages en coffret cadeau", 12.2, 40, null, "miel.png");
        banane7.insertProduct();
        Product banane8 = new Product("loukoumi", "grocery", "Variété de loukoumia greques aromatisée", 3.90, 54, null, "loukoumi.png");
        banane8.insertProduct();
        Product banane9 = new Product("riz dolmadakia", "grocery", "<html>Dolmadakia avec des feuilles de vigne,<br> farcie de riz<html>", 4.29, 92, null, "dolma.png");
        banane9.insertProduct();
        Product banane12 = new Product("capres", "grocery", "<html>Câpres sauvages du sol <br>volcanique anhydre de Santorin<html>", 5.39, 127, null, "capres.png");
        banane12.insertProduct();
        Product banane10 = new Product("kefir olympus", "fresh", "yaourt grec 1% au kéfir.", 4.25, 42, null, "kefir.png");
        banane10.insertProduct();
        Product banane11 = new Product("moussaka", "fresh", "<html>la moussaka est un plat riche <br>et traditionnellement grec.</html>", 6.50, 22, null, "moussaka.png");
        banane11.insertProduct();
        Product banane13 = new Product("soutzouki", "fresh", "<html>Le délicieux soutzouki, <br>prêt à être coupé en tranches et dégusté.<html>", 9.99,67 , null, "soutzouki.png");
        banane13.insertProduct();
        Product banane14 = new Product("feta", "fresh", "La feta grecque AOP de 400g!", 5.50, 34, null, "feta.png");
        banane14.insertProduct();
        Product banane15 = new Product("pastrami", "fresh", "<html>Le pastrami exquis coupé en tranches<br>et prêt à être apprécié!</html>", 7.99, 52, null, "pastrami.png");
        banane15.insertProduct();
        
        banane14.addDiscount(10, 45);
        banane.addDiscount(6, 20);
        banane7.addDiscount(4, 35);
        banane3.addDiscount(3, 50);
        banane11.addDiscount(4,22);
        banane8.addDiscount(10,30);
        
        
        
        
        
        
        
        
        Customer gaga = new Customer("Gaetan", "Bouchy", 23, "0678461259", "3 impasse des chemin rébus briis sous forges 91111", "gaetan.bouchy@edu.ece.fr", "pass123");
        gaga.insertCustomer();
        Customer arno = new Customer("Arnaud", "Lambert", 34, "06953342576", " 8 rue eugene sue rueil-malmaison 92500", "arnaud.lambert@edu.ece.fr", "pass123");
        arno.insertCustomer();
        Customer benji = new Customer("Benjamin", "Léocadio", 47, "0671345621", " 112 rue de Geneve Alfortville 94140", "benjamin.leocadio@edu.ece.fr", "pass123");
        benji.insertCustomer();
        Customer mathias = new Customer("Mathias", "Sericola", 63, "0645321578", " 30  boulevard Albin Durand Chalon-sur-saone 71100 ", "mathias.sericola@edu.ece.fr", "pass123");
        mathias.insertCustomer();
        Customer cherine = new Customer("Cherine", "Seo", 19, "0678953645", "57 avenue voltaire Malakoff 92240", "cherine.seo@edu.ece.fr", "pass123");
        cherine.insertCustomer();
        Customer antoine= new Customer("Antoine", "Stutzmann", 43, "0768241239", " 107  rue Pierre De Coubertin Toulouse 31100", "antoine.stutzmann@edu.ece.fr", "pass123");
        antoine.insertCustomer();
        
        //Customer vide= new Customer("Antoine", "Stutzmann", 43, "0768241239", " 107  rue Pierre De Coubertin Toulouse 31100", "", "");
        //vide.insertCustomer();
        Employee empVide = new Employee("Matilda", "Dufresne", 28, "0645648423", "120  rue de Raymond Poincaré Nantes 44200", "", "");
        empVide.insertEmployee();
        
        Employee emp1 = new Employee("Matilda", "Dufresne", 28, "0645648423", "120  rue de Raymond Poincaré Nantes 44200", "matilda.dufresne@wondershop.com", "pass123");
        emp1.insertEmployee();
        Employee admin = new Employee("Fred", "Blanchard", 33, "0678964572", "3 rue des moulins maison lafittes", "admin@gmail.com", "ADMIN");
        admin.insertEmployee();
        Employee emp2 = new Employee("Apolline", "Tremblay", 40, "0645691230", "112 rue Sadi Carnot Auch 32000", "apolline.tremblay@wondershop.com", "pass123");
        emp2.insertEmployee();
        Employee emp3 = new Employee("Henry", "Tougas", 24, "0796472313", "26  place Maurice-Charretier Chartres 28000", "henry.tougas@wondershop.com", "pass123");
        emp3.insertEmployee();
        Employee emp4 = new Employee("Clement", "Bouvard", 20, "0640787637", "38 quai de grenelle Paris 75015", "clement.bouvard@edu.ece.fr", "pass123");
        emp4.insertEmployee();
        Employee emp5 = new Employee("Edouard", "Mignien", 20, "0645648423", "4 avenue du général de Gaulle Poitiers 86000", "edouard.mignien@edu.ece.fr", "pass123");
        emp5.insertEmployee();
        
        //Discount DiscountBanane = new Discount("Banane", 10, 9);
        //kiwi.addDiscount(10, 25);
        //banane5.addDiscount(12, 20);

       // Order order1 = new Order("marc.damp@gmail.com");
        
        
        
        
        
        
        addOrdersDefault();
    }

    // SUppression de la BDD
    public void dropAllTable()
    {
        DAO dao = new DAO();
        dao.getConnection();
        dao.query("DROP TABLE Product");
        dao.query("DROP TABLE Discount");
        dao.query("DROP TABLE Customer");
        dao.query("DROP TABLE Employee");
        dao.query("DROP TABLE OrderedProduct");
        dao.query("DROP TABLE Orders");
        dao.closeConnection();
       // System.out.println("All Table Droped");
    }
    
    
    
    public void addOrdersDefault()
    {
        try{
            /*
            Order order = new Order("DefaultEmail");
            order.setDate(createDate("02/11/2020"));
            ArrayList<OrderedProduct> list1 = new ArrayList<>();
            list1.add(new OrderedProduct(order.getId(), 0, "Banane", 10, 0));
            list1.add(new OrderedProduct(order.getId(), 0, "Kiwi", 10, 0));
            order.setArrayList(list1);
            order.insertAllOrder();
            */
            
            /*Order order2 = new Order("DefaultEmail");
            order2.setDate(createDate("03/10/2020"));
            ArrayList<OrderedProduct> list2 = new ArrayList<>();
            list2.add(new OrderedProduct(order2.getId(), 0, "Banane", 10, 0));
            list2.add(new OrderedProduct(order2.getId(), 0, "Kiwi", 11, 0));
            order2.setArrayList(list2);
            order2.insertAllOrder();
            */
            DAO dao = new DAO();  
            dao.getConnection();
            allProducts = dao.selectAllProducts();
            dao.closeConnection();
            
            
            for(int i=1 ; i<=30 ; i++)
            {
                int or = 0 + (int)(Math.random() * ((10 - 0) + 1));
                if(or < 3)
                {
                Order ord = new Order("DefaultEmail");
                if(i<10)
                    ord.setDate(createDate("0" + String.valueOf(i) + "/10/2020"));
                else
                    ord.setDate(createDate(String.valueOf(i) + "/10/2020"));
                
                ord.setArrayList(aleaProduct(ord));
                ord.insertAllOrder();
               }
            }
            for(int i=1 ; i<=30 ; i++)
            {
                int or = 0 + (int)(Math.random() * ((10 - 0) + 1));
                if(or == 0)
                {
                Order ord = new Order("DefaultEmail");
                if(i<10)
                    ord.setDate(createDate("0" + String.valueOf(i) + "/11/2020"));
                else
                    ord.setDate(createDate(String.valueOf(i) + "/11/2020"));
                
                ord.setArrayList(aleaProduct(ord));
                ord.insertAllOrder();
                }
            }
                    
            
        
            
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<OrderedProduct> aleaProduct(Order ord)
    {
        ArrayList<OrderedProduct> list = new ArrayList<>();
        int orderAmount = 0 + (int)(Math.random() * ((2 - 0) + 1));
        
        try{
        
            for(int i=0 ; i<orderAmount ; i++)
            {
                int productNum = 0 + (int)(Math.random() * (((allProducts.size()-1) - 0) + 1));
                int quantity = 1 + (int)(Math.random() * (((10) - 1) + 1));
                
                
                
                list.add(new OrderedProduct(ord.getId(), 0, allProducts.get(productNum).getName(), quantity, allProducts.get(productNum).getPrice()));
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return list;
    }
    
    public Date createDate(String str)
    {
        java.util.Date date = null;
        try
        {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(str);
        } 
        catch (ParseException e)
        {
            System.out.println("Error date");
            System.out.println(e.getMessage());
        }
        
        Date dateSQL = new java.sql.Date(date.getTime()); 
        
        return dateSQL;
    }
}
