<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style type="text/css">
    .error {
        color: red;
    }
</style>
<h3 align="center">${headermessage}</h3>
<form:form method="post" modelAttribute="viewModeCarUser">
    <h3 align="center">Login as Car User employee:</h3>
    <table align="center">
        <caption align="top">Car driver login form:</caption>
        <tr>
            <td>Email: </td>
            <td><form:input path="email"/></td>
            <td><form:errors path="email" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Company ID: </td>
            <td><form:input path="companyId"/></td>
            <td><form:errors path="companyId" cssClass="error"/></td>
        </tr>
        <tr>
            <td><input type="hidden" name="action" value="login"/></td>
            <td><input type = "submit" value = "Sign in"/></td>
        </tr>

    </table>
</form:form>