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
  .title {
    padding: 0 0 10px;
    color: #555;
    border-bottom: 1px solid #dadada;
    font-weight: bold;
    font-size: 16px;
}
/* unvisited link */
a:link {
    color: black;
}

/* mouse over link */
a:hover {
    color: hotpink;
}

	#item {
	font-family: "Times New Roman", Times, serif;
	font-size: 16px;
	}
.border {
    border-style: solid;
    border-width: 10px;
    border-color:grey;
}
  </style>
  <script>
	$(document).ready(function(){
		$('input[type=text]').each(function(){
				$(this).focusout(function(){
					 if($(this).val() > 5 || $(this).val() <  0)
						 {
						 alert("Rating should be for 5 and positive");
						 }
					 else
						 {
					 console.log($(this).attr("id"));
					$.getJSON('rateseller', {
						rate : $(this).val(),
						item_key : $(this).attr("id"),
					},function(jsonResponse) {
						//window.location="redirectdeleteUser";
					});
						 }
				});
				
			});
	});
</script>
  </head>
  <body>
  <div class="row">
  
 	
  <div class="col-sm-10">
  <div class ="border">
  	<table>
  	<tr>
  	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
  	<td><b>ItemName</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
  	<td><b>Cost</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
  	<td><b>Quantity</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
  	<td><b>Picture</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
  	</tr>
  	</table>
  
  </div>
  <s:set var="count" value="0"/>
  <s:set var="size" value="itemdetails.size()"/>
  <s:iterator value ="itemdetails">
  
      <div class="row">
           <s:if test="%{#count < #size}">
                <div class="caption">
                    <td></td> 
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<s:property value="itemdetails[#count].item_name"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="itemdetails[#count].price"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="itemdetails[#count].quantity"/>&nbsp;&nbsp;&nbsp;&nbsp; 
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<s:property value="itemdetails[#count].picture"/>" alt="Smiley face" height="96" width="96">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;RateSeller<input name = "rate" id = "<s:property value ="itemdetails[#count].i_surkey"/>" type="text" maxlength="5" size="6" placeholder="Out of 5"/>
					<button type="button">Rate</button>
					
					<!--  <a href="rateseller.action?item_key=<s:property value ="itemdetails[#count].i_surkey"/>&rate=" onclick="getInputValue(this,index);">Rate</a>-->
                    
                     <s:set var="count" value="%{#count+1}"/>
                 </div>
            </s:if>
           <!--  <script>
				  	function getInputValue(obj,index){
				  	 console.log(); 	
				     var inputValue = document.getElementsByName("rate")[index].value;
				     console.log(inputValue);
				     document.write(inputValue);
				      obj.href += inputValue;
				  	}
				</script>
				 -->
     </div>
     </s:iterator>
     
                    
     </div>
     </div>
  </body>
  </html>
  