package kosten_app.model.table.bill;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

public class BillTable {
    private TableView <Bill> table = new TableView<>();


    TableColumn<Bill, String> name_column = new TableColumn<>("Name");
    TableColumn<Bill, String> due_column = new TableColumn<>("Due");
    TableColumn<Bill, String> budget_column = new TableColumn<>("Budget");
    TableColumn<Bill, String> actual_column = new TableColumn<>("Actual");
    TableColumn<Bill, String> difference_column = new TableColumn<>("Difference");


    public BillTable(){
        name_column.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        due_column.setCellValueFactory(cellData -> cellData.getValue().dueProperty());
        budget_column.setCellValueFactory(cellData -> cellData.getValue().budgetProperty());
        actual_column.setCellValueFactory(cellData -> cellData.getValue().actualProperty());
        difference_column.setCellValueFactory(cellData -> cellData.getValue().actualProperty());


        name_column.setCellFactory(TextFieldTableCell.forTableColumn());
        due_column.setCellFactory(TextFieldTableCell.forTableColumn());
        budget_column.setCellFactory(TextFieldTableCell.forTableColumn());
        actual_column.setCellFactory(TextFieldTableCell.forTableColumn());
        difference_column.setCellFactory(TextFieldTableCell.forTableColumn());

        table.setEditable(true);

        name_column.setOnEditCommit(event -> {
            Bill bill = event.getRowValue();
            if (event.getTableColumn() == name_column) {
                bill.setName(event.getNewValue());
            } else if (event.getTableColumn() == due_column) {
                bill.setDue(event.getNewValue());
            }  else if (event.getTableColumn() == budget_column) {
                bill.setBudget(event.getNewValue());
            } else if (event.getTableColumn() == actual_column) {
                bill.setActual(event.getNewValue());
            } else if (event.getTableColumn() == difference_column) {
                bill.setDifference(event.getNewValue());
            }
        });
    }

    public TableView<Bill> getTable() {
        return table;
    }

    public void setTable(TableView<Bill> table) {
        this.table = table;
    }

    public TableColumn<Bill, String> getName_column() {
        return name_column;
    }

    public void setName_column(TableColumn<Bill, String> name_column) {
        this.name_column = name_column;
    }

    public TableColumn<Bill, String> getDue_column() {
        return due_column;
    }

    public void setDue_column(TableColumn<Bill, String> due_column) {
        this.due_column = due_column;
    }

    public TableColumn<Bill, String> getBudget_column() {
        return budget_column;
    }

    public void setBudget_column(TableColumn<Bill, String> budget_column) {
        this.budget_column = budget_column;
    }

    public TableColumn<Bill, String> getActual_column() {
        return actual_column;
    }

    public void setActual_column(TableColumn<Bill, String> actual_column) {
        this.actual_column = actual_column;
    }

    public TableColumn<Bill, String> getDifference_column() {
        return difference_column;
    }

    public void setDifference_column(TableColumn<Bill, String> difference_column) {
        this.difference_column = difference_column;
    }
}
