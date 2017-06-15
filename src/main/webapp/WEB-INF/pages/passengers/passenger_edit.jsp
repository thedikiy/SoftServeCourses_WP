<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <title>Edit passenger</title>
</head>
<body>
<button class="btn"><a href="/passenger_list">Назад</a></button>
<form action="/passenger/edit" method="post">
    <input type="hidden" name="passengerID" value="${passenger.passengerID}">
    <input name="passengerName" type="text" value="${passenger.passengerName}">Имя*
    <Br>
    <input name="passengerSurname" type="text" value="${passenger.passengerSurname}">
    Фамилия* <Br>
    <input type="submit" value="submit">
</form>
</body>
</html>
