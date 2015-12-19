package cbnu.inform.db.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cbnu.inform.db.model.InfoData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DaoSelectClassAll {

	public static ObservableList<InfoData> selectClassAllDao(){

		ObservableList<InfoData> infoDataList = FXCollections.observableArrayList();
		
		
		Connection dbConnection  = DaoDBConnection.tryConnect();
		
		Statement stmt =null;
		ResultSet result =null;
		
		try{
			stmt = dbConnection.createStatement();
			result = stmt.executeQuery("select  name, idNumber, major, grade, collage,pLecName,"
					+ " pLecNum, pName, classTime from classinfo.student s, "
					+ "classinfo.classallinfo c, classinfo.apply a "
					+ "where s.idNumber = c.sNumber and a.pLecNum = c.lecNumber;");
			
			while(result.next()){
				InfoData infoData = new InfoData();
				infoData.setStudentName(result.getString("name"));
				infoData.setStudentNumber(result.getInt("idNumber"));
				infoData.setMajor(result.getString("major"));
				infoData.setGrade(result.getInt("grade"));
				infoData.setCollege(result.getString("collage"));
				infoData.setLecture(result.getString("pLecName"));
				infoData.setLectureNumber(result.getInt("pLecNum"));
				infoData.setProfessor(result.getString("pName"));
				infoData.setLectureTime(result.getString("classTime"));
				
				infoDataList.add(infoData);
			}
			
		} catch(SQLException e){
			System.out.println("q f" + e.getMessage());
			return null;
		}

		
		return infoDataList;
	}
}
