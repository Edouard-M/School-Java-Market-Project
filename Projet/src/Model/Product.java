
package Model;
/**
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
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
    
    public void addDiscount(int discountQuantity, double discountPrice) throws Exception
    {
        discount = new Discount(name, discountQuantity, discountPrice);
        discount.insertDiscount();
    }
    
    public void insertProduct() throws Exception
    {
        try{
            dao.getConnection();
            dao.query("INSERT INTO Product (name, category, description, price, stock, image) VALUES ('"+name+"', '"+category+"', '"+description+"', '"+price+"', '"+stock+"', '"+image+"')");
            dao.closeConnection();
        }
        catch(Exception e){System.out.println(e);}
    }
    
    
    
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