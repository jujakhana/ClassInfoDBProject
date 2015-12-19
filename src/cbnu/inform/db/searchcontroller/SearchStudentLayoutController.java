package cbnu.inform.db.searchcontroller;

import java.io.IOException;

import cbnu.inform.db.MainApp;
import cbnu.inform.db.model.ProfessorData;
import cbnu.inform.db.model.StudentData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class SearchStudentLayoutController {
	
	@FXML
	private TableView<StudentData> studentTable;
	
	@FXML
	private TableColumn<StudentData, String> studentNameColumn;
	
	@FXML
	private TableColumn<StudentData, Integer> studentNumberColumn;
	
	@FXML
	private TableColumn<StudentData, String> studentMajorColumn;
	
	@FXML
	private TableColumn<StudentData, Integer> studentGradeColumn;
	
	@FXML
	private TableColumn<StudentData, String> studentCollegeColumn;
	
	private ObservableList<StudentData> studentDataList = FXCollections.observableArrayList();
	
	/**
	 * The constructor
	 */
	public SearchStudentLayoutController() {
		// TODO Auto-generated constructor stub
	}
	
	@FXML
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
	private void initialize(){
		// Initialize the person table with the five columns.
		
		studentNameColumn.setCellValueFactory(cellData -> cellData.getValue().studentNameProperty());
		studentNumberColumn.setCellValueFactory(cellData -> cellData.getValue().studentNumberProperty().asObject());
		studentMajorColumn.setCellValueFactory(cellData -> cellData.getValue().studentMajorProperty());
		studentGradeColumn.setCellValueFactory(cellData -> cellData.getValue().studentGradeProperty().asObject());
		studentCollegeColumn.setCellValueFactory(cellData -> cellData.getValue().studentCollageProperty());
	}

	public void setStudentSearchLayout(SplitPane pane) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/SearchStudentLayout.fxml"));
			AnchorPane anchorPane;
			anchorPane = (AnchorPane) loader.load();
			pane.getItems().set(1, anchorPane);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setProfessorTableView(ObservableList<StudentData> studentData){
		studentDataList = studentData;
		studentTable.setItems(studentDataList);
	}
}
