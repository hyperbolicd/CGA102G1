package com.tk_ord.model;



public class Order {
		private TKorder[] TKorders;
		private FDorder[] FDorders;
		private String[] seatindex;
		private Integer MemberID;
		private Integer SH_ID;
		public TKorder[] getTKorders() {
			return TKorders;
		}
		public void setTKorder(TKorder[] tKorders) {
			TKorders = tKorders;
		}
		public FDorder[] getFDorders() {
			return FDorders;
		}
		public void setFDorder(FDorder[] fDorders) {
			FDorders = fDorders;
		}
		public String[] getSeatindex() {
			return seatindex;
		}
		public void setSeatindex(String[] seatindex) {
			this.seatindex = seatindex;
		}
		public Integer getMemberID() {
			return MemberID;
		}
		public void setMemberID(Integer memberID) {
			MemberID = memberID;
		}
		public Integer getSH_ID() {
			return SH_ID;
		}
		public void setSH_ID(Integer sH_ID) {
			SH_ID = sH_ID;
		}
		
		
}
