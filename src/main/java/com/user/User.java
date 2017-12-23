package com.user;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "video2")
public class User {
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	private String webname;
	@NotNull
	private String videoname;
	private Date pagetime;
	private Date collecttime;
	private String fromwhere;
	private String property;
	private String area;
	private int hot;
	public int getHot() {
		return hot;
	}
	public void setHot(int hot) {
		this.hot = hot;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public Date getPagetime() {
		return pagetime;
	}
	public void setPagetime(Date pagetime) {
		this.pagetime = pagetime;
	}
	public Date getTime() {
		return collecttime;
	}
	public void setTime(Date collecttime) {
		this.collecttime = collecttime;
	}
	public String getFrom() {
		return fromwhere;
	}
	public void setFrom(String fromwhere) {
		this.fromwhere = fromwhere;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWebname() {
		return webname;
	}
	public void setWebname(String webname) {
		this.webname = webname;
	}
	public String getVideoname() {
		return videoname;
	}
	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}

}
