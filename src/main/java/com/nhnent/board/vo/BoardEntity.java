package com.nhnent.board.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardEntity {
	private int eno;
	private String email;
	private String password;
	private String body;
	private Date writeTime;
	private Date editTime;
	
	
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
	public String getWriteTime() {
		return new SimpleDateFormat("yyyy년 M월 d일 a h:mm:s-S").format(writeTime);
	}
	public BoardEntity setWriteTime(Date writeTime) {
		this.writeTime = writeTime;
		return this;
	}
	public String getEditTime() {
		return new SimpleDateFormat("yyyy년 M월 d일 a h:mm:s-S").format(editTime);
	}
	public BoardEntity setEditTime(Date editTime) {
		this.editTime = editTime;
		return this;
	}
	
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
	public static boolean checkEmail(String email) {
		if(email.length() == 0) { //존재하는지 확인
			return false;
		}
		
		int atIndex = email.indexOf('@');
		if(atIndex != email.lastIndexOf('@')) { //@문자는 전체 이메일 주소에서 1개만 들어가 있어야 함니다.
			return false;
		}
		
		int dotIndex = email.indexOf('.');
		if(dotIndex != email.lastIndexOf('.')) { //.문자는 전체 이메일 주소에서 1개만 들어가 있어야 합니다.
			return false;
		}
		
		if(atIndex == 0
				||dotIndex - atIndex == 1
				||dotIndex == email.length() - 1) { //@와 . 양 옆에 문자열이 존재하는지 확인
			return false;
		}
		
		if(atIndex < dotIndex) { // 이메일 주소는  aaa@aaa.com 형식으로 항상 .앞에 @가 들어갑니다.
			return true;
		} else {
			return false;
		}
	}
	
	
}
