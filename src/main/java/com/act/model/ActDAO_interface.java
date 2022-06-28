package com.act.model;

import java.util.*;

public interface ActDAO_interface {
          public void insert(ActVO actVO); //新增
          public void update(ActVO avtVO); //修改
          
          public void delete(Integer act_id); //刪除
          
          public ActVO findByPrimaryKey(Integer act_id); //查詢
          public List<ActVO> getAll();
          
          public void actStatus(Integer act_id);
          
          
        //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}


//public interface ActivityDAO_interface {
//    public void insert();
//    public void update();
//    public void delete();
//    public  findByPrimaryKey(Integer);
//    public List<> getAll();
//    //萬用複合查詢(傳入參數型態Map)(回傳 List)
////  public List<EmpVO> getAll(Map<String, String[]> map); 
//}