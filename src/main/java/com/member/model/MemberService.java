package com.member.model;

import java.util.List;
import java.util.Random;

import MemberSendEmail.MailService;

public class MemberService {

	private MemberDAO_interface dao;

	public MemberService() {
//		dao = new EmpJDBCDAO();
		dao = new MemberJDBCDAO();
	}

//新增會員
	public MemberVO addMember(String member_Level, String member_Email, String member_Password, String member_Name,
			String member_Phone, String member_Address, String member_Pic, Integer member_Status, Integer wish_Ticket,
			Integer bonus_Points, Integer sum_Count) {

		MemberVO memberVO = new MemberVO();
		memberVO.setMember_Level(member_Level);
		memberVO.setMember_Email(member_Email);
		memberVO.setMember_Password(member_Password);
		memberVO.setMember_Name(member_Name);
		memberVO.setMember_Phone(member_Phone);
		memberVO.setMember_Address(member_Address);
		memberVO.setMember_Pic(member_Pic);
		memberVO.setMember_Status(member_Status);
		memberVO.setWish_Ticket(0);
		memberVO.setBonus_Points(0);
		memberVO.setSum_Count(0);
		dao.insert(memberVO);
		
		
		
		return memberVO;
		
/*-----------------------當會員註冊時會寄送信件更改會員權限--------------------------------*/		
//		memberVO.setMember_ID(member_Status);
//		return member_Status;

		
	}

//預留給 Struts 2 或 Spring MVC 用
	public void addMember(MemberVO memberVO) {
		dao.insert(memberVO);
	}

	public void update(MemberVO memberVO) {
		dao.update(memberVO);
	}

//前台修改會員資料	
	public MemberVO updateMember(Integer member_ID, String member_Password, String member_Name, String member_Phone,
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
	public Integer updateStatus(Integer mem_id, Integer member_Status) {
		dao.updateStatus(mem_id, member_Status);
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

	public void sendMail(String Email) {
		String to = Email;
		List<MemberVO> list = dao.getAll();
		Integer memberID = 0;
		for (MemberVO memberVO : list) {
			if (memberVO.getMember_Email().equals(Email)) {
				memberID = memberVO.getMember_ID();

			}
		}
		MemberVO memberVO = dao.findByPrimaryKey(memberID);
//		String passRandom = "qwe222";
		String subject = "密碼通知";
		String ch_name = "JIA";
		
		
		/*產生亂數6位數*/
		char[] CHARS = { '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L',
				'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 6; i++)
			buffer.append(CHARS[random.nextInt(CHARS.length)]);
		String passRandom = buffer.toString();

		memberVO.setMember_Password(passRandom);
		dao.update(memberVO);
		String messageText = "Hello! " + ch_name + " 請謹記此密碼: " + passRandom + "\n" + " (已經啟用)"
				+ "http://localhost:8081/CGA102G1/front_end/login/login.jsp";

		MailService mailService = new MailService();
		mailService.sendMail(to, subject, messageText);
	}

	// wish
	public void updateWishTicket(Integer member_id, Integer wish_ticket) {
		dao.updateWishTicket(member_id, wish_ticket);
	}
	
	
	//會員註冊時會傳送信件，並修改會員狀態(藉由Email搜尋會員ID)
	public  MemberVO Register(MemberVO memberVO) {
		return dao.register(memberVO);
		
	}

}
