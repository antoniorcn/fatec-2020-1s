package edu.curso;

import java.io.InputStream;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SistemaSolar extends Application {
	
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
		ctx.drawImage(imgSpace, 0, 0);
		ctx.drawImage(imgSun, imgSpace.getWidth() / 2, imgSpace.getHeight() / 2);
		
		stage.setTitle("Sistema Solar");
		stage.show();		
	}

	public static void main(String[] args) {
		Application.launch(SistemaSolar.class, args);
	}

}
