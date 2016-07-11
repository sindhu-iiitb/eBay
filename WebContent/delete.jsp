<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<head>
<style type="text/css">
#division{
width: 60%;
margin: auto;
margin-left: 300px;
height: 250%;
}

</style>
<script type="text/javascript">
		
		function validateform(){  
			//var name=document.myform.subcategory.value;  
			var item = document.getElementById("itemslist");

			if (item.selectedIndex==0)
			{
			alert("Please select a item");
			return false;
			}
			  
			
			}
	</script> 
</head>
<div id="division">
<form action="deleteitemaction"  theme="simple" cssClass="form-horizontal" id="additemform" nonvalidate="nonvalidate" onsubmit="return validateform()">

 <div class="well" align="left"> 
					 	<table class="table">
							    
							    <tbody>
							        <td>items</td>
							        <td><s:select name="itemslist" id="itemslist" list="itemslist" headerKey="-1" headerValue="select item"  />  <br> </tr>
							         <tr>
							        <td></td>
							        <td>
									<input type="submit" name="Submit" value="Submit" class="btn btn-primary" id="iadd" align="right"/>
									
							        <td></td>
							      </tr>
							      </tbody>
							      </table>
							      </div>
							      
							      </form>
							      </div>