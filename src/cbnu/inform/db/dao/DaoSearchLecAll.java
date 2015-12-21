package cbnu.inform.db.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cbnu.inform.db.model.LectureData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DaoSearchLecAll {
	public static ObservableList<LectureData> searchLecAll() {
		ObservableList<LectureData> lecDataList = FXCollections.observableArrayList();

		Connection dbConnection = DaoDBConnection.tryConnect();

		Statement stmt = null;
		ResultSet result = null;

		try {
			stmt = dbConnection.createStatement();
			result = stmt.executeQuery("select * from classinfo.lecture ");

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
