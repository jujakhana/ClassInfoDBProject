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
				&& InvalidDataCheck.isStringValid("���� �Է�", inputText))
		{
			if(firstSelectedInfo.equals("�л�")){
				FXMLLoader loader= setStudentSearchLayout();
				SearchStudentLayoutController controller = loader.getController();
				
				controller.setSearchStudentLayout();
			} else if(firstSelectedInfo.equals("����")){
				setLectureSearchLayout();
			}else if(firstSelectedInfo.equals("����")){
				setProfessorSearchLayout();
			}	
		}
	}

	@FXML
	private void handleAllSearchButton() {
		firstSelectedInfo = firstComboBox.getSelectionModel().getSelectedItem();
		secondSelectedInfo = secondComboBox.getSelectionModel().getSelectedItem();
		
		//if(InvalidDataCheck.isStringValid("�˻�", firstSelectedInfo)
	//			&& InvalidDataCheck.isStringValid("�˻�", secondSelectedInfo))
		{
			if(firstSelectedInfo.equals("�л�")){
				setStudentSearchLayout();
			} else if(firstSelectedInfo.equals("����")){
				setLectureSearchLayout();
			}else if(firstSelectedInfo.equals("����")){
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
