package com.order_detail.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.merchandise_order.model.MerchOrdVO;

public class OrderDetailDAO implements OrderDetailDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/movietheater?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
	private static final String INSERT_STMT = "INSERT INTO order_detail (MERCH_OR_ID, ITEM, MERCH_ID, OR_COUNT, OR_STATUS, OR_PRICE) Values (?, ?, ?, ?, ?, ?);";
	private static final String GET_ALL_STMT = "SELECT MERCH_OR_ID, ITEM, MERCH_ID, OR_COUNT, OR_STATUS, OR_PRICE FROM order_detail order by MERCH_OR_ID ,ITEM;";
	private static final String GET_ONE_STMT = "SELECT MERCH_OR_ID, ITEM, MERCH_ID, OR_COUNT, OR_STATUS, OR_PRICE FROM order_detail order by ITEM where MERCH_OR_ID = ?, ITEM = ?;";
	private static final String DELETE = "DELETE FROM order_detail WHERE MERCH_OR_ID = ?, ITEM = ?;";
	private static final String UPDATE = "UPDATE order_detail set MERCH_ID=?, OR_COUNT=?, OR_STATUS=?, OR_PRICE=? WHERE MERCH_OR_ID = ?, ITEM = ?;";
	
	@Override
	public void insert(OrderDetailVO orderDetailVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setInt(1, orderDetailVo.getMerchOrdID());
			pstmt.setInt(2, orderDetailVo.getItem());
			pstmt.setInt(3, orderDetailVo.getMerchID());
			pstmt.setInt(4, orderDetailVo.getOrdCount());
			pstmt.setByte(5, orderDetailVo.getOrdStatus());
			pstmt.setDouble(6, orderDetailVo.getOrdPrice());
			
			pstmt.executeUpdate();
			
		}catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void update(OrderDetailVO orderDetailVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setInt(1, orderDetailVo.getMerchID());
			pstmt.setInt(2, orderDetailVo.getOrdCount());
			pstmt.setByte(3, orderDetailVo.getOrdStatus());
			pstmt.setDouble(4, orderDetailVo.getOrdPrice());
			pstmt.setInt(5, orderDetailVo.getMerchOrdID());
			pstmt.setInt(6, orderDetailVo.getItem());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public List<OrderDetailVO> getAll() {
		List<OrderDetailVO> list = new ArrayList<OrderDetailVO>();
		OrderDetailVO orderDetailVo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			con = ds.getConnection();
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				orderDetailVo = new OrderDetailVO();
				orderDetailVo.setMerchOrdID(rs.getInt("MERCH_OR_ID"));
				orderDetailVo.setItem(rs.getInt("ITEM"));
				orderDetailVo.setMerchID(rs.getInt("MERCH_ID"));
				orderDetailVo.setOrdStatus(rs.getByte("OR_STATUS"));
				orderDetailVo.setOrdPrice(rs.getDouble("OR_PRICE"));
				orderDetailVo.setOrdCount(rs.getInt("OR_COUNT"));
				list.add(orderDetailVo);
			}
		
		
		}catch (SQLException se) {
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
		

	@Override
	public void delete(Integer merchOrdID, Integer item) {
		Connection con = null;
		PreparedStatement pstmt = null;try {

//			con = ds.getConnection();
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, merchOrdID);
			pstmt.setInt(2, item);
			pstmt.executeUpdate();

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
	public OrderDetailVO findByPrimaryKey(Integer merchOrdID, Integer item) {
		OrderDetailVO orderDetailVo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			con = ds.getConnection();
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, merchOrdID);
			pstmt.setInt(2, item);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				orderDetailVo = new OrderDetailVO();
				orderDetailVo.setMerchOrdID(rs.getInt("MERCH_OR_ID"));
				orderDetailVo.setItem(rs.getInt("ITEM"));
				orderDetailVo.setMerchID(rs.getInt("MERCH_ID"));
				orderDetailVo.setOrdStatus(rs.getByte("OR_STATUS"));
				orderDetailVo.setOrdPrice(rs.getDouble("OR_PRICE"));
				orderDetailVo.setOrdCount(rs.getInt("OR_COUNT"));
			}
		
		
		}catch (SQLException se) {
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
		return orderDetailVo;
	}

}
