package com.vo;

public class PostCommentVO {
	private int cmCode;
	private String contents;
	private String name;
	public int getCmCode() {
		return cmCode;
	}
	public void setCmCode(int cmCode) {
		this.cmCode = cmCode;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "PostCommentVO [cmCode=" + cmCode + ", contents=" + contents + ", name=" + name + "]";
	}
}
