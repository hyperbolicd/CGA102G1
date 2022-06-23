package com.merchandise_inf.model;

import java.sql.Blob;
import java.util.List;

public class MerchService {
	private MerchDAO_interface dao;

	public MerchService() {

		dao = new MerchDAO();
	}
	
	//預留給Spring MVC
	public void addMerch(MerchVO merchVo) {
		dao.insert(merchVo);
	}
	
	public MerchVO addMerch(String merchName, String merchDT, Blob merchPic1, Blob merchPic2, Blob merchPic3, Blob merchPic4, Blob merchPic5, java.sql.Timestamp merchDate, Double merchPrice, String merchClass, Byte merchStatus, Integer merchStock) {
		MerchVO merchVo = new MerchVO();
		
		merchVo.setMerchName(merchName);
		merchVo.setMerchDT(merchDT);
		merchVo.setMerchPic1(merchPic1);
		merchVo.setMerchPic2(merchPic2);
		merchVo.setMerchPic3(merchPic3);
		merchVo.setMerchPic4(merchPic4);
		merchVo.setMerchPic5(merchPic5);
		merchVo.setMerchDate(merchDate);
		merchVo.setMerchPrice(merchPrice);
		merchVo.setMerchClass(merchClass);
		merchVo.setMerchStatus(merchStatus);
		merchVo.setMerchStock(merchStock);
		merchVo.setSoldTotal(merchStock);
		dao.insert(merchVo);
		
		return merchVo;
	}
	
	
	public MerchVO updateMerch(Integer merchID, String merchName, String merchDT, Blob merchPic1, Blob merchPic2, Blob merchPic3, Blob merchPic4, Blob merchPic5, java.sql.Timestamp merchDate, Double merchPrice, String merchClass, Byte merchStatus, Integer merchStock){
		MerchVO merchVo = new MerchVO();
		merchVo.setMerchID(merchID);
		merchVo.setMerchName(merchName);
		merchVo.setMerchDT(merchDT);
		merchVo.setMerchPic1(merchPic1);
		merchVo.setMerchPic2(merchPic2);
		merchVo.setMerchPic3(merchPic3);
		merchVo.setMerchPic4(merchPic4);
		merchVo.setMerchPic5(merchPic5);
		merchVo.setMerchDate(merchDate);
		merchVo.setMerchPrice(merchPrice);
		merchVo.setMerchClass(merchClass);
		merchVo.setMerchStatus(merchStatus);
		merchVo.setMerchStock(merchStock);
		merchVo.setSoldTotal(merchStock);
		dao.update(merchVo);
		
		return dao.findByPrimaryKey(merchID);
	}
	
	public List<MerchVO> getAll(){
		return dao.getAll();
	}
	public List<MerchVO> getByName(String searchName){
		return dao.getByName(searchName);
	}
	
	public MerchVO getOneMerch(Integer merchID) {
		return dao.findByPrimaryKey(merchID);
	}
	
	public void updateMerch(MerchVO merchVo) {
		dao.update(merchVo);
	}
	
	public void deleteMerch(Integer merchID) {
		dao.delete(merchID);
	}
}
