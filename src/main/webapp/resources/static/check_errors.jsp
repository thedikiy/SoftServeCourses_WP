<body>
<c:if test="${not empty errors}">
    <c:forEach items="${errors}" var="error">
        <p class="error">${error.defaultMessage}</p>
    </c:forEach>
</c:if>
</body>

