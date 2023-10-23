package kosten_app.gui.mainscreen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    // Classes
    private CostController control;
    private CostModel model;
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

    public ObservableList<Bill> getBillList() {
        return billList;
    }

    public ObservableList<Debt> getDebtList() {
        return debtList;
    }

    public ObservableList<Expense> getExpenseList() {
        return expenseList;
    }

    public ObservableList<Saving> getSavingList() {
        return savingList;
    }

    // private final Scene secondScene = null;
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
    private Rectangle savingTableTop        = new Rectangle(0,0,400,15);
    private Rectangle debtTableTop          = new Rectangle(0,0,400,15);

    private Rectangle billTableBot          = new Rectangle(0,0,400,15);
    private Rectangle expenseTableBot       = new Rectangle(0,0,400,15);
    private Rectangle savingTableBot        = new Rectangle(0,0,400,15);
    private Rectangle debtTableBot          = new Rectangle(0,0,400,15);
    private Rectangle incomeTableBot        = new Rectangle(0,0,400,15);

    // Charts //
    int [] roundedOverview ;
    private ObservableList<PieChart.Data> pieChartData = getPieChart();

    private final PieChart chart = new PieChart(pieChartData);

    // --Text-- //
    private Text cardTextSpend              = new Text("LEFT TO SPEND");
    private Text cardTextIncome             = new Text("TOTAL INCOME");
    private Text cardTextExpenses           = new Text("TOTAL EXPENSES");
    private Text cardTextBudget             = new Text("LEFT TO BUDGET");

    private Text cardValueSpend             = new Text();
    private Text cardValueIncome            = new Text();
    private Text cardValueExpenses          = new Text();
    private Text cardValueBudget            = new Text();

    // Text total
    private Text tableBillBotText           =  new Text();
    private Text tableBillBotBudget         =  new Text();
    private Text tableBillBotActual         =  new Text();
    private Text tableBillBotDiff           =  new Text();

    private Text tableExpenseBotText        =  new Text();
    private Text tableExpenseBotBudget      =  new Text();
    private Text tableExpenseBotActual      =  new Text();
    private Text tableExpenseBotDiff        =  new Text();

    private Text tableSavingBotText         =  new Text();
    private Text tableSavingBotBudget       =  new Text();
    private Text tableSavingBotActual       =  new Text();
    private Text tableSavingBotDiff         =  new Text();

    private Text tableDebtBotText           =  new Text();
    private Text tableDebtBotBudget         =  new Text();
    private Text tableDebtBotActual         =  new Text();
    private Text tableDebtBotDiff           =  new Text();

    private Text tableIncomeBotText         =  new Text();
    private Text tableIncomeBotExpected     =  new Text();
    private Text tableIncomeBotActual       =  new Text();

    // -Pane layouts- //
    private VBox cardOrder1                 = new VBox(cardTextSpend, cardValueSpend);
    private VBox cardOrder2                 = new VBox(cardTextIncome, cardValueIncome);
    private VBox cardOrder3                 = new VBox(cardTextExpenses, cardValueExpenses);
    private VBox cardOrder4                 = new VBox(cardTextBudget, cardValueBudget);

    HBox hBoxBill                           = new HBox();
    HBox hBoxExpense                        = new HBox();
    HBox hBoxSaving                         = new HBox();
    HBox hBoxDebt                           = new HBox();
    HBox hBoxIncome                         = new HBox();

    private StackPane stpCardSpend          = new StackPane();
    private StackPane stpCardIncome         = new StackPane();
    private StackPane stpCardExpense        = new StackPane();
    private StackPane stpCardDebt           = new StackPane();

    private StackPane stpTableBillTop       = new StackPane(billTableTop,new Text("BILLS"));
    private StackPane stpTableExpenseTop    = new StackPane(expenseTableTop,new Text("EXPENSES"));
    private StackPane stpTableSavingTop     = new StackPane(savingTableTop, new Text("SAVINGS"));
    private StackPane stpTableDebtTop       = new StackPane(debtTableTop, new Text("DEBT"));

    //private StackPane stpTableIncomeBot     = new StackPane(debtTableBot, new Text"TOTAL INCOME: " + totalIncome));

    // Text on rectangle for total
    private StackPane stpTableBillBot       = new StackPane(billTableBot, hBoxBill);
    private StackPane stpTableExpenseBot    = new StackPane(expenseTableBot, hBoxExpense);
    private StackPane stpTableSavingBot     = new StackPane(savingTableBot, hBoxSaving);
    private StackPane stpTableDebtBot       = new StackPane(debtTableBot, hBoxDebt);
    private StackPane stpTableIncomeBot     = new StackPane(incomeTableBot, hBoxIncome);


    // Merging tables to one group
    private VBox billTableGui               = new VBox(stpTableBillTop,billTable.getTable(),stpTableBillBot);
    private VBox expenseTableGui            = new VBox(stpTableExpenseTop, expenseTable.getTable(),stpTableExpenseBot);
    private VBox savingTableGui             = new VBox(stpTableSavingTop,savingTable.getTable(),stpTableSavingBot);
    private VBox debtTableGui               = new VBox(stpTableDebtTop,debtTable.getTable(),stpTableDebtBot);
    private VBox incomeTableGui             = new VBox(incomeTable.getTable(),stpTableIncomeBot);

    // Pie-Chart
    private VBox chartOrder                 = new VBox();

    // Final order on GUI

    //private HBox vTableBottom               = new HBox(debtTableGui, savingTableGui);
    private HBox hTableBottom               = new HBox(billTableGui, expenseTableGui, debtTableGui, savingTableGui);
    private HBox tableOrder                 = new HBox();
    private HBox cardOrder                  = new HBox(stpCardSpend, stpCardIncome, stpCardExpense, stpCardDebt);
    private VBox compOrder                  = new VBox(cardOrder, new HBox(chart,chartOrder),tableOrder, btnSaveInput);
    private ScrollPane s1                   = new ScrollPane();

    // -End of Pane layouts- //

    //-------End attributes of the GUI-------//




    public CostView(CostController control, Stage stage, CostModel model) {
        s1.setContent(hTableBottom);
        this.stage = stage;
        this.model = model;
        this.control = control;
        setStage(stage, compOrder);
        this.initKomponenten();
        this.initListener();
    }


    void setStage(Stage stage, Pane pane){
        scene = new Scene(pane,1950, 1200);
        String css = this.getClass().getResource("/kosten_app/style.css").toExternalForm();
        String background = this.getClass().getResource("/kosten_app/background.css").toExternalForm();
        hTableBottom.setStyle("-fx-background-color: #E0FFFF");
        scene.getStylesheets().addAll(css,background);
        stage.setScene(scene);
        stage.setTitle("Monatliche Kostenberechnung");
        //stage.setResizable(true);
        stage.show();
    }

    private void initKomponenten(){
        //roundedOverview =  control.PiechartOverview();
        hTableBottom.setSpacing(20);
        control.setBillList(getBillList());
        control.setExpenseList(getExpenseList());
        control.setSavingList(getSavingList());
        control.setDebtList(getDebtList());
        control.setIncomeList(getIncomeList());


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

        incomeTableBot.setFill(Color.SKYBLUE);
        incomeTableBot.setStroke(Color.LIGHTBLUE);
        incomeTableBot.setStrokeWidth(2);

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

        chartOrder.getChildren().addAll(incomeTableGui);

        stpCardSpend.setPadding(new Insets(10));
        stpCardIncome.setPadding(new Insets(10));
        stpCardExpense.setPadding(new Insets(10));
        stpCardDebt.setPadding(new Insets(10));

        cardValueSpend.setText(control.calculateTotalOfIncome(getIncomeList())[1] -
                        (control.calculateTotalOfBill(getBillList())[1] +
                        control.calculateTotalOfExpense(getExpenseList())[1] +
                        control.calculateTotalOfSaving(getSavingList())[1] +
                        control.calculateTotalOfDebt(getDebtList())[1]) + "€");

        cardValueIncome.setText(control.calculateTotalOfIncome(getIncomeList())[1] +"€");

        cardValueExpenses.setText(
                        (control.calculateTotalOfBill(getBillList())[1] +
                        control.calculateTotalOfExpense(getExpenseList())[1] +
                        control.calculateTotalOfSaving(getSavingList())[1] +
                        control.calculateTotalOfDebt(getDebtList())[1]) + "€");

        cardValueBudget.setText(control.calculateTotalOfIncome(getIncomeList())[0] -
                        (control.calculateTotalOfBill(getBillList())[0] +
                        control.calculateTotalOfExpense(getExpenseList())[0] +
                        control.calculateTotalOfSaving(getSavingList())[0] +
                        control.calculateTotalOfDebt(getDebtList())[0]) + "€");

        //-- Text styling --//
        // Cards
        cardTextSpend.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        cardTextIncome.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        cardTextBudget.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        cardTextExpenses.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        cardValueSpend.setFont(Font.font("Arial", FontWeight.BOLD, 46));
        cardValueIncome.setFont(Font.font("Arial", FontWeight.BOLD, 46));
        cardValueBudget.setFont(Font.font("Arial", FontWeight.BOLD, 46));
        cardValueExpenses.setFont(Font.font("Arial", FontWeight.BOLD, 46));

        // Styling
        TableView.TableViewSelectionModel <Bill> selectionModel = billTable.getTable().getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);

        billTable.getTable().setTableMenuButtonVisible(true);
        //totalIncome = control.calculateActualOfIncome(getIncomeList())[0];
        // Bill bottom Row
        stpTableBillBot.setAlignment(Pos.CENTER_LEFT);
        tableBillBotText.setText("TOTAL:");
        tableBillBotBudget.setText("" + control.calculateTotalOfBill(getBillList())[0] + "€");
        tableBillBotActual.setText("" + control.calculateTotalOfBill(getBillList())[1] + "€");
        tableBillBotDiff.setText("" + control.calculateTotalOfBill(getBillList())[2] + "€");
        hBoxBill.getChildren().addAll(tableBillBotText,tableBillBotBudget,tableBillBotActual,tableBillBotDiff);

        hBoxBill.setMargin(tableBillBotText,new Insets(0,110,0,0));
        hBoxBill.setMargin(tableBillBotBudget,new Insets(0,20,0,20));
        hBoxBill.setMargin(tableBillBotActual,new Insets(0,20,0,20));
        hBoxBill.setMargin(tableBillBotDiff,new Insets(0,5,0,20));

        // Expense bottom Row
        stpTableExpenseBot.setAlignment(Pos.CENTER_LEFT);
        tableExpenseBotText.setText("TOTAL:");
        tableExpenseBotBudget.setText("" + control.calculateTotalOfExpense(getExpenseList())[0] + "€");
        tableExpenseBotActual.setText("" + control.calculateTotalOfExpense(getExpenseList())[1] + "€");
        tableExpenseBotDiff.setText("" + control.calculateTotalOfExpense(getExpenseList())[2] + "€");
        hBoxExpense.getChildren().addAll(tableExpenseBotText,tableExpenseBotBudget,tableExpenseBotActual,tableExpenseBotDiff);

        hBoxExpense.setMargin(tableExpenseBotText,new Insets(0,90,0,0));
        hBoxExpense.setMargin(tableExpenseBotBudget,new Insets(0,20,0,0));
        hBoxExpense.setMargin(tableExpenseBotActual,new Insets(0,30,0,30));
        hBoxExpense.setMargin(tableExpenseBotDiff,new Insets(0,5,0,20));

        // Debt bottom Row
        stpTableDebtBot.setAlignment(Pos.CENTER_LEFT);
        tableDebtBotText.setText("TOTAL:");
        tableDebtBotBudget.setText("" + control.calculateTotalOfDebt(getDebtList())[0] + "€");
        tableDebtBotActual.setText("" + control.calculateTotalOfDebt(getDebtList())[1] + "€");
        tableDebtBotDiff.setText("" + control.calculateTotalOfDebt(getDebtList())[2] + "€");
        hBoxDebt.getChildren().addAll(tableDebtBotText,tableDebtBotBudget,tableDebtBotActual,tableDebtBotDiff);

        hBoxDebt.setMargin(tableDebtBotText,new Insets(0,90,0,0));
        hBoxDebt.setMargin(tableDebtBotBudget,new Insets(0,20,0,0));
        hBoxDebt.setMargin(tableDebtBotActual,new Insets(0,30,0,30));
        hBoxDebt.setMargin(tableDebtBotDiff,new Insets(0,5,0,20));

        // Saving bottom Row
        stpTableSavingBot.setAlignment(Pos.CENTER_LEFT);
        tableSavingBotText.setText("TOTAL:");
        tableSavingBotBudget.setText("" + control.calculateTotalOfSaving(getSavingList())[0] + "€");
        tableSavingBotActual.setText("" + control.calculateTotalOfSaving(getSavingList())[1] + "€");
        tableSavingBotDiff.setText("" + control.calculateTotalOfSaving(getSavingList())[2] + "€");
        hBoxSaving.getChildren().addAll(tableSavingBotText,tableSavingBotBudget,tableSavingBotActual,tableSavingBotDiff);

        hBoxSaving.setMargin(tableSavingBotText,new Insets(0,90,0,0));
        hBoxSaving.setMargin(tableSavingBotBudget,new Insets(0,20,0,0));
        hBoxSaving.setMargin(tableSavingBotActual,new Insets(0,30,0,30));
        hBoxSaving.setMargin(tableSavingBotDiff,new Insets(0,5,0,20));

        // Income bottom Row
        stpTableIncomeBot.setAlignment(Pos.CENTER_LEFT);
        tableIncomeBotText.setText("TOTAL:");
        tableIncomeBotExpected.setText("" + control.calculateTotalOfIncome(getIncomeList())[0] + "€");
        tableIncomeBotActual.setText("" + control.calculateTotalOfIncome(getIncomeList())[1] + "€");
        hBoxIncome.getChildren().addAll(tableIncomeBotText,tableIncomeBotExpected,tableIncomeBotActual);

        hBoxIncome.setMargin(tableIncomeBotExpected,new Insets(0,70,0,180));
        //tableIncomeBotText.setTextAlignment(TextAlignment.LEFT);
        chart.setTitle("Spending Overview");

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
            billList.add(new Bill("Bill", "30.02", "150", "120", "30"));

        }

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

    public ObservableList <PieChart.Data> getPieChart() {


        ObservableList<PieChart.Data> pie;
        pie = FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10),
                new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", 30));

        return pie;
    }
    public void showInformationWindow(String report){
        new ShowMessageWindow(AlertType.INFORMATION,
                "Information", report).zeigeMeldungsfensterAn();
    }


}