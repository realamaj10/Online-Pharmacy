package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.base.Employee;

public class RegisterChoose {

    private Employee admin;

    public RegisterChoose(Employee admin) {
        this.admin = admin;
    }

    public void show(Stage st) {
        
        Button pharm = new Button("Register new pharmacist");
        pharm.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: green;");
        Button manager = new Button("Register new manager");
        manager.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: green;");
        Button back = new Button("Return to Admin View");
        back.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: green;");

        VBox vb = new VBox();
        vb.getChildren().addAll(pharm, manager, back);
        vb.setSpacing(5);
        vb.setAlignment(Pos.CENTER);
                vb.setStyle("-fx-background-image: url('resources/images/CHOOSE.jpeg');"
                + "-fx-background-size: 100% 100%;" + "-fx-background-attachment: fixed;"
                + "fx-background-position: center;");

        Scene sc = new Scene(vb, 400, 400);
        st.setTitle("Register Employee");
        st.setScene(sc);
        st.show();

        //BUTTON FUNCTIONS
        pharm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent args0) {

                (new RegisterPharmacist(admin)).show(st);
                st.show();
            }
        });
        manager.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent args0) {

                (new RegisterManager(admin)).show(st);
                st.show();
            }
        });
        
        back.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				(new AdminView(admin)).show(st);
				st.show();
			}
		});

    }
}
