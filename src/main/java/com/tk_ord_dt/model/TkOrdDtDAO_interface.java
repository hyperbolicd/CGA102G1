package com.tk_ord_dt.model;

import java.util.List;

public interface TkOrdDtDAO_interface {
	public void insert(TkOrdDtVO tkOrdDtVO);
    public void update(TkOrdDtVO tkOrdDtVO);
    public void delete(Long tkOrdID, Integer tkDtID);
    public TkOrdDtVO findByPrimaryKey(Long tkOrdID, Integer tkDtID);
    public List<TkOrdDtVO> getAll();
  //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<TkOrdDtVO> getAll(Map<String, String[]> map); 

}
