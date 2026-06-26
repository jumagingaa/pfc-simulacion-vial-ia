# Colección Postman

## Autenticación

### Login

POST

http://localhost:8080/api/auth/login

Body

```json
{
    "email":"admin@uteq.edu.ec",
    "password":"123456"
}
```

Respuesta esperada

```json
{
    "token":"JWT",
    "tipo":"Bearer"
}
```

---

### Registro

POST

http://localhost:8080/api/auth/register

Body

```json
{
    "nombre":"Jefferson",
    "apellido":"Umaginga",
    "email":"jefferson@uteq.edu.ec",
    "password":"123456"
}
```

---

## Escenarios

### Obtener todos

GET

```
http://localhost:8080/api/escenarios
```

---

### Obtener por id

GET

```
http://localhost:8080/api/escenarios/1
```

---

### Crear

POST

```
http://localhost:8080/api/escenarios
```

---

### Actualizar

PUT

```
http://localhost:8080/api/escenarios/1
```

---

### Eliminar

DELETE

```
http://localhost:8080/api/escenarios/1
```

---

## Simulaciones

### Obtener todas

GET

```
http://localhost:8080/api/simulaciones
```

---

### Obtener una

GET

```
http://localhost:8080/api/simulaciones/1
```

---

### Crear

POST

```
http://localhost:8080/api/simulaciones
```

---

### Actualizar

PUT

```
http://localhost:8080/api/simulaciones/1
```

---

### Eliminar

DELETE

```
http://localhost:8080/api/simulaciones/1
```