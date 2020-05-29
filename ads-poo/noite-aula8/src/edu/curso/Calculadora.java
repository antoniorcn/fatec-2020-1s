package edu.curso;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculadora extends Application {
/*	class BotaoPressionado implements EventHandler<ActionEvent> {
		private TextField display;
		public BotaoPressionado(TextField t) { 
			this.display = t;
		}
		
		public void handle(ActionEvent e) { 
			Button btn = (Button)e.getTarget();
			//System.out.println(btn.getText());
			this.display.setText(display.getText() + btn.getText());
		}
	}
	*/
	
	/*
	private TextField display = new TextField();
	
	class BotaoPressionado implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) { 
			Button btn = (Button)e.getTarget();
			display.setText(display.getText() + btn.getText());
		}
	}
	*/

	@Override
	public void start(Stage stage) throws Exception {
		String botoesNomes[] = {"7", "8", "9", "/",
								"4", "5", "6", "*",
								"1", "2", "3", "-",
								",", "0", "=", "+"};
		VBox root = new VBox();
		Scene scn = new Scene(root, 90, 150);
		
		TextField display = new TextField();	
		
		display.setAlignment(Pos.CENTER_RIGHT);
		
		// BotaoPressionado eventButtonPressed = new BotaoPressionado(display);
		
		// BotaoPressionado eventButtonPressed = new BotaoPressionado();
		TilePane botoes = new TilePane();
		botoes.setPrefColumns(4);
		for (int i = 0; i < botoesNomes.length; i++) { 
			Button btn = new Button(botoesNomes[i]);
			//btn.addEventFilter(ActionEvent.ACTION, eventButtonPressed);
			
			/* btn.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) { 
					display.setText(display.getText() + btn.getText());
				}
			});
			*/
			
			/*
			btn.addEventFilter(ActionEvent.ACTION, (e) -> {
				display.setText(display.getText() + btn.getText());
			});
			*/
			
			btn.setOnAction(
				(e) -> { 
					display.setText(display.getText() + btn.getText());
				}
			);
			
			
			botoes.getChildren().add(btn);
		}
		root.getChildren().addAll(display, botoes);
		stage.setScene(scn);
		stage.setTitle("Calculadora");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(Calculadora.class, args);
	}

}
