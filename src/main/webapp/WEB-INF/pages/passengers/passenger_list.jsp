<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Passengers</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
</head>
<body>
<h1 align="center">Список Пассажиров</h1>
<button class="btn"><a href="/">Назад</a></button>
<div class="row">
    <table>
        <thead>
        <tr>
            <th class="col-md-1">#</th>
            <th class="col-md-4">Имя</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${passengers}" var="passenger" varStatus="count">
            <tr>
                <th class="col-md-1">${count.index + 1}</th>
                <td class="col-md-4">
                    <c:url value="/passenger?id=${passenger.passengerID}" var="passengerUrl"/>
                    <a href=${passengerUrl}>${passenger.passengerName}</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<button class="btn"><a href="/passenger/edit">Добавить...</a></button>
</body>
</html>
