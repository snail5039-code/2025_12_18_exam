<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<meta charset="UTF-8">
<title>${pageTitle }</title>
</head>
<body>
	<a href="/">home</a>
	<a href="/usr/article/list">list</a>
	<c:if test="${sessionScope.loginedMemberId == null }">
		<a href="/usr/member/join">join</a>
		<a href="/usr/member/login">login</a>
	</c:if>
	<c:if test="${sessionScope.loginedMemberId != null }">
		<a href="/usr/article/write">글 작성</a>
		<a href="/usr/member/logout">logout</a>
		<a href="/usr/member/modify?id=${sessionScope.loginedMemberId }">프로필 수정</a>
	</c:if>
