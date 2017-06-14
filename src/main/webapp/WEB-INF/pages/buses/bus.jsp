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
<h4><a href="/buslist">Назад</a></h4>
<p>Модель: ${bus.busModel}</p>
<p>Регистрационный номер: ${bus.registrationNumber}</p>
<p>Дата последнего ТО: ${bus.lastTI}</p>
<p>Дата следующего ТО: ${bus.nextTI}</p>
<p>Рейсы:</p>
<p><c:forEach items="${bus.journeys}" var="journey">${journey.fromPlace}
${journey.destination}</c:forEach></p>
<h4><a href="/bus/edit?id=${bus.busID}">Изменить...</a></h4>
</body>
</html>
