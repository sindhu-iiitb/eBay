
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>SignUp & Login</title>
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <script src="js/jquery-1.10.2.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/jquery.validate.js"></script>

  <style type="text/css">
    #logo{
      width: 10%;
          margin: auto;
         
    }
    #tabs{
      width: 30%;
          margin: auto;
          border: 1px groove gray;
           border-radius: 8px;
    }
    #email,#remail,#pass,#fname,#bot,#emailruser,#lpass{
        width: 95%;
        margin-top: 10px;
        margin-right: 10px;
        margin-bottom: 10px;
        margin-left: 10px;
    }
    #id1{
      width: 45%;
      display: inline;
        float: left;
    }
    #id1 input{
      width: 95%;
      margin-left: 10px;
      margin-right: 5px;
    }
    #id2{
      width: 50%;
      display: block;
        margin-top: 0px;
        margin-right: 5px;
        margin-bottom: 10px;
        margin-left: 10px;
        float: left;
    }
    #check{
      margin-top: 15px;
      margin-left: 10px;
    }
    #tab1,#tab2{
      width: 50%;
    }
    #tab1 a,#tab2 a{
      text-align: center;
    }
    #check1{
      color:green;
    }
    #check1:hover{
      color: blue;
    }
    #para,#lpara{
      margin-left: 10px;
      margin-right: 10px;
      margin-top: 15px;
      line-height: 15px
    }
    #sm1,#sm2{
      color: blue;
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
    #want{
      width: 95%;
      margin-top: 10px;
        margin-right: 10px;
        margin-bottom: 10px;
        margin-left: 10px;
        border-top: groove;
        border-color: rgb(0,255,255)
        margin-top: 10px;
    }
    body{
      border-color: #D8BFD8;
    }
  </style>

  <script>
  
  
  
  
  $(function() {
    $( "#tabs" ).tabs();
  });
  function checkemail(obj){
		$.getJSON('emailcheckAction',{'email_first': obj.value}, function(data) {
			
		  if(data.username!=null){
				alert("Email ID already exists!");
				return false;
		  }
		});
}
  
  $(document).ready(function() {
	  $('#remail').focusout(function(){
		  var reemail = $(this).val();
		  var email = $('#email').val();
		  console.log(email);
		  console.log(reemail);
		  if(reemail != email){
			  alert("please enter same emailId");
			  $(this).val("");
	  }
	  });
  });
 
  
  </script>
</head>
<body>
<div id="logo">

<img src="image/eBay-India.jpg"/></div>

<div class="container" id="logo1">
   
<div class="form" id="tabs">
  <ul class="nav nav-tabs" id="myTabs" role="tab-list">
          
            <li class="active" id="tab1"><a data-toggle="tab" href="#signup"><span class="glyphicon glyphicon-circle-arrow-right">Sign Up</a></li>
          
            <li id="tab2"><a data-toggle="tab"  href="#login">  Log In</a></li>
          
          </ul>
  <div id="signup" class="tab-pane fade in active" style="display:inline">
      
      <form action="registeraction" method="post" name="myForm" onsubmit="return myFunction()" id="registrationForm">
      
              <input type="text" id="email" name="email_first" placeholder="Email" onchange="checkemail(this)" required="required"/> 
      
              <input type="text" id="remail" name="email_confirm" placeholder="Reenter Email" required="required" onchange="duplicatecheck()"/>  
      
              <input type="password" id="pass" name="password" placeholder="Password" required="required"/> 
      
              <div id="id1">
      
                <input type="text"  name="fname" placeholder="First name" required="required"/>
      
              </div >
      
              <input type="text" id="id2" name="lname" placeholder="Last name" required="required"/>
      
            <input type="checkbox" id="check" required="required"/>
      
            <label for="check" id="check1"><a href="#" style="text-decoration: none"><small>Receive exclusive offers and promotions from eBay</small></label>
            
            <p id="para">
            
              <small>By clicking <strong>Register</strong>, you agree that you have read and accepted the </small>
            
              <small id="sm1">eBay User Agreement, Paisapay User Agreement, eBay Rules and Policies</small>
            
               <small>and</small>
            
             <small id="sm2"> User Privacy Notice</small><small> and that you are at least 18 years old</small>.</p>
            
              <button type="submit" id="but" class="button button-block"/><strong>Register</strong></button>
            
              <p id="want"><strong style="margin-top:15px">WANT TO JOIN AS A BUSINESS?</strong></p>
            
              <a href="#" id="bot" style="text-decoration:none"><strong>Register for a buisiness account</strong></a>
          
           </form>
    </div>
  <div id="login" style="display:inline" class="tab-pane fade in active">   
        
          <form action="login" method="post">
         
         <input type="text" id="emailruser" name="email_user" placeholder="Email" required="required"/> 
    
          	<input type="password" id="lpass" name="password" placeholder="Password" required="required"/> 
    
           <button type="submit" id="lbut" class="button button-block"/><strong>Sign In</strong></button>
    
           <div style="display:inline">
    
           	 <input type="checkbox"  style="float:left;margin-left:10px" ><small>Stay signed in</small>
    
           	 <a href="#" style="float:right;text-decoration:none;color:blue;margin-right:10px"><small>Forgot your password?</small></a>
    
           </div>
    
           <p id="lpara"><small >Using a public or shared device? Uncheck to protect your account.<a href="#" style="text-decoration:none;color:blue">Learn more</small></small></p>
    
          </form>

        </div>
</div>
 
 </div>
</body>
</html>