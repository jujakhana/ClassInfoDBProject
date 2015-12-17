package cbnu.inform.db.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
	TableView infoTableView;

	private ObservableList<CheckBox> selectedCheckBoxes = FXCollections.observableArrayList();
	private ObservableList<CheckBox> unselectedCheckBoxes = FXCollections.observableArrayList();

	private IntegerBinding numCheckBoxesSelected = Bindings.size(selectedCheckBoxes);

	/**
	 * Constructor
	 */
	public InfoLayoutController() {
		// TODO Auto-generated constructor stub

	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		configureCheckBox(studentNameBox);
		configureCheckBox(studentNumberBox);
		configureCheckBox(majorBox);
		configureCheckBox(gradeBox);
		configureCheckBox(collegeBox);
		configureCheckBox(lectureBox);
		configureCheckBox(lectureNumberBox);
		configureCheckBox(professorBox);
		configureCheckBox(lectureTimeBox);
		configureCheckBox(lecturePerson);
		configureCheckBox(lectureLimit);

		infoButton.setDisable(true);

		numCheckBoxesSelected.addListener((obs, oldSelectedCount, newSelectedCount) -> {
			if (newSelectedCount.intValue() >= 1) {
				infoButton.setDisable(false);
			} else {
				infoButton.setDisable(true);
			}
		});
	}
	
	/**
	 * allSelected CheckBox Event
	 */
	@FXML
	private void pressedAllSelected() {
		if(allSelected.isSelected())
		{
			checkBoxAllSelected();
		} else {
			checkBoxAllUnSelected();
		}	
	}

	
	/**
	 * CheckBox Configuration & Event Binding
	 * @param checkBox
	 */
	private void configureCheckBox(CheckBox checkBox) {
		if (checkBox.isSelected()) {
			selectedCheckBoxes.add(checkBox);
		} else {
			unselectedCheckBoxes.add(checkBox);
		}

		checkBox.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
			if (isNowSelected) {
				unselectedCheckBoxes.remove(checkBox);
				selectedCheckBoxes.add(checkBox);
			} else {
				allSelected.setSelected(false);
				selectedCheckBoxes.remove(checkBox);
				unselectedCheckBoxes.add(checkBox);
			}
		});
	}
	
	@FXML
	private void clickInfoButton(){
		Iterator<CheckBox> it = selectedCheckBoxes.iterator();
		List<String> selectedList = new ArrayList<String>();
		infoTableView.getColumns().clear();
		while(it.hasNext())
		{
			CheckBox cb = it.next();
			selectedList.add(cb.getText());
			System.out.println(cb.getText());
			TableColumn column = new TableColumn(cb.getText());
			infoTableView.getColumns().add(column);
		}
		setInfoTableView();
	}
	
	private void setInfoTableView(){
		
	}
	
	private void checkBoxAllSelected(){
		studentNameBox.setSelected(true);
		studentNumberBox.setSelected(true);
		majorBox.setSelected(true);
		gradeBox.setSelected(true);
		collegeBox.setSelected(true);
		lectureBox.setSelected(true);
		lectureNumberBox.setSelected(true);
		professorBox.setSelected(true);
		lectureTimeBox.setSelected(true);
		lecturePerson.setSelected(true);
		lectureLimit.setSelected(true);
	}
	
	private void checkBoxAllUnSelected(){
		studentNameBox.setSelected(false);
		studentNumberBox.setSelected(false);
		majorBox.setSelected(false);
		gradeBox.setSelected(false);
		collegeBox.setSelected(false);
		lectureBox.setSelected(false);
		lectureNumberBox.setSelected(false);
		professorBox.setSelected(false);
		lectureTimeBox.setSelected(false);
		lecturePerson.setSelected(false);
		lectureLimit.setSelected(false);
	}
}
