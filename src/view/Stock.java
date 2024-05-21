package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Stock {

    Scene sc2;

    public void show(Stage primaryStage) {
        
        GridPane g1 = new GridPane();
        Button b1 = new Button("Add Stock");
        Button b2 = new Button("Remove Stock");
        Button back = new Button("Return");
        Button b3 = new Button("Check Suppliers");

        File theDir = new File("C:/Pharm2/product");
        if (!theDir.exists()) {
            theDir.mkdir();
            String directory = "C:/Pharm2/product/products.txt";
            File file = new File(directory);
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent args0) {

            }
        });

        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent args0) {

            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new ManagerView()).show(primaryStage);
                primaryStage.show();
            }
        });

        GridPane g2 = new GridPane();
        sc2 = new Scene(g2, 200, 300);

        g1.addRow(3, b1, b2, back);
        g1.setAlignment(Pos.CENTER);
        g1.setHgap(10);

        Scene sc = new Scene(g1, 400, 350);
        primaryStage.setScene(sc);
        primaryStage.setMaxWidth(500);
        primaryStage.setMaxHeight(400);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Stock");
        primaryStage.show();

        try {
            Scanner prod = new Scanner(new BufferedReader(new FileReader("C:/Pharm2/product/products.txt")));
            while (prod.hasNextLine()) {
                String product = prod.nextLine();
                int quantity = prod.nextInt();
                prod.nextLine();
                double price = prod.nextDouble();
                prod.nextLine();
                if (quantity < 5) {
                    Alert alt = new Alert(Alert.AlertType.INFORMATION);
                    alt.setContentText("You need to restock " + product);
                    alt.show();
                }
            }
        } catch (IOException ex) {
            Alert aa = new Alert(Alert.AlertType.ERROR);
            aa.setContentText("File doesn't exist");
            aa.show();
        }
    }
}
