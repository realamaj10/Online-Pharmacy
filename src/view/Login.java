package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.RW.UserRW;
import model.base.Employee;
import model.base.Type;

public class Login {

    public void show(Stage st) {

        Text[] err = new Text[2];
        err[0] = new Text("> 2 characters!!!");
        err[1] = new Text("> 2 characters!!!");
        for (int i = 0; i < err.length; i++) {
            err[i].setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 12));
            err[i].setFill(Color.RED);
            err[i].setVisible(false);
        }
        TextField welcome = new TextField("Welcome to our Pharmacy Management System");
        welcome.setFont(Font.font("Tahoma",
                FontWeight.NORMAL, 20));
        welcome.setStyle("-fx-text-inner-color: green; -fx-background-color: beige; -fx-text-fill: green;");
        welcome.setPrefWidth(450);

        Label us = new Label("Username");
        us.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        us.setTextFill(Color.GREEN);
        Label pa = new Label("Password");
        pa.setFont(Font.font("Book Antiqua",
                FontWeight.BOLD, 16));
        pa.setTextFill(Color.GREEN);

        TextField user = new TextField();
        user.setPromptText("Enter name");
        user.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if (user.getText().length() < 2) {
                    err[0].setVisible(true);
                } else {
                    err[0].setVisible(false);
                }

            }
        });

        PasswordField pass = new PasswordField();
        pass.setPromptText("Enter surname");
        pass.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event1) {
                if (pass.getText().length() < 2) {
                    err[1].setVisible(true);
                } else {
                    err[1].setVisible(false);
                }

            }
        });

        Button login = new Button("Login");
        login.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: green;");
        Button cancel = new Button("Cancel");
        cancel.setStyle("-fx-border-color: green; -fx-border-width: 5px; -fx-background-color: beige; -fx-text-fill: green;");

        HBox hb1 = new HBox(us, user, err[0]);
        hb1.setPadding(new Insets(5, 5, 5, 5));
        hb1.setAlignment(Pos.CENTER);
        
        HBox hb2 = new HBox(pa, pass, err[1]);
        hb2.setPadding(new Insets(5, 5, 5, 5));
        hb2.setAlignment(Pos.CENTER);
        
        HBox hb3 = new HBox(login, cancel);
        hb3.setPadding(new Insets(5, 5, 5, 5));
        HBox.setMargin(login, new Insets(0, 10, 0, 0));
        hb3.setAlignment(Pos.CENTER);

        GridPane mainPane = new GridPane();
        welcome.setId("welcome-text");
        welcome.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        mainPane.addColumn(0, welcome, hb1 , hb2, hb3);
        mainPane.setId("actiontarget");
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setStyle("-fx-background-image: url('https://www.theglobeandmail.com/resizer/xE2DsbP0TZxaDfepyw7pJ4Rmd2s=/1200x0/filters:quality(80)/arc-anglerfish-tgam-prod-tgam.s3.amazonaws.com/public/VCUGUEABORH6LAGMBJMPKZJQA4');"
                + "-fx-background-size: 100% 100%;" + "-fx-background-attachment: fixed;"
                + "fx-background-position: center;");
        Scene scene = new Scene(mainPane, 700, 600);
        st.setTitle("Login");
        st.setScene(scene);

        //BUTTON FUNCTIONS
        
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                System.exit(0);
            }
        });

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                UserRW us = new UserRW();
                if (user.getText().isEmpty() || pass.getText().isEmpty()) {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("CAREFUL!!!");
                    alert.setContentText("Enter Data in Username and Password!!");

                    DialogPane dP = alert.getDialogPane();
                    dP.setStyle("-fx-background-color: beige;");
                    dP.getStyleClass().remove("alert");
                    GridPane grid = (GridPane) dP.lookup(".header-panel");
                    grid.setStyle("-fx-background-color: red; "
                            + "-fx-font-style: italic;"
                            + "-fx-text-fill: green");
                    alert.showAndWait();
                    
                } else {
                    Employee emp = us.checkUser(user.getText(), pass.getText());

                    if (emp == null) {
                        Alert alert = new Alert(AlertType.WARNING);
                        alert.setTitle("Warning Dialog");
                        alert.setHeaderText("CAREFUL!!!");
                        alert.setContentText("User and Password do not match!!");

                        DialogPane dP = alert.getDialogPane();
                        dP.setStyle("-fx-background-color: beige;");
                        dP.getStyleClass().remove("alert");
                        GridPane grid = (GridPane) dP.lookup(".header-panel");
                        grid.setStyle("-fx-background-color: red; "
                                + "-fx-font-style: italic;"
                                + "-fx-text-fill: green");
                        alert.showAndWait();

                    } else {
                        if (emp.getType().equals(Type.Administrator)) {
                            (new AdminView(emp)).show(st);
                        } else if (emp.getType().equals(Type.Pharmacist)) {
                            (new PharmacistView(emp)).show(st);
                        } else if (emp.getType().equals(Type.Manager)) {
                            (new ManagerView(emp)).show(st);
                        }
                    }
                }
            }
        });
        
        //BUTTON FUNCTIONS
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                System.exit(0);
            }
        });

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                UserRW us = new UserRW();
                if (user.getText().isEmpty() || pass.getText().isEmpty()) {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("CAREFUL!!!");
                    alert.setContentText("Enter Data in Username and Password!!");

                    DialogPane dP = alert.getDialogPane();
                    dP.setStyle("-fx-background-color: beige;");
                    dP.getStyleClass().remove("alert");
                    GridPane grid = (GridPane) dP.lookup(".header-panel");
                    grid.setStyle("-fx-background-color: red; "
                            + "-fx-font-style: italic;"
                            + "-fx-text-fill: green");
                    alert.showAndWait();

                } else {
                    Employee emp = us.checkUser(user.getText(), pass.getText());

                    if (emp == null) {
                        Alert alert = new Alert(AlertType.WARNING);
                        alert.setTitle("Warning Dialog");
                        alert.setHeaderText("CAREFUL!!!");
                        alert.setContentText("User and Password do not match!!");

                        DialogPane dP = alert.getDialogPane();
                        dP.setStyle("-fx-background-color: beige;");
                        dP.getStyleClass().remove("alert");
                        GridPane grid = (GridPane) dP.lookup(".header-panel");
                        grid.setStyle("-fx-background-color: red; "
                                + "-fx-font-style: italic;"
                                + "-fx-text-fill: green");
                        alert.showAndWait();

                    } else {
                        if (emp.getType().equals(Type.Administrator)) {
                            (new AdminView(emp)).show(st);
                        } else if (emp.getType().equals(Type.Pharmacist)) {
                            (new PharmacistView(emp)).show(st);
                        } else if (emp.getType().equals(Type.Manager)) {
                            (new ManagerView(emp)).show(st);
                        }
                    }
                }
            }
        });

    }

}
