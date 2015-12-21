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

			// DB 데이터 입력하는 곳

			if (DaoEnrollmentClass.classEnrollDao(classData))
				AlertDialog.showAlert("수강신청", "신청이 완료되었습니다.");
			else
				AlertDialog.showAlert("수강신청", "신청이 실패하였습니다.");
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
			errorMessage += "학생 이름이 유효하지 않습니다.\n";
		}
		if (studentNumberTextField.getText() == null || studentNumberTextField.getText().length() == 0) {
			errorMessage += "학생 학번이 유효하지 않습니다.\n";
		} else {
			// try to parse the postal code into an int.
			try {
				Integer.parseInt(studentNumberTextField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "학생 학번이 유효하지 않습니다(숫자 입력)!\n";
			}
		}

		if (lectureNameTextField.getText() == null || lectureNameTextField.getText().length() == 0) {
			errorMessage += "수강과목이 유효하지 않습니다.\n";
		}
		if (lectureNumberTextField.getText() == null || lectureNumberTextField.getText().length() == 0) {
			errorMessage += "교과번호가 유효하지 않습니다.\n";
		} else {
			// try to parse the postal code into an int.
			try {
				Integer.parseInt(lectureNumberTextField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "교과번호이 유효하지 않습니다(숫자 입력)!\n";
			}
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
