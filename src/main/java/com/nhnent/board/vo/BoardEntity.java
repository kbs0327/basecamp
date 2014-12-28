package com.nhnent.board.vo;

import java.sql.Time;
import java.util.Date;

public class BoardEntity {
	private int eno;
	private String email;
	private String password;
	private String body;
	private Time writeTime;
	private Time editTime;
	
	
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
	public Date getWriteTime() {
		return writeTime;
	}
	public BoardEntity setWriteTime(Time writeTime) {
		this.writeTime = writeTime;
		return this;
	}
	public Time getEditTime() {
		return editTime;
	}
	public BoardEntity setEditTime(Time editTime) {
		this.editTime = editTime;
		return this;
	}
	
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
}
