package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.RW.ProductRW;
import model.RW.UserRW;
import model.base.Date;
import model.base.Employee;
import model.base.Manager;

public class AddProduct {

    private Employee manager;

    public AddProduct(Employee manager) {
        this.manager = manager;
    }

    public void show(Stage st) {

        Label name = new Label("Name: ");
        name.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        name.setTextFill(Color.LIGHTBLUE);

        TextField nameF = new TextField();
        nameF.setPromptText("Enter name");

        HBox bx1 = new HBox();
        bx1.getChildren().addAll(name, nameF);
        bx1.setSpacing(5);
        bx1.setAlignment(Pos.CENTER);

        ToggleGroup pos = new ToggleGroup();
        RadioButton r1 = new RadioButton("Without Prescription");
        r1.setStyle("-fx-border-color: lightblue; -fx-border-width: 3px; -fx-background-color: lightblue; -fx-text-fill: beige;");
        RadioButton r2 = new RadioButton("With Prescription");
        r2.setStyle("-fx-border-color:lightblue; -fx-border-width: 3px; -fx-background-color: lightblue; -fx-text-fill: beige;");

        r1.setToggleGroup(pos);
        r2.setToggleGroup(pos);

        HBox bx2 = new HBox();
        bx2.getChildren().addAll(r1, r2);
        bx2.setSpacing(5);
        bx2.setAlignment(Pos.CENTER);

        DatePicker dp1 = new DatePicker();
        dp1.setStyle("-fx-background-color: lightblue ;");
        dp1.setPromptText("Enter date");

        Label pd = new Label("Purchase Date :");
        pd.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        pd.setTextFill(Color.LIGHTBLUE);

        HBox bx3 = new HBox();
        bx3.getChildren().addAll(pd, dp1);
        bx3.setSpacing(5);
        bx3.setAlignment(Pos.CENTER);

        Label purchasePrice = new Label("Purchase Price: ");
        purchasePrice.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        purchasePrice.setTextFill(Color.LIGHTBLUE);

        TextField purchaseField = new TextField();
        purchaseField.setPromptText(" Enter purchase field");

        HBox bx4 = new HBox();
        bx4.getChildren().addAll(purchasePrice, purchaseField);
        bx4.setSpacing(5);
        bx4.setAlignment(Pos.CENTER);

        DatePicker dp2 = new DatePicker();
        dp2.setPromptText("Enter the Expiry Date");
        dp2.setStyle("-fx-background-color: lightblue ;");
        Label expD = new Label("Expiry Date :");
        expD.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        expD.setTextFill(Color.LIGHTBLUE);

        HBox bx5 = new HBox();
        bx5.getChildren().addAll(expD, dp2);
        bx5.setSpacing(5);
        bx5.setAlignment(Pos.CENTER);

        Label price = new Label("Selling Price: ");
        price.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        price.setTextFill(Color.LIGHTBLUE);
        TextField priceField = new TextField();
        priceField.setPromptText(" Enter selling price");

        Label stock = new Label("Stock: ");
        stock.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        stock.setTextFill(Color.LIGHTBLUE);
        TextField stockField = new TextField();
        stockField.setPromptText("Enter stock");

        HBox bx6 = new HBox();
        bx6.getChildren().addAll(price, priceField);
        bx6.setSpacing(5);
        bx6.setAlignment(Pos.CENTER);

        HBox bx7 = new HBox();
        bx6.getChildren().addAll(stock, stockField);
        bx6.setSpacing(5);
        bx6.setAlignment(Pos.CENTER);

        Button add = new Button("Add");
        add.setStyle("-fx-border-color: lightblue; -fx-border-width: 5px; -fx-background-color: lightblue; -fx-text-fill: beige;");
        Button back = new Button("Back");
        back.setStyle("-fx-border-color: lightblue; -fx-border-width: 5px; -fx-background-color: lightblue; -fx-text-fill: beige;");

        HBox bx8 = new HBox();
        bx8.getChildren().addAll(add, back);
        bx8.setSpacing(5);
        bx8.setAlignment(Pos.CENTER);

        VBox vb = new VBox();
        vb.getChildren().addAll(bx1, bx2, bx3, bx4, bx5, bx6, bx7, bx8);
        vb.setSpacing(5);
        vb.setAlignment(Pos.CENTER);
        vb.setStyle("-fx-background-color: beige;");
                
        Scene sc = new Scene(vb, 300, 400);
        st.setScene(sc);
        st.setTitle("Add Product");

        //BUTTON FUNCTIONS
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new ManagerView(manager)).show(st);
                st.show();
            }
        });
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                if (nameF.getText() != null && (r1.isSelected() || r2.isSelected())
                        && dp1.getValue().toString() != null && purchaseField.getText() != null
                        && dp2.getValue().toString() != null
                        && priceField.getText() != null) {

                    ProductRW prod = new ProductRW();

                    if (r1.isSelected()) {
                        prod.addProduct(new model.base.WithoutPerscription(nameF.getText(), new Date(dp1.getValue().toString().replace("-", "/")),
                                Double.parseDouble(purchaseField.getText()), new Date(dp2.getValue().toString().replace("-", "/")),
                                Double.parseDouble(priceField.getText()), Integer.parseInt(stock.getText())));

                        (new ManagerView(manager)).show(st);
                        st.show();
                    } else if (r2.isSelected()) {
                        prod.addProduct(new model.base.WithPerscription(nameF.getText(), new Date(dp1.getValue().toString().replace("-", "/")),
                                Double.parseDouble(purchaseField.getText()), new Date(dp2.getValue().toString().replace("-", "/")),
                                Double.parseDouble(priceField.getText()), Integer.parseInt(stock.getText())));

                        (new ManagerView(manager)).show(st);
                        st.show();
                    }
                }

            }
        });
    }
}
