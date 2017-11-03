package rectangleexperiment;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;

public class RectangleExperiment extends Application {
    @Override
    public void start(Stage primaryStage) {
        UI.setGroup(new Group());
        
        primaryStage.setTitle("Rectangle Experiment");
        primaryStage.setScene(UI.initialize());
        primaryStage.show();
        
        UI.putString(68, 13, "Exact Match!Please wait while systemis accessed.", 68);
    }

    public static void main(String[] args) { launch(args); }
}