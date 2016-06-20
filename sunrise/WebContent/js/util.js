$(document).ready(function() {
	    window.Graphs = {
	        elemento: "",
	        opciones: {},
	        getContext: function(Element) {
	            elemento = $(Element);
	            return this;
	        },
	        options: function(config) {
	            opciones = config;
	            return this;
	        },
	        toChart: function() {
	            return new Chart(elemento, opciones);
	        }
	    }

});
