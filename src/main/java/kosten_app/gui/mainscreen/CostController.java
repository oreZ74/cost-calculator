package kosten_app.gui.mainscreen;


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

    public CostController(Stage stage) {
        this.model = new CostModel();
        this.view = new CostView(this, stage, model);
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
                        i.getExpected(),
                        i.getActual()
                ));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void saveData(){
        extractData();
        model.writeToCsv();
        view.showInformationWindow("Your data has been saved!");
    }

//    public double calculateLeftToSpend(){
//        double totalIncome = 0;
//        //System.out.println("hi");
////        for (Income i : model.getListIncome()) {
////            System.out.println("hi" + i.getActual());
////            totalIncome += Double.parseDouble(i.getActual());
////        }
//        for (Income i : this.view.getIncome()) {
//            System.out.println("hi" + i.getActual());
//            totalIncome += Double.parseDouble(i.getActual());
//        }
//
//
//        return totalIncome;
//    }

    double calculateTotalIncome(){
        return 0;
    }

    double calculateTotalExpense(){
        return 0;
    }

    double calculateLeftBudget(){
        return 0;
    }
}