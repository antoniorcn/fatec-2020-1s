package edu.curso;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class Desenho extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Group grp = new Group();
		Scene scn = new Scene(grp, 640, 480);
		Canvas canvas = new Canvas(640, 480);
		grp.getChildren().add(canvas);
		primaryStage.setScene(scn);
		GraphicsContext ctx = canvas.getGraphicsContext2D();
		ctx.setStroke(Color.RED);
		ctx.beginPath();
		ctx.moveTo(320, 240);
		ctx.lineTo(640, 0);
		ctx.rect(50, 50, 200, 100);
		ctx.stroke();
		ctx.setStroke(Color.BLUE);
		ctx.beginPath();
		for (double altura = 0; altura < 100; altura += 10) {
			double y = 100 - (altura / 2);
			ctx.strokeOval(50, y, 200, altura);
		}
		ctx.stroke();
		primaryStage.setTitle("Desenho");
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(Desenho.class, args);
	}	
}
