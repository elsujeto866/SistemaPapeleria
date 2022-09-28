/*CREACIÓN DE LA BASE DE DATOS */
DROP DATABASE IF EXISTS datospeluqueria;
CREATE DATABASE datospeluqueria;
USE datospeluqueria;

/* CREACIÓN DE LAS TABLAS */
CREATE TABLE tipousuario(
	idtipoUsuario INT NOT NULL AUTO_INCREMENT,
    tipoUsuario VARCHAR(20) NOT NULL,
    PRIMARY KEY (idtipoUsuario)
);

CREATE TABLE productos(
	idProducto INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL,
    precio DOUBLE NOT NULL,
    unidades INT,
    PRIMARY KEY (idProducto)
);

CREATE TABLE usuarios(
	idUsuario INT NOT NULL AUTO_INCREMENT,
    apodoUsuario VARCHAR(20) NOT NULL,
    passUsuario VARCHAR(20) NOT NULL,
    nombreUsuario VARCHAR(20) NOT NULL,
    apellidoUsuario VARCHAR(20) NOT NULL,
    idTipo INT NOT NULL,
	PRIMARY KEY (idUsuario),
    FOREIGN KEY (idTipo) REFERENCES tipousuario(idtipoUsuario)
);

/* INSERCIÓN DE DATOS A LAS TABLAS */
INSERT INTO tipousuario (tipoUsuario)
VALUES
	('Administrador'),
    ('Subadministrador'),
    ('Vendedor');
    
INSERT INTO productos (nombre,precio,unidades)
VALUES
	('Corte',4.00,20),
    ('Tijeras',4.30,20),
    ('Secadoras',20.00,5),
    ('Tintes',1.50,30),
    ('Botos',0.05,100),
    ('Planchas',0.40,50);
    
INSERT INTO usuarios (apodoUsuario,passUsuario,nombreUsuario,apellidoUsuario,idTipo)
VALUES
	('Marco','1001','Marco','Pereira',1),
    ('Marcia','1002','Marcia','Granda',2),
    ('Ismael','1003','Ismael','Pereira',2),
    ('Mari','1004','María','Pozo',3),
    ('Fer','1004','Fernanda','Chávez',3),
    ('Marce','1004','Marcela','Gozo',3);