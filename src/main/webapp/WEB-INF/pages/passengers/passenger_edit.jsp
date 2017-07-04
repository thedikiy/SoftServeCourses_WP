<%@include file="/resources/static/head.jsp" %>
<html>
<head>
    <title>Edit passenger</title>
</head>
<body>
<%@include file="/resources/static/nav.jsp" %>
<div class="content">
    <form action="/passenger/edit" method="post">
        <input type="hidden" name="passengerID"
               value="${passenger.passengerID}">
        <input name="passengerName" type="text"
               value="${passenger.passengerName}">Имя*
        <Br>
        <input name="passengerSurname" type="text"
               value="${passenger.passengerSurname}">
        Фамилия* <Br>
        <%@include file="/resources/static/check_errors.jsp"%>
        <input class="button submit_button" type="submit" value="submit">
    </form>
</div>
</body>
</html>
