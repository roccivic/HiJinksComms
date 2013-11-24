<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="date" class="java.util.Date" />
<c:if test="${ empty community}">
	<p>
		Error: Community not found
	</p>
</c:if>
<c:if test="${ not empty community}">
	<dl>
		<dt>Name</dt>
		<dd>${community.name}</dd>
		<dt>Owner</dt>
		<dd>
			<a href="<%= request.getContextPath() %>/users/${community.owner.id}">
				${community.owner.fname} ${community.owner.lname}
			</a>
		</dd>
		<dt>Description</dt>
		<dd>${community.description}</dd>
		<c:if test="${community.keywordsEnabled}">
			<dt>Keywords</dt>
			<dd>${community.keywords}</dd>
		</c:if>
		<dt>Visibility Level</dt>
		<dd>${community.visibilityLevel}</dd>
		<dt>Access Level</dt>
		<dd>${community.accessLevel}</dd>
		<dt>Created</dt>
		<dd>${community.getCreatedFormatted()}</dd>
	</dl>
	
	<ul data-role="listview" data-inset="true">
		<li data-role="list-divider">Community Members</li>
		<c:if test="${empty users}">
			<li>No users</li>
		</c:if>
		<c:if test="${not empty users}">
			<c:forEach var="user" items="${users}">
				<li>
					<a href="<%= request.getContextPath() %>/users/${user.id}">
						${user.fname} ${user.lname}
					</a>
				</li>
			</c:forEach>
		</c:if>
	</ul>
</c:if>