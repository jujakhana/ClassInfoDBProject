package cbnu.inform.db.dao;

import java.sql.Connection;
import java.sql.Statement;

import cbnu.inform.db.model.InfoData;
import javafx.collections.ObservableList;

public class DaoSelectClassAll {

	public static ObservableList<InfoData> selectClassAllDao(InfoData infoData){
		Connection dbConnection = null;
		dbConnection = DaoDBConnection.tryConnect();
		
		Statement stmt =null;
		
		
		return null;
		
	}
}
