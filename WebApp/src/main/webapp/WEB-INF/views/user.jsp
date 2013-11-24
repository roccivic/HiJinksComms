<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="date" class="java.util.Date" />
<c:if test="${empty user}">
	<div class="notification error">
		Error: User not found
	</div>
</c:if>
<c:if test="${not empty user}">
	<dl>
		<dt>Name</dt>
		<dd>${user.fname} ${user.lname}</dd>
		<dt>Email</dt>
		<dd>${user.email}</dd>
		<dt>Type</dt>
		<dd>${user.type}</dd>
	</dl>
</c:if>

