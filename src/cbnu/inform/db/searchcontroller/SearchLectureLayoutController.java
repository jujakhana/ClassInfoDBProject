package cbnu.inform.db.searchcontroller;

import cbnu.inform.db.model.LectureData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SearchLectureLayoutController {

	@FXML
	private TableView<LectureData> lectureTableView;

	@FXML
	private TableColumn<LectureData, Integer> lectureNumberColumn;

	@FXML
	private TableColumn<LectureData, String> lectureNameColumn;

	@FXML
	private TableColumn<LectureData, String> lectureMajorColumn;

	@FXML
	private TableColumn<LectureData, String> lectureCollegeColumn;

	private ObservableList<LectureData> lectureDataList = FXCollections.observableArrayList();

	private SearchLayoutController controller;

	/**
	 * The constructor
	 */
	public SearchLectureLayoutController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		lectureNumberColumn.setCellValueFactory(cell -> cell.getValue().lectureNumberProperty().asObject());
		lectureNameColumn.setCellValueFactory(cell -> cell.getValue().lectureNameProperty());
		lectureMajorColumn.setCellValueFactory(cell -> cell.getValue().lectureMajorProperty());
		lectureCollegeColumn.setCellValueFactory(cell -> cell.getValue().lectureCollegeProperty());
	}

	public void setSearchLayoutController(SearchLayoutController ctl) {
		this.controller = ctl;
		lectureTableView.setItems(controller.getLectureData());
	}

}
