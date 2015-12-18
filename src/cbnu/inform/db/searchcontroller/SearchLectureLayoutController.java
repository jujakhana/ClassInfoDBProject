package cbnu.inform.db.searchcontroller;

import cbnu.inform.db.model.LectureData;
import cbnu.inform.db.model.ProfessorData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SearchLectureLayoutController {

	@FXML
	TableView<LectureData> lectureTableView;
	
	@FXML
	TableColumn<LectureData, Integer> lectureNumberColumn;
	
	@FXML
	TableColumn<LectureData, String> lectureNameColumn;
	
	@FXML
	TableColumn<LectureData, String> lectureMajorColumn;
	
	@FXML
	TableColumn<LectureData, String> lectureCollegeColumn;
	
	private ObservableList<LectureData> lectureData = FXCollections.observableArrayList();
	
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
	private void initialize(){
		lectureNumberColumn.setCellValueFactory(cell -> cell.getValue().lectureNumberProperty().asObject());
		lectureNameColumn.setCellValueFactory(cell -> cell.getValue().lectureNameProperty());
		lectureMajorColumn.setCellValueFactory(cell -> cell.getValue().lectureMajorProperty());
		lectureCollegeColumn.setCellValueFactory(cell -> cell.getValue().lectureMajorProperty());
	}
	
	public void setProfessorTable(ProfessorData data){
		
	}
	
}
