package cbnu.inform.db.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cbnu.inform.db.model.ProfessorData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DaoSearchProfessor {

	public static ObservableList<ProfessorData> searchProfessorDao(String s, String value){

		Connection dbConnection  = DaoDBConnection.tryConnect();
		ObservableList<ProfessorData> proDataList = FXCollections.observableArrayList();
		
		Statement stmt =null;
		ResultSet result =null;
		
		String select ;
		
		try{	
			stmt = dbConnection.createStatement();

			if(s.equals("������ȣ")){
				select = "idNumber";
				result = stmt.executeQuery("select * from classinfo.professor where "+select+ " = " +Integer.parseInt(value));
			}
			else if(s.equals("������")){
				select = "name";
				result = stmt.executeQuery("select * from classinfo.professor where "+select+ " = '" +value +"'");
			}else if(s.equals("�Ҽ��а�")){
				select = "major";
				result = stmt.executeQuery("select * from classinfo.professor where "+select+ " = '" +value +"'");
				
			}else if(s.equals("����")){
				select = "division";
				result = stmt.executeQuery("select * from classinfo.professor where "+select+ " = '" +value +"'");
			}
		
			while(result.next()){
				ProfessorData proData = new ProfessorData();
				
				proData.setProfessorNumber(result.getInt("idNumber"));
				proData.setProfessorName(result.getString("name"));
				proData.setProfessorMajor(result.getString("major"));
				proData.setProfessorDivision(result.getString("division"));
				
				proDataList.add(proData);
			}
			
		}catch(SQLException e){
			System.out.println("q f" + e.getMessage());
			return null;
		}
		
		
		return proDataList;
	}
}
