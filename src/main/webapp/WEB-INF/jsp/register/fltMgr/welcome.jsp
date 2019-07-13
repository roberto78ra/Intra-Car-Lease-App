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
            Back to home page
        </button>
    </a>
</h3>
<h2 align="center">${headerMessage}</h2>
<h3 align="center">You have registered as fleet manager with following Info::::</h3>
<table align="center" border="5px">
    <tr>
        <td>Fleet manager name:</td>
        <td>${employee.firstName}</td>
    </tr>
    <tr>
        <td>Fleet manager last name:</td>
        <td>${employee.lastName}</td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${employee.email}</td>
    </tr>
    <tr>
        <td>Admin role: </td>
        <td>${employee.admin}</td>
    </tr>
    <tr>
        <td><a href="<c:url value="/home" />">
            <button>
                Back to  home page
            </button>
        </a></td>
    </tr>

    </table>
</body>
</html>
