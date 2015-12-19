package cbnu.inform.db.registercontroller;

import java.io.IOException;

import cbnu.inform.db.MainApp;
import cbnu.inform.db.dao.DaoEnrollmentProfessor;
import cbnu.inform.db.log.AlertDialog;
import cbnu.inform.db.model.ProfessorData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	
	/**
	 * Called when the user clicks on the register button
	 */
	@FXML
	private void handleRegisterButton(){
		ProfessorData professor = new ProfessorData();
		if(isInputValid()){
			professor.setProfessorName(professorNameTextField.getText());
			professor.setProfessorNumber(Integer.parseInt(professorNumberTextField.getText()));
			professor.setProfessorMajor(professorMajorTextField.getText());
			professor.setProfessorDivision(professorDivisionTextField.getText());
			
			//DAO �̿��ؼ� professor�� �Ѱ��ָ� �˴ϴ�.
			DaoEnrollmentProfessor.proEnrollDao(professor);

			setAllTextFieldClear();
		}
	}
	
	private void setAllTextFieldClear()
	{
		professorNameTextField.clear();
		professorNumberTextField.clear();
		professorMajorTextField.clear();
		professorDivisionTextField.clear();
		AlertDialog.showAlert("�������", "����� �Ϸ�Ǿ����ϴ�.");	
		
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

	private boolean isInputValid() {
        String errorMessage = "";
        if (professorNameTextField.getText() == null || professorNameTextField.getText().length() == 0) {
            errorMessage += "�����̸��� ��ȿ���� �ʽ��ϴ�.\n"; 
        }
        if (professorNumberTextField.getText() == null || professorNumberTextField.getText().length() == 0) {
            errorMessage += "������ȣ�� ��ȿ���� �ʽ��ϴ�.\n"; 
        }else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(professorNumberTextField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "������ȣ�� ��ȿ���� �ʽ��ϴ�.(���� �Է�)!\n"; 
            }
        }
        if (professorMajorTextField.getText() == null || professorMajorTextField.getText().length() == 0) {
            errorMessage += "���������� ��ȿ���� �ʽ��ϴ�.\n"; 
        }
        if (professorDivisionTextField.getText() == null || professorDivisionTextField.getText().length() == 0) {
            errorMessage += "���������� ��ȿ���� �ʽ��ϴ�.\n"; 
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
