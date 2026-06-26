# Evidencias de Seguridad OWASP - Entrega 1B

## 1. BCrypt con costo 12

El sistema utiliza BCrypt para cifrar contraseñas con un factor de costo 12.

Archivo:

`SecurityConfig.java`

Código:

```java
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(12);
}