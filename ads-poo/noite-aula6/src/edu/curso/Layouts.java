package edu.curso;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Layouts extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		BorderPane bp = new BorderPane();
		Scene scn = new Scene(bp, 600, 400);
		
		Label ld = new Label("Direita");
		Label le = new Label("Esquerda");
		Label lc = new Label("Cima");
		Label lb = new Label("Baixo");
		Label lcentro = new Label("Centro");
		bp.setRight(ld);
		bp.setLeft(le);
		bp.setTop(lc);
		// bp.setBottom(lb);
		bp.setCenter(lcentro);
		
		BorderPane.setAlignment(ld, Pos.CENTER_RIGHT);
		BorderPane.setAlignment(le, Pos.CENTER_LEFT);
		BorderPane.setAlignment(lc, Pos.TOP_CENTER);
		
		FlowPane flow = new FlowPane();
		flow.setStyle("-fx-background-color:red");
		flow.getChildren().add(new Button("Botão 1"));
		flow.getChildren().add(new Button("Botão 2"));
		flow.setMaxWidth(200);
		
		bp.setBottom(flow);
		
		BorderPane.setAlignment(flow, Pos.BOTTOM_CENTER);
		
		
		stage.setScene(scn);
		stage.setTitle("Teste de Layouts");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(Layouts.class, args);
	}
}
