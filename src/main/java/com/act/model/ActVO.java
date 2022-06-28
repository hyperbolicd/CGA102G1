package com.act.model;
import java.sql.Timestamp;

public class ActVO implements java.io.Serializable{
	private Integer act_id;
	private byte[] act_picture;
	private String act_title;
	private String act_subtitle;
	private String act_content;
	private Timestamp act_time_start;
	private Timestamp act_time_end;
	private Byte act_status;
	
	
	public ActVO() {
		super();
	}
	public ActVO(Integer act_id, byte[] act_picture, String act_title, String act_subtitle, String act_content,
			Timestamp act_time_start, Timestamp act_time_end, Byte act_status) {
		super();
		this.act_id = act_id;
		this.act_picture = act_picture;
		this.act_title = act_title;
		this.act_subtitle = act_subtitle;
		this.act_content = act_content;
		this.act_time_start = act_time_start;
		this.act_time_end = act_time_end;
		this.act_status = act_status;
	}
	
	public Integer getAct_id() {
		return act_id;
	}
	public void setAct_id(Integer act_id) {
		this.act_id = act_id;
	}
	public byte[] getAct_picture() {
		return act_picture;
	}
	public void setAct_picture(byte[] act_picture) {
		this.act_picture = act_picture;
	}
	public String getAct_title() {
		return act_title;
	}
	public void setAct_title(String act_title) {
		this.act_title = act_title;
	}
	public String getAct_subtitle() {
		return act_subtitle;
	}
	public void setAct_subtitle(String act_subtitle) {
		this.act_subtitle = act_subtitle;
	}
	public String getAct_content() {
		return act_content;
	}
	public void setAct_content(String act_content) {
		this.act_content = act_content;
	}
	public Timestamp getAct_time_start() {
		return act_time_start;
	}
	public void setAct_time_start(Timestamp act_time_start) {
		this.act_time_start = act_time_start;
	}
	public Timestamp getAct_time_end() {
		return act_time_end;
	}
	public void setAct_time_end(Timestamp act_time_end) {
		this.act_time_end = act_time_end;
	}
	public Byte getAct_status() {
		return act_status;
	}
	public void setAct_status(Byte act_status) {
		this.act_status = act_status;
	}

}
