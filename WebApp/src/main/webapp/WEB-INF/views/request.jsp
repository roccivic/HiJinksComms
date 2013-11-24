<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="date" class="java.util.Date" />
<c:if test="${empty request}">
	<div class="notification error">
		Error: Request not found
	</div>
</c:if>
<c:if test="${not empty request}">
	<dl>
		<dt>From</dt>
		<dd>
			<a href="<%= request.getContextPath() %>/users/${request.user.id}">
				${request.user.fname} ${request.user.lname}
			</a>
		</dd>
		<dt>To join community</dt>
		<dd>
			<a href="<%= request.getContextPath() %>/communities/${request.community.id}">
				${request.community.name}
			</a>
		</dd>
		<dt>Requested</dt>
		<dd>${request.getDateFormatted()}</dd>
	</dl>
	<div class="ui-grid-a">
	    <div class="ui-block-a">
	        <a href="<%= request.getContextPath() %>/acceptRequest/${request.id}" data-role="button" data-theme="b">Accept</a>
	    </div>
	    <div class="ui-block-b">
	        <a href="<%= request.getContextPath() %>/declineRequest/${request.id}" data-role="button">Reject</a>
	    </div>
	</div>
</c:if>

