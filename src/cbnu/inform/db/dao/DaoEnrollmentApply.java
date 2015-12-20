package cbnu.inform.db.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Statement;

import cbnu.inform.db.model.ApplyData;

public class DaoEnrollmentApply {

	public static boolean applyEnrollDao(ApplyData applyData) {
		Connection dbConnection = null;
		dbConnection = DaoDBConnection.tryConnect();

		Statement stmt = null;

		try {
			stmt = dbConnection.createStatement();
			int rowCnt = stmt.executeUpdate(
					"insert into classinfo.apply(pName,pNum,pLecName,pLecNum,classTime,classCredit) values('"
							+ toLatin1(applyData.getProfessorName()) + "' ," + applyData.getProfessorNumber() + ",'"
							+ toLatin1(applyData.getLectureName()) + "' ," + applyData.getLectureNumber() + " ,'"
							+ toLatin1(applyData.getClassTime()) + "' ," + applyData.getClassCredit() + ")");
		
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

		return new String(str.getBytes(), "utf8");
	}
}