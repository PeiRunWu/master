package packag_java;

public class User {
	/** 用户的名字 **/
	private String userName;
	/** 账号密码 **/
	private String password;
	/** 用户的email **/
	private String email;

	public User() {super();}
	public User(String userName,String password,String email) {
		setUserName(userName);
		setPassword(password);
		setEmail(email);
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
