package com.user;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Rep")
public class RepUser {
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	private String videoweb;//��Ƶ����״̬
	private String videoweburl;//��վ��
	private int alive;//����ַ
	private String webtype;//��վ����
	private String lasttime;//�ϴβɼ�
	private String colltime;//���βɼ�
	private String collrate;//�ɼ�Ƶ��
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVideoweb() {
		return videoweb;
	}
	public void setVideoweb(String videoweb) {
		this.videoweb = videoweb;
	}
	public String getVideoweburl() {
		return videoweburl;
	}
	public void setVideoweburl(String videoweburl) {
		this.videoweburl = videoweburl;
	}
	public int getAlive() {
		return alive;
	}
	public void setAlive(int alive) {
		this.alive = alive;
	}
	public String getWebtype() {
		return webtype;
	}
	public void setWebtype(String webtype) {
		this.webtype = webtype;
	}
	public String getLasttime() {
		return lasttime;
	}
	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}
	public String getColltime() {
		return colltime;
	}
	public void setColltime(String colltime) {
		this.colltime = colltime;
	}
	public String getCollrate() {
		return collrate;
	}
	public void setCollrate(String collrate) {
		this.collrate = collrate;
	}

	
}
