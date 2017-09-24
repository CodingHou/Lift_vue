
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h2>Hello World!</h2>
<form:form method="post" modelAttribute="user" action="/toJson">
    用户名:<input path="name"/>
    密码:<input  path="password"/>
    <input type="submit" value="提交">
</form:form>
</body>
</html>