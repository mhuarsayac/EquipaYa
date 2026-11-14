USE equipa_ya;
INSERT INTO cliente (documento, nombre, telefono)
VALUES ('DNI123', 'Juan Perez', '987654321'),
       ('RUC123', 'Producciones Andinas SAC', '912345678'),
       ('DNI456', 'Maria Gonzales', '956789123'),
       ('RUC456', 'Eventos Lima SAC', '934567812'),
       ('DNI789', 'Carlos Ramirez', '945678231');

INSERT INTO tipo(id_tipo, nombre)
VALUES ('TE1', 'Camara'),
       ('TE2', 'Iluminacion'),
       ('TE3', 'Audio');

INSERT INTO equipo (codigo_equipo, descripcion, tarifa_diaria, disponible, id_tipo)
VALUES ('C001', 'Camara Sony FX3', 250.00, 'S', 'TE1'),
       ('C002', 'Camara Canon EOS R6', 180.00, 'N', 'TE1'),
       ('I001', 'Panel LED Godox', 90.00, 'S', 'TE2'),
       ('I002', 'Kit de iluminacion Neewer', 120.00, 'N', 'TE2'),
       ('A001', 'Microfono Shure SM58', 60.00, 'S', 'TE3'),
       ('A002', 'Grabadora Zoom H6', 100.00, 'S', 'TE3'),
       ('A003', 'Sistema de microfonos inalambricos', 150.00, 'S', 'TE3');

INSERT INTO alquiler (documento, codigo_equipo, fecha_inicio, numero_dias, monto_cobrado, devuelto)
VALUES ('DNI123', 'C001', '2026-11-01', 3, 862.50, 'S'),
       ('RUC123', 'C002', '2026-11-10', 2, 414.00, 'N'),
       ('DNI456', 'I001', '2026-10-20', 7, 567.00, 'S'),
       ('RUC456', 'I002', '2026-11-12', 6, 648.00, 'N'),
       ('DNI789', 'A001', '2026-10-15', 1, 120.00, 'S'),
       ('DNI123', 'A002', '2026-11-05', 4, 400.00, 'S');