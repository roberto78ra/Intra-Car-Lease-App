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
<form:form method="post" modelAttribute="caruser">
    <h3 align="center">Register as car user employee:</h3>
    <table align="center">
        <caption align="top">Car user registration form:</caption>
        <tr>
            <td>Full name: </td>
            <td><form:input path="fullName"/></td>
            <td><form:errors path="fullName" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Enter email: </td>
            <td><form:input path="email"/></td>
            <td><form:errors path="email" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Enter company card number:</td>
            <td><form:password path="companyId"/></td>
            <td><form:errors path="companyId" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Checkbox if fuel card holder:</td>
            <td><form:checkbox path="fuelCard"/></td>
        </tr>
        <tr>
            <td><input type = "submit" value = "Register"/></td>
            <input type="hidden" value="register" name="action"/>
        </tr>
    </table>
</form:form>