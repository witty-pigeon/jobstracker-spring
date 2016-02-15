<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:generic title="New Position">
  <h1>Insert a position</h1>

  <c:url var="addUrl" value="/positions/"/>
  <form:form commandName="position" cssClass="form" action="${addUrl}" >
    <%@include file="form.jspf" %>
    <input type="Submit" value="Create">
  </form:form>
</t:generic>
