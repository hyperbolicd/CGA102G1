package com.tk_folder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.common.JDBCUtil;
import com.tk_ord.model.TkOrdVO;
import com.tk_ord_dt.model.TkOrdDtVO;

public class TkFolderDAO implements TkFolder_interface {
	public static final String GET_ALL_TKORD=
			"Select * FROM tk_ord WHERE MEMBER_ID = ?";

	@Override
	public List<TkOrdVO> getAllTkOrd(Integer member_ID) {
		
		List<TkOrdVO> list = new ArrayList<TkOrdVO>();
		TkOrdVO tkOrdVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(GET_ALL_TKORD);
			pstmt.setLong(1, member_ID);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				tkOrdVO = new TkOrdVO();
				tkOrdVO.setTkOrdID(rs.getLong("TK_ORD_ID"));
				tkOrdVO.setMemberID(rs.getInt("MEMBER_ID"));
				tkOrdVO.setShID(rs.getInt("SH_ID"));
				list.add(tkOrdVO);
			}
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver."
					+e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("Couldn't load database driver."
					+se.getMessage());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
		return list;
	}
}
