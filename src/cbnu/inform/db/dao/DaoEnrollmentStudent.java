package cbnu.inform.db.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class DaoEnrollmentStudent {

	Connection dbConnection = null;
	
	public static void stuendtEnrollDao(Connection dbConnection){
		dbConnection = DaoDBConnection.tryConnect();
		
		Scanner sc = new Scanner(System.in);

		System.out.print("name : ");
		String name = sc.next();
		System.out.print("idNumber : ");
		int idNumber = sc.nextInt();
		System.out.print("major : ");
		String major = sc.next();
		System.out.print("grade : ");
		String grade = sc.next();
		System.out.print("collage : ");
		String collage = sc.next();
		
		Statement stmt =null;
		
		try{
			stmt = dbConnection.createStatement();
			int rowCnt = stmt.executeUpdate("insert into classinfo.enrollment(name,idNumber,major,grade,collage) values('"+name+"' ,"+idNumber+","+major+"' ,"+grade+","+collage+")");
			
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
