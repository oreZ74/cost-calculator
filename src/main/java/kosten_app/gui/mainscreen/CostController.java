package kosten_app.gui.mainscreen;


import javafx.stage.Stage;
import kosten_app.model.CostModel;

// Der Controller behandelt Benutzereingaben und aktualisiert das Model und die View
public class CostController {
    private CostView view = null;
    private CostModel model = null;


    public CostController(Stage stage) {
        this.model = new CostModel();
        this.view = new CostView(this, stage, model);
    }
}