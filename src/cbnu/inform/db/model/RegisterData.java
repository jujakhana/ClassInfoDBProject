package cbnu.inform.db.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RegisterData {
	private final StringProperty regList;
	
	public RegisterData(String regList){
		this.regList = new SimpleStringProperty("regList");		
	}

	public final StringProperty regListProperty() {
		return this.regList;
	}
	

	public final java.lang.String getRegList() {
		return this.regListProperty().get();
	}
	

	public final void setRegList(final java.lang.String regList) {
		this.regListProperty().set(regList);
	}
	
}
