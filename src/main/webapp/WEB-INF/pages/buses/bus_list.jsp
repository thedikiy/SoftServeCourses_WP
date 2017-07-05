<%@include file="/resources/static/head.jsp" %>
<html>
<head>
    <title>Buses</title>
</head>
<body>
<%@include file="/resources/static/nav.jsp" %>
<div class="content">
    <h1>Список Автобусов</h1>
    <form action="/bus/list" method="post">
        <input name="busModel" placeholder="Модель автобуса" type="text"/>
        <input name="registrationNumber" placeholder="Регистрационный номер" type="text"/>
        <input type="submit" value = "Найти"/>
    </form>
    <div class="col-md-6">
        <div class="row">
            <table class="table table-striped">
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
        <a class="button submit_button" href="/bus/edit">Добавить...</a>
    </div>
</div>
</body>
</html>
