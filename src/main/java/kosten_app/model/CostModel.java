package kosten_app.model;

import kosten_app.model.table.bill.Bill;
import kosten_app.model.table.debt.Debt;
import kosten_app.model.table.expense.Expense;
import kosten_app.model.table.saving.Saving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// Das com.example.kostenkalkulation.Model speichert die Daten und führt Berechnungen durch
// Das Model speichert die Daten und führt Berechnungen durch

public class CostModel {

    private ArrayList <Bill> listBill = new ArrayList<>();
    private ArrayList <Debt> listDebt= new ArrayList<>();
    private ArrayList <Expense> listExpense= new ArrayList<>();
    private ArrayList <Saving> listSaving= new ArrayList<>();


    public CostModel() {

    }

    public ArrayList<Bill> getListBill() {
        return listBill;
    }

    public void setListBill(ArrayList<Bill> listBill) {
        this.listBill = listBill;
    }
    public void addBill(Bill bill){
        listBill.add(bill);
    }

    public ArrayList<Debt> getListDebt() {
        return listDebt;
    }

    public void setListDebt(ArrayList<Debt> listDebt) {
        this.listDebt = listDebt;
    }
    public void addDebt(Debt debt){
        listDebt.add(debt);
    }

    public ArrayList<Expense> getListExpense() {
        return listExpense;
    }

    public void setListExpense(ArrayList<Expense> listExpense) {
        this.listExpense = listExpense;
    }

    public void addExpense(Expense expense){
        listExpense.add(expense);
    }

    public ArrayList<Saving> getListSaving() {
        return listSaving;
    }

    public void setListSaving(ArrayList<Saving> listSaving) {
        this.listSaving = listSaving;
    }


    public void addSaving(Saving saving){
        listSaving.add(saving);

    }

    public void writeToCsv()
    {
        BufferedWriter aus;
        try {
            aus = new BufferedWriter(
                    new FileWriter("Debt.csv", true));
            for (Bill i : this.getListBill()){
                aus.write(i.getBillBack(';'));
            }
            aus.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



//
//
//    public void schreibeFreizeitbaederInCsvDatei() throws Exception
//    {
//        //BufferedWriter aus = new BufferedWriter(new FileWriter("Freizeitbaeder.csv", true));
//        //aus.write(getBad().gibFreizeitbadZurueck(';'));
//        //aus.close();
//        ConcreteCSVProductCreator creator = new ConcreteCSVProductCreator();
//        var product = creator.factoryMethod();
//
//        // foreach
//        for(var bad : getBaeder())
//            product.fuegeInDateiHinzu(bad);
//        product.schliesseDatei();
//    }
}
