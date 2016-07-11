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
	font-size: 16px;
	}
.border {
    border-style: solid;
    border-width: 10px;
    border-color:grey;
}
  </style>
  </head>
  <body>
  <div class="row">
  
  <div class="col-sm-2">
  
  	<div class="title">Bought From eBay</div><br>
  	<a id="item" href="In_transaction_orders.action">Transactions in Process</a> <br><br>
  	<a id="item" href="shipped_orders.action">Items Shipped</a><br><br>
  	<a id="item" href="received_orders.action">Items Received</a><br><br>
  	<a id="item" href="seller_or_user.action">Change Order Status</a>
  
  </div>
 	
  <div class="col-sm-10">
  <h2><b>No Items to Display</b></h2>
  </div>
 
  
  </div>
  
  
  </body>
  </html>
  