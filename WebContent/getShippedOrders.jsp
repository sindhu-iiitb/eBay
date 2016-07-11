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
  

 	
  <div class="col-sm-10">
  <div class ="border">
  	<table>
  	<tr>
  	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
  	<td><b>OrderId</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
  	<td><b>Total Cost</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
  	<td><b>Transaction Date</b>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  	<td><b>Order Status</b>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  	</tr>
  	</table>
  
  </div>
  <s:set var="count" value="0"/>
  <s:set var="size" value="orderitems.size()"/>
  <s:iterator value ="orderitems">
  
      <div class="row">
           <s:if test="%{#count < #size}">
                <div class="caption">
                    <td></td> 
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="shipped_itemdetails.action?orderid=<s:property value="orderitems[#count].order_id"/>"><s:property value="orderitems[#count].order_id"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="orderitems[#count].totalcost"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="orderitems[#count].transaction_date"/>&nbsp;&nbsp;&nbsp;&nbsp; 
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="orderitems[#count].order_status"/>&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href ="update_ToReceived.action?o_surkey=<s:property value ="orderitems[#count].order_id"/>"><button type="submit" class="btn btn-default" id = "remove" ><strong>Received</strong></button></a>
                     </p>
                     <br/>
                     <s:set var="count" value="%{#count+1}"/>
                 </div>
            </s:if>
     </div>
     </s:iterator>
     </div>
     </div>
 </body>