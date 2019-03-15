package lolkek;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
 
public class program2 extends Application {
 
    @Override
    public void start(Stage primaryStage) throws Exception {
 
        Label label = new Label("My Label");
 
        FlowPane root = new FlowPane();
        root.setPadding(new Insets(10));
        root.getChildren().add(label);
 
        Scene scene = new Scene(root, 200, 100);
 
        primaryStage.setTitle("JavaFX Label (o7planning.org)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        Application.launch(args);
    }
 
}
