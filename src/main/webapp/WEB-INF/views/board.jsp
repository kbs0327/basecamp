<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
</head>
<body>
<form action="add" method="post">
	<table>
		<tr>
			<td>이메일 : <input type = "text" name = "email"></td>
			<td>비밀번호 : <input type = "password" name = "password"></td>
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
				<input type="submit" value="추가">
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
				<td>변경시간 : ${entity.editTime}</td>
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