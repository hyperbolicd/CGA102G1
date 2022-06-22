package com.wishing_pond.model;

import java.util.*;

import javax.naming.NamingException;

import com.common.JDBCUtil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class WishingPondJDBCDAO implements WishingPondDAO_interface{
	
	private static final String INSERT =
			"insert into wishing_pond (WISH_NO, WISH_OPTION, MV_ID, WISH_COUNT, WISH_START, WISH_END) values "
			+ "(?, ?, ?, ?, ?, ?);";
	private static final String READ_ONE =
			"select WISH_NO, WISH_OPTION, MV_ID, WISH_COUNT, WISH_START, WISH_END from wishing_pond where WISH_NO = ? order by WISH_COUNT desc, WISH_OPTION;";
	private static final String READ_ALL =
			"select WISH_NO, WISH_OPTION, MV_ID, WISH_COUNT, WISH_START, WISH_END from wishing_pond order by WISH_NO, WISH_OPTION;";
	private static final String UPDATE =
			"update wishing_pond set MV_ID = ?, WISH_COUNT = ?, WISH_START = ?, WISH_END = ? "
			+ "where WISH_NO = ? and WISH_OPTION = ?;";
	private static final String DELETE =
			"delete from wishing_pond where WISH_NO = ? and WISH_OPTION = ?;";
	
	@Override
	public void insert(WishingPondVO wishingPondVO) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(INSERT);
			
			ps.setInt(1, wishingPondVO.getWish_no());
			ps.setInt(2, wishingPondVO.getWish_option());
			ps.setInt(3, wishingPondVO.getMv_id());
			ps.setInt(4, wishingPondVO.getWish_count());
			ps.setTimestamp(5, wishingPondVO.getWish_start());
			ps.setTimestamp(6, wishingPondVO.getWish_end());
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public void delete(Integer wishNo, Integer wishOption) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(DELETE);
			
			ps.setInt(1, wishNo);
			ps.setInt(2, wishOption);
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
	}
	@Override
	public void update(WishingPondVO wishingPondVO) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(UPDATE);
			
			ps.setInt(1, wishingPondVO.getMv_id());
			ps.setInt(2, wishingPondVO.getWish_count());
			ps.setTimestamp(3, wishingPondVO.getWish_start());
			ps.setTimestamp(4, wishingPondVO.getWish_end());
			ps.setInt(5, wishingPondVO.getWish_no());
			ps.setInt(6, wishingPondVO.getWish_option());
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
	}
	@Override
	public List<WishingPondVO> findByWishNo(Integer wishNo) {
		List<WishingPondVO> list = new ArrayList<WishingPondVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(READ_ONE);
			
			ps.setInt(1, wishNo);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				WishingPondVO wishingPondVO = new WishingPondVO();
				wishingPondVO.setWish_no(rs.getInt("WISH_NO"));
				wishingPondVO.setWish_option(rs.getInt("WISH_OPTION"));
				wishingPondVO.setMv_id(rs.getInt("MV_ID"));
				wishingPondVO.setWish_count(rs.getInt("WISH_COUNT"));
				wishingPondVO.setWish_start(rs.getTimestamp("WISH_START"));
				wishingPondVO.setWish_end(rs.getTimestamp("WISH_END"));
				list.add(wishingPondVO);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
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
	public List<WishingPondVO> getAll() {
		List<WishingPondVO> list = new ArrayList<WishingPondVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(READ_ALL);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				WishingPondVO wishingPondVO = new WishingPondVO();
				wishingPondVO.setWish_no(rs.getInt("WISH_NO"));
				wishingPondVO.setWish_option(rs.getInt("WISH_OPTION"));
				wishingPondVO.setMv_id(rs.getInt("MV_ID"));
				wishingPondVO.setWish_count(rs.getInt("WISH_COUNT"));
				wishingPondVO.setWish_start(rs.getTimestamp("WISH_START"));
				wishingPondVO.setWish_end(rs.getTimestamp("WISH_END"));
				list.add(wishingPondVO);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
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
		WishingPondJDBCDAO dao = new WishingPondJDBCDAO();
		
		// C
//		WishingPondVO wishingPondVO1 = new WishingPondVO();
//		wishingPondVO1.setWish_no(2);
//		wishingPondVO1.setWish_option(8);
//		wishingPondVO1.setMv_id(1);
//		wishingPondVO1.setWish_count(0);
//		wishingPondVO1.setWish_start(Timestamp.valueOf("2022-06-01 00:00:00"));
//		wishingPondVO1.setWish_end(Timestamp.valueOf("2022-07-31 23:59:59"));
//		dao.insert(wishingPondVO1);
		
		// R_ONE
//		List<WishingPondVO> list = dao.findByWishNo(2);
//		for(WishingPondVO wp: list) {
//			System.out.print(wp.getWish_no() + ", ");
//			System.out.print(wp.getWish_option() + ", ");
//			System.out.print(wp.getMv_id() + ", ");
//			System.out.print(wp.getWish_count() + ", ");
//			System.out.print(wp.getWish_start().toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss") + ", ");
//			System.out.println(wp.getWish_end().toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//		}
		
		// R_ALL
		List<WishingPondVO> list = dao.getAll();
		for(WishingPondVO wp: list) {
			System.out.print(wp.getWish_no() + ", ");
			System.out.print(wp.getWish_option() + ", ");
			System.out.print(wp.getMv_id() + ", ");
			System.out.print(wp.getWish_count() + ", ");
			System.out.print(wp.getWish_start().toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ", ");
//			System.out.println(wp.getWish_end().toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(wp.getWish_end()));
		}
		
		// U
//		WishingPondVO wishingPondVO2 = new WishingPondVO();
//		wishingPondVO2.setWish_no(2);
//		wishingPondVO2.setWish_option(8);
//		wishingPondVO2.setMv_id(1);
//		wishingPondVO2.setWish_count(100);
//		wishingPondVO2.setWish_start(Timestamp.valueOf("2022-06-01 00:00:00"));
//		wishingPondVO2.setWish_end(Timestamp.valueOf("2022-07-31 23:59:59"));
//		dao.update(wishingPondVO2);
		
		// D
//		dao.delete(2, 8);
	}

}
