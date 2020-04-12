package com.fs.model;

import java.util.Date;

public class Warehouse_log {
	private int id;
	private int pro_id; 
	private String name;
	private int  number;
	private String persson;
	private Date date;
	private String state;
	private String sale;
	private String custmer;
	private int order_id;
	private int audit_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPersson() {
		return persson;
	}
	public void setPersson(String persson) {
		this.persson = persson;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSale() {
		return sale;
	}
	public void setSale(String sale) {
		this.sale = sale;
	}
	public String getCustmer() {
		return custmer;
	}
	public void setCustmer(String custmer) {
		this.custmer = custmer;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getAudit_id() {
		return audit_id;
	}
	public void setAudit_id(int audit_id) {
		this.audit_id = audit_id;
	}
	public Warehouse_log() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Warehouse_log(int id, int pro_id, String name, int number, String persson, Date date, String state,
			String sale, String custmer, int order_id, int audit_id) {
		super();
		this.id = id;
		this.pro_id = pro_id;
		this.name = name;
		this.number = number;
		this.persson = persson;
		this.date = date;
		this.state = state;
		this.sale = sale;
		this.custmer = custmer;
		this.order_id = order_id;
		this.audit_id = audit_id;
	}
	@Override
	public String toString() {
		return "Warehouse_log [id=" + id + ", pro_id=" + pro_id + ", name=" + name + ", number=" + number + ", persson="
				+ persson + ", date=" + date + ", state=" + state + ", sale=" + sale + ", custmer=" + custmer
				+ ", order_id=" + order_id + ", audit_id=" + audit_id + "]";
	}
	
	
	

}
