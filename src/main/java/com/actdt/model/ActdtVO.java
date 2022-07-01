package com.actdt.model;
import java.sql.Date;

public class ActdtVO implements java.io.Serializable{
	private Integer act_id;        //活動編號
	private String act_title;      //活動標題
	private Integer tk_type_id;    //票種編號
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
	public Integer getTk_type_id() {
		return tk_type_id;
	}
	public void setTk_type_id(Integer tk_type_id) {
		this.tk_type_id = tk_type_id;
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
	

}
