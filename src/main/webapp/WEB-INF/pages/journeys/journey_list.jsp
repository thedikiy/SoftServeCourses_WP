<%@include file="/resources/static/head.jsp" %>
<html>
<head>
    <title>Journeys</title>
</head>
<body>
<%@include file="/resources/static/nav.jsp" %>
<div class="content">
    <h1>Список рейсов</h1>
    <div class="col-md-6">
        <div class="row">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th class="col-md-1">#</th>
                    <th class="col-md-4">Место отправленя</th>
                    <th class="col-md-4">Место прибытия</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${journeyList}" var="journey"
                           varStatus="count">
                    <tr>
                        <th class="col-md-1">${count.index + 1}</th>
                        <td class="col-md-4">
                            <p>${journey.fromPlace}</p>
                        </td>
                        <td class="col-md-4">
                            <p>${journey.destination}</p>
                        </td>
                        <td class="col-md-4"><c:url
                                value="/journey?id=${journey.journeyID}"
                                var="journeyUrl"/>
                            <a href=${journeyUrl}>Подробнее...</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <sec:authorize access="hasAnyAuthority('ADMIN','MANAGER')">
            <a class="button submit_button" href="/journey/edit">Добавить...</a>
        </sec:authorize>
    </div>
</div>
</body>
</html>
