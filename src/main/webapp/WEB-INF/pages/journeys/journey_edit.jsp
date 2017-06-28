<%@include file="../resources/head.jsp"%><html>
<head>
    <title>Edit journey</title>
</head>
<body>
<%@include file="../resources/nav.jsp"%>
<button class="btn"><a href="/journey_list">Назад</a></button>
<form action="/journey/edit" method="post">
    <input type="hidden" name="journeyID" value="${journey.journeyID}">
    <input name="fromPlace" type="text" value="${journey.fromPlace}">Место
    отправления*<Br>
    <input name="destination" type="text" value="${journey.destination}">
    Место прибытия * <Br>
    <input type="date" name="leavingDate"
           value=${journey.leavingDate}>Время отправления<Br/>
    <input type="date" name="arrivingDate"
           value=${journey.arrivingDate}>Время прибытия<Br/>
    <select name="driverID" size=1>
        <c:forEach items="${drivers}" var="driver">
            <option name="driverID"
                    value="${driver.driverID}">${driver.driverName}
                    ${driver.driverSurname}</option>
        </c:forEach>
    </select>Водитель<br/>
    <select name="busID" size=1>
        <c:forEach items="${buses}" var="bus">
            <option name="bus" value="${bus.busID}">${bus.busModel}</option>
        </c:forEach>
    </select>Автобус<br/>
    <input type="submit" name="action" value="Submit">
</form>
</body>
</html>
