package com.user;

import javax.persistence.Entity;
//import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
//@Table(name = "View")
public class Area {
	/*@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;*/  
	@NotNull
	private String value;
	@Id
	@NotNull
	private String area;
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
	public String getArea() {
		return area;
	}
	public void setName(String area) {
		this.area = area;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
