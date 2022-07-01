package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.conn.JDBCConnection;
import com.vo.LoginVO;

public class SchoolDAO {
	private Connection conn = null;
	private String sql = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	public String login(LoginVO vo) {
		String id = null;
		try {
			conn = JDBCConnection.getConnection();
			sql = "SELECT ID FROM ACCOUNT WHERE ID=? AND PASSWORD=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPw());
			rs = stmt.executeQuery();
			if(rs.next()) {
				id = rs.getString("ID");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, stmt, conn);
		}
		return id;
	}
}
