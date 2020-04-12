package com.fs.model;

public class Customer {
	private int cus_id;
	private String cus_company_name;
	private String cus_username;
	private String cus_sex;
	
	private String cus_tel;
	private String cus_email;
	private String cus_address;
	private int id;
	private String cusName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int cus_id, String cus_company_name, String cus_username, String cus_sex, String cus_tel,
			String cus_email, String cus_address) {
		super();
		this.cus_id = cus_id;
		this.cus_company_name = cus_company_name;
		this.cus_username = cus_username;
		this.cus_sex = cus_sex;
		this.cus_tel = cus_tel;
		this.cus_email = cus_email;
		this.cus_address = cus_address;
	}
	@Override
	public String toString() {
		return "Customer [cus_id=" + cus_id + ", cus_company_name=" + cus_company_name + ", cus_username="
				+ cus_username + ", cus_sex=" + cus_sex + ", cus_tel=" + cus_tel + ", cus_email=" + cus_email
				+ ", cus_address=" + cus_address + "]";
	}
	public int getCus_id() {
		return cus_id;
	}
	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}
	public String getCus_company_name() {
		return cus_company_name;
	}
	public void setCus_company_name(String cus_company_name) {
		this.cus_company_name = cus_company_name;
	}
	public String getCus_username() {
		return cus_username;
	}
	public void setCus_username(String cus_username) {
		this.cus_username = cus_username;
	}
	public String getCus_sex() {
		return cus_sex;
	}
	public void setCus_sex(String cus_sex) {
		this.cus_sex = cus_sex;
	}
	public String getCus_tel() {
		return cus_tel;
	}
	public void setCus_tel(String cus_tel) {
		this.cus_tel = cus_tel;
	}
	public String getCus_email() {
		return cus_email;
	}
	public void setCus_email(String cus_email) {
		this.cus_email = cus_email;
	}
	public String getCus_address() {
		return cus_address;
	}
	public void setCus_address(String cus_address) {
		this.cus_address = cus_address;
	}
	

}
