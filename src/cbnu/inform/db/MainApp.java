package cbnu.inform.db;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("ClassInfoDBProject_ÀÌ´Ù¿¹");

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
			
			FXMLLoader cloader = new FXMLLoader();
			cloader.setLocation(MainApp.class.getResource("view/RegisterMainLayout.fxml"));
			AnchorPane cpane = (AnchorPane) cloader.load();
			
			TabPane tpan = (TabPane)mainOverview.getChildren().get(0);
			Tab tab = tpan.getTabs().get(0);
			SplitPane spane = (SplitPane)tab.getContent();
			AnchorPane ppane = (AnchorPane)spane.getItems().get(1);
			
			//spane.getItems().set(1, cpane);
			//(AnchorPane)spane.getItems().get(1) = cpane;
		
			spane.getItems().set(1, cpane);
			ppane.resize(primaryStage.getWidth(), primaryStage.getHeight());
			rootLayout.setCenter(mainOverview);
			
			System.out.println(ppane.getId());
			
			
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
