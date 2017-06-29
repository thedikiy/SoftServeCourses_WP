<%@include file="/resources/head.jsp" %>
<html>
<head>
    <title>Buses</title>
</head>
<body>
<%@include file="/resources/nav.jsp"%>
<div class="content"><h1>Список Автобусов</h1>
<div class="row">
<table>
    <thead>
    <tr>
        <th class="col-md-1">#</th>
        <th class="col-md-4">Модель</th>
        <th class="col-md-4">Регистрационный номер</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${buses}" var="bus" varStatus="count">
        <tr>
            <th class="col-md-1">${count.index + 1}</th>
            <c:url value="/bus?id=${bus.busID}" var="busUrl"/>
            <td class="col-md-4">
                <a href=${busUrl}>${bus.busModel}</a>
            </td>
            <td class="col-md-4">
                <a href=${busUrl}>${bus.registrationNumber}</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<button class="btn"><a href="/bus/edit">Добавить...</a></button>
</div></body>
</html>
