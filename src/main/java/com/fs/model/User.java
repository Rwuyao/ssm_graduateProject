package com.fs.model;

public class User {
    private int userId;

    private String username;

    private String password;

    private String name;

    private Integer depId;

    private Integer roleId;

    private String telephone;

    private String email;

    private String adress;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String username, String password, String name, Integer depId, Integer roleId,
			String telephone, String email, String adress) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.depId = depId;
		this.roleId = roleId;
		this.telephone = telephone;
		this.email = email;
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", depId=" + depId + ", roleId=" + roleId + ", telephone=" + telephone + ", email=" + email
				+ ", adress=" + adress + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

    
    
}