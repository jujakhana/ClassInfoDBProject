package cbnu.inform.db.dao;

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
			// result = stmt.executeQuery("select * from classinfo.student where
			// idNumber = " + Integer.parseInt(value));
			if (s.equals("학번")) {
				select = "idNumber";
				result = stmt.executeQuery(
						"select * from classinfo.student where " + select + " = " + Integer.parseInt(value));
			} else if (s.equals("이름")) {
				select = "name";
				result = stmt.executeQuery("select * from classinfo.student where " + select + " = '" + value + "'");
			} else if (s.equals("학과")) {
				select = "major";
				result = stmt.executeQuery("select * from classinfo.student where " + select + " = '" + value + "'");

			} else if (s.equals("학년")) {
				select = "grade";
				result = stmt.executeQuery(
						"select * from classinfo.student where " + select + " = " + Integer.parseInt(value));

			} else if (s.equals("대학")) {
				select = "collage";
				result = stmt.executeQuery("select * from classinfo.student where " + select + " = '" + value + "'");
			}

			while (result.next()) {
				StudentData studentData = new StudentData();

				studentData.setStudentName(result.getString("name"));
				studentData.setStudentNumber(result.getInt("idNumber"));
				studentData.setStudentMajor(result.getString("major"));
				studentData.setStudentGrade(result.getInt("grade"));
				studentData.setStudentCollage(result.getString("collage"));

				stDataList.add(studentData);
			}
		} catch (SQLException e) {
			System.out.println("q f" + e.getMessage() + " / " + e.getSQLState() + " / " + e.getErrorCode());
			return null;
		}

		System.out.println(stDataList.size());
		return stDataList;

	}
}
