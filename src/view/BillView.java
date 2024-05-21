//package view;
//
//import java.awt.Desktop;
//import java.io.File;
//import java.io.IOException;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//import model.RW.BillRW;
//import model.RW.ProductRW;
//import model.RW.UserRW;
//import model.base.Bill;
//import model.base.Date;
//import model.base.Employee;
//import model.base.Pharmacist;
//import model.base.Product;
//import model.base.RegDay;
//import static model.base.Type.Pharmacist;
//
////Pharmacist should create a bill and enter the data of the bought medical products, such as name of the
////medical product and its quantity. If the medical product does not exist or is out of stock, it should automatically give
////him an alert about it. The software should provide him the total amount of the bill and it should be in a printable format
////([BillNo].txt). The updates in the software file should be done automatically by adding the data into the respective files.
//public class BillView {
//
//    private Employee pharm;
//    
//    public void show(Stage st) {
//
//        BillRW rw = new BillRW();
//        Label bId = new Label("Bill ID");
//        Label produName = new Label("Product Name");
//        Label quantityL = new Label("Quantity");
//        Label pharmL = new Label("Pharmacy Name");
//        Label rdL = new Label("Register Day");
//
//        TextField bid = new TextField();
//        TextField prodName = new TextField();
//        TextField quantity = new TextField();
//        TextField pharma = new TextField();
//        TextField rd = new TextField();
//
//        Button create = new Button("Create New Bill");
//        Button back = new Button("Return");
//
//        VBox v1 = new VBox();
//        v1.getChildren().addAll(bId, bid, produName, prodName, quantityL, quantity, pharmL, pharma, rdL, rd, create, back);
//        v1.setSpacing(7);
//        v1.setAlignment(Pos.CENTER);
//
//        Scene sc = new Scene(v1, 700, 700);
//        st.setScene(sc);
//        st.setTitle("Bill View");
//        st.show();
//
//  ////////BUTTON FUNCTIONS
//        create.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent arg0) {
//                if (bid.getText() != null && prodName.getText() != null
//                        && quantity.getText() != null && pharma.getText() != null
//                        && rd.getText() != null) {
//
//                    BillRW bill = new BillRW();
//                    bill.addBill(new model.base.Bill(
//                            bid.getText(),
//                            prodName.getText(),
//                            quantity.getText(),
//                            pharma.getText(),
//                            rd.getText()));
//                     
//    if (fB.exists())
//    {
//     if (Desktop.isDesktopSupported())
//     {
//      try
//      {
//       Desktop.getDesktop().open(fB);
//      }
//      catch (IOException e)
//      {
//      
//       e.printStackTrace();
//      }
//     }
//     else
//      {
//       System.err.println("Awt Desktop is not supported!");
//      }
//    }
//    
//    else
//    {
//     System.err.println("File does not exist!");
//    }
//  
//   }
//                    (new PharmacistView()).show(st);
//                    st.show();
//                }
//
//        });
//
//         back.setOnAction(new EventHandler<ActionEvent>(){
//			@Override
//			public void handle(ActionEvent arg0) {
//				(new PharmacistView()).show(st);
//				st.show();
//			}
//		});
//    }
//
//}
