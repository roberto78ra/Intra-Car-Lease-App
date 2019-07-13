<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
    <title>Welcome Page</title>
</head>
<body>
<h2 align="center">Welcome Car Lessor, ${sessionScope.loggedLessor.fullName} please choose an action below: </h2>
<table align="center" border="5px">
    <tr>
        <td><a href="/lessor/addCar">Add car(s) to database</a></td>

    </tr>
    <tr>
        <td><a href="/lessor/allCars">List of all available cars</a></td>
        <c:forEach items="${allCars}" var="car">
            <b>Car model:</b> ${lessor.fullName} <br/>
            <a href="/showCars/${lessor.id}">select</a>
        </c:forEach> <br/>
    </tr>
    <tr>
        <td><a href="/driver/add">Pair driver to car</a></td>
    </tr>
    <tr>
        <td><a href="<c:url value="/home" />"><button>Back to  home page</button></a></td>
    </tr>
</table>
</body>

/home/roberto/IntraCarLease/src/main/webapp/WEB-INF/jsp/home/fleetMgr/welcome.jsp