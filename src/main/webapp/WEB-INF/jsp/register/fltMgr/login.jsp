<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>Login Page</title>
<style type="text/css">
    .error {
        color: red;
    }
</style>
<h3 align="center">${headermessage}</h3>
<form:form method="post" modelAttribute="viewModeFltMgr">
    <h3 align="center">Login as fleet manager employee:</h3>
    <table align="center">
        <caption align="top">Fleet manager login form:</caption>
        <tr>
            <td>Email: </td>
            <td><form:input path="email"/></td>
            <td><form:errors path="email" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Password: </td>
            <td><form:password path="password"/></td>
            <td><form:errors path="password" cssClass="error"/></td>
        </tr>
        <tr>
            <td><input type="hidden" name="action" value="login"/></td>
            <td><input type = "submit" value = "Sign in"/></td>
        </tr>
    </table>
</form:form>
