<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Being Java Guys | Registration Form</title>
</head>
<body>
<center>

    <div style="color: teal; font-size: 30px">Being Java Guys |
        Registration Form</div>

    <form:form method="post" action="register" modelAttribute="employeeObject">
        <table width="400px" height="150px">
            <tr>
                <form:input path="id" type="hidden" value="${employeeObject.id}"/>
                <td><form:label path="firstName">First Name</form:label>
                </td>
                <td><form:input path="firstName" value="${employeeObject.firstName}"/>
                </td>
            </tr>
            <tr>
                <td><form:label path="lastName">Last Name</form:label>
                </td>
                <td><form:input path="lastName" value="${employeeObject.lastName}"/>
                </td>
            </tr>
            <tr>
                <td><form:label path="email">Email</form:label>
                </td>
                <td><form:input path="email" value="${employeeObject.email}"/>
                </td>
            </tr>
            <tr>
                <td><form:label path="phone">Phone</form:label>
                </td>
                <td><form:input path="phone" value="${employeeObject.phone}"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save" /></td>
            </tr>
        </table>
    </form:form>
    <a href="list">Click Here to see User List</a>
</center>
</body>
</html>
