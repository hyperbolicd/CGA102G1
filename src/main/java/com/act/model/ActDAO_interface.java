package com.act.model;

import java.util.*;
import com.actdt.model.ActdtVO;

public interface ActDAO_interface {

	public void insert(ActVO actVO); // 新增

	public void update(ActVO actVO); // 修改

	public void delete(Integer act_id); // 刪除

	public ActVO findByPrimaryKey(Integer act_id); // 查詢

	public List<ActVO> getAll(); // 全部查詢
	

    
    //查詢已上架活動的票種(一對多)(回傳 Set)
    public Set<ActdtVO> getActdtStatus(Byte act_status);
    
}