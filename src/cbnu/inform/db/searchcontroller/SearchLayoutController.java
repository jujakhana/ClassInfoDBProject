package cbnu.inform.db.searchcontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cbnu.inform.db.MainApp;
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

	private List<String> studentList;
	private List<String> professorList;
	private List<String> lectureList;

	private String firstSelectedInfo;
	private String secondSelectedInfo;
	private String inputText;
	
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

	@FXML
	private void handleSearchButton() {
		firstSelectedInfo = firstComboBox.getSelectionModel().getSelectedItem();
		secondSelectedInfo = secondComboBox.getSelectionModel().getSelectedItem();
		inputText = textField.getText();
		
		if(InvalidDataCheck.isStringValid("검색", firstSelectedInfo)
				&& InvalidDataCheck.isStringValid("검색", secondSelectedInfo)
				&& InvalidDataCheck.isStringValid("내용 입력", inputText))
		{
			if(firstSelectedInfo.equals("학생")){
				FXMLLoader loader= setStudentSearchLayout();
				SearchStudentLayoutController controller = loader.getController();
				
				controller.setSearchStudentLayout();
			} else if(firstSelectedInfo.equals("교과")){
				setLectureSearchLayout();
			}else if(firstSelectedInfo.equals("교수")){
				setProfessorSearchLayout();
			}	
		}
	}

	@FXML
	private void handleAllSearchButton() {
		firstSelectedInfo = firstComboBox.getSelectionModel().getSelectedItem();
		secondSelectedInfo = secondComboBox.getSelectionModel().getSelectedItem();
		
		//if(InvalidDataCheck.isStringValid("검색", firstSelectedInfo)
	//			&& InvalidDataCheck.isStringValid("검색", secondSelectedInfo))
		{
			if(firstSelectedInfo.equals("학생")){
				setStudentSearchLayout();
			} else if(firstSelectedInfo.equals("교과")){
				setLectureSearchLayout();
			}else if(firstSelectedInfo.equals("교수")){
				setProfessorSearchLayout();
			}	
		}
	}

	private FXMLLoader setStudentSearchLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/SearchStudentLayout.fxml"));
			AnchorPane anchorPane;
			anchorPane = (AnchorPane) loader.load();
			pane.getItems().set(1, anchorPane);
			return loader;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private void setLectureSearchLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/SearchLectureLayout.fxml"));
			AnchorPane anchorPane;
			anchorPane = (AnchorPane) loader.load();
			pane.getItems().set(1, anchorPane);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setProfessorSearchLayout() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/SearchProfessorLayout.fxml"));
			AnchorPane anchorPane;
			anchorPane = (AnchorPane) loader.load();
			pane.getItems().set(1, anchorPane);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
