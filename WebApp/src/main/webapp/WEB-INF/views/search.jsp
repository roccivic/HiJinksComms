<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="date" class="java.util.Date" />

<c:choose>
	<c:when test="${not empty communities}">
		<ul data-role="listview" data-inset="true" data-filter="true" data-filter-placeholder="Search...">
		<c:forEach var="community" items="${communities}">
			<li>
				<a href="<%= request.getContextPath() %>/communities/${community.id}">
					${community.name}
				</a>
			</li>
		</c:forEach>
		</ul>
	</c:when>
	<c:otherwise>
		No communities
	</c:otherwise>
</c:choose>