package cbnu.inform.db.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cbnu.inform.db.model.StudentData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DaoSearchStAll {

	public static ObservableList<StudentData> searchStAll(){
		
		Connection dbConnection = DaoDBConnection.tryConnect();
		ObservableList<StudentData> stDList = FXCollections.observableArrayList();
		
		Statement stmt = null;
		ResultSet result = null;
		
		try {

			stmt = dbConnection.createStatement();
			result = stmt.executeQuery("select * from classinfo.student");
			while(result.next())
			{
				StudentData studentData = new StudentData();
				
				studentData.setStudentName(result.getString("name"));
				studentData.setStudentNumber(result.getInt("idNumber"));
				studentData.setStudentMajor(result.getString("major"));
				studentData.setStudentGrade(result.getInt("grade"));
				studentData.setStudentCollage(result.getString("collage"));

				stDList.add(studentData);
			}
		} catch (SQLException e)
		{
			System.out.println("q f" + e.getMessage() + " / " + e.getSQLState() + " / " + e.getErrorCode());
			return null;
		}
		
	
		return stDList;
	}
}
