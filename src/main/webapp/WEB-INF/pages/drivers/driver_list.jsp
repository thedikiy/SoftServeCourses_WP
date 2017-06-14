<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <title>driveres</title>
</head>
<body>
<h1>Список водителей</h1>
<h4><a href="/">Назад</a></h4>
<div class="row">
<table>
    <thead>
    <tr>
        <th class="col-md-1">#</th>
        <th class="col-md-4">Имя</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${driverList}" var="driver" varStatus="count">
        <tr>
            <th class="col-md-1">${count.index + 1}</th>
            <td class="col-md-4">
                <c:url value="/driver?id=${driver.driverID}" var="driverUrl"/>
                <a href=${driverUrl}>${driver.driverName} ${driver.driverSurname}</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<h4><a href="/driver/edit">Добавить...</a></h4>
</body>
</html>
