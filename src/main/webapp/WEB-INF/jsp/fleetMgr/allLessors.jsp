<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
    <title>All Cars page</title>
</head>
<body>
<h2 align="center">${sessionScope.loggedLessor.fullName} cars availability: </h2>
<div align="center">
    <table cellpadding="5" border="5px">
        <tr>
            <th>Brand</th>
            <th>Model</th>
            <th>Car Plate</th>
            <th>Fuel</th>
            <th>Options: Delete | Edit</th>
        </tr>
        <c:forEach items="${allCars}" var="car">
            <tr>
                <td>${car.brand}</td>
                <td>${car.model}</td>
                <td>${car.carPlate}</td>
                <td>${car.fuelType}</td>
                <td><a href="/lessor/removeCar/${car.id}"><button>Remove Car</button></a>
                    <a href="/lessor/editCar/${car.id}"><button>Edit Car</button></a>
                </td>

            </tr>
        </c:forEach>
        <tr>
            <td><a href="<c:url value="/lessor/dashboard" />"><button>Back to dashboard</button></a></td>
        </tr>
        <%--<tr>--%>
            <%--<td><a href="<c:url value="/lessor/removeCar/${allCars.id}"/>"><button>Remove Car</button></a></td>--%>
        <%--</tr>--%>
    </table>
</div>

</table>
</body>



<%--<tr>--%>
<%--<td><a href="/driver/add">Pair driver to car</a></td>--%>
<%--</tr>--%>
