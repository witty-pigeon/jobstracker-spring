<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Generic Layout" pageEncoding="UTF-8"%>

<%@attribute name="title" required="true"%>
<%@attribute name="body_area" fragment="true"%>
<%@attribute name="nav" fragment="true"%>
<%@attribute name="useAngular"%>

<!DOCTYPE html>
<html ng-app="JobsTrackerSpring">
  <head>
    <title>${title}</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="_context" content="<c:url value="/"/>" >
    <link type="text/css"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>
    <c:url var="stylesheetUrl" value="/resources/style.css" />
    <link type="text/css" href="${stylesheetUrl}" rel="stylesheet"/>
  </head>

  <body>
    <jsp:include page="/WEB-INF/fragments/navbar.jsp">
      <jsp:param name="useAngular" value="${useAngular}"/>
    </jsp:include>
    
    
    <!--                     main content                   -->
    <div class="container">
      <jsp:doBody />
    </div>
    
    
    
    <!--                        scripts              -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular.min.js">
      </script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular-route.min.js">
      </script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular-resource.min.js">
      </script>
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/1.1.2/ui-bootstrap.min.js">
    </script>
    <c:url var="appScript" value="/resources/js/main.js" />
    <script src="${appScript}"></script>
    <%@ include file="/WEB-INF/fragments/footer.jsp" %>
  </body>
</html>