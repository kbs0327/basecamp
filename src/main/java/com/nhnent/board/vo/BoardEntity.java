package com.nhnent.board.vo;

import java.sql.Time;
import java.util.Date;

public class BoardEntity {
	private int eno;
	private String email;
	private String password;
	private String body;
	private Time write_time;
	
	
	public int getEno() {
		return eno;
	}
	public BoardEntity setEno(int eno) {
		this.eno = eno;
		return this;
	}
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
	public Date getWrite_time() {
		return write_time;
	}
	public BoardEntity setWrite_time(Time writingDate) {
		this.write_time = writingDate;
		return this;
	}
}
