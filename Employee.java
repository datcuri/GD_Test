package Employee;

import java.sql.Date;

public class Employee {
	private String ID;
	private String Name;
	private Date Brithday;
	private Float Rate;
	private String Deparment;
	//
	public Employee(){
		
	}
	public Employee(String iD, String name, Date brithday, Float rate, String deparment) {
		ID = iD;
		Name = name;
		Brithday = brithday;
		Rate = rate;
		Deparment = deparment;
	}
	//
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Date getBrithday() {
		return Brithday;
	}
	public void setBrithday(Date brithday) {
		Brithday = brithday;
	}
	public Float getRate() {
		return Rate;
	}
	public void setRate(Float rate) {
		Rate = rate;
	}
	public String getDeparment() {
		return Deparment;
	}
	public void setDeparment(String deparment) {
		Deparment = deparment;
	}
	
	
	//
	@Override
	public String toString() {
		return "Employee [ID=" + ID + ", Name=" + Name + ", Brithday=" + Brithday + ", Rate=" + Rate + ", Deparment="
				+ Deparment + "]";
	}
	
}
