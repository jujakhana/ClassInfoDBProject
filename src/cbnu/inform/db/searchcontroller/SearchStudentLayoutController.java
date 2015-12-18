package cbnu.inform.db.searchcontroller;

import cbnu.inform.db.model.StudentData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
	
	private ObservableList<StudentData> studentData = FXCollections.observableArrayList();
	
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
	
	public ObservableList<StudentData> getPersonData(){
		return studentData;
	}
	
	public void setSearchStudentLayout(){
		StudentData s = new StudentData();
		s.setStudentName("1");
		s.setStudentNumber(2);
		s.setStudentMajor("3");
		s.setStudentGrade(4);
		s.setStudentCollage("5");
		studentData.add(s);
		
		studentTable.setItems(studentData);
	}
	
	
}
