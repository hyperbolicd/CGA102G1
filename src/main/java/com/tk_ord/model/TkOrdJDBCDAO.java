package com.tk_ord.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class TkOrdJDBCDAO implements TkOrdDAO_interface{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/movietheater?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
	
	private static final String INSERT_STMT = 
		"INSERT INTO tk_ord (MEMBER_ID,SH_ID) VALUES (?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT TK_ORD_ID,MEMBER_ID,SH_ID,ORD_TIME FROM tk_ord order by TK_ORD_ID";
	private static final String GET_ONE_STMT = 
		"SELECT TK_ORD_ID,MEMBER_ID,SH_ID,ORD_TIME FROM tk_ord where TK_ORD_ID = ?";
	private static final String DELETE = 
		"DELETE FROM tk_ord where TK_ORD_ID = ?";
	private static final String UPDATE = 
		"UPDATE tk_ord set MEMBER_ID=?, SH_ID=? where TK_ORD_ID = ?";
	
	
	
//	private static final String GET_ALL_MOVIESHOWING =
//	"SELECT SH_ID, MV_NAME,MV_PICTURE,SH_TIME,SH_STATE,SH_TYPE,SH_SEAT_STATE,HL_NAME,HL_ROW,HL_COL FROM showing s JOIN movie m ON s.MV_ID = m.MV_ID JOIN hall h ON s.HL_ID = h.HL_ID";
//	
//	
	
//	@Override
//	public List<MovieAndShowingVO> getAllMovieAndShowing() {
//		List<MovieAndShowingVO> list = new ArrayList<TkOrdVO>();
//		TkOrdVO tkOrdVO = null;
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
//			pstmt = con.prepareStatement(GET_ALL_STMT);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				// tkOrdVO 也稱為 Domain objects
//				tkOrdVO = new TkOrdVO();
//				tkOrdVO.setTkOrdID(rs.getLong("TK_ORD_ID"));
//				tkOrdVO.setMemberID(rs.getInt("MEMBER_ID"));
//				tkOrdVO.setShID(rs.getInt("SH_ID"));
//				tkOrdVO.setOrdTime(rs.getTimestamp("ORD_Time"));
//				list.add(tkOrdVO); // Store the row in the list
//			}
//
//			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
//			// Handle any SQL errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. "
//					+ se.getMessage());
//			// Clean up JDBC resources
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
//		return list;
//	}
	
	@Override
	public void insert(TkOrdVO tkOrdVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, tkOrdVO.getMemberID());
			pstmt.setInt(2, tkOrdVO.getShID());

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

	@Override
	public void update(TkOrdVO tkOrdVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, tkOrdVO.getMemberID());
			pstmt.setInt(2, tkOrdVO.getShID());
			pstmt.setLong(3, tkOrdVO.getTkOrdID());

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

	@Override
	public void delete(Long tkOrdID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setLong(1, tkOrdID);

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

	@Override
	public TkOrdVO findByPrimaryKey(Long tkOrdID) {

		TkOrdVO tkOrdVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setLong(1, tkOrdID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// tkOrdVO 也稱為 Domain objects
				tkOrdVO = new TkOrdVO();
				tkOrdVO.setTkOrdID(rs.getLong("TK_ORD_ID"));
				tkOrdVO.setMemberID(rs.getInt("MEMBER_ID"));
				tkOrdVO.setShID(rs.getInt("SH_ID"));
				tkOrdVO.setOrdTime(rs.getTimestamp("ORD_Time"));

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
		return tkOrdVO;
	}
	
	@Override
	public List<TkOrdVO> getAll() {
		List<TkOrdVO> list = new ArrayList<TkOrdVO>();
		TkOrdVO tkOrdVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// tkOrdVO 也稱為 Domain objects
				tkOrdVO = new TkOrdVO();
				tkOrdVO.setTkOrdID(rs.getLong("TK_ORD_ID"));
				tkOrdVO.setMemberID(rs.getInt("MEMBER_ID"));
				tkOrdVO.setShID(rs.getInt("SH_ID"));
				tkOrdVO.setOrdTime(rs.getTimestamp("ORD_Time"));
				list.add(tkOrdVO); // Store the row in the list
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

		TkOrdJDBCDAO dao = new TkOrdJDBCDAO();

		// 新增
//		TkOrdVO tkOrdVO1 = new TkOrdVO();
//		tkOrdVO1.setMemberID(1);
//		tkOrdVO1.setShID(1);
//		dao.insert(tkOrdVO1);

		// 修改
//		TkOrdVO tkOrdVO2 = new TkOrdVO();
//		tkOrdVO2.setTkOrdID(5L);
//		tkOrdVO2.setMemberID(1);
//		tkOrdVO2.setShID(2);
//		dao.update(tkOrdVO2);

		// 刪除
//		dao.delete(5L);

		// 查詢
		TkOrdVO tkOrdVO3 = dao.findByPrimaryKey(4L);
		System.out.print(tkOrdVO3.getTkOrdID() + ",");
		System.out.print(tkOrdVO3.getMemberID() + ",");
		System.out.print(tkOrdVO3.getShID() + ",");
		System.out.print(tkOrdVO3.getOrdTime() + ",");
		System.out.println("---------------------");

		// 查詢
		List<TkOrdVO> list = dao.getAll();
		for (TkOrdVO aTkOrdVO : list) {
			System.out.print(aTkOrdVO.getTkOrdID() + ",");
			System.out.print(aTkOrdVO.getMemberID() + ",");
			System.out.print(aTkOrdVO.getShID() + ",");
			System.out.print(aTkOrdVO.getOrdTime() + ",");
			System.out.println();
		}
	}
}
