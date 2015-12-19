package cbnu.inform.db.searchcontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cbnu.inform.db.MainApp;
import cbnu.inform.db.dao.DaoEnrollmentStudent;
import cbnu.inform.db.dao.DaoSearchProfessor;
import cbnu.inform.db.dao.DaoSearchStudent;
import cbnu.inform.db.log.InvalidDataCheck;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SearchLayoutController {

	@FXML
	private ComboBox<String> firstComboBox;

	@FXML
	private ComboBox<String> secondComboBox;

	@FXML
	private SplitPane pane;
	
	@FXML
	private TextField textField;

	SearchLectureLayoutController lectureController;
	SearchProfessorLayoutController professorContorller;
	SearchStudentLayoutController studentController;
	
	private List<String> studentList;
	private List<String> professorList;
	private List<String> lectureList;

	private String firstSelectedInfo;
	private String secondSelectedInfo;
	private String inputText;
	
	public SearchLayoutController() {
		// TODO Auto-generated constructor stub
		
		studentController = new SearchStudentLayoutController();
		lectureController = new SearchLectureLayoutController();
		professorContorller = new SearchProfessorLayoutController();
		
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

	@FXML
	private void handleSearchButton() {
		firstSelectedInfo = firstComboBox.getSelectionModel().getSelectedItem();
		secondSelectedInfo = secondComboBox.getSelectionModel().getSelectedItem();
		inputText = textField.getText();
		
		if(InvalidDataCheck.isStringValid("�˻�", firstSelectedInfo)
				&& InvalidDataCheck.isStringValid("�˻�", secondSelectedInfo)
				&& InvalidDataCheck.isStringValid("���� �Է�", inputText)){
			
			if(firstSelectedInfo.equals("�л�")){
				studentController.setStudentSearchLayout(pane);
				DaoSearchStudent.searchStudentDao("�л�", secondSelectedInfo);
			} else if(firstSelectedInfo.equals("����")){
				lectureController.setLectureSearchLayout(pane);
				DaoSearchProfessor.searchProfessorDao("����", secondSelectedInfo);
			}else if(firstSelectedInfo.equals("����")){
				professorContorller.setProfessorSearchLayout(pane);
				DaoSearchProfessor.searchProfessorDao("����", secondSelectedInfo);
			}	
		}
	}

	@FXML
	private void handleAllSearchButton() {
		firstSelectedInfo = firstComboBox.getSelectionModel().getSelectedItem();
		secondSelectedInfo = secondComboBox.getSelectionModel().getSelectedItem();
		
		if(InvalidDataCheck.isStringValid("�˻�", firstSelectedInfo))
		{
			if(firstSelectedInfo.equals("�л�")){
				studentController.setStudentSearchLayout(pane);
			} else if(firstSelectedInfo.equals("����")){
				lectureController.setLectureSearchLayout(pane);
			}else if(firstSelectedInfo.equals("����")){
				professorContorller.setProfessorSearchLayout(pane);
			}	
		}
	}


}
