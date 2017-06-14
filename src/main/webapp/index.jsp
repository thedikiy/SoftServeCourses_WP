<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <title>Bus Manager</title>
</head>
<body>
<div id="title">
<h1 align="center"><a href="/">Bus Manager</a></h1>
</div>
<div class="row">
    <div class="col-md-4">
       <h3 align="center"><a href="/buslist">Список автобусов</a></h3>
    </div>
    <div class="col-md-4">
        <h3 align="center"><a href="/driver_list">Список водителей</a></h3>
    </div>
    <div class="col-md-4">
        <h3 align="center"><a href="/journey_list">Список рейсов</a></h3>
    </div>
</div>
</body>
</html>
