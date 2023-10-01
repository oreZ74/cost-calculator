package kosten_app;

import javafx.application.Application;
import javafx.stage.Stage;

import kosten_app.gui.mainscreen.CostController;

import java.sql.SQLException;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws SQLException {
        DB_Util database = null;

        try {
            database = new DB_Util("Database.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
        CostController controller = new CostController(primaryStage);
    }
}