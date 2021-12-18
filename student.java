package TestPart;

public class student {
	private int ID;
	private String Name;
	private int Age;
	private String Phone;
	private String Address;
	
	//Constructor
	public student(){
		
	}

	public student(int iD, String name, int age, String phone, String address) {
		super();
		ID = iD;
		Name = name;
		Age = age;
		Phone = phone;
		Address = address;
	}


	// to string
	public String toString() {
		return "student [ID=" + ID + ", Name=" + Name + ", Age=" + Age + ", Phone=" + Phone + ", Address=" + Address
				+ "]";
	}

	//get set
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	

	
	
}
