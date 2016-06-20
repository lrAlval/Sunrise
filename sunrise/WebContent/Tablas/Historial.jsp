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
		  
		   

        function loadTable(){
		     $('.tHistorial').jtable({
		            title: 'Estadias',
		            paging:true,
		            pageSize: 10,
		            defaultSorting: 'IdHistorial desc',
		            sorting :true,
		            actions: {
		            	listAction:   '../CHistorial?action=list',
		                createAction: '../CHistorial?action=create',
		                updateAction: '../CHistorial?action=update',
		                deleteAction: '../CHistorial?action=delete'
		            },
		            
		            
		            fields: {
		            	IdHistorial: {
		                	title:'Historial',
		                    key: true,
		                    list:false
		                    
		                },
		                IdEmp: {
		                    title: 'Empleado',
		                    width: '15%',
		                    options: '../CEmpleado?action=list&relacion=Hijo',
		                    edit:true
		                },
		                IdCliente: {
		                    title: 'Cliente',
		                    width: '15%',
		                    options: '../CCliente?action=list&relacion=Hijo',
		                    edit:true
		                },
		                IdHabitacion: {
		                	title: 'Habitacion',
		                    width: '15%',
		                    options: '../CHabitacion?action=list&relacion=Hijo',
		                    edit:true
		                },
		                
		                FechaEstadia: {
		                	title: 'Fecha Estadia',
		                    width: '20%',
		                    type: 'date',
		                    displayFormat: 'yy-mm-dd',
		                    edit: true
		                },
		                CargoPorHabitacion: {
		                	title: 'Cargo Habitacion',
		                    width: '20%',
		                    edit: true
		                },
		                CargoPorTelefono: {
		                	title: 'Cargo Telefono',
		                    width: '40%',
		                    edit: true
		                },
		                Notas: {
		                    title: 'Notas',
		                    width: '20%',
		                    list:false,
		                    edit: true
		                }

		            }
		        });
		     
		        $('.tHistorial').jtable('load');
        }
        
        loadTable();
       
});
	
   </script>
			

		<div class="tHistorial"></div>


</body>
</html>