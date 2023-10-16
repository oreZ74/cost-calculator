package kosten_app.gui.mainscreen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import kosten_app.model.CostModel;
import kosten_app.model.table.bill.Bill;
import kosten_app.model.table.bill.BillTable;
import kosten_app.model.table.debt.Debt;
import kosten_app.model.table.debt.DebtTable;
import kosten_app.model.table.expense.Expense;
import kosten_app.model.table.expense.ExpenseTable;
import kosten_app.model.table.saving.Saving;
import kosten_app.model.table.saving.SavingTable;
import javafx.scene.control.Alert.AlertType;
import kosten_app.ownUtil.ShowMessageWindow;


public class CostView {
    //---Start attributes of the GUI---//
    private Scene scene = null;
    Stage stage = null;

    // Liste //
    public ObservableList <Bill> billList;
    public static ObservableList <Debt> debtList;
    public static ObservableList <Expense> expenseList;
    public static ObservableList <Saving> savingList;

    // private final Scene secondScene = null;

    // Button //
    private Button btnSaveInput	         	    = new Button("Save");

    // Tables //
    private BillTable billTable                 = new BillTable();
    private DebtTable debtTable                 = new DebtTable();
    private SavingTable savingTable             = new SavingTable();
    private ExpenseTable expenseTable           = new ExpenseTable();

    // Shapes //
    private Rectangle card1                     = new Rectangle(20,20,300,150);
    private Rectangle card2                     = new Rectangle(20,20,300,150);
    private Rectangle card3                     = new Rectangle(20,20,300,150);
    private Rectangle card4                     = new Rectangle(20,20,300,150);
    private Rectangle cardBackground1           = new Rectangle(20,20,300,153);
    private Rectangle cardBackground2           = new Rectangle(20,20,300,153);
    private Rectangle cardBackground3           = new Rectangle(20,20,300,153);
    private Rectangle cardBackground4           = new Rectangle(20,20,300,153);

    private Rectangle billTableTop              = new Rectangle(0,0,400,15);
    private Rectangle expenseTableTop           = new Rectangle(0,0,400,15);
    private Rectangle savingTableTop            = new Rectangle(0,0,500,15);
    private Rectangle debtTableTop              = new Rectangle(0,0,500,15);

    private Rectangle billTableBot              = new Rectangle(0,0,400,15);
    private Rectangle expenseTableBot           = new Rectangle(0,0,400,15);
    private Rectangle savingTableBot            = new Rectangle(0,0,500,15);
    private Rectangle debtTableBot              = new Rectangle(0,0,500,15);

    private Text cardTextSpend                  = new Text("LEFT TO SPEND");
    private Text cardTextIncome                 = new Text("TOTAL INCOME");
    private Text cardTextExpenses               = new Text("TOTAL EXPENSES");
    private Text cardTextBudget                 = new Text("LEFT TO BUDGET");

    private Text cardValueSpend                 = new Text("10000" + "€");
    private Text cardValueIncome                = new Text("400000" + "€");
    private Text cardValueExpenses              = new Text("5000" + "€");
    private Text cardValueBudget                = new Text("200000000" + "€");

    private VBox cardOrder1                     = new VBox(cardTextSpend, cardValueSpend);
    private VBox cardOrder2                     = new VBox(cardTextIncome, cardValueIncome);
    private VBox cardOrder3                     = new VBox(cardTextExpenses, cardValueExpenses);
    private VBox cardOrder4                     = new VBox(cardTextBudget, cardValueBudget);

    // Charts //
    private ObservableList<PieChart.Data> pieChartData =
            FXCollections.observableArrayList(
                    new PieChart.Data("Grapefruit", 13),
                    new PieChart.Data("Oranges", 25),
                    new PieChart.Data("Plums", 10),
                    new PieChart.Data("Pears", 22),
                    new PieChart.Data("Apples", 30));
    private final PieChart chart = new PieChart(pieChartData);



    // Pane layouts //
    private StackPane stpCardSpend = new StackPane();
    private StackPane stpCardIncome = new StackPane();
    private StackPane stpCardExpense = new StackPane();
    private StackPane stpCardDebt = new StackPane();

    private StackPane stpTableBillTop = new StackPane(billTableTop,new Text("BILLS"));
    private StackPane stpTableExpenseTop = new StackPane(expenseTableTop,new Text("EXPENSES"));
    private StackPane stpTableSavingTop = new StackPane(savingTableTop, new Text("SAVINGS"));
    private StackPane stpTableDebtTop = new StackPane(debtTableTop, new Text("DEBT"));

    private StackPane stpTableBillBot = new StackPane(billTableBot, new Text("hallo"));
    private StackPane stpTableExpenseBot = new StackPane(expenseTableBot, new Text("hallo"));
    private StackPane stpTableSavingBot = new StackPane(savingTableBot, new Text("hallo"));
    private StackPane stpTableDebtBot = new StackPane(debtTableBot, new Text("hallo"));

    private Group chartOrder = new Group();
    private VBox vTableBottom = new VBox(new VBox(stpTableDebtTop,debtTable.getTable(),stpTableDebtBot), new VBox(stpTableSavingTop,savingTable.getTable(),stpTableSavingBot));
    private HBox hTableBottom = new HBox(new VBox(stpTableBillTop,billTable.getTable(),stpTableBillBot), new VBox(stpTableExpenseTop, expenseTable.getTable(),stpTableExpenseBot), vTableBottom);
    private HBox tableOrder = new HBox();
    private HBox cardOrder = new HBox(stpCardSpend, stpCardIncome, stpCardExpense, stpCardDebt, chartOrder);
    private VBox compOrder = new VBox(cardOrder, tableOrder, btnSaveInput);
    private ScrollPane s1 = new ScrollPane();

    //-------End attributes of the GUI-------//


    // Classes
    private final CostController control;
    private final CostModel model;

    public CostView(CostController control, Stage stage, CostModel model) {
        vTableBottom.setPrefSize(500,600);

        s1.setContent(hTableBottom);
        this.control = control;
        this.model = model;
        this.stage = stage;
        setStage(stage, compOrder);
        this.initKomponenten();
        this.initListener();

    }


    void setStage(Stage stage, Pane pane){
        scene = new Scene(pane,1780, 1050);
        String css = this.getClass().getResource("/kosten_app/style.css").toExternalForm();
        String background = this.getClass().getResource("/kosten_app/background.css").toExternalForm();
        hTableBottom.setStyle("-fx-background-color: #E0FFFF");
        scene.getStylesheets().addAll(css,background);
        stage.setScene(scene);
        stage.setTitle("Monatliche Kostenberechnung");
        stage.setResizable(true);
        stage.show();
        chart.setTitle("Imported Fruits");

    }

    private void initKomponenten(){
        hTableBottom.setSpacing(20);

        // Table
        billTable.getTable().getColumns().addAll(billTable.getName_column(), billTable.getDue_column(), billTable.getBudget_column(), billTable.getActual_column(), billTable.getDifference_column());
        expenseTable.getTable().getColumns().addAll(expenseTable.getName_column(), expenseTable.getBudget_column(), expenseTable.getActual_column(), expenseTable.getDifference_column());
        savingTable.getTable().getColumns().addAll(savingTable.getName_column(), savingTable.getBudget_column(), savingTable.getActual_column(), savingTable.getDifference_column());
        debtTable.getTable().getColumns().addAll(debtTable.getName_column(), debtTable.getBudget_column(), debtTable.getActual_column(), debtTable.getDifference_column());

        billTable.getTable().setItems(getBill());
        expenseTable.getTable().setItems(getExpense());
        savingTable.getTable().setItems(getSaving());
        debtTable.getTable().setItems(getDebt());

        tableOrder.getChildren().addAll(s1);



        card1.setFill(Color.TRANSPARENT);
        card2.setFill(Color.TRANSPARENT);
        card3.setFill(Color.TRANSPARENT);
        card4.setFill(Color.TRANSPARENT);
        // Name of table
        billTableTop.setFill(Color.SKYBLUE);
        billTableTop.setStroke(Color.LIGHTBLUE);
        billTableTop.setStrokeWidth(2);

        expenseTableTop.setFill(Color.SKYBLUE);
        expenseTableTop.setStroke(Color.LIGHTBLUE);
        expenseTableTop.setStrokeWidth(2);

        savingTableTop.setFill(Color.SKYBLUE);
        savingTableTop.setStroke(Color.LIGHTBLUE);
        savingTableTop.setStrokeWidth(2);

        debtTableTop.setFill(Color.SKYBLUE);
        debtTableTop.setStroke(Color.LIGHTBLUE);
        debtTableTop.setStrokeWidth(2);

        // Total of table
        billTableBot.setFill(Color.SKYBLUE);
        billTableBot.setStroke(Color.LIGHTBLUE);
        billTableBot.setStrokeWidth(2);

        expenseTableBot.setFill(Color.SKYBLUE);
        expenseTableBot.setStroke(Color.LIGHTBLUE);
        expenseTableBot.setStrokeWidth(2);

        savingTableBot.setFill(Color.SKYBLUE);
        savingTableBot.setStroke(Color.LIGHTBLUE);
        savingTableBot.setStrokeWidth(2);

        debtTableBot.setFill(Color.SKYBLUE);
        debtTableBot.setStroke(Color.LIGHTBLUE);
        debtTableBot.setStrokeWidth(2);


        card1.setStroke(Color.BLACK);
        card2.setStroke(Color.BLACK);
        card3.setStroke(Color.BLACK);
        card4.setStroke(Color.BLACK);



        stpCardSpend.getChildren().addAll(cardBackground1,card1,cardOrder1);
        stpCardIncome.getChildren().addAll(cardBackground2,card2,cardOrder2);
        stpCardExpense.getChildren().addAll(cardBackground3,card3,cardOrder3);
        stpCardDebt.getChildren().addAll(cardBackground4,card4,cardOrder4);

        card1.setFill(Color.BISQUE);
        card2.setFill(Color.BISQUE);
        card3.setFill(Color.BISQUE);
        card4.setFill(Color.BISQUE);

        cardOrder1.setAlignment(Pos.CENTER);
        cardOrder2.setAlignment(Pos.CENTER);
        cardOrder3.setAlignment(Pos.CENTER);
        cardOrder4.setAlignment(Pos.CENTER);

        chartOrder.getChildren().add(chart);

        stpCardSpend.setPadding(new Insets(10));
        stpCardIncome.setPadding(new Insets(10));
        stpCardExpense.setPadding(new Insets(10));
        stpCardDebt.setPadding(new Insets(10));


        // Text styling
        cardTextSpend.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        cardTextIncome.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        cardTextBudget.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        cardTextExpenses.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        cardValueSpend.setFont(Font.font("Arial", FontWeight.BOLD, 46));
        cardValueIncome.setFont(Font.font("Arial", FontWeight.BOLD, 46));
        cardValueBudget.setFont(Font.font("Arial", FontWeight.BOLD, 46));
        cardValueExpenses.setFont(Font.font("Arial", FontWeight.BOLD, 46));

        // Styling
        //inline code
        //ocrButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        TableView.TableViewSelectionModel <Bill> selectionModel = billTable.getTable().getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);

        Thread t = new Thread(() -> {
            while(true) {
                for (var i : billList) {

                    System.out.println(i.getName());
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            /*Platform.runLater(() -> {
                //Here the actions that use the gui where is finished the actions on background.
            });*/
        });
        t.start();
    }

    private void initListener(){

        btnSaveInput.setOnAction((ActionEvent e)->
        {
            control.extractData();
        });
    }



    public ObservableList<Bill> getBill(){
        if(billList == null) {
            billList = FXCollections.observableArrayList();
            billList.add(new Bill("Miete", "30.02", "150€", "120", "30"));
        }
        return billList;
    }
    public ObservableList<Expense> getExpense(){
        ObservableList<Expense> liste = FXCollections.observableArrayList();
        liste.add(new Expense("", "", "", "" ));
        return liste;
    }
    public ObservableList<Saving> getSaving(){
        ObservableList<Saving> liste = FXCollections.observableArrayList();
        liste.add(new Saving("Miete", "150€", "120", "30" ));
        return liste;
    }
    public ObservableList<Debt> getDebt(){
        ObservableList<Debt> liste = FXCollections.observableArrayList();
        liste.add(new Debt("Miete", "150€", "120", "30" ));
        return liste;
    }
    public void showInformationWindow(String report){
        new ShowMessageWindow(AlertType.INFORMATION,
                "Information", report).zeigeMeldungsfensterAn();
    }


}