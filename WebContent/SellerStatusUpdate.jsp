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
  .title {
    padding: 0 0 10px;
    color: #555;
    border-bottom: 1px solid #dadada;
    font-weight: bold;
    font-size: 16px;
}
/* unvisited link */
a:link {
    color: black;
}

/* mouse over link */
a:hover {
    color: hotpink;
}

/* selected link */
a:active {
    color: blue;
}
	#item {
	font-family: "Times New Roman", Times, serif;
	font-size: 20px;
	}
.alignment {
    float align :right;
}
  </style>
  </head>
  <body>
  <div class="row">
 
  <div class="col-sm-10">
  <div class ="alignment">
  	<a id="item" class ="alignment" href="getpaid.action">Change Order Status To Shipped</a><br><br>
  	<a id="item" class ="alignment" href="getshipped.action">Change Order Status To Received</a>
  </div>
  </div>
 
  
  </div>
  
  
  </body>
  </html>
  