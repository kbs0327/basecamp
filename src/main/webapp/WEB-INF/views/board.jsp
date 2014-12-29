<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	checkEmail=function() {
		var email = document.addForm.email.value;
		var result = true;
		
		if(email == "") { //존재하는지 확인
			alert("email을 입력해 주세요.");
			return false;
		}
		
		var atIndex = email.indexOf("@");
		if(atIndex == -1 || atIndex != email.lastIndexOf("@")) { //@가 1개만 존재하는지 확인
			alert("email형식에 맞지 않습니다.");
			return false;
		}
		
		var dotIndex = email.indexOf(".");
		if(dotIndex == -1 || dotIndex != email.lastIndexOf(".")) { //.이 1개만 존재하는지 확인
			alert("email형식에 맞지 않습니다.");
			return false;
		}
		
		if(atIndex == 0
				|| dotIndex-atIndex == 1
				|| dotIndex == email.length - 1) { //@와 . 양 옆에 문자열이 존재하는지 확인
			alert("email형식에 맞지 않습니다.");
			return false;
		}
		
		if(atIndex < dotIndex) {
			result = true;
		} else {
			alert("email형식에 맞지 않습니다.");
			result = false;
		}
		
		return result;
	}
	
	fncAddSubmit = function() {
		if(checkEmail()) {
			document.addForm.submit();
		}
	}
	
	transDateFormat = function(date) {
		var colIndex = date.lastIndexOf(":");
		var str =  date.substring(0,colIndex);
		document.write(str);
	}
</script>
<title>게시판</title>
</head>
<body>
<form action="add" name="addForm" method="post">
	<table>
		<tr>
			<td width="50%">이메일 : <input type = "text" name = "email"></td>
			<td width="50%">비밀번호 : <input type = "password" name = "password"></td>
		</tr>
		<tr>
			<td colspan="2">본문</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea rows="10" cols="100" name = "body"></textarea>
			</td>
		</tr>
		<tr>
			<td align="right">
				<input type="button" value="추가" onclick="fncAddSubmit()">
			</td>
			<td align="left">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>	
</form>
<br>

<c:forEach var="entity" items="${entityList}">
	<form action="edit?eno=${entity.eno}" method="post">
		<table>
			<tr>
				<td>이메일 : ${entity.email}</td>
				<td>비밀번호 : <input type = "password" name = "password"></td>
				<td>변경시간 : <script type="text/javascript">transDateFormat('${entity.editTime}')</script></td>
			</tr>
			<tr>
				<td colspan="3">본문</td>
			</tr>
			<tr>
				<td colspan="3">
					<textarea rows="10" cols="100" name = "body">${entity.body}</textarea>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="3">
					<input type="submit" value="수정">
				</td>
			</tr>
		</table>
		<br>
	</form>
</c:forEach>
</body>
</html>