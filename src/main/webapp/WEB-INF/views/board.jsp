<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="//code.jquery.com/jquery-1.11.2.min.js"></script>
	<script type="text/javascript">
		$(function() { 
			$(".btn-primary").click(function() {
				if($(this).val()=="수정") {
					var eno = $(this).attr("name");
					var clickedDom = $(this);
					$.ajax({
						type:"post",
						url: "/board/passwordConfirm",
						dataType: "text",
						data:"eno=" + $(this).attr("name") + "&password=" + $("#password-"+ $(this).attr("name")).val(),
						success: function(data) {
							if(data=="true") {
								$("#textarea-"+eno).removeAttr("readonly");
								var updateBtn = " <input id='update' type='submit' class='btn btn-warning' value='반영'>";
								clickedDom.after(updateBtn);
								clickedDom.remove();
							} else if(data=="false"){
								alert("password가 맞지 않습니다.");
							}
						},
						error: function(data) {
							alert("error");
							}
						})
				}
			});
		});
	
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
<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-6">
		<center><h2><b>방명록 추가</b></h2></center>
		<form action="add" name="addForm" method="post">
			<table class="table">
				<tr>
					<td width="50%">
						<div class="input-group input-group">
						  <span class="input-group-addon" id="sizing-addon2">Email</span>
						  <input type="text" name="email" class="form-control" aria-describedby="sizing-addon2">
						</div>
					</td>
					<td width="50%">
						<div class="input-group input-group">
						  <span class="input-group-addon" id="sizing-addon2">Password</span>
						  <input type="password" name="password" class="form-control" aria-describedby="sizing-addon2">
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea rows="5" name = "body"  class="form-control" placeholder="본문"></textarea>
					</td>
				</tr>
				<tr>
					<td align="right">
						<button type="button" class="btn btn-primary" onclick="fncAddSubmit()">추가</button>
					</td>
					<td align="left">
						<input type="reset" class="btn btn-warning" value="취소">
					</td>
				</tr>
			</table>
		</form>
		<br>
		<br>
		<center><h2><b>방명록 목록</b></h2></center>
		<c:forEach var="entity" items="${entityList}">
			<form action="edit?eno=${entity.eno}" method="post" class="form-horizontal">
				<table class="table">
					<tr>
						<td width="100">
							<div class="form-group">
							    <label class="col-sm-2 control-label">Email</label>
							    <div class="col-sm-10">
							      <p class="form-control-static">${entity.email}</p>
							    </div>
							 </div>
						</td>
					</tr>
					<tr>
						<td width="50%">
							<div class="form-group">
							    <label class="col-sm-2 control-label">Password</label>
							    <div class="col-sm-6">
							      <input type="password" name="password" id="password-${entity.eno}" class="form-control" aria-describedby="sizing-addon2">
							    </div>
							 </div>	
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="form-group">
							    <label class="col-sm-2 control-label">변경시간</label>
							    <div class="col-sm-10">
							      <p class="form-control-static"><script type="text/javascript">transDateFormat('${entity.editTime}')</script></p>
							    </div>
							 </div>
						</td>
					</tr>
					<tr>
						<td colspan="3">
							<textarea id="textarea-${entity.eno}" rows="5" cols="100" name = "body" class="form-control" readonly>${entity.body}</textarea>
						</td>
					</tr>
					<tr>
						<td align="center" colspan="3">
							<input name="${entity.eno}" type="button" class="btn btn-primary" value="수정">
						</td>
					</tr>
				</table>
				<br>
			</form>
		</c:forEach>
	</div>
	<div class="col-md-3"></div>
</div>	
</body>
</html>