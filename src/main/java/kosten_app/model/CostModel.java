package kosten_app.model;

// Das com.example.kostenkalkulation.Model speichert die Daten und führt Berechnungen durch
// Das Model speichert die Daten und führt Berechnungen durch
public class CostModel {
    private double monthlyIncome;
    private double fixedExpenses;

    public double calculateTotalMonthlyCost() {
        return monthlyIncome - fixedExpenses;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public double getFixedExpenses() {
        return fixedExpenses;
    }

    public void setFixedExpenses(double fixedExpenses) {
        this.fixedExpenses = fixedExpenses;
    }
}
