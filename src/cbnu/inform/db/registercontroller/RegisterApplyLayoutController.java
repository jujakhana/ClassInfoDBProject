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
	TextField studentNameTextField;

	@FXML
	TextField studentNumberTextField;

	@FXML
	TextField lectureNameTextField;

	@FXML
	TextField lectureNumberTextField;

	@FXML
	Button registerButton;

	private String studentName;
	private String studentNumber;
	private String lectureName;
	private String lectureNumber;

	/**
	 * Called when the user clicks on the register button
	 */
	@FXML
	private void handleRegisterButton() {

		studentName = studentNameTextField.getText();
		studentNumber = studentNumberTextField.getText();
		lectureNumber = lectureNumberTextField.getText();
		lectureName = lectureNameTextField.getText();
	}

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
