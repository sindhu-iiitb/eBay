<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@page import="java.sql.*"%>
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
	  var datePicker = dojo.widget.byId("to");
	  dojo.event.connect(datePicker, "onValueChanged", calcost);
	  }
  function calcost(){
	 
	  var start=dojo.widget.byId("from").getValue();
	  var end=dojo.widget.byId("to").getValue();
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

  function validateform(){  
		   /*var name2=document.addattributeForm.specificattribute2.value;  
  var name3=document.addattributeForm.specificattribute3.value; */ 
  var category = document.getElementById("condition");
  var category1 = document.getElementById("color");
  var category2 = document.getElementById("deal_eligible");
  //var selectedValue = ddl.options[ddl.selectedIndex].value;
	if (category.selectedIndex==0)
	  {
	   alert("Please select  Condition");
	   return false;
	  }
  if (category1.selectedIndex==0)
	  {
	   alert("Please select Color");
	   return false;
	  }
	   
  if (category2.selectedIndex==0)
	  {
	   alert("Please select Deal");
	   return false;
	  }
	   

 
  }
  $(document).ready(function() {
	  
	  $('#adt_surkey').hide();
	  $("#adt_label").hide();
	  $("#from_label").hide();
	  $("#to_label").hide();
	  $('#from_date').hide();
	  $('#to_date').hide();
	  $('#cost_label').hide();
   	 $('#cost').hide();
	  $('input:radio[name="advt_status"]').change(
			    function(){
			        if ($(this).is(':checked') && $(this).val() == 'Yes') {
			            // append goes here
			        	$('#adt_surkey').show();
			      	  $("#adt_label").show();
			      	$('#cost_label').show();
			      	 $('#cost').show();
			      	  $("#from_label").show();
			      	  $("#to_label").show();
			      	  $('#from_date').show();
			      	  $('#to_date').show();
			      	  
			        }
			        else{
			        	$('#adt_surkey').hide();
			      	  $("#adt_label").hide();
			      	$('#cost_label').hide();
			      	 $('#cost').hide();
			      	  $("#from_label").hide();
			      	  $("#to_label").hide();
			      	  $('#from_date').hide();
			      	  $('#to_date').hide();
			      	 
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
	<ol class="breadcrumb">
  	<li><a href="#">Home</a></li>
  	<li><a href="#">Sell</a></li>
  	<li class="active">Update Item Details</li>
	</ol>
    <div class="container">

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center"><strong>Update Item Form</strong>
                    </h2>
                    <hr>
                </div>
                <div class="col-md-8">	
                    <form action="UpdateItemDetails"  theme="bootstrap"  display="block" id="additemform" nonvalidate="nonvalidate" onsubmit="return validateform()">
					 <div class="well" align="left"> 
					 <s:hidden value="%{category_Name}" name="category_Name" />
					 <s:hidden value="%{subCategory_Name}" name="subCategory_Name" />
					 <s:hidden value="%{i_surkey}" name="i_surkey" />
					 	<table class="table" border="0" >
							    
							    <tbody>
							      <tr>
							        <td>Name</td>
							        <td><input type="text"  name = "item_Name" id="item_Name" value="<s:property value="item_Name"/>" class="span4" required="required"/></td>
							        <td></td>
							      </tr>
							       
									<tr>
							        <td>Change item image</td>
							        <td>Previous Image :<s:property value="picture"/></td>
							        </tr>
							        <tr>
							        <td></td>
							        <td>
							        <input type="file"
				                        tooltip="Upload Your Picture"
				                        id="picture"
				                        name="picture"
				                        required="required"
				                        value="<s:property value="picture"/>"/></td>
							        <td></td>
							      </tr>
							      <tr>
							        <td>Item Description</td>
							        <td><input type="text"  name = "item_desc" id="item_desc" value="<s:property value="item_desc"/>" class="span4" required="required"/></td>
							        <td></td>
							      </tr>
							      <tr>
							        <td>Condition</td>
							         <td>Previous Condition :<s:property value="condition"/></td></tr><tr>
							        <td></td><td><select name = "condition" id="condition" selected="<s:property value="condition"/>" class="span4" required="required">
							        		<option value="condition">-condition-</option>
							        	<option value="old">Old</option>
							        	<option value="new">New</option>
							        	<option value="refurbished">Refurbished</option>
							        	<option value="NA">NA</option>
							        	</select>
							        </td>
							      </tr>
							      
							      <tr>
							        <td>Quantity</td>
							        <td><input type="text"  name = "quantity" id="quantity" value="<s:property value="quantity"/>" class="span4" required="required"/></td>
							      </tr>
							      <tr>
							        <td>Duration</td>
							        <td><input type="text"  name = "duration" id="duration" value="<s:property value="duration"/>" class="span4" required="required"/></td>
							      </tr>
							      <tr>
							        <td>Price</td>
							        <td><input type="text"  name = "price" id="price" value="<s:property value="price"/>" class="span4" required="required"/></td>
							      </tr>
							     	
							     	<tr>
							        <td>Weight</td>
							        <td><input type="text"  name = "weight" id="weight" value="<s:property value="weight"/>" class="span4" required="required"/></td>
							      </tr>
							     
							      <tr>
							        <td>Discount</td>
							        <td><input type="text"  name = "discount" id="discount" value="<s:property value="discount"/>" class="span4"/></td>
							      </tr>
							      <tr>
							        <td>Payment Mode</td>
							        <td><input type="text"  name = "paymentmode" id="paymentmode" value="<s:property value="paymentmode"/>" class="span4" required="required"/></td>
							      </tr>
							      <tr>
							        <td>Shipping Details</td>
							        <td><textarea name = "shippingdetails" id="shippingdetails" class="span4" required="required" rows="4" cols="50" >
							        <s:property value="shippingdetails"/>
							        </textarea></td>
							      </tr>
							      <tr>
							        <td>Handling Time</td>
							        <td><input type="text"  name = "handlingtime" id="handlingtime" value="<s:property value="handlingtime"/>" class="span4" required="required"/></td>
							      </tr>
							      <tr>
							        <td>Shipping Cost</td>
							        <td><input type="text"  name = "shippingcost" id="shippingcost" value="<s:property value="shippingcost"/>" class="span4" required="required"/>
							        </td>
							      </tr>
							      <tr>
							        <td>Brand</td>
							        <td><input type="text"  name = "brand" id="brand" value="<s:property value="brand"/>" class="span4"/></td>
							      </tr>
							      <tr>
							      	<td>Type</td>
							        <td><input type="text"  name = "type" id="type" value="<s:property value="type"/>" class="span4"/></td>
							      </tr>
							      <tr>
							        <td>Warranty</td>
							        <td><input type="text"  name = "warranty" id="warranty" value="<s:property value="warranty"/>" class="span4"/></td>
							      </tr>
							      <tr>
							        <td>Model</td>
							        <td><input type="text"  name = "model" id="model" value="<s:property value="model"/>" class="span4"/></td>
							      </tr>
							      <tr>
							        <td>Color</td>
							        <td>Previous color : <s:property value="color"/></td></tr><tr>
							       <td></td> <td><select name = "color" id="color" class="span4" value="<s:property value="color"/>">
							       		<option value="color">-color-</option>
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
							        <td><input type="text"  name = "size" id="size" value="<s:property value="size"/>" class="span4"/></td>
							      </tr>
							      <tr>
							        <td>Material</td>
							        <td><input type="text"  name = "material" id="material" value="<s:property value="material"/>" class="span4"/></td>
							      </tr>
							        <tr>
							        <td>Expiry Date</td>
							        <td><sx:datetimepicker name = "expiry_date" displayFormat="dd/MM/yyyy" startDate="%{'today'}" value="%{'today'}"/></td>
							      </tr>
							      <s:set var="count" value="0"/>
							      <s:iterator value="specs.keySet().toArray()" var="spec">
							      <tr>
							        <td><s:property value="#spec"/></td>
							      
							        <td><input type="text"  name ="att${count}" id="<s:property />" value="<s:property value="specs.get(#spec)"/>" class="span4"/></td>
							      </tr>
							      <s:set var="count" value="%{#count+1}"/>
							      </s:iterator>
							      
							      <tr>
							        <td>Advertising Item</td>
							        <td>Previous status :<s:property value="advt_status"/></td>	
							       </tr><tr>         
							        <td></td><td><s:radio
					                        tooltip="Select an action on the items"
					                        labelposition="inline"
					                        list="{'Yes','No'}"
					                        name="advt_status"
					                        theme="css_xhtml"
					                        cssErrorClass="foo"
					                       requiredLabel="true"
					                       required="required"/> </td>
							      </tr>
							      <tr>
							        <td id="adt_label">Advertisement Detail Key</td>
							        <td><input type="text"  name = "adt_surkey" id="adt_surkey" value="<s:property value="adt_surkey"/>" class="span4"/></td>
							      </tr>
							      <tr>
							      <td id="cost_label">Cost :</td>
							      <td id="cost"><s:property value="advt_cost"/></td>
							      
							      </tr>
							      <tr>
							        <td id="from_label">Start Advertising Date</td>
							        <td id="from_date"><sx:datetimepicker  name="from_date" id="from" displayFormat="dd/MM/yyyy" /></td>
							      </tr>
							       <tr>
							        <td id="to_label">End Advertising Date</td>
							        <td id="to_date"><sx:datetimepicker name = "to_date" id="to" displayFormat="dd/MM/yyyy" onchange="calcost()"/></td>
							      </tr>
							<!--        <tr>
							        <td >Deal Eligible</td>
							        <td>Previous :<s:property value="deal_eligible"/></td>
							        </tr><tr>
							       <td></td> <td><select name = "deal_eligible" id="deal_eligible" class="span4" required="required" headerValue="<s:property value="deal_eligible"/>">
							       		<option value="deal">-deal-</option>	
							        	<option value="Yes">Yes</option>
							        	<option value="No">No</option>
							        	</select>
							        </td>
							        </tr>-->
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
