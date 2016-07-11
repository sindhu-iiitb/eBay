<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page import="java.sql.*"%>
<%@page import="ebay.iiitb.DBUtil.DbConnection" %>
<html lang="en">
<head>
  <title>update item</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.validate.js"></script>
  <style type="text/css">
	#deal{
		background-color: cyan;
		width:50%;
		margin:auto;	
	}
	
</style>
<script type="text/javascript">

		   function validateform(){  
				   /*var name2=document.addattributeForm.specificattribute2.value;  
		   var name3=document.addattributeForm.specificattribute3.value; */ 
		   var category = document.getElementById("one");
		  
		   //var selectedValue = ddl.options[ddl.selectedIndex].value;
		   if (category.selectedIndex==0)
		  {
		   alert("Please select an Item");
		   return false;
		  }
		 
			   

		  
		   }
	</script> 
</head>
<body>
	<div id="deal">
	 	<form action="UpdateItem"  theme="simple" cssClass="form-horizontal" id="addDeal" nonvalidate="nonvalidate" onsubmit="return validateform()">
					 <div class="well" align="left"> 
					 	<table class="table">
							    <tbody>  
							       <tr>
							        <td><strong>Select Item</strong></td>
							        <td><s:select name="item_Name" id="one" theme="css_xhtml" list="items" headerKey="-1" headerValue="select Item" ></s:select></td>
							        <td></td>
							      </tr>
						
								<tr>
									
									<td></td><td></td><td>
								<input type="submit" name="Delete Deal" value="Update Item" class="btn btn-primary" align="left"/>
									</td><td/>	
									</tr>
												
						</tbody>
					</table>
				</div>
			</form>
	</div>
</body>
</html>