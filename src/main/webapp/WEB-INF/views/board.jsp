<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
</head>
<body>
<form action="add" method="post">
	이메일 : <input type = "text" name = "email">
	비밀번호 : <input type = "password" name = "password"><br>
	본문<br>
	<textarea rows="10" cols="100" name = "body"></textarea><br>
	<input type="submit" value="추가">
	<input type="reset" value="취소">
</form>
</body>
</html>