package view;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.RW.UserRW;
import model.base.Date;
import model.base.Employee;

public class DeleteUser {

    private Employee admin;
    private ArrayList<Employee> emp;

    public DeleteUser(Employee admin) {
        this.admin = admin;
    }

    public void show(Stage st) {
        UserRW rw = new UserRW();

        Label delLabel = new Label("Delete user with username: ");
        TextField delUsername = new TextField();

        Button delete = new Button("Delete user");
        Button back = new Button("Return");

        HBox hb = new HBox();
        hb.getChildren().addAll(delLabel, delUsername, delete);
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(5);

        HBox hb1 = new HBox();
        hb.getChildren().addAll(back);
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(5);

        VBox vb = new VBox();
        vb.getChildren().addAll(hb, hb1);
        vb.setAlignment(Pos.CENTER);

        for (Employee x : rw.readEmployee()) {
            vb.getChildren().add(new Text(x.toString() + "|"
                    + x.getUsername() + "|" + x.getPassword()));
        }
        Scene sc = new Scene(vb, 400, 400);
        st.setScene(sc);
        st.show();

        //button functions
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
//                            			Iterator<Employee> itr = emp.iterator();
//                    while(itr.hasNext()) {
//			Employee x = itr.next();
//			if(delUsername.getText().equals(x.getName()))
//				itr.remove();
//			}
//		
//                                
//                            
//                             (new AdminView(admin)).show(st);
//                        st.show();
//                        }           

                Iterator itr = rw.readEmployee().iterator();
                while (itr.hasNext()) {
                    Employee e = (Employee) itr.next();
                    if (delUsername.getText().equals(e.getUsername())) {
                        itr.remove();
                    }
                }
                (new AdminView(admin)).show(st);
                st.show();
            }

        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent args0) {
                (new AdminView(admin)).show(st);
                st.show();
            }
        });

    }
}
