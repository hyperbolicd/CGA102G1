package com.tk_ord.model;

import java.util.*;
import java.sql.*;

import com.fd_ord_dt.model.FdOrdDtJDBCDAO;
import com.fd_ord_dt.model.FdOrdDtVO;
import com.tk_ord_dt.model.TkOrdDtJDBCDAO;
import com.tk_ord_dt.model.TkOrdDtVO;

public class TkOrdJDBCDAO implements TkOrdDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/movietheater?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String INSERT_STMT = "INSERT INTO tk_ord (MEMBER_ID,SH_ID) VALUES (?, ?)";
	private static final String GET_ALL_STMT = "SELECT TK_ORD_ID,MEMBER_ID,SH_ID,ORD_TIME FROM tk_ord order by TK_ORD_ID";
	private static final String GET_ONE_STMT = "SELECT TK_ORD_ID,MEMBER_ID,SH_ID,ORD_TIME FROM tk_ord where TK_ORD_ID = ?";

	private static final String GET_TkOrdDts_ByTkOrdID_STMT = "SELECT TK_DT_ID,TK_ORD_ID,TK_TYPE_ID,ACT_ID,STATE,SEAT,SELL_PRICE FROM tk_ord_dt where TK_ORD_ID = ? order by TK_ORD_ID";

	private static final String GET_FdOrdDts_ByTkOrdID_STMT = "SELECT FD_DT_ID,TK_ORD_ID,FD_ID,FD_COUNT,FD_STATE,SELL_PRICE FROM fd_ord_dt where TK_ORD_ID = ? order by TK_ORD_ID";

	private static final String DELETE = "DELETE FROM tk_ord where TK_ORD_ID = ?";
	private static final String UPDATE = "UPDATE tk_ord set MEMBER_ID=?, SH_ID=? where TK_ORD_ID = ?";

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
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
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
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
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
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
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
				// tkOrdVO ????????? Domain objects
				tkOrdVO = new TkOrdVO();
				tkOrdVO.setTkOrdID(rs.getLong("TK_ORD_ID"));
				tkOrdVO.setMemberID(rs.getInt("MEMBER_ID"));
				tkOrdVO.setShID(rs.getInt("SH_ID"));
				tkOrdVO.setOrdTime(rs.getTimestamp("ORD_Time"));

			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
				// tkOrdVO ????????? Domain objects
				tkOrdVO = new TkOrdVO();
				tkOrdVO.setTkOrdID(rs.getLong("TK_ORD_ID"));
				tkOrdVO.setMemberID(rs.getInt("MEMBER_ID"));
				tkOrdVO.setShID(rs.getInt("SH_ID"));
				tkOrdVO.setOrdTime(rs.getTimestamp("ORD_Time"));
				list.add(tkOrdVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public Set<TkOrdDtVO> getTkOrdDtsByTkOrdID(Long tkOrdID) {
		Set<TkOrdDtVO> set = new HashSet<TkOrdDtVO>();
		TkOrdDtVO tkOrdDtVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_TkOrdDts_ByTkOrdID_STMT);
			pstmt.setLong(1, tkOrdID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				tkOrdDtVO = new TkOrdDtVO();
				tkOrdDtVO.setTkDtID(rs.getLong("TK_DT_ID"));
				tkOrdDtVO.setTkOrdID(rs.getLong("TK_ORD_ID"));
				tkOrdDtVO.setTkTypeID(rs.getInt("TK_TYPE_ID"));
				tkOrdDtVO.setActID(rs.getInt("ACT_ID"));
				tkOrdDtVO.setState(rs.getByte("STATE"));
				tkOrdDtVO.setSeat(rs.getString("SEAT"));
				tkOrdDtVO.setSellPrice(rs.getInt("SELL_PRICE"));
				set.add(tkOrdDtVO); // Store the row in the vector
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

	@Override
	public Set<FdOrdDtVO> getFdOrdDtsByTkOrdID(Long tkOrdID) {
		Set<FdOrdDtVO> set = new HashSet<FdOrdDtVO>();
		FdOrdDtVO fdOrdDtVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_FdOrdDts_ByTkOrdID_STMT);
			pstmt.setLong(1, tkOrdID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				fdOrdDtVO = new FdOrdDtVO();
				fdOrdDtVO.setFdDtID(rs.getLong("FD_DT_ID"));
				fdOrdDtVO.setTkOrdID(rs.getLong("TK_ORD_ID"));
				fdOrdDtVO.setFdID(rs.getInt("FD_ID"));
				fdOrdDtVO.setFdCount(rs.getInt("FD_COUNT"));
				fdOrdDtVO.setFdState(rs.getByte("FD_STATE"));
				fdOrdDtVO.setSellPrice(rs.getInt("SELL_PRICE"));
				set.add(fdOrdDtVO); // Store the row in the vector
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

	@Override
	public void insertWithTkOrdDtsAndFdOrdDts(TkOrdVO tkOrdVO, List<TkOrdDtVO> list, List<FdOrdDtVO> list2) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);

			// 1???????????? pstm.executeUpdate()??????
			con.setAutoCommit(false);

			// ???????????????
			String cols[] = { "TK_ORD_ID" };
			pstmt = con.prepareStatement(INSERT_STMT, cols);
			pstmt.setInt(1, tkOrdVO.getMemberID());
			pstmt.setInt(2, tkOrdVO.getShID());

			pstmt.executeUpdate();
			// ??????????????????????????????
			Long next_tkOrdID = null;
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				next_tkOrdID = rs.getLong(1);

//				System.out.println("???????????????= " + next_tkOrdID + "(??????????????????????????????)");
			} else {
//				System.out.println("????????????????????????");
			}
			rs.close();
			// ????????????????????????
			TkOrdDtJDBCDAO dao = new TkOrdDtJDBCDAO();
//			System.out.println("list.size()-A=" + list.size());
			for (TkOrdDtVO aTkOrdDt : list) {
				aTkOrdDt.setTkOrdID(new Long(next_tkOrdID));
				dao.insert2(aTkOrdDt, con);
			}
			
			
			// ???????????????????????????
			if (list2 != null) {
				FdOrdDtJDBCDAO dao2 = new FdOrdDtJDBCDAO();
//				System.out.println("list.size()-A=" + list2.size());
				for (FdOrdDtVO aFdOrdDt : list2) {
					aFdOrdDt.setTkOrdID(new Long(next_tkOrdID));
					dao2.insert2(aFdOrdDt, con);
				}
				
			}else {
				
//				System.out.println("??????????????????");
			}
			
			
			
			
			


			// 2???????????? pstm.executeUpdate()??????
			con.commit();
			con.setAutoCommit(true);
			System.out.println("list.size()-B=" + list.size());
			System.out.println("??????????????????" + next_tkOrdID + "???,??????" + list.size() + "?????????????????????");

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3??????????????????exception????????????catch?????????
					System.err.print("Transaction is being ");
					System.err.println("rolled back-???-dept");
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. " + excep.getMessage());
				}
			}
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

	public static void main(String[] args) {

		TkOrdJDBCDAO dao = new TkOrdJDBCDAO();

		// ??????
//		TkOrdVO tkOrdVO1 = new TkOrdVO();
//		tkOrdVO1.setMemberID(1);
//		tkOrdVO1.setShID(1);
//		dao.insert(tkOrdVO1);

		// ??????
//		TkOrdVO tkOrdVO2 = new TkOrdVO();
//		tkOrdVO2.setTkOrdID(5L);
//		tkOrdVO2.setMemberID(1);
//		tkOrdVO2.setShID(2);
//		dao.update(tkOrdVO2);

		// ??????
//		dao.delete(5L);

		// ??????
//		TkOrdVO tkOrdVO3 = dao.findByPrimaryKey(4L);
//		System.out.print(tkOrdVO3.getTkOrdID() + ",");
//		System.out.print(tkOrdVO3.getMemberID() + ",");
//		System.out.print(tkOrdVO3.getShID() + ",");
//		System.out.print(tkOrdVO3.getOrdTime() + ",");
//		System.out.println("---------------------");

		// ??????
//		List<TkOrdVO> list = dao.getAll();
//		for (TkOrdVO aTkOrdVO : list) {
//			System.out.print(aTkOrdVO.getTkOrdID() + ",");
//			System.out.print(aTkOrdVO.getMemberID() + ",");
//			System.out.print(aTkOrdVO.getShID() + ",");
//			System.out.print(aTkOrdVO.getOrdTime() + ",");
//			System.out.println();
//		}



		TkOrdVO tkOrdVO = new TkOrdVO();
		tkOrdVO.setMemberID(4);
		tkOrdVO.setShID(1);

		List<TkOrdDtVO> testList = new ArrayList<TkOrdDtVO>(); // ???????????????????????????
		TkOrdDtVO empXX = new TkOrdDtVO(); // ??????POJO1
		empXX.setTkTypeID(1);
		empXX.setActID(1);
		empXX.setState(Byte.valueOf("0"));
		empXX.setSeat("02022");
		empXX.setSellPrice(100);
		
		

		TkOrdDtVO empYY = new TkOrdDtVO(); // ??????POJO2
		empYY.setTkTypeID(1);
		empYY.setActID(1);
		empYY.setState(Byte.valueOf("0"));
		empYY.setSeat("02032");
		empYY.setSellPrice(100);

		testList.add(empXX);
		testList.add(empYY);
		
		
		List<FdOrdDtVO> testList2 = new ArrayList<FdOrdDtVO>(); // ????????????????????????
		FdOrdDtVO empZZ = new FdOrdDtVO(); // ??????POJO1
		empZZ.setFdID(1);
		empZZ.setFdCount(2);
		empZZ.setFdState(Byte.valueOf("0"));
		empZZ.setSellPrice(1222);

		FdOrdDtVO empSS = new FdOrdDtVO(); // ??????POJO2
		empSS.setFdID(2);
		empSS.setFdCount(2);
		empSS.setFdState(Byte.valueOf("0"));
		empSS.setSellPrice(3333);

		testList2.add(empZZ);
		testList2.add(empSS);

		dao.insertWithTkOrdDtsAndFdOrdDts(tkOrdVO, testList, testList2);
		
		
	}
}
