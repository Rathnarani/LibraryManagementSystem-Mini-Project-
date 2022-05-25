
// Save this class Admin_Verification

import java.io.Serializable;

public class Admin_Verification implements Serializable{
	String username;
	String password;
	String confirmpassword;
	String mobilenumber;
	public Admin_Verification(String username, String password, String confirmpassword, String role) {
		super();
		this.username = username;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.mobilenumber = mobilenumber;
	}
	public Admin_Verification() {
		// TODO Auto-generated constructor stub
		
	}
	@Override
	public String toString() {
		return "Admin_Verification [username=" + username + ", password=" + password + ", confirmpassword="
				+ confirmpassword + ", mobilenumber=" + mobilenumber + "]";
	}
	
}
