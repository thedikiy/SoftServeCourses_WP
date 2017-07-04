
<c:if test="${not empty errors}">
    <c:forEach items="${errors}" var="error">
        <p class="error_message">${error.defaultMessage}</p>
    </c:forEach>
</c:if>

