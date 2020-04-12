package com.fs.model;

/**
 * @author Mr-Yang
 *
 */
public class Product1 {
	private String name; 			// 类别名称
	private int num; 				// 销量

	public Product1(String name, int num) {
		this.name = name;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", num=" + num + "]";
	}


}
