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
	private static final String INSERT_STMT = // 宣告變數INSERT_STMT，自動編號不用加：FAQ編號跟FAQ發布時間不用，因為自動生成
			"insert into movietheater.activity_detail" 
			+ " (act_id, tk_type_id, act_discount, act_coupon) values" 
			+ " (?, ?, ?, ?)";
	/* 單一查詢 */
	private static final String GET_ONE_STMT = 
			"select act_id, tk_type_id, act_discount, act_coupon"
			+ " from movietheater.activity_detail where act_id = ?";
	/* 全部查詢 */
	private static final String GET_ALL_STMT = 
			"select act_id, tk_type_id, act_discount, act_coupon"
			+ " from movietheater.activity_detail order by act_id";
	/* 修改 */
	private static final String UPDATE = 
			"update movietheater.activity_detail set"
			+ " act_discount=?, act_coupon=?"
			+ " where act_id = ? and tk_type_id=?" ;
	/* 刪除 */
	private static final String DELETE = 
			"delete from movietheater.activity_detail where act_id = ?";
	
	@Override /* 新增 */
	public void insert(ActdtVO actdtVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, actdtVO.getAct_id());
			pstmt.setInt(2, actdtVO.getTk_type_id());
			pstmt.setDouble(3, actdtVO.getAct_discount());
			pstmt.setInt(4, actdtVO.getAct_coupon());
			
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

			pstmt.setDouble(1, actdtVO.getAct_discount());
			pstmt.setInt(2, actdtVO.getAct_coupon());
			pstmt.setInt(3, actdtVO.getAct_id());
			pstmt.setInt(4, actdtVO.getTk_type_id());
			
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
	public void delete(Integer Actdt_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, Actdt_id);

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
	public ActdtVO findByPrimaryKey(Integer act_id) {
		ActdtVO actdtVO = null;
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
				// ActdtVo 也稱為 Domain objects
				actdtVO = new ActdtVO();
				actdtVO.setAct_id(rs.getInt("act_id"));
				actdtVO.setTk_type_id(rs.getInt("tk_type_id"));
				actdtVO.setAct_discount(rs.getDouble("act_discount"));
				actdtVO.setAct_coupon(rs.getInt("act_coupon"));
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
				actdtVO.setTk_type_id(rs.getInt("tk_type_id"));
				actdtVO.setAct_discount(rs.getDouble("act_discount"));
				actdtVO.setAct_coupon(rs.getInt("act_coupon"));
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

		// 新增
//		ActivitydetailVO actdtVO1 = new ActivitydetailVO();
//		actdtVO1.setAct_id(5);
//		actdtVO1.setTk_type_id(3);
//		actdtVO1.setAct_discount(1.0);
//		actdtVO1.setAct_coupon(-50);
//		dao.insert(actdtVO1);

		// 修改
//		ActivitydetailVO actdtVO2 = new ActivitydetailVO();
//		actdtVO2.setAct_discount(1.0);
//		actdtVO2.setAct_coupon(-50);
//		actdtVO2.setAct_id(2);
//		actdtVO2.setTk_type_id(3);
//		dao.update(actdtVO2);


		// 查詢 OK
//		ActivitydetailVO actdtVO3 = dao.findByPrimaryKey(2);
//			System.out.print(actdtVO3.getAct_id() + ",");
//			System.out.print(actdtVO3.getTk_type_id() + ",");
//			System.out.print(actdtVO3.getAct_discount() + ",");
//			System.out.print(actdtVO3.getAct_coupon() + ",");
//			System.out.println("---------------------");

		// 全部查詢 OK
		List<ActdtVO> list = dao.getAll();
		for (ActdtVO aActdt : list) {
			System.out.print(aActdt.getAct_id() + ",");
			System.out.print(aActdt.getTk_type_id() + ",");
			System.out.print(aActdt.getAct_discount() + ",");
			System.out.print(aActdt.getAct_coupon() + ",");
			System.out.println();
			}
			
		// 刪除
//		dao.delete(5);


	}
}
