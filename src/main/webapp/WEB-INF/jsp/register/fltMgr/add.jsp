<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>Registration Page</title>
<style type="text/css">
    .error {
        color: red;
    }
</style>
<h3 align="center">${headermessage}</h3>
<form:form method="post" modelAttribute="employee">
    <h3 align="center">Register as fleet manager employee:</h3>
    <table align="center">
        <caption align="top">Fleet manager registration form:</caption>
            <tr>
                <td>First name: </td>
                <td><form:input path="firstName"/></td>
                <td><form:errors path="firstName" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Second name: </td>
                <td><form:input path="lastName"/></td>
                <td><form:errors path="lastName" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Enter email: </td>
                <td><form:input path="email"/></td>
                <td><form:errors path="email" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Enter Password:</td>
                <td><form:password path="password"/></td>
                <td><form:errors path="password" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Checkbox if Admin role:</td>
                <td><form:checkbox path="admin"/></td>
            </tr>
            <tr>
                <td><input type = "submit" value = "Sign up"/></td>
                <td><input type="hidden" name="action" value="register" /></td>
            </tr>
    </table>
</form:form>