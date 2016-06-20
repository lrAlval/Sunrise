<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../libs/main/css/jquery-ui-1.10.3.custom.css">
    <link rel="stylesheet" type="text/css" href="../libs/main/css/metro/crimson/jtable.min.css">
    <script src="../libs/main/js/jquery-2.2.4.min.js"></script>
    <script src="../libs/main/js/jquery-ui-1.10.3.custom.js"></script>
    <script src="../libs/main/js/jquery.jtable.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../libs/main/css/bootstrap.min.css">
</head>
<body>

	<script type="text/javascript">
	
	 $(document).ready(function () {
			     $('.tEmpleados').jtable({
			            title: 'Empleados',
			            paging:true,
			            pageSize: 10,
			            defaultSorting: 'Value desc',
			            sorting :true,
			            actions: {
			            	listAction:   '../CEmpleado?action=list&relacion=Padre',
			                createAction: '../CEmpleado?action=create',
			                updateAction: '../CEmpleado?action=update',
			                deleteAction: '../CEmpleado?action=delete'
			            },
			            
			            
			            fields: {
			            	Value: {
			                	title:'Empleado',
			                    key: true,
			                    list:false
			                    
			                },
			                DisplayText: {
			                    title: 'Nombre',
			                    width: '10%',   
			                    edit:true
			                },
			                Apellido: {
			                    title: 'Apellido',
			                    width: '10%', 
			                    edit:true
			                },
			                Cargo: {
			                	title: 'Cargo',
			                    width: '10%',			                    
			                    edit:true
			                },
			                login: {
			                	title: 'Login',
			                    width: '10%',			                    
			                    edit:true
			                },
			                pass: {
			                	title: 'Password',
			                    width: '10%',	
			                    type: 'password',
			                    edit: true,
			                    list: false
			                },
			                idPregunta: {
			                	title: 'Pregunta',
			                    width: '20%',	
			                    options: '../CPreguntas?action=list&relacion=Hijo',
			                    edit:true
			                },
			                respuesta: {
			                	title: 'Respuesta',
			                    width: '10%',	
			                    edit:true
			                },
			                idEstado: {
			                    title: 'Estado',
			                    width: '10%',
			                    options: '../CEmpleadoEstado?action=list&relacion=Hijo',
			                    edit: true
			                }

			            }
			        });
			     
			     	/*$('.tEmpleados').click(function fun(e) {
			     		e.preventDefault();
			     		 $('.tEmpleados').jtable('load', {
			                 name: $('DisplayText').val()
			             });
					}),*/
			     
			        $('.tEmpleados').jtable('load');
	        
	        
	       
	});
   
	
   </script>
			

		<div class="tEmpleados"></div>


</body>
</html>