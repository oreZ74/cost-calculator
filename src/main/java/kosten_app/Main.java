package kosten_app;

import javafx.application.Application;
import javafx.stage.Stage;
import kosten_app.gui.mainscreen.CostController;



public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        new CostController(primaryStage);
    }
}