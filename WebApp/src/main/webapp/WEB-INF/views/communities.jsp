<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="date" class="java.util.Date" />
<c:if test="${ empty communities}">
	<div class="notification warning">
		No communities
	</div>
</c:if>
<c:if test="${not empty communities}">
	<ul data-role="listview" data-inset="true" data-autodividers="true">
	<c:forEach var="community" items="${communities}">
		<li>
			<a href="<%= request.getContextPath() %>/communities/${community.id}">
				${community.name}
			</a>
		</li>
	</c:forEach>
	</ul>
</c:if>