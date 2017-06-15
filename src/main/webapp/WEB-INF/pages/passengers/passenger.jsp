<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <title>journey</title>
</head>
<body>
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
</body>
</html>
