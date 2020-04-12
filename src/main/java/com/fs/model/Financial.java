package com.fs.model;

import java.util.Date;

public class Financial {
    private Integer id;

    private String fund;

    private String state;

    private Integer auditId;

    private Integer orderId;

    private String persson;

    private String custmer;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFund() {
        return fund;
    }

    public void setFund(String fund) {
        this.fund = fund;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getPersson() {
        return persson;
    }

    public void setPersson(String persson) {
        this.persson = persson;
    }

    public String getCustmer() {
        return custmer;
    }

    public void setCustmer(String custmer) {
        this.custmer = custmer;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

	@Override
	public String toString() {
		return "Financial [id=" + id + ", fund=" + fund + ", state=" + state + ", auditId=" + auditId + ", orderId="
				+ orderId + ", persson=" + persson + ", custmer=" + custmer + ", time=" + time + "]";
	}

	public Financial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Financial(Integer id, String fund, String state, Integer auditId, Integer orderId, String persson,
			String custmer, Date time) {
		super();
		this.id = id;
		this.fund = fund;
		this.state = state;
		this.auditId = auditId;
		this.orderId = orderId;
		this.persson = persson;
		this.custmer = custmer;
		this.time = time;
	}
    
}