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


	
$(document).ready(function() {
	$('#pricefilter').click(function(event) {
			event.preventDefault();
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
	      
	      $.getJSON('ajaxSortAction', {
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
		        	var temp = item.itemsk;
		        	console.log(temp);
		        	   trHTML += 
							'<tr style="text-align: left;"><td width=30%>' + '<a href="getitem?i_surkey='+item.i_surkey+'"><img style="width:240px;height:160px"   src= "' +item.picture+ '"  class="img-thumbnail"></a>'+
			            			'</td><td width="70%"><p><a href="getitem?i_surkey='+item.i_surkey+ '">' + item.item_Name + ' </a></p><p><strong>Price :</strong>' + item.price + '</p><p><strong>Discount :</strong>' + item.discount + '</p><p><strong>Available :</strong>' + item.quantity + '</p></td><tr>';
			            
		            
		        	});
		        $('#tablebody').append(trHTML);
	      	}); 
	      	
	      });

					 $('#catbrand').change(function(event) {
				          var brands = $("select#catbrand").val();
				          console.log(brands);
				          var criteria = $("select#sortby").val();
					      var cat2_id = <s:property value="subcatid" />;
					    	  var toprice = $("#toprice").val();
					   		  if(toprice=="")
					   			  toprice="0";
						  var fromprice = $("#fromprice").val();
						  if(fromprice=="")
				   			  fromprice= "0";
						  $.getJSON('ajaxSortAction2', {
							 
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
							        	var temp = item.itemsk;
							        	console.log(temp);
							         trHTML += 
											'<tr style="text-align: left;"><td width=30%>' + '<a href="getitem?i_surkey='+item.i_surkey+'"><img style="width:240px;height:160px"   src= "' +item.picture+ '"  class="img-thumbnail"></a>'+
							            			'</td><td width="70%"><p><a href="getitem?i_surkey='+item.i_surkey+ '">' + item.item_Name + ' </a></p><p><strong>Price :</strong>' + item.price + '</p><p><strong>Discount :</strong>' + item.discount + '</p><p><strong>Available :</strong>' + item.quantity + '</p></td><tr>';
							            
							        	});
							        $('#tablebody').append(trHTML);
						      	}); 
				         })
		         
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
		<div class="col-sm-2 sidenav text-left well" style= "margin: 0 auto;">
		
				<div style="margin: 0 auto; ">		
				<!-- Filter by price -->
				 <label>Price Range</label>	
				 <ul style="list-style : none;">
				 	 <span style="font-size:12px;">Rs.<s:textfield name="fromprice" id="fromprice" size="6" > </s:textfield>
				 	to<br> Rs.<s:textfield name="to price" id="toprice" size="6" ></s:textfield>
				 	<input type="submit"  id="pricefilter" name ="pricefilter" value=">>" ></input></span>
				 
				 </ul>
				 <!-- Brands
				  <label>Brands</label>	
				 <ul style="list-style : none;">
				 <s:set var="count" value="0"></s:set>
				 	 <s:iterator id="iter" value="brands" begin="0">
				 	 <li><input type="submit"  id="brandfilter" name ="brandfilter" value=" <s:property value="brands[#count]"/>" style="width:150px;"></input></li>
				 	  <s:set var="count" value="%{#count+1}"/>
				 	 </s:iterator>
				 
				 </ul> -->
				 <ul style="list-style : none;">
				 <s:select name="brand" id="catbrand" list="brands" headerKey="-1" headerValue="select category" />
				 </ul>
				 
				 </div>				
			</div>	
		
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
		        			
		        			
		        			<th>
		        				Sort:
		        				<s:select name="sortby" list="#{'1':'Best Match', '2':'price:lowest first', '3':'price:highest first'}"
		        						headerkey="1" headervalue="Best Match" > </s:select>
		        			</th>
		        			</tr>
		        		</thead>
		        		<table class="table" align="center" id = "table">
		        		<tbody id = "tablebody" >			        	
				        	<s:iterator id="iter" value="items" begin="0"> 
		 						<tr style="text-align: left;" id="tablerow">
		 						 		<s:url action="getitem" var="item">
											<s:param name="i_surkey"><s:property value="i_surkey"/></s:param>
										</s:url>
		 						 	<td width="30%"><s:a href="%{item}"><img style="width:240px;height:160px" src = "<s:property value="picture" />" class= "img-thumbnail" width="200" height="200"></s:a></td>
		 						 	<td width="70%"><h4><p><s:a href="%{item}"><s:property value="item_Name" /></s:a></p></h4>
		 											<h5><p>Rs. <s:property value="price" /></p></h5>	 					
		        									<h4><p>Discount : <s:property value ="discount"/>%</h4>
		 											<h4><p>Items available : <s:property value ="quantity"/></h4>	 					
		        				
		 						 	</td>
								<tr>
							</s:iterator>
					
						</tbody>
					</table>
					<s:submit class="btn btn-primary" name="showmore" value="Show More"></s:submit>
				</div>
			</div>		
		</div>
		
		<div class="col-sm-2 sidenav well" style="height: 100% position:absolute;">
			<!-- advertisement paart -->
			
				<img alt="advertis 1" src="images/adv1.jpg" class="img-responsive" style="width:100%; height: 60%  ">
				<br>
				<img alt="advertis 2" src="images/adv2.jpg" class="img-responsive" style="width:100%; height: 20%">
			
		</div>
	</div>
</div>



</body>
</html>