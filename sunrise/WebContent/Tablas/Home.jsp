<!DOCTYPE html>
<html>
<title>Sunrise3</title>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="theme-color" content="#34495E">
    <link rel="icon" type="image/png" href="../public/imgs/favicon-hotel.ico" sizes="192x192">
    <!--Responsive Css-->
    <link rel="stylesheet" type="text/css" href="../css/reset.css">
    <link rel="stylesheet" type="text/css" href="../css/queries.css">
    <!--Styling Css -->
    <link rel="stylesheet" type="text/css" href="../css/Main.css">
    <link rel="stylesheet" type="text/css" href="../css/LeftPanel.css">
    <!-- Just Some Font -->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
    <!-- Loading Libs -->
    <link rel="stylesheet" type="text/css" href="../libs/main/css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="../libs/main/css/ionicons.min.css">
    <link rel="stylesheet" type="text/css" href="../libs/main/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../css/Folders.css">
    <!-- Jtable Dependencys -->


    <!-- Axios  -->
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="../libs/main/js/jquery-2.2.4.min.js"></script>
    <script src="../js/LeftPanel.js"></script>
    <script src="../js/Main.js"></script>
    <!--Just for testing -->
    <link rel="stylesheet" type="text/css" href="../css/demo.css">
    
    
    

</head>

<body>
    <div class="PanelUsuario" style="display: none;">
        <i class="ion-android-close" id="CloseLeftBar"></i>
        <div class="cardinfo">
            <img class="profilepic" src="../public/profile pics/pic3.png" width="200" height="200">
            <h1>Armando,30</h1>
            <div class="info">
                <div class="item1">
                    <i class="ion-home"></i>
                    <p>24</p>
                    <label>Reservas</label>
                </div>
                <div class="item2">
                    <i class="ion-clock"></i>
                    <p>200</p>
                    <label>Horas T.</label>
                </div>
                <div class="item3">
                    <i class="ion-ios-people"></i>
                    <p>5</p>
                    <label>Clientes</label>
                </div>
            </div>
        </div>
        <div class="MainFolder">
            <ul class="cd-accordion-menu animated">
                <li class="has-children">
                    <input type="checkbox" name="group-1" id="group-1" class="UXHandler">
                    <label for="group-1">Mantenimientos</label>
                    <ul>
                        <li><a href="#0">Empleados</a></li>
                        <li><a href="#0">Clientes</a></li>
                        <li><a href="Habitacion.jsp" target="MainBody">Habitacion</a></li>
                        <li class="has-children">
                            <input type="checkbox" id='sub-group-1' class="UXHandler">
                            <label for="sub-group-1">Tipos/Estados </label>
                            <ul>
                                <li><a href="#0">CamaTipo</a></li>
                                <li><a href="#0">HabitacionTipo</a></li>
                                <li><a href="#0">HabitacionEstado</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li class="has-children">
                    <input type="checkbox" name="group-2" id="group-2" class="UXHandler" checked>
                    <label for="group-2">Reportes</label>
                    <ul>
                        <li><a href="Home.jsp" style="background-color: #23B684;" >DashBoard</a></li>
                        <li><a href="#0">Reporte1</a></li>
                        <li><a href="#0">Reporte2</a></li>
                    </ul>
                </li>
                <li class="has-children">
                    <input type="checkbox" name="group-3" id="group-3" class="UXHandler">
                    <label for="group-3">Feedback</label>
                    <ul>
                        <li><a href="Contactenos.jsp">Contacto</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div class="topbarS">
        <i class="ion-navicon-round" id="OpenLeftBar"></i>
        <div class="Eles">
            <label>Armando Paredez</label>
            <i id="IconTopbar" class="ion-log-out"></i>
        </div>
    </div>


    <div class="container" style="padding-top: 100px;">
          <iframe name="MainBody" class="MainFrame" src="" frameborder="0"  ></iframe>
    </div>
</body>


  
</html>
