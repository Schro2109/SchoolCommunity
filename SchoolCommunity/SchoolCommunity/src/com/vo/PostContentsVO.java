package com.vo;

public class PostContentsVO {
	private String pType;
	private String title;
	private String name;
	private String contents;
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
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "PostContentsVO [pType=" + pType + ", title=" + title + ", name=" + name + ", contents=" + contents
				+ "]";
	}

	
}
