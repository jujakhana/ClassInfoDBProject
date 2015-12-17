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
	
	public final BooleanProperty allSelectedProperty() {
		return this.allSelected;
	}
	
	public final boolean isAllSelected() {
		return this.allSelectedProperty().get();
	}
	
	public final void setAllSelected(final boolean allSelected) {
		this.allSelectedProperty().set(allSelected);
	}
	
	public final BooleanProperty studentNameProperty() {
		return this.studentName;
	}
	
	public final boolean isStudentName() {
		return this.studentNameProperty().get();
	}
	
	public final void setStudentName(final boolean studentName) {
		this.studentNameProperty().set(studentName);
	}
	
	public final BooleanProperty studentNumberProperty() {
		return this.studentNumber;
	}
	
	public final boolean isStudentNumber() {
		return this.studentNumberProperty().get();
	}
	
	public final void setStudentNumber(final boolean studentNumber) {
		this.studentNumberProperty().set(studentNumber);
	}
	
	public final BooleanProperty majorProperty() {
		return this.major;
	}
	
	public final boolean isMajor() {
		return this.majorProperty().get();
	}
	
	public final void setMajor(final boolean major) {
		this.majorProperty().set(major);
	}
	
	public final BooleanProperty gradeProperty() {
		return this.grade;
	}
	
	public final boolean isGrade() {
		return this.gradeProperty().get();
	}
	
	public final void setGrade(final boolean grade) {
		this.gradeProperty().set(grade);
	}
	
	public final BooleanProperty collegeProperty() {
		return this.college;
	}
	
	public final boolean isCollege() {
		return this.collegeProperty().get();
	}
	
	public final void setCollege(final boolean college) {
		this.collegeProperty().set(college);
	}
	
	public final BooleanProperty lectureProperty() {
		return this.lecture;
	}
	
	public final boolean isLecture() {
		return this.lectureProperty().get();
	}
	
	public final void setLecture(final boolean lecture) {
		this.lectureProperty().set(lecture);
	}
	
	public final BooleanProperty lectureNumberProperty() {
		return this.lectureNumber;
	}
	
	public final boolean isLectureNumber() {
		return this.lectureNumberProperty().get();
	}
	
	public final void setLectureNumber(final boolean lectureNumber) {
		this.lectureNumberProperty().set(lectureNumber);
	}
	
	public final BooleanProperty professorProperty() {
		return this.professor;
	}
	
	public final boolean isProfessor() {
		return this.professorProperty().get();
	}
	
	public final void setProfessor(final boolean professor) {
		this.professorProperty().set(professor);
	}
	
	public final BooleanProperty lectureTimeProperty() {
		return this.lectureTime;
	}
	
	public final boolean isLectureTime() {
		return this.lectureTimeProperty().get();
	}
	
	public final void setLectureTime(final boolean lectureTime) {
		this.lectureTimeProperty().set(lectureTime);
	}
	
	public final BooleanProperty lecturePersonProperty() {
		return this.lecturePerson;
	}
	
	public final boolean isLecturePerson() {
		return this.lecturePersonProperty().get();
	}
	
	public final void setLecturePerson(final boolean lecturePerson) {
		this.lecturePersonProperty().set(lecturePerson);
	}
	
	public final BooleanProperty lectureLimitProperty() {
		return this.lectureLimit;
	}
	
	public final boolean isLectureLimit() {
		return this.lectureLimitProperty().get();
	}
	
	public final void setLectureLimit(final boolean lectureLimit) {
		this.lectureLimitProperty().set(lectureLimit);
	}
	

	 

}
