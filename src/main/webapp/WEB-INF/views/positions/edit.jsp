<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:generic title="Edit position ${position.position}">
  <h1>Edit position: ${position.position} </h1>

  <c:url var="editUrl" value="/positions/${position.id}"/>
  <form:form commandName="position" cssClass="form" action="${editUrl}" >
    <form:hidden path="id" />
    <%@include file="form.jspf" %>
    <div class="form-group">
      <form:label path="closed">Closed?</form:label>
      <form:checkbox path="closed" />
    </div>
      <input type="Submit" value="Update">
      <input type="reset" value="reset">
  </form:form>
</t:generic>
