package kosten_app.model.table.saving;


import javafx.beans.property.SimpleStringProperty;

public class Saving {

    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty budget = new SimpleStringProperty();
    private SimpleStringProperty actual = new SimpleStringProperty();
    private SimpleStringProperty difference = new SimpleStringProperty();

    public Saving(String name, String budget, String actual, String difference) {

        setName(name);
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

    public String getSavingBack(char separator){
        return this.getName() + separator
                + this.getBudget()+ separator
                + this.getActual() + separator
                + this.getDifference();
    }
}