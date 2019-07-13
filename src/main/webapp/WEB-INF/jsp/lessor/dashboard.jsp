<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
    <title>Welcome Page</title>
</head>
<body>
<h2 align="center">Welcome ${sessionScope.loggedLessor.fullName} please choose an action below: </h2>
<table align="center" border="5px">
    <tr>
        <td><a href="<c:url value="/lessor/addCar" /> ">
            <button>Add car(s) to database</button>
            </a>
        </td>
    </tr>
    <tr>
        <td><a href="<c:url value="/lessor/allCars" /> ">
            <button>Display all available cars</button>
            </a>
        </td>
    </tr>
    <tr>
        <td><a href="<c:url value="/home" />"><button>Back to home page</button></a></td>
    </tr>
</table>
</body>
<%--<c:forEach items="${allCars}" var="car">--%>
<%--${lessor.fullName} <br/>--%>
<%--<a href="/showCars/${car.id}">${car.carPlate}</a>--%>
<%--</c:forEach>--%>

<%--<tr>--%>
<%--<td><a href="/driver/add">Pair driver to car</a></td>--%>
<%--</tr>--%>