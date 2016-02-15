<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:generic title="Position: ${position.position}">
  <h1>Position details for ${position.position} </h1>
  <table class="table table-hover">
    <tbody>
      <tr><td>Position:</td><td>${position.position}</td></tr>
      <tr><td>Company:</td><td>${position.company}</td></tr>
      <tr><td>Point of contact:</td><td>${position.pointOfContact}</td></tr>
      <tr><td>Agency:</td><td>${position.agency}</td></tr>
      <tr><td>Notes:</td><td>${position.notes}</td></tr>
      <tr><td>Specs:</td><td>${position.specificationsLink}</td></tr>
    </tbody>
  </table>
  <c:url var="editUrl" value="/positions/${position.id}/edit" />
  <c:url var="showAllUrl" value="/positions/" />
  <a href="${showAllUrl}"> &lt; Show All</a> |
  <a href="${editUrl}">Edit</a>

  </t:generic>
