package kosten_app.model.table;

public class Product {

    private String name;
    private double revenue;
    private double outgoings;
    private String price;

    public Product(String name, double revenue, double outgoings, String price) {
        this.name = name;
        this.revenue = revenue;
        this.outgoings = outgoings;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getOutgoings() {
        return outgoings;
    }

    public void setOutgoings(double outgoings) {
        this.outgoings = outgoings;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}