module KostenApp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;


    opens kosten_app to javafx.fxml;
    opens kosten_app.model to javafx.fxml;
    opens kosten_app.gui.mainscreen to javafx.fxml;



    exports kosten_app;
    exports kosten_app.model;
    exports kosten_app.gui.mainscreen;



}