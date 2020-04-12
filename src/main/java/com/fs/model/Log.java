package com.fs.model;

import java.util.Date;

public class Log {
    private Integer id;

    private String context;

    private String people;

    private Date time;

    private String object;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

	@Override
	public String toString() {
		return "Log [id=" + id + ", context=" + context + ", people=" + people + ", time=" + time + ", object=" + object
				+ "]";
	}

	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Log(Integer id, String context, String people, Date time, String object) {
		super();
		this.id = id;
		this.context = context;
		this.people = people;
		this.time = time;
		this.object = object;
	}
    
}