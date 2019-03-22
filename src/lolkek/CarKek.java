package lolkek;
	
import javafx.application.Application;
import javafx.event.EventHandler;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;


public class CarKek extends Application {
	
	static double x1;
	static double x2;
	static double x3;
	static double x4;
	static double x5;
	
	@Override
	public void start(Stage theStage) {
		theStage.setTitle( "ѕример работы с клавиатурой" );
		
		Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );
		
		Canvas canvas = new Canvas (660, 150);
		root.getChildren().add(canvas); 
		
		// —оздаем список с кодами нажатых клавиш
        ArrayList<String> input = new ArrayList<String>();

        // ќбработка событи€ нажати€ на клавишу
        theScene.setOnKeyPressed(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                	// код клавиши
                    String code = e.getCode().toString(); 
                    if ( !input.contains(code) )
                        input.add( code );
                }
            });

        // обработка "отпускани€" клавиши
        theScene.setOnKeyReleased(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    input.remove( code );
                }
            });
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		Image car = new Image("car.png");
		Image road = new Image("road.png");
		x1 = 0;
		x2 = 220;
		x3 = 440;
		x4 = 660;
		x5 = 200;
		
		final long startTime = System.nanoTime();
		
		new AnimationTimer() {

			@Override
			public void handle(long t) {
				gc.drawImage(road, x1, 0);
				gc.drawImage(road, x2, 0);
				gc.drawImage(road, x3, 0);
				gc.drawImage(road, x4, 0);
				gc.drawImage(car, x5, -30);
				if (input.contains("LEFT"))
                    x5 -= 1;

                if (input.contains("RIGHT"))
                    x5 += 1;
                
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
		
		
		theStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
