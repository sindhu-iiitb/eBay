<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>eBay</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/business-casual.css" rel="stylesheet">
    <link href="css/productslider.css" rel="stylesheet">
    
    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-1.10.2.min.js"></script>
    <!-- Fonts -->
  <link href="css/fonts1.css" rel="stylesheet" type="text/css">
    <link href="css/fonts2.css" rel="stylesheet" type="text/css">
   
   <link href="css/business-casual.css" rel="stylesheet">
</head>
	<div class ="row" align = "center" style = "padding-bottom:300px;">
	 <form action="PaymentPage">
		<h3>Click Pay Now to pay the amount</h3><br><br>
		<input type="submit" name="Pay Now" value="Pay Now" class="btn btn-primary"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="revieworder.action" class="btn btn-info" role="button">Cancel</a>
    </form>
	</div>
    
  