package com.merchandise_order.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.merchandise_inf.model.MerchVO;

public class MerchOrdDAO implements MerchOrdDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/movietheater?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
	
	private static final String INSERT_STMT = "INSERT INTO merchandise_order (MEMBER_ID, MERCH_OR_COUNT, MERCH_OR_STATUS) VALUES (?,?,?);";
	private static final String GET_ALL_STMT = "SELECT MERCH_OR_ID, MEMBER_ID, MERCH_OR_DATE, MERCH_OR_COUNT, MERCH_OR_STATUS FROM merchandise_order ORDER BY MERCH_OR_ID;";
	private static final String GET_ONE_STMT = "SELECT MERCH_OR_ID, MEMBER_ID, MERCH_OR_DATE, MERCH_OR_COUNT, MERCH_OR_STATUS FROM merchandise_order WHERE MERCH_OR_ID = ?;";
	private static final String DELETE = "DELETE FROM merchandise_order WHERE MERCH_OR_ID = ?;";
	private static final String UPDATE = "UPDATE merchandise_order set MERCH_OR_COUNT = ?, MERCH_OR_STATUS = ? WHERE MERCH_OR_ID = ?;";
	@Override
	public void insert(MerchOrdVO merchOrdVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
//			con = ds.getConnection();
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setInt(1, merchOrdVo.getMemberID());
			pstmt.setInt(2, merchOrdVo.getMerchOrdCount());
			pstmt.setByte(3, merchOrdVo.getMerchOrdStatus());
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
	public void update(MerchOrdVO merchOrdVo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
//			con = ds.getConnection();
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setInt(1, merchOrdVo.getMerchOrdCount());
			pstmt.setByte(2, merchOrdVo.getMerchOrdStatus());
			pstmt.setInt(3, merchOrdVo.getMerchOrdID());
			pstmt.executeUpdate();
			// Handle any driver errors
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
	public void delete(Integer merchOrdID) {
		Connection con = null;
		PreparedStatement pstmt = null;try {

//			con = ds.getConnection();
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, merchOrdID);

			pstmt.executeUpdate();

			// Handle any driver errors
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
	public MerchOrdVO findByPrimaryKey(Integer merchOrdID) {
		MerchOrdVO merchOrdVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

//			con = ds.getConnection();
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, merchOrdID);

			rs = pstmt.executeQuery();
			while(rs.next()) {
				merchOrdVO = new MerchOrdVO();
				merchOrdVO.setMemberID(rs.getInt("MERCH_OR_ID"));
				merchOrdVO.setMemberID(rs.getInt("MEMBER_ID"));
				merchOrdVO.setMerchOrdDate(rs.getTimestamp("MERCH_OR_DATE"));
				merchOrdVO.setMerchOrdCount(rs.getInt("merchOrdCount"));
				merchOrdVO.setMerchOrdStatus(rs.getByte("MERCH_OR_STATUS"));
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
		return merchOrdVO;
	}

	@Override
	public List<MerchOrdVO> getAll() {
		List<MerchOrdVO> list = new ArrayList<MerchOrdVO>();
		MerchOrdVO merchOrdVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			con = ds.getConnection();
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				merchOrdVO = new MerchOrdVO();
				merchOrdVO.setMemberID(rs.getInt("MERCH_OR_ID"));
				merchOrdVO.setMemberID(rs.getInt("MEMBER_ID"));
				merchOrdVO.setMerchOrdDate(rs.getTimestamp("MERCH_OR_DATE"));
				merchOrdVO.setMerchOrdCount(rs.getInt("merchOrdCount"));
				merchOrdVO.setMerchOrdStatus(rs.getByte("MERCH_OR_STATUS"));
				list.add(merchOrdVO);
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

}
