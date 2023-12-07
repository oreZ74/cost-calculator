package kosten_app.gui.mainscreen;


import javafx.collections.ObservableList;
import javafx.stage.Stage;
import kosten_app.model.CostModel;
import kosten_app.model.table.bill.Bill;
import kosten_app.model.table.debt.Debt;
import kosten_app.model.table.expense.Expense;
import kosten_app.model.table.income.Income;
import kosten_app.model.table.saving.Saving;

// Der Controller behandelt Benutzereingaben und aktualisiert das Model und die View
public class CostController {
    private CostView view = null;
    private CostModel model = null;

    public ObservableList <Bill> billList;
    public ObservableList <Debt> debtList;
    public ObservableList <Expense> expenseList;
    public ObservableList <Saving> savingList;
    public ObservableList <Income> incomeList;

    public CostController(Stage stage) {
        this.model = new CostModel();
        System.out.println("hi");
        this.view = new CostView(this, stage, model);
        view.init();
        System.out.println("hi 2");
        extractData();

    }

    public void extractData(){
        try{
            for (var i : view.billList) {
                this.model.addBill(new Bill(
                        i.getName(),
                        i.getDue(),
                        i.getBudget(),
                        i.getActual(),
                        i.getDifference()
                ));
            }
            for (var i : view.debtList) {
                this.model.addDebt(new Debt(
                        i.getName(),
                        i.getBudget(),
                        i.getActual(),
                        i.getDifference()
                ));
            }
            for (var i : view.expenseList) {
                this.model.addExpense(new Expense(
                        i.getName(),
                        i.getBudget(),
                        i.getActual(),
                        i.getDifference()
                ));
            }
            for (var i : view.savingList) {
                this.model.addSaving(new Saving(
                        i.getName(),
                        i.getBudget(),
                        i.getActual(),
                        i.getDifference()
                ));

            }
            for (var i : view.incomeList) {
                this.model.addIncome(new Income(
                        i.getName(),
                        i.getPayday(),
                        i.getActual(),
                        i.getExpected()
                        ));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void saveData(){
        System.out.println(model.getListIncome());
        extractData();
        model.writeToCsv();
        view.showInformationWindow("Your data has been saved!");
    }

    // Calulating the total of one row
//    public double calculateActualOfIncome(ObservableList<Income> income){
//        double totalIncomeActual = 0;
//        for (Income i : income) {
//            totalIncomeActual += Double.parseDouble(" "+i.getActual());
//        }
//        return totalIncomeActual;
//    }

    // [0] = expected || [1] = actual
    public double [] calculateTotalOfIncome(ObservableList<Income> income){
        //System.out.println(view.getBillList().get(0).getName());
        //System.out.println(model.getListBill().get(0).getName());
        double [] total = new double[2];
        int counter= 0;
        for (Income i : income) {
            total[counter] += Double.parseDouble(" "+i.getExpected());
        }
        counter++;
        for (Income i : income) {
            total[counter] += Double.parseDouble(" "+i.getActual());
        }
        return total;
    }

    // [0] = budget || [1] = actual || [3] = diff
    public double [] calculateTotalOfBill(ObservableList<Bill> bill){
        double [] total = new double[3];
        int counter= 0;
        for (Bill i : bill) {
            total[counter] += Double.parseDouble(" "+i.getBudget());
        }
        counter++;
        for (Bill i : bill) {
            total[counter] += Double.parseDouble(" "+i.getActual());
        }
        counter++;
            total[counter] = total[0] - total[1];

        return total;
    }
    // [0] = budget || [1] = actual || [3] = diff
    public double [] calculateTotalOfExpense(ObservableList<Expense> expense){
        double [] total = new double[3];
        int counter= 0;
        for (Expense i : expense) {
            total[counter] += Double.parseDouble(" "+i.getBudget());
        }
        counter++;
        for (Expense i : expense) {
            total[counter] += Double.parseDouble(" "+i.getActual());
        }
        counter++;
        total[counter] = total[0] - total[1];

        return total;
    }
    // [0] = budget || [1] = actual || [3] = diff
    public double [] calculateTotalOfSaving(ObservableList<Saving> saving){
        double [] total = new double[3];
        int counter= 0;
        for (Saving i : saving) {
            total[counter] += Double.parseDouble(" "+i.getBudget());
        }
        counter++;
        for (Saving i : saving) {
            total[counter] += Double.parseDouble(" "+i.getActual());
        }
        counter++;
        total[counter] = total[0] - total[1];

        return total;
    }
    // [0] = budget || [1] = actual || [3] = diff
    public double [] calculateTotalOfDebt(ObservableList<Debt> debt){
        double [] total = new double[3];
        int counter= 0;
        for (Debt i : debt) {
            total[counter] += Double.parseDouble(" "+i.getBudget());
        }
        counter++;
        for (Debt i : debt) {
            total[counter] += Double.parseDouble(" "+i.getActual());
        }
        counter++;
        total[counter] = total[0] - total[1];
        return total;
    }

    public double totalExpense (){
        double total= (calculateTotalOfBill(getBillList())[1] +
                calculateTotalOfExpense(getExpenseList())[1] +
                calculateTotalOfSaving(getSavingList())[1] +
                calculateTotalOfDebt(getDebtList())[1]);
        return total;
    }

    public int [] PiechartOverview (){
        int [] i =  new int[4];
        i[0] = (int) Math.round(calculateTotalOfBill(getBillList())[1] / totalExpense() * 100);
        i[1] = (int) Math.round(calculateTotalOfDebt(getDebtList())[1] / totalExpense() * 100);
        i[2] = (int) Math.round(calculateTotalOfExpense(getExpenseList())[1] / totalExpense() * 100);
        i[3] = (int) Math.round(calculateTotalOfSaving(getSavingList())[1] / totalExpense() * 100);
        return i;
    }
//    public double totalExpense (ObservableList<Bill> bill, ObservableList<Expense> expense, ObservableList<Saving> saving, ObservableList<Debt> debt){
//        double total= (calculateTotalOfBill(bill)[1] +
//                calculateTotalOfExpense(expense)[1] +
//                calculateTotalOfSaving(saving)[1] +
//                calculateTotalOfDebt(debt)[1]);
//        return total;
//    }
//
//    public int [] PiechartOverview (ObservableList<Bill> bill, ObservableList<Expense> expense, ObservableList<Saving> saving, ObservableList<Debt> debt){
//        int [] i =  new int[4];
//        i[0] = (int) Math.round(calculateTotalOfBill(bill)[1] / totalExpense(bill,expense,saving,debt) * 100);
//        i[1] = (int) Math.round(calculateTotalOfDebt(debt)[1] / totalExpense(bill,expense,saving,debt) * 100);
//        i[2] = (int) Math.round(calculateTotalOfExpense(expense)[1] / totalExpense(bill,expense,saving,debt) * 100);
//        i[3] = (int) Math.round(calculateTotalOfSaving(saving)[1] / totalExpense(bill,expense,saving,debt) * 100);
//       return i;
//    }


    public ObservableList<Bill> getBillList() {
        return billList;
    }

    public void setBillList(ObservableList<Bill> billList) {
        this.billList = billList;
    }

    public ObservableList<Debt> getDebtList() {
        return debtList;
    }

    public void setDebtList(ObservableList<Debt> debtList) {
        this.debtList = debtList;
    }

    public ObservableList<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(ObservableList<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    public ObservableList<Saving> getSavingList() {
        return savingList;
    }

    public void setSavingList(ObservableList<Saving> savingList) {
        this.savingList = savingList;
    }

    public ObservableList<Income> getIncomeList() {
        return incomeList;
    }

    public void setIncomeList(ObservableList<Income> incomeList) {
        this.incomeList = incomeList;
    }
}