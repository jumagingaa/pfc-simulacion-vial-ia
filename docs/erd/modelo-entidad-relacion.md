# Diccionario de Datos

## Tabla: roles

| Campo | Tipo | Restricción | Descripción |
|-------|------|-------------|-------------|
| id | BIGSERIAL | PK | Identificador único del rol |
| nombre | VARCHAR(50) | UNIQUE, NOT NULL | Nombre del rol |
| descripcion | VARCHAR(255) | | Descripción del rol |

---

## Tabla: usuarios

| Campo | Tipo | Restricción | Descripción |
|-------|------|-------------|-------------|
| id | BIGSERIAL | PK | Identificador del usuario |
| nombre | VARCHAR(100) | NOT NULL | Nombres |
| apellido | VARCHAR(100) | NOT NULL | Apellidos |
| email | VARCHAR(150) | UNIQUE | Correo electrónico |
| password | VARCHAR(255) | NOT NULL | Contraseña cifrada |
| estado | VARCHAR(20) | CHECK | Estado del usuario |
| fecha_registro | TIMESTAMPTZ | | Fecha de registro |
| rol_id | BIGINT | FK | Rol asignado |

---

## Tabla: escenarios

| Campo | Tipo | Restricción | Descripción |
|-------|------|-------------|-------------|
| id | BIGSERIAL | PK | Identificador |
| nombre | VARCHAR(100) | NOT NULL | Nombre del escenario |
| descripcion | VARCHAR(500) | | Descripción |
| tipo_via | VARCHAR(50) | | Tipo de vía |
| nivel_dificultad | INTEGER | CHECK | Nivel de dificultad |
| clima | VARCHAR(50) | | Clima |
| densidad_trafico | VARCHAR(50) | | Densidad del tráfico |

---

## Tabla: simulaciones

| Campo | Tipo | Restricción | Descripción |
|-------|------|-------------|-------------|
| id | BIGSERIAL | PK | Identificador |
| fecha_inicio | TIMESTAMPTZ | | Inicio de la simulación |
| fecha_fin | TIMESTAMPTZ | | Fin de la simulación |
| estado | VARCHAR(30) | CHECK | Estado |
| puntaje_final | NUMERIC(5,2) | | Puntaje obtenido |
| usuario_id | BIGINT | FK | Usuario |
| escenario_id | BIGINT | FK | Escenario |