package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.*;
import java.util.Scanner;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ViewSuppliers {

    
    public void show(Stage primaryStage) {
        
        ListView<String> listView = new ListView<>();
        GridPane main = new GridPane();
        GridPane g1 = new GridPane();
        TextField name = new TextField();
        TextField product = new TextField();
        TextField price = new TextField();
        Button add = new Button("Add");
        add.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: green;");
        Button back = new Button("Back");
        back.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: green;");
        Label l1 = new Label("Name");
        l1.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        l1.setTextFill(Color.GREEN);
        Label l2 = new Label("Product");
        l2.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        l2.setTextFill(Color.GREEN);
        Label l3 = new Label("Price");
        l3.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        l3.setTextFill(Color.GREEN);
        
        VBox vb = new VBox();
        vb.getChildren().add(back);
        g1.addRow(0,l1,name,l2,product,l3,price,add,vb);
        main.addRow(0,listView);
        main.addRow(1,g1);
        String directory = "C:/Pharmacy2/supp.txt";
        File file = new File(directory);
        try {
            Scanner read = new Scanner(new BufferedReader(new FileReader(directory)));
            while (read.hasNextLine()) {
                boolean user = false;
                while (read.hasNextLine()){
                    String name_s = read.nextLine();
                    String product_s = read.nextLine();
                    double price_s = read.nextDouble();
                    read.nextLine();
                    listView.getItems().add("Suppliers name: "+name_s+" product: "+product_s+" price per product: "+price_s);
                }
            }
            // Always close files.

        } catch (IOException ex) {
            System.out.println(
                    "Unable to open file");
        }
         back.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent args0){
                (new ManagerView()).show(primaryStage);
                primaryStage.show();
                
            }
        });
        
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                file.getParentFile().mkdirs();
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    FileWriter pw = new FileWriter(file.getAbsoluteFile(), true);
                    pw.write(name.getText() + "\n");
                    pw.write(product.getText() + "\n");
                    pw.write(price.getText() + "\n");
                    pw.close();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
                try {
                    
                    Scanner read = new Scanner(new BufferedReader(new FileReader(directory)));
                    while (read.hasNextLine()) {
                        boolean user = false;
                        while (read.hasNextLine()){
                            String name_s = read.nextLine();
                            String product_s = read.nextLine();
                            double price_s = read.nextDouble();
                            read.nextLine();
                            listView.getItems().add("Suppliers name: "+name_s+" product: "
                                    +product_s+" price per product: "+price_s);
                        }
                    }
                    // Always close files.

                } catch (IOException ex) {
                    System.out.println(
                            "Unable to open file");
                }
            }
        });
       
      

        Scene sc = new Scene(main);
        primaryStage.setScene(sc);
        primaryStage.show();


    }
}












   
