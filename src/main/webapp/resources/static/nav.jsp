<body>

<div class="row">
    <h1 class="col-md-10"><a id="logo" href="/">Bus Manager</a></h1>
    <sec:authorize access="isAnonymous()">
        <h4><a href="/login">Вход</a></h4>
    </sec:authorize>
    <sec:authorize access="isAnonymous() or hasAuthority('ADMIN') ">
        <h4><a href="/registration">Регистрация</a></h4>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()"><h4><a href="/logout">Выход</a>
    </h4></sec:authorize>
</div>
<div class="nav_container">
    <div class="row">
        <sec:authorize access="hasAnyAuthority('ADMIN','MANAGER')">
            <div class="col-md-3">
                <h3 align="center"><a class="nav_link" href="/bus_list">Список
                    автобусов</a></h3>
            </div>
            <div class="col-md-3">
                <h3 align="center"><a class="nav_link" href="/driver_list">Список
                    водителей</a></h3>
            </div>
        </sec:authorize>
        <div class="col-md-3">
            <h3 align="center"><a class="nav_link" href="/journey_list">Список
                рейсов</a></h3>
        </div>
        <sec:authorize access="isAuthenticated()">
            <div class="col-md-3">
                <h3 align="center"><a class="nav_link" href="/passenger_list">Список
                    пассажиров</a></h3>
            </div>
        </sec:authorize>
    </div>
</div>
</body>
