package cbnu.inform.db.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cbnu.inform.db.model.LectureData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DaoSearchLecture {

	public static ObservableList<LectureData> searchLectureDao(String s, String value) {

		ObservableList<LectureData> lecDataList = FXCollections.observableArrayList();

		Connection dbConnection = DaoDBConnection.tryConnect();

		Statement stmt = null;
		ResultSet result = null;

		String select;

		try {
			stmt = dbConnection.createStatement();

			if (s.equals("교과번호")) {
				select = "idNumber";
				result = stmt.executeQuery(
						"select * from classinfo.lecture where " + select + " = " + Integer.parseInt(value));
			} else if (s.equals("교과명")) {
				select = "name";
				result = stmt.executeQuery("select * from classinfo.lecture where " + select + " = '" + value + "'");
			} else if (s.equals("관련학과")) {
				select = "major";
				result = stmt.executeQuery("select * from classinfo.lecture where " + select + " = '" + value + "'");
			} else if (s.equals("관리대학")) {
				select = "collage";
				result = stmt.executeQuery("select * from classinfo.lecture where " + select + " = '" + value + "'");

			}
			while (result.next()) {
				LectureData lectureData = new LectureData();
				lectureData.setLectureNumber(result.getInt("idNumber"));
				lectureData.setLectureName(result.getString("name"));
				lectureData.setLectureMajor(result.getString("major"));
				lectureData.setLectureCollege(result.getString("collage"));

				lecDataList.add(lectureData);
			}

		} catch (SQLException e) {
			System.out.println("q f" + e.getMessage());
			return null;
		}

		return lecDataList;
	}
}
