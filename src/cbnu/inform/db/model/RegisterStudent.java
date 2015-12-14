package cbnu.inform.db.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.IntegerPropertyBase;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Register Student
 * 
 */
public class RegisterStudent {

	private final StringProperty studentName;
	private final IntegerProperty studentNumber;
	private final StringProperty studentMajor;
	private final IntegerProperty studentGrade;
	private final StringProperty studentCollage;
	
	/*
	 * Default constructor.
	 * Constuctor with some initial data.
	 */
	public RegisterStudent(){
		this.studentName = new SimpleStringProperty();
		this.studentNumber = new SimpleIntegerProperty();
		this.studentMajor = new SimpleStringProperty();
		this.studentGrade = new SimpleIntegerProperty();
		this.studentCollage = new SimpleStringProperty();
	}
	
	public final StringProperty studentNameProperty() {
		return this.studentName;
	}
	
	public final String getStudentName() {
		return this.studentNameProperty().get();
	}
	
	public final void setStudentName(final java.lang.String studentName) {
		this.studentNameProperty().set(studentName);
	}
	
	public final IntegerProperty studentNumberProperty() {
		return this.studentNumber;
	}
	
	public final int getStudentNumber() {
		return this.studentNumberProperty().get();
	}
	
	public final void setStudentNumber(final int studentNumber) {
		this.studentNumberProperty().set(studentNumber);
	}
	
	public final StringProperty studentMajorProperty() {
		return this.studentMajor;
	}
	
	public final java.lang.String getStudentMajor() {
		return this.studentMajorProperty().get();
	}
	
	public final void setStudentMajor(final java.lang.String studentMajor) {
		this.studentMajorProperty().set(studentMajor);
	}
	
	public final IntegerProperty studentGradeProperty() {
		return this.studentGrade;
	}
	
	public final int getStudentGrade() {
		return this.studentGradeProperty().get();
	}
	
	public final void setStudentGrade(final int studentGrade) {
		this.studentGradeProperty().set(studentGrade);
	}
	
	public final StringProperty studentCollageProperty() {
		return this.studentCollage;
	}
	
	public final String getStudentCollage() {
		return this.studentCollageProperty().get();
	}
	
	public final void setStudentCollage(final String studentCollage) {
		this.studentCollageProperty().set(studentCollage);
	}
	
	
	
	
}
