package kosten_app.model.table.income;


import javafx.beans.property.SimpleStringProperty;

public class Income {

    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty payday = new SimpleStringProperty();
    private SimpleStringProperty expected = new SimpleStringProperty();
    private SimpleStringProperty actual = new SimpleStringProperty();

    public Income(String name, String payday, String actual, String expected) {

        setName(name);
        setPayday(payday);
        setActual(actual);
        setExpected(expected);

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

    public String getPayday() {
        return payday.get();
    }

    public SimpleStringProperty paydayProperty() {
        return payday;
    }

    public void setPayday(String payday) {
        this.payday.set(payday);
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

    public String getExpected() {
        return expected.get();
    }

    public SimpleStringProperty expectedProperty() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected.set(expected);
    }

    public String getIncomeBack(char separator){
        return this.getName() + separator
                + this.getPayday()+ separator
                + this.getExpected() + separator
                + this.getActual();
    }
}