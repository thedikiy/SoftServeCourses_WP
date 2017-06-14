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
<h1>Рейс №${journey.journeyID}</h1>
<button class="btn"><a href="/journey_list">Назад</a></button>
<p>Место отправления: ${journey.fromPlace}</p>
<p>Место прибытия: ${journey.destination}</p>
<a href="/driver?id=${journey.driver.driverID}">Водитель: ${journey.driver.driverName}
    ${journey.driver.driverSurname}</a>
<p><a href="/bus?id=${journey.bus.busID}">Автобус:
    ${journey.bus.busModel}</a></p>
<button class="btn">
    <a href="/journey/edit?id=${journey.journeyID}">Изменить...</a></button>
</body>
</html>
