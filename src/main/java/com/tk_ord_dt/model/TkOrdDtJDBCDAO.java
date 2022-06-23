package com.tk_ord_dt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TkOrdDtJDBCDAO implements TkOrdDtDAO_interface{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/movietheater?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
	
	private static final String INSERT_STMT = 
			"INSERT INTO tk_ord_dt (TK_ORD_ID,TK_DT_ID,TK_TYPE_ID,ACT_ID,STATE,SEAT,SELL_PRICE) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
			"SELECT TK_ORD_ID,TK_DT_ID,TK_TYPE_ID,ACT_ID,STATE,SEAT,SELL_PRICE FROM tk_ord_dt order by TK_ORD_ID, TK_DT_ID";
	private static final String GET_ONE_STMT = 
			"SELECT TK_ORD_ID,TK_DT_ID,TK_TYPE_ID,ACT_ID,STATE,SEAT,SELL_PRICE FROM tk_ord_dt where TK_ORD_ID = ? and TK_DT_ID = ?";
	private static final String DELETE = 
			"DELETE FROM tk_ord_dt where TK_ORD_ID = ? and TK_DT_ID = ?";
	private static final String UPDATE = 
			"UPDATE tk_ord_dt set TK_TYPE_ID=?, ACT_ID=?, STATE=?, SEAT=?, SELL_PRICE=? where TK_ORD_ID = ? and TK_DT_ID = ?";

	@Override
	public void insert(TkOrdDtVO tkOrdDtVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setLong(1, tkOrdDtVO.getTkOrdID());
			pstmt.setInt(2, tkOrdDtVO.getTkDtID());
			pstmt.setInt(3, tkOrdDtVO.getTkTypeID());
			pstmt.setInt(4, tkOrdDtVO.getActID());
			pstmt.setByte(5, tkOrdDtVO.getState());
			pstmt.setString(6, tkOrdDtVO.getSeat());
			pstmt.setInt(7, tkOrdDtVO.getSellPrice());

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
	public void update(TkOrdDtVO tkOrdDtVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, tkOrdDtVO.getTkTypeID());
			pstmt.setInt(2, tkOrdDtVO.getActID());
			pstmt.setByte(3, tkOrdDtVO.getState());
			pstmt.setString(4, tkOrdDtVO.getSeat());
			pstmt.setInt(5, tkOrdDtVO.getSellPrice());
			pstmt.setLong(6, tkOrdDtVO.getTkOrdID());
			pstmt.setInt(7, tkOrdDtVO.getTkDtID());
			
			
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
	public void delete(Long tkOrdID, Integer tkDtID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setLong(1, tkOrdID);
			pstmt.setLong(2, tkDtID);
			
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
	public TkOrdDtVO findByPrimaryKey(Long tkOrdID, Integer tkDtID) {

		TkOrdDtVO tkOrdDtVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setLong(1, tkOrdID);
			pstmt.setLong(2, tkDtID);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// tkOrdDtVO 也稱為 Domain objects
				tkOrdDtVO = new TkOrdDtVO();				
				tkOrdDtVO.setTkOrdID(rs.getLong("TK_ORD_ID"));
				tkOrdDtVO.setTkDtID(rs.getInt("TK_DT_ID"));
				tkOrdDtVO.setTkTypeID(rs.getInt("TK_TYPE_ID"));
				tkOrdDtVO.setActID(rs.getInt("ACT_ID"));
				tkOrdDtVO.setState(rs.getByte("STATE"));
				tkOrdDtVO.setSeat(rs.getString("SEAT"));
				tkOrdDtVO.setSellPrice(rs.getInt("SELL_PRICE"));
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
		return tkOrdDtVO;
	}
	
	@Override
	public List<TkOrdDtVO> getAll() {
		List<TkOrdDtVO> list = new ArrayList<TkOrdDtVO>();
		TkOrdDtVO tkOrdDtVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// tkOrdDtVO 也稱為 Domain objects
				tkOrdDtVO = new TkOrdDtVO();
				tkOrdDtVO.setTkOrdID(rs.getLong("TK_ORD_ID"));
				tkOrdDtVO.setTkDtID(rs.getInt("TK_DT_ID"));
				tkOrdDtVO.setTkTypeID(rs.getInt("TK_TYPE_ID"));
				tkOrdDtVO.setActID(rs.getInt("ACT_ID"));
				tkOrdDtVO.setState(rs.getByte("STATE"));
				tkOrdDtVO.setSeat(rs.getString("SEAT"));
				tkOrdDtVO.setSellPrice(rs.getInt("SELL_PRICE"));
				list.add(tkOrdDtVO); // Store the row in the list
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

		TkOrdDtJDBCDAO dao = new TkOrdDtJDBCDAO();

		// 新增
//		TkOrdDtVO tkOrdDtVO1 = new TkOrdDtVO();				
//		tkOrdDtVO1.setTkOrdID(1L);
//		tkOrdDtVO1.setTkDtID(3);		
//		tkOrdDtVO1.setTkTypeID(5);
//		tkOrdDtVO1.setActID(5);
//		tkOrdDtVO1.setState(Byte.valueOf("0"));
//		tkOrdDtVO1.setSeat("A3");
//		tkOrdDtVO1.setSellPrice(234);
//		dao.insert(tkOrdDtVO1);

		// 修改
//		TkOrdDtVO tkOrdDtVO2 = new TkOrdDtVO();
//		tkOrdDtVO2.setTkOrdID(1L);
//		tkOrdDtVO2.setTkDtID(3);
//		tkOrdDtVO2.setTkTypeID(5);
//		tkOrdDtVO2.setActID(5);
//		tkOrdDtVO2.setState(Byte.valueOf("0"));
//		tkOrdDtVO2.setSeat("A4");
//		tkOrdDtVO2.setSellPrice(234);
//		dao.update(tkOrdDtVO2);

		// 刪除
//		dao.delete(1L,3);

		// 查詢
		TkOrdDtVO tkOrdDtVO3 = dao.findByPrimaryKey(1L, 2);
		System.out.print(tkOrdDtVO3.getTkDtID() + ",");
		System.out.print(tkOrdDtVO3.getTkOrdID() + ",");
		System.out.print(tkOrdDtVO3.getTkTypeID() + ",");
		System.out.print(tkOrdDtVO3.getActID() + ",");
		System.out.print(tkOrdDtVO3.getState() + ",");
		System.out.print(tkOrdDtVO3.getSeat() + ",");
		System.out.println(tkOrdDtVO3.getSellPrice());
		System.out.println("---------------------");

		// 查詢
		List<TkOrdDtVO> list = dao.getAll();
		for (TkOrdDtVO aTkOrdDt : list) {
			System.out.print(aTkOrdDt.getTkOrdID() + ",");
			System.out.print(aTkOrdDt.getTkDtID() + ",");
			System.out.print(aTkOrdDt.getTkTypeID() + ",");
			System.out.print(aTkOrdDt.getActID() + ",");
			System.out.print(aTkOrdDt.getState() + ",");
			System.out.print(aTkOrdDt.getSeat() + ",");
			System.out.print(aTkOrdDt.getSellPrice());
			System.out.println();
		}
	}
	
}
