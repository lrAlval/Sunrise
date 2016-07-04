DROP DATABASE IF EXISTS sunrise;
CREATE DATABASE IF NOT EXISTS sunrise;
USE sunrise;

-- SET SQL_SAFE_UPDATES = 0;







CREATE TABLE EstadoEmpleado(
    IdEstado INT auto_increment PRIMARY KEY,
    DescEstado varchar(60)
) ENGINE=INNODB;


INSERT INTO EstadoEmpleado (`IdEstado`, `DescEstado`) VALUES 
 ('1', 'Activo'),
 ('2', 'De Vacaciones'),
 ('3', 'Despedido'),
 ('4', 'Bloqueado');


CREATE TABLE Preguntas(
    IdPregunta INT auto_increment PRIMARY KEY,
    Descripcion varchar(50)
) ENGINE=INNODB;


INSERT INTO `sunrise`.`Preguntas` (`IdPregunta`, `Descripcion`) VALUES 
 ('1', 'Nombre de Tu Primer Mascota?'),
 ('2', 'Curso Favorito en la escuela?'),
 ('3', 'Edad de tu madre?'),
 ('4', 'Palabra Secreta?'),
 ('5', 'Cual es tu Pasatiempo?');



SELECT * FROM Preguntas;


CREATE TABLE Empleados(
    IdEmp INT auto_increment PRIMARY KEY,
    Nombre varchar(50),
    Apellido varchar(50),
    Edad varchar(3),
    Cargo varchar(70),
    login varchar(10),
    pass varchar(10),
    idPregunta int,
    respuesta varchar(50),
    idEstado int default 1,
    profilepic varchar(150) default 'public/profile pics/d2.png',
    FOREIGN KEY(idPregunta) REFERENCES Preguntas(IdPregunta),
	FOREIGN KEY(idEstado) REFERENCES EstadoEmpleado(IdEstado)
) ENGINE=INNODB;



INSERT INTO `sunrise`.`Empleados` 
(`IdEmp`, `Nombre`, `Apellido`,`Edad`, `Cargo`, `login`, `pass`,`idPregunta`,`respuesta`,`profilepic`) 
VALUES 
 (1,'Pedro','Jimenez','35','Jefe de Turno','pjimenez','123456',1,'gato1','public/profile pics/troll.jpg'),
 (2,'Carlos','Rodriguez','30','Gerente general','crodriguez','123456',1,'gato2','public/profile pics/yao.jpg'),
 (22958,'Andrew','Laskin','20','Recepcionista','alasking','123456',1,'Boris','public/profile pics/d2.png'),
 (24095,'Fred','Barclay','18','Recepcionista','fbar','123456',4,'que te importa','public/profile pics/d2.png'),
 (27049,'Harriett','Dovecott','19','Recepcionista','hdovecott','123456',2,'Educacion Fisica','public/profile pics/d2.png'),
 (28405,'Peggy','Thompson','21','Recepcionista','pthompson','123456',5,'dormir','public/profile pics/d2.png'),
 (70429,'Lynda','Fore','23','Recepcionista','lfore','123456',3,'ni idea','public/profile pics/d2.png'),
 (72947,'Sheryl','Shegger','22','Recepcionista','shegger','123456',1,'Kuro','public/profile pics/d2.png');



INSERT INTO `sunrise`.`Empleados` 
(`IdEmp`, `Nombre`, `Apellido`,`Edad`, `Cargo`, `login`, `pass`,`idPregunta`,`respuesta`) 
VALUES 
 ('3', 'Carla', 'Torres','24','Recepcionista', 'ctorres', '123456', '1', 'gg'),
 ('4', 'Carlos', 'Castillo','25','Jefe de Turno', 'ccastillo', '123456', '1', 'gg'),
 ('5', 'Paola', 'Puente','28','Recepcionista', 'ppuente', '123456', '1', 'gg');
 


CREATE TABLE horasEmpleados(
idHora int auto_increment primary key,
idEmp int,
SesionID varchar(45) default 0,
Fecha date, 
LogInHora time,
LogOutHora time,
FOREIGN KEY(idEmp) REFERENCES Empleados(IdEmp)
);


INSERT INTO horasEmpleados(idEmp,Fecha,LogInHora,LogOutHora)
VALUES
(3,'2016-07-01', '20:00:00','21:00:00'); -- simple part of the same day




SELECT * FROM Empleados;

SELECT * FROM horasEmpleados;





CREATE TABLE infoEmpleados(
idActividad int auto_increment primary key,
idhorasEmpleados int,
Opcion varchar(60),
Accion varchar(50),
Fecha date,
Hora time,
FOREIGN KEY(idhorasEmpleados) REFERENCES horasEmpleados(idHora)
);


INSERT INTO `infoEmpleados`(idhorasEmpleados,Opcion,Accion,Fecha,Hora) VALUES
(1,"Habitacion","Añadio una Habitacion",current_date(),current_time()),
(1,"Reserva","Reservo una Habitacion",current_date(),current_time),
(1,"Habitacion","Actualizo el Estado de una Habitacion",current_date(),current_time()),
(1,"Habitacion Tipo","Actualizo  Habitacion Tipo",current_date(),current_time());



SELECT * FROM infoEmpleados;











CREATE TABLE Clientes(
    IdCliente INT auto_increment PRIMARY KEY,
    Nombre varchar(50),
    Apellido varchar(50),
    Telefono varchar(15),
    Notas varchar(70),
    idEmp int,
    FOREIGN KEY(idEmp) REFERENCES Empleados(IdEmp)
)ENGINE=INNODB;


INSERT INTO `sunrise`.`Clientes` (`IdCliente`, `Nombre`, `Apellido`, `Telefono`, `Notas`,`idEmp`) VALUES ('208405', 'Peter', 'Carney', '990-585-1886', 'Spencer Miles',5);
INSERT INTO `sunrise`.`Clientes` (`IdCliente`, `Nombre`, `Apellido`, `Telefono`, `Notas`,`idEmp`) VALUES ('204795', 'Juliette', 'Beckins', '410-944-1440', 'Bernard Brodsky',5);
INSERT INTO `sunrise`.`Clientes` (`IdCliente`, `Nombre`, `Apellido`, `Telefono`, `Notas`,`idEmp`) VALUES ('902840', 'Daniel', 'Peters', '624-802-1686', 'Grace Peters',5);
INSERT INTO `sunrise`.`Clientes` (`IdCliente`, `Nombre`, `Apellido`, `Telefono`, `Notas`,`idEmp`) VALUES ('383084', 'Peter', 'Carney', '990-585-1886', 'Spencer Miles',5);
INSERT INTO `sunrise`.`Clientes` (`IdCliente`, `Nombre`, `Apellido`, `Telefono`, `Notas`,`idEmp`) VALUES ('660820', 'Anne', 'Sandt', '953-172-9347', 'William Sandt',5);
INSERT INTO `sunrise`.`Clientes` (`IdCliente`, `Nombre`, `Apellido`, `Telefono`, `Notas`,`idEmp`) VALUES ('100752', 'Caroline', 'Lomey', '301-652-0700', 'Albert Lomey',5);
INSERT INTO `sunrise`.`Clientes` (`IdCliente`, `Nombre`, `Apellido`, `Telefono`, `Notas`,`idEmp`) VALUES ('608208', 'Alfred', 'Owens', '804-798-3257', 'Jane Owens',3);
INSERT INTO `sunrise`.`Clientes` (`IdCliente`, `Nombre`, `Apellido`, `Telefono`, `Notas`,`idEmp`) VALUES ('180204', 'Randy', 'Whittaker', '703-631-1200', 'Bryan Rattner',3);
INSERT INTO `sunrise`.`Clientes` (`IdCliente`, `Nombre`, `Apellido`, `Telefono`, `Notas`,`idEmp`) VALUES ('284085', 'Lucy', 'Chen', '425-979-7413', 'Edward Lamb',3);
INSERT INTO `sunrise`.`Clientes` (`IdCliente`, `Nombre`, `Apellido`, `Telefono`, `Notas`,`idEmp`) VALUES ('260482', 'Caroline', 'Lomey', '301-652-0700', 'Albert Lomey',3);
INSERT INTO `sunrise`.`Clientes` (`IdCliente`, `Nombre`, `Apellido`, `Telefono`, `Notas`,`idEmp`) VALUES ('474065', 'Peter', 'Carney', '990-585-1886', 'Spencer Miles',3);
INSERT INTO `sunrise`.`Clientes` (`IdCliente`, `Nombre`, `Apellido`, `Telefono`, `Notas`,`idEmp`) VALUES ('640800', 'Randy', 'Whittaker', '703-631-1200', 'Bryan Rattner',3);
INSERT INTO `sunrise`.`Clientes` (`IdCliente`, `Nombre`, `Apellido`, `Telefono`, `Notas`,`idEmp`) VALUES ('294209', 'Doris', 'Wilson', '703-416-0934', 'Gabriela Dawson',22958);
INSERT INTO `sunrise`.`Clientes` (`IdCliente`, `Nombre`, `Apellido`, `Telefono`, `Notas`,`idEmp`) VALUES ('946090', 'Peter', 'Carney', '990-585-1886', 'Spencer Miles',22958);
INSERT INTO `sunrise`.`Clientes` (`IdCliente`, `Nombre`, `Apellido`, `Telefono`, `Notas`,`idEmp`) VALUES ('629305', 'Joan', 'Davids', '202-789-0500', 'Rebecca Boiron',22958);
INSERT INTO `sunrise`.`Clientes` (`IdCliente`, `Nombre`, `Apellido`, `Telefono`, `Notas`,`idEmp`) VALUES ('608502', 'Caroline', 'Lomey', '301-652-0700', 'Albert Lomey',22958);




SELECT * FROM Clientes;





CREATE TABLE Pagos(
    IdRecibo INT auto_increment PRIMARY KEY,
    IdEmp INT ,
    FechaPago DATE,
    IdCliente INT ,
    ImportePagar DECIMAL(10, 2),
    Notas VARCHAR(180),
    FOREIGN KEY(IdEmp) REFERENCES EMPLEADOS(IdEmp),
    FOREIGN KEY(IdCliente) REFERENCES CLIENTES(IdCliente)

)ENGINE=INNODB;



INSERT INTO `sunrise`.`Pagos` (`IdRecibo`, `IdEmp`, `FechaPago`, `IdCliente`, `ImportePagar`) VALUES ('1', '28405', '2016/01/08', '100752', '343.80');
INSERT INTO `sunrise`.`Pagos` (`IdRecibo`, `IdEmp`, `FechaPago`, `IdCliente`, `ImportePagar`) VALUES ('2', '28405', '2016-01-10', '946090', '98.95');
INSERT INTO `sunrise`.`Pagos` (`IdEmp`, `FechaPago`, `IdCliente`, `ImportePagar`) VALUES ('24095', '2016-01-10', '204795', '85.95');
INSERT INTO `sunrise`.`Pagos` (`IdRecibo`, `IdEmp`, `FechaPago`, `IdCliente`, `ImportePagar`) VALUES ('4', '70429', '2016-01-11', '474065', '450.00');
INSERT INTO `sunrise`.`Pagos` (`IdEmp`, `FechaPago`, `IdCliente`, `ImportePagar`) VALUES ('28405', '2016-01-13', '208405', '472.50');
INSERT INTO `sunrise`.`Pagos` (`IdEmp`, `FechaPago`, `IdCliente`, `ImportePagar`) VALUES ('28405', '2016-01-13', '284085', '387.92');
INSERT INTO `sunrise`.`Pagos` (`IdEmp`, `FechaPago`, `IdCliente`, `ImportePagar`, `Notas`) VALUES ('24095', '2016-01-13', '294209', '379.25', 'Al Cliente se le Cargo $380');
INSERT INTO `sunrise`.`Pagos` (`IdRecibo`, `IdEmp`, `FechaPago`, `IdCliente`, `ImportePagar`, `Notas`) VALUES ('8', '70429', '2016-01-14', '383084', '670.00', 'Al Cliente se le Cargo una Tarija Fija de  $670 Por la Habitacion de conferencias');

INSERT INTO `sunrise`.`Pagos` (`IdRecibo`, `IdEmp`, `FechaPago`, `IdCliente`, `ImportePagar`) VALUES ('9', '70429', '2016-01-15', '260482', '450.00');

INSERT INTO `sunrise`.`Pagos` (`IdRecibo`, `IdEmp`, `FechaPago`, `IdCliente`, `ImportePagar`) VALUES ('10', '28405', '2016-01-19', '180204', '98.85');
INSERT INTO `sunrise`.`Pagos` (`IdRecibo`, `IdEmp`, `FechaPago`, `IdCliente`, `ImportePagar`) VALUES ('11', '70429', '2016-01-28', '608208', '192.32');


SELECT * FROM Pagos;



 -- SELECT * FROM Historial;















-- Habitacion y sus Dependencias


CREATE TABLE HabitacionEstado(
    IDHabEstado INT auto_increment PRIMARY KEY,
    Notas varchar(90)
)ENGINE=INNODB;

INSERT INTO `sunrise`.`HabitacionEstado` (`IDHabEstado`, `Notas`) VALUES ('1', 'Disponible');
INSERT INTO `sunrise`.`HabitacionEstado` (`IDHabEstado`, `Notas`) VALUES ('2', 'Reservada');
INSERT INTO `sunrise`.`HabitacionEstado` (`IDHabEstado`, `Notas`) VALUES ('3', 'Mantenimiento');



SELECT * FROM HabitacionEstado;

CREATE TABLE CamaTipo(
    IdCamaTipo INT auto_increment PRIMARY KEY,
    Notas varchar(90)
)ENGINE=INNODB;

INSERT INTO `sunrise`.`CamaTipo` (`IdCamaTipo`, `Notas`) VALUES ('1', 'Queen');
INSERT INTO `sunrise`.`CamaTipo` (`IdCamaTipo`, `Notas`) VALUES ('2', 'King');
INSERT INTO `sunrise`.`CamaTipo` (`IdCamaTipo`, `Notas`) VALUES ('3', 'Double');



SELECT * FROM CamaTipo;


CREATE TABLE HabitacionTipo(
    IDHabTipo INT auto_increment PRIMARY KEY,
    Notas varchar(90)
)ENGINE=INNODB;

INSERT INTO `sunrise`.`HabitacionTipo` (`IDHabTipo`, `Notas`) VALUES ('1', 'Cama');
INSERT INTO `sunrise`.`HabitacionTipo` (`IDHabTipo`, `Notas`) VALUES ('2', 'Studio');
INSERT INTO `sunrise`.`HabitacionTipo` (`IDHabTipo`, `Notas`) VALUES ('3', 'Conferencia');


SELECT * FROM HabitacionTipo;

-- drop table Habitacion;

CREATE TABLE Habitacion(
    IDHab INT auto_increment PRIMARY KEY,
    IDHabTipo INT ,
    IdCamaTipo INT  ,
	Precio DECIMAL(10, 2),
    IdEstado INT default 3,
    Notas varchar(90),
    
    FOREIGN KEY(IdEstado) REFERENCES HabitacionEstado(IDHabEstado),
    FOREIGN KEY(IdCamaTipo) REFERENCES CamaTipo(IdCamaTipo),
    FOREIGN KEY(IDHabTipo) REFERENCES HabitacionTipo(IDHabTipo)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    
)ENGINE=INNODB;


INSERT INTO `sunrise`.`Habitacion` 
(`IDHab`, `IDHabTipo`, `IdCamaTipo`, `Precio`, `IdEstado`, `Notas`) VALUES 
('101', '1', '1', '85.95', '1', ''),
('102', '1', '3', '92.50', '1', ''),
('103', '2', '3', '112.50', '1', ''),
('104', '1', '1', '85.95', '1', ''),
('105', '1', '2', '98.75', '1', ''),
('106', '1', '1', '85.95', '1', ''),
('107', '1', '2', '98.75', '1', ''),
('108', '1', '1', '85.95', '1', ''),
('110', '3','1',  '450.00', '1', ''),
('112', '3',  '1','650.00', '1', ''),
('114', '1', '2', '98.75', '1', ''),
('115', '1', '2', '98.75', '1', ''),
('116', '1', '1', '85.95', '1', ''),
('117', '1', '1', '85.95', '1', ''),
('118', '1', '2', '98.75', '1', ''),
('120', '2', '2', '124.95', '1', ''),
('122', '3', '1' , '725.00', '1', ''),
('125', '1', '2', '95.50', '1', ''),
('126', '2', '2', '124.95', '1', ''),
('127', '1', '3', '92.50', '1', ''),
('128', '1', '3', '92.50', '1', ''),
('130', '3', '1','500.00', '1', ''),
('201', '1', '3', '92.50', '1', ''),
('202', '2', '2', '124.95', '1', ''),
('203', '2', '1', '94.50', '1', ''),
('204', '1', '3', '96.50', '1', ''),
('205', '1', '1', '85.95', '1', ''),
('206', '1', '2', '92.75', '1', ''),
('207', '1', '1', '85.95', '1', ''),
('208', '1', '1', '85.95', '1', ''),
('209', '1', '2', '92.75', '1', ''),
('210', '2', '3', '112.50', '1', '');






SELECT * FROM Habitacion;


CREATE TABLE Historial(
    IdHistorial INT auto_increment PRIMARY KEY,
    IdEmp     INT ,
    IdCliente INT,
    IdHabitacion INT ,
    FechaEstadia Date,
    CargoPorHabitacion DECIMAL(10, 2),
    CargoPorTelefono DECIMAL(10, 2),
    Notas varchar(90),
    
    FOREIGN KEY(IdEmp) REFERENCES EMPLEADOS(IdEmp),
    FOREIGN KEY(IdCliente) REFERENCES CLIENTES(IdCliente),
    FOREIGN KEY(IdHabitacion) REFERENCES Habitacion(IDHab)

)ENGINE=INNODB;


INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`, `Notas`) VALUES ('1', '24095', '100752', '106', '2016/01/04', '85.95', 'El Cliente Esta Aqui por Una Conferencia y Ocupara la Habitacion por una Semana');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('2', '24095', '100752', '106', '2016/01/05', '85.95');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('3', '24095', '100752', '106', '2016/01/06', '85.95');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('4', '24095', '100752', '106', '2016/01/07', '85.95');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('5', '28405', '100752', '106', '2016/01/08', '85.95');

INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`, `CargoPorTelefono`) VALUES ('6', '28405', '946090', '114', '2016-01-09', '98.95', '3.55');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`, `Notas`) VALUES ('7', '28405', '474065', '110', '2016-01-09', '450.00', 'Habitacion Rentada por una Conferencia');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('8', '24095', '204795', '104', '2016-01-09', '85.95');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('9', '27049', '204795', '104', '2016-01-10', '85.95');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`, `CargoPorTelefono`) VALUES ('10', '28405', '946090', '114', '2016-01-10', '98.95', '18.86');

INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('11', '24095', '208405', '203', '2016-01-11', '98.95');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('12', '24095', '284085', '106', '2016-01-11', '98.95');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('13', '24095', '294209', '205', '2016-01-11', '98.95');




INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`, `CargoPorTelefono`) VALUES ('14', '24095', '208405', '203', '2016-01-12', '94.50', '2.25');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('15', '24095', '284085', '106', '2016-01-12', '85.95');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('16', '24095', '294209', '205', '2016-01-12', '85.95');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('17', '24095', '208405', '203', '2016-01-12', '94.50');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('18', '24095', '284085', '106', '2016-01-12', '85.95');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('19', '24095', '294209', '205', '2016-01-12', '85.95');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('20', '24095', '208405', '203', '2016-01-12', '94.50');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`, `CargoPorTelefono`) VALUES ('21', '24095', '284085', '106', '2016-01-12', '85.95', '3.15');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('22', '24095', '294209', '205', '2016-01-12', '85.95');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`, `CargoPorTelefono`) VALUES ('23', '24095', '208405', '203', '2016-01-12', '94.50', '4.05');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`, `CargoPorTelefono`) VALUES ('24', '24095', '284085', '106', '2016-01-12', '85.95', '5.52');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('25', '24095', '294209', '205', '2016-01-12', '85.95');


INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`,`CargoPorHabitacion`) VALUES ('26', '28405', '208405', '203', '2016-01-14','94.50');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`,`CargoPorHabitacion`, `CargoPorTelefono`, `Notas`) VALUES ('27', '70429', '383084', '112', '2016-01-14','650.00', '22.64', 'La habitacion Conferencia esta Rentada por una Boda');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`,`CargoPorHabitacion`) VALUES ('28', '28405', '284085', '106', '2016-01-14','85.95');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`,`CargoPorHabitacion`) VALUES ('29', '24095', '294209', '205', '2016-01-14','85.95');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`,`CargoPorHabitacion`) VALUES ('30', '28405', '902840', '107', '2016-01-14','85.95');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`,`CargoPorHabitacion`, `CargoPorTelefono`) VALUES ('31', '28405', '608502', '120', '2016-01-14','85.95', '4.26');

INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`,`CargoPorHabitacion`) VALUES ('32', '28405', '180204', '126', '2016-01-14','85.95');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`,`CargoPorHabitacion`) VALUES ('33', '28405', '629305', '122', '2016-01-14','725.00');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`,`CargoPorHabitacion`) VALUES ('34', '28405', '660820', '105', '2016-01-14','85.95');

INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`,`CargoPorHabitacion`) VALUES ('35', '28405', '208405', '203', '2016-01-14','94.50');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`,`CargoPorHabitacion`, `CargoPorTelefono`, `Notas`) VALUES ('36', '70429', '383084', '112', '2016-01-14','650.00', '22.64', 'La habitacion Conferencia esta Rentada por una Boda');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`,`CargoPorHabitacion`) VALUES ('37', '28405', '284085', '106', '2016-01-14','85.95');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`,`CargoPorHabitacion`) VALUES ('38', '24095', '294209', '205', '2016-01-14','85.95');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`,`CargoPorHabitacion`) VALUES ('39', '28405', '902840', '107', '2016-01-14','85.95');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`,`CargoPorHabitacion`, `CargoPorTelefono`) VALUES ('40', '28405', '608502', '120', '2016-01-14','85.95', '4.26');

INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`,`CargoPorHabitacion`) VALUES ('41', '28405', '180204', '126', '2016-01-14','85.95');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`,`CargoPorHabitacion`) VALUES ('42', '28405', '629305', '122', '2016-01-14','725.00');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`,`CargoPorHabitacion`) VALUES ('43', '28405', '660820', '105', '2016-01-14','85.95');


INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('44', '27049', '902840', '107', '2016-01-16', '85.75');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`, `CargoPorTelefono`) VALUES ('45', '27049', '608502', '120', '2016-01-16', '98.85', '8.48');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('46', '28405', '180204', '126', '2016-01-16', '98.85');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('47', '70429', '260482', '110', '2016-01-16', '450.00');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('48', '70429', '660820', '105', '2016-01-16', '92.75');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('49', '28405', '660820', '105', '2016-01-17', '92.75');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('50', '28405', '608502', '114', '2016-01-19', '98.85');


INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('51', '28405', '608502', '114', '2016-01-19', '92.75');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`, `CargoPorTelefono`) VALUES ('52', '28405', '608502', '114', '2016-01-20', '92.75', '6.82');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('53', '70429', '608502', '114', '2016-01-21', '92.75');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('54', '70429', '640800', '204', '2016-01-21', '96.60');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('55', '70429', '640800', '204', '2016-01-22', '96.60');
INSERT INTO `sunrise`.`Historial` (`IdHistorial`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEstadia`, `CargoPorHabitacion`) VALUES ('56', '27049', '640800', '204', '2016-01-23', '96.60');


SELECT * FROM Historial;




CREATE TABLE Reservas(
    IdReserva INT auto_increment PRIMARY KEY,
    IdEmp     INT ,
    IdCliente INT,
    IdHabitacion INT ,
    FechaEntrada Date,
    FechaSalida Date,
    Notas varchar(90),
    FOREIGN KEY(IdEmp) REFERENCES EMPLEADOS(IdEmp),
    FOREIGN KEY(IdCliente) REFERENCES CLIENTES(IdCliente),
    FOREIGN KEY(IdHabitacion) REFERENCES Habitacion(IDHab)

)ENGINE=INNODB;



INSERT INTO `sunrise`.`Reservas` (`IdReserva`, `IdEmp`, `IdCliente`, `IdHabitacion`, `FechaEntrada`, `FechaSalida`) VALUES 
('1', '24095', '100752', '106', '2016-02-10','2016-02-13'),
('2', '24095', '100752', '106', '2016-02-16','2016-02-22'),
('3', '24095', '100752', '106', '2016-02-24','2016-02-27'),
('4', '24095', '100752', '106','2016-02-28','2016-02-29'),
('5', '28405', '100752', '106', '2016-03-02','2016-03-04'),
('6', '28405', '946090', '114', '2016-03-06','2016-03-10'),
('7', '28405', '474065', '110', '2016-03-11','2016-03-13'),
('8', '24095', '204795', '104', '2016-03-14','2016-03-17'),
('9', '27049', '204795', '104','2016-03-19','2016-03-21'),
('10', '28405', '946090', '114', '2016-03-22','2016-03-22'),
('11', '24095', '208405', '203','2016-03-26','2016-03-28'),
('12', '24095', '284085', '106', '2016-03-30','2016-04-01'),
('13', '24095', '294209', '205','2016-04-03','2016-04-07'),
('14', '24095', '208405', '203','2016-04-08','2016-04-08'),
('15', '24095', '284085', '106','2016-04-09','2016-04-09'),
('16', '24095', '294209', '205', '2016-04-10','2016-04-11'),
('17', '24095', '208405', '203','2016-04-11','2016-04-18'),
('18', '24095', '284085', '106','2016-04-22','2016-04-24'),
('19', '24095', '294209', '205', '2016-04-25','2016-04-25'),
('20', '24095', '208405', '203','2016-04-27','2016-04-28'),
('21', '24095', '284085', '106', '2016-04-29','2016-05-01'),
('22', '24095', '294209', '205', '2016-05-02','2016-05-02'),
('23', '24095', '208405', '203', '2016-05-04','2016-05-04'),
('24', '24095', '284085', '106', '2016-05-11','2016-05-15'),
('25', '24095', '294209', '205','2016-05-15','2016-05-18'),
 ('26', '28405', '208405', '203', '2016-05-19','2016-05-21'),
 ('27', '70429', '383084', '112', '2016-05-22','2016-05-23'),
 ('28', '28405', '284085', '106', '2016-05-24','2016-05-25'),
 ('29', '24095', '294209', '205', '2016-05-26','2016-05-27'),
 ('30', '28405', '902840', '107', '2016-05-29','2016-06-01'),
 ('31', '28405', '608502', '120', '2016-06-02','2016-06-03'),
 ('32', '28405', '180204', '126', '2016-06-03','2016-06-05'),
 ('33', '28405', '629305', '122','2016-06-06','2016-06-07'),
 ('34', '28405', '660820', '105','2016-06-09','2016-06-11'),
 ('35', '28405', '208405', '203', '2016-06-12','2016-06-14'),
 ('36', '70429', '383084', '112', '2016-06-15','2016-06-17'),
 ('37', '28405', '284085', '106', '2016-06-18','2016-06-20'),
 ('38', '24095', '294209', '205', '2016-06-21','2016-06-23'),
 ('39', '28405', '902840', '107', '2016-06-24','2016-06-26'),
 ('40', '28405', '608502', '120', '2016-06-27','2016-06-28'),
 ('41', '28405', '180204', '126', '2016-07-01','2016-07-03'),
 ('42', '28405', '629305', '122', '2016-07-01','2016-07-03'),
 ('43', '28405', '660820', '105', '2016-07-04','2016-07-05'),
('44', '27049', '902840', '107', '2016-07-07','2016-07-08'),
('45', '27049', '608502', '120','2016-07-09','2016-07-12'),
('46', '28405', '180204', '126', '2016-07-13','2016-07-14'),
('47', '70429', '260482', '110','2016-07-15','2016-07-17'),
('48', '70429', '660820', '105','2016-07-18','2016-07-20'),
('49', '28405', '660820', '105','2016-07-21','2016-07-23'),
('50', '28405', '608502', '114', '2016-07-24','2016-07-26'),
('51', '28405', '608502', '114', '2016-07-27','2016-07-28'),
('52', '28405', '608502', '114', '2016-07-29','2016-07-31'),
('53', '70429', '608502', '114','2016-08-01','2016-07-04'),
('54', '70429', '640800', '204', '2016-08-05','2016-07-07'),
('55', '70429', '640800', '204', '2016-08-08','2016-07-11'),
('56', '27049', '640800', '204', '2016-08-12','2016-07-14'),
('57', '5', '608502', '110', '2016-08-12', '2016-08-15'),
('58', '5', '608502', '110', '2016-08-16', '2016-08-18'),
('59', '5', '608502', '110', '2016-08-19', '2016-08-20');






SELECT * FROM Reservas;






CREATE TABLE Contacto(
    IdContacto INT auto_increment PRIMARY KEY,
    Nombre     varchar(30),
    mail varchar(30),
    Notas varchar(90)
)ENGINE=INNODB;


INSERT INTO `sunrise`.`Contacto` (`IdContacto`, `Nombre`, `mail`, `Notas`) VALUES ('1', 'Carlos', 'carlos@gmail.com', 'Cotizacion Sobre Nuevo Producto');
INSERT INTO `sunrise`.`Contacto` (`IdContacto`, `Nombre`, `mail`, `Notas`) VALUES ('2', 'Penelope', 'penelope@gmail.com', 'Info Sobre Nuevo Producto');







SELECT * FROM Contacto;

