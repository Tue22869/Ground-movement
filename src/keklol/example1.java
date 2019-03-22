package keklol;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;


public class example1 extends Application {
	public void start(Stage theStage) 
    {
        theStage.setTitle( "������ ������ � �����������" );

        // ������� �������� ������� � ����� ��� ����
        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        // ��������� ������ ����� � ��������� �� � �������� �������
        Canvas canvas = new Canvas( 512 - 64, 256 );
        root.getChildren().add( canvas );

        // ������� ������ � ������ ������� ������
        ArrayList<String> input = new ArrayList<String>();

        // ��������� ������� ������� �� �������
        theScene.setOnKeyPressed(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                	// ��� �������
                    String code = e.getCode().toString(); 
                    if ( !input.contains(code) )
                        input.add( code );
                }
            });

        // ��������� "����������" �������
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

        // ������� ������� �����������

        Image left = new Image( "car.png" );
        Image leftG = new Image( "road.png" );

        Image right = new Image( "car.png" );
        Image rightG = new Image( "road.png" );

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                // ������ ��� ������� �����
                gc.clearRect(0, 0, 512,512);

                // ������ �����������, � ����������� �� ���� �������
                if (input.contains("LEFT"))
                    gc.drawImage( leftG, 64, 64 );
                else
                    gc.drawImage( left, 64, 64 );

                if (input.contains("RIGHT"))
                    gc.drawImage( rightG, 256, 64 );
                else
                    gc.drawImage( right, 256, 64 );
            }
        }.start();

        theStage.show();
    }
	public static void main(String[] args)
    {
        launch(args);
    }

}
