package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HelloFX extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Pane pan = new Pane();
		Scene scn = new Scene(pan, 600, 400);
		Button btnOk = new Button("Ok");
		Label lblWelcome = new Label("Bem vindo ao java Fx");
		TextField txt = new TextField();
		pan.getChildren().add(lblWelcome);
		pan.getChildren().add(btnOk);
		pan.getChildren().add(txt);
		double x = (600 - btnOk.getWidth()) / 2;
		double y = (400 - btnOk.getHeight()) / 2;
		txt.relocate(100, 100);
		btnOk.relocate(x, y);
		stage.setScene(scn);
		stage.show();
		System.out.println(pan.getHeight());
	}
	
	public static void main(String[] args) {
		Application.launch(HelloFX.class, args);
	}
}
