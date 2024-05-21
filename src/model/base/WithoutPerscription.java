package model.base;

public class WithoutPerscription extends Product{
    
    public WithoutPerscription(String name, Date pd, double purchasePrice, Date expiryDate, double price, int stock) {
        super(name, pd, purchasePrice, expiryDate, price, stock);
        setCategory(Category.OTC);
    }

    @Override
    public String toString() {
        return "With Perscription{" + super.getName() + " " + super.getPd() 
                + " " + super.getPurchasePrice() + " " + super.getExpiryDate()
              + " "  +super.getPrice()+'}';
    }
    
    
    
}
