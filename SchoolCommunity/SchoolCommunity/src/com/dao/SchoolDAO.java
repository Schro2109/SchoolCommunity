package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.conn.JDBCConnection;
import com.vo.HomePostsVO;
import com.vo.LoginVO;
import com.vo.PostCommentVO;
import com.vo.PostContentsVO;
import com.vo.PostReplyVO;

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
			sql = "SELECT PTYPE, TITLE, WRITER, CONTENTS\r\n" + 
					"FROM POST_TBL\r\n" + 
					"WHERE PCODE=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pCode);
			rs = stmt.executeQuery();
			vo = new PostContentsVO();
			if(rs.next()) {
				vo.setpType(rs.getString("PTYPE"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setName(rs.getString("WRITER"));
				vo.setContents(rs.getString("CONTENTS"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCConnection.close(rs, stmt, conn);
		}
		return vo;
	}
	public ArrayList<PostCommentVO> getPostComments(int pCode){
		ArrayList<PostCommentVO> list = null;
		try {
			conn = JDBCConnection.getConnection();
			sql = "SELECT CMCODE, CONTENTS, WRITER, NAME\r\n" + 
					"FROM COMMENT_TBL LEFT OUTER JOIN ACCOUNT_TBL ON(WRITER=ID)\r\n" + 
					"WHERE PCODE = ? ORDER BY CMCODE DESC";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pCode);
			rs = stmt.executeQuery();
			list = new ArrayList<PostCommentVO>();
			while(rs.next()) {
				PostCommentVO vo = new PostCommentVO();
				vo.setCmCode(rs.getInt("CMCODE"));
				vo.setContents(rs.getString("CONTENTS"));
				vo.setName(rs.getString("NAME"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCConnection.close(rs, stmt, conn);
		}
		return list;
	}
	public ArrayList<PostReplyVO> getPostReply(int cmCode){
		ArrayList<PostReplyVO> list = null;
		try {
			conn = JDBCConnection.getConnection();
			sql = "SELECT RECODE, CONTENTS, WRITER, NAME\r\n" + 
					"FROM REPLY_TBL LEFT OUTER JOIN ACCOUNT_TBL ON(WRITER=ID)\r\n" + 
					"WHERE CMCODE = ? ORDER BY RECODE";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cmCode);
			rs = stmt.executeQuery();
			list = new ArrayList<PostReplyVO>();
			while(rs.next()) {
				PostReplyVO vo = new PostReplyVO();
				vo.setReCode(rs.getInt("RECODE"));
				vo.setContents(rs.getString("CONTENTS"));
				vo.setName(rs.getString("NAME"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCConnection.close(rs, stmt, conn);
		}
		return list;
	}
	
	
}
