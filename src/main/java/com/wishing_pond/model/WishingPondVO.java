package com.wishing_pond.model;

import java.sql.*;

public class WishingPondVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer wish_no;
	private String wish_name;
	private Timestamp wish_start;
	private Timestamp wish_end;
	private Integer top_one;
	
	public String getWish_name() {
		return wish_name;
	}
	public void setWish_name(String wish_name) {
		this.wish_name = wish_name;
	}
	public Integer getTop_one() {
		return top_one;
	}
	public void setTop_one(Integer top_one) {
		this.top_one = top_one;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getWish_no() {
		return wish_no;
	}
	public void setWish_no(Integer wish_no) {
		this.wish_no = wish_no;
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
