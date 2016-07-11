<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <style type="text/css">

 #listitems{
	
	  font-size: 100%;
	  }
	  #maindiv{
	      width:100%;
	      height:360px;
	      padding-top:10px;
	      padding-left:230px;
	      margin-left:300px;
	      border-left:300px;'
          margin: auto;
	     
	  }
  </style>
  </head>
  <body>
  	<div class ="container"  id="maindiv">
  	<div class ="row">
  	<div  >
  	
  		<ul class="list-unstyled" >
  			<li class ="title">Top Categories</li>
  			<hr style="border-bottom-style: solid;border-width: 2px;color: gray;">
  			<s:iterator  value="subCategories.subCatlist.toArray()" var="i">
	  		<li><a id="listitems" href="get.action?category_Name=<s:property value="#i"/>"><s:property value="#i"/></a></li> 
	  		
	  	
	  		</s:iterator>
  		</ul>
  	</div>
  
   </div>
  </div>
    
</body>