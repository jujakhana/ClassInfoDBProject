package cbnu.inform.db.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import cbnu.inform.db.dao.DaoDBConnection;
import cbnu.inform.db.log.InvalidDataCheck;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DeleteLayoutController {
	
	@FXML
	TextField studentNumberTextField;
	@FXML
	TextField lectureNumberTextField;
	@FXML
	TextField professorNumberTextField;
	@FXML
	TextField classLectureNumberTextField;
	@FXML
	TextField classStudentNumberTextField;
	@FXML
	TextField applyProfessorNumberTextField;
	@FXML
	TextField applyLectureNumberTextField;
	
	private String studentNumber;
	private String lectureNumber;
	private String professorNumber;
	private String classLectureNumber;
	private String classStudentNumber;
	private String applyProfessorNumber;
	private String applyLectureNumber;
	
	/**
	 * Constructor
	 */
	public DeleteLayoutController() {
	}
	
	
	/**
	 * Called when the user clicks on the student delete button
	 * @throws SQLException 
	 */
	@FXML
	private void HandleStudentDelButton() throws SQLException{
		studentNumber = studentNumberTextField.getText();
		if(InvalidDataCheck.isIntegerValid("�й�", studentNumber))
		{
			//Valid Data;
			Connection dbConnection = DaoDBConnection.tryConnect();			
			Statement stmt =dbConnection.createStatement();
			
			int cnt = stmt.executeUpdate("delete from classinfo.student where idNumber = "+studentNumber);

			if(cnt ==0){
				System.out.println("������ ������ ã�� �� �����ϴ�.");
				
			}
			else{
				System.out.println("���� �Ǿ����ϴ�.");
				
			}
		}
	}
	
	/**
	 * Called when the user clicks on the lecture delete button
	 * @throws SQLException 
	 */
	@FXML
	private void HandleLectureDelButton() throws SQLException{
		lectureNumber = lectureNumberTextField.getText();
		if(InvalidDataCheck.isIntegerValid("��������", lectureNumber))
		{
			//Valid Data;
			Connection dbConnection = DaoDBConnection.tryConnect();			
			Statement stmt =dbConnection.createStatement();
			
			int cnt = stmt.executeUpdate("delete from classinfo.lecture where idNumber = "+lectureNumber);

			if(cnt ==0){
				System.out.println("������ ������ ã�� �� �����ϴ�.");
				
			}
			else{
				System.out.println("���� �Ǿ����ϴ�.");
				
			}

		}
	}
	
	/**
	 * Called when the user clicks on the professor delete button
	 * @throws SQLException 
	 */
	@FXML
	private void HandleProfessorDelButton() throws SQLException{
		professorNumber = professorNumberTextField.getText();
		if(InvalidDataCheck.isIntegerValid("��������", professorNumber))
		{
			//Valid Data;
			Connection dbConnection = DaoDBConnection.tryConnect();			
			Statement stmt =dbConnection.createStatement();
			
			int cnt = stmt.executeUpdate("delete from classinfo.professor where idNumber = "+professorNumber);

			if(cnt ==0){
				System.out.println("������ ������ ã�� �� �����ϴ�.");
				
			}
			else{
				System.out.println("���� �Ǿ����ϴ�.");
				
			}
		}
	}
	
	/**
	 * Called when the user clicks on the class delete button
	 * @throws SQLException 
	 */
	@FXML
	private void HandleClassDelButton() throws SQLException{
		classLectureNumber = classLectureNumberTextField.getText();
		classStudentNumber = classStudentNumberTextField.getText();
		
		if(InvalidDataCheck.isIntegerValid("�������", classLectureNumber)
				&& InvalidDataCheck.isIntegerValid("�������", classStudentNumber))
		{
			//valid data
			Connection dbConnection = DaoDBConnection.tryConnect();			
			Statement stmt =dbConnection.createStatement();
			
			int cnt = stmt.executeUpdate("delete from classinfo.classallinfo where sNumber = "+classStudentNumber
					+" AND lecNumber ="+classLectureNumber);

			if(cnt ==0){
				System.out.println("������ ������ ã�� �� �����ϴ�.");
				
			}
			else{
				System.out.println("���� �Ǿ����ϴ�.");
				
			}
		}
		
	}
	
	/**
	 * Called when the user clicks on the apply delete button
	 * @throws SQLException 
	 */
	@FXML
	private void HandleApplyDelButton() throws SQLException{
		applyProfessorNumber = applyProfessorNumberTextField.getText();
		applyLectureNumber = applyLectureNumberTextField.getText();
		
		if(InvalidDataCheck.isIntegerValid("�������", applyProfessorNumber)
				&& InvalidDataCheck.isIntegerValid("�������", applyLectureNumber))
		{
			//valid data;
			Connection dbConnection = DaoDBConnection.tryConnect();			
			Statement stmt =dbConnection.createStatement();
			
			int cnt = stmt.executeUpdate("delete from classinfo.apply where pNum = "+applyProfessorNumber
					+" AND pLecNum = "+applyLectureNumber);

			if(cnt ==0){
				System.out.println("������ ������ ã�� �� �����ϴ�.");
				
			}
			else{
				System.out.println("���� �Ǿ����ϴ�.");
				
			}
		}
	}
}


