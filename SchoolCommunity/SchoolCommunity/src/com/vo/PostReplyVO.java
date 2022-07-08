package com.vo;

public class PostReplyVO {
	private int reCode;
	private String contents;
	private String name;
	public int getReCode() {
		return reCode;
	}
	public void setReCode(int reCode) {
		this.reCode = reCode;
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
		return "PostReplyVO [reCode=" + reCode + ", contents=" + contents + ", name=" + name + "]";
	}
}
