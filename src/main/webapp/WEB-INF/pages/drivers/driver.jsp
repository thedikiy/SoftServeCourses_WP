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
Водитель ${driver.driverID}
<button class="btn"><a href="/driver_list">Назад</a></button>
<p>Имя: ${driver.driverName}</p>
<p>Фамилия: ${driver.driverSurname}</p>
<p>Номер телефона: ${driver.phoneNumber}</p>
<p>Лицезия оканчивается: ${driver.licenceExpire}</p>
<p>Рейсы:</p>
<p><c:forEach items="${driver.journeys}" var="journey">${journey.fromPlace}
    ${journey.destination}</c:forEach></p>
<button class="btn"><a href="/driver/edit?id=${driver.driverID}">Изменить...</a></button>
</body>
</html>
