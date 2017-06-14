<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <title>Journeys</title>
</head>
<body>
<h1>Список рейсов</h1>
<button class="btn"><a href="/">Назад</a></button>
<div class="row">
<table>
    <thead>
    <tr>
        <th class="col-md-1">#</th>
        <th class="col-md-4">Место отправленя</th>
        <th class="col-md-4">Место прибытия</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${journeyList}" var="journey" varStatus="count">
        <tr>
            <th class="col-md-1">${count.index + 1}</th>
                <td class="col-md-4">
                    <p>${journey.fromPlace}</p>
                </td>
                <td class="col-md-4">
                    <p>${journey.destination}</p>
                </td>
            <td class="col-md-4"><c:url value="/journey?id=${journey.journeyID}"
                       var="journeyUrl"/>
                <a href=${journeyUrl}>Подробнее...</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<button class="btn"> <a href="/journey/edit">Добавить...</a></button>
</body>
</html>
