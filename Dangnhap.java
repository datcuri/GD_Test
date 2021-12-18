package TestPart;

public class Dangnhap {
	private String Account;
	private String Passwork;
	private String Role;
	
	// Constructor
	public Dangnhap(){
		
	}
	
	public Dangnhap(String account, String passwork, String role) {
		Account = account;
		Passwork = passwork;
		Role = role;
	}
	//	
	public String toString() {
		return "Dangnhap [Account=" + Account + ", Passwork=" + Passwork + ", Role=" + Role + "]";
	}

	// get set
	public String getAccount() {
		return Account;
	}

	public void setAccount(String account) {
		Account = account;
	}

	public String getPasswork() {
		return Passwork;
	}

	public void setPasswork(String passwork) {
		Passwork = passwork;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

}
