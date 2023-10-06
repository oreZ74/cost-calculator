package kosten_app.gui.mainscreen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import kosten_app.model.CostModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import kosten_app.model.table.Product;
import kosten_app.model.table.ProductTable;


public class CostView {
    //---Anfang Attribute der grafischen Oberflaeche---
    private GridPane grid = new GridPane();
    private BorderPane border = new BorderPane();
    private TextField monthlyIncomeField = new TextField();
    private TextField fixedExpensesField = new TextField();
    private Label totalMonthlyCostLabel = new Label("Verbleibendes Budget: ");
    private Label monthlyIncomeLabel = new Label("Monatliches Einkommen:");
    private Label fixedExpensesLabel = new Label("Fixkosten:");
    private Button calculateButton = new Button("Berechnen");
    private Button ocrButton = new Button("Kassenbon hinzufügen");
    private Scene scene = null;
    private Scene secondScene = null;
    Stage stage = null;
    ProductTable table = new ProductTable();

    //-------Ende Attribute der grafischen Oberflaeche-------

    private CostController control;
    private CostModel model;

    public CostView(CostController control, Stage stage, CostModel model) {

        this.control = control;
        this.model = model;
        this.stage = stage;
        setStage(stage, grid);
        this.initKomponenten();
        this.initListener();
    }


    void setStage(Stage stage, Pane pane){
        scene = new Scene(pane,900, 600);
        //scene.getStylesheets().add(this.getClass().getResource("kosten_app/gui/mainscreen/style.css").toExternalForm());
        String css = this.getClass().getResource("/kosten_app/style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Monatliche Kostenberechnung");
        stage.setResizable(false);
        stage.show();

    }

    private void initKomponenten(){
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPrefSize(300, 200);
        grid.setPadding(new Insets(20, 20, 20, 20));

        calculateButton.getStyleClass().add("button");

        grid.add(monthlyIncomeLabel, 0, 0);
        grid.add(monthlyIncomeField, 1, 0);
        grid.add(fixedExpensesLabel, 0, 1);
        grid.add(fixedExpensesField, 1, 1);
        grid.add(calculateButton, 0, 2);
        grid.add(ocrButton,1,2);
        grid.add(totalMonthlyCostLabel, 0, 3);



        // Table
        table.getTable().getColumns().addAll(table.getName_column(), table.getRevenue_column(), table.getOutgoings_column(), table.getPrice_column());
        grid.add(table.getTable(),0,5);
        table.getTable().setItems(getProducts());
        //table.getTable().setItems(table.getTable().getListe());

        // Styling
        //inline code
        //ocrButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

    }

    private void initListener(){

        fixedExpensesField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    calculateButton.fire();
                }
            }
        });
        //fixedExpensesField.setOnAction(new calculateHandler());
        ocrButton.setOnAction(new ocrHandler());
        calculateButton.setOnAction(new calculateHandler());
        // Lambda Funktion verwenden und an den controller weitergeben

    }

    public ObservableList<Product> getProducts(){
        ObservableList<Product> liste = FXCollections.observableArrayList();
        liste.add(new Product("Käse", 400, 500, "" + 100 + "€"));
        liste.add(new Product("Affe", 500, 600, "" + 200 + "€"));
        liste.add(new Product("Waffe", 600, 700, "" + 300 + "€"));
        liste.add(new Product("Ak-74", 700, 800, "" + 400 + "€"));
        return liste;
    }


    public double getMonthlyIncome() {
        return Double.parseDouble(monthlyIncomeField.getText());
    }

    public double getFixedExpenses() {
        return Double.parseDouble(fixedExpensesField.getText());
    }

    public void setTotalMonthlyCost(double totalMonthlyCost) {
        totalMonthlyCostLabel.setText("Verbleibendes Budget: " + totalMonthlyCost);
    }

    class calculateHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            double monthlyIncome = getMonthlyIncome();
            double fixedExpenses = getFixedExpenses();

            double totalMonthlyCost = monthlyIncome - fixedExpenses;

            setTotalMonthlyCost(totalMonthlyCost);
        }
    }

    class ocrHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            setStage(stage, border);
        }
    }
}