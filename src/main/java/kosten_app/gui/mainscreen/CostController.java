package kosten_app.gui.mainscreen;


import javafx.stage.Stage;
import kosten_app.model.CostModel;
import kosten_app.model.table.bill.Bill;
import kosten_app.model.table.debt.Debt;
import kosten_app.model.table.expense.Expense;
import kosten_app.model.table.saving.Saving;

// Der Controller behandelt Benutzereingaben und aktualisiert das Model und die View
public class CostController {
    private CostView view = null;
    private CostModel model = null;

    public CostController(Stage stage) {
        this.model = new CostModel();
        this.view = new CostView(this, stage, model);
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
            model.writeToCsv();
            view.showInformationWindow("Your data has been saved!");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void addNewLine (){

    }

}