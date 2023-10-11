package kosten_app.model.table.bill;


import javafx.beans.property.SimpleStringProperty;

public class Bill {

    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty due = new SimpleStringProperty();
    private SimpleStringProperty budget = new SimpleStringProperty();
    private SimpleStringProperty actual = new SimpleStringProperty();
    private SimpleStringProperty difference = new SimpleStringProperty();

    public Bill(String name, String due, String budget, String actual, String difference) {

        setName(name);
        setDue(due);
        setBudget(budget);
        setActual(actual);
        setDifference(difference);

    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDue() {
        return due.get();
    }

    public SimpleStringProperty dueProperty() {
        return due;
    }

    public void setDue(String due) {
        this.due.set(due);
    }

    public String getBudget() {
        return budget.get();
    }

    public SimpleStringProperty budgetProperty() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget.set(budget);
    }

    public String getActual() {
        return actual.get();
    }

    public SimpleStringProperty actualProperty() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual.set(actual);
    }

    public String getDifference() {
        return difference.get();
    }

    public SimpleStringProperty differenceProperty() {
        return difference;
    }

    public void setDifference(String difference) {
        this.difference.set(difference);
    }
}