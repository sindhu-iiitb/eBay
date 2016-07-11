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
	  #div1{
	  	width:30%;
	  	margin-left:500px;
	  }
	 
  </style>
  </head>
  <body>

    


   <div id="div1" class="col-sm-10 col-sm-offset-1 tab-pane active" id="division">
   	 <div style="float:left">
    	 <h1 class="intro-text text-center"><strong>Review Order</strong></h1>
       	 <h4>Your items will be delivered to following address:</h4>
     	 <div class="caption">
         <s:iterator value="TL">
        
        	  <h4><p><strong><s:property value="TL[0].firstname"/>  <s:property value="TL[0].lastname"/></strong></p></h4>
     		 <p><s:property value="TL[0].line1"/> </p>
			<p> <s:property value="TL[0].line2"/> </p> 
			<p><s:property value="TL[0].city"/></p><p><s:property value="TL[0].state"/></p> 
		</s:iterator>
		<p><strong>Grand Total:</strong><s:property value="grandtotal"/></p>
     	 <a href="loadchangeaddress.action"><strong class="text-info">change address</strong></a><br><br>
		<a href="makepayment.action" class="btn btn-info" role="button">Make Payment</a><br><br>
	
       </div>
      
     
      
    
    </div>
    
    </div>
    
  
</body>
  