$(document).ready(function() {
	
	/*
	$.getJSON("DashBoard?info=Reservas").done(function(res) {
        console.log(res)
    })
	*/
    
    
	function getPagos() {
	    return axios.get('../DashBoard?info=Pagos');
	}
	
	function getReservas() {
	    return axios.get('../DashBoard?info=Reservas');
	}
	
	function getEstadias() {
	    return axios.get('../DashBoard?info=Estadias');
	}

axios.all([getPagos(), getReservas(), getEstadias()])
		    .then(axios.spread(function(pagos, reservas, estadias) {
		    	
		    	//Pagos Stuff
		    	var Ganancias = _.pluck(pagos.data,'ImportePagar');
		    	
		    	//Reservas Stuff
		    	var CantReservas = _.pluck(reservas.data,'CantReservas');
		    	var Mes = _.pluck(reservas.data,'Mes');
		    	
		    	//Estadias Stuff
		    	var CantEstadias = _.pluck(estadias.data,'CantEstadias');
		    	var Nombres = _.pluck(estadias.data,'Nombre');
		    	
		    	

		    	
		    	
		    	

		        
		        
		    	
		    	
		        //Reservas por Mes
		        var dataReservas = {
		            //labels: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio"],
		            labels:  Mes,
		            datasets: [{
		                label: "Reservas Por Mes",
		                backgroundColor: "#f1c40f",
		                borderColor: "transparent",
		                borderWidth: 0,
		                hoverBackgroundColor: "#f39c12",
		                hoverBorderColor: "transparent",
		                //data: [65, 59, 80, 81, 56, 55, 40],
		                data: CantReservas
		                //data: res.data,
		            }]
		        };



		        var ChartReservas = Graphs
		            .getContext("#resporMes")
		            .options({
		                type: 'bar',
		                data: dataReservas,
		                options: {
		                    responsive: true,
		                    maintainAspectRatio: false
		                }
		            })
		            .toChart();




		        //Empleados con mas Estadias creadas
		        var dataEmpleados = {
		            datasets: [{
		                //data: [11, 16, 7, 3, 14],
		                data: CantEstadias,
		                backgroundColor: ["#FF6384", "#4BC0C0", "#FFCE56", "#E7E9ED", "#36A2EB"],
		                label: 'Estadias' // for legend
		            }],
		            //labels: ["Carla", "Paola", "Andrew", "Fred", "Peggy"]
		            labels: Nombres
		        };


		        var ChartEmp = Graphs
		            .getContext("#empporMes")
		            .options({
		                type: 'pie',
		                data: dataEmpleados,
		                options: {
		                    responsive: false,
		                    maintainAspectRatio: true
		                }
		            })
		            .toChart();

		        //Mes de Mas Ganancias

		        var dataPagos = {
		            labels: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio"],
		            datasets: [{
		                    label: "Ganancias Por Mes",
		                    fill: false,
		                    lineTension: 0.1,
		                    backgroundColor: "rgba(75,192,192,0.4)",
		                    borderColor: "rgba(75,192,192,1)",
		                    borderCapStyle: 'butt',
		                    borderDash: [],
		                    borderDashOffset: 0.0,
		                    borderJoinStyle: 'miter',
		                    pointBorderColor: "rgba(75,192,192,1)",
		                    pointBackgroundColor: "#fff",
		                    pointBorderWidth: 1,
		                    pointHoverRadius: 5,
		                    pointHoverBackgroundColor: "rgba(75,192,192,1)",
		                    pointHoverBorderColor: "rgba(220,220,220,1)",
		                    pointHoverBorderWidth: 2,
		                    pointRadius: 1,
		                    pointHitRadius: 10,
		                    //data: [65, 59, 80, 81, 56, 55, 40],
		                    data : Ganancias
		                }, {
		                    label: "Egresos Por Mes",
		                    fill: false,
		                    lineTension: 0.1,
		                    backgroundColor: "#e67e22",
		                    borderColor: "#e67e22",
		                    borderCapStyle: 'butt',
		                    borderDash: [],
		                    borderDashOffset: 0.0,
		                    borderJoinStyle: 'miter',
		                    pointBorderColor: "rgba(75,192,192,1)",
		                    pointBackgroundColor: "#fff",
		                    pointBorderWidth: 1,
		                    pointHoverRadius: 5,
		                    pointHoverBackgroundColor: "rgba(75,192,192,1)",
		                    pointHoverBorderColor: "rgba(220,220,220,1)",
		                    pointHoverBorderWidth: 2,
		                    pointRadius: 1,
		                    pointHitRadius: 10,
		                    data: [55, 50, 40, 31, 46, 75, 20],
		                }

		            ]
		        };




		        var ChartPagos = Graphs
		            .getContext("#pagporMes")
		            .options({
		                type: 'line',
		                data: dataPagos,
		                options: {
		                    responsive: true,
		                    maintainAspectRatio: false
		                }
		            })
		            .toChart();


		        //Loading Resume Stuff
		        var ChartPagos = Graphs
		            .getContext("#ResupagporMes")
		            .options({
		                type: 'line',
		                data: dataPagos,
		                options: {
		                    responsive: true,
		                    maintainAspectRatio: false
		                }
		            })
		            .toChart();



		        var ChartReservas = Graphs
		            .getContext("#ResuresporMes")
		            .options({
		                type: 'bar',
		                data: dataReservas,
		                options: {
		                    responsive: true,
		                    maintainAspectRatio: false
		                }
		            })
		            .toChart();

		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		        console.log(pagos.data);
		        console.log(reservas.data);
		        console.log(estadias.data);

    }));
    
    
    
    
    
    
    
    
    
    




});
