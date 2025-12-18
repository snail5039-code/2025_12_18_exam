<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="상세보기"/>

<%@ include file="/view/usr/common/header.jsp" %>


	<table border="1">
	<c:if test="${article != null }">
		<tr>
			<th>번호</th>
			<td>${article.getId() }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${article.getWriterName() }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${article.getTitle() }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${article.getRegDate() }</td>
		</tr>
		<tr>
			<th>수정일</th>
			<td>${article.getUpdateDate() }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${article.getContent() }</td>
		</tr>
	</c:if>
	<c:if test="${article == null }">
		<tr>
			<th>게시글이 존재하지 않습니다</th>
		</tr>
	</c:if>
	</table>


<%@ include file="/view/usr/common/footer.jsp" %>