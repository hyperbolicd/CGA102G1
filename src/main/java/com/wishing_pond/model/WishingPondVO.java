package com.wishing_pond.model;

import java.sql.*;

public class WishingPondVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer wish_no;
	private Integer wish_option;
	private Integer mv_id;
	private Integer wish_count;
	private Timestamp wish_start;
	private Timestamp wish_end;
	
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
	public Timestamp getWish_start() {
		return wish_start;
	}
	public void setWish_start(Timestamp wish_start) {
		this.wish_start = wish_start;
	}
	public Timestamp getWish_end() {
		return wish_end;
	}
	public void setWish_end(Timestamp wish_end) {
		this.wish_end = wish_end;
	}
}
