package com.vo;

public class HomePostsVO {
	private int pCode;
	private String pType;
	private String title;
	private String name;
	private String suggestion;
	private String commentCount;
	
	public int getpCode() {
		return pCode;
	}
	public void setpCode(int pCode) {
		this.pCode = pCode;
	}
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	public String getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}
	@Override
	public String toString() {
		return "HomePostsVO [pCode=" + pCode + ", pType=" + pType + ", title=" + title + ", name=" + name
				+ ", suggestion=" + suggestion + ", commentCount=" + commentCount + "]";
	}
}
