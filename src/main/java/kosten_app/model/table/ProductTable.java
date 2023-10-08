package kosten_app.model.table;

import javafx.css.PseudoClass;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class ProductTable {
    private TableView <Product> table = new TableView<>();


    TableColumn<Product, String> name_column = new TableColumn<>("Name");
    TableColumn<Product, String> revenue_column = new TableColumn<>("Revenue");
    TableColumn<Product, String> outgoings_column = new TableColumn<>("Outgoings");
    TableColumn<Product, String> price_column = new TableColumn<>("Price");


    public ProductTable(){
        name_column.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        revenue_column.setCellValueFactory(cellData -> cellData.getValue().revenueProperty());
        outgoings_column.setCellValueFactory(cellData -> cellData.getValue().outgoingsProperty());
        price_column.setCellValueFactory(cellData -> cellData.getValue().priceProperty());


        name_column.setCellFactory(TextFieldTableCell.forTableColumn());
        revenue_column.setCellFactory(TextFieldTableCell.forTableColumn());
        outgoings_column.setCellFactory(TextFieldTableCell.forTableColumn());
        price_column.setCellFactory(TextFieldTableCell.forTableColumn());
        table.setEditable(true);

        name_column.setOnEditCommit(event -> {
            Product product = event.getRowValue();
            if (event.getTableColumn() == name_column) {
                product.setName(event.getNewValue());
            } else if (event.getTableColumn() == outgoings_column) {
                product.setOutgoings(event.getNewValue());
            }  else if (event.getTableColumn() == revenue_column) {
                product.setRevenue(event.getNewValue());
            } else if (event.getTableColumn() == price_column) {
                product.setPrice(event.getNewValue());
            }
        });
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

    public TableColumn<Product, String> getRevenue_column() {
        return revenue_column;
    }

    public void setRevenue_column(TableColumn<Product, String> revenue_column) {
        this.revenue_column = revenue_column;
    }

    public TableColumn<Product, String> getOutgoings_column() {
        return outgoings_column;
    }

    public void setOutgoings_column(TableColumn<Product, String> outgoings_column) {
        this.outgoings_column = outgoings_column;
    }

    public TableColumn<Product, String> getPrice_column() {
        return price_column;
    }

    public void setPrice_column(TableColumn<Product, String> price_column) {
        this.price_column = price_column;
    }
}
