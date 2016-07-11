<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <script src="js/jquery-1.10.2.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/jquery.validate.js"></script>
<style type="text/css">
#division{
width: 50%;
margin: auto;
margin-left:450px;
margin-top:100px;
height:360px;
}

</style>
</head>
<body>
<script>


function myfun(obj){
	$.getJSON('validateAction',{'item_Id': obj.value},function(data) {
		
		if(data.status==false){
			alert("Please enter valid itemid");
			
		}
		
	});
}

</script>

  <div id="division">
                	<form action="updateadvt"  theme="bootstrap" class="form-horizontal">
                	<table>
                	<tr><td>Item ID &nbsp; &nbsp; &nbsp; &nbsp;</td>
                	<td><input type="text" id ="item_Id" name="item_Id" placeholder="item_Id" class="span4" onchange="myfun(this)" required="required"></td>
                	<td><input type="submit" class="btn btn-primary" value ="submit" name="submit" align="right"/></td></tr>
                	
                	</table>       
				    </form>
							       
				   
                </div>

</body>
</html>