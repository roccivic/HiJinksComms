<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <c:if test="${not empty message}">
 <div class="notification">
		${message}
	</div>
</c:if>
<p>
	<img src="<%= request.getContextPath() %>/resources/images/home.jpg" alt="home" />
</p>