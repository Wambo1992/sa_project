package de.hsnr.abts.what2do.business;


public class User{
	private String id;
	private String username;
	private String password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ID: "+ id);
		builder.append(System.lineSeparator());
		builder.append("Username: "+username);
		builder.append(System.lineSeparator());
		builder.append("Password: "+password);
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		return builder.toString();
	}
}
