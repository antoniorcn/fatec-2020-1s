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
		double anguloTerra = 0;
		double anguloMarte = 0;
	}
	
	public double[] centro(Image img, double centroX, double centroY) { 
		double[] pos = new double[2];
		pos[0] = centroX - (img.getWidth() / 2);
		pos[1] = centroY - (img.getHeight() / 2);
		return pos;
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
				double terraDistancia = 100;
				double marsDistancia = 150;
				
				ctx.drawImage(imgSpace, 0, 0);
				double[] sunPos = centro(imgSun, solX, solY);
				ctx.drawImage(imgSun, sunPos[0], sunPos[1]);

				double terraX = solX + (terraDistancia * Math.cos(p.anguloTerra));
				double terraY = solY + (terraDistancia * Math.sin(p.anguloTerra));
				double[] earthPos = centro(imgEarth, terraX, terraY);
				ctx.drawImage(imgEarth, earthPos[0], earthPos[1]);
				
				double marsX = solX + (marsDistancia * Math.cos(p.anguloMarte));
				double marsY = solY + (marsDistancia * Math.sin(p.anguloMarte));
				double[] marsPos = centro(imgMars, marsX, marsY);
				ctx.drawImage(imgMars, marsPos[0], marsPos[1]);				
				p.anguloTerra += 0.01;
				p.anguloMarte += 0.03;
			} 
		}.start();
		stage.setTitle("Sistema Solar");
		stage.show();		
	}

	public static void main(String[] args) {
		Application.launch(SistemaSolar.class, args);
	}

}

