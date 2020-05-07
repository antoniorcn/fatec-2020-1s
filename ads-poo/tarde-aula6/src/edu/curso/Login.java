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
		Pane p = new Pane();
		Scene scn = new Scene(p, 600, 400);
		Label lblTitulo = new Label("Login no Sistema");
		// lblTitulo.setStyle("-fx-font-size: 36");
		Font font = new Font(36);
		lblTitulo.setFont(font);
		// double x = (600 - lblTitulo.getWidth()) / 2;
		Label lblUser = new Label("User ID:");
		Label lblPassword = new Label("Password:");
		TextField txtUser = new TextField();
		TextField txtPassword = new TextField();
		Button btnLogin = new Button("Login");
		Button btnReg = new Button("Registration");
		p.getChildren().addAll(lblTitulo, lblUser, lblPassword, 
				txtUser, txtPassword, btnLogin, btnReg);
		lblTitulo.relocate(150,  40);
		lblUser.relocate(100, 120);
		lblPassword.relocate(100, 200);
		txtUser.relocate(200, 120);
		txtPassword.relocate(200, 200);
		btnLogin.relocate(100, 280);
		btnReg.relocate(260, 280);
		// p.getChildren().add(new Label("Password:"));
		stage.setScene(scn);
		stage.setTitle("Login no Sistema");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(Login.class, args);
	}
}
