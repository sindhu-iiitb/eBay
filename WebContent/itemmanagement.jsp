<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
     <%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<div id="division">
 <tr>
							        <td><strong> Item Management</strong></td>
							        
							     <tr>
							      		<td><form action="selectaction"  theme="simple" cssClass="form-horizontal" id="selectaction"> 					        
							       <div class="well" align="left"> 
					 	<table class="table">
							    
							    <tbody>
							     <s:radio
					                        tooltip="Select an action on the items"
					                        labelposition="inline"
					                        list="{'AddItem','DeleteItem','UpdateItem','Add Deal','Delete Deal'}"
					                        name="choice"
					                        cssErrorClass="foo"
					                       requiredLabel="true"/> 
					                       </td>
					             </tr>
					                     
							       <tr>
							        <td></td>
							        <td><br>
									<input type="submit" name="submit" value="submit" class="btn btn-primary" id="iadd" align="right"/>
									
							        <td></td>
							      </tr>
							      </tbody>
							      </table>
							      </div>
							      
					                      </form></td>
					                      
							        <td></td>
							 </tr>
							 </div>
							 </div>
</body>
</html>