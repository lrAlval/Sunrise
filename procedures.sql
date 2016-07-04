use sunrise;

DROP PROCEDURE IF EXISTS sp_GetHorasEmpleados;

-- Get Login  Info Empleados 
DELIMiTER $$
create procedure sp_GetHorasEmpleados(NomExcp varchar(80))
begin

SELECT  h.idHora, e.Nombre , e.Apellido ,  Fecha , DATE_FORMAT(h.LogInHora,'%r') as LogInHora , DATE_FORMAT(h.LogInHora,'%r') as LogOutHora 
FROM horasEmpleados as h JOIN Empleados as e
on h.idEmp = e.idEmp
where e.Nombre != NomExcp;


end$$
DELIMiTER ;


DROP PROCEDURE IF EXISTS sp_GetHorasEmpleadoss;

-- Get Login  Info Empleados 
DELIMiTER $$
create procedure sp_GetHorasEmpleadoss(nom varchar(80),NomExcp varchar(80))
begin

-- SELECT  h.idHora, e.Nombre , e.Apellido ,  DATE_FORMAT( h.Fecha,'%d-%m-%Y') AS Fecha , h.LogInHora , h.LogOutHora  
SELECT  h.idHora, e.Nombre , e.Apellido ,  Fecha , h.LogInHora , h.LogOutHora  
FROM horasEmpleados as h JOIN Empleados as e
on h.idEmp = e.idEmp
where e.Nombre LIKE CONCAT('%', nom ,'%') and e.Nombre != NomExcp;


end$$
DELIMiTER ;


/*****************************Procedure para la busqueda de la tabla cliente***************************************/



DROP PROCEDURE IF EXISTS sp_BusquedaClientes; 


DELIMiTER $$
create procedure sp_BusquedaClientes(nom varchar(80),recordsPerPage int ,startPageIndex int)
begin
SELECT  IdCliente, Nombre, Apellido, Telefono, Notas
FROM CLIENTES
where Nombre LIKE CONCAT('%', nom ,'%') LIMIT recordsPerPage OFFSET startPageIndex;

end$$
DELIMiTER ;


call sp_BusquedaClientes('p',10,0);

/*
SELECT  COUNT(*) as cantidad
FROM CLIENTES
where Nombre LIKE CONCAT( 'p' ,'%'); 
*/

/***************************Procedure para buscar la tabla habitacion *************************************************/

DROP PROCEDURE IF EXISTS sp_BusquedaHabitacion; 


DELIMiTER $$
create procedure sp_BusquedaHabitacion(hab varchar(80),recordsPerPage int ,startPageIndex int)
begin
SELECT h.*
FROM habitacion as h join habitaciontipo as t
on h.IDHabTipo=t.IDHabTipo
where t.Notas LIKE CONCAT('%', hab ,'%') and h.idEstado not in (2,3) LIMIT recordsPerPage OFFSET startPageIndex;

end$$
DELIMiTER ;


call sp_BusquedaHabitacion('cama',10,0);

/*
select count(*) as cantidad
from habitacion as h join habitaciontipo as t
on h.IDHabTipo=t.IDHabTipo
where t.Notas like concat('cama','%');
*/

/*********************************Procedure para buscar la tabla Historial *******************************************/

DROP PROCEDURE IF EXISTS sp_BusquedaHistarial; 


DELIMiTER $$
create procedure sp_BusquedaHistarial(Emp varchar(80),recordsPerPage int ,startPageIndex int)
begin
SELECT h.*
FROM historial as h join empleados as e
on h.IdEmp=e.IdEmp
where e.Nombre LIKE CONCAT('%', Emp ,'%')  LIMIT recordsPerPage OFFSET startPageIndex;
end$$
DELIMiTER ;


call sp_BusquedaHistarial('p',10,0);

/*
select count(*) 
from historial as h join empleados as e
on h.IdEmp=e.IdEmp
where e.Nombre like concat('p','%');
*/

/*********************************Procedure para buscar la tabla pagos *******************************************/

DROP PROCEDURE IF EXISTS sp_BusquedaPagos; 


DELIMiTER $$
create procedure sp_BusquedaPagos(Emp varchar(80),recordsPerPage int ,startPageIndex int)
begin
SELECT p.*
FROM pagos as p join empleados as e
on p.IdEmp=e.IdEmp
where e.Nombre LIKE CONCAT('%', Emp ,'%')  LIMIT recordsPerPage OFFSET startPageIndex;
end$$
DELIMiTER ;


call sp_BusquedaPagos('p',10,0);

/*
select count(*) 
from pagos as p join empleados as e
on p.IdEmp=e.IdEmp
where e.Nombre like concat('p','%');
*/

/************************** Procedure para buscar la tabla reservas **************************************************/


DROP PROCEDURE IF EXISTS sp_BusquedaReservas; 


DELIMiTER $$
create procedure sp_BusquedaReservas(Emp varchar(80),recordsPerPage int ,startPageIndex int)
begin
SELECT r.*
FROM reservas as r join empleados as e
on r.IdEmp=e.IdEmp
where e.Nombre LIKE CONCAT('%', Emp ,'%')  LIMIT recordsPerPage OFFSET startPageIndex;
end$$
DELIMiTER ;


call sp_BusquedaReservas('p',10,0);

/*
select count(*) 
from reservas as r join empleados as e
on r.IdEmp=e.IdEmp
where e.Nombre like concat('p','%');
*/

/************************** Procedure para buscar la tabla Empleado **************************************************/


DROP PROCEDURE IF EXISTS sp_BuscarEmpleado; 


DELIMiTER $$
create procedure sp_BuscarEmpleado(Emp varchar(80),recordsPerPage int ,startPageIndex int)
begin
SELECT *
FROM empleados
where Nombre LIKE CONCAT('%', Emp ,'%')  LIMIT recordsPerPage OFFSET startPageIndex;
end$$
DELIMiTER ;


call sp_BuscarEmpleado('p',10,0);
/*
select count(*) 
from empleados
where Nombre like concat('p','%');
*/

/****************************************************************************/

DROP PROCEDURE IF EXISTS sp_infoPerEmpleado;

-- Get Login  Info Empleados 
DELIMiTER $$
create procedure sp_infoPerEmpleado(idHora int)
begin

-- SELECT idActividad , idhorasEmpleados  , Opcion , Accion ,  DATE_FORMAT( Fecha,'%d-%m-%Y') as Fecha, Hora
SELECT idActividad , idhorasEmpleados  , Opcion , Accion ,  Fecha, DATE_FORMAT(Hora,'%r') 
FROM infoEmpleados
where idhorasEmpleados = idHora;

end$$
DELIMiTER ;


/******************************************** Stores to get Left Panel Info *****************************************************/


DROP PROCEDURE IF EXISTS sp_GetHorasEmpleado;

-- Get Login  Info Empleados 
DELIMiTER $$
create procedure sp_GetHorasEmpleado(idEmp int)
begin

-- SELECT e.Nombre , e.Apellido ,DATE_FORMAT( SEC_TO_TIME(SUM(TIME_TO_SEC(h.LogOutHora) - TIME_TO_SEC(h.LogInHora)) ) ,'%h:%i') AS Horas
SELECT e.Nombre , e.Apellido , SEC_TO_TIME(SUM(TIME_TO_SEC(h.LogOutHora) - TIME_TO_SEC(h.LogInHora)) )  AS Horas        
FROM horasEmpleados as h 
JOIN Empleados as e   on h.idEmp = e.idEmp  
where h.idEmp = idEmp  
GROUP BY h.idEmp;

end$$
DELIMiTER ;



DROP PROCEDURE IF EXISTS sp_cantReservas;

-- Get Cantidad de Reservas por Empleado
DELIMiTER $$
create procedure sp_cantReservas(idEmp int)
begin

SELECT count(IdReserva) as cReservas
FROM reservas as r  
where r.IdEmp = idEmp;

end$$
DELIMiTER ;



DROP PROCEDURE IF EXISTS sp_cantClientes;

-- Get Cantidad de Reservas por Empleado
DELIMiTER $$
create procedure sp_cantClientes(idEmp int)
begin

SELECT count(IdCliente) as cClientes
from Clientes
where idEmp = idEmp;


end$$
DELIMiTER ;
/****************************************************************/

DROP PROCEDURE IF EXISTS sp_CantReservasPorMes;

-- Get Cantidad de Reservas por Empleado
DELIMiTER $$
create procedure sp_CantReservasPorMes()
begin



SELECT COUNT(*) as CantReservas , DATE_FORMAT(FechaEntrada,'%M') as Mes 
FROM reservas
GROUP BY DATE_FORMAT(FechaEntrada, "%m-%Y") ;


end$$
DELIMiTER ;


call sp_CantReservasPorMes;


DROP PROCEDURE IF EXISTS sp_EmpCantEstadias;

-- Get Cantidad de Reservas por Empleado
DELIMiTER $$
create procedure sp_EmpCantEstadias()
begin

SELECT count(*) as CantEstadias , e.Nombre 
FROM historial as h
join empleados as e
on h.idEmp = e.idEmp
GROUP BY h.idEmp;


end$$
DELIMiTER ;

call sp_EmpCantEstadias;



/******************************************** Stores to get Left Panel Info *****************************************************/




/*



call sp_GetHorasEmpleados('Pedro');



call sp_GetHorasEmpleadoss('p','Pedro');





call sp_infoPerEmpleado(1);



SELECT idActividad , idhorasEmpleados  , Opcion , Accion ,  Fecha, Hora
FROM infoEmpleados;
-- where idhorasEmpleados = idHora;


call sp_GetHorasEmpleado(5);

call sp_cantClientes(5);

call sp_cantReservas(5);



*/




