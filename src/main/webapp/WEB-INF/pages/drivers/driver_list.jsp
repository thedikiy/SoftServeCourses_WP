<%@include file="/resources/head.jsp" %>
<html>
<head>
    <title>Drivers</title>
</head>
<body>
<%@include file="/resources/nav.jsp" %>
<div class="content"><h1>Список водителей</h1>
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
                        <c:url value="/driver?id=${driver.driverID}"
                               var="driverUrl"/>
                        <a href=${driverUrl}>${driver.driverName} ${driver.driverSurname}</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <button class="btn"><a href="/driver/edit">Добавить...</a></button>
</div>
</body>
</html>
