<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="로그인"/>

<%@ include file="/view/usr/common/header.jsp" %>

<script>
	const submitForm = function(form) {
		form.loginId.value = form.loginId.value.trim();
		form.loginPw.value = form.loginPw.value.trim();
		
		if(form.loginId.value.length == 0) {
			alert('아이디를 입력하세요.');
			form.loginId.focus();
			return false;
		}
		if(form.loginPw.value.length == 0) {
			alert('비밀번호를 입력하세요.');
			form.loginPw.focus();
			return false;
		}
		return true;
	}
</script>

<form action="/usr/member/doLogin" method="post" onsubmit="return submitForm(this)">
	<table border="1">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="loginId"/></td>		
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="text" name="loginPw"/></td>		
		</tr>
		<tr>
			<td>
				<button>로그인</button>
			</td>
		</tr>
	</table>
</form>


<%@ include file="/view/usr/common/footer.jsp" %>