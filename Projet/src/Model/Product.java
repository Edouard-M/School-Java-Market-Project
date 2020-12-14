
package Model;

/**
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
 */
/**
  * Classe product (Classe modele, d'une Persone)
  *
  * Contient : - un nom
  *            - une catégorie
  *            - une description
  *            - un prix
  *            - un stock
  *            - une image (string du nom de l'image dans le dossier)
  *            - une réduction
  *            - le DAO
  */
public class Product
{
    private final String name;
    private final String category;
    private final String description;
    private final double price;
    private final int stock;
    private final String image;
    private Discount discount;
    private final DAO dao;
    
        // Constructeur
    public Product(String Name, String Category, String Description, double Price, int Stock, Discount Discount, String Image) throws Exception
    {
        dao= new DAO();
        name = Name;
        category = Category;
        description = Description;
        price = Price;
        stock = Stock;
        discount = Discount;
        image = Image;
    }
    
        // Ajout d'une réduction liée au Produit
    public void addDiscount(int discountQuantity, double discountPrice) throws Exception
    {
        discount = new Discount(name, discountQuantity, discountPrice);
        discount.insertDiscount();
    }
    
        // Insert du produit dans la BDD
    public void insertProduct() throws Exception
    {
        try{
            dao.getConnection();
            dao.query("INSERT INTO Product (name, category, description, price, stock, image) VALUES ('"+name+"', '"+category+"', '"+description+"', '"+price+"', '"+stock+"', '"+image+"')");
            dao.closeConnection();
        }
        catch(Exception e){System.out.println(e);}
    }
    
    // Getters
    
    public String getName()
    {
        return name;
    }
    public String getCategory()
    {
        return category;
    }
    public String getDescription()
    {
        return description;
    }
    public double getPrice()
    {
        return price;
    }
    public int getStock()
    {
        return stock;
    }
    public Discount getDiscount()
    {
        return discount;
    }
    public String getImage()
    {
        return image;
    }
    
    
}