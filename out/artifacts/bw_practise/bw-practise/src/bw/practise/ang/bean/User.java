package bw.practise.ang.bean;

import java.sql.Date;

public class User {
	
	
	private String password;
	private String phone;
	private String name;
	private int age;
	private int id;
	private int role_type;
	private String email;
	private Date last_login_time;
	

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getRole_type() {
		return role_type;
	}


	public void setRole_type(int role_type) {
		this.role_type = role_type;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getLast_login_time() {
		return last_login_time;
	}


	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}


	@Override
	public String toString() {
		return "User [password=" + password + ", phone=" + phone + ", name=" + name + ", age=" + age + ", id=" + id
				+ ", role_type=" + role_type + ", email=" + email + ", last_login_time=" + last_login_time + "]";
	}
}
