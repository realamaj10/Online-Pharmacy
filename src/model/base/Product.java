package model.base;

public class Product {
    
    private int pid;
    public static int z=0;
    private String name;
    private Category category;
    private Date pd;
    private double purchasePrice;
    private Date expiryDate;
    private double price;
    private int stock;

    public Product(String name, Date pd, double purchasePrice, Date expiryDate, double price, int stock) {
        pid=z++;
        this.name = name;
        this.pd = pd;
        this.purchasePrice = purchasePrice;
        this.expiryDate = expiryDate;
        this.price = price;
        this.stock=stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Category getCategory() {
		return category;
	}

    public Date getPd() {
        return pd;
    }

    public void setPd(Date pd) {
        this.pd = pd;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

 
    public void setCategory(Category cat){
        this.category=category;
    }

    @Override
    public String toString() {
        return "Product{" + "pid=" + pid +
                ", name=" + name + ", category="  + category + ", pd=" + pd 
                + ", purchasePrice=" + purchasePrice + ", expiryDate=" + expiryDate 
                + ", price=" + price + ", stock=" + stock + '}';
    }
    
   
    
    
    
    
    
    
}
