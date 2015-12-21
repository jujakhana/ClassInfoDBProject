package cbnu.inform.db.log;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class InvalidDataCheck {

	/**
	 * Constructor
	 */
	public InvalidDataCheck() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * check inputdata is string
	 * 
	 * @param check
	 * @param inputData
	 * @return
	 */
	public static boolean isStringValid(String check, String inputData) {
		String errorMessage = "";

		if (inputData == null || inputData.length() == 0) {
			errorMessage += "No valid : " + check + "\n";
		}

		if (errorMessage.length() == 0)
			return true;

		errorMessage(errorMessage);
		return false;
	}

	/**
	 * 
	 * @param check
	 * @param inputData
	 * @return
	 */
	public static boolean isIntegerValid(String check, String inputData) {
		String errorMessage = "";

		if (inputData == null || inputData.length() == 0) {
			errorMessage = check + ": �����͸� �Է��� �ּ���.\n";
		} else {
			try {
				Integer.parseInt(inputData);
			} catch (NumberFormatException e) {
				errorMessage = check + " : " + inputData + "\n(���Ŀ� ���� �ʽ��ϴ�.)\n";
			}
		}

		if (errorMessage.length() == 0)
			return true;

		errorMessage(errorMessage);
		return false;
	}

	/**
	 * 
	 * @param error
	 */
	private static void errorMessage(String error) {
		// Show the error message.
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("��ȿ���� ���� ������");
		alert.setHeaderText("�ùٸ� �����͸� �Է����ּ���.");
		alert.setContentText(error);

		alert.showAndWait();
	}
}
