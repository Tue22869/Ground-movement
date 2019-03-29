package keklol228;

import javafx.animation.KeyFrame; 
import javafx.animation.Timeline; 
import javafx.application.Application; 
import javafx.stage.Stage; 
import javafx.util.Duration; 
import javafx.scene.Scene; 
import javafx.scene.canvas.Canvas; 
import javafx.scene.canvas.GraphicsContext; 
import javafx.scene.layout.BorderPane; 
import javafx.scene.layout.StackPane; 
import javafx.scene.paint.Color; 


public class Game extends Application { 

    //размеры поля 
    private static final int height = 600; 
    private static final int width = 800; 

    //ширина и высота ракетки 
    private static final int RACKET_WIDTH = 10; 
    private static final int RACKET_HEIGHT = 90; 

    //мячик 
    private static final int BALL_R = 30; 

    //начальные координаты ракеток 
    double compX = width - RACKET_WIDTH; 
    double compY = height/2; 

    double playerX = 0; 
    double playerY = height/2; 

    //начальные координаты мяча 
    double ballX = width/2; 
    double ballY = height/2; 

    //инструмент рисования 
    GraphicsContext gc; 

    boolean gameStarted; 

    //скорость мячика 
    double speedX = 3; 
    double speedY = 3; 

    public void drawField() { 
    	//поле 
        gc.setFill(Color.CYAN); 
        gc.fillRect(0, 0, width, height); 

        //разд. линия 
        gc.setFill(Color.YELLOW); 
        gc.fillRect(width/2, 0, 2, height); 

        gc.setFill(Color.WHITE); 
        if(gameStarted) { 
            ballX += speedX; 
            ballY += speedY; 
            if (ballX < width - 50) { 
                compY = ballY - RACKET_HEIGHT/2; 
            } 

            if (ballY >= height - 10) speedY = -3; 
            if (ballY <= 10) speedY = 3; 
            if (ballX >= compX - BALL_R / 2 && ballY >= compY - BALL_R / 2 && ballY <= compY + RACKET_HEIGHT + BALL_R / 2) speedX = -3; 
            if (ballX <= playerX + BALL_R / 2 && ballY >= playerY - RACKET_HEIGHT / 2 - BALL_R / 2 && ballY <= playerY + RACKET_HEIGHT / 2 + BALL_R / 2) speedX = 3;
            
            //если проигрыш
            // if (ballX < 0) { }
            // if (ballX > width) { }
            
            //мяч 
            gc.setFill(Color.WHITE); 
            gc.fillOval(ballX - BALL_R / 2, ballY - BALL_R / 2, BALL_R, BALL_R); 
        } 

            //ракетки 
            gc.setFill(Color.YELLOW); 
            gc.fillRect(playerX, playerY - RACKET_HEIGHT/2, RACKET_WIDTH, RACKET_HEIGHT); 
            gc.fillRect(compX, compY - RACKET_HEIGHT/2, RACKET_WIDTH, RACKET_HEIGHT);   
    } 

    @Override 
    public void start(Stage primaryStage) { 
    	Canvas canvas = new Canvas(width, height); 
        gc = canvas.getGraphicsContext2D(); 
        drawField(); 

        //Duration.millis(10), e->drawField() 
        Timeline t1 = new Timeline(new KeyFrame(Duration.millis(10), e->drawField())); 
        t1.setCycleCount(Timeline.INDEFINITE); 


        canvas.setOnMouseClicked(e -> gameStarted = true); 
        canvas.setOnMouseMoved(e -> playerY = e.getY()); 

        primaryStage.setScene(new Scene(new StackPane(canvas))); 
        primaryStage.setTitle("Ping-pong"); 
        primaryStage.show(); 
        t1.play(); 
    } 

    public static void main(String[] args) { 
        launch(args); 
    } 
}