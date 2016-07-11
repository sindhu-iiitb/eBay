<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<script type="text/javascript">
   $(document).ready(function() {
	   $("#sellerdetailsform").validate({
		   
		 rules:{
			 line1 :"required",
			 city: "required",
			 state: "required",
			 pincode: "required",
			 mobile: "required",
			 
			
		 },  
	   messages:{
			line1 :"compulsory",
			 
			pincode :"Enter pincode",
			 mobile : "Enter mobile"
		 }
		
		   
		   
	   });

});
</script>
<div class="row" align="center" style="color:white;"><h3>Fill Address Details</h3></div>
 <div class="row col-sm-6 col-sm-offset-3 " id="division">	     
  <h2>Welcome user, <s:property value="#session.user"/> </h2>            		
                    <form action="changeAddress"  theme="bootstrap" cssClass="form-horizontal" id="changeAddress" nonvalidate="nonvalidate">
					 <div class="well" align="left"> 
					 	<table class="table">
							    <tbody>
							      <tr>
							        <td>Line 1</td>
							        <td><input type="text" id="line1" name="line1" placeholder="line1(required)" class="span4"  required="required"/> </td>
							        <td></td>
							      </tr>
							        <tr>
							        <td> Line 2</td>
							        <td><input type="text" id="line2" name="line2" placeholder="line2(optional)" class="span4" required="required"/></td>
							        <td></td>
							      </tr>
							     
							        <tr>
							        <td> City</td>
							        <td><input type="text" id="city" name="city" placeholder="City" class="span4" required="required"/></td>
							        <td></td>
							      </tr>
							      <tr>
							        <td>State</td>
							        <td><input type="text" id="state"  name = "state" placeholder="state" class="span4" required="required"/> </td>
							        <td></td>
							      </tr>
							      <tr>
							        <td> Pincode</td>
							        <td><input type="text" id="pincode" name = "pincode" placeholder="pincode"  required="required"/></td>
							        <td></td>
							      </tr>
							      <tr>
							        <td> Mobile</td>
							        <td><input type="text" id="mobile" name = "mobile" placeholder="mobile" required="required"/></td>
							        <td></td>
							      </tr>
							       <tr>
							        <td></td>
							        <td>
									 <input type="submit" class="btn btn-primary" value ="submit" name="continue" />
									</td>
							        <td></td>
							      </tr>
							    </tbody>
							  </table>	             
					</div>        
					</form>
					
                </div>
                