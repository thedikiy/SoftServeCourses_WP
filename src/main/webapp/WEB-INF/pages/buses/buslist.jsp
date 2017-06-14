<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Buses</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
</head>
<body>
<h1 align="center">Список Автобусов</h1>
<h4><a href="/">Назад</a></h4>
<div class="row">
<table>
    <thead>
    <tr>
        <th class="col-md-1">#</th>
        <th class="col-md-4">Модель</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${buses}" var="bus" varStatus="count">
        <tr>
            <th class="col-md-1">${count.index + 1}</th>
            <td class="col-md-4">
                <c:url value="/bus?id=${bus.busID}" var="busUrl"/>
                <a href=${busUrl}>${bus.busModel}</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<h4><a href="/bus/edit">Добавить...</a></h4>
</body>
</html>
