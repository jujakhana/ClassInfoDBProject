package cbnu.inform.db;

import java.io.IOException;

import cbnu.inform.db.model.RegisterData;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;

	private ObservableList<RegisterData> regList = FXCollections.observableArrayList();
	
	/**
	 * Constructor
	 */
	public MainApp(){
		//add some initial data
		regList.add(new RegisterData("학생등록"));
		regList.add(new RegisterData("과목등록"));
		regList.add(new RegisterData("교수등록"));
		regList.add(new RegisterData("수강신청"));
		regList.add(new RegisterData("강좌등록"));
	}
	
	public ObservableList<RegisterData> getRegisterData(){
		return this.regList;
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("ClassInfoDBProject_이다예");

		initRootLayout();
		showMainOverview();
	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * Shows the main overview inside the center of root layout 
	 */
	public void showMainOverview() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/MainOverview.fxml"));
			AnchorPane mainOverview;		
			mainOverview = (AnchorPane) loader.load();
			
			/*
			FXMLLoader cloader = new FXMLLoader();
			cloader.setLocation(MainApp.class.getResource("view/RegisterStudentLayout.fxml"));
			AnchorPane cpane = (AnchorPane) cloader.load();
			
			TabPane tpan = (TabPane)mainOverview.getChildren().get(0);
			Tab tab = tpan.getTabs().get(0);
			SplitPane spane = (SplitPane)tab.getContent();
		
			BorderPane p = (BorderPane)spane.getItems().get(1);
			p.setCenter(cpane);
			 */
			
			rootLayout.setCenter(mainOverview);
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
	/**
	 * Returns the main stage
	 * @return
	 */
	public Stage getPrimaryStage(){
		return primaryStage;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
