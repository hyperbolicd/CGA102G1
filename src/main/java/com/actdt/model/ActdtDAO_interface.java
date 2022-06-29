package com.actdt.model;

import java.util.*;

public interface ActdtDAO_interface {
          public void insert(ActdtVO ActdtVO); //新增
          public void update(ActdtVO ActdtVO); //修改
          
          public void delete(Integer act_id); //刪除
          
          public ActdtVO findByPrimaryKey(Integer act_id);//查詢
          public List<ActdtVO> getAll();
        //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}


//public interface FaqDAO_interface {
//    public void insert();
//    public void update();
//    public void delete();
//    public  findByPrimaryKey(Integer);
//    public List<> getAll();
//    //萬用複合查詢(傳入參數型態Map)(回傳 List)
////  public List<EmpVO> getAll(Map<String, String[]> map); 
//}