package com.member.model;

import java.util.List;

import MemberSendEmail.MailService;

public class MemberService {
	
	private MemberDAO_interface dao;

	public MemberService() {
//		dao = new EmpJDBCDAO();
		dao = new MemberJDBCDAO();
	}	
//新增會員
	public MemberVO addMember(String member_Level,String member_Email,String member_Password,String member_Name,String member_Phone,
                  String member_Address, String member_Pic,Integer member_Status,Integer wish_Ticket,Integer bonus_Points,Integer sum_Count) {

		MemberVO memberVO = new MemberVO();
		memberVO.setMember_Level(member_Level);
		memberVO.setMember_Email(member_Email);
		memberVO.setMember_Password(member_Password);
		memberVO.setMember_Name(member_Name);
		memberVO.setMember_Phone(member_Phone);
		memberVO.setMember_Address(member_Address);
		memberVO.setMember_Pic(member_Pic);
		memberVO.setMember_Status(1);
		memberVO.setWish_Ticket(0);
		memberVO.setBonus_Points(0);
		memberVO.setSum_Count(0);
		dao.insert(memberVO);

		return memberVO;
	}

//預留給 Struts 2 或 Spring MVC 用
	public void addMember(MemberVO memberVO) {
		dao.insert(memberVO);
	}
	
	public void update(MemberVO memberVO) {
		dao.update(memberVO);
	}
	
//前台修改會員資料	
	public MemberVO updateMember(Integer member_ID,String member_Password,String member_Name,String member_Phone,
            String member_Address, String member_Pic) {

		MemberVO memberVO = new MemberVO();

		memberVO.setMember_ID(member_ID);
		memberVO.setMember_Password(member_Password);
		memberVO.setMember_Name(member_Name);
		memberVO.setMember_Phone(member_Phone);
		memberVO.setMember_Address(member_Address);
		memberVO.setMember_Pic(member_Pic);
		dao.update(memberVO);

		return dao.findByPrimaryKey(member_ID);
	}

//預留給 Struts 2 用的
	public void updateMem(MemberVO memberVO) {
		dao.update(memberVO);
	}

	public void deleteMem(Integer member_ID) {
		dao.delete(member_ID);
	}

	public MemberVO getOneMem(Integer member_ID) {
		return dao.findByPrimaryKey(member_ID);
	}

	public List<MemberVO> getAll() {
		return dao.getAll();
	}
	
//修改會員狀態	0為啟用 1為啟用 2為停權
	public Integer updateStatus(Integer mem_id,Integer member_Status) {
		dao.updateStatus(mem_id,member_Status);
		return member_Status;
	}
	
//會員登入 	
	public MemberVO loginMember(MemberVO memberVO) {
		
		return dao.loginMember(memberVO);
		
	}
//單一查詢會員	
	public MemberVO getOneMember(Integer member_ID) {
		return dao.findByPrimaryKey(member_ID);
	}
	
//寄送 email
	public void sendMail() {
		String to = "wanlly1993@gmail.com";
		String subject = "密碼通知";

		String ch_name = "JIA";
		String passRandom = "111";
		String messageText = "Hello! " + ch_name + " 請謹記此密碼: " + passRandom + "\n" + " (已經啟用)";
		
		
		MailService	mailService = new MailService();
		mailService.sendMail(to, subject, messageText);
	}
	
	// wish
	public void updateWishTicket(Integer member_id, Integer wish_ticket) {
		dao.updateWishTicket(member_id, wish_ticket);
	}
	
}
