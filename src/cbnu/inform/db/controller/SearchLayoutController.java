package cbnu.inform.db.controller;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SearchLayoutController {

	@FXML
	private ComboBox<String> firstComboBox;

	@FXML
	private ComboBox<String> secondComboBox;

	@FXML
	private TextField textField;

	@FXML
	private Button searchButton;

	@FXML
	private Button allSearchButton;

	private List<String> studentList;
	private List<String> professorList;
	private List<String> lectureList;

	public SearchLayoutController() {
		// TODO Auto-generated constructor stub
		firstComboBox = new ComboBox<String>();
		secondComboBox = new ComboBox<String>();

		studentList = new ArrayList<String>() {
			{
				add("이름");
				add("학번");
				add("학과");
				add("학년");
				add("대학");
			}
		};

		professorList = new ArrayList<String>() {
			{
				add("교수명");
				add("교수번호");
				add("소속학과");
				add("구분");
			}
		};

		lectureList = new ArrayList<String>() {
			{
				add("교과번호");
				add("과목명");
				add("관련학과");
				add("관리대학");
			}
		};
	}


	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		firstComboBox.getItems().addAll(new String("학생"), new String("교수"), new String("교과"));
	}

	/**
	 * 
	 */
	@FXML
	private void setSecondComboBox() {
		secondComboBox.getItems().clear();
		
		if (firstComboBox.getSelectionModel().getSelectedItem().equals("학생"))
			secondComboBox.getItems().setAll(studentList);
		else if (firstComboBox.getSelectionModel().getSelectedItem().equals("교수"))
			secondComboBox.getItems().setAll(professorList);
		if (firstComboBox.getSelectionModel().getSelectedItem().equals("교과"))
			secondComboBox.getItems().setAll(lectureList);
	}

}
