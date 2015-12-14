package cbnu.inform.db.registercontroller;

import java.io.IOException;

import cbnu.inform.db.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class RegisterApplyLayoutController implements IRegisterLayout {

	@FXML
	TextField studentName;
	
	@FXML
	TextField studentNumber;
	
	@FXML
	TextField lectureName;
	
	@FXML
	TextField lectureNumber;
	
	@FXML
	Button registerButton;
	
	@Override
	public void setView(SplitPane pane) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RegisterApplyLayout.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();
			pane.getItems().set(1, anchorPane);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
