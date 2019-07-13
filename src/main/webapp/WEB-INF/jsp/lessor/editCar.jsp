<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>Car add Page</title>
<style type="text/css">
    .error {
        color: red;
    }
</style>
<form:form method="post" modelAttribute="car">
    <h3 align="center">Edit car:</h3>
    <table align="center">
        <tr>
            <td>Car plate:</td>
            <td><form:input path="carPlate"/></td>
            <td><form:errors path="carPlate"/></td>
        </tr>
        <tr>
            <td>Car brand:</td>
            <td><form:input path="brand"/></td>
            <td><form:errors path="brand" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Car model:</td>
            <td><form:input path="model"/></td>
            <td><form:errors path="brand"/></td>
        </tr>
        <tr>
            <td>Fuel type:</td>
            <td><form:input path="fuelType"/></td>
            <td><form:errors path="fuelType"/></td>
        </tr>
        <tr>
            <td><form:hidden path="lessor" value="${sessionScope.loggedLessor.id}"/></td>
        </tr>
        <tr>
            <td><input type = "submit" value = "AddCar"/></td>

        </tr>
    </table>
</form:form>