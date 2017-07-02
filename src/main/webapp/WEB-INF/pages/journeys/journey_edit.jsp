<%@include file="/resources/static/head.jsp" %>
<html>
<head>
    <title>Edit journey</title>
</head>
<body>
<%@include file="/resources/static/nav.jsp" %>
<div class="content">
    <div class="col-md-4">
        <form action="/journey/edit" method="post">
            <br/>
            <input type="hidden" name="journeyID" value="${journey.journeyID}">
            <label for="fromPlace">Место отправления</label>
            <input id="fromPlace" class="form-control" name="fromPlace" type="text" value="${journey.fromPlace}"><br/>
            <label for="destination">Место прибытия</label>
            <input id ="destination" class="form-control" name="destination" type="text" value="${journey.destination}"><Br>
            <label for="leavingDate">Время отправления</label>
            <input id="leavingDate" class="form-control" type="date" name="leavingDate"
                   value=${journey.leavingDate}><Br/>
            <label for="arrivingDate">Время прибытия</label>
            <input id="arrivingDate" class="form-control" type="date" name="arrivingDate" value=${journey.arrivingDate}><Br/>
            <label for="driver">Водитель</label>
            <select id="driver" class="form-control" name="driverID" size=1>
                <c:forEach items="${drivers}" var="driver">
                    <option name="driverID"
                            value="${driver.driverID}">${driver.driverName}
                            ${driver.driverSurname}</option>
                </c:forEach>
            </select><br/>
            <label for="bus">Автобус</label>
            <select id="bus" class="form-control" name="busID" size=1>
                <c:forEach items="${buses}" var="bus">
                    <option name="bus"
                            value="${bus.busID}">${bus.busModel}</option>
                </c:forEach>
            </select><br/>
            <input class="submit_button" type="submit" name="action" value="Сохранить">
        </form>
    </div>
</div>
</body>
</html>
