package kosten_app.gui.mainscreen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import kosten_app.model.table.income.Income;
import kosten_app.model.table.income.IncomeTable;
import kosten_app.model.table.saving.Saving;
import kosten_app.model.table.saving.SavingTable;
import javafx.scene.control.Alert.AlertType;
import kosten_app.ownUtil.ShowMessageWindow;


public class CostView {

    //---Start attributes of the GUI---//

    private Scene scene = null;
    Stage stage;

    // Lists //
    public ObservableList <Bill> billList;
    public ObservableList <Debt> debtList;
    public ObservableList <Expense> expenseList;
    public ObservableList <Saving> savingList;
    public ObservableList <Income> incomeList;

    public ObservableList<Income> getIncomeList() {
        return incomeList;
    }

    // private final Scene secondScene = null;
    double totalIncome;
    // Button //
    private Button btnSaveInput	         	= new Button("Save");

    // Tables //
    private BillTable billTable             = new BillTable();
    private DebtTable debtTable             = new DebtTable();
    private SavingTable savingTable         = new SavingTable();
    private ExpenseTable expenseTable       = new ExpenseTable();
    private IncomeTable incomeTable         = new IncomeTable();

    // Shapes //
    private Rectangle card1                 = new Rectangle(20,20,300,150);
    private Rectangle card2                 = new Rectangle(20,20,300,150);
    private Rectangle card3                 = new Rectangle(20,20,300,150);
    private Rectangle card4                 = new Rectangle(20,20,300,150);
    private Rectangle cardBackground1       = new Rectangle(20,20,300,153);
    private Rectangle cardBackground2       = new Rectangle(20,20,300,153);
    private Rectangle cardBackground3       = new Rectangle(20,20,300,153);
    private Rectangle cardBackground4       = new Rectangle(20,20,300,153);

    private Rectangle billTableTop          = new Rectangle(0,0,400,15);
    private Rectangle expenseTableTop       = new Rectangle(0,0,400,15);
    private Rectangle savingTableTop        = new Rectangle(0,0,500,15);
    private Rectangle debtTableTop          = new Rectangle(0,0,500,15);

    private Rectangle billTableBot          = new Rectangle(0,0,400,15);
    private Rectangle expenseTableBot       = new Rectangle(0,0,400,15);
    private Rectangle savingTableBot        = new Rectangle(0,0,500,15);
    private Rectangle debtTableBot          = new Rectangle(0,0,500,15);

    // Charts //
    private ObservableList<PieChart.Data> pieChartData =
            FXCollections.observableArrayList(
                    new PieChart.Data("Grapefruit", 13),
                    new PieChart.Data("Oranges", 25),
                    new PieChart.Data("Plums", 10),
                    new PieChart.Data("Pears", 22),
                    new PieChart.Data("Apples", 30));
    private final PieChart chart = new PieChart(pieChartData);

    // Text //
    private Text cardTextSpend              = new Text("LEFT TO SPEND");
    private Text cardTextIncome             = new Text("TOTAL INCOME");
    private Text cardTextExpenses           = new Text("TOTAL EXPENSES");
    private Text cardTextBudget             = new Text("LEFT TO BUDGET");

    private Text cardValueSpend             = new Text("10000" + "€");
    private Text cardValueIncome            = new Text("400000" + "€");
    private Text cardValueExpenses          = new Text("5000" + "€");
    private Text cardValueBudget            = new Text("200000000" + "€");

    // -Pane layouts- //

    private VBox cardOrder1                 = new VBox(cardTextSpend, cardValueSpend);
    private VBox cardOrder2                 = new VBox(cardTextIncome, cardValueIncome);
    private VBox cardOrder3                 = new VBox(cardTextExpenses, cardValueExpenses);
    private VBox cardOrder4                 = new VBox(cardTextBudget, cardValueBudget);

    private StackPane stpCardSpend          = new StackPane();
    private StackPane stpCardIncome         = new StackPane();
    private StackPane stpCardExpense        = new StackPane();
    private StackPane stpCardDebt           = new StackPane();

    private StackPane stpTableBillTop       = new StackPane(billTableTop,new Text("BILLS"));
    private StackPane stpTableExpenseTop    = new StackPane(expenseTableTop,new Text("EXPENSES"));
    private StackPane stpTableSavingTop     = new StackPane(savingTableTop, new Text("SAVINGS"));
    private StackPane stpTableDebtTop       = new StackPane(debtTableTop, new Text("DEBT"));

    private StackPane stpTableBillBot       = new StackPane(billTableBot, new Text("hallo"));
    private StackPane stpTableExpenseBot    = new StackPane(expenseTableBot, new Text("hallo"));
    private StackPane stpTableSavingBot     = new StackPane(savingTableBot, new Text("hallo"));
    private StackPane stpTableDebtBot       = new StackPane(debtTableBot, new Text("hallo"));
    //private StackPane stpTableIncomeBot     = new StackPane(debtTableBot, new Text"TOTAL INCOME: " + totalIncome));
    private Text tableIncomeBotText=  new Text();
    private StackPane stpTableIncomeBot     = new StackPane(debtTableBot,tableIncomeBotText);


    // Merging tables to one group
    private VBox billTableGui               = new VBox(stpTableBillTop,billTable.getTable(),stpTableBillBot);
    private VBox expenseTableGui            = new VBox(stpTableExpenseTop, expenseTable.getTable(),stpTableExpenseBot);
    private VBox savingTableGui             = new VBox(stpTableSavingTop,savingTable.getTable(),stpTableSavingBot);
    private VBox debtTableGui               = new VBox(stpTableDebtTop,debtTable.getTable(),stpTableDebtBot);
    private VBox incomeTableGui             = new VBox(incomeTable.getTable(),stpTableIncomeBot);

    // Pie-Chart
    private VBox chartOrder                = new VBox();

    // Final order on GUI
    private VBox vTableBottom               = new VBox(debtTableGui, savingTableGui);
    private HBox hTableBottom               = new HBox(billTableGui, expenseTableGui, vTableBottom);
    private HBox tableOrder                 = new HBox();
    private HBox cardOrder                  = new HBox(stpCardSpend, stpCardIncome, stpCardExpense, stpCardDebt, chartOrder);
    private VBox compOrder                  = new VBox(cardOrder, tableOrder, btnSaveInput);
    private ScrollPane s1                   = new ScrollPane();

    // -End of Pane layouts- //

    //-------End attributes of the GUI-------//


    // Classes
    private CostController control;
    private CostModel model;

    public CostView(CostController control, Stage stage, CostModel model) {
        vTableBottom.setPrefSize(500,600);

        s1.setContent(hTableBottom);
        this.stage = stage;
        this.model = model;
        this.control = control;
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
        incomeTable.getTable().getColumns().addAll(incomeTable.getName_column(), incomeTable.getPayday_column(), incomeTable.getExpected_column(), incomeTable.getActual_column());

        billTable.getTable().setItems(getBill());
        expenseTable.getTable().setItems(getExpense());
        savingTable.getTable().setItems(getSaving());
        debtTable.getTable().setItems(getDebt());
        incomeTable.getTable().setItems(getIncome());

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

        chartOrder.getChildren().addAll(chart,incomeTableGui);

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

//        Thread t = new Thread(() -> {
//            while(true) {
//                for (var i : billList) {
//
//                    System.out.println(i.getName());
//                    try {
//                        Thread.sleep(10000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//            /*Platform.runLater(() -> {
//                //Here the actions that use the gui where is finished the actions on background.
//            });*/
//        });
//        t.start();
        billTable.getTable().setTableMenuButtonVisible(true);
        totalIncome = control.calculateLeftToSpend(getIncomeList());
        System.out.println("init" + totalIncome);
        tableIncomeBotText.setText("TOTAL INCOME:            " + totalIncome);
    }

    private void initListener(){

        btnSaveInput.setOnAction((ActionEvent e)->
        {
            control.saveData();
        });
    }


    static int zaehler = 0;
    public ObservableList<Bill> getBill(){
        if(billList == null) {
            billList = FXCollections.observableArrayList();
            billList.add(new Bill("Bill", "30.02", "150€", "120", "30"));

//            int i = 0;
//            while(true){
//                if( billList.get(i).getName() != null){
//                    billList.add(new Bill("", "", "", "", ""));
//                }
//                i++;
//            }

        }

//            int i = 0;
//            while(billList.get(i).getName() != null){
//
//                    billList.add(new Bill("", "", "", "", ""));
//                }




//        if(billList.get(0).getName() != null) {
//            billList.add(new Bill("", "", "", "", ""));
//
//        }
//         billTable.getTable().itemsProperty().addListener(new ChangeListener<ObservableList<Bill>>() {
//            @Override
//            public void changed(ObservableValue<? extends ObservableList<Bill>> observable, ObservableList<Bill> oldValue, ObservableList<Bill> newValue) {
//                if( billList.get(zaehler).getName() != null){
//                    billList.add(new Bill("", "", "", "", ""));
//                }
//                zaehler++;
//            }
//        });

        if( billList.get(zaehler).getName() != null){
        billTable.getTable().getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                System.out.println("+");
                billList.add(new Bill("", "", "", "", ""));
        });

    }
        return billList;
    }


    public ObservableList<Debt> getDebt(){
        if (debtList == null) {
            debtList = FXCollections.observableArrayList();
            debtList.add(new Debt("Debt", "150", "120", "30"));
        }
        return debtList;
    }
    public ObservableList<Expense> getExpense(){
        if (expenseList == null){
            expenseList = FXCollections.observableArrayList();
            expenseList.add(new Expense("Expense", "1000", "0", "1000" ));
        }
        return expenseList;
    }
    public ObservableList<Saving> getSaving(){
        if (savingList == null) {
            savingList = FXCollections.observableArrayList();
            savingList.add(new Saving("Saving", "150", "120", "30"));
        }
        return savingList;
    }

    public ObservableList<Income> getIncome(){
        if (incomeList == null) {
            incomeList = FXCollections.observableArrayList();
            incomeList.add(new Income("Income", "150", "120", "30"));
            incomeList.add(new Income("Income", "150", "150", "30"));
        }
        return incomeList;
    }

    public void showInformationWindow(String report){
        new ShowMessageWindow(AlertType.INFORMATION,
                "Information", report).zeigeMeldungsfensterAn();
    }


}