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

		ObservableList<StudentData> stDataList = FXCollections.observableArrayList();
		java.lang.String str = value;
		Connection dbConnection = DaoDBConnection.tryConnect();

		Statement stmt = null;
		ResultSet result = null;

		String select;

		try {
			stmt = dbConnection.createStatement();

			//if (s.equals("이름")) {
				select = "name";
				//str = toLatin1(str);
				result = stmt.executeQuery("select * from classinfo.student where " + select + " = '" + toLatin1(str)+ "';");
/*
			} else if (s.equals("학번")) {
				select = "idNumber";
				result = stmt.executeQuery(
						"select * from classinfo.student where " + select + " = " + Integer.parseInt(value) + ";");
			} else if (s.equals("교과")) {
				select = "major";
				result = stmt.executeQuery("select * from classinfo.student where " + select + " = '" + value + "';");
			} else if (s.equals("학년")) {
				select = "grade";
				result = stmt.executeQuery(
						"select * from classinfo.student where " + select + " = " + Integer.parseInt(value) + ";");
			} else if (s.equals("대학")) {
				select = "collage";
				result = stmt.executeQuery("select * from classinfo.student where " + select + " = '" + value + "';");

			}
*/
			System.out.println(result.getString("name"));

			while (result.next()) {
				StudentData stData = new StudentData();

				stData.setStudentName(result.getString("name"));
				stData.setStudentNumber(result.getInt("idNumber"));
				stData.setStudentMajor(result.getString("major"));
				stData.setStudentGrade(result.getInt("grade"));
				stData.setStudentCollage(result.getString("collage"));

				stDataList.add(stData);
			}

		} catch (SQLException e) {
			System.out.println("q f" + e.getMessage() + " / " + e.getSQLState() + " / " + e.getErrorCode());
			return null;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(stDataList.toString());
		return stDataList;
	}

	private static String toLatin1(String str) throws UnsupportedEncodingException {

		return new String(str.getBytes(), "utf8");
	}
}
