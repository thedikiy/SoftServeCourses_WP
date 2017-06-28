<%@include file="../resources/head.jsp"%>
<html>
<head>
    <title>Passenger ${passenger.passengerID}</title>
</head>
<body>
<%@include file="../resources/nav.jsp"%>
<h1>Пассажир №${passenger.passengerID}</h1>
<button class="btn"><a href="/passenger_list">Назад</a></button>
<p>Имя: ${passenger.passengerName}</p>
<p>Фамилия: ${passenger.passengerSurname}</p>
<p>Рейсы:</p>
<c:forEach items="${passenger.journeys}" var="journey">
    <p><a href="/journey?id=${journey.journeyID}">${journey.fromPlace}
            ${journey.destination}</a>
    </p>
</c:forEach>
<button class="btn">
    <a href="/passenger/edit?id=${passenger.passengerID}">Изменить...</a></button>
<button class="btn">
    <a href="/passenger/delete?id=${passenger.passengerID}">Удалить...</a></button>

</body>
</html>
