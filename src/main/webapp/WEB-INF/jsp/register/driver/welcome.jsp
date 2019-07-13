<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
    <title>Welcome Page</title>
</head>
<body>
<h3 align="right">
    <a href="<c:url value="/home" />">
        <button>
            Back
        </button>
    </a>
</h3>
<h2 align="center">${headerMessage}</h2>
<h3 align="center">You have registered as a company Car User with following Info::::</h3>
<table align="center" border="5px">
    <tr>
        <td>Driver full name:</td>
        <td>${caruser.fullName}</td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${caruser.email}</td>
    </tr>
    <tr>
        <td>Company ID card number: </td>
        <td>${caruser.companyId}</td>
    </tr>
    <tr>
        <td>Fuel card holder ?: </td>
        <td>${caruser.fuelCard}</td>
    </tr>
    </table>
</body>
</html>
