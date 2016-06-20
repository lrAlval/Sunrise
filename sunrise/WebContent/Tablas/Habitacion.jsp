<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../libs/main/css/jquery-ui-1.10.3.custom.css">
    <link rel="stylesheet" type="text/css" href="../libs/main/css/metro/crimson/jtable.min.css">
    <script src="../libs/main/js/jquery-2.2.4.min.js"></script>
    <script src="../libs/main/js/jquery-ui-1.10.3.custom.js"></script>
    <script src="../libs/main/js/jquery.jtable.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../libs/main/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../css/demo.css">
</head>
<body>
			<script type="text/javascript">
			$(document).ready(function () {
						$('.tHabitaciones').jtable({
				            title: 'Habitaciones',
				            paging:true,
				            pageSize: 10,
				            defaultSorting: 'IDHab desc',
				            sorting :true,
				            actions: {
				            	listAction:   '../CHabitacion?action=list&relacion=Padre',
				                createAction: '../CHabitacion?action=create',
				                updateAction: '../CHabitacion?action=update',
				                deleteAction: '../CHabitacion?action=delete'
				            },
				            
				            
				            fields: {
				            	Value: {
				                	title:'Habitacion',
				                    key: true,
				                    list:false
				                    
				                },
				                IDHabTipo: {
				                    title: 'Tipo Habitacion',
				                    width: '15%',
				                    options: '../CHabitacionTipo?action=list',
				                    edit:true
				                },
				                IdCamaTipo: {
				                    title: 'Tipo Cama',
				                    width: '15%',
				                    options: '../CCamaTipo?action=list',
				                    edit:true
				                },
				                Precio: {
				                    title: 'Precio',
				                    width: '15%',
				                    edit: true
				                },
				                
				                IdEstado: {
				                    title: 'Estado',
				                    width: '15%',
				                    options: '../CHabitacionEstado?action=list',
				                    edit: true
				                },
				                
				                Notas: {
				                    title: 'Notas',
				                    width: '20%',
				                    edit: true,
				                    list:false
				                }

				            }
				        });
		     
		        	$('.tHabitaciones').jtable('load');

			});
			
		     
              
			
		   </script>


	
	


	   		<div class="tHabitaciones"></div>

	
</body>
</html>