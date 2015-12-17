package cbnu.inform.db.registercontroller;

import java.io.IOException;

import cbnu.inform.db.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class RegisterProfessorLayoutController implements IRegisterLayout {

	
	@FXML
	TextField professorNumberTextField;
	
	@FXML
	TextField professorNameTextField;
	
	@FXML
	TextField professorMajorTextField;
	
	@FXML
	TextField professorDivisionTextField;
	
	@FXML
	Button registerButton;
	
	private String professorNumber;
	private String professorName;
	private String professorMajor;
	private String professorDivision;
	
	/**
	 * Called when the user clicks on the register button
	 */
	@FXML
	private void handleRegisterButton(){
		professorNumber = professorNumberTextField.getText();
		professorName = professorNameTextField.getText();
		professorMajor = professorMajorTextField.getText();
		professorDivision = professorDivisionTextField.getText();
	}
	
	@Override
	public void setView(SplitPane pane) {
		// TODO Auto-generated method stub
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RegisterProfessorLayout.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();
			pane.getItems().set(1, anchorPane);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
