package com.fs.model;

/**
 * @author Mr-Yang
 *
 */
public class Goods {
	private String goods_name;       //商品名称
	private long goodsTotalCost;    //出库总成本
	private long goodsTotalPrice;   //出库总金额
	private int freeNumber;         //商品剩余数量   
	private long goodsTotalProfit;   //总利润
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public long getGoodsTotalCost() {
		return goodsTotalCost;
	}
	public void setGoodsTotalCost(long goodsTotalCost) {
		this.goodsTotalCost = goodsTotalCost;
	}
	public long getGoodsTotalPrice() {
		return goodsTotalPrice;
	}
	public void setGoodsTotalPrice(long goodsTotalPrice) {
		this.goodsTotalPrice = goodsTotalPrice;
	}
	public int getFreeNumber() {
		return freeNumber;
	}
	public void setFreeNumber(int freeNumber) {
		this.freeNumber = freeNumber;
	}
	public long getGoodsTotalProfit() {
		return goodsTotalProfit;
	}
	public void setGoodsTotalProfit(long goodsTotalProfit) {
		this.goodsTotalProfit = goodsTotalProfit;
	}
	@Override
	public String toString() {
		return "Goods [goods_name=" + goods_name + ", goodsTotalCost=" + goodsTotalCost + ", goodsTotalPrice="
				+ goodsTotalPrice + ", freeNumber=" + freeNumber + ", goodsTotalProfit=" + goodsTotalProfit + "]";
	}
	public Goods(String goods_name, long goodsTotalCost, long goodsTotalPrice, int freeNumber, long goodsTotalProfit) {
		super();
		this.goods_name = goods_name;
		this.goodsTotalCost = goodsTotalCost;
		this.goodsTotalPrice = goodsTotalPrice;
		this.freeNumber = freeNumber;
		this.goodsTotalProfit = goodsTotalProfit;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
