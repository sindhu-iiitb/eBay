<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#division{
width: 50%;
margin: auto;

}

</style>

 <script type="text/javascript">
		
		function validateform(){  
			//var name=document.myform.subcategory.value;  
			var category = document.getElementById("one");

			if (category.selectedIndex==0)
			{
			alert("Please select a category");
			return false;
			}
			  
			
			}
	</script> 
</head>
<body>
 <div id="division">
  		
                    <form action="AddNewSubcategory" name="myform" theme="bootstrap" cssClass="form-horizontal" onsubmit="return validateform()">
					 <div class="well" align="left"> 
					 	<table class="table">
							    
							    <tbody>
							    <tr>
							        <td>Category</td>
							        <td> <s:select name="category" id="one" list="categories.keySet()" headerKey="-1" headerValue="select category" style="width:100%" /> 
									     
								  </td>
							      </tr>
							     
							      <tr>
							        <td>Sub Category</td>
							        <td> <s:textfield id= "name" name = "subcategory" placeholder="Enter SubCategory" class="span4" required="required"> </s:textfield></td>
							        <td></td>
							      </tr>
							       <tr>
							        <td></td>
							        <td>
									<input type="submit" class="btn btn-primary" value ="submit" name="submit" align="right"/>
								
							        <td></td>
							      </tr>
							    </tbody>
							  </table>
					
					
					
					
					
					             
					</div>        
					</form>
                </div>
</body>
</html>