package cbnu.inform.db.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Statement;

import cbnu.inform.db.model.ApplyData;

public class DaoEnrollmentApply {

	public static void applyEnrollDao(ApplyData applyData){
		Connection dbConnection = null;
		dbConnection = DaoDBConnection.tryConnect();
		
		Statement stmt =null;
		try{
			stmt = dbConnection.createStatement();
			int rowCnt = stmt.executeUpdate("insert into classinfo.apply(pName,pNum,lecName,lecNum,classTime,classCredit) values('"
											+toLatin1(applyData.getProfessorName())+"' ,"+applyData.getProfessorNumber()
											+",'"+toLatin1(applyData.getLectureName())+"' ,"+applyData.getLectureNumber()
											+" ,"+applyData.getClassTime()+"' ,"+applyData.getClassCredit()+")");
			
			
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