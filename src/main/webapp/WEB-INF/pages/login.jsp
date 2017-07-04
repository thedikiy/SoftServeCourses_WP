<%@include file="/resources/static/head.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>
<%@include file="/resources/static/nav.jsp"%>
<div class="content"><form action="/login" method='POST'>
<h1>Вход в систему</h1>
    <c:if test="${param.error.equals('true')}"><p class="error">
        <fmt:message key="login.validation.error.mismatch"/></p></c:if>
    <table>
        <tr>
            <td>Имя пользователя: </td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td><input class="button submit_button" name="submit" type="submit" value="submit" /></td>
        </tr>
    </table>
</form>
</div></body>
</html>
