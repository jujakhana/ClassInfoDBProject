package cbnu.inform.db.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cbnu.inform.db.model.LectureData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DaoSearchLecture {

	public static ObservableList<LectureData> searchLectureDao(String s, String value){
		
		ObservableList<LectureData> lecDataList = FXCollections.observableArrayList();
		LectureData lecData = new LectureData();
		
		Connection dbConnection  = DaoDBConnection.tryConnect();
		
		Statement stmt =null;
		ResultSet result =null;
		
		String select ;
		
		try{	
			stmt = dbConnection.createStatement();

			switch (s)
			{
			case "������" :
				select = "name";				
				result = stmt.executeQuery("select * from classinfo.student where " 
						+  select +" = '" + value + "')");
				break;
			case "������ȣ" :
				select = "idNumber";
				result = stmt.executeQuery("select * from classinfo.student where " 
						+  select +" = " + Integer.parseInt(value) + ")");
				break;
			case "�Ҽ��а�" :
				select = "major";
				result = stmt.executeQuery("select * from classinfo.student where " 
						+  select +" = '" + value + "')");
				break;
			case "����" :
				select = "collage";
				result = stmt.executeQuery("select * from classinfo.student where " 
						+  select +" = '" + value + "')");
				break;
				
			}
		
			while(result.next()){
				lecData.setLectureName(result.getString("name"));
				lecData.setLectureNumber(result.getInt("idNumber"));
				lecData.setLectureMajor(result.getString("major"));
				lecData.setLectureCollege(result.getString("collage"));
				
				lecDataList.add(lecData);
			}
			
		}catch(SQLException e){
			System.out.println("q f" + e.getMessage());
			return null;
		}
		
		
		return lecDataList;
	}
}
