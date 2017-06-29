<%@include file="/resources/head.jsp" %>
<html>
<head>
    <title>Driver ${driver.driverID}</title>
</head>
<body>
<%@include file="/resources/nav.jsp" %>
<div class="content"><h1>Водитель ${driver.driverID}</h1>
    <p>Имя: ${driver.driverName}</p>
    <p>Фамилия: ${driver.driverSurname}</p>
    <p>Номер телефона: ${driver.phoneNumber}</p>
    <p>Лицезия оканчивается:
        <fmt:formatDate value="${driver.licenceExpire}"
                        pattern="yyyy-MM-dd"/></p>
    <p>Рейсы:</p>
    <c:forEach items="${driver.journeys}" var="journey"><p><a
            href="/journey?id=${journey.journeyID}">${journey.fromPlace}
            ${journey.destination}</a></p></c:forEach>

    <button class="btn"><a
            href="/driver/edit?id=${driver.driverID}">Изменить...</a>
    </button>
    <button
            class="btn"><a href="/driver/delete?id=${driver.driverID}">Удалить
    </a></button>
</div>
</body>
</html>
