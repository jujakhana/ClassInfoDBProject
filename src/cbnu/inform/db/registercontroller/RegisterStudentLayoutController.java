package cbnu.inform.db.registercontroller;

import java.io.IOException;

import cbnu.inform.db.MainApp;
import cbnu.inform.db.dao.DaoEnrollmentStudent;
import cbnu.inform.db.model.StudentData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class RegisterStudentLayoutController implements IRegisterLayout{
	
	@FXML
	private AnchorPane registerSLController;
	
	@FXML
	private TextField nameTextField;
	
	@FXML
	private TextField numberTextField;
	
	@FXML
	private TextField majorTextField;
	
	@FXML
	private TextField gradeTextField;
	
	@FXML
	private TextField collegeTextField;
	
	@FXML
	private Button registerButton;
	
	private MainApp mainApp;

	
	/**
	 * Constructor
	 */
	public RegisterStudentLayoutController(){
	}
	
	/**
	 * Initializes the controller class.
	 * This method is automatically called after the fxml file has been loaded.
	 */	
	@FXML
	private void initialize(){
		//Initialize the RegisterStudentLayoutController
		
	}
	
	/**
	 * Called when the user clicks on the register button
	 */
	@FXML
	private void handleRegisterButton(){
		StudentData studentData = new StudentData();
		if(isInputValid())
		{
			studentData.setStudentName(nameTextField.getText());
			studentData.setStudentNumber(Integer.parseInt(numberTextField.getText()));
			studentData.setStudentMajor(majorTextField.getText());
			studentData.setStudentGrade(Integer.parseInt(gradeTextField.getText()));
			studentData.setStudentCollage(collegeTextField.getText());
		
			DaoEnrollmentStudent.stuendtEnrollDao(studentData);
		}
	}

	@Override
	public void setView(SplitPane pane) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/RegisterStudentLayout.fxml"));
		try {
			AnchorPane anchorPane = (AnchorPane) loader.load();
			pane.getItems().set(1, anchorPane);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private boolean isInputValid() {
        String errorMessage = "";

        if (nameTextField.getText() == null || nameTextField.getText().length() == 0) {
            errorMessage += "�̸��� ��ȿ���� �ʽ��ϴ�.\n"; 
        }
        if (numberTextField.getText() == null || numberTextField.getText().length() == 0) {
            errorMessage += "�й��� ��ȿ���� �ʽ��ϴ�.\n"; 
        }else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(numberTextField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "�й��� ��ȿ���� �ʽ��ϴ�(���� �Է�)!\n"; 
            }
        }
        if (majorTextField.getText() == null || majorTextField.getText().length() == 0) {
            errorMessage += "�а��� ��ȿ���� �ʽ��ϴ�.\n"; 
        }
        if (gradeTextField.getText() == null || gradeTextField.getText().length() == 0) {
            errorMessage += "�г��� ��ȿ���� �ʽ��ϴ�.\n"; 
        }
        if (collegeTextField.getText() == null || collegeTextField.getText().length() == 0) {
            errorMessage += "������ ��ȿ���� �ʽ��ϴ�.\n"; 
        }
    

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("������ ����");
            alert.setHeaderText("��Ȯ�� ������ �Է��� �ּ���.");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
	
}
