<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="date" class="java.util.Date" />
<c:if test="${empty invitation}">
	<div class="notification error">
		Error: Invitation not found
	</div>
</c:if>
<c:if test="${not empty invitation}">
	<dl>
		<dt>Invited by</dt>
		<dd>
			<a href="<%= request.getContextPath() %>/users/${invitation.invitedBy.id}">
				${invitation.invitedBy.fname} ${invitation.invitedBy.lname}
			</a>
		</dd>
		<dt>To join community</dt>
		<dd>
			<a href="<%= request.getContextPath() %>/communities/${invitation.community.id}">
				${invitation.community.name}
			</a>
		</dd>
		<dt>Requested</dt>
		<dd>${invitation.getDateFormatted()}</dd>
	</dl>
	<div class="ui-grid-a">
	    <div class="ui-block-a">
	        <a href="<%= request.getContextPath() %>/acceptInvitation/${invitation.id}" data-role="button" data-theme="b">Accept</a>
	    </div>
	    <div class="ui-block-b">
	        <a href="<%= request.getContextPath() %>/declineInvitation/${invitation.id}" data-role="button">Reject</a>
	    </div>
	</div>
</c:if>

