package kosten_app.gui.mainscreen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import kosten_app.model.CostModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import kosten_app.model.table.Product;
import kosten_app.model.table.ProductTable;
import kosten_app.model.table.bill.Bill;
import kosten_app.model.table.bill.BillTable;
import kosten_app.model.table.expense.Expense;
import kosten_app.model.table.expense.ExpenseTable;


public class CostView {
    //---Anfang Attribute der grafischen Oberflaeche---
    private final GridPane grid = new GridPane();
    private final BorderPane border = new BorderPane();
    private Scene scene = null;
    private final Scene secondScene = null;
    Stage stage = null;
    ProductTable table = new ProductTable();
    BillTable billTable = new BillTable();
    ExpenseTable expenseTable = new ExpenseTable();
    //VBox root = new VBox(new ScrollPane(table.getTable()));
    HBox root = new HBox(table.getTable(), billTable.getTable(), expenseTable.getTable());

    HBox hBox = new HBox();
    ScrollPane s1 = new ScrollPane();

    //-------Ende Attribute der grafischen Oberflaeche-------

    private final CostController control;
    private final CostModel model;

    public CostView(CostController control, Stage stage, CostModel model) {




        //s1.setPrefSize(300,400);
        s1.setContent(root);
        this.control = control;
        this.model = model;
        this.stage = stage;
        setStage(stage, hBox);
        this.initKomponenten();
        this.initListener();
    }


    void setStage(Stage stage, Pane pane){
        scene = new Scene(pane,900, 600);
        String css = this.getClass().getResource("/kosten_app/style.css").toExternalForm();
        String background = this.getClass().getResource("/kosten_app/background.css").toExternalForm();
        scene.getStylesheets().addAll(css,background);
        stage.setScene(scene);
        stage.setTitle("Monatliche Kostenberechnung");
        stage.setResizable(true);
        stage.show();

    }

    private void initKomponenten(){
        root.setSpacing(20);

        // Table
        table.getTable().getColumns().addAll(table.getName_column(), table.getRevenue_column(), table.getOutgoings_column(), table.getPrice_column());
        billTable.getTable().getColumns().addAll(billTable.getName_column(), billTable.getDue_column(), billTable.getBudget_column(), billTable.getActual_column(), billTable.getDifference_column());
        expenseTable.getTable().getColumns().addAll(expenseTable.getName_column(), expenseTable.getBudget_column(), expenseTable.getActual_column(), expenseTable.getDifference_column());
        //grid.add(s1,0,5);
        table.getTable().setItems(getProducts());
        billTable.getTable().setItems(getBill());
        expenseTable.getTable().setItems(getExpense());

        hBox.getChildren().addAll(s1);
        //table.getTable().setItems(table.getTable().getListe());

        // Styling
        //inline code
        //ocrButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

    }

    private void initListener(){


    }

    public ObservableList<Product> getProducts(){
        ObservableList<Product> liste = FXCollections.observableArrayList();
        liste.add(new Product("Käse",  "400", "500", "100" + "€"));
        return liste;
    }
    public ObservableList<Bill> getBill(){
        ObservableList<Bill> liste = FXCollections.observableArrayList();
        liste.add(new Bill("Miete", "30.02", "150€", "120", "30" ));
        return liste;
    }
    public ObservableList<Expense> getExpense(){
        ObservableList<Expense> liste = FXCollections.observableArrayList();
        liste.add(new Expense("Miete", "150€", "120", "30" ));
        return liste;
    }
}