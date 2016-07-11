<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
<head>
  <title>Email Change</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <style type="text/css">

 #listitems{
	
	  font-size: 100%;
	  }
	  #maindiv{
	      width:100%;
	      height:360px;
	      padding-top:10px;
	      padding-left:230px;
	      margin-left:300px;
	      border-left:300px;'
          margin: auto;
	     
	  }
	 
  </style>
  </head>
  <body>    
    <div class="row" align="center" style="color:white;"><h4>Welcome To eBay Bank</h4></div>
    <div class="row col-sm-6 col-sm-offset-3 " id="division">	    
                    <form action="emailchange"  theme="simple" cssClass="form-horizontal" id="additemform" nonvalidate="nonvalidate">
					 <div class="well" align="left"> 
					 	<table class="table">
							    <tbody>
							      <tr>
							        <td>Enter new email</td>
							        <td><input type="text"  name ="newemail" id="newemail" placeholder="new email"  class="span4" required="required"/></td>
							        <td></td>
							      </tr>
							     
						
									
									<input type="submit" name="emailchange" value="emailchange" class="btn btn-primary" align="left"/>
									</td><td/>	
									</tr>					
						</tbody>
					</table>
				</div>
			</form>
	  </div>
     <div class="col-sm-3"></div>
   </body>
</html>