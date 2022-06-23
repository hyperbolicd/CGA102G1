package com.emp_privilege.model;

import java.util.List;

public class EmpPrivilegeService {
	EmpPrivilegeDAO_interface dao;
	
	public EmpPrivilegeService() {
		dao = new EmpPrivilegeJDBCDAO();
		// 連線池版
//		dao = new EmpPrivilegeDAO();
	}
	
	public EmpPrivilegeVO addPrivilege(Integer emp_no, Integer fc_no) {
		EmpPrivilegeVO empPrivilegeVO = new EmpPrivilegeVO();
		empPrivilegeVO.setEmp_no(emp_no);
		empPrivilegeVO.setFc_no(fc_no);
		dao.insert(empPrivilegeVO);
		
		return empPrivilegeVO;
	}
	
	public void addPrivilege(EmpPrivilegeVO empPrivilegeVO) {
		dao.insert(empPrivilegeVO);
	}
	
	public void deletePrivilege(Integer empNo, Integer fcNo) {
		dao.delete(empNo, fcNo);
	}
	
	public List<EmpPrivilegeVO> getOneEmpPrivileges(Integer emp_no) {
		return dao.findByEmpNo(emp_no);
	}

	public List<EmpPrivilegeVO> getAll(){
		return dao.getAll();
	}
}
