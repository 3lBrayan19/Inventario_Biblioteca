CREATE DATABASE IF NOT EXISTS inventario_biblioteca_db;
USE inventario_biblioteca_db;

-- ============================================
-- Tablas sin llaves foraneas (catalogos base)
-- ============================================
CREATE TABLE roles (
    id_rol BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE autores (
    id_autor BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL
);

CREATE TABLE editoriales (
    id_editorial BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(120) NOT NULL
);

CREATE TABLE categorias (
    id_categoria BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(80) NOT NULL UNIQUE
);

CREATE TABLE proveedores (
    id_proveedor BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(120) NOT NULL,
    telefono VARCHAR(20)
);

CREATE TABLE ubicaciones (
    id_ubicacion BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(60) NOT NULL
);

-- ============================================
-- Tablas con 1 llave foranea
-- ============================================
CREATE TABLE usuarios (
    id_usuario BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(120) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    id_rol BIGINT NOT NULL,
    FOREIGN KEY (id_rol) REFERENCES roles(id_rol)
);

-- ============================================
-- Tabla con 3 llaves foraneas
-- ============================================
CREATE TABLE libros (
    id_libro BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    isbn VARCHAR(20) NOT NULL UNIQUE,
    id_autor BIGINT NOT NULL,
    id_editorial BIGINT NOT NULL,
    id_categoria BIGINT NOT NULL,
    FOREIGN KEY (id_autor) REFERENCES autores(id_autor),
    FOREIGN KEY (id_editorial) REFERENCES editoriales(id_editorial),
    FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria)
);

-- ============================================
-- Tabla con 2 llaves foraneas
-- ============================================
CREATE TABLE ejemplares (
    id_ejemplar BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo_inventario VARCHAR(30) NOT NULL UNIQUE,
    estado VARCHAR(20) NOT NULL,
    id_libro BIGINT NOT NULL,
    id_ubicacion BIGINT NOT NULL,
    FOREIGN KEY (id_libro) REFERENCES libros(id_libro),
    FOREIGN KEY (id_ubicacion) REFERENCES ubicaciones(id_ubicacion)
);

-- ============================================
-- Tabla con 2 llaves foraneas (movimientos de inventario)
-- ============================================
CREATE TABLE movimientos_inventario (
    id_movimiento BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo_movimiento VARCHAR(20) NOT NULL,
    cantidad INT NOT NULL,
    fecha_movimiento DATE NOT NULL,
    id_ejemplar BIGINT NOT NULL,
    id_proveedor BIGINT NULL,
    FOREIGN KEY (id_ejemplar) REFERENCES ejemplares(id_ejemplar),
    FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor)
);

-- ============================================
-- Datos iniciales de ejemplo
-- ============================================
INSERT INTO roles (nombre) VALUES ('ADMIN'), ('BIBLIOTECARIO'), ('LECTOR');

INSERT INTO autores (nombre, apellido) VALUES
('Gabriel', 'García Márquez'),
('Mario', 'Vargas Llosa');

INSERT INTO editoriales (nombre) VALUES
('Sudamericana'),
('Planeta');

INSERT INTO categorias (nombre) VALUES
('Ficción'),
('Ciencia');

INSERT INTO proveedores (nombre, telefono) VALUES
('Distribuidora Andina', '966123456'),
('Libros del Sur SAC', '966987654');

INSERT INTO ubicaciones (nombre) VALUES
('Estante A-1'),
('Estante B-2');

INSERT INTO usuarios (nombre, apellido, email, password, id_rol) VALUES
('Brayan', 'Vicaña', 'brayan@correo.com', '123456', 1);

INSERT INTO libros (titulo, isbn, id_autor, id_editorial, id_categoria) VALUES
('Cien años de soledad', '9780307474728', 1, 1, 1),
('La ciudad y los perros', '9788432223268', 2, 2, 1);

INSERT INTO ejemplares (codigo_inventario, estado, id_libro, id_ubicacion) VALUES
('EJ-001', 'DISPONIBLE', 1, 1),
('EJ-002', 'DISPONIBLE', 2, 2);

INSERT INTO movimientos_inventario (tipo_movimiento, cantidad, fecha_movimiento, id_ejemplar, id_proveedor) VALUES
('ENTRADA', 5, '2026-09-01', 1, 1),
('ENTRADA', 3, '2026-09-05', 2, 2);
