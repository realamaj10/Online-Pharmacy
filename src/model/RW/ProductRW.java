package model.RW;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.base.Product;

public class ProductRW {

    private final File fProduct;
    private ArrayList<Product> prod;

    public ProductRW() {
        fProduct = new File("product.txt");
        prod = new ArrayList<Product>();
        if (!fProduct.exists()) {
            writeProduct();
        } else {
            prod = readProduct();
        }
    }

    public ArrayList<Product> readProduct() {
        try {
            FileInputStream fis = new FileInputStream(fProduct);
            ObjectInputStream ois = new ObjectInputStream(fis);
            prod = (ArrayList<Product>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not Found!!!");
        } catch (ClassNotFoundException e) {
            System.err.println("Class not Found!!!");
        } catch (IOException e) {
            System.err.println("File not accessable!!!");
        }
        return prod;
    }

    private void writeProduct() {
        try {
            FileOutputStream fos = new FileOutputStream(fProduct);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fProduct));
            oos.writeObject(prod);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not Found!!!");
        } catch (IOException e) {
            System.err.println("File not Writable!!!");
        }
           readProduct();
    }

    public void addProduct(Product p) {
        prod.add(p);
        writeProduct();
    }

    public void removeProduct(Product p) {
        prod.remove(p);
        writeProduct();
    }

//    public Product getProduct(String name) {
//        for (Product x : prod) {
//            if (x.getName() == name) {
//                return x;
//            }
//        }
//        return null;
//    }

}
