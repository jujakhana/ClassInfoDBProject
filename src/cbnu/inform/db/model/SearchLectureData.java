package cbnu.inform.db.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SearchLectureData {
	private IntegerProperty lectureNumber;
	private StringProperty lectureName;
	private StringProperty lectureMajor;
	private StringProperty lectureCollege;
	
	public SearchLectureData() {
		// TODO Auto-generated constructor stub
		lectureNumber = new SimpleIntegerProperty();
		lectureName = new SimpleStringProperty();
		lectureMajor = new SimpleStringProperty();
		lectureCollege = new SimpleStringProperty();
	}
}
