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
import model.RW.UserRW;
import model.base.Employee;

public class ViewPharmacists {

    private Employee manager;

    public ViewPharmacists(Employee manager) {
        this.manager = manager;
    }

    public ViewPharmacists() {
    }

    public void show(Stage st) {

       // UserRW rw = new UserRW();// A DUHET NJE PHARMACISTRW?

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
        st.setScene(sc);
        st.setTitle("View Users");
        st.show();

//        for (Employee x : rw.readEmployee()) {
//            vb.getChildren().add(new Text(x.toString() + " and username is: "
//                    + x.getUsername() + " and password is: " + x.getPassword()));
//        }

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new ManagerView(manager)).show(st);
                st.show();
            }
        });

    }

}
