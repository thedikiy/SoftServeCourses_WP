<%@include file="/resources/static/head.jsp"%>
<html>
<head>
    <title>Passenger ${passenger.passengerID}</title>
</head>
<body>
<%@include file="/resources/static/nav.jsp"%>
<div class="content">
<h1>Пассажир №${passenger.passengerID}</h1>
<p>Имя: ${passenger.passengerName}</p>
<p>Фамилия: ${passenger.passengerSurname}</p>
<p>Рейсы:</p>
<c:forEach items="${passenger.journeys}" var="journey">
    <p><a href="/journey?id=${journey.journeyID}">${journey.fromPlace}
            ${journey.destination}</a>
    </p>
</c:forEach>
    <a class="button submit_button" href="/passenger/edit?id=${passenger.passengerID}">Изменить...</a>
    <a class="button delete_button" href="/passenger/delete?id=${passenger.passengerID}">Удалить...</a>
</div>
</body>
</html>
