package edu.curso;

import java.io.InputStream;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SistemaSolar extends Application {
	
	public Point2D centro(Image img, double centroX, double centroY) { 
		Point2D d = new Point2D(centroX - img.getWidth() / 2,
				centroY - img.getHeight() / 2);
		return d;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Group grp = new Group();
		Scene scn = new Scene(grp);
		stage.setScene(scn);
		InputStream isEspaco = 
				getClass().getResourceAsStream("/images/space.png");
		Image img = new Image(isEspaco);
		Image imgSun = new Image(getClass().getResourceAsStream("/images/sun.png"));
		Image imgEarth = new Image(getClass().getResourceAsStream("/images/earth.png"));
		Image imgMars = new Image(getClass().getResourceAsStream("/images/mars.png"));
		Canvas canvas = new Canvas(img.getWidth(), img.getHeight());
		grp.getChildren().add(canvas);
		GraphicsContext ctx = canvas.getGraphicsContext2D();
		double centroX = canvas.getWidth()/2;
		double centroY = canvas.getHeight()/2;
		final double[] angulo = new double[2];
		
		class ExecutaMouse implements EventHandler<MouseEvent> {
			@Override
			public void handle(MouseEvent event) {
				angulo[event.getButton().ordinal() - 1] = 0;
				
			} 		
		}
		
		final ExecutaMouse exe = new ExecutaMouse();
		canvas.addEventFilter(MouseEvent.MOUSE_PRESSED, exe);
		
		new AnimationTimer() {
			@Override
			public void handle(long now) {
				ctx.drawImage(img, 0, 0);	
				Point2D pointSun = centro(imgSun, centroX, centroY);
				ctx.drawImage(imgSun, 
						pointSun.getX(), 
						pointSun.getY());
				double earthX = centroX  + (100 * Math.cos(angulo[0]));
				double earthY = centroY + (100 * Math.sin(angulo[0]));
				Point2D pointEarth = centro(imgEarth, earthX, earthY);  
				ctx.drawImage(imgEarth, pointEarth.getX(), pointEarth.getY());
				
				double marsX = centroX  + (200 * Math.cos(angulo[1]));
				double marsY = centroY + (100 * Math.sin(angulo[1]));
				Point2D pointMars = centro(imgMars, marsX, marsY);
				ctx.drawImage(imgMars, pointMars.getX(), pointMars.getY());
				angulo[0] += 0.01;
				angulo[1] += 0.02;
			} 		
		}.start();
		
		
		stage.setTitle("Sistema Solar");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(SistemaSolar.class, args);
	}
}
