<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="date" class="java.util.Date" />
<c:if test="${empty users}">
	<div class="notification warning">
		No users
	</div>
</c:if>
<c:if test="${not empty users}">
		<ul data-role="listview" data-inset="true" data-filter="true" data-filter-placeholder="Search..." data-autodividers="true">
	<c:forEach var="user" items="${users}">
		<li>
			<a href="<%= request.getContextPath() %>/inviteUsers/${community.id}/${user.id}">
				${user.lname}, ${user.fname}
			</a>
		</li>
	</c:forEach>
	</ul>
</c:if>