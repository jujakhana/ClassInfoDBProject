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

	@FXML
	private void handleSearchButton() {
		firstSelectedInfo = firstComboBox.getSelectionModel().getSelectedItem();
		secondSelectedInfo = secondComboBox.getSelectionModel().getSelectedItem();
		inputText = textField.getText();
		
		if(InvalidDataCheck.isStringValid("검색", firstSelectedInfo)
				&& InvalidDataCheck.isStringValid("검색", secondSelectedInfo)
				&& InvalidDataCheck.isStringValid("내용 입력", inputText)){
			
			if(firstSelectedInfo.equals("학생")){
				studentController.setStudentSearchLayout(pane);
				DaoSearchStudent.searchStudentDao("학생", secondSelectedInfo);
			} else if(firstSelectedInfo.equals("교과")){
				lectureController.setLectureSearchLayout(pane);
				DaoSearchProfessor.searchProfessorDao("교과", secondSelectedInfo);
			}else if(firstSelectedInfo.equals("교수")){
				professorContorller.setProfessorSearchLayout(pane);
				DaoSearchProfessor.searchProfessorDao("교수", secondSelectedInfo);
			}	
		}
	}

	@FXML
	private void handleAllSearchButton() {
		firstSelectedInfo = firstComboBox.getSelectionModel().getSelectedItem();
		secondSelectedInfo = secondComboBox.getSelectionModel().getSelectedItem();
		
		if(InvalidDataCheck.isStringValid("검색", firstSelectedInfo))
		{
			if(firstSelectedInfo.equals("학생")){
				studentController.setStudentSearchLayout(pane);
			} else if(firstSelectedInfo.equals("교과")){
				lectureController.setLectureSearchLayout(pane);
			}else if(firstSelectedInfo.equals("교수")){
				professorContorller.setProfessorSearchLayout(pane);
			}	
		}
	}


}
