<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="작성"/>

<%@ include file="/view/usr/common/header.jsp" %>

<script>
	const submitForm = function(form) {
		form.title.value = form.title.value.trim();
		form.content.value = form.content.value.trim();
		
		if(form.title.value.length == 0) {
			alert('제목을 입력하세요.');
			form.title.focus();
			return false;
		}
		if(form.content.value.length == 0) {
			alert('내용을 입력하세요.');
			form.content.focus();
			return false;
		}
		return true;
	}

</script>

<form action="/usr/article/doWrite" method="post" onsubmit="return submitForm(this)">
	<table border="1">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" /></td>		
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" ></textarea></td>		
		</tr>
		<tr>
			<td>
				<button>작성</button>
			</td>
		</tr>
	</table>
</form>


<%@ include file="/view/usr/common/footer.jsp" %>