<%@include file="../resources/head.jsp"%>
<html>
<head>
    <title>Edit passenger</title>
</head>
<body>
<%@include file="../resources/nav.jsp"%>
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
