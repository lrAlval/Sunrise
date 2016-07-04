use sunrise;

SHOW TABLES;




SELECT * FROM camatipo;
SELECT * FROM clientes;
SELECT * FROM contacto;
SELECT * FROM empleados;
SELECT * FROM EstadoEmpleado;
SELECT * FROM habitacion;
SELECT * FROM habitacionestado;
SELECT * FROM habitaciontipo;
SELECT * FROM historial;
SELECT * FROM horasempleados;
SELECT * FROM infoempleados;
SELECT * FROM pagos;
SELECT * FROM preguntas;

SELECT * FROM reservas;





SELECT * FROM empleados;
SELECT * FROM empleados where idPregunta = 1 and respuesta = 'Boris';
SELECT * FROM preguntas;




/****************************************************************Selects for Admin Panel**************************************************************************/

SELECT COUNT(*) AS Reservas , date_format(FechaEntrada,'%M') as Mes , FechaEntrada
FROM reservas
GROUP BY idEmp,IdCliente ,MONTH(FechaEntrada) ;

-- Reservas Por Mes

SELECT DATE_FORMAT(FechaEntrada, "%m-%Y") AS Month, date_format(FechaEntrada,'%M') as  Mes, COUNT(*) as CantReservas
FROM reservas
GROUP BY DATE_FORMAT(FechaEntrada, "%m-%Y") ;


SELECT COUNT(*) as CantReservas
FROM reservas
GROUP BY DATE_FORMAT(FechaEntrada, "%m-%Y") ;



SELECT * FROM historial;


SELECT count(*) as CantEstadias , e.Nombre , h.FechaEstadia
FROM historial as h
join empleados as e
on h.idEmp = e.idEmp
GROUP BY h.idEmp;



SELECT ImportePagar ,  date_format(FechaPago,'%M')
FROM pagos 
limit 7;




/****************************************************************End Selects for Admin Panel**************************************************************************/




SELECT ImportePagar FROM PAGOS  limit 7 ;

-- DESCRIBE camatipo;  
-- DESCRIBE clientes;
-- DESCRIBE contacto;
-- DESCRIBE empleados;
-- DESCRIBE EstadoEmpleado;
-- DESCRIBE habitacion;
-- DESCRIBE habitacionestado;
-- DESCRIBE habitaciontipo;
DESCRIBE historial;
-- DESCRIBE horasempleados;
-- DESCRIBE infoempleados;
DESCRIBE pagos;
-- DESCRIBE preguntas;
-- DESCRIBE reservas;

/*************************************************************************************************************************************/
-- Get Number de Reservas Per Employee
SELECT count(IdReserva) as empsres
FROM reservas as r  
where r.IdEmp = 5;




-- Get Number of Clients per Employee

SELECT count(IdCliente)
from Clientes
where idEmp = 5;

-- Get Number of Hours per Employee


SELECT
   e.Nombre , e.Apellido ,DATE_FORMAT( SEC_TO_TIME(SUM(TIME_TO_SEC(h.LogOutHora) - TIME_TO_SEC(h.LogInHora)) ) ,'%h:%i') AS Horas      
FROM horasEmpleados as h 
JOIN Empleados as e   on h.idEmp = e.idEmp  
where h.idEmp = 5
GROUP BY h.idEmp;

/*************************************************************************************************************************************/



SELECT * FROM empleados where idEstado not in(3,2);
SELECT * FROM CLIENTES;



SELECT   H.IDHab , H.IDHabTipo , H.IdCamaTipo , H.Precio , H.IdEstado ,  T.Notas 
FROM habitacion AS H 
INNER JOIN HabitacionTipo as T 
on h.IDHabTipo = T.IDHabTipo ;
-- GROUP BY T.Notas;





SELECT * FROM empleados LIMIT 10 OFFSET 0 ;

select Count(*) from empleados;






SELECT * FROM empleados;
SELECT * FROM horasempleados;
SELECT * FROM infoempleados order by idActividad desc;







call sp_GetHorasEmpleadoss('p');


call sp_infoPerEmpleado(17);


call sp_GetHorasEmpleado(5);


call sp_GetHorasEmpleados







