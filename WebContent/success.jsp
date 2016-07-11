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

    <title>About - Business Casual - Start Bootstrap Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/business-casual.css" rel="stylesheet">
	 
	 <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Fonts -->
   <link href="css/fonts1.css" rel="stylesheet" type="text/css">
    <link href="css/fonts2.css" rel="stylesheet" type="text/css">
    <style >
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
	.dropdown-menu{
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

    <div class="brand">eBay</div>
   <div class="address-bar">(Model for part of eBay by DARK EXECUTERS )</div>

    <!-- Navigation -->
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
                <a class="navbar-brand" href="index.html">Business Casual</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
               <ul class="nav navbar-nav">
                   <li>
                        <a href="welcome.action">Home</a>
                    </li>
                    <li class="dropdown">
					<s:set var="size" value="categories.size()"/>
					<s:set var="rows" value="categories.size()/3"/>
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true">Shop by Category<span class="caret"></span></a>
					<table class="dropdown-menu">
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
                        <a href="dropdownItemManagement.action">Item Management</a>
                    </li>
                   	<li>
                        <a href="dropdownRegistration.action">Registration</a>
                    </li>
                    <li>
                        <a href="dropdownLogin.action">Login</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <div class="container">

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">Success _Seller</strong>
                     Welcome, <s:property value="#session.name"/>  
                    </h2>
                    <hr>
                </div>
                <div class="col-md-6">
                    <img class="img-responsive img-border-left" src="img/slide-2.jpg" alt="">
                </div>
                <div class="col-md-6">
                		
              <s:form  theme="bootstrap" cssClass="form-horizontal">
                    
					 <div class="well" align="left"> 
					 
					<h1>Seller Registered !!</h1> 
				</div>        
				</s:form>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
	<div>
	<ul class="pager">
    <li><a href="#">Previous</a></li>
    <li><a href="#">Next</a></li>
  </ul>
	</div>
   
    </div>
    <!-- /.container -->

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Copyright &copy; Your Website 2014</p>
                </div>
            </div>
        </div>
    </footer>

   

</body>

</html>
