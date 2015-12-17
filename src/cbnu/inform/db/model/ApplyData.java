package cbnu.inform.db.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ApplyData {
	private StringProperty studentName;
	private IntegerProperty studentNumber;
	private StringProperty lectureName;
	private IntegerProperty lectureNumber;
	
	/*
	 * Default constructor.
	 * Constuctor with some initial data.
	 */
	public ApplyData() {
		// TODO Auto-generated constructor stub
		studentName = new SimpleStringProperty();
		studentNumber = new SimpleIntegerProperty();
		lectureName = new SimpleStringProperty();
		lectureNumber = new SimpleIntegerProperty();
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
	

	public final StringProperty lectureNameProperty() {
		return this.lectureName;
	}
	

	public final java.lang.String getLectureName() {
		return this.lectureNameProperty().get();
	}
	

	public final void setLectureName(final java.lang.String lectureName) {
		this.lectureNameProperty().set(lectureName);
	}
	

	public final IntegerProperty lectureNumberProperty() {
		return this.lectureNumber;
	}
	

	public final int getLectureNumber() {
		return this.lectureNumberProperty().get();
	}
	

	public final void setLectureNumber(final int lectureNumber) {
		this.lectureNumberProperty().set(lectureNumber);
	}
	
}
