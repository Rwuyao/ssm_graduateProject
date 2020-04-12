package com.fs.model;

public class Supplier {
    private Integer supplierId;

    private String company;

    private String wner;

    private String adress;

    private String telephone;

    private String des;

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWner() {
        return wner;
    }

    public void setWner(String wner) {
        this.wner = wner;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", company=" + company + ", wner=" + wner + ", adress=" + adress
				+ ", telephone=" + telephone + ", des=" + des + "]";
	}

	public Supplier(Integer supplierId, String company, String wner, String adress, String telephone, String des) {
		super();
		this.supplierId = supplierId;
		this.company = company;
		this.wner = wner;
		this.adress = adress;
		this.telephone = telephone;
		this.des = des;
	}

	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}