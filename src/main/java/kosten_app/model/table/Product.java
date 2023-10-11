package kosten_app.model.table;


import javafx.beans.property.SimpleStringProperty;

public class Product {

    private SimpleStringProperty name = new SimpleStringProperty();;
    private SimpleStringProperty revenue = new SimpleStringProperty();;
    private SimpleStringProperty outgoings = new SimpleStringProperty();;
    private SimpleStringProperty price = new SimpleStringProperty();;

    public Product(String name, String revenue, String outgoings, String price) {
        this.name  = new SimpleStringProperty();
        this.revenue = new SimpleStringProperty();
        this.outgoings = new SimpleStringProperty();
        this.price = new SimpleStringProperty();

        setName(name);
        setRevenue(revenue);
        setOutgoings(outgoings);
        setPrice(price);
    }

    public String getName() {
        return name.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }
    public String getRevenue() {
        return revenue.get();
    }
    public void setRevenue(String revenue) {
        this.revenue.set(revenue);
    }
    public SimpleStringProperty revenueProperty() { return revenue;}

    public String getOutgoings() {
        return outgoings.get();
    }
    public void setOutgoings(String outgoings) {
        this.outgoings.set(outgoings);
    }
    public SimpleStringProperty outgoingsProperty() { return outgoings;}

    public String getPrice() {
        return price.get();
    }
    public void setPrice(String price) {
        this.price.set(price);
    }
    public SimpleStringProperty priceProperty() { return price;}

}