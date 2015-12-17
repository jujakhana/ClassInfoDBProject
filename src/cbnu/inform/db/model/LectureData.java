package cbnu.inform.db.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Register Lecture
 * 
 */
public class LectureData {
	private IntegerProperty lectureNumber;
	private StringProperty lectureName;
	private StringProperty lectureMajor;
	private StringProperty lectureCollege;

	/*
	 * Default constructor.
	 * Constuctor with some initial data.
	 */
	public LectureData() {
		// TODO Auto-generated constructor stub
		lectureNumber = new SimpleIntegerProperty();
		lectureName = new SimpleStringProperty();
		lectureMajor = new SimpleStringProperty();
		lectureCollege = new SimpleStringProperty();
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

	public final StringProperty lectureNameProperty() {
		return this.lectureName;
	}

	public final java.lang.String getLectureName() {
		return this.lectureNameProperty().get();
	}

	public final void setLectureName(final java.lang.String lectureName) {
		this.lectureNameProperty().set(lectureName);
	}

	public final StringProperty lectureMajorProperty() {
		return this.lectureMajor;
	}

	public final java.lang.String getLectureMajor() {
		return this.lectureMajorProperty().get();
	}

	public final void setLectureMajor(final java.lang.String lectureMajor) {
		this.lectureMajorProperty().set(lectureMajor);
	}

	public final StringProperty lectureCollegeProperty() {
		return this.lectureCollege;
	}

	public final java.lang.String getLectureCollege() {
		return this.lectureCollegeProperty().get();
	}

	public final void setLectureCollege(final java.lang.String lectureCollege) {
		this.lectureCollegeProperty().set(lectureCollege);
	}
}
