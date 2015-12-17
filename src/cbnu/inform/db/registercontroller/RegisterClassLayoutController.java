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
	TextField professorNameTextField;

	@FXML
	TextField professorNumberTextField;

	@FXML
	TextField lectureNameTextField;

	@FXML
	TextField lectureNumberTextField;

	@FXML
	TextField classTimeTextField;

	@FXML
	TextField classCreditTextField;

	@FXML
	TextField classLimitTextField;

	@FXML
	Button registerButton;

	private String professorName;
	private String professorNumber;
	private String lectureName;
	private String lectureNumber;
	private String classTime;
	private String classCredit;
	private String classLimit;
	
	
	/**
	 * Called when the user clicks on the register button
	 */
	@FXML
	private void handleRegisterButton(){
		professorName = professorNameTextField.getText();
		professorNumber = professorNumberTextField.getText();
		lectureNumber = lectureNumberTextField.getText();
		lectureName = lectureNameTextField.getText();
		classTime = classTimeTextField.getText();
		classCredit = classCreditTextField.getText();
		classLimit = classLimitTextField.getText();
	}
	
	
	@Override
	public void setView(SplitPane pane) {
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
