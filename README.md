#  Backend - Test Aldeamo Message

Este proyecto es el backend de una aplicación para la gestión de mensajes, construido con **Spring Boot 3**, **Spring Security con JWT**, **Mysql**, y documentado con **Swagger / OpenAPI**.

---

## Requisitos Previos

- Tener instalado **Docker** y **Docker Compose**
- Puerto `8080` libre en tu máquina

---

## Ejecución del Proyecto

1. Clona el repositorio:

   ```bash
   git clone https://github.com/afrancom2/Test-Aldeamo
   cd test
   ```

2. Levanta los servicios usando Docker:

   ```bash
   docker compose up --build
   ```

3. Una vez que el contenedor esté corriendo, accede a la documentación Swagger:

   👉 http://localhost:8080/aldeamo/swagger-ui.html

---

##  Autenticación JWT

Para acceder a los endpoints protegidos necesitas un **token JWT**. Primero debes autenticarte.

###  Endpoint de Login

```
curl --location 'http://localhost:8080/aldeamo/auth/login' \
--header 'Content-Type: application/json' \
--data '{
  "documentNumber": "123456",
  "password": "admin123"
}'
```

**Body (JSON):**

```json
{
  "documentNumber": "123456",
  "password": "admin123"
}
```

**Respuesta:**

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5..."
}
```

> Guarda ese token y úsalo en las siguientes peticiones como encabezado:

```
Authorization: Bearer <tu-token>
```

---

##  Documentación Swagger

Swagger UI está disponible en:

👉 [http://localhost:8080/sysman/swagger-ui.html](http://localhost:8080/sysman/swagger-ui.html)

---

##  Endpoints Disponibles

| Método | Endpoint      | Descripción                 | Auth Requerido |
|--------|---------------|-----------------------------|----------------|
| POST   | `/auth/login` | Login y generación de JWT   | ❌             |
| GET    | `/message `   | Lista total de mensajes     | ✅             |
| POST   | `/message `   | Guardado de mensajes        | ✅             |


---

##  Usuario de Prueba

```bash
Número de documento: 123456
Contraseña: admin123
```

Este usuario es cargado por defecto desde el script `init.sql` al inicializar la base de datos.

---

## ️ Estructura del Proyecto

```
fullstack.backend
├── db                   # Script SQL para crear tablas y datos iniciales
├── application          # Controladores y servicios
│   ├── Controller       # Controladores REST
│   ├── Repository       # Guardado y consulta en BD
│   ├── Services         # Servicios con logica de negocio
├── domain               # Entidades, request y response
├── infraestructure      # Configuraciones spring security y open api
├── util
├── resources
│   ├── application.properties
└── Dockerfile + docker-compose.yml
```

---

## Tecnologías Utilizadas

- Java 17
- Spring Boot 3.x
- Spring Security + JWT
- Mysql
- Swagger / Springdoc OpenAPI
- Docker & Docker Compose

---

## Autor

Andrés Felipe Franco Monroy
GitHub: [afrancom2](https://github.com/afrancom2)  
Email: afrancom2@gmail.com

---

## Notas

- Si necesitas reinicializar la base de datos, puedes bajar los contenedores y volver a correr `docker compose up --build`.
- Revisa que el archivo `init.sql` tenga la estructura correcta con los datos requeridos.