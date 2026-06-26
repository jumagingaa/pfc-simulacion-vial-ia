CREATE TABLE roles (
                       id BIGSERIAL PRIMARY KEY,
                       nombre VARCHAR(50) NOT NULL,
                       descripcion VARCHAR(255),
                       creado_en TIMESTAMPTZ NOT NULL DEFAULT NOW(),
                       actualizado_en TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE UNIQUE INDEX ux_roles_nombre ON roles(nombre);

CREATE TABLE usuarios (
                          id BIGSERIAL PRIMARY KEY,
                          nombre VARCHAR(100) NOT NULL,
                          apellido VARCHAR(100) NOT NULL,
                          email VARCHAR(150) NOT NULL,
                          password VARCHAR(255) NOT NULL,
                          estado VARCHAR(20) NOT NULL DEFAULT 'ACTIVO',
                          fecha_registro TIMESTAMPTZ NOT NULL DEFAULT NOW(),
                          rol_id BIGINT NOT NULL,
                          creado_en TIMESTAMPTZ NOT NULL DEFAULT NOW(),
                          actualizado_en TIMESTAMPTZ NOT NULL DEFAULT NOW(),

                          CONSTRAINT fk_usuarios_roles
                              FOREIGN KEY (rol_id)
                                  REFERENCES roles(id),

                          CONSTRAINT chk_usuarios_estado
                              CHECK (estado IN ('ACTIVO', 'INACTIVO'))
);

CREATE UNIQUE INDEX ux_usuarios_email ON usuarios(email);

CREATE TABLE escenarios (
                            id BIGSERIAL PRIMARY KEY,
                            nombre VARCHAR(100) NOT NULL,
                            descripcion VARCHAR(500),
                            tipo_via VARCHAR(50) NOT NULL,
                            nivel_dificultad INTEGER NOT NULL,
                            clima VARCHAR(50) NOT NULL,
                            densidad_trafico VARCHAR(50) NOT NULL,
                            creado_en TIMESTAMPTZ NOT NULL DEFAULT NOW(),
                            actualizado_en TIMESTAMPTZ NOT NULL DEFAULT NOW(),

                            CONSTRAINT chk_escenarios_nivel
                                CHECK (nivel_dificultad BETWEEN 1 AND 5)
);

CREATE TABLE simulaciones (
                              id BIGSERIAL PRIMARY KEY,
                              fecha_inicio TIMESTAMPTZ NOT NULL DEFAULT NOW(),
                              fecha_fin TIMESTAMPTZ,
                              estado VARCHAR(30) NOT NULL,
                              puntaje_final NUMERIC(5,2) NOT NULL DEFAULT 0,
                              usuario_id BIGINT NOT NULL,
                              escenario_id BIGINT NOT NULL,
                              creado_en TIMESTAMPTZ NOT NULL DEFAULT NOW(),
                              actualizado_en TIMESTAMPTZ NOT NULL DEFAULT NOW(),

                              CONSTRAINT fk_simulaciones_usuarios
                                  FOREIGN KEY (usuario_id)
                                      REFERENCES usuarios(id),

                              CONSTRAINT fk_simulaciones_escenarios
                                  FOREIGN KEY (escenario_id)
                                      REFERENCES escenarios(id),

                              CONSTRAINT chk_simulaciones_estado
                                  CHECK (estado IN ('INICIADA', 'FINALIZADA', 'CANCELADA')),

                              CONSTRAINT chk_simulaciones_puntaje
                                  CHECK (puntaje_final >= 0 AND puntaje_final <= 100)
);

CREATE OR REPLACE FUNCTION actualizar_fecha_modificacion()
RETURNS TRIGGER AS $$
BEGIN
    NEW.actualizado_en = NOW();
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_roles_actualizado
    BEFORE UPDATE ON roles
    FOR EACH ROW
    EXECUTE FUNCTION actualizar_fecha_modificacion();

CREATE TRIGGER trg_usuarios_actualizado
    BEFORE UPDATE ON usuarios
    FOR EACH ROW
    EXECUTE FUNCTION actualizar_fecha_modificacion();

CREATE TRIGGER trg_escenarios_actualizado
    BEFORE UPDATE ON escenarios
    FOR EACH ROW
    EXECUTE FUNCTION actualizar_fecha_modificacion();

CREATE TRIGGER trg_simulaciones_actualizado
    BEFORE UPDATE ON simulaciones
    FOR EACH ROW
    EXECUTE FUNCTION actualizar_fecha_modificacion();

INSERT INTO roles (nombre, descripcion) VALUES
                                            ('ADMIN', 'Administrador del sistema'),
                                            ('INSTRUCTOR', 'Instructor de conducción'),
                                            ('CONDUCTOR', 'Conductor en formación');