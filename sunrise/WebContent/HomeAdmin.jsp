<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<title>Sunrise3</title>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="theme-color" content="#34495E">
    <link rel="icon" type="image/png" href="../public/imgs/favicon-hotel.ico" sizes="192x192">
    <!--Responsive Css-->
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/queries.css">
    <!--Styling Css -->
    <link rel="stylesheet" type="text/css" href="css/Main.css">
    <link rel="stylesheet" type="text/css" href="css/LeftPanel.css">
    <!-- Just Some Font -->
    
    <!-- Loading Libs -->
    <link rel="stylesheet" type="text/css" href="libs/main/css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="libs/main/css/ionicons.min.css">
    <link rel="stylesheet" type="text/css" href="libs/main/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/Folders.css">
    <!-- Jtable Dependencys -->
    <script src="libs/main/js/jquery-2.2.4.min.js"></script>
    <script src="js/LeftPanel.js"></script>
    <script src="js/Main.js"></script>
    <!--Just for testing -->
    <link rel="stylesheet" type="text/css" href="css/demo.css">
    
    
    <script src="libs/main/js/axios.min.js"></script>
    <script  src="libs/main/js/underscore-min.js"></script>

</head>

<body>
    <c:if test="${sessionScope.usuario != null}">
    <div class="PanelUsuario" style="display: none;">
        <i class="ion-android-close" id="CloseLeftBar"></i>
        <div class="cardinfo">
            <img class="profilepic" src='${sessionScope.profile}' width="200" height="200">
             <center><h1>${sessionScope.leftBarInfo}</h1></center>
            <div class="info">
                <div class="item1">
                    <i class="ion-home"></i>
                    <p>${sessionScope.CantReser}</p>
                    <label>Reservas</label>
                </div>
                <div class="item2">
                    <i class="ion-clock"></i>
                    <p>${sessionScope.Horas}</p>
                    <label>Horas T.</label>
                </div>
                <div class="item3">
                    <i class="ion-ios-people"></i>
                    <p>${sessionScope.CantClis}</p>
                    <label>Clientes</label>
                </div>
            </div>
        </div>
        <div class="MainFolder">
            <ul class="cd-accordion-menu animated">
                <li class="has-children">
                    <input type="checkbox" name="group-1" id="group-1" class="UXHandler">
                    <label for="group-1">Informacion</label>
                    <ul>
                        <li><a href="adm/adminInfo.jsp" target="MainBody" onclick="return closePanel();" >DashBoard</a></li>
                
                        <li class="has-children">
                            <input type="checkbox" id='sub-group-1' class="UXHandler">
                            <label for="sub-group-1">Empleados</label>
                            <ul>
                                <li><a href="#0" target="MainBody" onclick="return closePanel();">Top Estadias</a></li>
                                <li><a href="#0" target="MainBody" onclick="return closePanel();">Top Clientes</a></li>
                                <li><a href="#0" target="MainBody" onclick="return closePanel();">Top Horas</a></li>
                                <li><a href="#0" target="MainBody" onclick="return closePanel();">Top Pagos</a></li>
                                <li><a href="#0" target="MainBody" onclick="return closePanel();">Top Estadias</a></li>
                            </ul>
                        </li>

                        <li class="has-children">
                            <input type="checkbox" id='sub-group-1' class="UXHandler">
                            <label for="sub-group-1">Habitaciones</label>
                            <ul>
                                <li><a href="#0" target="MainBody" onclick="return closePanel();">Top Clientes</a></li>
                                <li><a href="#0" target="MainBody" onclick="return closePanel();">Top Habitacion</a></li>
                                <li><a href="#0" target="MainBody" onclick="return closePanel();">Top Habitacion Reservada</a></li>
                            </ul>
                        </li>


                    </ul>
                </li>
                <li class="has-children">
                    <input type="checkbox" name="group-2" id="group-2" class="UXHandler" >
                    <label for="group-2">Reportes</label>
                    <ul>
                        <li><a href="#0">Grafico 1 </a></li>
                    </ul>
                </li>


            </ul>
        </div>
    </div>
    <div class="topbarS">
        <i class="ion-navicon-round" id="OpenLeftBar"></i>
        <div class="Eles">
            <label>${sessionScope.usuario}</label>
            <a href="CLogin" style="color: white;" ><i id="IconTopbar" class="ion-log-out"></i></a>
        </div>
    </div>

    <div class="container" style="padding-top: 100px;">
          <iframe name="MainBody" class="MainFrame" src="" frameborder="0"  ></iframe>
    </div>
  </c:if>
   <c:if test="${sessionScope.usuario == null}">
     <h1>Ahorita no joven , logueese</h1>
    </c:if>
    
    
</body>


  
</html>
