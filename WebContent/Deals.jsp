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

<script>

$(document).ready(function() {
	   $('#sortby').change(function(event) {
	      var criteria = $("select#sortby").val();
	      var brands = $("select#catbrand").val();
	      var cat2_id = <s:property value="subcatid" />;
	   	  var toprice = $("#toprice").val();
	   		  if(toprice=="")
	   			  toprice="0";
		  var fromprice = $("#fromprice").val();
		  if(fromprice=="")
   			  fromprice= "0";
	      console.log(criteria);
	      console.log(cat2_id);
	      console.log(toprice);
	      console.log(fromprice);
	      
	      $.getJSON('ajaxSortAction1', {
	        sortid : criteria,
	        subcatid : cat2_id,
	        toprice : toprice,
	        fromprice : fromprice,
	    	brand : brands
	
	      }, function(jsonResponse) {
			$('#ajaxResponse').text(jsonResponse.dummyMsg);
			$('#tablebody').remove();
			var tbody = '<tbody id="tablebody">';
			$('#table').append(tbody);
			
				 var trHTML = '';
		        $.each(jsonResponse.items, function (i, item) {
		        	console.log(item.itemsk);
		        	   trHTML += 
							'<tr style="text-align: left;"><td width=30%>' + '<a href="getitem?i_surkey='+item.i_surkey+'"><img style="width:240px;height:160px"   src= "' +item.picture+ '"  class="img-thumbnail"></a>'+
			            			'</td><td width="70%"><p><a href="getitem?i_surkey='+item.i_surkey+ '">' + item.item_Name + ' </a></p><p><strong>Price :</strong>' + item.price + '</p><p><strong>Discount :</strong>' + item.discount + '</p><p><strong>Available :</strong>' + item.quantity + '</p></td><tr>';
			            
		            
		        	});

		        $('#tablebody').append(trHTML);
	      	}); 
	      	
	      });
	});


	

	
	</script>


</head>
<body>

<s:actionerror theme="bootstrap"/>
<s:actionmessage theme="bootstrap"/>
<s:fielderror theme="bootstrap"/>

<!-- including the navigation bar -->	


<div class="container-fluid text-center"> 
			
	<div class="row content">
		
		<div class="col-sm-12">
			<div class="container">
		        <div class="well-none">
		        	
		        <!-- 
		        		<thead>
		        		<tr>
		        			<th>
		        				<div class="btn-group">
			        				<button class="btn btn-default" name="All Listings"><a href="#">All Listings</a></button>
			        				<button class="btn btn-default" name="Buy It Now"><a href="#">Buy It Now</a></button>
			        				<button class="btn btn-default" name="Auction"><a href="#">Auction</a></button>
		        				</div>
		        				
		        				
		        			</th>
		        			
		        			
		        			<th>
		        				Sort:
		        				<s:select name="sortby" list="#{'1':'Best Match', '2':'price:lowest first', '3':'price:highest first'}"
		        						headerkey="1" headervalue="Best Match" > </s:select>
		        			</th>
		        			</tr>
		        		</thead>-->
		        		<table class="table" align="center" id = "table">
		        		<tbody id = "tablebody" >			        	
				        	<s:iterator id="iter" value="deals.keySet().toArray()" begin="0" var="j"> 
				        	
			       		
		 					 	<tr style="text-align: left;" id="tablerow">
		 					 	
		 						 	<td width="30%">
		 						 	<h3><s:property value="deals.get(#j).get(0).dealtitle"/> </h3>
		 						 	
		 						 	
		 						 	<s:url action="getitem" var="item">
											<s:param name="i_surkey"><s:property value="deals.get(#j).get(0).i_surkey"/></s:param>
										</s:url>
		 						 	<s:a href="%{item}"><img style="width:240px;height:160px" src = "<s:property value="deals.get(#j).get(0).picture"/>" class= "img-thumbnail" width="200" height="200"></s:a>
		 						 	<h4><p><s:a href="%{item}"><s:property value="deals.get(#j).get(0).itemname"/></s:a></p></h4>
		 											<h5><p>Rs.<s:property value="deals.get(#j).get(0).price"/></p></h5>	 					
		 											<h4><p>Items available :<s:property value="deals.get(#j).get(0).quantity"/></h4>	 					
		        				
		 						 	 </td>
								
		 						 	<td width="30%"><br><br><br>
		 						 	<s:url action="getitem" var="item">
											<s:param name="i_surkey"><s:property value="deals.get(#j).get(1).i_surkey"/></s:param>
										</s:url><s:a href="%{item}"><img style="width:240px;height:160px" src = "<s:property value="deals.get(#j).get(1).picture"/>" class= "img-thumbnail" width="200" height="200"></s:a>
		 						 	<h4><p><s:a href="%{item}"><s:property value="deals.get(#j).get(1).itemname"/></s:a></p></h4>
		 											<h5><p>Rs.<s:property value="deals.get(#j).get(1).price"/></p></h5>	 					
		 											<h4><p>Items available :<s:property value="deals.get(#j).get(1).quantity"/></h4>	 					
		        				
		 						 	
									</td>
		 						 	<td width="30%" ><br><br><br>
		 						 	<s:url action="getitem" var="item">
											<s:param name="i_surkey"><s:property value="deals.get(#j).get(2).i_surkey"/></s:param>
										</s:url>
		 						 	
		 						 	<s:a href="%{item}"><img style="width:240px;height:160px" src = "<s:property value="deals.get(#j).get(2).picture"/>" class= "img-thumbnail" width="200" height="200"></s:a>
		 						 					<img src="Images/free.png" style="width:50px;height:50px;align:top;">
		 						 					<h4><p><s:a href="%{item}"><s:property value="deals.get(#j).get(2).itemname"/></s:a></p></h4>
		 											<h5><p>Rs.<s:property value="deals.get(#j).get(2).price"/></p></h5>	 					
		 											<h4><p>Items available :<s:property value="deals.get(#j).get(2).quantity"/></h4>	
		 											
		 								<br>	
		 							<h4>
		 							Seller Details<br></h4>
		 							<h5>Seller name: <s:property value="deals.get(#j).get(0).sellername"/><br>
		 						 	Seller Rating: <s:property value="deals.get(#j).get(0).sellerrating"/><br>
		 						 	Number of buyers: <s:property value="deals.get(#j).get(0).numberofbuyers"/></h5>				 					
		        				<s:if test="deals.get(#j).get(3).flag==null"><img src="Images/nodeal.jpg" style="width:150px;height:150px;align:center;"></s:if>
		 					 	<s:else>
		        				<a href="displayCart.action?deals_id=<s:property value="deals.get(#j).get(3).deals_id"/>">
								<button type="button" class="btn btn-primary btn-embossed" style="float:right;"><b>Add to cart<span class="glyphicon glyphicon-shopping-cart" style="font-size:15px"></span></b></button></a></s:else>
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