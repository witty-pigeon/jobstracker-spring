<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page pageEncoding="UTF-8" %>
<t:generic title="List of Positions">
  <h2>List of Positions</h2>
  <table class="table">
    <thead>
      <tr>
        <th>Position</th>
        <th>Company</th>
        <th>Agency</th>
        <th>Point of contact</th>
        <th>Salary</th>
        <th>Link</th>
        <th>Status</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="position" items="${positions}">
        <tr>
          <td>
            <c:url var="positionUrl" value="/positions/${position.id}" />
            <a href="${positionUrl}"><c:out value="${position.position}"/></a>
          </td>
          <td><c:out value="${position.company}"/></td>
          <td><c:out value="${position.agency}"/></td>
          <td><c:out value="${position.pointOfContact}"/></td>

          <td>
            <c:choose>
              <c:when test="${position.salaryMin == 0}">
                Not specified
              </c:when>
              <c:when test="${position.salaryMin < position.salaryMax}">
                <c:out value="${position.salaryMin} € - ${position.salaryMax} €"/>
              </c:when>
              <c:otherwise>
                <c:out value="${position.salaryMin}"/>
              </c:otherwise>
            </c:choose>
          </td>
          <td><a href="<c:url value="${position.specificationsLink}"/>">Link</a></td>
          <td>
            <c:choose>
              <c:when test="${position.closed}">
                <span class="label label-danger">Closed</span>
              </c:when>
              <c:otherwise>
                <span class="label label-success">Open</span>
              </c:otherwise>
            </c:choose>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </ul>
</t:generic>