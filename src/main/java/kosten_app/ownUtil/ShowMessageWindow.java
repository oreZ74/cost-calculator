package kosten_app.ownUtil;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ShowMessageWindow {
	
	private AlertType alertType;
	private String title;
	private String message;
	
	public ShowMessageWindow(AlertType alertType, String title, String message){
		this.alertType = alertType;
		this.title = title;
		this.message = message;
		if(message == null || "".equals(message)){
			this.message = "The message doesn't exist.";
		}
	}

    public void zeigeMeldungsfensterAn(){
    	Alert alert = new Alert(alertType);
	    alert.setTitle(this.title);
	    alert.setContentText(this.message);
	    alert.showAndWait();
    }   

}
