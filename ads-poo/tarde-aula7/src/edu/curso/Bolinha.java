package edu.curso;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Bolinha extends Application {
	
	class Ponto { 
		double x = 0;
		double y = 0;
		double velX = 1;
	}
	
	public void start(Stage stage) { 
		Group grp = new Group();
		Scene scn = new Scene(grp, 640, 480);
		stage.setScene(scn);
		Canvas canvas = new Canvas(640, 480);
		GraphicsContext ctx = canvas.getGraphicsContext2D();
		
		grp.getChildren().add(canvas);
		final Ponto p = new Ponto();
		new AnimationTimer() { 
			public void handle(long now) {
				ctx.clearRect(0,  0, 640, 480);
				ctx.setStroke(Color.BLACK);
				ctx.setFill(Color.BLACK);
				ctx.beginPath();
				ctx.fillOval(p.x, p.y, 20, 20);
				ctx.stroke();
				
				p.x += p.velX;
				
				if (p.x > canvas.getWidth()) { 
					 p.velX =-1;
				}
			}
		}.start();
		stage.setTitle("Bolinha");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(Bolinha.class, args);
	}

}
