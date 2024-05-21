package model.RW;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.base.Bill;
import model.base.Product;

public class BillRW {
    
    private final File fB;
    private ArrayList<Bill> bill;
    private ArrayList<Product> prod;

	public BillRW(){
            fB = new File("BillNo.txt");
            bill = new ArrayList<Bill>();
            if(!fB.exists()){
                writeBill();
            }else{
                bill = readBill();
            }
        }
        public ArrayList<Bill> readBill(){
            try{
                FileInputStream fis = new FileInputStream(fB); 
		ObjectInputStream ois=new ObjectInputStream(fis);
		bill=(ArrayList<Bill>) ois.readObject();
		ois.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not Found!!!");
		} catch (ClassNotFoundException e) {
			System.err.println("Class not Found!!!");
		} catch (IOException e) {
			System.err.println("File not accessable!!!");
		}
		return null;
	}

	private void writeBill() {
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fB));
			oos.writeObject(bill);
			oos.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not Found!!!");
		} catch (IOException e) {
			System.err.println("File not Writable!!!");
		}
	}
	public void addBill(Bill b){
		bill.add(b);
		writeBill();
	}
	
	public Bill getBill(String bid){
		for(Bill x:bill){
			if(x.getBid()==bid){
				return x;
			}
		}
		return null;
	}
 public void doesNotExist(){
     //ALERT JAVAFX
       for(Bill b:bill){
       if(!prod.contains(b.getProdName())){
           System.err.println("This does not exist");
       }
   }
 }
   
   public void outOfStock(){
       //ALERT JAVAFX
      for(Product p:prod){
          if(p.getStock()==0){
               System.err.println("This is out of stock");
      }
   }

}
}
