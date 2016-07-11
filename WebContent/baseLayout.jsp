<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div id="header">
   <tiles:insertAttribute name="header" /><br/>
   </div>
   <div id="body">
   <tiles:insertAttribute name="body" /><br/>
  </div>
  <div id=footer>
   <tiles:insertAttribute name="footer" /><br/>
   </div>
</body>
</html>