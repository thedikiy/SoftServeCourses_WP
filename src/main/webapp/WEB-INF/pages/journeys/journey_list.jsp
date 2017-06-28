<%@include file="../resources/head.jsp"%>
<html>
<head>
    <title>Journeys</title>
</head>
<body>
<%@include file="../resources/nav.jsp"%>
<h1>Список рейсов</h1>
<button class="btn"><a href="/">Назад</a></button>
<div class="row">
<table>
    <thead>
    <tr>
        <th class="col-md-1">#</th>
        <th class="col-md-4">Место отправленя</th>
        <th class="col-md-4">Место прибытия</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${journeyList}" var="journey" varStatus="count">
        <tr>
            <th class="col-md-1">${count.index + 1}</th>
                <td class="col-md-4">
                    <p>${journey.fromPlace}</p>
                </td>
                <td class="col-md-4">
                    <p>${journey.destination}</p>
                </td>
            <td class="col-md-4"><c:url value="/journey?id=${journey.journeyID}"
                       var="journeyUrl"/>
                <a href=${journeyUrl}>Подробнее...</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<button class="btn"> <a href="/journey/edit">Добавить...</a></button>
</body>
</html>
