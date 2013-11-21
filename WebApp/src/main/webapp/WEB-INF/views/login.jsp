<form data-ajax="false" method="post" action="<%= request.getContextPath() %>/login">
  <div class="${errorClass}">
  	${errorMsg}
  </div>
  <div data-role="fieldcontain">
    <label for="email">Email:</label>
    <input type="text" name="email" id="email" value="${email}" />
  </div>
  <div data-role="fieldcontain">
    <label for="password">Password:</label>
    <input type="password" name="password" id="password" value="" />
  </div>
  <input data-theme="b" type="submit" value="Go" />
</form>