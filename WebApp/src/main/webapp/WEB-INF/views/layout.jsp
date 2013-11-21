<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>
		<tiles:insertAttribute name="title" ignore="true" />
	</title>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/styles/jquery.mobile-1.3.2.min.css" />
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/styles/style.css" />
</head>
<body>
    <div data-role="page" class="type-<tiles:insertAttribute name="type" />">
      <div data-role="content">
			<tiles:insertAttribute name="header" />
			<div class="content-primary">
				<h2>
					<tiles:insertAttribute name="title" ignore="true" />
				</h2>
				<tiles:insertAttribute name="body" />
			</div>
			<div class="content-secondary">
				<tiles:insertAttribute name="menu" />
			</div>
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
	<tiles:insertAttribute name="scripts" />
</body>
</html>