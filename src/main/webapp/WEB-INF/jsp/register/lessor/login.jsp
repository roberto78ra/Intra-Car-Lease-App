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
<form:form method="post" modelAttribute="lessor">
    <h3 align="center">Login as Car Lessor:</h3>
    <table align="center">
        <caption align="top">Car Lessor login form:</caption>
        <tr>
            <td>Lessor full name: </td>
            <td><form:input path="fullName"/></td>
            <td><form:errors path="fullName" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Lessor NIP number: </td>
            <td><form:input path="nip"/></td>
            <td><form:errors path="nip" cssClass="error"/></td>
        </tr>
        <tr>
            <td><input type = "submit" value = "Sign in"/></td>
            <input type="hidden" name="action" value="login"/>
        </tr>
    </table>
</form:form>
