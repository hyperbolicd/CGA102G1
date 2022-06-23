package com.fd_ord_dt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FdOrdDtJDBCDAO implements FdOrdDtDAO_interface{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/movietheater?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
	
	private static final String INSERT_STMT = 
			"INSERT INTO fd_ord_dt (TK_ORD_ID,FD_ID,FD_COUNT,FD_STATE,SELL_PRICE) VALUES (?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
			"SELECT FD_DT_ID,TK_ORD_ID,FD_ID,FD_COUNT,FD_STATE,SELL_PRICE FROM fd_ord_dt order by FD_DT_ID";
	private static final String GET_ONE_STMT = 
			"SELECT FD_DT_ID,TK_ORD_ID,FD_ID,FD_COUNT,FD_STATE,SELL_PRICE FROM fd_ord_dt where FD_DT_ID= ?";
	private static final String DELETE = 
			"DELETE FROM fd_ord_dt where FD_DT_ID= ?";
	private static final String UPDATE = 
			"UPDATE fd_ord_dt set TK_ORD_ID= ?, FD_ID=?, FD_COUNT=?, FD_STATE=?, SELL_PRICE=? where FD_DT_ID= ?";
	
	@Override
	public void insert(FdOrdDtVO fdOrdDtVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setLong(1, fdOrdDtVO.getTkOrdID());
			pstmt.setInt(2, fdOrdDtVO.getFdID());
			pstmt.setInt(3, fdOrdDtVO.getFdCount());
			pstmt.setByte(4, fdOrdDtVO.getFdState());
			pstmt.setInt(5, fdOrdDtVO.getSellPrice());

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
	public void update(FdOrdDtVO fdOrdDtVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setLong(1, fdOrdDtVO.getTkOrdID());	
			pstmt.setInt(2, fdOrdDtVO.getFdID());
			pstmt.setInt(3, fdOrdDtVO.getFdCount());
			pstmt.setByte(4, fdOrdDtVO.getFdState());
			pstmt.setInt(5, fdOrdDtVO.getSellPrice());
			pstmt.setLong(6, fdOrdDtVO.getFdDtID());
					
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
	public void delete(Long fdDtID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setLong(1, fdDtID);

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
	public FdOrdDtVO findByPrimaryKey(Long fdDtID) {

		FdOrdDtVO fdOrdDtVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setLong(1, fdDtID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// fdOrdDtVO 也稱為 Domain objects
				fdOrdDtVO = new FdOrdDtVO();
				fdOrdDtVO.setFdDtID(rs.getLong("FD_DT_ID"));
				fdOrdDtVO.setTkOrdID(rs.getLong("TK_ORD_ID"));
				fdOrdDtVO.setFdID(rs.getInt("FD_ID"));
				fdOrdDtVO.setFdCount(rs.getInt("FD_COUNT"));
				fdOrdDtVO.setFdState(rs.getByte("FD_STATE"));
				fdOrdDtVO.setSellPrice(rs.getInt("SELL_PRICE"));
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
		return fdOrdDtVO;
	}

	@Override
	public List<FdOrdDtVO> getAll() {
		List<FdOrdDtVO> list = new ArrayList<FdOrdDtVO>();
		FdOrdDtVO fdOrdDtVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// fdOrdDtVO 也稱為 Domain objects
				fdOrdDtVO = new FdOrdDtVO();
				fdOrdDtVO.setFdDtID(rs.getLong("FD_DT_ID"));
				fdOrdDtVO.setTkOrdID(rs.getLong("TK_ORD_ID"));
				fdOrdDtVO.setFdID(rs.getInt("FD_ID"));
				fdOrdDtVO.setFdCount(rs.getInt("FD_COUNT"));
				fdOrdDtVO.setFdState(rs.getByte("FD_STATE"));
				fdOrdDtVO.setSellPrice(rs.getInt("SELL_PRICE"));
				list.add(fdOrdDtVO); // Store the row in the list
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

		FdOrdDtJDBCDAO dao = new FdOrdDtJDBCDAO();

		// 新增
//		FdOrdDtVO fdOrdDtVO1 = new FdOrdDtVO();
//		fdOrdDtVO1.setTkOrdID(3L);
//		fdOrdDtVO1.setFdID(4);
//		fdOrdDtVO1.setFdCount(2);
//		fdOrdDtVO1.setFdState(Byte.valueOf("0"));
//		fdOrdDtVO1.setSellPrice(40);
//		dao.insert(fdOrdDtVO1);

		// 修改
//		FdOrdDtVO fdOrdDtVO2 = new FdOrdDtVO();
//		fdOrdDtVO2.setFdDtID(5L);
//		fdOrdDtVO2.setTkOrdID(3L);
//		fdOrdDtVO2.setFdID(4);
//		fdOrdDtVO2.setFdCount(3);
//		fdOrdDtVO2.setFdState(Byte.valueOf("0"));
//		fdOrdDtVO2.setSellPrice(60);
//		dao.update(fdOrdDtVO2);

		// 刪除
//		dao.delete(5L);

		// 查詢
//		FdOrdDtVO fdOrdDtVO3 = dao.findByPrimaryKey(4L);
//		System.out.print(fdOrdDtVO3.getFdDtID() + ",");
//		System.out.print(fdOrdDtVO3.getTkOrdID() + ",");
//		System.out.print(fdOrdDtVO3.getFdID() + ",");
//		System.out.print(fdOrdDtVO3.getFdCount() + ",");
//		System.out.print(fdOrdDtVO3.getFdState() + ",");
//		System.out.print(fdOrdDtVO3.getSellPrice() + ",");
//		System.out.println("---------------------");

		// 查詢
		List<FdOrdDtVO> list = dao.getAll();
		for (FdOrdDtVO aFdOrdDt : list) {
			System.out.print(aFdOrdDt.getFdDtID() + ",");
			System.out.print(aFdOrdDt.getTkOrdID() + ",");
			System.out.print(aFdOrdDt.getFdID() + ",");
			System.out.print(aFdOrdDt.getFdCount() + ",");
			System.out.print(aFdOrdDt.getFdState() + ",");
			System.out.print(aFdOrdDt.getSellPrice() + ",");
			System.out.println();
		}
	}

}

