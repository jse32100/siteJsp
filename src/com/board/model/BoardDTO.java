package com.board.model;

public class BoardDTO {
	private int num;
	private String title;
	private String writer;
	private String description;
	private String filename;
	private int readcount;
	private String reg_date;
	private String tag;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title == null ? "" : title.trim();
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer == null ? "" : writer.trim();
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDescription() {
		return description == null ? "" : description.trim();
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFilename() {
		return filename == null ? "" : filename.trim();
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getReg_date() {
		return reg_date == null ? "" : reg_date.trim();
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getTag() {
		return tag == null ? "" : tag.trim();
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	

}
