package cbnu.inform.db.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Statement;

import cbnu.inform.db.model.LectureData;

public class DaoEnrollmentLecture {

	public static boolean lecEnrollDao(LectureData lecData) {
		Connection dbConnection = null;
		dbConnection = DaoDBConnection.tryConnect();

		Statement stmt = null;

		try {
			stmt = dbConnection.createStatement();
			int rowCnt = stmt.executeUpdate("insert into classinfo.lecture(name,idNumber,major,collage) values('"
					+ toLatin1(lecData.getLectureName()) + "' ," + lecData.getLectureNumber() + ",'"
					+ toLatin1(lecData.getLectureMajor()) + "' ,'" + toLatin1(lecData.getLectureCollege()) + "')");

			if (rowCnt == 1) {
				System.out.println("입력 성공");
				return true;
			} else {
				System.out.println("입력 실패");
				return false;
			}

		} catch (Exception e) {
			System.out.println("query fail");
			return false;
		}

	}

	private static String toLatin1(String str) throws UnsupportedEncodingException {

		return new String(str.getBytes(), "iso-8859-1");
	}
}
