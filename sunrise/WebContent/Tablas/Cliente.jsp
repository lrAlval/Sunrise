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
			     $('.tCliente').jtable({
			            title: 'Clientes',
			            paging:true,
			            pageSize: 10,
			            defaultSorting: 'Value desc',
			            sorting :true,
			            actions: {
			            	listAction:   '../CCliente?action=list&relacion=Padre',
			                createAction: '../CCliente?action=create',
			                updateAction: '../CCliente?action=update',
			                deleteAction: '../CCliente?action=delete'
			            },
			            
			            
			            fields: {
			            	Value: {
			                	title:'Cliente',
			                    key: true,
			                    list:false
			                    
			                },
			                DisplayText: {
			                    title: 'Nombre',
			                    width: '15%',   
			                    edit:true
			                },
			                Apellido: {
			                    title: 'Apellido',
			                    width: '15%', 
			                    edit:true
			                },
			                Telefono: {
			                	title: 'Telefono',
			                    width: '15%',
			                    
			                    edit:true
			                },
			                Notas: {
			                    title: 'Notas',
			                    width: '20%',
			                    edit: true
			                }

			            }
			        });
			     
			        $('.tCliente').jtable('load');
	       
	});
   
	
   </script>
			

		<div class="tCliente"></div>


</body>
</html>