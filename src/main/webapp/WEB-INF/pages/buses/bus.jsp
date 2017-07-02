<%@include file="/resources/static/head.jsp" %>
<html>
<head>
    <title>BUS ${bus.busID}</title>
</head>
<body>
<%@include file="/resources/static/nav.jsp"%>
<div class="content"><h1 class="bus">Автобус №${bus.busID}</h1>
<p>Модель: ${bus.busModel}</p>
<p>Регистрационный номер: ${bus.registrationNumber}</p>
<p>Дата последнего ТО:
    <fmt:formatDate value="${bus.lastTI}" pattern="yyyy-MM-dd"/> </p>
<p>Дата следующего ТО: <fmt:formatDate value="${bus.nextTI}" pattern="yyyy-MM-dd"/></p>
<p>Рейсы:</p>
<c:forEach items="${bus.journeys}" var="journey"><p><a
        href="/journey?id=${journey.journeyID}">${journey.fromPlace}
        ${journey.destination}</a></p></c:forEach>
<sec:authorize access="hasAnyAuthority('ADMIN','MANAGER')"><button class="btn">
    <a href="/bus/edit?id=${bus.busID}">Изменить...</a></button>
<button
        class="btn"><a href="/bus/delete?id=${bus.busID}">Удалить
</a></button></sec:authorize></div>
</body>
</html>
