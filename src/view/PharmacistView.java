package view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.RW.BillRW;
import model.base.Employee;
import model.base.Pharmacist;

public class PharmacistView {

    private Employee pharm;

    public PharmacistView(Employee pharm) {
        this.pharm = pharm;
    }

    public PharmacistView() {
        super();
    }
    public void show(Stage st) {

        Button go = new Button("Go to create a bill");
        Button back = new Button("Return");

        VBox v1 = new VBox();
        v1.getChildren().addAll(go, back);
        v1.setSpacing(7);
        v1.setAlignment(Pos.CENTER);

        Scene sc = new Scene(v1, 700, 700);
        st.setScene(sc);
        st.setTitle("Pharmacist View");
        st.show();
//
//        button functions

        go.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new BillView()).show(st);
                st.show();
            }
        });

        back.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				(new Login()).show(st);
				st.show();
			}
		});
    }
}
