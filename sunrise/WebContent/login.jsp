<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="public/imgs/favicon-hotel.ico" sizes="192x192">
    <!--Responsive Css-->
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/queries.css">
    <!-- Just Some Font -->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
    <!-- Loading Libs -->
    <link rel="stylesheet" type="text/css" href="libs/main/css/sweetalert.min.css">
    <link rel="stylesheet" type="text/css" href="libs/main/css/select.css">
    <link rel="stylesheet" type="text/css" href="libs/main/css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="libs/main/css/ionicons.min.css">
    <link rel="stylesheet" type="text/css" href="libs/main/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    
    
    <meta name="theme-color" content="#34495E">
    <title>Welcome Sunrise</title>
</head>

<body>
 


  <center><h1>${requestScope.error}</h1></center>
    <img class="logo" src="public/imgs/logo.png">
    <center><h1 style="color: white">Sunrise</h1></center>
    <div class="WrapperLogin">
        <div class="container-fluid">
            <div class="login-form">
                  <form id="log" action="CLogin"    method="POST" role="form">
                <!-- <form id="log"    method="POST" role="form"> -->
                <input type="hidden" name="proceso" value="0">
                    <div class="col-xs-12">
                        <div class="form-group">
                            <label for="txtUser">Email address</label>
                            <input id="user" type="text" class="form-control" name="txtUser" placeholder="Usuario">
                        </div>
                    </div>
                    <div class="col-xs-12">
                        <div class="form-group">
                            <label for="txtPass">Password</label>
                            <input id="pass" type="password" class="form-control" name="txtPass" placeholder="Password">
                        </div>
                    </div>
                    <p id="ShowForgot">Olvido Su Clave ?</p>
                    <button id="SendLogin" class="btn btn-primary">  Ingresa </button>
                </form>
            </div>
        </div>
    </div>
    <div class="WrapperForgot" style="display: none;">
        <div class="container-fluid">
            <div class="forgot-form">
                <form action="CLogin" method="POST" role="form">
                    <div class="col-xs-12">
                        <div class="form-group">
                            <label for="txtUser">Usuario</label>
                            <input type="email" class="form-control" id="txtUser" placeholder="Usuario">
                        </div>
                    </div>
                    <div class="col-xs-12">
                        <div class="form-group">
                            <label for="txtNewPass">Ingrese Su Nueva Contrasena</label>
                            <input type="password" class="form-control" id="txtNewPass" placeholder="New Password">
                        </div>
                    </div>
                    <div class="col-xs-12" style="margin-bottom: 20px;">
                        <label for="preguntas">Preguntas</label>
                        <select name="preguntas" class="selectpicker form-control" >
                            <option>Mustard</option>
                            <option>Ketchup</option>
                            <option>Relish</option>
                        </select>
                    </div>
                    <p id="ShowLogin">Regresar a Login ? </p>
                    <button id="SendForgot" class="btn btn-primary">Enviar</button>
                </form>
            </div>
        </div>
    </div>
    <script src="libs/main/js/jquery-2.2.4.min.js"></script>
    <script src="libs/main/js/sweetalert.min.js"></script>
    <script src="libs/main/js/bootstrap.min.js"></script>
    <script src="libs/main/js/select.js"></script>
    
    <script src="js/Login.js"></script>
</body>

</html>
