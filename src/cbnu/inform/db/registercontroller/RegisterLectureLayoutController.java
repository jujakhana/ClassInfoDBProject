package cbnu.inform.db.registercontroller;

import java.io.IOException;

import cbnu.inform.db.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class RegisterLectureLayoutController implements IRegisterLayout{

	@FXML
	TextField lectureNumberTextField;
	
	@FXML
	TextField lectureNameTextField;
	
	@FXML
	TextField lectureMajorTextField;
	
	@FXML
	TextField lectureCollegeTextField;
	
	@FXML
	Button registerButton;
	
	private String lectureNumber;
	private String lectureName;
	private String lectureMajor;
	private String lectureCollege;
	
	/**
	 * Called when the user clicks on the register button
	 */
	@FXML
	private void handleRegisterButton(){
		lectureNumber = lectureNumberTextField.getText();
		lectureName = lectureNameTextField.getText();
		lectureMajor = lectureMajorTextField.getText();
		lectureCollege = lectureCollegeTextField.getText();
	}
	
	@Override
	public void setView(SplitPane pane) {
		// TODO Auto-generated method stub
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RegisterLectureLayout.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();
			pane.getItems().set(1, anchorPane);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
