<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>View Student</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Students Management</h1>
    <h2>
        <a href="new">Add New Student</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">List All Students</a>
    </h2>
</div>
<div align="center">
    <c:if test="${student != null}">
        <div>
            <b>Names: </b><c:out value='${student.getFirstName()} ${student.getLastName()}'></c:out>
            <br>
            <b>gender: </b><c:out value='${student.getGender()}'></c:out>
        </div>
    </c:if>
</div>
</body>
</html>