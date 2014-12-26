package com.nhnent.board.vo;

import java.util.Date;

public class BoardEntity {
	private String email;
	private String password;
	private String body;
	private Date writingDate;
	
	
	public String getEmail() {
		return email;
	}
	public BoardEntity setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public BoardEntity setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getBody() {
		return body;
	}
	public BoardEntity setBody(String body) {
		this.body = body;
		return this;
	}
	public Date getWritingDate() {
		return writingDate;
	}
	public BoardEntity setWritingDate(Date writingDate) {
		this.writingDate = writingDate;
		return this;
	}
}
