package com.wishing_list.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.common.JDBCUtil;

public class WishingListJDBCDAO implements WishingListDAO_interface{
	
	private static final String INSERT =
			"insert into wishing_list (WISH_NO, WISH_OPTION, MV_ID, WISH_COUNT) values "
			+ "(?, ?, ?, ?)";
	private static final String READ_ONE =
			"select WISH_NO, WISH_OPTION, MV_ID, WISH_COUNT from wishing_list where WISH_NO = ? order by WISH_COUNT desc, WISH_OPTION";
	private static final String READ_ALL =
			"select WISH_NO, WISH_OPTION, MV_ID, WISH_COUNT from wishing_list order by WISH_NO, WISH_OPTION";
	private static final String UPDATE =
			"update wishing_list set MV_ID = ?, WISH_COUNT = ? where WISH_NO = ? and WISH_OPTION = ?";
	private static final String DELETE =
			"delete from wishing_list where WISH_NO = ? and WISH_OPTION = ?";
	
	@Override
	public void insert(WishingListVO wishingPondVO) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(INSERT);
			
			ps.setInt(1, wishingPondVO.getWish_no());
			ps.setInt(2, wishingPondVO.getWish_option());
			ps.setInt(3, wishingPondVO.getMv_id());
			ps.setInt(4, wishingPondVO.getWish_count());
			
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
	public void update(WishingListVO wishingPondVO) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(UPDATE);
			
			ps.setInt(1, wishingPondVO.getMv_id());
			ps.setInt(2, wishingPondVO.getWish_count());
			ps.setInt(3, wishingPondVO.getWish_no());
			ps.setInt(4, wishingPondVO.getWish_option());
			
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
	public List<WishingListVO> findByWishNo(Integer wishNo) {
		List<WishingListVO> list = new ArrayList<WishingListVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(READ_ONE);
			
			ps.setInt(1, wishNo);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				WishingListVO wishingPondVO = new WishingListVO();
				wishingPondVO.setWish_no(rs.getInt("WISH_NO"));
				wishingPondVO.setWish_option(rs.getInt("WISH_OPTION"));
				wishingPondVO.setMv_id(rs.getInt("MV_ID"));
				wishingPondVO.setWish_count(rs.getInt("WISH_COUNT"));
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
	public List<WishingListVO> getAll() {
		List<WishingListVO> list = new ArrayList<WishingListVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(READ_ALL);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				WishingListVO wishingPondVO = new WishingListVO();
				wishingPondVO.setWish_no(rs.getInt("WISH_NO"));
				wishingPondVO.setWish_option(rs.getInt("WISH_OPTION"));
				wishingPondVO.setMv_id(rs.getInt("MV_ID"));
				wishingPondVO.setWish_count(rs.getInt("WISH_COUNT"));
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
//		WishingListJDBCDAO dao = new WishingListJDBCDAO();
		
		// C
//		WishingListVO wishingListVO1 = new WishingListVO();
//		wishingListVO1.setWish_no(2);
//		wishingListVO1.setWish_option(8);
//		wishingListVO1.setMv_id(1);
//		wishingListVO1.setWish_count(0);
//		dao.insert(wishingListVO1);
		
		// R_ONE
//		List<WishingListVO> list = dao.findByWishNo(1);
//		for(WishingListVO wp: list) {
//			System.out.print(wp.getWish_no() + ", ");
//			System.out.print(wp.getWish_option() + ", ");
//			System.out.print(wp.getMv_id() + ", ");
//			System.out.println(wp.getWish_count());
//		}
		
		// R_ALL
//		List<WishingListVO> list = dao.getAll();
//		for(WishingListVO wp: list) {
//			System.out.print(wp.getWish_no() + ", ");
//			System.out.print(wp.getWish_option() + ", ");
//			System.out.print(wp.getMv_id() + ", ");
//			System.out.println(wp.getWish_count());
//		}
		
		// U
//		WishingListVO wishingListVO2 = new WishingListVO();
//		wishingListVO2.setWish_no(2);
//		wishingListVO2.setWish_option(8);
//		wishingListVO2.setMv_id(1);
//		wishingListVO2.setWish_count(100);
//		dao.update(wishingListVO2);
		
		// D
//		dao.delete(2, 8);
	}

}
