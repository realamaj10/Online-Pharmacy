package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.base.Employee;

public class AdminView {

    private Employee admin;

    public AdminView(Employee admin) {
        this.admin = admin;
    }

    public void show(Stage st) {

        TextField welcome = new TextField("Welcome to Admin View");
        welcome.setFont(Font.font("Tahoma",
                FontWeight.BOLD, 20));
        welcome.setStyle(" -fx-background-color: beige; -fx-text-fill: green; fx-background-position: center;");
        welcome.setPrefSize(280, 200);
        
        Button view = new Button("View existing users");
        view.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: green;");
        Button reg = new Button("Register a new user");
        reg.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: green;");
        Button edit = new Button("Edit users");
        edit.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: green;");
        Button del = new Button("Delete users");
        del.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: green;");
        Button out = new Button("Log Out");
        out.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: green;");

        GridPane gp = new GridPane();
        gp.setHgap(20);
        gp.setVgap(20);
        gp.setPadding(new Insets(5, 5, 5, 5));
        gp.setAlignment(Pos.CENTER);
        VBox vb = new VBox(welcome, view, reg, edit, del, out);
        vb.setSpacing(5);
        vb.setAlignment(Pos.CENTER);

        GridPane mainPane = new GridPane();
        welcome.setId("welcome-text");
        mainPane.addRow(0, vb);
        mainPane.setId("actiontarget");
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setStyle("-fx-background-image: url('resources/images/administrator.jpg');"
                + "-fx-background-size: 100% 100%;" + "-fx-background-attachment: fixed;"
                + "fx-background-position: center;");
       
		reg.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				(new RegisterChoose(admin)).show(st);
				st.show();
			}
			
		});
		edit.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				(new EditChoose(admin)).show(st);
				st.show();
			}
			
		});
               
                
		del.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				(new DeleteUser(admin)).show(st);
				st.show();
			}
		});
		view.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				(new ViewUsers()).show(st);
				st.show();
			}
		});
                out.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				(new Login()).show(st);
				st.show();
			}
		});
        Scene sc = new Scene(mainPane, 300, 150);
        st.setScene(sc);
        st.setTitle("Admin View");

    }

}
