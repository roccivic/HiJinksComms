<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="date" class="java.util.Date" />
<c:if test="${empty requests}">
	No requests
</c:if>
<c:if test="${not empty requests}">
	<ul data-role="listview" data-inset="true">
	<c:forEach var="request" items="${requests}">
		<li>
			<a href="<%= request.getContextPath() %>/requests/${request.id}">
				<h2>Community: ${request.community.name}</h2>
				<p>User: ${request.user.fname} ${request.user.lname}</p>
				<p class="ui-li-aside">
					${request.getDateFormatted()}
				</p>
			</a>
		</li>
	</c:forEach>
	</ul>
</c:if>