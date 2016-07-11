package ebay.iiitb.login;

public class LoginModal {

	private String email_user;
	private String password;
	private String username;
	private String fname;
	private String lname;
	private int u_surkey;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail_user() {
		return email_user;
	}
	public void setEmail_user(String email_user) {
		this.email_user = email_user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getU_surkey() {
		return u_surkey;
	}
	public void setU_surkey(int u_surkey) {
		this.u_surkey = u_surkey;
	}


}
