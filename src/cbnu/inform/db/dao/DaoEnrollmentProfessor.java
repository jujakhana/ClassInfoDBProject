package cbnu.inform.db.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Statement;

import cbnu.inform.db.model.ProfessorData;

public class DaoEnrollmentProfessor {

	public static boolean proEnrollDao(ProfessorData proData) {
		Connection dbConnection = null;
		dbConnection = DaoDBConnection.tryConnect();

		Statement stmt = null;

		try {
			stmt = dbConnection.createStatement();
			int rowCnt = stmt.executeUpdate("insert into classinfo.professor(name,idNumber,major,division) values('"
					+ toLatin1(proData.getProfessorName()) + "' ," + proData.getProfessorNumber() + ",'"
					+ toLatin1(proData.getProfessorMajor()) + "' ,'" + toLatin1(proData.getProfessorDivision()) + "')");

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

		return new String(str.getBytes(), "utf8");
	}
}
