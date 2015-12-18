package cbnu.inform.db.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * Model class for a Register Class
 * 
 */
public class ApplyData {
	private StringProperty professorName;
	private IntegerProperty professorNumber;
	private StringProperty lectureName;
	private IntegerProperty lectureNumber;
	private StringProperty classTime;
	private IntegerProperty classCredit;
	private IntegerProperty classLimit;
	
	/*
	 * Default constructor.
	 * Constuctor with some initial data.
	 */
	public ApplyData() {
		// TODO Auto-generated constructor stub
		professorName = new SimpleStringProperty();
		professorNumber = new SimpleIntegerProperty();
		lectureName = new SimpleStringProperty();
		lectureNumber = new SimpleIntegerProperty();
		classTime = new SimpleStringProperty();
		classCredit = new SimpleIntegerProperty();
		classLimit = new SimpleIntegerProperty();
	}

	public final StringProperty professorNameProperty() {
		return this.professorName;
	}
	

	public final java.lang.String getProfessorName() {
		return this.professorNameProperty().get();
	}
	

	public final void setProfessorName(final java.lang.String professorName) {
		this.professorNameProperty().set(professorName);
	}
	

	public final IntegerProperty professorNumberProperty() {
		return this.professorNumber;
	}
	

	public final int getProfessorNumber() {
		return this.professorNumberProperty().get();
	}
	

	public final void setProfessorNumber(final int professorNumber) {
		this.professorNumberProperty().set(professorNumber);
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
	

	public final StringProperty classTimeProperty() {
		return this.classTime;
	}
	

	public final java.lang.String getClassTime() {
		return this.classTimeProperty().get();
	}
	

	public final void setClassTime(final java.lang.String classTime) {
		this.classTimeProperty().set(classTime);
	}
	

	public final IntegerProperty classCreditProperty() {
		return this.classCredit;
	}
	

	public final int getClassCredit() {
		return this.classCreditProperty().get();
	}
	

	public final void setClassCredit(final int classCredit) {
		this.classCreditProperty().set(classCredit);
	}
	

	public final IntegerProperty classLimitProperty() {
		return this.classLimit;
	}
	

	public final int getClassLimit() {
		return this.classLimitProperty().get();
	}
	

	public final void setClassLimit(final int classLimit) {
		this.classLimitProperty().set(classLimit);
	}
	
	
}
