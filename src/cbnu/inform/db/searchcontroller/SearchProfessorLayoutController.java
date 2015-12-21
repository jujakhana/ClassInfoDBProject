package cbnu.inform.db.searchcontroller;

import cbnu.inform.db.model.ProfessorData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SearchProfessorLayoutController {

	@FXML
	private TableView<ProfessorData> professorTableView;

	@FXML
	private TableColumn<ProfessorData, String> professorNameColumn;

	@FXML
	private TableColumn<ProfessorData, Integer> professorNumberColumn;

	@FXML
	private TableColumn<ProfessorData, String> professorMajorColumn;

	@FXML
	private TableColumn<ProfessorData, String> professorDivisionColumn;

	private ObservableList<ProfessorData> professorData = FXCollections.observableArrayList();

	private SearchLayoutController controller;

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		professorNameColumn.setCellValueFactory(cellData -> cellData.getValue().professorNameProperty());
		professorNumberColumn.setCellValueFactory(cellData -> cellData.getValue().professorNumberProperty().asObject());
		professorMajorColumn.setCellValueFactory(cellData -> cellData.getValue().professorMajorProperty());
		professorDivisionColumn.setCellValueFactory(cellData -> cellData.getValue().professorDivisionProperty());
	}

	public void setSearchLayoutController(SearchLayoutController ctl) {
		this.controller = ctl;
		professorTableView.setItems(controller.getProfessorData());
	}

}
