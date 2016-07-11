<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*" %>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="ebay.iiitb.DBUtil.DbConnection" %>
<html lang="en">
<head>
  <s:head theme="simple"/> 
  <sx:head/>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script type="text/javascript">
  dojo.addOnLoad(init);
  function init() {
	  
	  var datePicker = dojo.widget.byId("to_date");
	  console.log(datePicker);
	  dojo.event.connect(datePicker, "onValueChanged", calcost);
	  }
  function calcost(){
	  
	  var start=dojo.widget.byId("from_date").getValue();
	  console.log(start);
	  var end=dojo.widget.byId("to_date").getValue();
	  console.log(end);
	  var adkey = $("#adt_surkey").val();
	  if(start=="" || end=="" || adkey=="")
	  {
		  alert("please enter advertisement id, start date and then end date to get cost"); 
	  }
	  else
	  {
		  if ((new Date(start).getTime()) > (new Date(end).getTime())) {
			  alert("please enter end date larger than start date");  
		  }
		  else{
		  	   $.getJSON('getCost', {start : start, end : end, adkey : adkey}, function(jsonResponse) {
			   alert("The chargable cost for advertising this item is Rs."+jsonResponse.cost);
			   }); 
		  }
      		
	  }
 }
   $(document).ready(function() {
	  $('#adt_surkey').hide();
	  $("#adt_label").hide();
	  $("#from_label").hide();
	  $("#to_label").hide();
	  $('#from').hide();
	  $('#to').hide();
	  
	  $('input:radio[name="advt_status"]').change(
			    function(){
			        if ($(this).is(':checked') && $(this).val() == 'Yes') {
			            // append goes here
			        	$('#adt_surkey').show();
			      	  $("#adt_label").show();
			      	  $("#from_label").show();
			      	  $("#to_label").show();
			      	  $('#from').show();
			      	  $('#to').show();
			      	 
			        }
			        else{
			        	$('#adt_surkey').hide();
			      	  $("#adt_label").hide();
			      	  $("#from_label").hide();
			      	  $("#to_label").hide();
			      	  $('#from').hide();
			      	  $('#to').hide();
			        }
	 });
	  $('#item_Name,#item_desc,#shippingdetails,#paymentmode,#Brand,#type,#model,#material').focusout(function(){
		  var query=$(this).val();
		  if(!(isNaN(parseFloat(query))))
		  {
			alert("should be string");
			 $(this).val("");
		  }
	  });
	  $('#quantity,#duration,#price,#weight,#discount,#handlingtime,#shippingcost,#warranty,#size').focusout(function(){
		  var query=$(this).val();
		  if((isNaN(parseFloat(query))))
		  {
			alert("should be number");
			 $(this).val("");
		  }
	  });
  }); 
</script>
</head>
<body>
<script>

 function myfun(obj){
	$.getJSON('validatename',{'item_Name': obj.value}, function(data) {
		
		if(data.status!=null){
			alert("Name already exists");
			
		}
		
	});
} 
</script>
	<!--  <ol class="breadcrumb">
  	<li><a href="#">Home</a></li>
  	<li><a href="#">Sell</a></li>
  	<li class="active">Add Item</li>
	</ol>-->
    <div class="container" style="width:50%;background-color:#F5F5F5">

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center"><strong>Add Item Form</strong>
                    </h2>
                    <hr>
                </div>
                <div class="col-md-8">	
                    <form action="AddItem"  theme="bootstrap"  display="block" id="additemform" nonvalidate="nonvalidate">
					 <div class="well" align="left" style="background-color:#F5F5F5"> 
					 <s:hidden value="%{category_Name}" name="category_Name" />
					 <s:hidden value="%{subCategory_Name}" name="subCategory_Name" />
					 	<table class="table" border="0" >
							    
							    <tbody>
							      <tr>
							        <td>Name</td>
							        <td><input type="text"  name = "item_Name" id="item_Name" placeholder="Item Name" onchange="myfun(this)" class="span4" required="required" title="Name must be String"/></td>
							        <td></td>
							      </tr>
							      <tr>
							        <td>Item Description</td>
							        <td><input type="text"  name = "item_desc" id="item_desc" placeholder="Item Description" class="span4" required="required"  title="Description must be string"/></td>
							        <td></td>
							      </tr>
							      <tr>
							        <td>Condition</td>
							        <td><select name = "condition" id="condition" placeholder="Condition" class="span4" required="required" title="choose any one of the given options">
							        	<option value="old">Old</option>
							        	<option value="new">New</option>
							        	<option value="refurbished">Refurbished</option>
							        	<option value="NA">NA</option>
							        	</select>
							        </td>
							      </tr>
							      <tr>
							        <td>Quantity</td>
							        <td><input type="text"  name = "quantity" id="quantity" placeholder="Quantity" class="span4" required="required" title="quantity must be numeric"/></td>
							      </tr>
							      <tr>
							        <td>Duration</td>
							        <td><input type="text"  name = "duration" id="duration" placeholder="Duration" class="span4" required="required" title="Duration must be in number of days"/></td>
							      </tr>
							      <tr>
							        <td>Price</td>
							        <td><input type="text"  name = "price" id="price" placeholder="Price" class="span4" required="required" title="price must be in rupees and numeric"/></td>
							      </tr>
							     	
							     	<tr>
							        <td>Weight</td>
							        <td><input type="text"  name = "weight" id="weight" placeholder="weight" class="span4" required="required" title="weight must be in grams and numeric"/></td>
							      </tr>
							     <tr>
							        <td>Serviced in India</td>
							        <td><select name = "serviced_in_india" id="serviced_in_india" selected="<s:property value="serviced_in_india"/>" class="span4" required="required" title="choose any one of the given options">
							        	<option value="yes">Yes</option>
							        	<option value="no">No</option>
							        	<option value="NA">NA</option>
							        	</select>
							        </td>
							      </tr>
							      <tr>
							        <td>Discount</td>
							        <td><input type="text"  name = "discount" id="discount" placeholder="Discount" class="span4" title="discount must be in percentage"/></td>
							      </tr>
							      <tr>
							        <td>Payment Mode</td>
							        <td><input type="text"  name = "paymentmode" id="paymentmode" placeholder="Payment Mode" class="span4" required="required" title="only debit card is allowed"/></td>
							      </tr>
							      <tr>
							        <td>Shipping Details</td>
							        <td><textarea name = "shippingdetails" id="shippingdetails" placeholder="Shipping Details" class="span4" required="required" rows="4" cols="50" title="Mention correct address" ></textarea></td>
							      </tr>
							      <tr>
							        <td>Handling Time</td>
							        <td><input type="text"  name = "handlingtime" id="handlingtime" placeholder="Handling Time" class="span4" required="required" title="must be in number of days"/></td>
							      </tr>
							      <tr>
							        <td>Shipping Cost</td>
							        <td><input type="text"  name = "shippingcost" id="shippingcost" placeholder="Shipping cost" class="span4" required="required" title="must be in rupees and numeric"/>
							        </td>
							      </tr>
							      <tr>
							        <td>Brand</td>
							        <td><input type="text"  name = "brand" id="brand" placeholder="Brand" class="span4" title="brand must be string"/></td>
							      </tr>
							      <tr>
							      	<td>Type</td>
							        <td><input type="text"  name = "type" id="type" placeholder="Type" class="span4" title="type must be string"/></td>
							      </tr>
							      <tr>
							        <td>Warranty</td>
							        <td><input type="text"  name = "warranty" id="warranty" placeholder="Warranty" class="span4" title="in number of months"/></td>
							      </tr>
							      <tr>
							        <td>Expiry Date</td>
							        <td><sx:datetimepicker name = "expiry_date" displayFormat="dd/MM/yyyy" startDate="%{'today'}" value="%{'today'}"/></td>
							      </tr>
							      <tr>
							        <td>Model</td>
							        <td><input type="text"  name = "model" id="model" placeholder="Model" class="span4" title="must be string"/></td>
							      </tr>
							      <tr>
							        <td>Color</td>
							        <td><select name = "color" id="color" class="span4">
							        	<option value="white">white</option>
							        	<option value="grey">grey</option>
							        	<option value="red">red</option>
							        	<option value="pink">pink</option>
							        	<option value="orange">orange</option>
							        	<option value="green">green</option>
							        	<option value="blue">blue</option>
							        	<option value="yellow">yellow</option>
							        	<option value="brown">brown</option>
							        	<option value="black">black</option>
							        	<option value="other">other</option>
							        	<option value="NA">NA</option>
							        	</select>
							      </tr>
							      <tr>
							        <td>Size</td>
							        <td><input type="text"  name = "size" id="size" placeholder="Size" class="span4" title="in number of inches"/></td>
							      </tr>
							      <tr>
							        <td>Material</td>
							        <td><input type="text"  name = "material" id="material" placeholder="Material" class="span4" title="must be string"/></td>
							      </tr>
							       <tr>
							        <td>Picture</td>
							        <td><input type="file"
				                        tooltip="Upload Your Picture"
				                        id="picture"
				                        name="picture"
				                        required = "required"/></td>
							        <td></td>
							      </tr>
							      <s:set var="count" value="0"/>
							      <s:iterator value="specs" var="spec">
							      <tr>
							        <td><s:property value="#spec"/></td>
							      
							        <td><input type="text"  name ="att${count}" id="<s:property/>" placeholder="<s:property/>" class="span4" required="required"/></td>
							      </tr>
							      <s:set var="count" value="%{#count+1}"/>
							      </s:iterator>
							      <tr>
							        <td>Advertising Item	</td>
							        <td>	        
							        <s:radio
					                        tooltip="Select an action on the items"
					                        labelposition="inline"
					                        theme="css_xhtml"
					                        list="{'Yes','No'}"
					                        name="advt_status"
					                        cssErrorClass="foo"
					                       requiredLabel="true"/> </td>
							      </tr>
							      <tr>
							        <td id="adt_label"></div>Advertisement Detail Key</td>
							        <td><input type="text"  name = "adt_surkey" id="adt_surkey" placeholder="advertisement key" class="span4"/></td>
							      </tr>
							      <tr>
							        <td id="from_label">Start Advertising Date</td>
							        							        
							        <td id="from"><sx:datetimepicker  name="from_date" id="from_date" displayFormat="dd/MM/yyyy" startDate="%{'today'}" value="%{'today'}"/></td>
							      </tr>
							       <tr>
							        <td id="to_label">End Advertising Date</td>
							        <td id="to"><sx:datetimepicker name="to_date" id="to_date" displayFormat="dd/MM/yyyy" startDate="%{'today'}" value="%{'today'}" onchange="calcost()" /></td>
							      </tr>
							       
							       <tr>
							        <td>Deal Eligible</td>
							        <td><select name = "deal_eligible" id="deal_eligible" class="span4" required="required">
							        	<option value="Yes">Yes</option>
							        	<option value="No" selected="selected">No</option>
							        	</select>
							        </td>
							        </tr>
							    
							      <tr>
							        <td></td>
							        <td>
									<input type="submit" name="Submit" value="Submit" class="btn btn-primary" id="iadd" align="right"/>
									</td>
									<td></td>
							      </tr>
							    </tbody>
							  </table>
					
					
					
					
					
					             
					</div>        
					</form>
                </div>
               
            </div>
        </div>
    </div>
</body>

</html>
