package com.user;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user2")
public class User2 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private int id;
	private String videoname2;
	private int hot2;
	private String fromwhere2;
	private Date collttime2;
	public Date getCollttime2() {
		return collttime2;
	}
	public void setCollttime2(Date collttime2) {
		this.collttime2 = collttime2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVideoname2() {
		return videoname2;
	}
	public void setVideoname2(String videoname2) {
		this.videoname2 = videoname2;
	}
	public int getHot2() {
		return hot2;
	}
	public void setHot2(int hot2) {
		this.hot2 = hot2;
	}
	public String getFromwhere2() {
		return fromwhere2;
	}
	public void setFromwhere2(String fromwhere2) {
		this.fromwhere2 = fromwhere2;
	}
	
}
