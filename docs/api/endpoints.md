# API REST - Sistema de Simulación de Comportamiento Vial con IA

## Autenticación

### Iniciar sesión

**POST**

```
/api/auth/login
```

Body:

```json
{
  "email": "usuario@uteq.edu.ec",
  "password": "123456"
}
```

Respuesta:

```json
{
  "token": "JWT",
  "tipo": "Bearer"
}
```

---

### Registrar usuario

**POST**

```
/api/auth/register
```

Body:

```json
{
  "nombre": "Jefferson",
  "apellido": "Umaginga",
  "email": "jefferson@uteq.edu.ec",
  "password": "123456"
}
```

---

## Escenarios

### Obtener escenarios

**GET**

```
/api/escenarios
```

---

### Obtener escenario por ID

**GET**

```
/api/escenarios/{id}
```

---

### Crear escenario

**POST**

```
/api/escenarios
```

---

### Actualizar escenario

**PUT**

```
/api/escenarios/{id}
```

---

### Eliminar escenario

**DELETE**

```
/api/escenarios/{id}
```

---

## Simulaciones

### Listar simulaciones

**GET**

```
/api/simulaciones
```

---

### Obtener simulación

**GET**

```
/api/simulaciones/{id}
```

---

### Crear simulación

**POST**

```
/api/simulaciones
```

---

### Actualizar simulación

**PUT**

```
/api/simulaciones/{id}
```

---

### Eliminar simulación

**DELETE**

```
/api/simulaciones/{id}
```