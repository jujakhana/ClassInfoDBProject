package cbnu.inform.db.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cbnu.inform.db.model.ProfessorData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DaoSearchProfessor {

	public static ObservableList<ProfessorData> searchProfessorDao(String s, String value){
		
		ObservableList<ProfessorData> proDataList = FXCollections.observableArrayList();
		ProfessorData proData = new ProfessorData();
		
		Connection dbConnection  = DaoDBConnection.tryConnect();
		
		Statement stmt =null;
		ResultSet result =null;
		
		String select ;
		
		try{	
			stmt = dbConnection.createStatement();

			switch (s)
			{
			case "교수명" :
				select = "name";				
				result = stmt.executeQuery("select * from classinfo.student where " 
						+  select +" = '" + value + "')");
				break;
			case "교수번호" :
				select = "idNumber";
				result = stmt.executeQuery("select * from classinfo.student where " 
						+  select +" = " + Integer.parseInt(value) + ")");
				break;
			case "소속학과" :
				select = "major";
				result = stmt.executeQuery("select * from classinfo.student where " 
						+  select +" = '" + value + "')");
				break;
			case "구분" :
				select = "division";
				result = stmt.executeQuery("select * from classinfo.student where " 
						+  select +" = '" + value + "')");
				break;
				
			}
		
			while(result.next()){
				proData.setProfessorName(result.getString("name"));
				proData.setProfessorNumber(result.getInt("idNumber"));
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
