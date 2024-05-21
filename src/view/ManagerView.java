package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.base.Employee;
import model.base.Manager;

public class ManagerView {

    private Manager manager;

    public ManagerView(Employee manager) {
        this.manager = (Manager) manager;
    }

    ManagerView() {
    }
    
    public void show(Stage st) {
        
        TextField welcome = new TextField("Welcome to Manager View");
        welcome.setFont(Font.font("Tahoma",
                FontWeight.BOLD, 20));
        welcome.setStyle(" -fx-background-color: beige; -fx-text-fill: green; fx-background-position: center;");
        welcome.setPrefSize(280, 200);
        Button addProd = new Button("Add products");
        addProd.setStyle("-fx-border-color: orange; -fx-border-width: 15px; -fx-background-color: orange; -fx-text-fill: black;");
        Button addStock = new Button("Add stock");
        addStock.setStyle("-fx-border-color: orange; -fx-border-width: 15px; -fx-background-color: orange; -fx-text-fill: black;");
        Button checkPharm = new Button("View Pharmacists");
        checkPharm.setStyle("-fx-border-color: orange; -fx-border-width: 15px; -fx-background-color: orange; -fx-text-fill: black;");
        Button statistics = new Button("Check the Statistics");
        statistics.setStyle("-fx-border-color: orange; -fx-border-width: 15px; -fx-background-color: orange; -fx-text-fill: black;");
        Button suppliers = new Button("Check the Suppliers");
        suppliers.setStyle("-fx-border-color: orange; -fx-border-width: 15px; -fx-background-color: orange; -fx-text-fill: black;");
        Button logout = new Button("Log Out");
        logout.setStyle("-fx-border-color: orange; -fx-border-width: 15px; -fx-background-color: orange; -fx-text-fill: black;");
        Button view = new Button("View Products");
        view.setStyle("-fx-border-color: orange; -fx-border-width: 15px; -fx-background-color: orange; -fx-text-fill: black;");

        VBox vb = new VBox();
        vb.getChildren().addAll(welcome, addProd, view, addStock, checkPharm, statistics, suppliers, logout);
        vb.setSpacing(5);;
        vb.setAlignment(Pos.BASELINE_LEFT);
        vb.setStyle("-fx-background-image: url('resources/images/manager.jpg');"
                + "-fx-background-size: 100% 100%;" + "-fx-background-attachment: fixed;"
                + "fx-background-position: center;");

        addProd.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                (new AddProduct(manager)).show(st);
                st.show();
            }

        });
        addStock.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new Stock()).show(st);
                st.show();
            }
        });
        checkPharm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {

                (new ViewPharmacists()).show(st);
                st.show();
            }
        });

        statistics.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new ViewStatistics()).show(st);
                st.show();
            }
        });

        suppliers.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new ViewSuppliers()).show(st);
                st.show();
            }
        });

        view.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new ViewProducts(manager)).show(st);
                st.show();
            }
        });
        
         logout.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				(new Login()).show(st);
				st.show();
			}
		});
//		
        Scene sc = new Scene(vb, 700, 700);
        st.setScene(sc);
        st.setTitle("Manager View");

    }
}
