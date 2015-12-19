package cbnu.inform.db.searchcontroller;

import java.io.IOException;

import cbnu.inform.db.MainApp;
import cbnu.inform.db.model.LectureData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

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
	
	private ObservableList<LectureData> lectureDataList = FXCollections.observableArrayList();
	
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
	
	public void setLectureSearchLayout(SplitPane pane) {
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
	
	public void setLectureTableView(ObservableList<LectureData> lecture){
		lectureDataList = lecture;
		lectureTableView.setItems(lectureDataList);
	}
	
}
