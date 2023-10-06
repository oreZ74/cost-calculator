package kosten_app.model.table;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReciptTable {

    TableColumn<Product, String> name_column = new TableColumn<>("Name");
    TableColumn<Product, String> price_column = new TableColumn<>("Price");



    public ReciptTable() {
        name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
        price_column.setCellValueFactory(new PropertyValueFactory<>("price"));

    }

}
