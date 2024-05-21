/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
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
import model.base.Date;
import model.base.Employee;

/**
 *
 * @author anisl
 */
public class EditManager {
      private Employee admin;
    private ArrayList<Employee> emp;
    
    public EditManager(Employee admin) {
        this.admin = admin;
    }
   
     public void show(Stage st){
       Label username = new Label("Username: ");
		Label password = new Label("Password: ");
                
		TextField userField = new TextField();
		TextField passField = new TextField();
                
		HBox bx1=new HBox();
		bx1.getChildren().addAll(username,userField);
		bx1.setSpacing(5);
		bx1.setAlignment(Pos.CENTER);
                
		HBox bx2=new HBox();
		bx2.getChildren().addAll(password,passField);
		bx2.setSpacing(5);
		bx2.setAlignment(Pos.CENTER);
  
               
		Label emer = new Label("Name: ");
		Label mbiemer = new Label("Surname: ");
                
		TextField name = new TextField();
		TextField surname = new TextField();
                
		HBox bx4=new HBox();
		bx4.getChildren().addAll(emer,name);
		bx4.setSpacing(5);
		bx4.setAlignment(Pos.CENTER);
                
		HBox bx5=new HBox();
		bx5.getChildren().addAll(mbiemer,surname);
		bx5.setSpacing(5);
		bx5.setAlignment(Pos.CENTER);
                
                
		DatePicker dp=new DatePicker();
		Label date=new Label("Birthday:");
                
		HBox bx6=new HBox();
		bx6.getChildren().addAll(date,dp);
		bx6.setSpacing(5);
		bx6.setAlignment(Pos.CENTER);
                
                TextField phoneField = new TextField();
                TextField emailField = new TextField();
                TextField salaryField = new TextField();
                
                Label phone = new Label("Phone number: ");
                Label email = new Label("E-mail : ");
                Label salary = new Label("Salary : ");
                
                HBox bx8=new HBox();
		bx8.getChildren().addAll(phone,phoneField);
		bx8.setSpacing(5);
		bx8.setAlignment(Pos.CENTER);
                
                HBox bx9=new HBox();
		bx9.getChildren().addAll(email,emailField);
		bx9.setSpacing(5);
		bx9.setAlignment(Pos.CENTER);
                
                HBox bx10=new HBox();
		bx10.getChildren().addAll(salary,salaryField);
		bx10.setSpacing(5);
		bx10.setAlignment(Pos.CENTER);
                
            
		Button update =new Button("Update");
		Button back=new Button("Back");
                
		HBox bx7=new HBox();
		bx7.getChildren().addAll(update,back);
		bx7.setSpacing(5);
		bx7.setAlignment(Pos.CENTER);
                
		VBox vb=new VBox();
		vb.getChildren().addAll(bx1,bx2,bx4,bx5,bx6,bx8,bx9,bx10, bx7);
		vb.setSpacing(5);
		vb.setAlignment(Pos.CENTER);
//                
		Scene sc=new Scene(vb,300,400);
		st.setScene(sc);
		st.setTitle("Update Manager");

                
                //button functions
                
                
		back.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				(new AdminView(admin)).show(st);
				st.show();
			}
		});
                
                update.setOnAction(new EventHandler<ActionEvent>(){
                    @Override 
                    public void handle(ActionEvent args0){
                        for(Employee e: emp){
                            
                        e.setUsername(userField.getText());
                        e.setPassword(passField.getText());
                        e.setName(name.getText());
                        e.setSurname(surname.getText());
                        e.setBdt(new Date(dp.getValue().toString()));
                        e.setEmail(emailField.getText());
                        e.setPhoneNumber(phoneField.getText());
                        e.setSalary(salaryField.getText());
                    
                        }
                     (new AdminView(admin)).show(st);
					st.show();
                }});
     }
}
