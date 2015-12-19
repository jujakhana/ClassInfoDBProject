package cbnu.inform.db.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import cbnu.inform.db.log.AlertDialog;
import cbnu.inform.db.model.StudentData;

public class DaoEnrollmentStudent {

	public static boolean stuendtEnrollDao(StudentData studentData) {
		Connection dbConnection = null;
		dbConnection = DaoDBConnection.tryConnect();

		Statement stmt = null;

		ResultSet result = null;
		try {
			stmt = dbConnection.createStatement();
			int rowCnt = stmt.executeUpdate("insert into classinfo.student(name,idNumber,major,grade,collage) values('"
					+ toLatin1(studentData.getStudentName()) + "' ," + studentData.getStudentNumber() + ",'"
					+ toLatin1(studentData.getStudentMajor()) + "' ," + studentData.getStudentGrade() + ",'"
					+ toLatin1(studentData.getStudentCollage()) + "')");

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

		return new String(str.getBytes(), "utf-8");
	}
}
