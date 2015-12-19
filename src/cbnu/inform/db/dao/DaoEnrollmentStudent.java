package cbnu.inform.db.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Statement;

import cbnu.inform.db.log.AlertDialog;
import cbnu.inform.db.model.StudentData;

public class DaoEnrollmentStudent {

	
	public static void stuendtEnrollDao(StudentData studentData){
		Connection dbConnection = null;
		dbConnection = DaoDBConnection.tryConnect();
		
		Statement stmt =null;
		
		try{
			stmt = dbConnection.createStatement();
			int rowCnt = stmt.executeUpdate("insert into classinfo.student(name,idNumber,major,grade,collage) values('"
											+toLatin1(studentData.getStudentName())+"' ,"+studentData.getStudentNumber()
											+",'"+toLatin1(studentData.getStudentMajor())+"' ,"+studentData.getStudentGrade()+",'"+toLatin1(studentData.getStudentCollage())+"')");
			
			
			if(rowCnt == 1)
			{
				System.out.println("�Է� ����");
				
			}
			else{
				System.out.println("�Է� ����");
			}
			
		} catch(Exception e){
			System.out.println("query fail");
				
		}
		
	}
	 private static String toLatin1(String str) throws UnsupportedEncodingException{

		    return new String(str.getBytes(), "iso-8859-1");
	 }
}
