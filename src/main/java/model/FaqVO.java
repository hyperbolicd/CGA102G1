package com.faq.model;
import java.sql.Date;

public class FaqVO implements java.io.Serializable{
	private Integer faq_no;       //FAQ編號
	private String faq_class;     //FAQ類別
	private String faq_title;     //FAQ標題
	private String faq_content;   //FAQ內容
	private Date faq_date;        //FAQ日期
	
	
	public Integer getFaq_no() {
		return faq_no;
	}
	public void setFaq_no(Integer faq_no) {
		this.faq_no = faq_no;
	}
	public String getFaq_class() {
		return faq_class;
	}
	public void setFaq_class(String faq_class) {
		this.faq_class = faq_class;
	}
	public String getFaq_title() {
		return faq_title;
	}
	public void setFaq_title(String faq_title) {
		this.faq_title = faq_title;
	}
	public String getFaq_content() {
		return faq_content;
	}
	public void setFaq_content(String faq_content) {
		this.faq_content = faq_content;
	}
	public Date getFaq_date() {
		return faq_date;
	}
	public void setFaq_date(Date faq_date) {
		this.faq_date = faq_date;
	}
	
}
