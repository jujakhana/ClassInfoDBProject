package cbnu.inform.db.log;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertDialog {
	public AlertDialog() {
		// TODO Auto-generated constructor stub
	}

	public static void showAlert(String Title, String Header) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(Title);
		alert.setHeaderText(Header);

		alert.showAndWait();
	}

}
