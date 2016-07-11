<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
<head>
  <title>View Details</title>
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

    
<!--<ol class="breadcrumb">
  	<li><a href="#">Home/Buy/</a></li>
  	<li class="active">Review Order</li>
	</ol>
    <div class="container">-->

       
    <div style="float:center">
     <h1 class="intro-text text-center"><strong>View Details</strong></h1>
    
    
     
      
       <div class="intro-text text-center" >
        <hr align="center">
       <s:iterator value="view">
          <h3><p>NAME:</p></h3>
          <h4><p><strong><s:property value="view[0].firstname"/>  <s:property value="view[0].lastname"/></strong></p></h4>
           <h3><p>ADDRESS:</p></h3>
     	 <p><s:property value="view[0].line1"/> </p>
		<p> <s:property value="view[0].line2"/> </p> 
		<p><s:property value="view[0].city"/></p>
	    <p><s:property value="view[0].state"/></p> 
	  <p><s:property value="view[0].pincode"/></p> 
	     <h3><p>EMAIL:</p></h3>
	      <p><s:property value="view[0].email"/></p> 
	      <h3><p>USERNAME:</p></h3>
	      <p><s:property value="view[0].user_id"/></p> 
		</s:iterator>
       </div>
     
      
    </div>
    
  
</body>
