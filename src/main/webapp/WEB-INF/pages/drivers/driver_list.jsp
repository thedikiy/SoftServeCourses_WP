<%@include file="../resources/head.jsp"%>
<html>
<head>
    <title>Drivers</title>
</head>
<body>
<%@include file="../resources/nav.jsp"%>
<h1>Список водителей</h1>
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
    <c:forEach items="${driverList}" var="driver" varStatus="count">
        <tr>
            <th class="col-md-1">${count.index + 1}</th>
            <td class="col-md-4">
                <c:url value="/driver?id=${driver.driverID}" var="driverUrl"/>
                <a href=${driverUrl}>${driver.driverName} ${driver.driverSurname}</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<button class="btn"><a href="/driver/edit">Добавить...</a></button>
</body>
</html>
