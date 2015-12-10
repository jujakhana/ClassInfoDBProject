package cbnu.inform.db.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RegisterData {
	private final StringProperty regList;
	
	public RegisterData(String regData){
		this.regList = new SimpleStringProperty(regData);		
	}

	public final StringProperty regListProperty() {
		return regList;
	}
	
	public final String getRegList() {
		return regListProperty().get();
	}
	

	public final void setRegList(final java.lang.String regList) {
		this.regList.set(regList);
	}
	
}
