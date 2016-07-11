<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>screen1</title>
<style type="text/css">
  	#login{
  		width:50%;
  		margin:auto;
  		margin-top:40px;
  	}
  	#div{
  	width:50%;
  		margin:auto;
  		
  		
  	}
  </style>
</head>
<body>

<nav class="navbar navbar-default" style="margin-bottom: 0px;border:solid;background-color:cyan">
 		 <div class="container-fluid" id="div">
   			<p align="center" style="margin-left:500px"><h3>Student Name:Sathya     Roll no:MT2015087     </h3></p>

  		</div>
	</nav>

<div id="login">
		<form name="login" method="post" action="selleridaction" id="login">
        <table>
            <tr>
                <td class="f1_label"><strong><h3>(Enter)brand<h3></strong></td><td><input type="text" id="brand" name="brand" placeholder="brand" required="required" />
                </td>
            </tr>
            
            <tr>
                <td>
                    <input type="submit" name="login" value="submit" style="font-size:18px; " />
                </td>
            </tr>
        </table>
    </form> 
	</div>

</body>
</html>