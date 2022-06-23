package com.emp_privilege.model;

import java.util.*;

public interface EmpPrivilegeDAO_interface {
	public void insert(EmpPrivilegeVO empPrivilegeVO);
	public void delete(Integer empNo, Integer fcNo);
//	public void update(EmpPrivilegeVO empPrivilegeVO);
	public List<EmpPrivilegeVO> findByEmpNo(Integer empNo);
	public List<EmpPrivilegeVO> getAll();
}
