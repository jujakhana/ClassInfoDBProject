package cbnu.inform.db.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SearchStudentData {

	private StringProperty studentName;
	private IntegerProperty studentNumber;
	private StringProperty studentMajor;
	private IntegerProperty studentGrade;
	private IntegerProperty studentCollege;
	
	/**
	 * The constructor
	 */
	public SearchStudentData() {
		// TODO Auto-generated constructor stub
		
		studentName = new SimpleStringProperty();
		studentNumber = new SimpleIntegerProperty();
		studentMajor = new SimpleStringProperty();
		studentGrade = new SimpleIntegerProperty();
		studentCollege = new SimpleIntegerProperty();
	}

	public final StringProperty studentNameProperty() {
		return this.studentName;
	}
	

	public final java.lang.String getStudentName() {
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
	

	public final IntegerProperty studentCollegeProperty() {
		return this.studentCollege;
	}
	

	public final int getStudentCollege() {
		return this.studentCollegeProperty().get();
	}
	

	public final void setStudentCollege(final int studentCollege) {
		this.studentCollegeProperty().set(studentCollege);
	}
}
