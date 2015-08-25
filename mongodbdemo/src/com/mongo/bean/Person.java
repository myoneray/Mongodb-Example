package com.mongo.bean;

import java.io.Serializable;

/**
 * TODO
 * @author wangming
 * @version TODO
 */
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3617931430808763429L;
	
	private String id;   
    private long value;
    private long ts;
    
	public Person() {
		super();
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
    public Long getValue() {
        return value;
    }
    public void setValue(Long value) {
        this.value = value;
    }
    public long getTs() {
        return ts;
    }
    public void setTs(long ts) {
        this.ts = ts;
    }
    public Person( long value, long ts) {
        super();
        this.value = value;
        this.ts = ts;
    }
    @Override
    public String toString() {
        return "Person [id=" + id + ", value=" + value + ", ts=" + ts + "]";
    }   



}