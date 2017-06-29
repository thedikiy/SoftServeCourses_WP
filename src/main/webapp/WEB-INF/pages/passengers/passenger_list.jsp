<%@include file="/resources/head.jsp" %>
<html>
<head>
    <title>Passengers</title>
</head>
<body>
<%@include file="/resources/nav.jsp" %>
<div class="content"><h1>Список Пассажиров</h1>
    <div class="row">
        <table>
            <thead>
            <tr>
                <th class="col-md-1">#</th>
                <th class="col-md-4">Имя</th>
                <th class="col-md-4">Фамилия</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${passengers}" var="passenger" varStatus="count">
                <tr>
                    <th class="col-md-1">${count.index + 1}</th>
                    <c:url value="/passenger?id=${passenger.passengerID}"
                           var="passengerUrl"/>
                    <td class="col-md-4">
                        <a href=${passengerUrl}>${passenger.passengerName}</a>
                    </td>
                    <td class="col-md-4">
                        <a href=${passengerUrl}>${passenger.passengerSurname}</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <button class="btn"><a href="/passenger/edit">Добавить...</a></button>
</div>
</body>
</html>
