package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Program1 extends Application {
	 
    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	FlowPane root = new FlowPane();
    	root.setHgap(10);
        root.setVgap(20);
        root.setPadding(new Insets(15,15,15,15));
    	
        TextField textField = new TextField();
        textField.setMinWidth(180);
        root.getChildren().add(textField);
        
        //
        Label lbl = new Label("Answer");
        root.getChildren().add(lbl);
        
        //
        String text = textField.getText().toString();
        int i = Integer.parseInt(text);
        
        // 
        Button button8 = new Button("to 8");
        button8.setOnAction(event -> lbl.setText("Answer: " + Integer.toString(i, 8)));
        root.getChildren().add(button8);
 
        //
        Button button16 = new Button("to 16");
        button16.setOnAction(event -> lbl.setText("Answer: " + Integer.toString(i, 16)));
        root.getChildren().add(button16);
 
        Scene scene = new Scene(root, 200, 100);
 
        primaryStage.setTitle("to 8 or 16");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        Application.launch(args);
    }
}
