package com.fs.model;

import java.util.Date;

public class Audit {
    private Integer auditId;

    private String depSend;

    private String depReceve;

    private String peopleSend;

    private String firstCheck;

    private String scondCheck;

    private String state;

    private String becauser;

    private String productName;

    private String price;

    private Integer number;

    private String custmer;

    private Integer orderId;

    private Date time;

    private String sta;
    private Product product;
    private double statisticCost;    //财务需要的字段
    
    private int goodsCost;          //财务需要的字段
    
    private double statisticPrice;   //财务需要的字段
    
    private double staticticProfit;  //财务需要的字段

	@Override
	public String toString() {
		return "Audit [auditId=" + auditId + ", depSend=" + depSend + ", depReceve=" + depReceve + ", peopleSend="
				+ peopleSend + ", firstCheck=" + firstCheck + ", scondCheck=" + scondCheck + ", state=" + state
				+ ", becauser=" + becauser + ", productName=" + productName + ", price=" + price + ", number=" + number
				+ ", custmer=" + custmer + ", orderId=" + orderId + ", time=" + time + ", sta=" + sta + ", product="
				+ product + ", statisticCost=" + statisticCost + ", goodsCost=" + goodsCost + ", statisticPrice="
				+ statisticPrice + ", staticticProfit=" + staticticProfit + "]";
	}

	public Audit(Integer auditId, String depSend, String depReceve, String peopleSend, String firstCheck,
			String scondCheck, String state, String becauser, String productName, String price, Integer number,
			String custmer, Integer orderId, Date time, String sta, Product product, double statisticCost,
			int goodsCost, double statisticPrice, double staticticProfit) {
		super();
		this.auditId = auditId;
		this.depSend = depSend;
		this.depReceve = depReceve;
		this.peopleSend = peopleSend;
		this.firstCheck = firstCheck;
		this.scondCheck = scondCheck;
		this.state = state;
		this.becauser = becauser;
		this.productName = productName;
		this.price = price;
		this.number = number;
		this.custmer = custmer;
		this.orderId = orderId;
		this.time = time;
		this.sta = sta;
		this.product = product;
		this.statisticCost = statisticCost;
		this.goodsCost = goodsCost;
		this.statisticPrice = statisticPrice;
		this.staticticProfit = staticticProfit;
	}

	public Audit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getAuditId() {
		return auditId;
	}

	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}

	public String getDepSend() {
		return depSend;
	}

	public void setDepSend(String depSend) {
		this.depSend = depSend;
	}

	public String getDepReceve() {
		return depReceve;
	}

	public void setDepReceve(String depReceve) {
		this.depReceve = depReceve;
	}

	public String getPeopleSend() {
		return peopleSend;
	}

	public void setPeopleSend(String peopleSend) {
		this.peopleSend = peopleSend;
	}

	public String getFirstCheck() {
		return firstCheck;
	}

	public void setFirstCheck(String firstCheck) {
		this.firstCheck = firstCheck;
	}

	public String getScondCheck() {
		return scondCheck;
	}

	public void setScondCheck(String scondCheck) {
		this.scondCheck = scondCheck;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBecauser() {
		return becauser;
	}

	public void setBecauser(String becauser) {
		this.becauser = becauser;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getCustmer() {
		return custmer;
	}

	public void setCustmer(String custmer) {
		this.custmer = custmer;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getSta() {
		return sta;
	}

	public void setSta(String sta) {
		this.sta = sta;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getStatisticCost() {
		return statisticCost;
	}

	public void setStatisticCost(double statisticCost) {
		this.statisticCost = statisticCost;
	}

	public int getGoodsCost() {
		return goodsCost;
	}

	public void setGoodsCost(int goodsCost) {
		this.goodsCost = goodsCost;
	}

	public double getStatisticPrice() {
		return statisticPrice;
	}

	public void setStatisticPrice(double statisticPrice) {
		this.statisticPrice = statisticPrice;
	}

	public double getStaticticProfit() {
		return staticticProfit;
	}

	public void setStaticticProfit(double staticticProfit) {
		this.staticticProfit = staticticProfit;
	}


   
    
}