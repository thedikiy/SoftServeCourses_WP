<%@include file="/resources/static/head.jsp" %>
<html>
<head>
    <title>Drivers</title>
</head>
<body>
<%@include file="/resources/static/nav.jsp" %>
<div class="content">
    <h1>Список водителей</h1>
    <form action="/driver/list" method="post">
        <input name="driverName" placeholder="Имя" type="text"/>
        <input name="driverSurname" placeholder="Фамилия" type="text"/>
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
                <c:forEach items="${drivers}" var="driver" varStatus="count">
                    <tr>
                        <th class="col-md-1">${count.index + 1}</th>
                        <c:url value="/driver?id=${driver.driverID}"
                               var="driverUrl"/>
                        <td class="col-md-4">
                            <a href=${driverUrl}>${driver.driverName}</a>
                        </td>
                        <td class="col-md-4">
                            <a href=${driverUrl}>${driver.driverSurname}</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <a class="button submit_button" href="/driver/edit">Добавить...</a>
    </div>
</div>
</body>
</html>
