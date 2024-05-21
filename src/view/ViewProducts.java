package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.RW.ProductRW;
import model.base.Employee;
import model.base.Product;

public class ViewProducts {

    private Employee manager;

    public ViewProducts(Employee manager) {
        manager = manager;
    }

    public ViewProducts() {
        super();
    }

    public void show(Stage st) {

        ProductRW rw = new ProductRW();

        Button back = new Button("Return");
        back.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: green;");

        VBox vb = new VBox();
        vb.getChildren().add(back);
        vb.setAlignment(Pos.CENTER);
        GridPane gp = new GridPane();
        gp.setHgap(20);
        gp.setVgap(20);
        gp.setPadding(new Insets(5, 5, 5, 5));
        gp.setAlignment(Pos.CENTER);

        GridPane mainPane = new GridPane();
        mainPane.addRow(0, vb);
        mainPane.setId("actiontarget");
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setStyle("-fx-background-color: beige;"
                + "-fx-background-size: 100% 100%;" + "-fx-background-attachment: fixed;"
                + "fx-background-position: center;");

        Scene sc = new Scene(mainPane, 400, 400);
        st.setTitle("View Products");
        st.setScene(sc);
        st.show();

        for (Product x : rw.readProduct()) {
            vb.getChildren().add(new Text(x.toString() + " and name is: "
                    + x.getName() + " and purchase price is: " + x.getPurchasePrice()
                    + " and expiry date is: " + x.getExpiryDate()
                    + " and price is: " + x.getPrice()));
        }

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new ManagerView(manager)).show(st);
                st.show();
            }
        });

    }

}
