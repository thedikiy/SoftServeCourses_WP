<%@include file="/resources/static/head.jsp" %>
<html>
<head>
    <title>Passengers</title>
</head>
<body>
<%@include file="/resources/static/nav.jsp" %>
<div class="content"><h1>Список Пассажиров</h1>
    <form action="/passenger/list" method="post">
        <input name="passengerName" placeholder="Имя" type="text"/>
        <input name="passengerSurname" placeholder="Фамилия" type="text"/>
        <input type="submit" value = "Найти"/>
    </form>
    <div class="col-md-6">
        <div class="row">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th class="col-md-1">#</th>
                    <th class="col-md-4">Имя</th>
                    <th class="col-md-4">Фамилия</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${passengers}" var="passenger"
                           varStatus="count">
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
        <a class="button submit_button" href="/passenger/edit">Добавить...</a>
    </div>
</div>
</body>
</html>
