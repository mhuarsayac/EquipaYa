CREATE DATABASE IF NOT EXISTS EquipaYa;
USE EquipaYa;

CREATE TABLE cliente
(
    documento VARCHAR(11),
    nombre    VARCHAR(100) NOT NULL,
    telefono  VARCHAR(9)  NOT NULL,

    CONSTRAINT cliente_documento_pk
        PRIMARY KEY (documento)
);

CREATE TABLE equipo
(
    codigo_equipo VARCHAR(5),
    descripcion   VARCHAR(50)    NOT NULL,
    tarifa_diaria DECIMAL(10, 2) NOT NULL,
    disponible    CHAR(1)        NOT NULL,
    tipo_equipo   VARCHAR(30)    NOT NULL,

    CONSTRAINT equipo_codigo_pk
        PRIMARY KEY (codigo_equipo),

    CONSTRAINT equipo_disponible_ck
        CHECK (disponible IN ('S', 'N')),

    CONSTRAINT equipo_tarifa_ck
        CHECK (tarifa_diaria > 0)
);

CREATE TABLE alquiler
(
    id_alquiler   INT AUTO_INCREMENT,
    documento     VARCHAR(11)    NOT NULL,
    codigo_equipo VARCHAR(5)     NOT NULL,
    fecha_inicio  DATE           NOT NULL,
    numero_dias   INT            NOT NULL,
    monto_cobrado DECIMAL(10, 2) NOT NULL,
    devuelto      CHAR(1)        NOT NULL,

    CONSTRAINT alquiler_id_pk
        PRIMARY KEY (id_alquiler),

    CONSTRAINT alquiler_cliente_fk
        FOREIGN KEY (documento)
            REFERENCES cliente (documento),

    CONSTRAINT alquiler_equipo_fk
        FOREIGN KEY (codigo_equipo)
            REFERENCES equipo (codigo_equipo),

    CONSTRAINT alquiler_dias_ck
        CHECK (numero_dias > 0),

    CONSTRAINT alquiler_monto_ck
        CHECK (monto_cobrado >= 0),

    CONSTRAINT alquiler_devuelto_ck
        CHECK (devuelto IN ('S', 'N'))
);