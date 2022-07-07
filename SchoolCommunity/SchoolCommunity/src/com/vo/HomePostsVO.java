package com.vo;

public class HomePostsVO {
	private String ptype;
	private String title;
	private String name;
	private String suggestion;
	private String commentCount;
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
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
		return "HomePostsVO [ptype=" + ptype + ", title=" + title + ", name=" + name + ", suggestion=" + suggestion
				+ ", commentCount=" + commentCount + "]";
	}
	
}
