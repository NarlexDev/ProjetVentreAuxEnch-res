package fr.eni.bo;

public class User {
	private String username;
	private String mail;
	private String password;
	private String confirmation;
	
	public User() {

	}

	public User(String username, String mail, String password) {
		super();
		this.username = username;
		this.mail = mail;
		this.password = password;
	}

	public User(String username, String mail, String password, String confirmation) {
		super();
		this.username = username;
		this.mail = mail;
		this.password = password;
		this.confirmation = (confirmation);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}
	
	
}
