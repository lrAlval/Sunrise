<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../libs/main/css/jquery-ui-1.10.3.custom.css">
            <link rel="stylesheet" type="text/css" href="../libs/main/css/metro/crimson/jtable.min.css">
                <script src="../libs/main/js/jquery-2.2.4.min.js"></script>
                <script src="../libs/main/js/jquery-ui-1.10.3.custom.js"></script>
                <script src="../libs/main/js/jquery.jtable.min.js"></script>
                
                
                <script type="text/javascript" src="../libs/main/js/export/tableExport.js"></script>
				<script type="text/javascript" src="../libs/main/js/export/jquery.base64.js"></script>
				

                <!--Table to PDf depencys for now
				<script src="../libs/main/js/export/sprintf.js"></script>
				<script src="../libs/main/js/export/jspdf.js"></script>
				<script src="../libs/main/js/export/base64.js"></script>
                -->
                <script src="../libs/main/js/export/jspdf.min.js"></script>
                <script src="../libs/main/js/export/jspdf.plugin.autotable.src.js"></script>
                
                <link rel="stylesheet" type="text/css" href="../libs/main/css/bootstrap.min.css">
                
                
                </head>
                <body>
                    <script type="text/javascript">
                	$(document).ready(function() {
                	    $('.tHorasEmpleado').jtable({
                	        title: 'Info Empleados',
                	        toolbar: {
                	            items: [{
                	                    icon: '../public/icos/excel.png',
                	                    text: 'Export to Excel',
                	                    click: function() {
                	                        $('table').tableExport({
                	                            type: 'excel',
                	                            escape: 'false'
                	                        });
                                        }
                	                },  
                                    {
                	                    icon: '../public/icos/pdf.png', 
                	                    text: 'Export to Pdf',
                	                    click: function() {
                	                    	/*
                	                        $('table').tableExport({
                	                            type: 'pdf',escape: 'false'
                	                        });
                	                        */
                	                        

                                                var doc = new jsPDF('p', 'pt');
                                                var elem = $('table');
                                                //var res = doc.autoTableHtmlToJson(elem);
                                                
                                                var res = $('table').tableExport({type: 'json', escape: 'false' });
                                                console.log(res);
                                                doc.autoTable(res.header, res.data);
                                                doc.save("Logins de Empleados.pdf");


                                            /**/
                	                        
                	                    }
                	                }]
                	        },


                	        actions: {
                	            listAction: '../CHorasEmpleado?action=list'
                	        },
                	        /*
                	        # idActividad, idhorasEmpleados, Opcion, Accion, Fecha, Hora
                	        1, 1, Habitacion, Añadio una Habitacion, 2016-06-11, 11:25:05
                	        */
                	        fields: {
                	            idHora: {
                	                title: '',
                	                width: '5%',
                	                key: true,
                	                sorting: false,
                	                edit: false,
                	                create: false,
                	                display: function(empData) {
                	                    var $img = $('<img src="../public/icos/de1.png" height=25px width=25px title="Click Para ver Detalle" />');
                	                    $img.click(function() {
                	                        $('.tHorasEmpleado').jtable('openChildTable',
                	                            $img.closest('tr'), {
                	                                title: 'Acciones de ' + empData.record.Nombre,
                	                                actions: {
                	                                    listAction: '../CAccionPerEmpleado?action=list&idHora=' + empData.record.idHora
                	                                },
                	                                fields: {
                	                                    idActividad: {
                	                                        type: 'hidden'
                	                                    },
                	                                    idhorasEmpleados: {
                	                                        key: true,
                	                                        create: false,
                	                                        list: false
                	                                    },
                	                                    opcion: {
                	                                        title: 'Opcion',
                	                                        width: '10%'
                	                                    },
                	                                    Accion: {
                	                                        title: 'Accion',
                	                                        width: '15%'
                	                                    },
                	                                    Fecha: {
                	                                        title: 'Fecha',
                	                                        width: '10%',
                	                                        type: 'date',
                	                                        displayFormat: 'dd-mm-yy',
                	                                        create: false,
                	                                        edit: false
                	                                    },
                	                                    Hora: {
                	                                        title: 'Hora',
                	                                        width: '10%',
                	                                        create: false,
                	                                        edit: false
                	                                    }
                	                                }
                	                            },
                	                            function(data) { //opened handler
                	                                data.childTable.jtable('load');
                	                            });
                	                    });
                	                    //Return image to show on the person row
                	                    return $img;
                	                }


                	            },

                	            Nombre: {
                	                title: 'Nombre',
                	                width: '20%'

                	            },
                	            Apellido: {
                	                title: 'Apellido',
                	                width: '20%'

                	            },
                	            Fecha: {
                	                title: 'Fecha',
                	                width: '20%'

                	            },

                	            LogInHora: {
                	                title: 'Inicio Sesion',
                	                width: '20%'

                	            },

                	            LogOutHora: {
                	                title: 'Cerro Sesion',
                	                width: '30%'

                	            }

                	        }
                	    });

                                $('#Load').click(function (e) {
                                    e.preventDefault();
                                    $('.tHorasEmpleado').jtable('load', {
                                        Nombre: $('#Nombre').val()
                                    });
                                });
 
                         //Load all records when page is first shown
                        $('#Load').click();

                	});		
              
			

        </script>
        
        <div class="filtering">
            <form>
                Empleado: <input type="text" name="Nombre" id="Nombre" />
                <button type="submit" id="Load">Enviar</button>
            </form>
        </div>

        

        <div class="tHorasEmpleado"></div>
    </body>
</html>