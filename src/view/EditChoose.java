package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.base.Employee;
import view.EditManager;
import view.EditPharmacist;

public class EditChoose {

    private Employee admin;

    public EditChoose(Employee admin) {
        this.admin = admin;
    }

    public void show(Stage st) {

        Button pharmacist = new Button("Edit pharmacist");
        pharmacist.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: green;");
        Button manager = new Button("Edit manager");
        manager.setStyle("-fx-border-color: blue; -fx-border-width: 5px; -fx-background-color: white; -fx-text-fill: blue;");
        Button back = new Button("Return to AdminView");
        back.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: green;");

        VBox vb = new VBox();
        vb.getChildren().addAll(pharmacist, manager, back);
        vb.setSpacing(5);
        vb.setAlignment(Pos.CENTER);
        vb.setStyle("-fx-background-image: url('resources/images/CHOOSE.jpeg');"
                + "-fx-background-size: 100% 100%;" + "-fx-background-attachment: fixed;"
                + "fx-background-position: center;");
       

        Scene sc = new Scene(vb, 400, 400);
        st.setTitle("Edit Employees");
        st.setScene(sc);
        st.show();

        //BUTTON FUNCTIONS
        
        pharmacist.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent args0) {

                (new EditPharmacist(admin)).show(st);
                st.show();
            }
        });
        manager.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent args0) {

                (new EditManager(admin)).show(st);
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
