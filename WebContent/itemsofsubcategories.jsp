<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <style type="text/css">
  #myCarousel .thumbnail {
	margin-bottom: 0;
}
.carousel-control.left, .carousel-control.right {
	background-image:none !important;
}
.carousel-control {
	color:#fff;
	top:40%;
	color:#428BCA;
	bottom:auto;
	padding-top:4px;
	width:30px;
	height:30px;
	text-shadow:none;
	opacity:1;
}
.carousel-control:hover {
	color: #d9534f;
}
.carousel-control.left, .carousel-control.right {
	background-image:none !important;
}
.carousel-control.right {
	left:auto;
	right:-32px;
}
.carousel-control.left {
	right:auto;
	left:-32px;
}
.carousel-indicators {
	bottom:-30px;
}
.carousel-indicators li {
	border-radius:0;
	width:10px;
	height:10px;
	background:#ccc;
	border:1px solid #ccc;
}
.carousel-indicators .active {
	width:12px;
	height:12px;
	background:#3276b1;
	border-color:#3276b1;
}
  .box{
    line-height: 30px;
    background-color: #f0f0f0;
    border: 1px solid #ddd;
    display: block;
    padding-left: 22px;
    font-size: 16px;
}

  img {
  display: block;
  max-width:230px;
  max-height:95px;
  width: auto;
  height: auto;
}
  #label{
      font-size: 16px;
	  font-weight: bold;
      padding-left: 22px;
      line-height: 40px;
      color: #666;
    }
  #label2
  {
  	font-weight: bold;
	color: #555;
  } 
  #checkbox:hover{
  	font-weight: bold;
	color: #333;
  } 
  #rowid{
   height: 720px;
  }
  </style>
</head>
<body>
	<div class="tab-content" id="filter1">
    <div role="tabpanel" class="tab-pane active" id="Review-Order">
    <div class="container" id="rowid">
    	<div class="row" >
    		<div class="col-sm-2">
    		 <label id = label>Filter by</label><br>
    		 <div class="box">
    		 <label id = label2>Top Brands</label>
    		 </div>
    		  
  				
  			
  				<s:iterator  value="brands.toArray()" var="i">
	  				<div class="checkbox">
	  					<label><input type="checkbox" value=""><s:property value="#i"/> </label>
	  				</div>
	  		
	  	
	  			</s:iterator>
  			
  			
    		 			 <br>

			 <div class="box">
    		 <label id = label2>Operating System</label>
    		 </div>
    		 <div class="checkbox">
  				<label id =checkbox><input type="checkbox" value="">Option 1</label>
			 </div>
			 <div class="checkbox">
 				 <label id =checkbox><input type="checkbox" value="">Option 2</label>
			 </div>
			 <div class="checkbox">
 				 <label id =checkbox><input type="checkbox" value="">Option 3</label>
			 </div>
			 <div class="checkbox">
 				 <label id =checkbox><input type="checkbox" value="">Option 4</label>
			 </div>
			 <div class="checkbox">
 				 <label id =checkbox><input type="checkbox" value="">Option 5</label>
			 </div>
			  <div class="box">
    		 <label id = label2>Price Range</label>
    		 </div>
    		 <div class="checkbox">
  				<label id =checkbox><input type="checkbox" value="">Option 1</label>
			 </div>
			 <div class="checkbox">
 				 <label id =checkbox><input type="checkbox" value="">Option 2</label>
			 </div>
			 <div class="checkbox">
 				 <label id =checkbox><input type="checkbox" value="">Option 3</label>
			 </div>
			 <div class="checkbox">
 				 <label id =checkbox><input type="checkbox" value="">Option 4</label>
			 </div>
			 <div class="checkbox">
 				 <label id =checkbox><input type="checkbox" value="">Option 5</label>
			 </div>
			 </div>
			 <div class = "col-sm-10">
			 		
                     <!-- Carousel
            ================================================== -->           
      <div id="myCarousel" class="carousel slide">
                <div class="carousel-inner">
                  		
                   
                         <s:set var="count" value="0"/>
                                <s:set var="size" value="nestedsubcategory[2].size()"/>
                                <s:set var="rows" value="nestedsubcategory[2].size()/3"/>
                       <s:iterator value="nestedsubcategory[2]">
                         <s:if test="%{#count == 0}">
                         <div class="item active">
                         </s:if>
                         <s:else>
                         <div class="item">
                         </s:else>
                        <div class="row">
                        <s:if test="%{#count < #size}">
                        <s:iterator value = "nestedsubcategory[2]" begin="%{#count}" end="%{(#count +2) < #size?(#count + 2):(#size-1)}">
                            <div class="col-md-4">
                                <div class="thumbnail">
                                
                               <a href="getitem.action?i_surkey=<s:property value="nestedsubcategory[2][#count].i_surkey"/>"> <img alt="slide12" src="<s:property value="nestedsubcategory[2][#count].picture"/>"></a>
                                
                                 <div class="caption">
                                 <h3>Product label</h3>   
								 <p>Item Id : <s:property value="nestedsubcategory[2][#count].i_surkey"/>  </p>
								 <p>Name :  <s:property value="nestedsubcategory[2][#count].item_Name"/>   </p>
								 <p>Cost :	<s:property value="nestedsubcategory[2][#count].price"/>  </p><br/>
										    
                                     <p> <a href="siteunderconstructionredirect.action" class="btn btn-default" role="button">Buy</a></p>
                                  
                                  </div>
                                </div>        
                            </div>
                            <s:set var="count" value="%{#count+1}"/>
                            </s:iterator>
                        </s:if>
                            </div>
                            </s:iterator> 
                            </div>
                            </div>
                         
                           <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
		    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
                
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol> 
               
                        </div>
                    
		
      		</div>
      		
      	<!-- Carousel ================================================== -->  
      <div class = "col-sm-10">
               
      <div id="myCarousel" class="carousel slide">
                <div class="carousel-inner">
                  		
                   
                         <s:set var="count" value="0"/>
                                <s:set var="size" value="nestedsubcategory[2].size()"/>
                                <s:set var="rows" value="nestedsubcategory[2].size()/3"/>
                       <s:iterator value="nestedsubcategory[2]">
                         <s:if test="%{#count == 0}">
                         <div class="item active">
                         </s:if>
                         <s:else>
                         <div class="item">
                         </s:else>
                        <div class="row">
                        <s:if test="%{#count < #size}">
                        <s:iterator value = "nestedsubcategory[2]" begin="%{#count}" end="%{(#count +2) < #size?(#count + 2):(#size-1)}">
                            <div class="col-md-4">
                                <div class="thumbnail">
                                
                                <img alt="slide12" src="<s:property value="nestedsubcategory[2][#count].picture"/>">
                                
                                 <div class="caption">
                                 <h3>Product label</h3>   
								 <p>Item Id : <s:property value="nestedsubcategory[2][#count].i_surkey"/>  </p>
								 <p>Name :  <s:property value="nestedsubcategory[2][#count].item_Name"/>   </p>
								 <p>Cost :	<s:property value="nestedsubcategory[2][#count].price"/>  </p><br/>
										    
                                     <p> <a href="siteunderconstructionredirect.action" class="btn btn-default" role="button">Buy</a></p>
                                  
                                  </div>
                                </div>        
                            </div>
                            <s:set var="count" value="%{#count+1}"/>
                         </s:iterator>
                               </s:if>
                               </div>
                               </s:iterator> 
                            </div>
		  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
				    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				    <span class="sr-only">Next</span>
		  </a>
				                
		                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol> 
                            </div>
                         
                         
                        </div>
                    </div>
                     </div>

                </div>
                 
           <!-- End Carousel -->        
   

    		
</body>	


