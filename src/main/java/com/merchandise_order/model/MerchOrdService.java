package com.merchandise_order.model;

import java.util.List;

public class MerchOrdService {
	private MerchOrdDAO_interface dao;
	public MerchOrdService() {
		dao = new MerchOrdDAO();
	}
	
	public void addMerchOrd(MerchOrdVO merchOrdVo) {
		dao.insert(merchOrdVo);
	}
	
	public MerchOrdVO addMerchOrd(Integer memberID, java.sql.Timestamp merchOrdDate,Integer merchOrdCount) {
		MerchOrdVO merchOrdVo = new MerchOrdVO();
		
		merchOrdVo.setMemberID(memberID);
		merchOrdVo.setMerchOrdCount(merchOrdCount);
		merchOrdVo.setMerchOrdDate(merchOrdDate);
		dao.insert(merchOrdVo);
		
		return merchOrdVo;
	}
	public MerchOrdVO updateMerchOrd(Integer merchOrdID, Integer memberID, java.sql.Timestamp merchOrdDate,Integer merchOrdCount,Byte merchOrdStatus) {
		MerchOrdVO merchOrdVo = new MerchOrdVO();
		
		merchOrdVo.setMerchOrdID(merchOrdID);
		merchOrdVo.setMemberID(memberID);
		merchOrdVo.setMerchOrdCount(merchOrdCount);
		merchOrdVo.setMerchOrdDate(merchOrdDate);
		merchOrdVo.setMerchOrdStatus(merchOrdStatus);
		dao.update(merchOrdVo);
		
		return dao.findByPrimaryKey(merchOrdID);
		
	}
	
	public List<MerchOrdVO> getAll(){
		return dao.getAll();
	}
	
	public MerchOrdVO getOneMerchOrd(Integer merchOrdID) {
		return dao.findByPrimaryKey(merchOrdID);
	}

	public void updateMerchOrd(MerchOrdVO merchOrdVo) {
		dao.update(merchOrdVo);
	}
	
	public void deleteMerchOrd(Integer MerchOrdID) {
		dao.delete(MerchOrdID);
	}
	
}
