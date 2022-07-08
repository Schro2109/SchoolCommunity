package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import com.conn.JDBCConnection;
import com.vo.HomePostsVO;
import com.vo.LoginVO;
import com.vo.PostContentsVO;

public class SchoolDAO {
	private Connection conn = null;
	private String sql = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	public String login(LoginVO vo) {
		String id = null;
		try {
			conn = JDBCConnection.getConnection();
			sql = "SELECT ID FROM ACCOUNT_TBL WHERE ID=? AND PASSWORD=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPw());
			rs = stmt.executeQuery();
			if(rs.next()) {
				id = rs.getString("ID");
			}
		} catch (Exception e) {
			System.out.println("로그인 실패");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, stmt, conn);
		}
		System.out.println("로그인 성공");
		return id;
	}
	public ArrayList<HomePostsVO> getHomeHotPosts(){
		ArrayList<HomePostsVO> list = null;
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "SELECT X.PCODE PCODE, DECODE(pType, 'NEWS','공지사항','FREE','자유게시판','QUES','Q&A') pType,TITLE,NAME,SUGGESTION,COUNT(Y.CMCODE) COMMENTCOUNT\r\n" + 
					"FROM (SELECT PCODE,pType,TITLE,NAME,SUGGESTION\r\n" + 
					"FROM POST_TBL LEFT OUTER JOIN ACCOUNT_TBL ON(WRITER=ID)) X LEFT OUTER JOIN COMMENT_TBL Y ON(X.PCODE=Y.PCODE)\r\n" + 
					"WHERE ROWNUM <= 8\r\n" +
					"GROUP BY X.PCODE,pType,TITLE,NAME,SUGGESTION\r\n" + 
					"ORDER BY SUGGESTION DESC";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			list = new ArrayList<HomePostsVO>();
			while(rs.next()) {
				HomePostsVO vo = new HomePostsVO();
				vo.setpCode(rs.getInt("PCODE"));
				vo.setpType(rs.getString("pType"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setName(rs.getString("NAME"));
				vo.setSuggestion(rs.getString("SUGGESTION"));
				vo.setCommentCount(rs.getString("COMMENTCOUNT"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCConnection.close(rs, stmt, conn);
		}
		return list;
	}
	public ArrayList<HomePostsVO> getHomePosts(String pType){
ArrayList<HomePostsVO> list = null;
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "SELECT X.PCODE PCODE, DECODE(pType, 'NEWS','공지사항','FREE','자유게시판','QUES','Q&A') pType,TITLE,NAME,SUGGESTION,COUNT(Y.CMCODE) COMMENTCOUNT\r\n" + 
					"FROM (SELECT PCODE,pType,TITLE,NAME,SUGGESTION\r\n" + 
					"FROM POST_TBL LEFT OUTER JOIN ACCOUNT_TBL ON(WRITER=ID) WHERE pType=?) X LEFT OUTER JOIN COMMENT_TBL Y ON(X.PCODE=Y.PCODE)\r\n" + 
					"WHERE ROWNUM <= 8\r\n" +
					"GROUP BY X.PCODE,pType,TITLE,NAME,SUGGESTION\r\n" + 
					"ORDER BY PCODE DESC";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, pType);
			rs = stmt.executeQuery();
			list = new ArrayList<HomePostsVO>();
			while(rs.next()) {
				HomePostsVO vo = new HomePostsVO();
				vo.setpCode(rs.getInt("PCODE"));
				vo.setpType(rs.getString("pType"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setName(rs.getString("NAME"));
				vo.setSuggestion(rs.getString("SUGGESTION"));
				vo.setCommentCount(rs.getString("COMMENTCOUNT"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCConnection.close(rs, stmt, conn);
		}
		return list;
	}
	public PostContentsVO getPostContents(int pCode) {
		PostContentsVO vo = null;
		try {
			conn = JDBCConnection.getConnection();
			sql = "";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCConnection.close(rs, stmt, conn);
		}
		return vo;
	}
	
	
}
