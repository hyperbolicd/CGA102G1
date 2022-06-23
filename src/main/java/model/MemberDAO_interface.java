package com.member.model;

import java.util.*;

public interface MemberDAO_interface {
    public void insert(MemberVO memberVO);					//新增
    public void update(MemberVO memberVO);					//修改
    public void delete(Integer memberVO);					//刪除
    public MemberVO findByPrimaryKey(Integer member_ID);		//查詢
    public List<MemberVO> getAll();						//查詢(全部)
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
}
