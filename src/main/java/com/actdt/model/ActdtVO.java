package com.actdt.model;
import java.sql.Date;

public class ActdtVO implements java.io.Serializable{
	private Integer act_id;
	private Integer tk_type_id;
	private Double act_discount;
	private Integer act_coupon;
	
	public Integer getAct_id() {
		return act_id;
	}
	public void setAct_id(Integer act_id) {
		this.act_id = act_id;
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
	

}
