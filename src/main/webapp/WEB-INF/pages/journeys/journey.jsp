<%@include file="/resources/static/head.jsp" %>
<html>
<head>
    <title>Journey ${journey.journeyID}</title>
</head>
<body>
<%@include file="/resources/static/nav.jsp" %>
<div class="content">
    <h1>Рейс №${journey.journeyID}</h1>
    <p>Место отправления: ${journey.fromPlace}</p>
    <p>Место прибытия: ${journey.destination}</p>
    <p>Время отправления: <fmt:formatDate value="${journey.leavingDate}"
                                          pattern="yyyy-MM-dd"/></p>
    <p>Время прибытия: <fmt:formatDate value="${journey.arrivingDate}"
                                       pattern="yyyy-MM-dd"/></p></p>
    <sec:authorize access="hasAnyAuthority('ADMIN','MANAGER')">
        Водитель: <a href="/driver?id=${journey.driver.driverID}">
            ${journey.driver.driverName} ${journey.driver.driverSurname}</a>
        <p>Автобус: <a href="/bus?id=${journey.bus.busID}">
                ${journey.bus.busModel}</a></p>
        <p>Пассажиры:</p>
        <c:forEach items="${journey.passengers}" var="passanger">
            <p>
                <a href="/passenger?id=${passanger.passengerID}">${passanger.passengerName}
                        ${passanger.passengerSurname}</a></p>
        </c:forEach>
    </sec:authorize>
    <sec:authorize access="hasAuthority('PASSENGER') or isAnonymous()">
        <a class="button submit_button"
           href="/journey/buy_ticket?id=${journey.journeyID}">Заказать билет</a>
    </sec:authorize>
    <sec:authorize access="hasAnyAuthority('ADMIN','MANAGER')">
        <a class="button submit_button" href="/journey/edit?id=${journey.journeyID}">Изменить...</a>
        <a class="button delete_button" href="/journey/delete?id=${journey.journeyID}">Удалить...</a>
    </sec:authorize>
</div>
</body>
</html>
