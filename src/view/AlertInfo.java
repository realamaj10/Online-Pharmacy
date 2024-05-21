package view;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AlertInfo {

    private String msg = "";

    public AlertInfo(String msg) {
        this.msg = msg;

        Stage st2 = new Stage();

        Text tx = new Text(msg);

        StackPane sp = new StackPane();
        sp.getChildren().add(tx);
        sp.setStyle("-fx-background-color:red; -fx-text-fill:white;");

        Scene sc = new Scene(sp);

        st2.setScene(sc);
        st2.setTitle("THIS IS AN ALERT!!");
        st2.show();
    }

}
