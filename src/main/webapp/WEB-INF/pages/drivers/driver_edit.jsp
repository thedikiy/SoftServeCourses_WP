<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <title>Edit driver</title>
</head>
<body>
<h4></h4><a href="/driver_list">Назад</a></h4>
<form action="/driver/edit" method="post">
    <input type="hidden" name="driverID" value="${driver.driverID}">
    <input name="driverName" type="text" value="${driver.driverName}">Имя
    водителя*<Br>
    <input name="driverSurname" type="text" value="${driver.driverSurname}">
    Фамилия водителя*<Br>
    <input type="date" value="${driver.licenceExpire}">Лицензия истекает<Br>
    <input  name="phoneNumber" type="text" value="${driver.phoneNumber}">Номер
    телефона<Br>
    <input type="submit" value="submit">
</form>
</body>
</html>
