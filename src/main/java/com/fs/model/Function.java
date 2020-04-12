package com.fs.model;

public class Function {
    private Integer functionId;

    private String name;

    private String des;

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
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

	@Override
	public String toString() {
		return "Function [functionId=" + functionId + ", name=" + name + ", des=" + des + "]";
	}

	public Function() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Function(Integer functionId, String name, String des) {
		super();
		this.functionId = functionId;
		this.name = name;
		this.des = des;
	}
    
}