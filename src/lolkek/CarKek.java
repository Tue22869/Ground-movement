package lolkek;
	
import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class CarKek extends Application {
	
	static double x1;
	static double x2;
	static double x3;
	static double x4;
	
	@Override
	public void start(Stage ps) {
		ps.setTitle("Animation example");
		
		Group root = new Group();
		Scene myScene = new Scene(root);
		ps.setScene(myScene);
		
		Canvas canvas = new Canvas (660, 300);
		root.getChildren().add(canvas); 
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		Image car = new Image("car.png");
		Image road = new Image("road.png");
		x1 = 0;
		x2 = 220;
		x3 = 440;
		x4 = 660;
		
		final long startTime = System.nanoTime();
		
		new AnimationTimer() {

			@Override
			public void handle(long t) {
				gc.drawImage(road, x1, 0);
				gc.drawImage(road, x2, 0);
				gc.drawImage(road, x3, 0);
				gc.drawImage(road, x4, 0);
				gc.drawImage(car, 200, 0);
				x1 -= 1;
				x2 -= 1;
				x3 -= 1;
				x4 -= 1;
				if (x1 == -220) {x1 = 660;}
				if (x2 == -220) {x2 = 660;}
				if (x3 == -220) {x3 = 660;}
				if (x4 == -220) {x4 = 660;}
			}
			
		}.start();
		
		
		ps.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
