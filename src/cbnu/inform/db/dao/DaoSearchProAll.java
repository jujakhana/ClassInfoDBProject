package cbnu.inform.db.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cbnu.inform.db.model.ProfessorData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DaoSearchProAll {
	public static ObservableList<ProfessorData> searchProAll(){
		
		Connection dbConnection  = DaoDBConnection.tryConnect();
		ObservableList<ProfessorData> proDataList = FXCollections.observableArrayList();
		
		Statement stmt =null;
		ResultSet result =null;
		
		try{	
			stmt = dbConnection.createStatement();
			result = stmt.executeQuery("select * from classinfo.professor ");
			

			while(result.next()){
				ProfessorData proData = new ProfessorData();
				
				proData.setProfessorNumber(result.getInt("idNumber"));
				proData.setProfessorName(result.getString("name"));
				proData.setProfessorMajor(result.getString("major"));
				proData.setProfessorDivision(result.getString("division"));
				
				proDataList.add(proData);
			}
		
	}catch(SQLException e){
		System.out.println("q f" + e.getMessage());
		return null;
	}
		return proDataList;
		
	}
}
