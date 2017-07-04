<%@include file="/resources/static/head.jsp" %>
<html>
<head>
    <title>Edit driver</title>
</head>
<body>
<%@include file="/resources/static/nav.jsp" %>
<div class="content">
    <div class="col-md-4">
        <form action="/driver/edit" method="post">
            <input type="hidden" name="driverID" value="${driver.driverID}">
            <label for="driverName">Имя водителя</label>
            <input id="driverName" class="form-control" name="driverName" type="text" value="${driver.driverName}"><Br>
            <label for="driverSurname">Фамилия водителя</label>
            <input id = "driverSurname" class="form-control" name="driverSurname" type="text"
                   value="${driver.driverSurname}"><Br>
            <label for="licenceExpire">Лицензия истекает</label>
            <input id="licenceExpire" class="form-control" type="date" name="licenceExpire"
                   value=${driver.licenceExpire}><Br>
            <label for="phoneNumber">Номер телефона</label>
            <input id="phoneNumber" class="form-control" name="phoneNumber" type="text" value="${driver.phoneNumber}"><Br>
            <%@include file="/resources/static/check_errors.jsp"%>
            <input class="button submit_button" type="submit" value="Сохранить">
        </form>
    </div>
</div>
</body>
</html>
