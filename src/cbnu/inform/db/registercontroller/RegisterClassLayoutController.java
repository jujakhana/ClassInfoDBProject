package cbnu.inform.db.registercontroller;

import java.io.IOException;

import cbnu.inform.db.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class RegisterClassLayoutController implements IRegisterLayout {

	
	@FXML
	TextField professorName;
	
	@FXML
	TextField professorNumber;
	
	@FXML
	TextField lectureName;
	
	@FXML
	TextField lectureNumber;
	
	@FXML
	TextField classTime;
	
	@FXML
	TextField classCredit;
	
	@FXML
	TextField classLimit;
	
	@FXML
	Button registerButton;
	
	
	@Override
	public void setView(SplitPane pane) {
		// TODO Auto-generated method stub
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RegisterClassLayout.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();
			pane.getItems().set(1, anchorPane);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
