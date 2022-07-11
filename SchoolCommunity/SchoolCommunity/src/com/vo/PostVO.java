package com.vo;

public class PostVO {
	private String ptype;
	private String writer;
	private String title;
	private String contents;
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "PostVO [ptype=" + ptype + ", writer=" + writer + ", title=" + title + ", contents=" + contents + "]";
	}
	
}
