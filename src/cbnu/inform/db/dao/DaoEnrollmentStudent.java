package cbnu.inform.db.dao;

import java.sql.Connection;
import java.sql.Statement;

import cbnu.inform.db.model.StudentData;

public class DaoEnrollmentStudent {

	
	public static void stuendtEnrollDao(StudentData studentData){
		Connection dbConnection = null;
		dbConnection = DaoDBConnection.tryConnect();
		
		Statement stmt =null;
		
		try{
			stmt = dbConnection.createStatement();
			int rowCnt = stmt.executeUpdate("insert into classinfo.enrollment(name,idNumber,major,grade,collage) values('"
											+studentData.getStudentName()+"' ,"+studentData.getStudentNumber()
											+","+studentData.getStudentMajor()+"' ,"+studentData.getStudentGrade()+","+studentData.getStudentCollage()+")");
			
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
}
