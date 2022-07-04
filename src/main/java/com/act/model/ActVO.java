package com.act.model;

import java.sql.*;

public class ActVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer act_id;
	private byte[] act_picture;
	private String act_subtitle;
	private String act_content;
	private Date act_date_start;
	private Date act_date_end;

	
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

	public Date getAct_date_start() {
		return act_date_start;
	}

	public void setAct_date_start(Date act_date_start) {
		this.act_date_start = act_date_start;
	}

	public Date getAct_date_end() {
		return act_date_end;
	}

	public void setAct_date_end(Date act_date_end) {
		this.act_date_end = act_date_end;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	// for join 標題、票種、折價、折扣、狀態 from act_id 呼叫 標題、票種、折價、折扣、狀態 (活動方案明細)
//    public com.actdt.model.ActdtVO getActdtVO() {
//	    com.actdt.model.ActdtService actdtSvc = new com.actdt.model.ActdtService();
//	    com.actdt.model.ActdtVO actdtVO = actdtSvc.findByPrimaryKey(act_id);
//	    return actdtVO;
//	}
    
	// for join 標題、票種、折價、折扣、狀態 from act_id 呼叫 標題、票種、折價、折扣、狀態 (活動方案明細)
    
}

