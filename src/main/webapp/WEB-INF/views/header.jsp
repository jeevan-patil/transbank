<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.8.0.js" type="text/javascript"></script>
</head>
<body>
	<div align="right">
		Welcome <strong><sec:authentication property="principal.username" /></strong> | <a href="${pageContext.request.contextPath}/j_spring_security_logout">Logout</a>
	</div>
	<div id="tabs">
		<ul>
			<li><a href="${pageContext.request.contextPath}/customer/view">View Customers</a></li>
			
			<sec:authorize ifAnyGranted="ROLE_ADMIN">
				<li><a href="${pageContext.request.contextPath}/customer/add">Add Customers</a></li>
				<li><a href="${pageContext.request.contextPath}/cash/handle">Cash Handling</a></li>
			</sec:authorize>						
		</ul>		
	</div>
</body>
</html>