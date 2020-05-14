package edu.curso;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TesteBotao extends Application {
	
	class ManipuladorBotao implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			System.out.println("Botão apertado...");
		}	
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FlowPane p = new FlowPane();
		Scene scn = new Scene(p, 300, 200);
		
		Button btn = new Button("Me aperte");
		Button btn2 = new Button("Me aperte 2");
		p.getChildren().add(new Label("Aperte o botao"));
		p.getChildren().addAll(btn, btn2);
		
		// ManipuladorBotao man = new ManipuladorBotao();
		// btn.addEventFilter(ActionEvent.ANY, man);
		// btn2.addEventFilter(ActionEvent.ANY, man);
		
		btn.setOnAction((e) -> { 
			System.out.println("Botão pressionado pelo lambda");
		});
		
		primaryStage.setScene(scn);
		
		primaryStage.setTitle("Teste pressionamento de Botão");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(TesteBotao.class, args);
	}
}
