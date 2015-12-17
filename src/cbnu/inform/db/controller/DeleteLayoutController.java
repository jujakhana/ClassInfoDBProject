package cbnu.inform.db.controller;

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
	public DeleteLayoutController() {}
	
	
	/**
	 * Called when the user clicks on the student delete button
	 */
	@FXML
	private void HandleStudentDelButton(){
		studentNumber = studentNumberTextField.getText();
		if(InvalidDataCheck.isIntegerValid("학번", studentNumber))
		{
			//Valid Data;
		}
	}
	
	/**
	 * Called when the user clicks on the lecture delete button
	 */
	@FXML
	private void HandleLectureDelButton(){
		lectureNumber = lectureNumberTextField.getText();
		if(InvalidDataCheck.isIntegerValid("교과삭제", lectureNumber))
		{
			//Valid Data;
		}
	}
	
	/**
	 * Called when the user clicks on the professor delete button
	 */
	@FXML
	private void HandleProfessorDelButton(){
		professorNumber = professorNumberTextField.getText();
		if(InvalidDataCheck.isIntegerValid("교수삭제", professorNumber))
		{
			//Valid Data;
		}
	}
	
	/**
	 * Called when the user clicks on the class delete button
	 */
	@FXML
	private void HandleClassDelButton(){
		classLectureNumber = classLectureNumberTextField.getText();
		classStudentNumber = classStudentNumberTextField.getText();
		
		if(InvalidDataCheck.isIntegerValid("수강취소", classLectureNumber)
				&& InvalidDataCheck.isIntegerValid("수강취소", classStudentNumber))
		{
			//valid data
		}
		
	}
	
	/**
	 * Called when the user clicks on the apply delete button
	 */
	@FXML
	private void HandleApplyDelButton(){
		applyProfessorNumber = applyProfessorNumberTextField.getText();
		applyLectureNumber = applyLectureNumberTextField.getText();
		
		if(InvalidDataCheck.isIntegerValid("강좌취소", applyProfessorNumber)
				&& InvalidDataCheck.isIntegerValid("강좌취소", applyLectureNumber))
		{
			//valid data;
		}
	}
}


