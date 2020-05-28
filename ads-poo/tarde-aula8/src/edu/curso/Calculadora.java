package edu.curso;

import edu.curso.TesteEventos.CapturaEvento;
import edu.curso.TesteEventos.CapturaTecla;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculadora extends Application {
	private String[] botoes = {"7", "8", "9", "/", 
								"4", "5", "6", "*",
								"1", "2", "3", "+",
								",", "0","=", "-"};
	
//	class ButtonClick implements EventHandler<ActionEvent> {
//	private TextField dsp;
//	public ButtonClick(TextField t) { 
//		dsp = t;
//	}
//	
//	@Override
//	public void handle(ActionEvent e) {
//		Button btn = (Button) e.getTarget();
//		dsp.setText(dsp.getText() + btn.getText());
//	} 
//}
	
//	private TextField display = new TextField();
//	class ButtonClick implements EventHandler<ActionEvent> {
//		@Override
//		public void handle(ActionEvent e) {
//			Button btn = (Button) e.getTarget();
//			display.setText(display.getText() + btn.getText());
//		} 
//	}
	
	public void start(Stage stg) { 
		FlowPane root = new FlowPane();
		GridPane panBotoes = new GridPane();
		Scene scn = new Scene(root, 800, 600);
		stg.setScene(scn);
		
//		TextField display = new TextField();
//		ButtonClick evtClick = new ButtonClick(display);
		
		TextField display = new TextField();
//		ButtonClick evtClick = new ButtonClick();
		for (int i = 0; i < botoes.length; i++) { 
			int lin = i / 4;
			int col = i % 4;
			Button btn = new Button(botoes[i]);
			// btn.addEventFilter(ActionEvent.ANY, evtClick);
			
			
//			btn.addEventFilter(ActionEvent.ANY, new EventHandler<ActionEvent>() {
//				public void handle(ActionEvent e) {
//					display.setText(display.getText() + btn.getText());
//				} 
//			});
			
//			btn.addEventFilter(ActionEvent.ANY, 
//				(e) -> {
//					display.setText(display.getText() + btn.getText());
//				}
//			);
			
			btn.setOnAction((e) -> { 
				display.setText(display.getText() + btn.getText());
			});
			
			panBotoes.add(btn, col, lin);
		}
		
		root.getChildren().addAll(display, panBotoes);
		
		stg.setTitle("Calculadora");
		stg.show();
	}
	
	public static void main(String[] args) {
		Application.launch(Calculadora.class, args);
	}

}
