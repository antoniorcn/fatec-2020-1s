package edu.curso;


import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TesteEventos extends Application {
	class CapturaEvento implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent e) {
//			System.out.printf("Tipo: %s\n", e.getEventType().getName());
//			System.out.printf("Target: %s\n", e.getTarget());
//			System.out.printf("Source: %s\n", e.getSource());
			System.out.printf("X: %6.2f  Y: %6.2f\n", e.getX(), e.getY());
		} 
	}
	
	class CapturaTecla implements EventHandler<KeyEvent> {
		@Override
		public void handle(KeyEvent e) {
			System.out.printf("Tecla: %s\n", e.getCode().getName());
			e.consume();
		} 
	}
	
	public void start(Stage stg) { 
		FlowPane root = new FlowPane();
		Scene scn = new Scene(root, 800, 600);
		stg.setScene(scn);
		
		CapturaEvento cp = new CapturaEvento();
		CapturaTecla ct = new CapturaTecla();
		Button btn = new Button("Aperte me");
		Label lbl = new Label("Pode apertar este label também");
		
		root.getChildren().addAll(btn, lbl);
		
		// stg.addEventFilter(MouseEvent.MOUSE_MOVED, cp);
		stg.addEventFilter(KeyEvent.KEY_PRESSED, ct);
		root.addEventFilter(KeyEvent.KEY_PRESSED,  ct);
		
		stg.setTitle("Teste de Eventos");
		stg.show();
	}

	public static void main(String[] args) {
		Application.launch(TesteEventos.class, args);
	}
}
