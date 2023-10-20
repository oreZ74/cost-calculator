package kosten_app.model;

import kosten_app.model.table.bill.Bill;
import kosten_app.model.table.debt.Debt;
import kosten_app.model.table.expense.Expense;
import kosten_app.model.table.income.Income;
import kosten_app.model.table.saving.Saving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// Das com.example.kostenkalkulation.Model speichert die Daten und führt Berechnungen durch
// Das Model speichert die Daten und führt Berechnungen durch

public class CostModel {

    private  ArrayList <Bill> listBill = new ArrayList<>();
    private  ArrayList <Debt> listDebt= new ArrayList<>();
    private  ArrayList <Expense> listExpense= new ArrayList<>();
    private  ArrayList <Saving> listSaving= new ArrayList<>();
    private  ArrayList <Income> listIncome= new ArrayList<>();


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

    public ArrayList<Income> getListIncome() {
        return listIncome;
    }

    public void setListIncome(ArrayList<Income> listIncome) {
        this.listIncome = listIncome;
    }

    public  void addIncome(Income income){
        listIncome.add(income);
    }

    public void writeToCsv()
    {
        BufferedWriter aus;
        try {
            aus = new BufferedWriter(
                    new FileWriter("SaveFile.csv", false));
            for (Bill i : this.getListBill()){
                aus.write(i.getBillBack(';'));
            }
            for (Debt i : this.getListDebt()){
                aus.write(i.getDebtBack(';'));
            }
            for (Expense i : this.getListExpense()){
                aus.write(i.getExpenseBack(';'));
            }
            for (Saving i : this.getListSaving()){
                aus.write(i.getSavingBack(';'));
            }
            for (Income i : this.getListIncome()){
                aus.write(i.getIncomeBack(';'));
            }
            aus.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public double calculateLeftToSpend() {
//        double totalIncome = 0;
//        //System.out.println("hi");
////        for (Income i : model.getListIncome()) {
////            System.out.println("hi" + i.getActual());
////            totalIncome += Double.parseDouble(i.getActual());
////        }
//        for (Income i : getListIncome()) {
//            System.out.println("hi" + i.getActual());
//            totalIncome += Double.parseDouble(i.getActual());
//        }
//        return totalIncome;
//    }
}
