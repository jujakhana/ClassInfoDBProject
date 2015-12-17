package cbnu.inform.db.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Register Professor
 * 
 */
public class ProfessorData {
	private StringProperty professorName;
	private IntegerProperty professorNumber;
	private StringProperty professorMajor;
	private StringProperty professorDivision;
	
	/*
	 * Default constructor.
	 * Constuctor with some initial data.
	 */
	public ProfessorData() {
		// TODO Auto-generated constructor stub
		professorNumber = new SimpleIntegerProperty();
		professorName = new SimpleStringProperty();
		professorMajor = new SimpleStringProperty();
		professorDivision = new SimpleStringProperty();
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
	


	public final StringProperty professorMajorProperty() {
		return this.professorMajor;
	}
	


	public final java.lang.String getProfessorMajor() {
		return this.professorMajorProperty().get();
	}
	


	public final void setProfessorMajor(final java.lang.String professorMajor) {
		this.professorMajorProperty().set(professorMajor);
	}
	


	public final StringProperty professorDivisionProperty() {
		return this.professorDivision;
	}
	


	public final java.lang.String getProfessorDivision() {
		return this.professorDivisionProperty().get();
	}
	


	public final void setProfessorDivision(final java.lang.String professorDivision) {
		this.professorDivisionProperty().set(professorDivision);
	}
	
}
