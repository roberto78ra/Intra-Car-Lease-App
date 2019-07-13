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
<form:form method="post" modelAttribute="lessor">
    <h3 align="center">Register as Car Lessor:</h3>
    <table align="center">
        <caption align="top">Car Lessor registration form:</caption>
        <tr>
            <td>Lessor company full name: </td>
            <td><form:input path="fullName"/></td>
            <td><form:errors path="fullName" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Lessor company full address:</td>
            <td><form:input path="address"/></td>
            <td><form:errors path="address" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Lessor company NIP: </td>
            <td><form:input path="nip"/></td>
            <td><form:errors path="nip" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Lessor company REGON: </td>
            <td><form:input path="regon"/></td>
            <td><form:errors path="regon" cssClass="error"/></td>
        </tr>
        <tr>
            <td><input type = "submit" value = "Register"/></td>
        </tr>
    </table>
</form:form>