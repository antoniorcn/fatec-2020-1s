package edu.curso;

import java.io.InputStream;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class SistemaSolar extends Application {
	class Ponto { 
		double angulo = 0;
	}
	public void start(Stage stage) { 
		Group grp = new Group();
		Scene scn = new Scene(grp);
		stage.setScene(scn);
		// Carregar imagens
		InputStream is = getClass().getResourceAsStream("/images/space.png");
		Image imgSpace = new Image(is);
		Image imgSun = new Image(getClass().getResourceAsStream("/images/sun.png"));
		Image imgEarth = new Image(getClass().getResourceAsStream("/images/earth.png"));
		Image imgMars = new Image(getClass().getResourceAsStream("/images/mars.png"));
		Canvas canvas = new Canvas(imgSpace.getWidth(), imgSpace.getHeight());
		grp.getChildren().add(canvas);	
		GraphicsContext ctx = canvas.getGraphicsContext2D();
		final double solX = imgSpace.getWidth() / 2;
		final double solY = imgSpace.getHeight() / 2;
		final Ponto p = new Ponto();
		new AnimationTimer() {
			@Override
			public void handle(long now) {
				double terraX = 0;
				double terraY = 0;
				double terraDistancia = 100;
				ctx.drawImage(imgSpace, 0, 0);
				ctx.drawImage(imgSun, solX, solY);
				terraX = (solX + imgSun.getWidth() / 2) + (terraDistancia * Math.cos(p.angulo));
				terraY = (solY + imgSun.getHeight() / 2) + (terraDistancia * Math.sin(p.angulo));
				ctx.drawImage(imgEarth, terraX, terraY);
				p.angulo += 0.01;
			} 
		}.start();
		stage.setTitle("Sistema Solar");
		stage.show();		
	}

	public static void main(String[] args) {
		Application.launch(SistemaSolar.class, args);
	}

}

