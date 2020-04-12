package com.fs.model;

/**
 * @author Mr-Yang
 *
 */
public class Statistic {
	private String bround;
	private String productName;
	private long totalRuKuNumber;
	private long totalChuKuNumber;
	private long totalRuKuCost;
	private long totalChuKuPrice;
	private long totalProfit;
	private double profitRadio;
	
	private String timeType;
	private Long moneyCompare;
	
	
	
	@Override
	public String toString() {
		return "Statistic [bround=" + bround + ", productName=" + productName + ", totalRuKuNumber=" + totalRuKuNumber
				+ ", totalChuKuNumber=" + totalChuKuNumber + ", totalRuKuCost=" + totalRuKuCost + ", totalChuKuPrice="
				+ totalChuKuPrice + ", totalProfit=" + totalProfit + ", profitRadio=" + profitRadio + ", timeType="
				+ timeType + ", moneyCompare=" + moneyCompare + "]";
	}

	public Statistic(String bround, String productName, long totalRuKuNumber, long totalChuKuNumber, long totalRuKuCost,
			long totalChuKuPrice, long totalProfit, double profitRadio, String timeType, Long moneyCompare) {
		super();
		this.bround = bround;
		this.productName = productName;
		this.totalRuKuNumber = totalRuKuNumber;
		this.totalChuKuNumber = totalChuKuNumber;
		this.totalRuKuCost = totalRuKuCost;
		this.totalChuKuPrice = totalChuKuPrice;
		this.totalProfit = totalProfit;
		this.profitRadio = profitRadio;
		this.timeType = timeType;
		this.moneyCompare = moneyCompare;
	}

	public Long getMoneyCompare() {
		return moneyCompare;
	}

	public void setMoneyCompare(Long moneyCompare) {
		this.moneyCompare = moneyCompare;
	}

	

	

	public String getTimeType() {
		return timeType;
	}

	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}

	public double getProfitRadio() {
		return profitRadio;
	}

	public void setProfitRadio(double profitRadio) {
		this.profitRadio = profitRadio;
	}

	



	public Statistic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBround() {
		return bround;
	}
	public void setBround(String bround) {
		this.bround = bround;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getTotalRuKuNumber() {
		return totalRuKuNumber;
	}
	public void setTotalRuKuNumber(long totalRuKuNumber) {
		this.totalRuKuNumber = totalRuKuNumber;
	}
	public long getTotalChuKuNumber() {
		return totalChuKuNumber;
	}
	public void setTotalChuKuNumber(long totalChuKuNumber) {
		this.totalChuKuNumber = totalChuKuNumber;
	}
	public long getTotalRuKuCost() {
		return totalRuKuCost;
	}
	public void setTotalRuKuCost(long totalRuKuCost) {
		this.totalRuKuCost = totalRuKuCost;
	}
	public long getTotalChuKuPrice() {
		return totalChuKuPrice;
	}
	public void setTotalChuKuPrice(long totalChuKuPrice) {
		this.totalChuKuPrice = totalChuKuPrice;
	}
	public long getTotalProfit() {
		return totalProfit;
	}
	public void setTotalProfit(long totalProfit) {
		this.totalProfit = totalProfit;
	}
	
	

}
