package cbnu.inform.db.searchcontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cbnu.inform.db.MainApp;
import cbnu.inform.db.dao.DaoSearchLecAll;
import cbnu.inform.db.dao.DaoSearchLecture;
import cbnu.inform.db.dao.DaoSearchProAll;
import cbnu.inform.db.dao.DaoSearchProfessor;
import cbnu.inform.db.dao.DaoSearchStAll;
import cbnu.inform.db.dao.DaoSearchStudent;
import cbnu.inform.db.log.InvalidDataCheck;
import cbnu.inform.db.model.LectureData;
import cbnu.inform.db.model.ProfessorData;
import cbnu.inform.db.model.StudentData;
import javafx.collections.ObservableList;
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

	private ObservableList<StudentData> studentDataList;
	private ObservableList<LectureData> lectureDataList;
	private ObservableList<ProfessorData> professorDataList;

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

		if (InvalidDataCheck.isStringValid("�˻�", firstSelectedInfo)
				&& InvalidDataCheck.isStringValid("�˻�", secondSelectedInfo)
				&& InvalidDataCheck.isStringValid("���� �Է�", inputText)) {

			if (firstSelectedInfo.equals("�л�")) {
				studentDataList = DaoSearchStudent.searchStudentDao(secondSelectedInfo, inputText);
				setStudentSearchLayout();

				System.out.println(studentDataList.size());
			} else if (firstSelectedInfo.equals("����")) {
				lectureDataList = DaoSearchLecture.searchLectureDao(secondSelectedInfo, inputText);
				setLectureSearchLayout();

			} else if (firstSelectedInfo.equals("����")) {
				professorDataList = DaoSearchProfessor.searchProfessorDao(secondSelectedInfo, inputText);
				setProfessorSearchLayout();

			}
		}
	}

	@FXML
	private void handleAllSearchButton() {
		firstSelectedInfo = firstComboBox.getSelectionModel().getSelectedItem();
		secondSelectedInfo = secondComboBox.getSelectionModel().getSelectedItem();

		if (InvalidDataCheck.isStringValid("�˻�", firstSelectedInfo)) {
			if (firstSelectedInfo.equals("�л�")) {
				studentDataList = DaoSearchStAll.searchStAll();
				setStudentSearchLayout();

			} else if (firstSelectedInfo.equals("����")) {
				professorDataList = DaoSearchProAll.searchProAll();
				setLectureSearchLayout();
			} else if (firstSelectedInfo.equals("����")) {
				lectureDataList = DaoSearchLecAll.searchLecAll();
				setProfessorSearchLayout();
			}
		}
	}

	public ObservableList<StudentData> getStudentData() {
		return studentDataList;
	}

	public ObservableList<ProfessorData> getProfessorData() {
		return professorDataList;
	}

	public ObservableList<LectureData> getLectureData() {
		return lectureDataList;
	}

	public void setStudentSearchLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/SearchStudentLayout.fxml"));
			AnchorPane anchorPane;
			anchorPane = (AnchorPane) loader.load();
			pane.getItems().set(1, anchorPane);

			SearchStudentLayoutController controller = loader.getController();
			controller.setSearchLayoutController(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setLectureSearchLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/SearchLectureLayout.fxml"));
			AnchorPane anchorPane;
			anchorPane = (AnchorPane) loader.load();
			pane.getItems().set(1, anchorPane);

			SearchLectureLayoutController controller = loader.getController();
			controller.setSearchLayoutController(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setProfessorSearchLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/SearchProfessorLayout.fxml"));
			AnchorPane anchorPane;
			anchorPane = (AnchorPane) loader.load();

			pane.getItems().set(1, anchorPane);

			SearchProfessorLayoutController controller = loader.getController();
			controller.setSearchLayoutController(this);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
