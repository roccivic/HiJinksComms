<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="date" class="java.util.Date" />

<c:if test="${ empty communities}">
	<div class="notification warning">
		No communities
	</div>
</c:if>
<c:if test="${not empty communities}">
	<ul data-role="listview" data-inset="true" data-filter="true" data-filter-placeholder="Search..." data-autodividers="true">
	<c:forEach var="community" items="${communities}">
		<c:if test="${not community.keywordsEnabled}">
			<li>
				<a href="<%= request.getContextPath() %>/communities/${community.id}">
					${community.name}
				</a>
			</li>
		</c:if>
		<c:if test="${community.keywordsEnabled}">
			<li data-filtertext="${community.name} ${community.keywords}">
				<a href="<%= request.getContextPath() %>/communities/${community.id}">
					${community.name}
				</a>
			</li>
		</c:if>
	</c:forEach>
	</ul>
</c:if>