package edu.curso;

import java.awt.BasicStroke;
import java.awt.Stroke;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class Bolinha extends Application {
	class Ponto { 
		double x;
		double y;
		double velX = 1;
		double velY;
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		Group grp = new Group();
		Scene scn = new Scene(grp);
		primaryStage.setScene(scn);
		
		Canvas canvas = new Canvas(640, 480);
		GraphicsContext ctx = canvas.getGraphicsContext2D();
		grp.getChildren().add(canvas);
		final Ponto p = new Ponto();
		new AnimationTimer() {
			@Override
			public void handle(long now) {
				ctx.clearRect(0,  0, canvas.getWidth(),  canvas.getHeight());
				ctx.setStroke(Color.DARKBLUE);
				ctx.setFill(Color.BLUE);
				ctx.beginPath();
				ctx.fillOval(p.x, 0, 50, 50);
				p.x += p.velX;
				if (p.x > canvas.getWidth()) { 
					p.velX = -1;
				}
				ctx.stroke();
			} 
		}.start();
		
		primaryStage.setTitle("Animação com bolinha");
		primaryStage.show();		
	}

	public static void main(String[] args) {
		Application.launch(Bolinha.class, args);
	}
}
