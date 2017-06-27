<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <title>Driver ${driver.driverID}</title>
</head>
<body>
<h1>Водитель ${driver.driverID}</h1>
<button class="btn"><a href="/driver_list">Назад</a></button>
<p>Имя: ${driver.driverName}</p>
<p>Фамилия: ${driver.driverSurname}</p>
<p>Номер телефона: ${driver.phoneNumber}</p>
<p>Лицезия оканчивается:
    <fmt:formatDate value="${driver.licenceExpire}" pattern="yyyy-MM-dd"/> </p>
<p>Рейсы:</p>
<c:forEach items="${driver.journeys}" var="journey"><p><a
        href="/journey?id=${journey.journeyID}">${journey.fromPlace}
        ${journey.destination}</a></p></c:forEach>

<button class="btn"><a href="/driver/edit?id=${driver.driverID}">Изменить...</a></button>
</body>
</html>
