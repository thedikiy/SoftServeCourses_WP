<body>
<div class="row">
    <div class="col-md-6"><h1 align="center"><a href="/">Bus Manager</a></h1></div>
    <div class="col-md-2"><h3><a href="/login">Login</a></h3></div>
</div>
<div class="row">
    <sec:authorize access="hasAnyRole('ADMIN','MANAGER')"><div class="col-md-3">
        <h3 align="center"><a href="/buslist">Список автобусов</a></h3>
    </div>
    <div class="col-md-3">
        <h3 align="center"><a href="/driver_list">Список водителей</a></h3>
    </div></sec:authorize>
    <div class="col-md-3">
        <h3 align="center"><a href="/journey_list">Список рейсов</a></h3>
    </div>
    <sec:authorize access="isAuthenticated()">
    <div class="col-md-3">
        <h3 align="center"><a href="/passenger_list">Список пассажиров</a></h3>
    </div></sec:authorize>
</div>
</body>
