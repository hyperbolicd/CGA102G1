package com.wishing_list.model;

public class WishingListVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer wish_no;
	private Integer wish_option;
	private Integer mv_id;
	private Integer wish_count;
	
	public Integer getWish_no() {
		return wish_no;
	}
	public void setWish_no(Integer wish_no) {
		this.wish_no = wish_no;
	}
	public Integer getWish_option() {
		return wish_option;
	}
	public void setWish_option(Integer wish_option) {
		this.wish_option = wish_option;
	}
	public Integer getMv_id() {
		return mv_id;
	}
	public void setMv_id(Integer mv_id) {
		this.mv_id = mv_id;
	}
	public Integer getWish_count() {
		return wish_count;
	}
	public void setWish_count(Integer wish_count) {
		this.wish_count = wish_count;
	}
}
