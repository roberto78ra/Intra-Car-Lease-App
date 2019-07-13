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
<h3 align="center">You have registered as Car Lessor with following Info::::</h3>
<table align="center" border="5px">
    <tr>
        <td>Lessor full name:</td>
        <td>${lessor.fullName}</td>
    </tr>
    <tr>
        <td>NIP:</td>
        <td>${lessor.nip}</td>
    </tr>
    <tr>
        <td>REGON:</td>
        <td>${lessor.regon}</td>
    </tr>
    <tr>
        <td>Address: </td>
        <td>${lessor.address}</td>
    </tr>
    <tr>
        <td><a href="<c:url value="/home" />">
            <button>
                Back to home page
            </button>
        </a></td>
    </tr>
    </table>
</body>
</html>
