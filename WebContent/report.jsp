<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
     <%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html  lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GENERATE REPORT</title>
</head>
<body>

                    <form action="generatereport"   theme="bootstrap" cssClass="form-horizontal" id="generatereport" nonvalidate="nonvalidate">
					 <div class="well" align="left"> 
					 	<table class="table">
							    
							    <tbody>
							     <tr>
							        <td> From</td>
							        <td><input type="text" id="from" name = "from" placeholder="from" /></td>
							        <td></td>
							      </tr>
							      <tr>
							        <td>To</td>
							        <td><input type="text" id="toe" name = "to" placeholder="to" /></td>
							        <td></td>
							      </tr>
							       <tr>
							        <td></td>
							        <td>
									 <input type="submit" class="btn btn-primary" value ="submit"  align="right"/>
									</td>
							        <td></td>
							      </tr>
							    </tbody>
							  </table>	             
					</div>        
					</form>
					
</body>
</html>