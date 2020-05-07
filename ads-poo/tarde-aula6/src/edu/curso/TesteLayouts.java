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
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class TesteLayouts extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		BorderPane bp = new BorderPane();
		Scene scn = new Scene(bp, 600, 400);
		
		Label lbl = new Label("Hello World");
		
		// FlowPane fp = new FlowPane();
		// fp.getChildren().add(lbl);
		// fp.setAlignment(Pos.BASELINE_CENTER);
		
		Label txt = new Label("Ola");
		txt.setStyle("-fx-background-color:blue");
		
		Button btnOk = new Button("Ok");
		Button btnCancel = new Button("Cancel");
		
		GridPane grid2 = new GridPane();
		// grid.setStyle("-fx-background-color: red");
		grid2.add(new Label("Nome: "), 0, 0, 2, 1);
		grid2.add(new Label("col0"), 0, 1);
		grid2.add(new Label("col1"), 1, 1);
		grid2.add(new Label("col2"), 2, 1);
		grid2.add(new Label("col3"), 3, 1);
		grid2.add(new Label("col4"), 4, 1);
		grid2.add(new Label("col5"), 5, 1);
		grid2.add(new Label("col6"), 6, 1);
		grid2.add(new TextField(), 2, 0, 4, 1);
		
		
		GridPane grid = new GridPane();
		// grid.setStyle("-fx-background-color: red");
		grid.add(btnOk, 0, 0);
		grid.add(btnCancel, 0, 1);
		grid.setMaxHeight(100);
		
		bp.setBottom(lbl);
		bp.setRight(grid);
		bp.setLeft(txt);
		bp.setCenter(grid2);

		
		// fp.setStyle("-fx-background-color:blue; -fx-left:50%");
		BorderPane.setAlignment(grid, Pos.CENTER_RIGHT);


		stage.setScene(scn);
		stage.show();
		stage.setTitle("Janela principal");
	}
	public static void main(String[] args) {
		Application.launch(TesteLayouts.class, args);
	}
}
