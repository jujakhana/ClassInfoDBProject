package cbnu.inform.db.registercontroller;

import java.io.IOException;

import cbnu.inform.db.MainApp;
import cbnu.inform.db.log.AlertDialog;
import cbnu.inform.db.dao.DaoEnrollmentLecture;
import cbnu.inform.db.model.LectureData;
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
	
	/**
	 * Called when the user clicks on the register button
	 */
	@FXML
	private void handleRegisterButton(){
		LectureData lecture = new LectureData();
		if(isInputValid()){
			lecture.setLectureName(lectureNameTextField.getText());
			lecture.setLectureNumber(Integer.parseInt(lectureNumberTextField.getText()));
			lecture.setLectureMajor(lectureMajorTextField.getText());
			lecture.setLectureCollege(lectureCollegeTextField.getText());
			
			//DB�� ������ �Ѱ��ָ� �Ǵ� ��
			DaoEnrollmentLecture.lecEnrollDao(lecture);
			
		}
	}
	
	private void setAllTextFieldClear()
	{
		lectureNameTextField.clear();
		lectureNumberTextField.clear();
		lectureMajorTextField.clear();
		lectureCollegeTextField.clear();
		AlertDialog.showAlert("������", "����� �Ϸ�Ǿ����ϴ�.");	
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
            errorMessage += "������ȣ�� ��ȿ���� �ʽ��ϴ�.\n"; 
        }else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(lectureNumberTextField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "������ȣ�� ��ȿ���� �ʽ��ϴ�(���� �Է�)!\n"; 
            }
        }
        if (lectureNameTextField.getText() == null || lectureNameTextField.getText().length() == 0) {
            errorMessage += "��������� ��ȿ���� �ʽ��ϴ�.\n"; 
        }
        if (lectureMajorTextField.getText() == null || lectureMajorTextField.getText().length() == 0) {
            errorMessage += "�����а��� ��ȿ���� �ʽ��ϴ�.\n"; 
        }
        if (lectureCollegeTextField.getText() == null || lectureCollegeTextField.getText().length() == 0) {
            errorMessage += "���������� ��ȿ���� �ʽ��ϴ�.\n"; 
        }
    

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("������ �Է� ����");
            alert.setHeaderText("��Ȯ�� ������ �Է��� �ּ���.");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
