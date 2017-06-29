<%@include file="/resources/head.jsp" %>
<html>
<head>
    <title>Edit driver</title>
</head>
<body>
<%@include file="/resources/nav.jsp" %>
<div class="content">
    <form action="/driver/edit" method="post">
        <input type="hidden" name="driverID" value="${driver.driverID}">
        <input name="driverName" type="text" value="${driver.driverName}">Имя
        водителя*<Br>
        <input name="driverSurname" type="text" value="${driver.driverSurname}">
        Фамилия водителя*<Br>
        <input type="date" name="licenceExpire" value=${driver.licenceExpire}>Лицензия
        истекает<Br>
        <input name="phoneNumber" type="text" value="${driver.phoneNumber}">Номер
        телефона<Br>
        <input type="submit" value="submit">
    </form>
</div>
</body>
</html>
