<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
  <c:when test="${!param.useAngular}">
    <c:url var="homeUrl" value="/" />
    <c:url var="alternateHomeUrl" value="/ng/" />
    <c:set var="alternateHomeLabel" value="Angular" />
    <c:url var="positionsUrl" value="/positions/" /> 
    <c:url var="createPositionUrl" value="/positions/new" /> 
  </c:when>
  <c:otherwise>
    <c:url var="homeUrl" value="/ng/"/>
    <c:url var="alternateHomeUrl" value="/" />
    <c:set var="alternateHomeLabel" value="JSP" />
    <c:url var="positionsUrl" value="#/positions/" /> 
    <c:url var="createPositionUrl" value="#/positions/new" /> 
  </c:otherwise>
</c:choose>


<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>

      <a class="navbar-brand" href="${homeUrl}">Position tracker</a>

    </div>


    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="${positionsUrl}">Tracker</a></li>
        <li><a href="${createPositionUrl}">Create a position</a></li>
        <li><a href="${alternateHomeUrl}">${alternateHomeLabel} Version</a></li>
      </ul>

      <!--      <form class="navbar-form navbar-left" role="search">
              <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
              </div>
              <button type="submit" class="btn btn-default">Submit</button>
            </form>-->
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>