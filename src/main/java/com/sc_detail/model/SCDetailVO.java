package com.sc_detail.model;

public class SCDetailVO implements java.io.Serializable {
	private Integer memberID;
	private Integer merchID;
	private Integer scCount;
	public Integer getMemberID() {
		return memberID;
	}
	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}
	public Integer getMerchID() {
		return merchID;
	}
	public void setMerchID(Integer merchID) {
		this.merchID = merchID;
	}
	public Integer getScCount() {
		return scCount;
	}
	public void setScCount(Integer scCount) {
		this.scCount = scCount;
	}
}
