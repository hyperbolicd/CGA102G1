package com.order_detail.model;

public class OrderDetailVO implements java.io.Serializable {
		private Integer merchOrdID;
		private Integer item;
		private Integer merchID;
		private Integer ordCount;
		private Byte ordStatus;
		private Double ordPrice;
		public Integer getMerchOrdID() {
			return merchOrdID;
		}
		public void setMerchOrdID(Integer merchOrdID) {
			this.merchOrdID = merchOrdID;
		}
		public Integer getItem() {
			return item;
		}
		public void setItem(Integer item) {
			this.item = item;
		}
		public Integer getMerchID() {
			return merchID;
		}
		public void setMerchID(Integer merchID) {
			this.merchID = merchID;
		}
		public Integer getOrdCount() {
			return ordCount;
		}
		public void setOrdCount(Integer ordCount) {
			this.ordCount = ordCount;
		}
		public Byte getOrdStatus() {
			return ordStatus;
		}
		public void setOrdStatus(Byte ordStatus) {
			this.ordStatus = ordStatus;
		}
		public Double getOrdPrice() {
			return ordPrice;
		}
		public void setOrdPrice(Double ordPrice) {
			this.ordPrice = ordPrice;
		}
}
