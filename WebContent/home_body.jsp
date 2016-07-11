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
  	#col2{
  		padding: 20px;
  		padding-left: 40px;
  		border-color :gray;
  		font-size:40%;
  	}
  	#col{
  		padding: 20px;
  		
  		
  		border-color :gray;
  	}
	  #listitems{
	
	  font-size: 220%;
	  }
  </style>
</head>
<body>
  <div class="row">
  	<div class="col-sm-2" id="col2">
  		<s:set var="size" value="categories.size()"/>
					<s:set var="rows" value="categories.size()/3"/> 
					<s:set var="count" value="0"/>
					<s:set var="size" value="categories.size()"/>	
					<s:iterator value="categories.keySet().toArray()">		
					<s:if test="%{#count < #size}">
					<s:iterator value="categories.keySet().toArray()" begin="%{#count}" end="%{(#count + #rows - 1) < #size?(#count + #rows - 1):(#size-1)}" var="i">
					<ul class="list-unstyled"  align-self="top">
					<li ><strong ><a  id="listitems" href="get1.action?category_Name=<s:property value="#i"/>"><s:property value="#i"/></a></strong></li>
					<s:set var="count" value="%{#count+1}"/>
					</ul>
					</s:iterator>
					</s:if>
					
					</s:iterator>
  	</div>
  	<div class="col-sm-1">
  	</div>
    <div class="col-sm-5" id="col">
    
       <!-- Carousel
            ================================================== -->           
      <div id="myCarousel" class="carousel slide ">
                <div class="carousel-inner" >
                  		
                   
                         <s:set var="count" value="0"/>
                                <s:set var="size" value="advtitems.size()"/>
                                <s:set var="rows" value="advtitems.size()/3"/>
                       <s:iterator value="advtitems">
                         <s:if test="%{#count == 0}">
                         <div class="item active">
                         </s:if>
                         <s:else>
                         <div class="item">
                         </s:else>
                        <div class="row">
                        <s:if test="%{#count < #size}">
                        <s:iterator value = "advtitems" begin="%{#count}" end="%{(#count +2) < #size?(#count + 2):(#size-1)}">
                            <div class="col-sm-4">
                                <div class="thumbnail">
                                  <a href="getitem.action?i_surkey=<s:property value="advtitems[#count].i_surkey"/>"> <img style="width:240px;height:160px;alt="slide12" src="<s:property value="advtitems[#count].picture"/>"></a>
                                 
                                 <div class="caption">
                                 <h3>Product label</h3>   
								 
								 <p>Name :  <s:property value="advtitems[#count].item_Name"/>   </p>
								 <p>Cost :	<s:property value="advtitems[#count].price"/>  </p><br/>
										    
                                     <p> <a href="displayCart.action?item_key=<s:property value="advtitems[#count].i_surkey"/>&quantity=1" class="btn btn-default" role="button">Add to Cart</a></p>
                                  
                                  </div>
                                </div>        
                            </div>
                            <s:set var="count" value="%{#count+1}"/>
                            </s:iterator>
                               </s:if>
                            </div>
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
                 
            </div><!-- End Carousel -->  
    
    
    
    
    </div>
 <!--    <div class="col-sm-2"  >.col-sm-3</div>
    <div class="col-sm-2">.col-sm-2</div>--> 
  </div><!-- 
  <div>
  <a align="center" href="screen1.jsp" class="btn btn-default" role="button" align="right">Exam02</a>
	
  </div> -->
</body>
