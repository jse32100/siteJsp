package com.movie.model;

public class commentMovieDTO {
	
	private int bnum;
	private String content;
	private String nickname;
	private String reg_date;
	private int cnum;
	
	
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getContent() {
		return content == null ? "" : content.trim();
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNickname() {
		return nickname == null ? "" : nickname.trim();
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getReg_date() {
		return reg_date == null ? "" : reg_date.trim();
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	
	
	
	

}
