package kosten_app.model.table.saving;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

public class SavingTable {
    private TableView <Saving> table = new TableView<>();


    TableColumn<Saving, String> name_column = new TableColumn<>("Name");
    TableColumn<Saving, String> budget_column = new TableColumn<>("Budget");
    TableColumn<Saving, String> actual_column = new TableColumn<>("Actual");
    TableColumn<Saving, String> difference_column = new TableColumn<>("Difference");


    public SavingTable(){
        name_column.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        budget_column.setCellValueFactory(cellData -> cellData.getValue().budgetProperty());
        actual_column.setCellValueFactory(cellData -> cellData.getValue().actualProperty());
        difference_column.setCellValueFactory(cellData -> cellData.getValue().actualProperty());


        name_column.setCellFactory(TextFieldTableCell.forTableColumn());
        budget_column.setCellFactory(TextFieldTableCell.forTableColumn());
        actual_column.setCellFactory(TextFieldTableCell.forTableColumn());
        difference_column.setCellFactory(TextFieldTableCell.forTableColumn());

        table.setEditable(true);

        name_column.setOnEditCommit(event -> {
            Saving expense = event.getRowValue();
            if (event.getTableColumn() == name_column) {
                expense.setName(event.getNewValue());
            }  else if (event.getTableColumn() == budget_column) {
                expense.setBudget(event.getNewValue());
            } else if (event.getTableColumn() == actual_column) {
                expense.setActual(event.getNewValue());
            } else if (event.getTableColumn() == difference_column) {
                expense.setDifference(event.getNewValue());
            }
        });
    }

    public TableView<Saving> getTable() {
        return table;
    }

    public void setTable(TableView<Saving> table) {
        this.table = table;
    }

    public TableColumn<Saving, String> getName_column() {
        return name_column;
    }

    public void setName_column(TableColumn<Saving, String> name_column) {
        this.name_column = name_column;
    }

    public TableColumn<Saving, String> getBudget_column() {
        return budget_column;
    }

    public void setBudget_column(TableColumn<Saving, String> budget_column) {
        this.budget_column = budget_column;
    }

    public TableColumn<Saving, String> getActual_column() {
        return actual_column;
    }

    public void setActual_column(TableColumn<Saving, String> actual_column) {
        this.actual_column = actual_column;
    }

    public TableColumn<Saving, String> getDifference_column() {
        return difference_column;
    }

    public void setDifference_column(TableColumn<Saving, String> difference_column) {
        this.difference_column = difference_column;
    }
}
