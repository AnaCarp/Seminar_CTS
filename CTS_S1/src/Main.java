import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        OnlineShop o = new OnlineShop("Emag", "logo.jpg", new ArrayList<Product>());

        Product p1 = new Product("Laptop", 3200.5, 1,1, 1123, "");
        Product p2 = new Product("Frigider", 207.95, 1,2, 1245, "");

        Product p3 = new Product(p1);

        p3.setQty(5);
        p3.setName("Paine");

        o.modifyProductsList(1,p1);
        o.modifyProductsList(1,p2);

        o.modifyProductsList(2, p1);
        System.out.println(p1.equals(p2));
    }
}

class OnlineShop {
    private String name;
    private String i;
    private ArrayList<Product> products;

    OnlineShop(String name, String img, ArrayList<Product> products)
    {
        this.products = new ArrayList<Product>();
        this.i = img;
        this.name = name;
    }

    public void modifyProductsList(int what, Product p)
    {
        if(what == 1)
        {
            this.products.add(p);
        }
        else
            this.products.remove(p);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getI() {
        return i;
    }

    public void setImg(String img) {
        this.i = img;
    }
}

class Product
{
    private int id;
    private String name;
    private double price;
    private int productType;
    private int productCategory;
    private int qty;
    private String exp; //expiry date - only for goods
    private String details; // ex.: processor, memory, power, volume (for refrigerators etc)

    public Product(String n, double p, int pt, int pc, int id, String exp)
    {
        name = n;
        price = p;
        productType = pt;
        productCategory = pc;
        this.id = id;
        this.exp = exp;
    }

    public Product(Product p)
    {
        this.name = p.name;
        this.price = p.price;
        this.productType = p.productType;
        this.productCategory = p.productCategory;
        this.id = p.id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public boolean equals(Product p)
    {
        if(p.id != this.id)
            return false;
        if(!p.name.equals(this.name))
            return false;
        if(p.price != this.price)
            return false;
        if(p.productType != p.productType)
            return false;
        if(p.productCategory != this.productCategory)
            return false;

        return true;
    }

    public void modify(boolean flag, double val)
    {
        if(flag)
            this.price+=this.price*val;
        if(!flag)
            this.price-=this.price*val/100;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

class User
{
    private String usn;
    private String userId;
    private ArrayList<Order> o;
    private ArrayList<Order> c;

    public User(String usn, String userId)
    {
        this.usn = usn;
        this.userId = userId;
        o=new ArrayList<Order>();
        c=new ArrayList<Order>();
    }

    public void addO1(Order o)
    {
        this.o.add(o);
    }

    public void addO2(Order o)
    {
        this.c.add(o);
    }
}

class Order
{
    private ArrayList<Product> l;
    private String addr;

    public Order()
    {
        l = new ArrayList<Product>();
    }
    public void add(Product p)
    {
        if(l.size() > 99)
            return;

        l.add(p);
    }

    public void remove(Product p)
    {
        l.remove(p);
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}

class InventoryP
{
    private Product p;
    private int q;

    public InventoryP(Product p, int q)
    {
        this.p = new Product(p);
        this.q = q;
    }
    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }
}


