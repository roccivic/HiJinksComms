<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="date" class="java.util.Date" />
 <c:if test="${not empty error}">
 <div class="notification error">
		${error}
	</div>
</c:if>
 <form data-ajax="false" method="POST" action="<%= request.getContextPath() %>/creatingCommunity">
 <div data-role="fieldcontain">
    <label for="name">*Name:</label>
    <input type="text" name="name" id="name" value="${name}" />
  </div>
  <div data-role="fieldcontain">
    <label for="description">*Description:</label>
    <input type="text" name="description" id="description" value="${description}" />
  </div>
  <div data-role="fieldcontain">
    <label for="keywords">Keywords:</label>
    <input type="text" name="keywords" id="keywords" value="${keywords}" />
  </div>
  <div data-role="fieldcontain">
  <fieldset data-role="controlgroup" data-type="horizontal">
  <legend>Keywords Enabled:</legend>
  <label for="keywordsEnabled1">Yes</label>
  <input id="keywordsEnabled1" type="radio" name="keywordsEnabled" value="1" checked="checked" />
  <label for="keywordsEnabled0">No</label>
  <input id="keywordsEnabled0" type="radio" name="keywordsEnabled" value="0" />
  </fieldset>
  </div>
  <div data-role="fieldcontain">
  <fieldset data-role="controlgroup" data-type="horizontal">
  <legend>Visibility Level:</legend>
  <label for="visibilityOpen">Open</label>
  <input id="visibilityOpen" type="radio" name="visibilityLevel" value="open" checked="checked" />
  <label for="visibilityPrivate">Private</label>
  <input id="visibilityPrivate" type="radio" name="visibilityLevel" value="private" />
  </fieldset>
  </div>
  <div data-role="fieldcontain">
  <fieldset data-role="controlgroup" data-type="horizontal">
  <legend>Access Level:</legend>
  <label for="accessLevelRestricted">Restricted</label>
  <input id="accessLevelRestricted" type="radio" name="accessLevel" value="restricted" checked="checked" />
  <label for="accessLevelUnrestricted">Unrestricted</label>
  <input id="accessLevelUnrestricted" type="radio" name="accessLevel" value="unrestricted" />
  </fieldset>
  </div>
  <input data-theme="b" type="submit" value="Ok" />
  </form>