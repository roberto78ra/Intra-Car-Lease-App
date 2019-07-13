<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<form:form method="post" modelAttribute="viewModeCarUser">
    <h3>Car user login page</h3>
    Company Id card: <form:input path="companyId"/>
    <form:errors path="companyId" cssClass="error" />
    Email: <form:input path="email"/>
    <form:errors path="email" cssClass="error" />
    Name and  Surname: <form:input path="fullName"/>
    <form:errors path="fullName" cssClass="error" />
    <%--<input type="hidden" value="login" name="action"/>--%>
    <input type = "submit" value = "Sign in"/>
</form:form>


<%--<form:form method = "post" modelAttribute="viewModeFltMgr">--%>
    <%--<input type="hidden" value="register" name="action"/>--%>
    <%--<input type = "submit" value = "Register"/>--%>
<%--</form:form>--%>