package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.conn.JDBCConnection;
import com.vo.HomePostsVO;
import com.vo.LoginVO;
import com.vo.PostCommentVO;
import com.vo.PostContentsVO;
import com.vo.PostReplyVO;
import com.vo.PostVO;

public class SchoolDAO {
	private Connection conn = null;
	private String sql = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	public String getUserName(String id) {
		String name = null;
		try {
			conn = JDBCConnection.getConnection();
			sql = "SELECT NAME FROM ACCOUNT_TBL WHERE ID=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				name = rs.getString("NAME");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, stmt, conn);
		}
		return name;
	}
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
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, stmt, conn);
		}
		return id;
	}
	public ArrayList<HomePostsVO> getHomeHotPosts(){
		ArrayList<HomePostsVO> list = null;
		
		try {
			conn = JDBCConnection.getConnection();
			sql = "SELECT X.PCODE PCODE, DECODE(PTYPE, 'NEWS','공지사항','FREE','자유게시판','QUES','Q&A') PTYPE,TITLE,NAME,SUGGESTION,COUNT(Y.CMCODE) COMMENTCOUNT \r\n" + 
					"FROM (SELECT PCODE,PTYPE,TITLE,NAME,SUGGESTION\r\n" + 
					"FROM (SELECT X.PCODE PCODE,PTYPE,WRITER,TITLE,COUNT(ID) SUGGESTION\r\n" + 
					"FROM POST_TBL X LEFT OUTER JOIN SUGGESTION_TBL Y ON (X.PCODE=Y.PCODE)\r\n" + 
					"GROUP BY X.PCODE,PTYPE,WRITER,TITLE) LEFT OUTER JOIN ACCOUNT_TBL ON(WRITER=ID)) X LEFT OUTER JOIN COMMENT_TBL Y ON(X.PCODE=Y.PCODE) \r\n" + 
					"WHERE ROWNUM <= 8\r\n" + 
					"GROUP BY X.PCODE,PTYPE,TITLE,NAME,SUGGESTION\r\n" + 
					"ORDER BY SUGGESTION DESC, PCODE DESC";
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
			sql = "SELECT X.PCODE PCODE, DECODE(PTYPE, 'NEWS','공지사항','FREE','자유게시판','QUES','Q&A') PTYPE,TITLE,NAME,SUGGESTION,COUNT(Y.CMCODE) COMMENTCOUNT \r\n" + 
					"FROM (SELECT PCODE,PTYPE,TITLE,NAME,SUGGESTION\r\n" + 
					"FROM (SELECT X.PCODE PCODE,PTYPE,WRITER,TITLE,COUNT(ID) SUGGESTION\r\n" + 
					"FROM POST_TBL X LEFT OUTER JOIN SUGGESTION_TBL Y ON (X.PCODE=Y.PCODE)\r\n" + 
					"GROUP BY X.PCODE,PTYPE,WRITER,TITLE) LEFT OUTER JOIN ACCOUNT_TBL ON(WRITER=ID) WHERE PTYPE=?) X LEFT OUTER JOIN COMMENT_TBL Y ON(X.PCODE=Y.PCODE) \r\n" + 
					"WHERE ROWNUM <= 8\r\n" + 
					"GROUP BY X.PCODE,PTYPE,TITLE,NAME,SUGGESTION \r\n" + 
					"ORDER BY PCODE DESC";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, pType);
			rs = stmt.executeQuery();
			list = new ArrayList<HomePostsVO>();
			while(rs.next()) {
				HomePostsVO vo = new HomePostsVO();
				vo.setpCode(rs.getInt("PCODE"));
				vo.setpType(rs.getString("PTYPE"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setName(rs.getString("NAME"));
				vo.setSuggestion(String.valueOf(rs.getInt("SUGGESTION")));
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
	private int getMaxPcode() {
		int pcode = 0;
		try {
			conn = JDBCConnection.getConnection();
			sql = "SELECT NVL2(MAX(PCODE),MAX(PCODE)+1,1) PCODE\r\n" + 
					"FROM POST_TBL";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				pcode = rs.getInt("PCODE");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCConnection.close(rs, stmt, conn);
		}
		return pcode;
	}
	public int addPost(PostVO vo) {
		int pcode = 0;
		int maxPcode = getMaxPcode();
		try {
			conn = JDBCConnection.getConnection();
			sql = "INSERT INTO POST_TBL VALUES(?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, maxPcode);
			stmt.setString(2, vo.getPtype());
			stmt.setString(3, vo.getWriter());
			stmt.setString(4, vo.getTitle());
			stmt.setString(5, vo.getContents());
			pcode = stmt.executeUpdate();
			if(pcode > 0) {
				pcode = maxPcode;
				conn.commit();
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			JDBCConnection.close(rs, stmt, conn);
		}
		return pcode;
	}
	
}
