package kosten_app.gui.mainscreen;

<<<<<<< Updated upstream

import javafx.stage.Stage;
import kosten_app.model.CostModel;

// Der Controller behandelt Benutzereingaben und aktualisiert das Model und die View
public class CostController {
    private CostView view = null;
    private CostModel model = null;


    public CostController(Stage stage) {
        this.model = new CostModel();
        this.view = new CostView(this, stage, model);
=======
import javafx.stage.Stage;
import kosten_app.model.CostModel;
import kosten_app.gui.mainscreen.CostView;
import kosten_app.model.table.debt.Debt;


// Der Controller behandelt Benutzereingaben und aktualisiert das Model und die View
public class CostController {
    CostView view ;
    CostModel model;

    public CostController(Stage stage) {
        model = new CostModel();
        System.out.println("hi");
        view = new CostView(this, stage, model);
        System.out.println("hi 2");
    }
    public void hallo (){
        System.out.println(model.setListDebt());
        //System.out.println(this.view.a);
>>>>>>> Stashed changes
    }
}