<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="java.sql.*"%>
<%@page import="ebay.iiitb.DBUtil.DbConnection" %>
<html lang="en">

<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ebaySellitem</title>
 	<link rel="stylesheet" href="css/bootstrap.min.css">
  	<script src="js/jquery.min.js"></script>
  	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.validate.js"></script> 
     <script type="text/javascript">
		$(document).ready(function() {
			   $('#cat').change(function(event) {
			          var categories = $("#cat").val()[0];
			          $.getJSON('ajaxAction', {
			            categoryName : categories
			          }, function(jsonResponse) {
			            var select = $('#sub');
			            select.find('option').remove();
			            $.each(jsonResponse.categoryMap, function(key, value) {
			              $('<option>').val(value).text(value).appendTo(select);
			            });
			          });
			         })    
		
		});
	</script> 
</head>

<body>
	
	<ol class="breadcrumb">
  	<li><a href="#">Home</a></li>
  	<li><a href="#">ItemManagement</a></li>
  	<li class="active">Sell Item</li>
	</ol>
    <div class="container">

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center"><strong>Tell us what you are selling</strong>
                    </h2>
                    <hr>
                </div>
                <div class="col-md-12">
                		
                    <s:form action="SellItem"  theme="bootstrap" cssClass="form-inline" id="sellform" nonvalidate="nonvalidate">
					 <div class="well" align="left"> 
					 	<table class="table">
						<tbody>
							        <tr>
								        <td>
								        <s:updownselect size="7" theme="simple" allowSelectAll="false" name="category_Name" id="cat" list="categories.keySet()" headerKey="-1" headerValue="select category"/> 
										</td>
										<td>
										<s:updownselect theme="simple" name="subCategory_Name" id="sub" headerKey="-1" list="{'Select subcategory'}" />
										</td>
									</tr>					      
									<tr>
							        <td>
									<input type="submit" name="submit" value="submit" class="btn btn-primary" id="iadd" align="right"/>
									</td>
									</tr>
						</tbody>
						</table>           
					</div>        
					</s:form>
					
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <div>
        	<ul class="pager">
    	<li><a href=ItemManagementredirect.action>Previous</a></li>
   			 <li><a href="#">Next</a></li>
  </ul>
        </div>

    </div>
    <!-- /.container -->

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Copyright &copy; Your Website 2016</p>
                </div>
            </div>
        </div>
    </footer>

    
</body>

</html>
