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
</head>
<body>
   <div id="division">
                    
			<s:form action="updatevatdetails"  theme="bootstrap" cssClass="form-horizontal">
					 <div class="well" align="left"> 
					 	<table class="table">
							    
							    <tbody>
							   	  <tr>
							        <td>Enter Vat Percentage</td>
							        <td> <s:textfield id="vat_percentage" name = "vat_percentage" placeholder="Enter Vat Percentage" class="span4" required = "required"> </s:textfield></td>
							        <td></td>
							      </tr>
							      <tr>
							        <td>
									<s:submit id="iadd" cssClass="btn btn-primary" align="right"/>
							        </td>
							      </tr>
							    </tbody>
							  </table>
					             
					</div>        
					</s:form>					       
							      
                   
   </div>
</body>
</html>