<%@include file="../resources/head.jsp"%>
<html>
<head>
    <title>Passengers</title>
</head>
<body>
<%@include file="../resources/nav.jsp"%>
<h1>Список Пассажиров</h1>
<button class="btn"><a href="/">Назад</a></button>
<div class="row">
    <table>
        <thead>
        <tr>
            <th class="col-md-1">#</th>
            <th class="col-md-4">Имя</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${passengers}" var="passenger" varStatus="count">
            <tr>
                <th class="col-md-1">${count.index + 1}</th>
                <td class="col-md-4">
                    <c:url value="/passenger?id=${passenger.passengerID}" var="passengerUrl"/>
                    <a href=${passengerUrl}>${passenger.passengerName}</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<button class="btn"><a href="/passenger/edit">Добавить...</a></button>
</body>
</html>
