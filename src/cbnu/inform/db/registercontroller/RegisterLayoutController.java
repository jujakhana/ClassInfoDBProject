package cbnu.inform.db.registercontroller;

import cbnu.inform.db.controller.MainOverviewController;
import cbnu.inform.db.model.RegisterData;
import javafx.fxml.FXML;

import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * Controll RegisterApllyLayout
 */
public class RegisterLayoutController {

	@FXML
	SplitPane splitPane;

	@FXML
	private TableView<RegisterData> regListTable;

	@FXML
	private TableColumn<RegisterData, String> regListColumn;

	@FXML
	private AnchorPane registerAnchorPane;

	private MainOverviewController mainOverviewController;
	private RegisterStudentLayoutController studentController;
	private RegisterLectureLayoutController lectureController;
	private RegisterProfessorLayoutController professorController;
	private RegisterClassLayoutController classController;
	private RegisterApplyLayoutController applyController;

	/**
	 * The constructor The constructor is called before the initialize() method.
	 */
	public RegisterLayoutController() {
		studentController = new RegisterStudentLayoutController();
		lectureController = new RegisterLectureLayoutController();
		professorController = new RegisterProfessorLayoutController();
		classController = new RegisterClassLayoutController();
		applyController = new RegisterApplyLayoutController();
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Initialize the RegisterData List
		regListColumn.setCellValueFactory(cellData -> cellData.getValue().regListProperty());

		regListTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showRegisterLayoutDetails(newValue));
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 */
	public void setRegisterLayout(MainOverviewController mainOverviewController) {
		this.mainOverviewController = mainOverviewController;

		regListTable.setItems(mainOverviewController.getRegisterData());
	}

	private void showRegisterLayoutDetails(RegisterData reg) {

		System.out.println(reg.getRegList());

		if (reg.getRegList().equals("학생등록")) {
			studentController.setView(splitPane);
		} else if (reg.getRegList().equals("과목등록")) {
			lectureController.setView(splitPane);
		} else if (reg.getRegList().equals("교수등록")) {
			professorController.setView(splitPane);
		} else if (reg.getRegList().equals("수강신청")) {
			classController.setView(splitPane);
		} else if (reg.getRegList().equals("강좌등록")) {
			applyController.setView(splitPane);
		}

	}

}
