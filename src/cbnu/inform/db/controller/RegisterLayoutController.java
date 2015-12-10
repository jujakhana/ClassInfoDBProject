package cbnu.inform.db.controller;

import cbnu.inform.db.MainApp;
import cbnu.inform.db.model.RegisterData;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * RegisterApllyLayoutControll
 */
public class RegisterLayoutController {
	
	@FXML
	private TableView<RegisterData> regListTable;
	
	@FXML
	private TableColumn<RegisterData, String> regListColumn;
	
	private MainApp mainApp;
	
	/**
	 * The constructor
	 * The constructor is called before the initialize() method.
	 */
	public RegisterLayoutController(){
	}
		
	/**
	 * Initializes the controller class.
	 * This method is automatically called after the fxml file has been loaded.
	 */
	@FXML
	private void initialize(){
		//Initialize the RegisterData List
		regListColumn.setCellValueFactory(cellData -> cellData.getValue().regListProperty());
	}
	
	/**
	 * Is called by the main application to give a reference back to itself.
	 */
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
		
		regListTable.setItems(mainApp.getRegisterData());
	}
	
}
