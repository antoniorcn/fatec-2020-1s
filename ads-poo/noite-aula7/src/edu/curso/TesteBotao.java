package edu.curso;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TesteBotao extends Application {
	class Executa implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			System.out.println("Apertado: " + event.getTarget());
		} 		
	}
	
	class ExecutaMouse implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			System.out.println("Mouse Clicado: " + event.getTarget());
		} 		
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		FlowPane pan = new FlowPane();
		Scene scn = new Scene(pan, 300, 200);
		stage.setScene(scn);
		
		Label lblTexto = new Label("Clique aqui");
		Button btnOk = new Button("Ok");
		
		Executa exe = new Executa();
		ExecutaMouse exeMouse = new ExecutaMouse();
		btnOk.addEventFilter(ActionEvent.ANY, exe);
		lblTexto.addEventFilter(MouseEvent.MOUSE_PRESSED, exeMouse);
		
		pan.getChildren().addAll(lblTexto, btnOk);
		
		stage.setTitle("Teste de Botão");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(TesteBotao.class, args);
	}
}
