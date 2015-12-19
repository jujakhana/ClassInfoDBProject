package cbnu.inform.db.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Statement;

import cbnu.inform.db.model.ClassData;

public class DaoEnrollmentClass {

	public static boolean classEnrollDao(ClassData classData) {
		Connection dbConnection = null;
		dbConnection = DaoDBConnection.tryConnect();

		Statement stmt = null;
		try {
			stmt = dbConnection.createStatement();
			int rowCnt = stmt
					.executeUpdate("insert into classinfo.classallinfo(sName,sNumber,lecName,lecNumber) values('"
							+ toLatin1(classData.getStudentName()) + "' ," + classData.getStudentNumber() + ",'"
							+ toLatin1(classData.getLectureName()) + "' ," + classData.getLectureNumber() + ")");

			if (rowCnt == 1) {
				System.out.println("�Է� ����");
				return true;
			} else {
				System.out.println("�Է� ����");
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
