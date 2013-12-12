<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:useBean id="date" class="java.util.Date" />
 <form:form method="POST" action="createCommunity" modelAttribute="Community">
 <form:errors path="name" class="notification error" style="display:block"></form:errors>
 <form:errors path="description" class="notification error" style="display:block"></form:errors>
 <form:errors path="keywords" class="notification error" style="display:block"></form:errors>
 <form:errors path="keywordsEnabled" class="notification error" style="display:block"></form:errors>
 <form:errors path="visibilityLevel" class="notification error" style="display:block"></form:errors>
 <form:errors path="accessLevel" class="notification error" style="display:block"></form:errors>
 <div data-role="fieldcontain">
    <form:label path="name">Name:</form:label>
    <form:input path="name" />
  </div>
  <div data-role="fieldcontain">
    <form:label path="description">Description:</form:label>
    <form:input path="description" />
  </div>
  <div data-role="fieldcontain">
    <form:label path="keywords">Keywords:</form:label>
    <form:input  path="keywords" />
  </div>
  <div data-role="fieldcontain">
  <fieldset data-role="controlgroup" data-type="horizontal">
  <legend>Keywords Enabled:</legend>
  <form:radiobutton path="keywordsEnabled" value="0" label="No" />
  <form:radiobutton path="keywordsEnabled" value="1" label="Yes"/>
  </fieldset>
  </div>
  <div data-role="fieldcontain">
  <fieldset data-role="controlgroup" data-type="horizontal">
  <legend>Visibility Level:</legend>
  <form:radiobutton path="visibilityLevel" value="private" label="Private"/>
  <form:radiobutton path="visibilityLevel" value="open" label="Open"/>
  </fieldset>
  </div>
  <div data-role="fieldcontain">
  <fieldset data-role="controlgroup" data-type="horizontal">
  <legend>Access Level:</legend>
  <form:radiobutton path="accessLevel" value="restricted" label="Restricted"/>
  <form:radiobutton path="accessLevel" value="unrestricted" label="Unrestricted"/>
  </fieldset>
  </div>
  <input data-theme="b" type="submit" value="Ok" />
  </form:form>