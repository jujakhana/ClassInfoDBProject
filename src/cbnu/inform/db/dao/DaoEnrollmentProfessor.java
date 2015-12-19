package cbnu.inform.db.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Statement;

import cbnu.inform.db.model.ProfessorData;

public class DaoEnrollmentProfessor {

	public static void proEnrollDao(ProfessorData proData){
		Connection dbConnection = null;
		dbConnection = DaoDBConnection.tryConnect();
		
		Statement stmt =null;
		
		try{
			stmt = dbConnection.createStatement();
			System.out.println();
			int rowCnt = stmt.executeUpdate("insert into classinfo.professor(name,idNumber,major,division) values('"
											+toLatin1(proData.getProfessorName())+"' ,"+proData.getProfessorNumber()
											+",'"+toLatin1(proData.getProfessorMajor())+"' ,"+toLatin1(proData.getProfessorDivision())+"')");
			
			
			if(rowCnt == 1)
			{
				System.out.println("입력 성공");
			}
			else{
				System.out.println("입력 실패");
			}
			
		} catch(Exception e){
			System.out.println("query fail");
				
		}
		
	}
	 private static String toLatin1(String str) throws UnsupportedEncodingException{

		    return new String(str.getBytes(), "iso-8859-1");
	 }
}
