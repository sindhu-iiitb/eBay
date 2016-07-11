<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <!-- jQuery -->
    <script src="js/jquery.js"></script>
    <script src="js/jquery.validate.js"></script>
   
    
    

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    
<style type="text/css">
#division{
width: 60%;
margin: auto;
margin-left: 300px;
height: 250%;
}

</style>
</head>
<body>

<script type="text/javascript">
   $(document).ready(function() {
	   $('#cat').change(function(event) {
	          var categories = $("select#cat").val();
	          $.getJSON('ajaxAction', {
	            categoryName : categories
	          }, function(jsonResponse) {
	            var select = $('#subcat');
	            select.find('option').remove();
	            $.each(jsonResponse.categoryMap, function(key, value) {
	              $('<option>').val(key).text(value).appendTo(select);
	            });
	          });
	         })
	         
	         
});
   

   function validateform(){  
   var name1=document.addattributeForm.specificattribute1.value;  
   /*var name2=document.addattributeForm.specificattribute2.value;  
   var name3=document.addattributeForm.specificattribute3.value; */ 
   var category = document.getElementById("cat");
   //var selectedValue = ddl.options[ddl.selectedIndex].value;
   if (category.selectedIndex==0)
  {
   alert("Please select a category");
   return false;
  }
   

     
   if (name1==null || name1==""){  
     alert("atleast add one attribute");  
     return false;  
   }
   }
   </script>
<div id="division">
  		
                    <form action="AddItemSpecificAttributes"  theme="bootstrap" cssClass="form-horizontal" name="addattributeForm" nonvalidate="nonvalidate" onsubmit="return validateform()">
					 <div class="well" align="left"> 
					 	<table class="table">
							    
							    <tbody>
							      <tr>
							        <td>Category</td>
							        <td><s:select name="category" id="cat" list="categories.keySet()" headerKey="-1" headerValue="select category" />  <br> </tr>
									 <tr> <td>Sub Category</td><td><s:select name="subCategory" id="subcat" headerKey="-1" headerValue="select Subcategory" list="{'Select subcategory'}"  />
									       </td></tr>
									       <tr><td><td>Attribute 1</td><td><input type="text" name = "specificattribute1" id ="specificattribute1" ></td></tr>
									       <tr><td><td>Attribute 2</td><td><input type="text" name = "specificattribute2" id="specificattribute2" ></td></tr>
									       <tr><td><td>Attribute 3</td><td><input type="text" name = "specificattribute3" id="specificattribute3"></td></tr>
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