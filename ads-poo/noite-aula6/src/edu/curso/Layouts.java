package edu.curso;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
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
		// bp.setCenter(lcentro);
		
		BorderPane.setAlignment(ld, Pos.CENTER_RIGHT);
		BorderPane.setAlignment(le, Pos.CENTER_LEFT);
		BorderPane.setAlignment(lc, Pos.TOP_CENTER);
		
		FlowPane flow = new FlowPane();
		flow.setStyle("-fx-background-color:red");
		flow.getChildren().add(new Button("Botão 1"));
		flow.getChildren().add(new Button("Botão 2"));
		flow.setMaxWidth(200);
		
		TilePane grid = new TilePane();
		grid.setPrefColumns(2);
		Label lblNome = new Label("Nome: ");
		TextField txtNome = new TextField();
		
		Label lblTel = new Label("Telefone: ");
		TextField txtTel = new TextField();
		txtTel.setMinWidth(200);
		
//		grid.add(lblNome, 0, 0);
//		grid.add(txtNome, 1, 0);
//		grid.add(lblTel, 0, 1);
//		grid.add(txtTel, 1, 1);
		grid.getChildren().addAll(lblNome, txtNome,lblTel, txtTel);
		
		bp.setCenter(grid);
		
		bp.setBottom(flow);
		
		BorderPane.setAlignment(flow, Pos.BOTTOM_CENTER);
		
		Text txt = new Text("Um carneirinho foi passear, sobre as montanhas e desceu ao mar.");
		txt.setWrappingWidth(100);
		bp.setLeft(txt);
		
		stage.setScene(scn);
		stage.setTitle("Teste de Layouts");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(Layouts.class, args);
	}
}
