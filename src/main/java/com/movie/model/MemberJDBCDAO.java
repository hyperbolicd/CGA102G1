package com.movie.model;

import java.util.*;

import java.sql.*;


import java.sql.*;

public class MemberJDBCDAO implements MemberDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/movietheater?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String INSERT = 				//新增資料 
		 "insert into `member`"
		 +"(MEMBER_LEVEL,MEMBER_EMAIL,MEMBER_PASSWORD,MEMBER_NAME,MEMBER_PHONE,MEMBER_ADDRESS,MEMBER_PIC) VALUES"
		 + "(?,?,?,?,?,?,?) ;";
	private static final String GET_ALL_MEM =     		//查詢全部資料
		"select MEMBER_ID,MEMBER_LEVEL,MEMBER_EMAIL,MEMBER_PASSWORD,MEMBER_NAME,MEMBER_PHONE,MEMBER_ADDRESS,MEMBER_PIC,MEMBER_STATUS,WISH_TICKET,BONUS_POINTS,SUM_COUNT "
		+ "from member order by MEMBER_ID ";
	private static final String GET_ONE_STMT =  		//查詢單筆資料
		"select MEMBER_ID,MEMBER_LEVEL,MEMBER_EMAIL,MEMBER_PASSWORD,MEMBER_NAME,MEMBER_PHONE,MEMBER_ADDRESS,MEMBER_PIC,MEMBER_STATUS,WISH_TICKET,BONUS_POINTS,SUM_COUNT " 
		+"from member where (MEMBER_ID = ?);";
	private static final String UPDATE =      			//修改資料
		"UPDATE `member`"
		+"set  MEMBER_PASSWORD = ?, MEMBER_NAME = ?, MEMBER_PHONE = ?, MEMBER_ADDRESS = ?,MEMBER_PIC= ?"
		+"where (MEMBER_ID = ?);";
	private static final String DELETE =                //刪除資料
	     "DELETE FROM member where MEMBER_ID = ?";
	     
	
	public void insert(MemberVO memberVO) {

		Connection con = null;          //宣告連線物件，以便可以在finally中關閉
		PreparedStatement pstmt = null; //宣告語句物件，以便可以在finally中關閉

		try {

			Class.forName(driver); //反射機制  載入驅動類，不同資料庫軟體驅動類不同
			con = DriverManager.getConnection(url, userid, passwd);//使用DriverManager獲得連線物件，其中url每個資料庫不同
			pstmt = con.prepareStatement(INSERT);

			pstmt.setString(1, memberVO.getMember_Level());
			pstmt.setString(2, memberVO.getMember_Email());
			pstmt.setString(3, memberVO.getMember_Password());
			pstmt.setString(4, memberVO.getMember_Name());
			pstmt.setString(5, memberVO.getMember_Phone());
			pstmt.setString(6, memberVO.getMember_Address());
			pstmt.setString(7, memberVO.getMember_Pic());


			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	
	public void update(MemberVO memberVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, memberVO.getMember_Password());
			pstmt.setString(2, memberVO.getMember_Name());
			pstmt.setString(3, memberVO.getMember_Phone());
			pstmt.setString(4, memberVO.getMember_Address());
			pstmt.setString(5, "");//照片處理
			pstmt.setInt(6, memberVO.getMember_ID());
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
	}
	
	public void delete(Integer member_ID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, member_ID);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

//單筆查詢
public MemberVO findByPrimaryKey(Integer member_ID) {

	MemberVO memberVO = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {

		Class.forName(driver);
		con = DriverManager.getConnection(url, userid, passwd);
		pstmt = con.prepareStatement(GET_ONE_STMT);

		pstmt.setInt(1, member_ID);

		rs = pstmt.executeQuery();

		while (rs.next()) {
			// empVo 也稱為 Domain objects
			memberVO = new MemberVO();
			memberVO.setMember_ID(rs.getInt("member_ID"));
			memberVO.setMember_Level(rs.getString("member_Level"));
			memberVO.setMember_Email(rs.getString("member_Email"));
			memberVO.setMember_Password(rs.getString("member_Password"));
			memberVO.setMember_Name(rs.getString("member_Name"));
			memberVO.setMember_Phone(rs.getString("member_Phone"));
			memberVO.setMember_Address(rs.getString("member_Address"));
			memberVO.setMember_Pic(rs.getString("member_Pic"));
			memberVO.setMember_Status(rs.getInt("member_Status"));
			memberVO.setWish_Ticket(rs.getInt("wish_Ticket"));
			memberVO.setBonus_Points(rs.getInt("bonus_Points"));
			memberVO.setSum_Count(rs.getInt("sum_Count"));
		}

		// Handle any driver errors
	} catch (ClassNotFoundException e) {
		throw new RuntimeException("Couldn't load database driver. "
				+ e.getMessage());
		// Handle any SQL errors
	} catch (SQLException se) {
		throw new RuntimeException("A database error occured. "
				+ se.getMessage());
		// Clean up JDBC resources
	} finally {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}
	return memberVO;
}

//@Override
public List<MemberVO> getAll() {
	List<MemberVO> list = new ArrayList<MemberVO>();
	MemberVO memberVO = null;

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {

		Class.forName(driver);
		con = DriverManager.getConnection(url, userid, passwd);
		pstmt = con.prepareStatement(GET_ALL_MEM);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			// empVO 也稱為 Domain objects
			memberVO = new MemberVO();
			memberVO.setMember_ID(rs.getInt("member_ID"));
			memberVO.setMember_Level(rs.getString("member_Level"));
			memberVO.setMember_Email(rs.getString("member_Email"));
			memberVO.setMember_Password(rs.getString("member_Password"));
			memberVO.setMember_Name(rs.getString("member_Name"));
			memberVO.setMember_Phone(rs.getString("member_Phone"));
			memberVO.setMember_Address(rs.getString("member_Address"));
			memberVO.setMember_Pic(rs.getString("member_Pic"));
			memberVO.setMember_Status(rs.getInt("member_Status"));
			memberVO.setWish_Ticket(rs.getInt("wish_Ticket"));
			memberVO.setBonus_Points(rs.getInt("bonus_Points"));
			memberVO.setSum_Count(rs.getInt("sum_Count"));
			list.add(memberVO); // Store the row in the list
		}

		// Handle any driver errors
	} catch (ClassNotFoundException e) {
		throw new RuntimeException("Couldn't load database driver. "
				+ e.getMessage());
		// Handle any SQL errors
	} catch (SQLException se) {
		throw new RuntimeException("A database error occured. "
				+ se.getMessage());
		// Clean up JDBC resources
	} finally {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}
	return list;
}




	public static void main(String[] args) {


		MemberJDBCDAO dao = new MemberJDBCDAO();

		// 新增
//				MemberVO memberVO = new MemberVO();
//				memberVO.setMemeber_Email("wanlly1993@gmail.com");
//				memberVO.setMember_Password("rt678345");
//				memberVO.setMember_Name("王移加");
//				memberVO.setMember_Phone("0967854321");
//				memberVO.setMember_Address("桃園市中壢區");
//				memberVO.setMember_Pic(null);
//				memberVO.setMember_Level("C");
//				dao.insert(memberVO);

		// 修改
				
//		MemberVO memberVO = new MemberVO();
//		memberVO.setMember_Password("WE456789");
//		memberVO.setMember_Name("王嘉惠");
//		memberVO.setMember_Phone("0915775234");
//		memberVO.setMember_Address("桃園市平鎮區");
//		memberVO.setMember_Pic("");	
//		memberVO.setMember_ID(11);
//		dao.update(memberVO);

		// 刪除
//		dao.delete(11);

//		 查詢
//		MemberVO member = dao.findByPrimaryKey();
//		System.out.print(member.getMember_ID() + ",");
//		System.out.print(member.getMember_Level() + ",");
//		System.out.print(member.getMemeber_Email() + ",");
//		System.out.print(member.getMember_Password() + ",");
//		System.out.print(member.getMember_Name() + ",");
//		System.out.print(member.getMember_Phone() + ",");
//		System.out.print(member.getMember_Address() + ",");
//		System.out.print(member.getMember_Pic() + ",");
//		System.out.print(member.getMember_Status() + ",");
//		System.out.print(member.getWish_Ticket() + ",");
//		System.out.print(member.getBonus_Points() + ",");
//		System.out.println(member.getSum_Count());
//		System.out.println("---------------------");

		// 查詢
//		List<MemberVO> list = dao.getAll();
//		for (MemberVO aMem : list) {
//			System.out.print(aMem.getMember_ID() + ",");
//			System.out.print(aMem.getMember_Level() + ",");
//			System.out.print(aMem.getMemeber_Email() + ",");
//			System.out.print(aMem.getMember_Password() + ",");
//			System.out.print(aMem.getMember_Name() + ",");
//			System.out.print(aMem.getMember_Phone() + ",");
//			System.out.print(aMem.getMember_Address() + ",");
//			System.out.print(aMem.getMember_Pic() + ",");
//			System.out.print(aMem.getMember_Status() + ",");
//			System.out.print(aMem.getWish_Ticket() + ",");
//			System.out.print(aMem.getBonus_Points() + ",");
//			System.out.print(aMem.getSum_Count());
//			System.out.println();
//		}

	}

}


  

	
	

