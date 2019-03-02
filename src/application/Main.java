package application;
	
import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class Main extends Application {
	
	static double x;
	static double y; 
	static double qx;
	static double qy; 
	
	@Override
	public void start(Stage ps) {
		ps.setTitle("Animation example");
		
		Group root = new Group();
		Scene myScene = new Scene(root);
		ps.setScene(myScene);
		
		Canvas canvas = new Canvas (512, 512);
		root.getChildren().add(canvas); 
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		Image sun = new Image("sun.png");
		Image space = new Image("space.png");
		Image earth = new Image("earth.png");
		
		final long startTime = System.nanoTime();
		x = 230 + 200;
		y = 230 + 200;
		qx = -1;
		qy = 0;
		
		new AnimationTimer() {

			@Override
			public void handle(long t) {
				if ((x == 230 + 200) && (y == 230 + 200)) {
					qx = -2;
					qy = 0;
				}
				if ((x == 230 - 200) && (y == 230 + 200)) {
					qx = 0;
					qy = -2;
				}
				if ((x == 230 - 200) && (y == 230 - 200)) {
					qx = 2;
					qy = 0;
				}
				if ((x == 230 + 200) && (y == 230 - 200)) {
					qx = 0;
					qy = 2;
				}
				x += qx;
				y += qy;
				gc.drawImage(space, 0, 0);
				gc.drawImage(earth, x, y);
				gc.drawImage(sun, 196, 196);
			}
			
		}.start();
		
		
		ps.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
