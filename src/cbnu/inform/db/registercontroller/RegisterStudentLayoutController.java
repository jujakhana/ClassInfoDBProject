package cbnu.inform.db.registercontroller;

import java.io.IOException;
import java.lang.reflect.AnnotatedArrayType;

import cbnu.inform.db.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class RegisterStudentLayoutController implements IRegisterLayout{
	
	@FXML
	private AnchorPane registerSLController;
	
	@FXML
	private TextField nameTextField;
	
	@FXML
	private TextField numberTextField;
	
	@FXML
	private TextField majorTextField;
	
	@FXML
	private TextField gradeTextField;
	
	@FXML
	private TextField collegeTextField;
	
	private MainApp mainApp;
	
	private String studentName;
	private int studentNumber;
	private String studentMajor;
	private String studentGrade;
	private String studentCollege;
	
	/**
	 * Constructor
	 */
	public RegisterStudentLayoutController(){
	}
	
	/**
	 * Initializes the controller class.
	 * This method is automatically called after the fxml file has been loaded.
	 */	
	@FXML
	private void initialize(){
		//Initialize the RegisterStudentLayoutController
		
	}
	
	/**
	 * Called when the user clicks on the delete button
	 */
	@FXML
	private void handleRegisterButton(){
		
	}

	@Override
	public void setView(SplitPane pane) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/RegisterStudentLayout.fxml"));
		try {
			AnchorPane anchorPane = (AnchorPane) loader.load();
			pane.getItems().set(1, anchorPane);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
