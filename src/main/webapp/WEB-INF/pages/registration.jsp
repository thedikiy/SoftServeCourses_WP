<%@include file="/resources/static/head.jsp" %>
<html>
<body>
<%@include file="/resources/static/nav.jsp" %>
<div class="content">
    <h2>Заполните регистрационную форму</h2>
    <div class="col-md-4">
        <form action="/registration" method="post">
            <sec:authorize access="hasAuthority('ADMIN')">
            <c:forEach items="${roles}" var="role">
                <div class="col-md-4"><label class=".radio-inline">
                    <input name="role" class="form-control" type="radio" value="${role}"
                           <c:if test="${role.toString().equals('PASSENGER')}">checked</c:if>>
                        ${role.toString()}</label>
                </div>
            </c:forEach>
            </sec:authorize>
            <label for="username">Имя пользователя</label>
            <input id="username" class="form-control" type="text"
                   name="username"/><Br/>
            <label for="password">Пароль</label>
            <input id="password" class="form-control" type="password"
                   name="password"/><Br/>
            <label for="matchPassword">Повторите пароль</label>
            <input id="matchPassword" class="form-control" type="Password"
                   name="matchingPassword"/><br/>
            <c:if test="${not empty errors}">
                <c:forEach items="${errors}" var="error">
                    <p class="error">${error.defaultMessage}</p>
                </c:forEach>
            </c:if>
            <input class="submit_button" type="submit" value="Подтвердить"/>
        </form>
    </div>
</div>
</body>
</html>
