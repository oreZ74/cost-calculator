package kosten_app.model.table.income;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

public class IncomeTable {
    private TableView <Income> table = new TableView<>();

    TableColumn<Income, String> name_column = new TableColumn<>("Name");
    TableColumn<Income, String> payday_column = new TableColumn<>("Payday");
    TableColumn<Income, String> expected_column = new TableColumn<>("Expected");
    TableColumn<Income, String> actual_column = new TableColumn<>("Actual");

    public IncomeTable(){
        name_column.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        payday_column.setCellValueFactory(cellData -> cellData.getValue().paydayProperty());
        expected_column.setCellValueFactory(cellData -> cellData.getValue().expectedProperty());
        actual_column.setCellValueFactory(cellData -> cellData.getValue().actualProperty());


        name_column.setCellFactory(TextFieldTableCell.forTableColumn());
        payday_column.setCellFactory(TextFieldTableCell.forTableColumn());
        expected_column.setCellFactory(TextFieldTableCell.forTableColumn());
        actual_column.setCellFactory(TextFieldTableCell.forTableColumn());

        table.setEditable(true);

        name_column.setOnEditCommit(event -> {
            Income income = event.getRowValue();
            if (event.getTableColumn() == name_column) {
                income.setName(event.getNewValue());
            }  else if (event.getTableColumn() == payday_column) {
                income.setPayday(event.getNewValue());
            } else if (event.getTableColumn() == expected_column) {
                income.setActual(event.getNewValue());
            } else if (event.getTableColumn() == actual_column) {
                income.setExpected(event.getNewValue());
            }
        });
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    public TableView<Income> getTable() {
        return table;
    }
    public void setTable(TableView<Income> table) {
        this.table = table;
    }


    public TableColumn<Income, String> getName_column() {
        return name_column;
    }

    public void setName_column(TableColumn<Income, String> name_column) {
        this.name_column = name_column;
    }

    public TableColumn<Income, String> getPayday_column() {
        return payday_column;
    }

    public void setPayday_column(TableColumn<Income, String> payday_column) {
        this.payday_column = payday_column;
    }

    public TableColumn<Income, String> getExpected_column() {
        return expected_column;
    }

    public void setExpected_column(TableColumn<Income, String> expected_column) {
        this.expected_column = expected_column;
    }

    public TableColumn<Income, String> getActual_column() {
        return actual_column;
    }

    public void setActual_column(TableColumn<Income, String> actual_column) {
        this.actual_column = actual_column;
    }
}
