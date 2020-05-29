package edu.curso;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TesteEvento extends Application {
	class Interceptador implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) { 
			Button b = (Button) e.getTarget();
			System.out.println(b.getText());
		}
	}
	@Override
	public void start(Stage stage) throws Exception {
		FlowPane pan = new FlowPane();
		Scene scn = new Scene(pan, 300, 200);
		stage.setScene(scn);
		
		Interceptador intercept = new Interceptador();
		
		Label lblTexto = new Label("Você pode clicar aqui");
		Button btnOk = new Button("9");
		
		stage.addEventFilter(ActionEvent.ACTION, intercept);
		
		pan.getChildren().addAll(lblTexto, btnOk);
		
		stage.setTitle("Teste de Eventos");
		stage.show();
	}
	public static void main(String[] args) {
		Application.launch(TesteEvento.class, args);
	}
}