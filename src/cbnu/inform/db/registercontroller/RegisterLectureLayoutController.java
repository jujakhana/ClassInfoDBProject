package cbnu.inform.db.registercontroller;

import java.io.IOException;

import cbnu.inform.db.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
		if(isInputValid()){
			lectureNumber = lectureNumberTextField.getText();
			lectureName = lectureNameTextField.getText();
			lectureMajor = lectureMajorTextField.getText();
			lectureCollege = lectureCollegeTextField.getText();	
		}
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
	
	private boolean isInputValid() {
        String errorMessage = "";

        if (lectureNumberTextField.getText() == null || lectureNumberTextField.getText().length() == 0) {
            errorMessage += "교과번호가 유효하지 않습니다.\n"; 
        }else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(lectureNumberTextField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "교과번호이 유효하지 않습니다(숫자 입력)!\n"; 
            }
        }
        if (lectureNameTextField.getText() == null || lectureNameTextField.getText().length() == 0) {
            errorMessage += "교과목명이 유효하지 않습니다.\n"; 
        }
        if (lectureMajorTextField.getText() == null || lectureMajorTextField.getText().length() == 0) {
            errorMessage += "관리학과가 유효하지 않습니다.\n"; 
        }
        if (lectureCollegeTextField.getText() == null || lectureCollegeTextField.getText().length() == 0) {
            errorMessage += "관리대학이 유효하지 않습니다.\n"; 
        }
    

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("데이터 입력 오류");
            alert.setHeaderText("정확한 정보를 입력해 주세요.");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
