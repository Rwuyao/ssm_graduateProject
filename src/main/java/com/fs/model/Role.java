package com.fs.model;

public class Role {
    private Integer roleId;

    private String name;

    private String des;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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
		return "Role [roleId=" + roleId + ", name=" + name + ", des=" + des + "]";
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Integer roleId, String name, String des) {
		super();
		this.roleId = roleId;
		this.name = name;
		this.des = des;
	}
    
}