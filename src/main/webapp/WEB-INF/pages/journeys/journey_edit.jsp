<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <title>Edit journey</title>
</head>
<body>
<h4><a href="/journeylist">Назад</a></h4>
<form action="/journey/edit" method="post">
    <input type="hidden" name="journeyID" value="${journey.journeyID}">
    <input name="fromPlace" type="text" value="${journey.fromPlace}">Место
    отправления*<Br>
    <input name="destination" type="text" value="${journey.destination}">
    Место прибытия * <Br>
    <select name="driverID" size=1 >
        <c:forEach items="${drivers}" var="driver">
            <option name="driverID" value="${driver.driverID}">${driver.driverName}
                    ${driver.driverSurname}</option>
        </c:forEach>
    </select>Водитель<br/>
    <select name="busID" size=1 >
        <c:forEach items="${buses}" var="bus">
            <option name="bus" value="${bus.busID}">${bus.busModel}</option>
        </c:forEach>
    </select>Автобус<br/>
    <input type="submit" value="submit">
</form>
</body>
</html>
