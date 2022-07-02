package com.act.model;

import java.sql.*;
import java.util.*;

import com.actdt.model.ActdtVO;
import com.tk_ord_dt.model.TkOrdDtVO;
import com.actdt.model.ActdtJDBCDAO;

public class ActJDBCDAO implements ActDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/movietheater?serverTimezone=Asia/Taipei"; //連結的MySQL路徑
	String userid = "root"; // MySQL 帳號
	String passwd = "password"; // MySQL 密碼

	/* 新增 */
	private static final String INSERT_STMT = // 宣告變數INSERT_STMT，自動編號不用加：Act編號不用，因為自動生成
			"insert into activity" 
			+ " (act_picture, act_subtitle, act_content, act_date_start, act_date_end) values" 
			+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	/* 單一查詢 */
	private static final String GET_ONE_STMT = 
			"select act_id, act_picture, act_subtitle, act_content, act_date_start, act_date_end"
			+ " from movietheater.activity where act_id = ?";
	
	/* 全部查詢 */
	private static final String GET_ALL_STMT = 
			"select act_id, act_picture, act_subtitle, act_content, act_date_start, act_date_end"
			+ " from movietheater.activity order by act_id";
	
	
	// 查詢票種
	private static final String GET_STATUS_STMT = 			
			"select act_id, act_title, tk_type_id, act_discount, act_coupon, act_status"
			+ " from movietheater.activity_detail where act_status = ?";

	
	
	/* 修改 */
	private static final String UPDATE = 
			"update movietheater.activity set"
			+ " act_picture=?, act_subtitle=?, act_content=?, act_date_start=?, act_date_end=?"
			+ " where act_id = ?";
	/* 刪除 */
	private static final String DELETE = 
			"delete from movietheater.activity where act_id = ?";
	
	
	
	
	
	@Override /* 新增 */
	public void insert(ActVO actVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setBytes(1, actVO.getAct_picture());
			pstmt.setString(2, actVO.getAct_subtitle());
			pstmt.setString(3, actVO.getAct_content());
			pstmt.setDate(4, actVO.getAct_date_start());
			pstmt.setDate(5, actVO.getAct_date_end());
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// Handle any SQL errors
		} catch (SQLException e) {
			e.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override //修改
	public void update(ActVO actVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setBytes(1, actVO.getAct_picture());
			pstmt.setString(2, actVO.getAct_subtitle());
			pstmt.setString(3, actVO.getAct_content());
			pstmt.setDate(4, actVO.getAct_date_start());
			pstmt.setDate(5, actVO.getAct_date_end());
			pstmt.setInt(6, actVO.getAct_id());
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// Handle any SQL errors
		} catch (SQLException e) {
			e.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override //刪除
	public void delete(Integer Act_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, Act_id);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// Handle any SQL errors
		} catch (SQLException e) {
			e.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public ActVO findByPrimaryKey(Integer act_id) {
		ActVO actVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, act_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// ActVo 也稱為 Domain objects
				actVO = new ActVO();
				actVO.setAct_id(rs.getInt("act_id"));
				actVO.setAct_picture(rs.getBytes("act_picture"));
				actVO.setAct_subtitle(rs.getString("act_subtitle"));
				actVO.setAct_content(rs.getString("act_content"));
				actVO.setAct_date_start(rs.getDate("act_date_start"));
				actVO.setAct_date_end(rs.getDate("act_date_end"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// Handle any SQL errors
		} catch (SQLException e) {
			e.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return actVO;
	}

	@Override
	public List<ActVO> getAll() {
		List<ActVO> list = new ArrayList<ActVO>();
		ActVO actVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// ActVo 也稱為 Domain objects
				actVO = new ActVO();
				actVO.setAct_id(rs.getInt("act_id"));
				actVO.setAct_picture(rs.getBytes("act_picture"));
				actVO.setAct_subtitle(rs.getString("act_subtitle"));
				actVO.setAct_content(rs.getString("act_content"));
				actVO.setAct_date_start(rs.getDate("act_date_start"));
				actVO.setAct_date_end(rs.getDate("act_date_end"));
				list.add(actVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
			e.printStackTrace();
			// Handle any SQL errors
		} catch (SQLException e) {
//			throw new RuntimeException("A database error occured. "
//					+ e.getMessage());
			e.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	
//	@Override
//	public List<ActdtVO> getActdtStatus(Byte act_status) {
//		List<ActdtVO> list = new ArrayList<ActdtVO>();
//		ActdtVO actdtVO = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
//			pstmt = con.prepareStatement(GET_STATUS_STMT);
//			pstmt.setByte(1, act_status);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				// ActdtVo 也稱為 Domain objects
//				actdtVO = new ActdtVO();
//				actdtVO.setAct_id(rs.getInt("act_id"));
//				actdtVO.setAct_title(rs.getString("act_title"));
//				actdtVO.setTk_type_id(rs.getInt("tk_type_id"));
//				actdtVO.setAct_discount(rs.getDouble("act_discount"));
//				actdtVO.setAct_coupon(rs.getInt("act_coupon"));
//				actdtVO.setAct_status(rs.getByte("act_status"));
//				list.add(actdtVO); // Store the row in the list
//			}
//
//			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
////			throw new RuntimeException("Couldn't load database driver. "
////					+ e.getMessage());
//			e.printStackTrace();
//			// Handle any SQL errors
//		} catch (SQLException e) {
////			throw new RuntimeException("A database error occured. "
////					+ e.getMessage());
//			e.printStackTrace();
//			// Clean up JDBC resources
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return list;
//	}
	
	
	@Override
	public Set<ActdtVO> getActdtStatus(Byte act_status) {
		Set<ActdtVO> set = new HashSet<ActdtVO>();
		ActdtVO actdtVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_STATUS_STMT);
			pstmt.setByte(1, act_status);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// ActdtVo 也稱為 Domain objects
				actdtVO = new ActdtVO();
				actdtVO.setAct_id(rs.getInt("act_id"));
				actdtVO.setAct_title(rs.getString("act_title"));
				actdtVO.setTk_type_id(rs.getInt("tk_type_id"));
				actdtVO.setAct_discount(rs.getDouble("act_discount"));
				actdtVO.setAct_coupon(rs.getInt("act_coupon"));
				actdtVO.setAct_status(rs.getByte("act_status"));
				set.add(actdtVO); // Store the row in the list
			}
			
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return set;
		
	}
	
	
	

	public static void main(String[] args) {

		ActJDBCDAO dao = new ActJDBCDAO();

		// 新增 OK
//		ActVO actVO1 = new ActVO();
//		actVO1.setAct_picture(null);
//		actVO1.setAct_subtitle("夏日觀影趣 樂FUN一下");
//		actVO1.setAct_content("凡購買05/25(三)~06/12(日)任一電影票，即享20元折價優惠");
//		actVO1.setAct_date_start(java.sql.Date.valueOf("2022-05-25"));
//		actVO1.setAct_date_end(java.sql.Date.valueOf("2022-06-13"));
//		dao.insert(actVO1);

		// 修改
//		ActVO actVO2 = new ActivityVO();
//		actVO2.setAct_id(3);
//		actVO2.setAct_picture(" ");
//		actVO2.setAct_subtitle("夏日觀影趣 樂FUN一下");
//		actVO2.setAct_content("凡購買05/25(三)~06/12(日)任一電影票，即享20元折價優惠");
//		actVO2.setAct_date_start(java.sql.Date.valueOf("2022-06-07"));
//		actVO2.setAct_date_end(java.sql.Date.valueOf("2022-06-07"));
//		dao.update(actVO2);


		// 查詢 OK
//		ActVO actVO3 = dao.findByPrimaryKey(3);
//			System.out.print(actVO3.getAct_id() + ",");
//			System.out.print(actVO3.getAct_picture() + ",");
//			System.out.print(actVO3.getAct_subtitle() + ",");
//			System.out.print(actVO3.getAct_content() + ",");
//			System.out.print(actVO3.getAct_date_start() + ",");
//			System.out.print(actVO3.getAct_date_end() + ",");
//			System.out.println("---------------------");

		// 全部查詢 OK
//		List<ActVO> list = dao.getAll();
//		for (ActVO aAct : list) {
//			System.out.print(aAct.getAct_id() + ",");
//			System.out.print(aAct.getAct_picture() + ",");
//			System.out.print(aAct.getAct_subtitle() + ",");
//			System.out.print(aAct.getAct_content() + ",");
//			System.out.print(aAct.getAct_date_start() + ",");
//			System.out.print(aAct.getAct_date_end() + ",");
//			System.out.println();
//			}
			
		// 刪除
//		dao.delete(5);


	}

}
