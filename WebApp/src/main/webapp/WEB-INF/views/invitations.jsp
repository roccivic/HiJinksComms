<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="date" class="java.util.Date" />
<c:if test="${empty invitations}">
	No invitations
</c:if>
<c:if test="${not empty invitations}">
	<ul data-role="listview" data-inset="true">
	<c:forEach var="invitation" items="${invitations}">
		<li>
			<a href="<%= request.getContextPath() %>/invitations/${invitation.id}">
				<h2>Community: ${invitation.community.name}</h2>
				<p>Invited By: ${invitation.invitedBy.fname} ${invitation.invitedBy.lname}</p>
				<p class="ui-li-aside">
					${invitation.getDateFormatted()}
				</p>
			</a>
		</li>
	</c:forEach>
	</ul>
</c:if>