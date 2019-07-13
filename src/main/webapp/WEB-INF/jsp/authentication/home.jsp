<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login As | IntraCarLease</title>
    <style>
        a {
            display: block;
            margin-bottom: 10px;
        }
        div{
            display: inline-block;
            alignment: center;
            margin-right: 50px;
        }
        #container {
            margin-left: 750px;
        }
    </style>
</head>

<body>
<h3 align="center">${headermessage}</h3>
<div id="container">
    <div  align="center">
        <h3>Log in as</h3>
        <a href="<c:url value="/register/fltMgr/login" /> ">
            <button>
                Fleet Manager
            </button>
        </a>
        <a href="<c:url value="/register/driver/login" /> ">
            <button>
                Car user
            </button>
        </a>
        <a href="<c:url value="/register/lessor/login" /> ">
            <button>
                Car Lessor
            </button>
        </a>
    </div>
    <div align="center">
        <h3>Signup as</h3>

        <a href="<c:url value="/register/fltMgr/add" /> ">
            <button>
                Fleet Manager
            </button>
        </a>
        <a href="<c:url value="/register/driver/add" /> ">
            <button>
                Car user
            </button>
        </a>
        <a href="<c:url value="/register/lessor/add" /> ">
            <button>
                Car Lessor
            </button>
        </a>
    </div>
</div>


</body>
</html>
