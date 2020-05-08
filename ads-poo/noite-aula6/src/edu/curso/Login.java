package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Pane pan = new Pane();
		Scene scn = new Scene(pan, 600, 400);
	
		Label lblLogin = new Label("Login no Sistema");
		lblLogin.relocate(100, 40);
		// lblLogin.setStyle("-fx-font-size: 30");
		Font fnt = new Font(30);
		lblLogin.setFont(fnt);
		
		Label lblUser = new Label("User ID:");
		lblUser.relocate(100, 120);
		
		TextField txtUser = new TextField();
		txtUser.relocate(175, 120);
		
		Label lblPassword = new Label("Password:");
		lblPassword.relocate(100, 200);
		
		TextField txtPassword = new TextField();
		txtPassword.relocate(175, 200);
		
		Button btnLogin = new Button("Login");
		btnLogin.relocate(100, 280);
		
		Button btnRegistration = new Button("Registration");
		btnRegistration.relocate(250, 280);
		
		pan.getChildren().addAll(lblLogin, lblUser, lblPassword, 
				txtUser, txtPassword, btnLogin, btnRegistration);

		stage.setTitle("Formulário de Login");
		stage.setScene(scn);
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(Login.class, args);
	}
}
