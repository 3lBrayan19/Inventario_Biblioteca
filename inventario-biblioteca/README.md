# Sistema de Inventario de Biblioteca

Proyecto Spring Boot (Java 21) con arquitectura en capas (Controller / Service / Repository / Model)
y MySQL. 10 tablas, con un máximo de 3 llaves foráneas por tabla.

## Estructura de la base de datos (10 tablas)

| Tabla | Llaves foráneas |
|---|---|
| roles | 0 |
| autores | 0 |
| editoriales | 0 |
| categorias | 0 |
| proveedores | 0 |
| ubicaciones | 0 |
| usuarios | 1 (id_rol) |
| libros | 3 (id_autor, id_editorial, id_categoria) |
| ejemplares | 2 (id_libro, id_ubicacion) |
| movimientos_inventario | 2 (id_ejemplar, id_proveedor) |

## Pasos para correrlo

1. Ejecuta `database/script_mysql.sql` completo en MySQL Workbench (crea la base `inventario_biblioteca_db` con datos de ejemplo).
2. Abre esta carpeta en VS Code.
3. Revisa `src/main/resources/application.properties`: si tu contraseña de MySQL NO es `root123`, cámbiala ahí.
4. Abre `InventarioBibliotecaApplication.java` y dale **Run**.
5. Espera a ver `Started InventarioBibliotecaApplication` y `Tomcat started on port 8080`.
6. Prueba en Thunder Client: `GET http://localhost:8080/api/roles`

## Endpoints disponibles

Todos siguen el mismo patrón CRUD: `GET /api/<recurso>`, `GET /api/<recurso>/{id}`, `POST /api/<recurso>`, `PUT /api/<recurso>/{id}`, `DELETE /api/<recurso>/{id}`

- `/api/roles`
- `/api/usuarios`
- `/api/autores`
- `/api/editoriales`
- `/api/categorias`
- `/api/libros`
- `/api/proveedores`
- `/api/ubicaciones`
- `/api/ejemplares`
- `/api/movimientos`

## Ejemplos de JSON para POST

### POST /api/usuarios
```json
{
  "nombre": "Ana",
  "apellido": "Torres",
  "email": "ana@correo.com",
  "password": "123456",
  "rol": { "idRol": 3 }
}
```

### POST /api/libros
```json
{
  "titulo": "Rayuela",
  "isbn": "9789500000000",
  "autor": { "idAutor": 1 },
  "editorial": { "idEditorial": 1 },
  "categoria": { "idCategoria": 1 }
}
```

### POST /api/ejemplares
```json
{
  "codigoInventario": "EJ-003",
  "estado": "DISPONIBLE",
  "libro": { "idLibro": 1 },
  "ubicacion": { "idUbicacion": 1 }
}
```

### POST /api/movimientos
```json
{
  "tipoMovimiento": "ENTRADA",
  "cantidad": 10,
  "fechaMovimiento": "2026-09-27",
  "ejemplar": { "idEjemplar": 1 },
  "proveedor": { "idProveedor": 1 }
}
```
