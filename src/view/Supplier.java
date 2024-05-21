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
import static javafx.application.Application.launch;

public class Supplier {

    public void show(Stage primaryStage) {
        ListView<String> listView = new ListView<>();
        GridPane main = new GridPane();
        GridPane g1 = new GridPane();
        TextField name = new TextField();
        TextField product = new TextField();
        TextField price = new TextField();
        Button add = new Button("Add");
        Label l1 = new Label("Name");
        Label l2 = new Label("Product");
        Label l3 = new Label("Price");
        g1.addRow(0,l1,name,l2,product,l3,price,add);
        main.addRow(0,listView);
        main.addRow(1,g1);
        String directory = "C:/SuperMarket/supp.txt";
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
                    listView.getItems().clear();
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
            }
        });

        Scene sc = new Scene(main);
        primaryStage.setScene(sc);
        primaryStage.show();


    }
}