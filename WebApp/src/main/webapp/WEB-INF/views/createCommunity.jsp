<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:useBean id="date" class="java.util.Date" />
 <form:form method="POST" action="createCommunity" modelAttribute="Community">
 <div data-role="fieldcontain">
    <form:label path="name">Name:</form:label>
    <form:input path="name" />
     <form:errors path="name" style="color:red"></form:errors>
  </div>
  <div data-role="fieldcontain">
    <form:label path="description">Description:</form:label>
    <form:input path="description" />
    <form:errors path="description" style="color:red"></form:errors>
  </div>
  <div data-role="fieldcontain">
    <form:label path="keywords">Keywords:</form:label>
    <form:input  path="keywords" />
    <form:errors path="keywords" style="color:red"></form:errors>
  </div>
  <div data-role="fieldcontain">
  <fieldset data-role="controlgroup" data-type="horizontal">
  <legend>Keywords Enabled:</legend>
  <form:radiobutton path="keywordsEnabled" value="0" label="No" />
  <form:radiobutton path="keywordsEnabled" value="1" label="Yes"/>
  </fieldset>
  <form:errors path="keywordsEnabled" style="color:red"></form:errors>
  </div>
  <div data-role="fieldcontain">
  <fieldset data-role="controlgroup" data-type="horizontal">
  <legend>Visibility Level:</legend>
  <form:radiobutton path="visibilityLevel" value="private" label="Private"/>
  <form:radiobutton path="visibilityLevel" value="open" label="Open"/>
  </fieldset>
  <form:errors path="visibilityLevel" style="color:red"></form:errors>
  </div>
  <div data-role="fieldcontain">
  <fieldset data-role="controlgroup" data-type="horizontal">
  <legend>Access Level:</legend>
  <form:radiobutton path="accessLevel" value="restricted" label="Restricted"/>
  <form:radiobutton path="accessLevel" value="unrestricted" label="Unrestricted"/>
  </fieldset>
    <form:errors path="accessLevel" style="color:red"></form:errors>
  </div>
  <input data-theme="b" type="submit" value="Ok" />
  </form:form>