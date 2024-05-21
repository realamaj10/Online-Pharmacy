/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.base;

/**
 *
 * @author anisl
 */
public class WithPerscription extends Product {

    public WithPerscription(String name, Date pd, double purchasePrice, Date expiryDate, double price, int stock) {
        super(name, pd, purchasePrice, expiryDate, price, stock);
        setCategory(Category.Perscription);
    }

    @Override
    public String toString() {
        return "Perscription{" + super.getName() + " " + super.getPd() + " " + super.getPurchasePrice() + " " + super.getExpiryDate()
              + " "  +super.getPrice()+'}';
    }
    

 
    
}
