package cbnu.inform.db.controller;

import java.io.IOException;

import cbnu.inform.db.MainApp;
import cbnu.inform.db.model.RegisterData;
import cbnu.inform.db.registercontroller.RegisterLayoutController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

public class MainOverviewController {
	@FXML
	private TabPane tabPane;

	@FXML
	private Tab registerTab;

	@FXML
	private Tab deleteTab;

	@FXML
	private Tab searchTab;

	@FXML
	private Tab infoTab;

	private ObservableList<RegisterData> regList = FXCollections.observableArrayList();
	private AnchorPane Layout;

	public MainOverviewController() {
		// add some initial data
		regList.add(new RegisterData("학생등록"));
		regList.add(new RegisterData("과목등록"));
		regList.add(new RegisterData("교수등록"));
		regList.add(new RegisterData("수강신청"));
		regList.add(new RegisterData("강좌등록"));
	}

	/**
	 * Returns the data as an observable list of Persons.
	 * 
	 * @return
	 */
	public ObservableList<RegisterData> getRegisterData() {
		return regList;
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Initialize the MainOverview
		showRegisterLayout();
		showDeletelayout();
		showSearchLayout();
		showInfoLayout();
	}

	private void showRegisterLayout() {
		try {
			FXMLLoader regLoader = new FXMLLoader();
			regLoader.setLocation(MainApp.class.getResource("view/RegisterLayout.fxml"));
			Layout = (AnchorPane) regLoader.load();
			registerTab.setContent(Layout);

			RegisterLayoutController controller = regLoader.getController();
			controller.setRegisterLayout(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showDeletelayout() {
		try {
			FXMLLoader deleteLoader = new FXMLLoader();
			deleteLoader.setLocation(MainApp.class.getResource("view/DeleteLayout.fxml"));
			Layout = (AnchorPane) deleteLoader.load();
			deleteTab.setContent(Layout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showSearchLayout() {
		try {
			FXMLLoader searchLoader = new FXMLLoader();
			searchLoader.setLocation(MainApp.class.getResource("view/SearchLayout.fxml"));
			Layout = (AnchorPane) searchLoader.load();
			searchTab.setContent(Layout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showInfoLayout(){
		try {
			FXMLLoader infoLoader = new FXMLLoader();
			infoLoader.setLocation(MainApp.class.getResource("view/InfoLayout.fxml"));
			Layout = (AnchorPane) infoLoader.load();
			infoTab.setContent(Layout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void setMainOverView() {

	}

}
