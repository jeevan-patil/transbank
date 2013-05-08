<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
</head>
<body>
	<!-- Check if customer is already logged in, if yes redirect to dashboard -->
	<sec:authorize ifNotGranted="ROLE_ANONYMOUS">
		<%
		    response.sendRedirect("dashboard");
		%>
	</sec:authorize>

	<div align="center">
		<label style="color: red;"> 
			<c:choose>
				<c:when test="${param.msg == 'cw'}">
					       Login Failed. Please try again.
					   </c:when>
				<c:when test="${param.msg == 'se'}">
					       Session expired. Please login again.
                       </c:when>
				<c:when test="${param.msg == 'al'}">
                            User is already logged in.
                       </c:when>
				<c:when test="${param.msg == 'sedl'}">
                            Duplicate login tried.
                       </c:when>
				<c:when test="${param.msg == 'ce'}">
                            Credentials expired.
                       </c:when>
				<c:when test="${param.msg == 'ad'}">
                            Account disabled.
                       </c:when>
			</c:choose>
		</label>
	</div>
	<div align="center">
		<form id="transbank-login" name="transbank-login" method="POST" action="${pageContext.request.contextPath}/j_spring_security_check">
			<table>
				<tr>
					<td>User Name :</td>
					<td><input type="text" id="j_username" name="j_username" tabindex="1"></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" id="j_password" name="j_password" tabindex="2"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="checkbox" id="j_remember" name="_spring_security_remember_me" />&nbsp;Remember me</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" id="loginBttn" name="loginBttn" value="Sign IN"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>