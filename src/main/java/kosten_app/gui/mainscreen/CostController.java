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


    public void nehmeFreizeitbadAuf(){
        try{
            this.model.setBad(new Freizeitbad(
                    view.getTxtName().getText(),
                    view.getTxtGeoeffnetVon().getText(),
                    view.getTxtGeoeffnetBis().getText(),
                    view.getTxtBeckenlaenge().getText(),
                    view.getTxtWassTemperatur().getText()));

            view.zeigeInformationsfensterAn("Das Freizeitbad wurde aufgenommen!");
        }
        catch(PlausiException exc){
            view.zeigeFehlermeldungsfensterAn(exc.getPlausiTyp() + "er ", exc.getMessage());
        }
    }

    public void zeigeFreizeitbaederAn(){
        if(this.model.getBad() != null){
            view.getTxtAnzeige().setText(this.model.getBad().gibFreizeitbadZurueck(' '));
        }
        else{
            view.zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
        }
    }


    void schreibeFreizeitbaederInDatei(String typ){
        try{
            if("csv".equals(typ)){
                model.schreibeFreizeitbaederInCsvDatei();
            }
            else{
                view.zeigeInformationsfensterAn(
                        "Noch nicht implementiert!");
            }
        }
        catch(Exception exc){
            view.zeigeFehlermeldungsfensterAn(
                    "Unbekannter Fehler beim Speichern!", "Fehler");
        }
    }
}