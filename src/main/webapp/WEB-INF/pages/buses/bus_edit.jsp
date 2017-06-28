<%@include file="../resources/head.jsp" %>
<html>
<head>
    <title>Edit bus</title>
</head>
<body>
<%@include file="../resources/nav.jsp"%>
<button class="btn"><a href="/buslist">Назад</a></button>
<form action="/bus/edit" method="post">
    <input type="hidden" name="busID" value="${bus.busID}">
    <div class="form_class"><input name="busModel" type="text"
           value="${bus.busModel}">Модель
    автобуса*<Br></div>
    <input class="form_class" name="registrationNumber" type="text"
            value="${bus.registrationNumber}">
    Регистрационный номер*<Br>
    <input class="form_class" name="nextTI" type="date"
           value=${bus.nextTI}>Дата следующего ТО<Br>
    <input class="form_class" name="lastTI" type="date"
           value=${bus.lastTI}>Дата
    предыдущего ТО<Br>
    <input class="form_class" type="submit" value="submit">
</form>
</body>
</html>
