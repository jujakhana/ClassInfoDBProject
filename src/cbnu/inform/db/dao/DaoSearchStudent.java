package cbnu.inform.db.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cbnu.inform.db.model.StudentData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DaoSearchStudent {
	
	public static ObservableList<StudentData> searchStudentDao(String s, String value){
		
		ObservableList<StudentData> stDataList = FXCollections.observableArrayList();
		StudentData stData = new StudentData();
		
		Connection dbConnection  = DaoDBConnection.tryConnect();
		
		Statement stmt =null;
		ResultSet result =null;
		
		String select ;
		
		try{	
			stmt = dbConnection.createStatement();

			switch (s)
			{
			case "이름" :
				select = "name";				
				result = stmt.executeQuery("select * from classinfo.student where " 
						+  select +" = '" + value + "')");
				break;
			case "학번" :
				select = "idNumber";
				result = stmt.executeQuery("select * from classinfo.student where " 
						+  select +" = " + Integer.parseInt(value) + ")");
				break;
			case "학과" :
				select = "major";
				result = stmt.executeQuery("select * from classinfo.student where " 
						+  select +" = '" + value + "')");
				break;
			case "학년" :
				select = "grade";
				result = stmt.executeQuery("select * from classinfo.student where " 
						+  select +" = " + Integer.parseInt(value) + ")");
				break;
			case "대학" :
				select = "collage";
				result = stmt.executeQuery("select * from classinfo.student where " 
						+  select +" = '" + value + "')");
				break;
				
			}
		
			while(result.next()){
				stData.setStudentName(result.getString("name"));
				stData.setStudentNumber(result.getInt("idNumber"));
				stData.setStudentMajor(result.getString("major"));
				stData.setStudentGrade(result.getInt("grade"));
				stData.setStudentCollage(result.getString("collage"));
				
				stDataList.add(stData);
			}
			
		}catch(SQLException e){
			System.out.println("q f" + e.getMessage());
			return null;
		}
		
		
		return stDataList;
	}
}
