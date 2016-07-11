<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="workflow">
	<div class="well" align="left"> 
			<table class="table" align="center" id = "table">
		        		<thead>
		        			
		        			<th>
		        				<Strong>sr.no</Strong>
		        			</th>
		        			<th>
		        				<Strong>Seller id</Strong>
		        			</th>
		        			<th>
		        				<Strong>Seller name</Strong>
		        			</th>
		        			<th>
		        				<Strong>Seller Address</Strong>
		        			</th>
		        			
		        		</thead>
		        	
		        		<tbody id = "tablebody" >	
		        		<s:set var="count" value="1"/>		        	
				        	<s:iterator id="iter" value="sellers" begin="0"> 
		 						<tr style="text-align: left;" id="tablerow">
		 							<td width="30%"><s:property  value="#count" /></td>
		 						 	<td width="30%"><s:property value="sellerid" /></td>
		 						 	<td width="30%"><s:property value="sellername" /></td> 
		 						 	<td width="30%"><s:property value="selleraddress" /></td>
		 						 	
		 						 	
								<tr>
								 <s:set var="count" value="%{#count+1}"/>
							</s:iterator>
					
						</tbody>
					</table>
					
					
					 <div class="well" align="left"> 
					 	<table class="table">
					 		<tbody>
									<td></td><td></td><td>
								<input type="submit" name="submit" value="submit" class="btn btn-primary" align="left"/>
									</td><td/>	
									</tr>
					 		</tbody>
					 	</table>
					 </div>
					
		</div>
		
</div>
</body>
</html>