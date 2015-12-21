package cbnu.inform.db.registercontroller;

import java.io.IOException;

import cbnu.inform.db.MainApp;
import cbnu.inform.db.log.AlertDialog;
import cbnu.inform.db.dao.DaoEnrollmentClass;
import cbnu.inform.db.model.ClassData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class RegisterClassLayoutController implements IRegisterLayout {

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

	/**
	 * Called when the user clicks on the register button
	 */
	@FXML
	private void handleRegisterButton() {
		ClassData classData = new ClassData();
		if (isInputValid()) {
			classData.setStudentName(studentNameTextField.getText());
			classData.setStudentNumber(Integer.parseInt(studentNumberTextField.getText()));
			classData.setLectureNumber(Integer.parseInt(lectureNumberTextField.getText()));
			classData.setLectureName(lectureNameTextField.getText());

			// DB ������ �Է��ϴ� ��

			if (DaoEnrollmentClass.classEnrollDao(classData))
				AlertDialog.showAlert("������û", "��û�� �Ϸ�Ǿ����ϴ�.");
			else
				AlertDialog.showAlert("������û", "��û�� �����Ͽ����ϴ�.");
			setAllTextFieldClear();
		}
	}

	/**
	 * ClassView's all TextField is clear
	 */
	private void setAllTextFieldClear() {
		studentNameTextField.clear();
		studentNumberTextField.clear();
		lectureNumberTextField.clear();
		lectureNameTextField.clear();

	}

	/**
	 * Set RegisterClassLayout in SplitPane of RegisterLayout
	 */
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

	/**
	 * Validates the user input in the text fields.
	 * 
	 * @return
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (studentNameTextField.getText() == null || studentNameTextField.getText().length() == 0) {
			errorMessage += "�л� �̸��� ��ȿ���� �ʽ��ϴ�.\n";
		}
		if (studentNumberTextField.getText() == null || studentNumberTextField.getText().length() == 0) {
			errorMessage += "�л� �й��� ��ȿ���� �ʽ��ϴ�.\n";
		} else {
			// try to parse the postal code into an int.
			try {
				Integer.parseInt(studentNumberTextField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "�л� �й��� ��ȿ���� �ʽ��ϴ�(���� �Է�)!\n";
			}
		}

		if (lectureNameTextField.getText() == null || lectureNameTextField.getText().length() == 0) {
			errorMessage += "���������� ��ȿ���� �ʽ��ϴ�.\n";
		}
		if (lectureNumberTextField.getText() == null || lectureNumberTextField.getText().length() == 0) {
			errorMessage += "������ȣ�� ��ȿ���� �ʽ��ϴ�.\n";
		} else {
			// try to parse the postal code into an int.
			try {
				Integer.parseInt(lectureNumberTextField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "������ȣ�� ��ȿ���� �ʽ��ϴ�(���� �Է�)!\n";
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
