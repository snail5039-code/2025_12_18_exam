<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="개인정보 수정"/>

<%@ include file="/view/usr/common/header.jsp" %>

<script>
	const submitForm = function(form) {
		form.loginPw.value = form.loginPw.value.trim();
		form.name.value = form.name.value.trim();

		if(form.loginPw.value.length == 0) {
			alert('비밀번호를 입력하세요.');
			form.loginPw.focus();
			return false;
		}

		if(form.name.value.length == 0) {
			alert('이름을 입력하세요.');
			form.name.focus();
			return false;
		}
		return true;
	}

</script>

<form action="/usr/member/doModify" method="post" onsubmit="return submitForm(this)">
	<input type="hidden" name="loginId" value="${member.getLoginId() }"/>
	<table border="1">
		<tr>
			<th>아이디</th>
			<td>${member.getLoginId() }</td>		
		</tr>
		<tr>
			<th>비밀번호 변경</th>
			<td><input type="text" name="loginPw" value="${member.getLoginPw() }"/></td>		
		</tr>
		<tr>
			<th>이름 변경</th>
			<td><input type="text" name="name" value="${member.getName() }"/></td>		
		</tr>
		<tr>
			<td>
				<button>개인정보 수정</button>
			</td>
		</tr>
	</table>
</form>


<%@ include file="/view/usr/common/footer.jsp" %>