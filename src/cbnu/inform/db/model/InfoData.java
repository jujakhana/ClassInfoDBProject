package cbnu.inform.db.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InfoData {

	private StringProperty studentName;
	private IntegerProperty studentNumber;
	private StringProperty major;
	private IntegerProperty grade;
	private StringProperty college;
	private StringProperty lecture;
	private IntegerProperty lectureNumber;
	private StringProperty professor;
	private IntegerProperty lectureTime;
	private IntegerProperty lecturePerson;
	private IntegerProperty lectureLimit;
	
	public InfoData() {
		// TODO Auto-generated constructor stub
		studentName = new SimpleStringProperty();
		studentNumber= new SimpleIntegerProperty();
		major = new SimpleStringProperty();
		grade= new SimpleIntegerProperty();
		college = new SimpleStringProperty();
		lecture= new SimpleStringProperty();
		lectureNumber = new SimpleIntegerProperty();
		professor = new SimpleStringProperty();
		lectureTime = new SimpleIntegerProperty();
		lecturePerson = new SimpleIntegerProperty();
		lectureLimit = new SimpleIntegerProperty();
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
	

	public final StringProperty majorProperty() {
		return this.major;
	}
	

	public final java.lang.String getMajor() {
		return this.majorProperty().get();
	}
	

	public final void setMajor(final java.lang.String major) {
		this.majorProperty().set(major);
	}
	

	public final IntegerProperty gradeProperty() {
		return this.grade;
	}
	

	public final int getGrade() {
		return this.gradeProperty().get();
	}
	

	public final void setGrade(final int grade) {
		this.gradeProperty().set(grade);
	}
	

	public final StringProperty collegeProperty() {
		return this.college;
	}
	

	public final java.lang.String getCollege() {
		return this.collegeProperty().get();
	}
	

	public final void setCollege(final java.lang.String college) {
		this.collegeProperty().set(college);
	}
	

	public final StringProperty lectureProperty() {
		return this.lecture;
	}
	

	public final java.lang.String getLecture() {
		return this.lectureProperty().get();
	}
	

	public final void setLecture(final java.lang.String lecture) {
		this.lectureProperty().set(lecture);
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
	

	public final StringProperty professorProperty() {
		return this.professor;
	}
	

	public final java.lang.String getProfessor() {
		return this.professorProperty().get();
	}
	

	public final void setProfessor(final java.lang.String professor) {
		this.professorProperty().set(professor);
	}
	

	public final IntegerProperty lectureTimeProperty() {
		return this.lectureTime;
	}
	

	public final int getLectureTime() {
		return this.lectureTimeProperty().get();
	}
	

	public final void setLectureTime(final int lectureTime) {
		this.lectureTimeProperty().set(lectureTime);
	}
	

	public final IntegerProperty lecturePersonProperty() {
		return this.lecturePerson;
	}
	

	public final int getLecturePerson() {
		return this.lecturePersonProperty().get();
	}
	

	public final void setLecturePerson(final int lecturePerson) {
		this.lecturePersonProperty().set(lecturePerson);
	}
	

	public final IntegerProperty lectureLimitProperty() {
		return this.lectureLimit;
	}
	

	public final int getLectureLimit() {
		return this.lectureLimitProperty().get();
	}
	

	public final void setLectureLimit(final int lectureLimit) {
		this.lectureLimitProperty().set(lectureLimit);
	}
	
	
	
}
