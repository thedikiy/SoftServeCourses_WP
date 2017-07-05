<form action="${action}" method="post">
    <input type="hidden" name="passengerID"
           value="${passenger.passengerID}">
    <label for="passengerName">Имя</label>
    <input id="passengerName" name="passengerName" type="text"
           class="form-control" value="${passenger.passengerName}">
    <Br>
    <label for="passengerSurname">Фамилия</label>
    <input id ="passengerSurname" name="passengerSurname" type="text"
           class="form-control" value="${passenger.passengerSurname}"><Br>
    <label for="phoneNumber">Номер телефона</label>
    <input id="phoneNumber" class="form-control" name="phoneNumber"
           type="text" value="${passenger.phoneNumber}"><Br>
    <%@include file="/resources/static/check_errors.jsp"%>
    <input name="submit" class="button submit_button" type="submit" value="Сохранить">
</form>