module KostenApp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires java.sql;


    opens kosten_app to javafx.fxml;
    opens kosten_app.model to javafx.fxml;
    opens kosten_app.model.table to javafx.fxml;




    exports kosten_app;
    exports kosten_app.model;
    exports kosten_app.model.table;




}