
<!DOCTYPE html>
<%@ taglib prefix="s" uri = "/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html lang="en">
<head>
  <title>eBay</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
   <script src="js/jquery-1.10.2.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <style type="text/css">
  		.dropdown:hover .dropdown-menu {
    		display: block;
    		margin-top: 0; // remove the gap so it doesn't close
 		}
 		#lsignin{
			margin-left:15px
 		}
 		#lsignin,#ldeal,#lsells,#lcontacts,#ltrack,#lmyebay,#lregister{
 			display:inline;
 			float:left;
 			margin-top: 15px;
 			margin-left:1px;
 			margin-bottom: 0px;
 			padding-bottom: 0px;
 			padding-right: 0px;
 			margin-right: 0px;
 		}
 		#asignin{
 			margin-right:15px;
 		}
 		#adeals,#asells,#acontacts,#atrack,#amypaisa,#amyebay,#aregister{
 			margin-top: 0px;
 			padding-top: 0px;
 			margin-right:5px;
 			margin-left:5px;
 			color:black;
 		}
 		#lcart{
 			display:inline;
 			float:right;
 			margin-top:10px
 		}
 		#acart{
 			margin-right:15px;
 			margin-left:15px;
 			color:black;
 			margin-bottom: 0px;
 			padding-bottom: 0px;
 			padding-top: 10px;
 		}
 		#lmypaisa{
 			display:inline;
 			float:left;
 			margin-top: 15px;
 		}
 		#lbell{
 			margin-top: 10px;
 		}
 		#logo{
          margin-left: 40px;
          display: inline;
          float: left;
   		 }
   		 #searchInput{
   		 	width: 109%;
   		 	margin-top: 7px;
   		 	margin-right: 0px;
   		 	padding-right: 0px;
   		 }
   		 #sel1{
   		 	margin-top: 7px;
   		 	margin-left: 40px;
   		 	padding-left: 10px;
   		 	margin-right: 60px;
   		 	width:10%;
   		 	display: inline;
   		 }
   		 #search{
   		 	display: inline;
   		 	border-radius:5px; 
   		 	background-color:rgb(0,80,157);
   		 	color:white;
   		 	margin-top:7px;
   		 }
   		 #lshop{
   		 	margin-left: 0px;
   		 	padding-left: 0px;
   		 }
   		 
   		 #main{
   		 	margin-top:7px;
   		 	height:35px;
   		 	width:120%;
   		 }
   		 
   		 
   		 
   		 
   		 	.list-unstyled{
			padding-top: 10px;
    		padding-right: 10px;
    		padding-bottom: 10px;
    		padding-left: 10px;
    		width : 250px;
    		height: auto;
    		
	}
	.top{
			font-size: 15px;
			font-weight: bold;
	}
	#drop{
    		font-family: "Open Sans","Helvetica Neue",Helvetica,Arial,sans-serif;
    		 height: auto;
    		 width:  auto;
    		 max-width: 800px;
    		 max-height: 500px;
    		 overflow-x: auto;
    		 overflow-y: auto;    		
	     }
	 .cat {
	 	font-size: 15px;
	 	font-color: DarkSlateGray;
	 	align-self: top;
	 }
		     a:link {
	    color: DarkSlateGray;
	}

			/* visited link */
			a:visited {
			    color: DarkSlateGray;
			}
			
			/* mouse over link */
			a:hover {
			    color: blue;
			}
			
			/* selected link */
			a:active {
			    color: blue;
			}
  </style>
</head>
<body>
	<nav class="navbar navbar-default" style="box-shadow:10px 10px 5px #D8D8D8;margin-top:0px;margin-bottom:0px">
 	<div id="logo">
   <a href="start.action"><img src="image/ebay.jpg" /></a> 
    </div>
    <ul class="nav navbar-nav">
    	<li id="lregister"><a href="#" id="aregister"style="margin-right:0px;paddin-right:0px" >Register(seller)</a></li>

    	<li class="dropdown" id="lshop">
			
								
					<s:set var="size" value="categories.size()"/>
					<s:set var="rows" value="categories.size()/3"/>
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true">Shop by Category<span class="caret"></span></a>
					<table class="dropdown-menu" id="drop">
					<tr>
					<s:set var="count" value="0"/>
					<s:set var="size" value="categories.size()"/>
					
					<s:iterator value="categories.keySet().toArray()">		
					<td>
					<s:if test="%{#count < #size}">
					<s:iterator value="categories.keySet().toArray()" begin="%{#count}" end="%{(#count + #rows - 1) < #size?(#count + #rows - 1):(#size-1)}" var="i">
					<ul class="list-unstyled" align-self="top">
					<li class="top"><a href="#"><s:property value="#i"/></a></li>
					<s:set var="count" value="%{#count+1}"/>
					<s:iterator value="categories.get(#i)">
					<li><a href="get.action?category_Name=<s:property value="category_Name"/>"><s:property value="category_Name"/></a></li>
					</s:iterator>
					</ul>
					</s:iterator>
					</s:if>
					</td>
					</s:iterator>
					
					</tr>
					</table>
							</li>
    
	<li>
	<form class="navbar-form form-inline" role="form" style="width:120%">	
		<div class="row">		
		<div class="col-sm-6">
		<input type="text" class="form-control" placeholder="Search" id="searchInput">
		</div>
		<div class="col-sm-3">
	     	 <s:select name="category" id="main" list="categories.keySet()" headerKey="-1" headerValue="select category" /> 
      	</div>
      	<div class="col-sm-3" style="margin-left:0px">
		<button type="submit" class="btn btn-default" id="search"><strong>Search</strong></button>
		</div>
		</div>
	</form><!-- end navbar-form -->
	</li>

	<li id="litemm" style="margin-left:0px;margin-top:px"><a href="selling.action" id="aitemm" style="margin-left:40px;padding-right:0px" >Item Management</a></li>

	<li id="lreport"><a href="report.jsp" id="alogin"style="margin-right:0px;padding-right:0px" >Report</a></li>

	</ul>
 </nav>

<nav class="navbar navbar-default" style="border:none;margin-bottom:10px;margin-top:0px">
  <div class="container-fluid" style="height:5px;background-color:white">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                          
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>    
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
         <s:if test="#session.email==null">
         <li id="lsignin"><small>Hi! <a href="Registration_login.jsp">Sign In</a> or <a href="Registration_login.jsp" id="asignin">Register</a>|</small></li>
         	
        	<li id="ldeal"><small><a href="deals" id="adeals">Deals</a>|</small></li>
     <li id="lcontacts"><small><a href="discount.action" id="acontacts">Discount</a>|</small></li>
        	<li id="lsells"><small><a href="sell.action" id="asells">Sells</a>|</small></li>
        	
        
       
        	
       
        	<li id="ltrack"><small><a href="trackorders.action" id="atrack">Track My Order</a></small></li>
		 </s:if>
	 	<s:elseif test="#session.value=='admin'">
		<a class="dropdown-toggle" data-toggle="dropdown" href="#" id="lsignin"><small>Hi ! <s:property value="#session.username"/></small>|</a>
      				<ul class="dropdown-menu">
      				   <li><img src="fonts/profile.png" style="font-size:60px"><small><a href="#"><s:property value="#session.username"/></a></small></li>
       	 				
       	 				<li><a href="#">My Collections</a></li>
        				<li><a href="#">Account and settings</a></li>
        				<li><a href="logout.action">Logout</a></li>                       
      				</ul>	 
      					<li id="ldeal"><small><a href="deals" id="adeals">Deals</a>|</small></li>
     					<li id="lcontacts"><small><a href="discount.action" id="acontacts">Discount</a>|</small></li>
        	<li id="lsells"><small><a href="sell.action" id="asells">Sells</a>|</small></li>
        
       
        	
       
        	<li id="ltrack"><small><a href="adminhome.action" id="atrack">Admin Mangement</a></small></li>
		 </s:elseif> 
		 <s:else >
		<a class="dropdown-toggle" data-toggle="dropdown" href="#" id="lsignin"><small>Hi ! <s:property value="#session.username"/></small>|</a>
      				<ul class="dropdown-menu">
      				   <li><img src="fonts/profile.png" style="font-size:60px"><small><a href="#"><s:property value="#session.username"/></a></small></li>
       	 			   <li><a href="updateuser1.action">Update Info</a></li>
       	 			 	<li><a href="viewuser1.action">View Info</a></li>
       	 				<li><a href="deleteuser1.action">Delete Account</a></li> 
        				
        				<li><a href="logout.action">Logout</a></li>                       
      				</ul>	 
      					<li id="ldeal"><small><a href="deals" id="adeals">Deals</a>|</small></li>
     					<li id="lcontacts"><small><a href="discount.action" id="acontacts">Discount</a>|</small></li>
        	<li id="lsells"><small><a href="sell.action" id="asells">Sells</a>|</small></li>
        
       
        	
       
        	<li id="ltrack"><small><a href="trackorders.action" id="atrack">Track My Order</a></small></li>
		 </s:else> 
		 <!-- 	
        	<li id="ldeal"><small><a href="#" id="adeals">Deals</a>|</small></li>
     
        	<li id="lsells"><small><a href="#" id="asells">Sells</a>|</small></li>
        
       
        	<li id="lcontacts"><small><a href="#" id="acontacts">Help & Contacts</a>|</small></li>
       
        	<li id="ltrack"><small><a href="#" id="atrack">Track My Order</a></small></li> -->
	 </ul>
	 <ul class="nav navbar-nav pull-right" style="margin-right:30px">
	 		<li id="lcart"><a href="displayCart" id="acart"><span class="glyphicon glyphicon-shopping-cart" style="font-size:15px"></span></a></li>

	 		

 			 <li style="" id="lmypaisa"><small><a href="#" id="amypaisa">My PaisaPay</a></small></li>

 			 <li class="dropdown" id="lmyebay">
     			 <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="amyebay"><small>My eBay</small></a>
      				<ul class="dropdown-menu">
       	 				<li><a href="#">Submenu 1-1</a></li>
        				<li><a href="#">Submenu 1-2</a></li>
        				<li><a href="#">Submenu 1-3</a></li>                        
      				</ul>
 			 </li>

 			 <li class="dropdown" id="lbell">
     			 <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="padding-top: 10px;"><span class="glyphicon glyphicon-bell" style="font-size:15px"></span></a>
      				<ul class="dropdown-menu">
       	 				<li><a href="#">Submenu 1-1</a></li>
        				<li><a href="#">Submenu 1-2</a></li>
        				<li><a href="#">Submenu 1-3</a></li>                        
      				</ul>
 			 </li>
	 </ul>
    </div>
  </div>
</nav>

</body>