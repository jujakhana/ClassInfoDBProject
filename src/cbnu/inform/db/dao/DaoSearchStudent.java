package cbnu.inform.db.dao;


import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cbnu.inform.db.model.StudentData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DaoSearchStudent {

	public static ObservableList<StudentData> searchStudentDao(String s, String value) {
		Connection dbConnection = DaoDBConnection.tryConnect();
		ObservableList<StudentData> stDataList = FXCollections.observableArrayList();
		
		Statement stmt = null;
		ResultSet result = null;

		String select;

		try {
			stmt = dbConnection.createStatement();
			result = stmt.executeQuery("select * from classinfo.student where idNumber = " + Integer.parseInt(value));
	
			while(result.next())
			{
				StudentData studentData = new StudentData();
				
				studentData.setStudentName(result.getString("name"));
				studentData.setStudentNumber(result.getInt("idNumber"));
				studentData.setStudentMajor(result.getString("major"));
				studentData.setStudentGrade(result.getInt("grade"));
				studentData.setStudentCollage(result.getString("collage"));

				stDataList.add(studentData);
			}
		} catch (SQLException e)
		{
			System.out.println("q f" + e.getMessage() + " / " + e.getSQLState() + " / " + e.getErrorCode());
			return null;
		}

		System.out.println(stDataList.size());
		return stDataList;

	}

	private static String toLatin1(String str) throws UnsupportedEncodingException {

		return new String(str.getBytes(""), "8859_1");
	}
}
