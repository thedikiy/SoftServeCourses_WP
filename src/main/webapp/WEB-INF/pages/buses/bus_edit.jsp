<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <title>Edit bus</title>
</head>
<body>
<h4><a href="/buslist">Назад</a></h4>
<form action="/bus/edit" method="post">
    <input type="hidden" name="busID" value="${bus.busID}">
    <div class="form_class"><input name="busModel" type="text"
           value="${bus.busModel}">Модель
    автобуса*<Br></div>
    <input class="form_class" name="registrationNumber" type="text"
            value="${bus.registrationNumber}">
    Регистрационный номер*<Br>
    <input class="form_class" type="date" value="${bus.nextTI}">Дата
    следующего ТО<Br>
    <input class="form_class" type="date" value="${bus.lastTI}">Дата предыдущего ТО<Br>
    <input class="form_class" type="submit" value="submit">
</form>
</body>
</html>
