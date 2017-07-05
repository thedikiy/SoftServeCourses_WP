<%@include file="/resources/static/head.jsp" %>
<html>
<head>
    <title>Edit passenger</title>
</head>
<body>
<%@include file="/resources/static/nav.jsp" %>
<div class="content">
    <div class="col-md-4">
        <form action="${action}" method="post">
        <%@include file="/resources/static/passenger_form.jsp"%>
        </form>
    </div>
</div>
</body>
</html>
