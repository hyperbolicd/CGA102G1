package com.actdt.model;
import java.sql.Date;

public class ActdtVO implements java.io.Serializable{
	private Integer act_id;        //活動編號
	private String act_title;      //活動標題
	private Integer tkTypeID;      //票種編號
	private Double act_discount;   //活動折價
	private Integer act_coupon;    //活動折扣
	private Byte act_status;       //活動狀態
	
	
	public Integer getAct_id() {
		return act_id;
	}
	public void setAct_id(Integer act_id) {
		this.act_id = act_id;
	}
	public String getAct_title() {
		return act_title;
	}
	public void setAct_title(String act_title) {
		this.act_title = act_title;
	}
	public Integer gettkTypeID() {
		return tkTypeID;
	}
	public void settkTypeID(Integer tkTypeID) {
		this.tkTypeID = tkTypeID;
	}
	public Double getAct_discount() {
		return act_discount;
	}
	public void setAct_discount(Double act_discount) {
		this.act_discount = act_discount;
	}
	public Integer getAct_coupon() {
		return act_coupon;
	}
	public void setAct_coupon(Integer act_coupon) {
		this.act_coupon = act_coupon;
	}
	public Byte getAct_status() {
		return act_status;
	}
	public void setAct_status(Byte act_status) {
		this.act_status = act_status;
	}
	
	// 取得票種編號
	public com.tk_inf.model.TkInfVO getTkInfVO() {
		com.tk_inf.model.TkInfService TkInfSvc = new com.tk_inf.model.TkInfService();
		return TkInfSvc.getOneTkInf(tkTypeID);
	}
	// 取得活動資訊
	public com.act.model.ActVO getActVO() {
		com.act.model.ActService actSvc = new com.act.model.ActService();
		return actSvc.getOneAct(act_id);
	}
	

}
