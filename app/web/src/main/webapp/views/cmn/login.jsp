<!DOCTYPE html>
<html>
<head>

    <title>Login Yagu</title>
	<meta name="viewport" content="width=device-width,  initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" >
	<%@ include file="/views/fw/static-res.jsp"%>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,700|Merriweather:400,400italic,700italic"
          rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="resources/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" href="resources/css/style.css"/>
    <link rel="stylesheet" href="resources/css/own-style.css"/>
    <link rel="stylesheet" href="resources/css/icons.css"/>
    <link rel="stylesheet" href="resources/css/animate.min.css"/>
    <link rel="shortcut icon" href="resources/img/ico/32.png" sizes="32x32" type="image/png"/>
    <link rel="apple-touch-icon-precomposed" href="resources/img/ico/60.png" type="image/png"/>
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="resources/img/ico/72.png" type="image/png"/>
    <link rel="apple-touch-icon-precomposed" sizes="120x120" href="resources/img/ico/120.png" type="image/png"/>
    <link rel="apple-touch-icon-precomposed" sizes="152x152" href="resources/img/ico/152.png" type="image/png"/>
</head>

<body id="home">

<!-- Login modal -->
<div class="modal fade login" id="loginModal" aria-hidden="true">
  <div class="modal-dialog login">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Log in</h4>
      </div>
      <div class="modal-body">
        <div class="box">
          <div class="form loginBox">
            <form class="myform" method="post" action="login" accept-charset="UTF-8">
              <div class="form-group" >
                <label class="control-label">user name:</label>
                <br/>
                <div class="controls">
                  <input id="userName" class="form-control" type="text"
                         placeholder="Login" name="userName" required="true">
                </div>
              </div>
              <div class="form-group">
                <label class="control-label">password:</label>
                <br/>
                <div class="controls">
                  <input id="pwd" class="form-control" type="password"
                         placeholder="Password" name="pwd" required="true">
                </div>
              </div>
              <br/>
              <input class="btn btn-block" type="submit" value="Log in" >
            </form>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <div class="forgot login-footer"></span>
        </div>
      </div>
    </div>
  </div>
</div>

</div>
    <script type="text/javascript" src="resources/js/placeholders.min.js"></script>
    <script type="text/javascript" src="resources/js/wow.min.js"></script>
    <script type="text/javascript" src="resources/js/custom.js"></script>
</body>
</html>