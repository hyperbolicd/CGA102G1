package com.emp_privilege.model;

import java.sql.Connection;
import java.util.List;

public interface EmpPrivilegeDAO_interface {
	public void insert(EmpPrivilegeVO empPrivilegeVO);
	public void insert(EmpPrivilegeVO empPrivilegeVO, Connection con);
	public void delete(Integer empNo, Integer fcNo);
	public void update(List<EmpPrivilegeVO> empPrivilegeVOs);
	public List<EmpPrivilegeVO> findByEmpNo(Integer empNo);
	public List<EmpPrivilegeVO> getAll();
}
