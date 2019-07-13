<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c"
           uri = "http://java.sun.com/jsp/jstl/core" %>
<form:form method="post"
           modelAttribute="car">
    <h3>Register car</h3>
    Car Plate: <form:input path="carPlate"/><br/>
    <form:errors path="carPlate"/>
    Brand: <form:password path="brand"/><br/>
    <form:errors path="brand"/>
    Model: <form:input path="model"/><br/>
    Fuel Type: <form:input path="fuelType"/><br/>
    Supplier: <form:select path="lessor" items="${allLessors}" itemLabel="fullName" itemValue="id" /> <br/>
    <input type = "submit" value = "Add car"/>
</form:form>
