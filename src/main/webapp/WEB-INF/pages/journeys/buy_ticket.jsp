<%@include file="/resources/static/head.jsp" %>
<html>
<head>
    <title>Buy ticket</title>
</head>
<body>
<%@include file="/resources/static/nav.jsp" %>
<div class="content">
    <div class="col-md-4">
        <form action="/journey/buy_ticket" method="post">
            <input type="hidden" name="journeyID" value="${journeyID}"/>
            <label for="passenger">Автобус</label>
            <select id="passenger" class="form-control" name="passengerID"
                    size=1>
                <option value="-1">Выберите Пассажира</option>
                <c:forEach items="${passengers}" var="passenger">
                    <option value="${passenger.passengerID}">
                            ${passenger.passengerSurname} ${passenger.passengerName}</option>
                </c:forEach>
            </select><br/>
            <input class="button submit_button" type="submit" name="submit"
                   value="Выбрать">
        </form>
    </div>
    <div class="col-md-4"><%@include file="/resources/static/passenger_form.jsp"%></div>
</div>
</body>
</html>
