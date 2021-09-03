DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario(
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(45),
    password VARCHAR(128)
);

INSERT INTO usuario (username, password) VALUES('admin', '$2a$10$kZZ61p4Yaa2.S2lLNPKseOY/hdqehhvKgygwM45ArUndyM4sjsPvW');
INSERT INTO usuario (username, password) VALUES('user', '$2a$10$6af60tunUZJUsuHa17lfh.Qt3uJPN2W2Dtt4vnUPtVhPeP.2AWuk2');

DROP TABLE IF EXISTS rol;
CREATE TABLE rol(
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(45),
    id_usuario int
);

INSERT INTO rol (nombre, id_usuario) VALUES('ROLE_ADMIN', 1);
INSERT INTO rol (nombre, id_usuario) VALUES('ROLE_USER', 1);
INSERT INTO rol (nombre, id_usuario) VALUES('ROLE_USER', 2);

DROP TABLE IF EXISTS persona;
CREATE TABLE persona(
    id_persona INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(45),
    apellido VARCHAR(45),
    email VARCHAR(45),
    telefono VARCHAR(45),
    saldo double(45)
);

INSERT INTO persona (nombre, apellido, email, telefono, saldo) VALUES
('Andres', 'Castillo', 'acastilo@gamil.com', '123456789', 100),
('Juan', 'Perez', 'jPerez', '987456321', 150);

CREATE TABLE IF NOT EXISTS tipo_articulo (
  id_tipoarticulo int(11) NOT NULL AUTO_INCREMENT,
  descripcion_articulo varchar(30) NOT NULL,
  PRIMARY KEY (id_tipoarticulo)
);

INSERT INTO tipo_articulo (id_tipoarticulo, descripcion_articulo) VALUES
(1, 'Marvel'),
(2, 'DC comics');

CREATE TABLE IF NOT EXISTS tipo_producto (
  id_tipoproducto int(11) NOT NULL AUTO_INCREMENT,
  descripcion_producto varchar(30) NOT NULL,
  PRIMARY KEY (id_tipoproducto)
);

INSERT INTO tipo_producto (id_tipoproducto, descripcion_producto) VALUES
(1, 'camisetas'),
(2, 'vasos'),
(3, 'comics'),
(4, 'juguetes');

CREATE TABLE IF NOT EXISTS articulo (
  id_articulo int(11) NOT NULL AUTO_INCREMENT,
  descripcion varchar(30) NOT NULL,
  precio_venta int(11) NOT NULL,
  precio_costo int(11) NOT NULL,
  stock int(11) NOT NULL,
  cod_tipo_articulo int(11) NOT NULL,
  cod_tipo_producto varchar(20) NOT NULL,
  fecha_ingreso varchar(15) NOT NULL,
  PRIMARY KEY (id_articulo),
  FOREIGN KEY(cod_tipo_articulo) REFERENCES tipo_articulo(id_tipoarticulo),
  FOREIGN KEY(cod_tipo_producto) REFERENCES tipo_producto(id_tipoproducto)
) ;


INSERT INTO articulo (descripcion, precio_venta, precio_costo, stock, cod_tipo_articulo, cod_tipo_producto, fecha_ingreso) VALUES
('Abominación', 100000, 80000, 20, 1, 1, '2012-11-03'),
('Abominación', 100000, 80000, 20, 1, 2, '2012-11-03'),
('Abominación', 100000, 80000, 20, 1, 3, '2012-11-03'),
('Abominación', 100000, 80000, 20, 1, 4, '2012-11-03'),
('Adam Warlock', 70000, 50000, 55, 1, 1, '2012-10-11'),
('Adam Warlock', 70000, 50000, 55, 1, 2, '2012-10-11'),
('Adam Warlock', 70000, 50000, 55, 1, 3, '2012-10-11'),
('Adam Warlock', 70000, 50000, 55, 1, 4, '2012-10-11'),
('Agente Carter ', 150000, 130000, 1, 1, 1, '2012-09-01'),
('Agente Carter ', 150000, 130000, 1, 1, 2, '2012-09-01'),
('Agente Carter ', 150000, 130000, 1, 1, 3, '2012-09-01'),
('Agente Carter ', 150000, 130000, 1, 1, 4, '2012-09-01'),
('Alpha Flight ', 120000, 100000, 8, 1, 1, '2012-10-02'),
('Alpha Flight ', 120000, 100000, 8, 1, 2, '2012-10-02'),
('Alpha Flight ', 120000, 100000, 8, 1, 3, '2012-10-02'),
('Alpha Flight ', 120000, 100000, 8, 1, 4, '2012-10-02'),
('Amadeus Cho (Hulk)', 50000, 30000, 1, 1, 1, '2012-11-01'),
('Amadeus Cho (Hulk)', 50000, 30000, 1, 1, 2, '2012-11-01'),
('Amadeus Cho (Hulk)', 50000, 30000, 1, 1, 3, '2012-11-01'),
('Amadeus Cho (Hulk)', 50000, 30000, 1, 1, 4, '2012-11-01'),
('Ángel / Arcángel', 90000, 70000, 24, 1, 1, '2012-10-02'),
('Ángel / Arcángel', 90000, 70000, 24, 1, 2, '2012-10-02'),
('Ángel / Arcángel', 90000, 70000, 24, 1, 3, '2012-10-02'),
('Ángel / Arcángel', 90000, 70000, 24, 1, 4, '2012-10-02'),
('Ángela, asesina de Asgard', 50000, 30000, 12, 1, 1, '2012-10-20'),
('Ángela, asesina de Asgard', 50000, 30000, 12, 1, 2, '2012-10-20'),
('Ángela, asesina de Asgard', 50000, 30000, 12, 1, 3, '2012-10-20'),
('Ángela, asesina de Asgard', 50000, 30000, 12, 1, 4, '2012-10-20'),
('Annihilus', 70000, 50000, 8, 1, 1, '2012-11-02'),
('Annihilus', 70000, 50000, 8, 1, 2, '2012-11-02'),
('Annihilus', 70000, 50000, 8, 1, 3, '2012-11-02'),
('Annihilus', 70000, 50000, 8, 1, 4, '2012-11-02'),
('Ant-Man (Hombre Hormiga)', 60000, 40000, 20, 1, 1, '2012-10-23'),
('Ant-Man (Hombre Hormiga)', 60000, 40000, 20, 1, 2, '2012-10-23'),
('Ant-Man (Hombre Hormiga)', 60000, 40000, 20, 1, 3, '2012-10-23'),
('Ant-Man (Hombre Hormiga)', 60000, 40000, 20, 1, 4, '2012-10-23'),
('Anti-Venom', 60000, 40000, 17, 1, 1, '2012-10-23'),
('Anti-Venom', 60000, 40000, 17, 1, 2, '2012-10-23'),
('Anti-Venom', 60000, 40000, 17, 1, 3, '2012-10-23'),
('Anti-Venom', 60000, 40000, 17, 1, 4, '2012-10-23'),
('Antorcha Humana', 100000, 80000, 20, 1, 1, '2012-10-23'),
('Antorcha Humana', 100000, 80000, 20, 1, 2, '2012-10-23'),
('Antorcha Humana', 100000, 80000, 20, 1, 3, '2012-10-23'),
('Antorcha Humana', 100000, 80000, 20, 1, 4, '2012-10-23'),
('Apocalipsis', 30000, 20000, 30, 1, 1, '2012-10-03'),
('Apocalipsis', 30000, 20000, 30, 1, 2, '2012-10-03'),
('Apocalipsis', 30000, 20000, 30, 1, 3, '2012-10-03'),
('Apocalipsis', 30000, 20000, 30, 1, 4, '2012-10-03');