<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <title>BUS</title>
</head>
<body>
<h1>Автобус №${bus.busID}</h1>
<button class="btn"><a href="/buslist">Назад</a></button>
<p>Модель: ${bus.busModel}</p>
<p>Регистрационный номер: ${bus.registrationNumber}</p>
<p>Дата последнего ТО: ${bus.lastTI}</p>
<p>Дата следующего ТО: ${bus.nextTI}</p>
<p>Рейсы:</p>
<c:forEach items="${bus.journeys}" var="journey"><p>${journey.fromPlace}
${journey.destination}</p></c:forEach>
<button class="btn"><a href="/bus/edit?id=${bus.busID}" >Изменить...</a></button>
</body>
</html>
