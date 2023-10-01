package kosten_app.model.table;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Table {
    private TableView <Product> table = new TableView<>();


    TableColumn<Product, String> name_column = new TableColumn<>("Name");
    TableColumn<Product, Double> revenue_column = new TableColumn<>("Revenue");
    TableColumn<Product, Double> outgoings_column = new TableColumn<>("Outgoings");
    TableColumn<Product, String> price_column = new TableColumn<>("Price");


    public Table(){
        name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
        revenue_column.setCellValueFactory(new PropertyValueFactory<>("revenue"));
        outgoings_column.setCellValueFactory(new PropertyValueFactory<>("outgoings"));
        price_column.setCellValueFactory(new PropertyValueFactory<>("price"));
    }



    public TableView<Product> getTable() {
        return table;
    }

    public void setTable(TableView<Product> table) {
        this.table = table;
    }

    public TableColumn<Product, String> getName_column() {
        return name_column;
    }

    public void setName_column(TableColumn<Product, String> name_column) {
        this.name_column = name_column;
    }

    public TableColumn<Product, Double> getRevenue_column() {
        return revenue_column;
    }

    public void setRevenue_column(TableColumn<Product, Double> revenue_column) {
        this.revenue_column = revenue_column;
    }

    public TableColumn<Product, Double> getOutgoings_column() {
        return outgoings_column;
    }

    public void setOutgoings_column(TableColumn<Product, Double> outgoings_column) {
        this.outgoings_column = outgoings_column;
    }

    public TableColumn<Product, String> getPrice_column() {
        return price_column;
    }

    public void setPrice_column(TableColumn<Product, String> price_column) {
        this.price_column = price_column;
    }
}
