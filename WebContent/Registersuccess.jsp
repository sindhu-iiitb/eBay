
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Successful Registration</title>
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <script src="js/jquery-1.10.2.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/jquery.validate.js"></script>

  <style type="text/css">
    #logo{
          width: 10%;
          margin: auto;
          margin-right:600px;
    }
      #logo1{
          width: 30%;
          margin: auto;
          border-style: groove;
          border-color: gray;
          border-width: 1px;
    }
      #but,#lbut{
      width: 95%;
        margin-top: 10px;
        margin-right: 10px;
        margin-bottom: 10px;
        margin-left: 10px;
        background-color:rgb(0, 80, 157);
        border-color: none;
        border-radius: 8px;
        color: white;
        height: 40px;
    }

  </style>

  <script>
  $(function() {
    $( "#tabs" ).tabs();
  });
  
  </script>
</head>
<body>
<div id="logo">

<img src="image/eBay-India.jpg"/>

</div>
<div class="container" id="logo1"> 
<br>
<div class="container" >
 <strong style="font-size:20px; color:rgb(0, 204, 0)"><span class="glyphicon glyphicon-ok-circle" style="font-size:50px ;color:rgb(0, 204, 0); float:left; margin-bottom:10px;margin-top:10px"></span>
 <strong style="margin-top:40px"> Welcome to eBay  <s:property value="fname"/>! </strong></strong><br><br>
 <strong style="font-size:10px;" >We've created a unique username for you:<s:property value="username"/> </strong>
 </div>
 <div class="container" >
 <form action="loginafterregister">
 <input type="hidden" name="username" value="<s:property value="username"/>"></input>
 <button type="submit" id="but" class="button button-block" style="width:25%"><strong>Continue</strong></button>
 </form> 
</div>
</div>
</body>
</html>