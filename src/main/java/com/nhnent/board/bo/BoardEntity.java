package com.nhnent.board.bo;

public class BoardEntity {
	private String email;
	private String password;
	private String body;
	
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
}
