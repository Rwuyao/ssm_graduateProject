package com.fs.model;

import java.util.Date;

public class Order {
    private Integer orderId;
    private String productName;
    private String price;
    private Integer number;
    private String people;
    private String custmer;
    private String state;
    private Date time;
    private String becauser;
    
    private int stateCount;//处理状态条数
    private int sumNum;//订单总数
    private Date weekTime;//记录周次
    private String monthTime;//记录月份
    private int sumMoney;//月收入总额
    private String autoOrderId;//自动补全orderID
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(Integer orderId, String productName, String price, Integer number, String people, String custmer,
			String state, Date time, String becauser, int stateCount, int sumNum, Date weekTime, String monthTime,
			int sumMoney, String autoOrderId) {
		super();
		this.orderId = orderId;
		this.productName = productName;
		this.price = price;
		this.number = number;
		this.people = people;
		this.custmer = custmer;
		this.state = state;
		this.time = time;
		this.becauser = becauser;
		this.stateCount = stateCount;
		this.sumNum = sumNum;
		this.weekTime = weekTime;
		this.monthTime = monthTime;
		this.sumMoney = sumMoney;
		this.autoOrderId = autoOrderId;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productName=" + productName + ", price=" + price + ", number=" + number
				+ ", people=" + people + ", custmer=" + custmer + ", state=" + state + ", time=" + time + ", becauser="
				+ becauser + ", stateCount=" + stateCount + ", sumNum=" + sumNum + ", weekTime=" + weekTime
				+ ", monthTime=" + monthTime + ", sumMoney=" + sumMoney + ", autoOrderId=" + autoOrderId + "]";
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getCustmer() {
		return custmer;
	}
	public void setCustmer(String custmer) {
		this.custmer = custmer;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getBecauser() {
		return becauser;
	}
	public void setBecauser(String becauser) {
		this.becauser = becauser;
	}
	public int getStateCount() {
		return stateCount;
	}
	public void setStateCount(int stateCount) {
		this.stateCount = stateCount;
	}
	public int getSumNum() {
		return sumNum;
	}
	public void setSumNum(int sumNum) {
		this.sumNum = sumNum;
	}
	public Date getWeekTime() {
		return weekTime;
	}
	public void setWeekTime(Date weekTime) {
		this.weekTime = weekTime;
	}
	public String getMonthTime() {
		return monthTime;
	}
	public void setMonthTime(String monthTime) {
		this.monthTime = monthTime;
	}
	public int getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(int sumMoney) {
		this.sumMoney = sumMoney;
	}
	public String getAutoOrderId() {
		return autoOrderId;
	}
	public void setAutoOrderId(String autoOrderId) {
		this.autoOrderId = autoOrderId;
	}
	
	
}