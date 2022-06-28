package com.act.model;

import java.sql.*;
import java.util.*;

public class ActJDBCDAO implements ActDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/movietheater?serverTimezone=Asia/Taipei"; //連結的MySQL路徑
	String userid = "root"; // MySQL 帳號
	String passwd = "password"; // MySQL 密碼

	/* 新增 */
	private static final String INSERT_STMT = // 宣告變數INSERT_STMT，自動編號不用加：Act編號不用，因為自動生成
			"insert into movietheater.activity" 
			+ " (act_picture, act_title, act_subtitle, act_content, act_time_start, act_time_end, act_status) values" 
			+ " (?, ?, ?, ?, ?, ?, ?)";
	/* 單一查詢 */
	private static final String GET_ONE_STMT = 
			"select act_id, act_picture, act_title, act_subtitle, act_content, act_time_start, act_time_end, act_status"
			+ " from movietheater.activity where act_id = ?";
	/* 全部查詢 */
	private static final String GET_ALL_STMT = 
			"select act_id, act_picture, act_title, act_subtitle, act_content, act_time_start, act_time_end, act_status"
			+ " from movietheater.activity order by act_id";
	/* 修改 */
	private static final String UPDATE = 
			"update movietheater.activity set"
			+ " act_picture=?, act_title=?, act_subtitle=?, act_content=?, act_time_start=?, act_time_end=?, act_status=?"
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
			pstmt.setString(2, actVO.getAct_title());
			pstmt.setString(3, actVO.getAct_subtitle());
			pstmt.setString(4, actVO.getAct_content());
			pstmt.setTimestamp(5, actVO.getAct_time_start());
			pstmt.setTimestamp(6, actVO.getAct_time_end());
			pstmt.setInt(7, actVO.getAct_status());


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
			pstmt.setString(2, actVO.getAct_title());
			pstmt.setString(3, actVO.getAct_subtitle());
			pstmt.setString(4, actVO.getAct_content());
			pstmt.setTimestamp(5, actVO.getAct_time_start());
			pstmt.setTimestamp(6, actVO.getAct_time_end());
			pstmt.setInt(7, actVO.getAct_status());
			pstmt.setInt(8, actVO.getAct_id());
			
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
				actVO.setAct_title(rs.getString("act_title"));
				actVO.setAct_subtitle(rs.getString("act_subtitle"));
				actVO.setAct_content(rs.getString("act_content"));
				actVO.setAct_time_start(rs.getTimestamp("act_time_start"));
				actVO.setAct_time_end(rs.getTimestamp("act_time_end"));
				actVO.setAct_status(rs.getByte("act_status"));
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
				actVO.setAct_title(rs.getString("act_title"));
				actVO.setAct_subtitle(rs.getString("act_subtitle"));
				actVO.setAct_content(rs.getString("act_content"));
				actVO.setAct_time_start(rs.getTimestamp("act_time_start"));
				actVO.setAct_time_end(rs.getTimestamp("act_time_end"));
				actVO.setAct_status(rs.getByte("act_status"));
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

	public static void main(String[] args) {

		ActJDBCDAO dao = new ActJDBCDAO();

		// 新增
//		ActivityVO actVO1 = new ActivityVO();
//		actVO1.setAct_picture(" ");
//		actVO1.setAct_title("夏日方案");
//		actVO1.setAct_subtitle("夏日觀影趣 樂FUN一下");
//		actVO1.setAct_content("凡購買05/25(三)~06/12(日)任一電影票，即享20元折價優惠");
//		actVO1.setAct_time_start(java.sql.Timestamp.valueOf("2022-05-25 04:00:00"));
//		actVO1.setAct_time_end(java.sql.Timestamp.valueOf("2022-06-13 04:00:00"));
//		actVO1.setAct_status(1);
//		dao.insert(actVO1);

		// 修改
//		ActivityVO actVO2 = new ActivityVO();
//		actVO2.setAct_id(3);
//		actVO2.setAct_picture(" ");
//		actVO2.setAct_title("夏日方案");
//		actVO2.setAct_subtitle("夏日觀影趣 樂FUN一下");
//		actVO2.setAct_content("凡購買05/25(三)~06/12(日)任一電影票，即享20元折價優惠");
//		actVO2.setAct_time_start(java.sql.Timestamp.valueOf("2022-06-07 06:00:00"));
//		actVO2.setAct_time_end(java.sql.Timestamp.valueOf("2022-06-07 06:00:00"));
//		actVO2.setAct_status(1);
//		dao.update(actVO2);


		// 查詢 OK
//		ActivityVO actVO3 = dao.findByPrimaryKey(3);
//			System.out.print(actVO3.getAct_id() + ",");
//			System.out.print(actVO3.getAct_picture() + ",");
//			System.out.print(actVO3.getAct_title() + ",");
//			System.out.print(actVO3.getAct_subtitle() + ",");
//			System.out.print(actVO3.getAct_content() + ",");
//			System.out.print(actVO3.getAct_time_start() + ",");
//			System.out.print(actVO3.getAct_time_end() + ",");
//			System.out.print(actVO3.getAct_status() + ",");
//			System.out.println("---------------------");

		// 全部查詢 OK
//		List<ActVO> list = dao.getAll();
//		for (ActVO aAct : list) {
//			System.out.print(aAct.getAct_id() + ",");
//			System.out.print(aAct.getAct_picture() + ",");
//			System.out.print(aAct.getAct_title() + ",");
//			System.out.print(aAct.getAct_subtitle() + ",");
//			System.out.print(aAct.getAct_content() + ",");
//			System.out.print(aAct.getAct_time_start() + ",");
//			System.out.print(aAct.getAct_time_end() + ",");
//			System.out.print(aAct.getAct_status() + ",");
//			System.out.println();
//			}
			
		// 刪除
//		dao.delete(5);


	}

	@Override
	public void actStatus(Integer act_id) {
		// TODO Auto-generated method stub
		
	}
}
