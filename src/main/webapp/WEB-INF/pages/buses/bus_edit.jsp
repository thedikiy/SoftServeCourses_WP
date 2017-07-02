<%@include file="/resources/static/head.jsp" %>
<html>
<head>
    <title>Edit bus</title>
</head>
<body>
<%@include file="/resources/static/nav.jsp" %>
<div class="content">
    <div class="col-md-4">
        <form action="/bus/edit" method="post">
            <input type="hidden" name="busID" value="${bus.busID}">
            <div class="form_class">
                <label for="model">Модель автобуса</label>
                <input id="model" class="form-control" name="busModel"
                       type="text" value="${bus.busModel}">
                <Br></div>
            <label for="registrationNumber">Регистрационный номер</label>
            <input id = "registrationNumber" class="form-control" name="registrationNumber" type="text"
                   value="${bus.registrationNumber}"><Br>
            <label for="nextTI">Дата следующего ТО</label>
            <input id ="nextTI" class="form-control" name="nextTI" type="date"
                   value=${bus.nextTI}><Br>
            <label for="lastTI">Дата предыдущего ТО</label>
            <input id="lastTI" class="form-control" name="lastTI" type="date"
                   value=${bus.lastTI}><Br>
            <input class="submit_button" type="submit" value="Сохранить">
        </form>
    </div>
</div>
</body>
</html>
