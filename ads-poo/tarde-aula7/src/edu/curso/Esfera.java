package edu.curso;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Esfera extends Application {
	@Override
	public void start(Stage stage) throws Exception { 
		Group grp = new Group();
		Scene scn = new Scene(grp, 600, 400);
		stage.setScene(scn);
		
		Canvas canvas = new Canvas(600, 400);
		grp.getChildren().add(canvas);
		
		GraphicsContext ctx = canvas.getGraphicsContext2D();
		ctx.setStroke(Color.BLACK);
		for (double raiox = 0; raiox < 50; raiox += 5) {
			ctx.beginPath();
			ctx.arc(300, 200, raiox, 50, 0, 360);
			ctx.stroke();	
		}
		for (double raioy = 0; raioy < 50; raioy += 5) {
			ctx.beginPath();
			ctx.arc(300, 200, 45, raioy, 0, 360);
			ctx.stroke();	
		}

		stage.setTitle("Bolinha");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(Esfera.class, args);
	}

}
