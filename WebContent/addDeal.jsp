<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page import="java.sql.*"%>
<%@page import="ebay.iiitb.DBUtil.DbConnection" %>
<html lang="en">
<head>
  <title>Add Deal</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery.min.js"></script>
   <script src="js/jquery.validate.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <style type="text/css">
	#deal{
		background-color: cyan;
		width:50%;
		margin:auto;	
	}
	
</style>
 <script type="text/javascript">
		$(document).ready(function() {
			$('#one').change(function(event) {
		          var name1 = $("#one").val();
		          $.getJSON('ajaxDealsSecondAction', {
		            itemName1 : name1,
		          }, function(jsonResponse) {
		            var select = $('#second');
		            select.find('option').remove();
		        $('<option>').text("Select Second Item").appendTo(select);
		            $.each(jsonResponse.itemNames, function(key, value) {
		              $('<option>').val(value).text(value).appendTo(select);
		            });
		          });
		         }); 
			  
				   $('#second').change(function(event) {
			          var name1 = $("#one").val();
			          var name2 = $("#second").val();
			          $.getJSON('ajaxDealsAction', {
			            itemName1 : name1,
			            itemName2 : name2,
			          }, function(jsonResponse) {
			            var select = $('#third');
			            select.find('option').remove();
			            $('<option>').text("Select Free Item").appendTo(select);
			            $.each(jsonResponse.itemNames, function(key, value) {
			              $('<option>').val(value).text(value).appendTo(select);
			            });
			          });
			         }); 	
			  
		
		});
		
		

		   function validateform(){  
				   /*var name2=document.addattributeForm.specificattribute2.value;  
		   var name3=document.addattributeForm.specificattribute3.value; */ 
		   var category = document.getElementById("one");
		   var category1 = document.getElementById("second");
		   var category2 = document.getElementById("third");
		   //var selectedValue = ddl.options[ddl.selectedIndex].value;
			if (category.selectedIndex==0)
			  {
			   alert("Please select first Item");
			   return false;
			  }
		   if (category1.selectedIndex==0)
			  {
			   alert("Please select second  Item");
			   return false;
			  }
			   
		   if (category2.selectedIndex==0)
			  {
			   alert("Please select third Item");
			   return false;
			  }
			   

		  
		   }
	</script> 		
</head>
<body>
	<div id="deal">
	 	<form action="insertDeal"  theme="simple" cssClass="form-horizontal" id="addDeal" nonvalidate="nonvalidate" onsubmit="return validateform()">
					 <div class="well" align="left"> 
					 	<table class="table">
							    <tbody>
							    <tr>
							        <td><strong>Deal Title</strong></td>
							        <td><input type="text" id="deal_title" name="deal_title" placeholder="Deal title" required="required"  class="span4" /></td>
							        <td></td>
							      </tr>  
							       <tr>
							        <td><strong>Select Item1</strong></td>
							        <td><s:select name="item1" id="one" theme="css_xhtml" list="itemNames" headerKey="-1" headerValue=" select First Item" ></s:select></td>
							        <td></td>
							      </tr>
							      <tr>
							        <td><strong>Select Item2</strong></td>
							        <td><s:select name="item2" id="second" theme="css_xhtml" list="{}" headerKey="-1" headerValue="Select Second Item" ></s:select></td>
							        <td></td>
							      </tr>
							      <tr>
							        <td><strong>Select Free Item</strong></td>
							        <td><s:select name="item3" id="third" theme="css_xhtml" list="{}" headerKey="-1" headerValue=" Select Free Item" ></s:select></td>
							        <td></td>
							      </tr>
								<tr>
									
									<td></td><td></td><td>
								<input type="submit" name="Add Deal" value="Add Deal" class="btn btn-primary" align="left"/>
									</td><td/>	
									</tr>
												
						</tbody>
					</table>
				</div>
			</form>
	</div>
</body>
</html>