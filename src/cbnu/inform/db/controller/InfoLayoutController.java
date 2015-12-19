package cbnu.inform.db.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import cbnu.inform.db.model.InfoData;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class InfoLayoutController {

	@FXML
	CheckBox allSelected;
	@FXML
	CheckBox studentNameBox;
	@FXML
	CheckBox studentNumberBox;
	@FXML
	CheckBox majorBox;
	@FXML
	CheckBox gradeBox;
	@FXML
	CheckBox collegeBox;
	@FXML
	CheckBox lectureBox;
	@FXML
	CheckBox lectureNumberBox;
	@FXML
	CheckBox professorBox;
	@FXML
	CheckBox lectureTimeBox;
	@FXML
	CheckBox lecturePerson;
	@FXML
	CheckBox lectureLimit;
	@FXML
	Button infoButton;

	@FXML
	TableView<InfoData> infoTableView;
	@FXML
	TableColumn<InfoData, String> studentNameColumn;
	@FXML
	TableColumn<InfoData, Integer> studentNumberColumn;
	@FXML
	TableColumn<InfoData, String> majorColumn;
	@FXML
	TableColumn<InfoData, Integer> gradeColumn;
	@FXML
	TableColumn<InfoData, String> collegeColumn;
	@FXML
	TableColumn<InfoData, String> lectureColumn;
	@FXML
	TableColumn<InfoData, Integer> lectureNumberColumn;
	@FXML
	TableColumn<InfoData, String> professorColumn;
	@FXML
	TableColumn<InfoData, String> lectureTimeColumn;

	ObservableList<InfoData> infoData = FXCollections.observableArrayList();

	List<Boolean> checkStatus = new ArrayList<Boolean>();
	List<TableColumn> listTableColumn = new ArrayList<TableColumn>();

	public InfoLayoutController() {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < 9; i++) {
			checkStatus.add(i, false);
		}
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		setVisiableAllColumn(false);

		listTableColumn.add(0, studentNameColumn);
		listTableColumn.add(1, studentNumberColumn);
		listTableColumn.add(2, majorColumn);
		listTableColumn.add(3, gradeColumn);
		listTableColumn.add(4, collegeColumn);
		listTableColumn.add(5, lectureColumn);
		listTableColumn.add(6, lectureNumberColumn);
		listTableColumn.add(7, professorColumn);
		listTableColumn.add(8, lectureTimeColumn);

		/*
		//data column initialize
		studentNameColumn.setCellValueFactory(cell -> cell.getValue().studentNameProperty());
		studentNumberColumn.setCellValueFactory(cell -> cell.getValue().studentNumberProperty().asObject());
		majorColumn.setCellValueFactory(cell -> cell.getValue().majorProperty());
		gradeColumn.setCellValueFactory(cell -> cell.getValue().gradeProperty().asObject());
		collegeColumn.setCellValueFactory(cell -> cell.getValue().collegeProperty());
		lectureColumn.setCellValueFactory(cell -> cell.getValue().lectureProperty());
		lectureNumberColumn.setCellValueFactory(cell -> cell.getValue().lectureNumberProperty().asObject());
		professorColumn.setCellValueFactory(cell -> cell.getValue().professorProperty());
		lectureTimeColumn.setCellValueFactory(cell -> cell.getValue().lectureTimeProperty());

		 */
	}
	
	public ObservableList<InfoData> getPersonData() {
        return infoData;
    }
	
	public void setInfoData(InfoData data){
		infoData.add(data);
		
		infoTableView.setItems(infoData);
	}

	/**
	 * allSelected CheckBox Event
	 */
	@FXML
	private void pressedAllSelected() {
		if (allSelected.isSelected()) {
			setCheckBoxAllSelected(true);
		} else {
			setCheckBoxAllSelected(false);
		}
	}

	@FXML
	private void handleStudentCheckBox() {
		checkStatus.set(0, studentNameBox.isSelected());
	}

	@FXML
	private void handleStudentNumberCheckBox() {
		checkStatus.set(1, studentNumberBox.isSelected());
	}

	@FXML
	private void handleMajorCheckBox() {
		checkStatus.set(2, majorBox.isSelected());
	}

	@FXML
	private void handleGradeCheckBox() {
		checkStatus.set(3, gradeBox.isSelected());
	}

	@FXML
	private void handleCollegeCheckBox() {
		checkStatus.set(4, collegeBox.isSelected());
	}

	@FXML
	private void handleLectureCheckBox() {
		checkStatus.set(5, lectureBox.isSelected());
	}

	@FXML
	private void handleLectureNumberCheckBox() {
		checkStatus.set(6, lectureNumberBox.isSelected());
	}

	@FXML
	private void handleProfessorCheckBox() {
		checkStatus.set(7, professorBox.isSelected());
	}

	@FXML
	private void handleLectureTimeCheckBox() {
		checkStatus.set(8, lectureTimeBox.isSelected());
	}

	@FXML
	private void handleLecturePersonCheckBox() {
		checkStatus.set(9, lecturePerson.isSelected());
	}

	@FXML
	private void handleLectureLimitCheckBox() {
		checkStatus.set(10, lectureLimit.isSelected());
	}

	@FXML
	private void handleClickInfoButton() {
		for (int i = 0; i < 9; i++) {
			listTableColumn.get(i).setVisible(checkStatus.get(i));
		}
	}

	private void setCheckBoxAllSelected(boolean set) {
		studentNameBox.setSelected(set);
		studentNumberBox.setSelected(set);
		majorBox.setSelected(set);
		gradeBox.setSelected(set);
		collegeBox.setSelected(set);
		lectureBox.setSelected(set);
		lectureNumberBox.setSelected(set);
		professorBox.setSelected(set);
		lectureTimeBox.setSelected(set);
		for (int i = 0; i < 9; i++) {
			checkStatus.set(i, set);
		}
	}

	private void setVisiableAllColumn(boolean set) {
		studentNameColumn.setVisible(set);
		studentNumberColumn.setVisible(set);
		majorColumn.setVisible(set);
		gradeColumn.setVisible(set);
		collegeColumn.setVisible(set);
		lectureColumn.setVisible(set);
		lectureNumberColumn.setVisible(set);
		professorColumn.setVisible(set);
		lectureTimeColumn.setVisible(set);

		for (int i = 0; i < 9; i++) {
			checkStatus.set(i, set);
		}
	}
}
