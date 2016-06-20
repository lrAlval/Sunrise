<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%! @SuppressWarnings("unchecked") %>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--Responsive Css-->
<link rel="stylesheet" type="text/css" href="../css/reset.css">
<!--<link rel="stylesheet" type="text/css" href="../css/queries.css">-->
<!-- Loading Libs -->
<link rel="stylesheet" type="text/css"
	href="../libs/main/css/animate.min.css">
<link rel="stylesheet" type="text/css"
	href="../libs/main/css/ionicons.min.css">
<link rel="stylesheet" type="text/css"
	href="../libs/main/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/Admin.css">
<link rel="stylesheet" type="text/css" href="../css/responsiveTabs.css">
</head>

<body>
	<c:if test="${sessionScope.usuario != null}">
		<div class="header">
			<h2>Armando Paredez</h2>
			<h3 style="font-size: 20px;">Bienvenido, Vea un resumen de datos</h3>

			<center>
				<ul id="MainTabs" class="nav nav-tabs nav-tabs-responsive">
					<li class="active"><a data-toggle="tab" href="#home"> <span
							class="text">Resumen</span>
					</a></li>
					<li class="next"><a data-toggle="tab" href="#res"> <span
							class="text">Reservas</span>
					</a></li>
					<li><a data-toggle="tab" href="#emps"> <span class="text">Empleados</span>
					</a></li>
					<li><a data-toggle="tab" href="#habs"> <span class="text">Ganancias</span>
					</a></li>
				</ul>
			</center>
		</div>
		<div class="WrapperMainTabs">
			<div class="tab-content MainTabs">
				<div id="home" class="tab-pane fade in active">
					<div class="container-fluid">
						<div class="row">
							<div class="col-lg-12">
								<div class="infoCard" style="height: 300px; width: inherit;">
									<canvas id="ResupagporMes" height="300"></canvas>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-lg-12">
								<div class="infoCard" style="height: 300px; width: inherit;">
									<canvas id="ResuresporMes" height="300"></canvas>
								</div>
							</div>
						</div>


					</div>
					<!--End Div container-fluid-->
				</div>
				<div id="res" class="tab-pane fade">
					<div class="container-fluid">
						<div class="row">
							<div class="col-lg-12">
								<div class="infoCard" style="height: 300px; width: inherit;">
									<canvas id="resporMes"></canvas>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 ">
								<div class="infoCard ">
									<div class="header-card">
										<i class="ion-bookmark" style="font-size: 40px;"></i>
										<h4>Nro Total de Reservas</h4>
									</div>
									<div class="body-card">120</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 ">
								<div class="infoCard ">
									<div class="header-card">
										<i class="ion-android-people" style="font-size: 40px;"></i>
										<h4>Empleado con Mas Reservas</h4>
									</div>
									<div class="body-card">Pedro el Mono</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 ">
								<div class="infoCard ">
									<div class="header-card">
										<i class="ion-person" style="font-size: 40px;"></i>
										<h4>Cliente Con mas Reservas</h4>
									</div>
									<div class="body-card">Paul Vaso</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 ">
								<div class="infoCard ">
									<div class="header-card">
										<i class="ion-android-menu" style="font-size: 40px;"></i>
										<h4>Habitacion con Mas Reservas</h4>
									</div>
									<div class="body-card">106</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 ">
								<div class="infoCard ">
									<div class="header-card">
										<i class="ion-ios-people" style="font-size: 40px;"></i>
										<h4>Mes con mas Reservas</h4>
									</div>
									<div class="body-card">Julio</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 ">
								<div class="infoCard ">
									<div class="header-card">
										<i class="ion-ios-people" style="font-size: 40px;"></i>
										<h4>Mes con Menos Reservas</h4>
									</div>
									<div class="body-card">Marzo</div>
								</div>
							</div>
						</div>
						<!--End Row-->
					</div>
					<!--End Div container-fluid-->
				</div>
				<!--End Tab Pane-->
				<div id="emps" class="tab-pane fade">
					<div class="container-fluid">
						<div class="row">
							<div class="col-lg-12">
								<div class="infoCard" style="height: 300px;">
									<canvas id="empporMes" height="300"></canvas>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 ">
								<div class="infoCard ">
									<div class="header-card">
										<i class="ion-bookmark" style="font-size: 40px;"></i>
										<h4>Nro Total de Reservas</h4>
									</div>
									<div class="body-card">120</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 ">
								<div class="infoCard ">
									<div class="header-card">
										<i class="ion-android-people" style="font-size: 40px;"></i>
										<h4>Empleado con Mas Reservas</h4>
									</div>
									<div class="body-card">Pedro el Mono</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 ">
								<div class="infoCard ">
									<div class="header-card">
										<i class="ion-person" style="font-size: 40px;"></i>
										<h4>Cliente Con mas Reservas</h4>
									</div>
									<div class="body-card">Paul Vaso</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 ">
								<div class="infoCard ">
									<div class="header-card">
										<i class="ion-android-menu" style="font-size: 40px;"></i>
										<h4>Habitacion con Mas Reservas</h4>
									</div>
									<div class="body-card">106</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 ">
								<div class="infoCard ">
									<div class="header-card">
										<i class="ion-ios-people" style="font-size: 40px;"></i>
										<h4>Mes con mas Reservas</h4>
									</div>
									<div class="body-card">Julio</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 ">
								<div class="infoCard ">
									<div class="header-card">
										<i class="ion-ios-people" style="font-size: 40px;"></i>
										<h4>Mes con Menos Reservas</h4>
									</div>
									<div class="body-card">Marzo</div>
								</div>
							</div>
						</div>
						<!--End Row-->
					</div>
					<!--End Div container-fluid-->
				</div>
				<!--End Div tab Pane-->
				<div id="habs" class="tab-pane fade">
					<div class="container-fluid">
						<div class="row">
							<div class="col-lg-12">
								<div class="infoCard" style="height: 300px; width: inherit;">
									<canvas id="pagporMes" height="300"></canvas>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 ">
								<div class="infoCard ">
									<div class="header-card">
										<i class="ion-bookmark" style="font-size: 40px;"></i>
										<h4>Total Ganancias</h4>
									</div>
									<div class="body-card">999</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 ">
								<div class="infoCard ">
									<div class="header-card">
										<i class="ion-android-people" style="font-size: 40px;"></i>
										<h4>Mejor Empleado</h4>
									</div>
									<div class="body-card">Pedro el Mono</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 ">
								<div class="infoCard ">
									<div class="header-card">
										<i class="ion-person" style="font-size: 40px;"></i>
										<h4>Mejor Cliente</h4>
									</div>
									<div class="body-card">Paul Vaso</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 ">
								<div class="infoCard ">
									<div class="header-card">
										<i class="ion-android-menu" style="font-size: 40px;"></i>
										<h4>Habitacion Mas Usada</h4>
									</div>
									<div class="body-card">106</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 ">
								<div class="infoCard ">
									<div class="header-card">
										<i class="ion-ios-people" style="font-size: 40px;"></i>
										<h4>Mejor Mes</h4>
									</div>
									<div class="body-card">Febrero</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 ">
								<div class="infoCard ">
									<div class="header-card">
										<i class="ion-ios-people" style="font-size: 40px;"></i>
										<h4>Peor Mes</h4>
									</div>
									<div class="body-card">Julio</div>
								</div>
							</div>
						</div>
						<!--End Row-->
					</div>
					<!--End Div container-fluid-->
				</div>
				<!--End Div tab Pane-->
			</div>
		</div>
		<script src="../libs/main/js/jquery-2.2.4.min.js"></script>
		<script src="../libs/main/js/bootstrap.min.js"></script>
		<script src="../libs/main/js/axios.min.js"></script>
		<script src="../libs/main/js/underscore-min.js"></script>
		<script src="../js/util.js"></script>
		<script src="../js/Admin.js"></script>
		<script src="../js/responsiveTabs.js"></script>
		<script src="../libs/main/js/chartjs.min.js"></script>
	</c:if>
	<c:if test="${sessionScope.usuario == null}">
		<h1>Ahorita no joven , logueese</h1>
	</c:if>
</body>

</html>
