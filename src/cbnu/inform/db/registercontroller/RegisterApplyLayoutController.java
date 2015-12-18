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

public class RegisterApplyLayoutController implements IRegisterLayout {

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
	
	private boolean isInputValid() {
        String errorMessage = "";

        if (professorNameTextField.getText() == null || professorNameTextField.getText().length() == 0) {
            errorMessage += "���� �̸��� ��ȿ���� �ʽ��ϴ�.\n"; 
        }
        if (professorNumberTextField.getText() == null || professorNumberTextField.getText().length() == 0) {
            errorMessage += "���� ��ȣ�� ��ȿ���� �ʽ��ϴ�.\n"; 
        }else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(professorNumberTextField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "���� ��ȣ�� ��ȿ���� �ʽ��ϴ�(���� �Է�)!\n"; 
            }
        }
        if (lectureNameTextField.getText() == null || lectureNameTextField.getText().length() == 0) {
            errorMessage += "������ ���� ��ȿ���� �ʽ��ϴ�.\n"; 
        }
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
        if (classTimeTextField.getText() == null || classTimeTextField.getText().length() == 0) {
            errorMessage += "�����ð��� ��ȿ���� �ʽ��ϴ�.\n"; 
        }
        if (classCreditTextField.getText() == null || classCreditTextField.getText().length() == 0) {
            errorMessage += "������ ��ȿ���� �ʽ��ϴ�.\n"; 
        }else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(classCreditTextField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "������ ��ȿ���� �ʽ��ϴ�(���� �Է�)!\n"; 
            }
        }
        if (classLimitTextField.getText() == null || classLimitTextField.getText().length() == 0) {
            errorMessage += "������ ��ȿ���� �ʽ��ϴ�.\n"; 
        }else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(classLimitTextField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "������ ��ȿ���� �ʽ��ϴ�(���� �Է�)!\n"; 
            }
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
