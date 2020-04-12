package com.fs.model;

import java.util.Date;

public class Product {
    private Integer proId;

    private String picture;

    private String name;

    private String bround;

    private String catagorg;

    private String des;

    private String cost;

    private String price;

    private Integer supplierId;

    private Date date;

    private Integer number;
    
   private String company;
    
    private Supplier supplier;
    private String  state;
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBround() {
		return bround;
	}
	public void setBround(String bround) {
		this.bround = bround;
	}
	public String getCatagorg() {
		return catagorg;
	}
	public void setCatagorg(String catagorg) {
		this.catagorg = catagorg;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Integer proId, String picture, String name, String bround, String catagorg, String des, String cost,
			String price, Integer supplierId, Date date, Integer number, String company, Supplier supplier,
			String state) {
		super();
		this.proId = proId;
		this.picture = picture;
		this.name = name;
		this.bround = bround;
		this.catagorg = catagorg;
		this.des = des;
		this.cost = cost;
		this.price = price;
		this.supplierId = supplierId;
		this.date = date;
		this.number = number;
		this.company = company;
		this.supplier = supplier;
		this.state = state;
	}
	@Override
	public String toString() {
		return "Product [proId=" + proId + ", picture=" + picture + ", name=" + name + ", bround=" + bround
				+ ", catagorg=" + catagorg + ", des=" + des + ", cost=" + cost + ", price=" + price + ", supplierId="
				+ supplierId + ", date=" + date + ", number=" + number + ", company=" + company + ", supplier="
				+ supplier + ", state=" + state + "]";
	}
	
	}