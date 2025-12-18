<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="목록"/>

<%@ include file="/view/usr/common/header.jsp" %>


	<table border="1">
		<c:if test="${articles != null }" >
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
			<c:forEach items="${articles }" var="article">
				<tr>
					<td>${article.getId() }</td>
					<td>${article.getWriterName() }</td>
					<td><a href="/usr/article/detail?id=${article.getId() }">${article.getTitle() }</a></td>
					<td>${article.getRegDate() }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${articles == null }" >
			<tr>
				<th colspan="4">게시글이 존재하지 않습니다.</th>
			</tr>
		</c:if>
	</table>


<%@ include file="/view/usr/common/footer.jsp" %>