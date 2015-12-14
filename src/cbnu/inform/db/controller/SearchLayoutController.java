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
				add("�̸�");
				add("�й�");
				add("�а�");
				add("�г�");
				add("����");
			}
		};

		professorList = new ArrayList<String>() {
			{
				add("������");
				add("������ȣ");
				add("�Ҽ��а�");
				add("����");
			}
		};

		lectureList = new ArrayList<String>() {
			{
				add("������ȣ");
				add("�����");
				add("�����а�");
				add("��������");
			}
		};
	}


	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		firstComboBox.getItems().addAll(new String("�л�"), new String("����"), new String("����"));
	}

	/**
	 * 
	 */
	@FXML
	private void setSecondComboBox() {
		secondComboBox.getItems().clear();
		
		if (firstComboBox.getSelectionModel().getSelectedItem().equals("�л�"))
			secondComboBox.getItems().setAll(studentList);
		else if (firstComboBox.getSelectionModel().getSelectedItem().equals("����"))
			secondComboBox.getItems().setAll(professorList);
		if (firstComboBox.getSelectionModel().getSelectedItem().equals("����"))
			secondComboBox.getItems().setAll(lectureList);
	}

}
