<!DOCTYPE html>
<%@tag description="Generic Layout" pageEncoding="UTF-8"%>

<%@attribute name="title" required="true"%>
<%@attribute name="body_area" fragment="true"%>
<%@attribute name="nav" fragment="true"%>
<html>
  <head>
    <title>${title}</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>
  </head>

  <body>
    <jsp:include page="/WEB-INF/fragments/navbar.jsp"/>
    <div class="container">
      <jsp:doBody />
    </div>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  </body>
</html>