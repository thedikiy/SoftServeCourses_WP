<%@include file="../resources/head.jsp"%>
<html>
<head>
    <title>Journey ${journey.journeyID}</title>
</head>
<body>
<%@include file="../resources/nav.jsp"%>
<h1>Рейс №${journey.journeyID}</h1>
<button class="btn"><a href="/journey_list">Назад</a></button>
<p>Место отправления: ${journey.fromPlace}</p>
<p>Место прибытия: ${journey.destination}</p>
<p>Время отправления: <fmt:formatDate value="${journey.leavingDate}"
                                      pattern="yyyy-MM-dd"/></p>
<p>Время прибытия:<fmt:formatDate value="${journey.arrivingDate}"
                                  pattern="yyyy-MM-dd"/></p></p>
<a href="/driver?id=${journey.driver.driverID}">Водитель: ${journey.driver.driverName}
    ${journey.driver.driverSurname}</a>
<p><a href="/bus?id=${journey.bus.busID}">Автобус:
    ${journey.bus.busModel}</a></p>
<p>Пассажиры:</p>
<c:forEach items="${journey.passengers}" var="passanger">
    <p>
        <a href="/passenger?id=${passanger.passengerID}">${passanger.passengerName}
                ${passanger.passengerSurname}</a></p>
</c:forEach>
<button class="btn">
    <a href="/journey/edit?id=${journey.journeyID}">Изменить...</a></button>
<button class="btn">
    <a href="/journey/delete?id=${journey.journeyID}">Удалить...</a></button>
</body>
</html>
