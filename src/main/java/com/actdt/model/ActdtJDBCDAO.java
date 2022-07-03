package com.actdt.model;

import java.sql.*;
import java.util.*;

import com.act.model.ActVO;

public class ActdtJDBCDAO implements ActdtDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/movietheater?serverTimezone=Asia/Taipei"; //連結的MySQL路徑
	String userid = "root"; // MySQL 帳號
	String passwd = "password"; // MySQL 密碼

	/* 新增 */
	private static final String INSERT_STMT = // 宣告變數INSERT_STMT
			"insert into movietheater.activity_detail" 
			+ " (act_id, act_title, tk_type_id, act_discount, act_coupon, act_status) values" 
			+ " (?, ?, ?, ?, ?, ?)";
	
	/* 活動編號單一查詢 */
	private static final String GET_ONE_STMT = 
			"select act_id, act_title, tk_type_id, act_discount, act_coupon, act_status"
			+ " from movietheater.activity_detail where act_id = ?";
	
	
	/* 活動狀態單一查詢 OK */ 
	private static final String GET_STATUS_STMT = 
			"select act_id, act_title, tk_type_id, act_discount, act_coupon, act_status"
			+ " from movietheater.activity_detail where act_status = ?";
	
	
	
	/* 全部查詢 */
	private static final String GET_ALL_STMT = 
			"select act_id, act_title, tk_type_id, act_discount, act_coupon, act_status"
			+ " from movietheater.activity_detail order by act_id";
	/* 修改 */
	private static final String UPDATE = 
			"update movietheater.activity_detail set"
			+ " act_title=?, act_discount=?, act_coupon=?, act_status=?"
			+ " where act_id = ? and tk_type_id = ?" ;
	/* 刪除 */
	private static final String DELETE = 
			"delete from movietheater.activity_detail where act_id = ? and tk_type_id = ?";
	
	@Override /* 新增 */
	public void insert(ActdtVO actdtVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			
			pstmt.setInt(1, actdtVO.getAct_id());
			pstmt.setString(2, actdtVO.getAct_title());
			pstmt.setInt(3, actdtVO.gettkTypeID());
			pstmt.setDouble(4, actdtVO.getAct_discount());
			pstmt.setInt(5, actdtVO.getAct_coupon());
			pstmt.setByte(6, actdtVO.getAct_status());
			
			
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
	public void update(ActdtVO actdtVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);


			pstmt.setString(1, actdtVO.getAct_title());
			pstmt.setDouble(2, actdtVO.getAct_discount());
			pstmt.setInt(3, actdtVO.getAct_coupon());
			pstmt.setByte(4, actdtVO.getAct_status());
			pstmt.setInt(5, actdtVO.getAct_id());
			pstmt.setInt(6, actdtVO.gettkTypeID());


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
	public void delete(Integer Actdt_id, Integer tkTypeID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, Actdt_id);
			pstmt.setInt(2, tkTypeID);

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
	public ActdtVO findByPrimaryKey(Integer act_id, Integer tkTypeID) {
		ActdtVO actdtVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, act_id);
			//pstmt.setInt(2, tkTypeID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// ActdtVo 也稱為 Domain objects
				actdtVO = new ActdtVO();
				actdtVO.setAct_id(rs.getInt("act_id"));
				actdtVO.setAct_title(rs.getString("act_title"));
				actdtVO.settkTypeID(rs.getInt("TK_TYPE_ID"));
				actdtVO.setAct_discount(rs.getDouble("act_discount"));
				actdtVO.setAct_coupon(rs.getInt("act_coupon"));
				actdtVO.setAct_status(rs.getByte("act_status"));
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
		return actdtVO;
	}

	@Override
	public List<ActdtVO> getAll() {
		List<ActdtVO> list = new ArrayList<ActdtVO>();
		ActdtVO actdtVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// ActdtVo 也稱為 Domain objects
				actdtVO = new ActdtVO();
				actdtVO.setAct_id(rs.getInt("act_id"));
				actdtVO.setAct_title(rs.getString("act_title"));
				actdtVO.settkTypeID(rs.getInt("TK_TYPE_ID"));
				actdtVO.setAct_discount(rs.getDouble("act_discount"));
				actdtVO.setAct_coupon(rs.getInt("act_coupon"));
				actdtVO.setAct_status(rs.getByte("act_status"));
				list.add(actdtVO); // Store the row in the list
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
	
	@Override
	public List<ActdtVO> getActdtStatus(Byte act_status) {
		List<ActdtVO> list = new ArrayList<ActdtVO>();
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
				actdtVO.settkTypeID(rs.getInt("TK_TYPE_ID"));
				actdtVO.setAct_discount(rs.getDouble("act_discount"));
				actdtVO.setAct_coupon(rs.getInt("act_coupon"));
				actdtVO.setAct_status(rs.getByte("act_status"));
				list.add(actdtVO); // Store the row in the list
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

	public static void main(String[] args) {

		ActdtJDBCDAO dao = new ActdtJDBCDAO();

		// 新增 OK
		ActdtVO actdtVO1 = new ActdtVO();
		actdtVO1.setAct_id(5);
		actdtVO1.setAct_title("夏日方案");
		actdtVO1.settkTypeID(3);
		actdtVO1.setAct_discount(1.0);
		actdtVO1.setAct_coupon(-50);
		actdtVO1.setAct_status(Byte.valueOf("1"));
		dao.insert(actdtVO1);

		// 修改 OK
//		ActdtVO actdtVO2 = new ActdtVO();
//		actdtVO2.setAct_id(2);
//		actdtVO2.settkTypeID(3);
//		actdtVO2.setAct_title("夏日方案");
//		actdtVO2.setAct_discount(1.0);
//		actdtVO2.setAct_coupon(-50);
//		actdtVO2.setAct_status(Byte.valueOf("1"));
//		dao.update(actdtVO2);


		// 查詢 OK
//		ActdtVO actdtVO3 = dao.findByPrimaryKey(2,2);
//			System.out.print(actdtVO3.getAct_id() + ",");
//			System.out.print(actdtVO3.getAct_title() + ",");
//			System.out.print(actdtVO3.gettkTypeID() + ",");
//			System.out.print(actdtVO3.getAct_discount() + ",");
//			System.out.print(actdtVO3.getAct_coupon() + ",");
//		    System.out.print(actdtVO3.getAct_status() + ",");
//			System.out.println("---------------------");

		// 全部查詢 OK
//		List<ActdtVO> list = dao.getAll();
//		for (ActdtVO aActdt : list) {
//			System.out.print(aActdt.getAct_id() + ",");
//		    System.out.print(aActdt.getAct_title() + ",");
//			System.out.print(aActdt.gettkTypeID() + ",");
//			System.out.print(aActdt.getAct_discount() + ",");
//			System.out.print(aActdt.getAct_coupon() + ",");
//	     	System.out.print(aActdt.getAct_status() + ",");
//			System.out.println();
//			}
			
		// 刪除
//		dao.delete(5,1);


	}
}
