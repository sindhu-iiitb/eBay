<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <style type="text/css">
 .cartBorder {
    position: relative;
    border: 10px solid #EEEEEE;
}
.cartmargins1 {
    position: relative;
    border: 1px solid #EEEEEE;
    padding: 10px 20px 18px 20px;
	color: #666666;
	height: 80px;
}
#text1
{
font-size: 28px;
font-weight: 200;
text-align : left;
}
#text2{
font-size: 14px;
padding-right: 5px;
text-align : right;
}
#text3{
font-size: 24px;
color: #666;
font-weight: 700
}
.rightalign{
text-align: left;
float: right;
padding-top: 10px;
}
.margins{
margin-top: 100px;
    margin-bottom: 100px;
    margin-right: 150px;
    margin-left: 80px;	
}
.cartmargins2{
padding: 20px 20px 10px 20px;
border-top: 1px solid #DDD;
border-bottom: 1px solid #DDD;
background-color: #F2F2F5;
}
.inline{
display: inline-block;
width: 100%;
}
.rgt{
float: right;
text-align: right;
min-width: 250px;
}
.po{
padding-bottom: 10px;
float: right;
}
.btn{
display: inline-block;
vertical-align: baseline;
cursor: pointer;
text-align: center;
font-weight: 500;
border-radius: 3px;
box-shadow: 0 3px 0px
padding-top: 0.5em;
padding-right: 1.2em;
padding-bottom: 0.5em;
padding-left: 1.2em;
border-top-width: 1px;
border-right-width: 1px;
border-bottom-width: 1px;
border-left-width: 1px;
border-top-style: solid;
border-right-style: solid;
border-bottom-style: solid;
border-left-style: solid;
border-top-color: transparent;
border-right-color: transparent;
border-bottom-color: transparent;
border-left-color: transparent;
border-image-slice: 100% 100% 100% 100%;
border-image-width: 1 1 1 1;
border-image-outset: 0 0 0 0;
border-image-repeat: stretch stretch;
overflow: visible;
overflow-x: visible;
overflow-y: visible;
}
.btn-m {
    font-size: 14px;
}
.btn-prim{
	color: #fff;
	background: -moz-linear-gradient(top, #0079bc, #00509d);
    background-color: transparent;
    background-image: -moz-linear-gradient(center top , rgb(0, 121, 188), rgb(0, 80, 157));
    background-repeat: repeat;
    background-attachment: scroll;
    background-position: 0% 0%;
    background-clip: border-box;
    background-origin: padding-box;
    background-size: auto auto;
}
.sm{
padding-right: 28px;
float: right;
margin-top:7px;
}
.btn-ter{
border-width: 1px;
border-style: solid;
border-color: #ccc #ccc #bbb;
background: -moz-linear-gradient(top, #fefefe,#f8f8f8);
}
#sm
{
			display: inline;
   		 	border-radius:5px; 
   		 	background-color:rgb(178,190,181)
   		 	color:white;
   		 	margin-top:7px;
}
#placeorder{
			margin-top:15px;
			display: inline;
   		 	border-radius:5px; 
   		 	background-color:rgb(0,80,157);
   		 	color:white;
   		 	
}
.cartmargins3 {
    position: relative;
    border: 1px solid #EEEEEE;
    padding: 10px 20px 18px 20px;
	<!--color: #666666;-->
	border-bottom: 1px solid #E5E5E5;
	<!--background-color: #FFF;-->	
}
img.top{
vertical-align:text-top;
}
#checkbox:hover{
  	font-weight: bold;
	color: #333;
  } 
  p{
  float: right;
  }
.footer{
padding: 12px;
text-align: center;
border-top: 1px solid #DDD;
height: 110px;
}
#remove{
float: right;
}
  </style>
  <script>
	$(document).ready(function(){
		$('input[type=text]').each(function(){
	
				$(this).focusout(function(){
					 console.log($(this).val());
					 console.log($(this).attr("id"));
					$.getJSON('updatequantity', {
						quantity : $(this).val(),
						item_key : $(this).attr("id"),
					},function(jsonResponse) {
						if(jsonResponse.quantityCheck == "0"){
							alert("Quantity not available");
						}
						//window.location="start";
						//console.log("response");
					});	
				});
			});
	});
</script>
  </head>
  <body>
  <div class = "margins">
  <div class = "cartBorder">
  <div class = "cartmargins1" >
 	<span id = "text1">Items in your cart</span>	
 	<!-- 	<div class = "rightalign">
 			<span id ="text2"><b>Order total</b></span>
 			<span id = "text3">Rs.</span>
 			<<span id = "text3"><p id="ordertotal"></p></span>
 			<span id = "text3"><s:property value = "orderTotal"/></span>
 		</div> -->
 		
  </div>
  <div class = "cartmargins2" style="display:block">
  	<div class = "inline">
  		
  			<div>
  			 <p> <a href="viewoffers.action" class="btn btn-m btn-prim" id ="placeorder" role="button">View Offers</a></p>
  				<!-- <input class = "btn btn-m btn-prim" type ="submit" value ="Place Order"></input> -->
  			</div>	
  			<div >
  			<p><a class ="btn btn-m btn-default" id ="sm" href ="start.action">Shop More</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
  			</div>
  		
  	</div>
 </div>
 			  <s:set var="count" value="0"/>
			  <s:set var="size" value="itemsInCart.size()"/> 
		 		  	   
<s:iterator value = "itemsInCart" status="stat">
	<div class ="cartmargins3">
		<s:if test="%{#count < #size}"> 
			 <div class ="inline">
			 		<!--  <div class="checkbox">
  						<label id =checkbox><input type="checkbox" value="orderitem#count" checked></label>
			 		</div>-->
			 			 <script>
			 			 var total=0;
			        	 var flag=1;
			 	     	</script>						
			  			<img class ="top" src="<s:property value="itemsInCart[#count].item.picture"/>" alt="Slide11" style="width:96px;height:96px;">
			  		    <a href ="getitem.action?i_surkey=<s:property value ="itemsInCart[#count].item.i_surkey"/>"><s:property value = "itemsInCart[#count].item.itemName"/></a>
			  							
			  			<p>Qty<input name = "quantity" id = "<s:property value ='itemsInCart[#count].item.i_surkey'/>" type="text" maxlength="5" size="2" 
			value="<s:property value ="itemsInCart[#count].item.quantity"/>" ></input>
			  			 <button type="button">update</button> 
			  			<br><br><br>
			  			<s:if test="%{itemsInCart[#count].item.discount > 0}">
			  			 <br><b style="float:right">Price per Item &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rs.<s:property value ="itemsInCart[#count].item.price" /></b>	<br>
			  			 <br><b style="float:right">Discount per Item&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value ="itemsInCart[#count].item.discount" /> %</b>	<br>
			  			 <br><b style="float:right">Price After Discount per Item &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rs.<s:property value ="itemsInCart[#count].item.priceafterdiscount" /></b>	<br>
			  			<br><b style="float:right">Shipping Cost &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rs.<s:property value ="itemsInCart[#count].item.shippingcost" /></b>	<br>
			  			</s:if>
			  			<s:else>
			  			 <br><b style="float:right">Price per Item &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rs.<s:property value ="itemsInCart[#count].item.price" /></b>	<br>
			  			<br><b style="float:right">Shipping Cost &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rs.<s:property value ="itemsInCart[#count].item.shippingcost" /></b>	<br>
			  			</s:else>
			  			
			  			<a href ="remove.action?item_key=<s:property value ="itemsInCart[#count].item.i_surkey"/>"><button type="submit" class="btn btn-default" id = "remove" ><strong>Remove</strong></button></a></p>
				  		</div>
				  	</s:if>
		<s:set var="count" value="%{#count+1}"/>
	</div>
</s:iterator>  				

  <div class="footer">
  <img src="Images/ebay_guar.jpg">
  </div> 
  </div>
  </div>
 </body>
 