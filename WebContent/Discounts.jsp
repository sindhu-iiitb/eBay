<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
	


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<title>Insert title here</title>

<style>

 body 
    {
  	overflow-x: hidden; /* // hide horizontal */
	}

	/*Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }

</style>



</head>
<body>

<s:actionerror theme="bootstrap"/>
<s:actionmessage theme="bootstrap"/>
<s:fielderror theme="bootstrap"/>

<!-- including the navigation bar -->	


<div class="container-fluid text-center"> 
			
		
		
		<div class="col-sm-8">
			<div class="container">
		        <div class="well-none">
		        	
		        
		        		<thead>
		        		<tr>
		        			<th>
		        				<div class="btn-group">
			        				<button class="btn btn-default" name="All Listings"><a href="#">All Listings</a></button>
			        				<button class="btn btn-default" name="Buy It Now"><a href="#">Buy It Now</a></button>
			        				<button class="btn btn-default" name="Auction"><a href="#">Auction</a></button>
		        				</div>
		        				
		        				
		        			</th>
		        			
		        		
		        			</tr>
		        		</thead>
		        		<table class="table" align="center" id = "table">
		        		<tbody id = "tablebody" >	
		        				        	
				        	<s:iterator id="iter" value="discountModels" begin="0"> 
		 						<tr style="text-align: left;" id="tablerow">
		 						 		<s:url action="getitem" var="item">
											<s:param name="i_surkey"><s:property value="itemid"/></s:param>
										</s:url>
		 						 	<td width="30%"><s:a href="%{item}"><img style="width:240px;height:160px" src = "<s:property value="picture" />" class= "img-thumbnail" width="200" height="200"></s:a></td>
		 						 	<td width="70%"><h4><p><s:a href="%{item}"><s:property value="itemname" /></s:a></p></h4>
		 											<h5><p>Rs. <s:property value="price" /></p></h5>	 					
		        									<h4><p>Discount : <s:property value ="discount"/>%</h4>
		 											<h4><p>Items available : <s:property value ="quantity"/></h4>	 					
		        				
		 						 	</td>
								<tr>
							</s:iterator>
					
						</tbody>
					</table>
					
				</div>
			</div>		
		</div>
		
		
	</div>
</div>



</body>
</html>