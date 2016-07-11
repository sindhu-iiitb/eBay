<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
<head>
  <title>Review Order</title>
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
<div class="caption">
     <table class="table">
     <tr>
    <th> Itemid</th>
    <th>ItemName</th>
    <th>Seller_Firstname</th>
    <th>Seller_Lastname</th>
    </tr>
       <s:iterator value="reportdetails">
       <tr>
       <th>
      <p> <s:property value="itemid"/> </p>
     </th>
     <th>
     <p><s:property value="item_name"/> </p>
     </th>
    	<th>
		 <p> <s:property value="firstname"/>
		 </th>
		 <th>
		<p><s:property value="lastname"/> </p>
		 </th>
		 
		  </tr>
		  
		</s:iterator>
		 </table>
       </div>
    
</body>
</html>