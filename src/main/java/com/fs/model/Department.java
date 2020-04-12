package com.fs.model;

public class Department {
    private Integer depId;

    private String name;

    private String des;

    private String money;

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

	@Override
	public String toString() {
		return "Department [depId=" + depId + ", name=" + name + ", des=" + des + ", money=" + money + "]";
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(Integer depId, String name, String des, String money) {
		super();
		this.depId = depId;
		this.name = name;
		this.des = des;
		this.money = money;
	}
    
}