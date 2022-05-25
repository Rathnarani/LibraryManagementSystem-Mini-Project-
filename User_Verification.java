
// Save this class as User_Verification

import java.io.Serializable;

public class User_Verification implements Serializable{
	String username;
	String password;
	String confirmpassword;
	String mobilenumber;
	public User_Verification(String username, String password, String confirmpassword,  String mobilenumber) {
		super();
		this.username = username;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.mobilenumber = mobilenumber;
	}
	public User_Verification() {
		// TODO Auto-generated constructor stub
		
	}
	@Override
	public String toString() {
		return "User_Verification [username=" + username + ", password=" + password + ", confirmpassword="
				+ confirmpassword + ", mobilenumber=" + mobilenumber + "]";
	}
	
	
}

