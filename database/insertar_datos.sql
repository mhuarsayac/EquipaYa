USE equipaya;
INSERT INTO cliente (documento, nombre, telefono)
VALUES ('DNI123', 'Juan Perez', '987654321'),
       ('RUC123', 'Producciones Andinas SAC', '912345678'),
       ('DNI456', 'Maria Gonzales', '956789123'),
       ('RUC456', 'Eventos Lima SAC', '934567812'),
       ('DNI789', 'Carlos Ramirez', '945678231');

INSERT INTO equipo (codigo_equipo, descripcion, tarifa_diaria, disponible, tipo_equipo)
VALUES ('C001', 'Camara Sony FX3', 250.00, 'S', 'CAMARA'),
       ('C002', 'Camara Canon EOS R6', 180.00, 'N', 'CAMARA'),
       ('I001', 'Panel LED Godox', 90.00, 'S', 'ILUMINACION'),
       ('I002', 'Kit de iluminacion Neewer', 120.00, 'N', 'ILUMINACION'),
       ('A001', 'Microfono Shure SM58', 60.00, 'S', 'AUDIO'),
       ('A002', 'Grabadora Zoom H6', 100.00, 'S', 'AUDIO'),
       ('A003', 'Sistema de microfonos inalambricos', 150.00, 'S', 'AUDIO');

INSERT INTO alquiler (id_alquiler, documento, codigo_equipo, fecha_inicio, numero_dias, monto_cobrado, devuelto)
VALUES ('A001', 'DNI123', 'C001', '2026-11-01', 3, 862.50, 'S'),
       ('A002', 'RUC123', 'C002', '2026-11-10', 2, 575.00, 'N'),
       ('A003', 'DNI456', 'I001', '2026-10-20', 7, 567.00, 'S'),
       ('A004', 'RUC456', 'I002', '2026-11-12', 6, 648.00, 'N'),
       ('A005', 'DNI789', 'A001', '2026-10-15', 1, 120.00, 'S'),
       ('A006', 'DNI123', 'A002', '2026-11-05', 4, 400.00, 'S');