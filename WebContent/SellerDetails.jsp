<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SELLER DETAILS</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/business-casual.css" rel="stylesheet">
    
     <!-- jQuery -->
    <script src="js/jquery.js"></script>
	<script src="js/jquery.validate.js"></script>
   
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    
<style type="text/css">
#division{
width: 60%;
margin: auto;
margin-left: 300px;
height: 250%;
}

</style>
</head>
<body>


<script type="text/javascript">
function validateform(){  
	var pincode=document.sellerdetailsform.pincode.value;  
	var mobile=document.sellerdetailsform.mobile.value;  
	  
	if(pincode.length!=6)  {
		alert("enter pincode of length 6");
		return false;  
	}
	if(mobile.length!=10){
		alert("enter mobile of length 10");
		return false;  
	}
	
	}
</script>
 <div id="division">
 
 <h2>Welcome user, <s:property value="#session.email"/> </h2> 
 
                    <form action="sellerdetails"   name="sellerdetailsform" class="form-horizontal" onsubmit="return validateform()" >
					 <div class="well" align="left"> 
					 	<table class="table">
							    
							    <tbody>
							      <tr>
							        <td>Seller id</td>
							        <td><input type="text" id="sellerid" name="sellerid"  required="required"/> </td>
							        <td></td>
							      </tr>
							      <tr>
							        <td>Seller shop</td>
							        <td><input type="text" id="sellershop" name="sellershop" required="required"  /> </td>
							        <td></td>
							      </tr>
							      <tr>
							        <td>nature_of_business</td>
							        <td><input type="text" id="nature" name="nature"/> </td>
							        <td></td>
							      </tr>
							      <tr>
							        <td>Address Line 1</td>
							        <td><input type="text" id="line1" name="line1" required="required"/> </td>
							        <td></td>
							      </tr>
							        <tr>
							        <td>Address  Line 2</td>
							        <td><input type="text" id="line2" name="line2"  /></td>
							        <td></td>
							      </tr>
							      </tr>
							        <tr>
							        <td> City</td>
							        <td><input type="text" id="city" name="city" required="required"/></td>
							        <td></td>
							      </tr>
							      <tr>
							        <td>State</td>
							        <td><input type="text" id="state"  name = "state" class="span4" required="required"/> </td>
							        <td></td>
							      </tr>
							      <tr>
							        <td> Pincode</td>
							        <td><input type="text" id="pincode" name = "pincode" required="required" /></td>
							        <td></td>
							      </tr>
							      <tr>
							        <td> Mobile</td>
							        <td><input type="text" id="mobile" name = "mobile" required="required"/></td>
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
					
                </div>
</body>
</html>