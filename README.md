# Sistema de Simulación de Comportamiento Vial con Inteligencia Artificial

## Descripción

Backend desarrollado en Spring Boot para administrar usuarios, escenarios y simulaciones de un sistema de entrenamiento vial mediante Inteligencia Artificial.

## Tecnologías

- Java 21
- Spring Boot 3.5
- Spring Security
- JWT
- Spring Data JPA
- PostgreSQL
- Redis
- Flyway
- Docker Compose
- Maven

---

## Requisitos

- Java JDK 21
- Maven
- PostgreSQL
- Redis
- Docker Desktop

---

## Instalación

### 1. Clonar el proyecto

```bash
git clone https://github.com/TU_ORGANIZACION/pfc-simulacion-vial-ia.git
```

### 2. Entrar al backend

```bash
cd backend
```

### 3. Configurar application.yml

Modificar:

- usuario PostgreSQL
- contraseña
- nombre de la base de datos

---

### 4. Ejecutar

```bash
./mvnw spring-boot:run
```

Windows

```bash
mvnw.cmd spring-boot:run
```

---

### 5. Probar API

Abrir Postman

```
http://localhost:8080
```

---

## Arquitectura

```
Frontend Angular

↓

Spring Boot

↓

Spring Security

↓

JWT

↓

JPA

↓

PostgreSQL

↓

Redis
```

---

## Autores

Proyecto desarrollado para la Universidad Técnica Estatal de Quevedo.

Carrera de Software.