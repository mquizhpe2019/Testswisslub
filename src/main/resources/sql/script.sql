
CREATE DATABASE testswisslub;

USE testswisslub;

CREATE TABLE  movimiento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_empresa BIGINT NOT NULL,
    descripcion VARCHAR(255),
    bodega_origen_codigo VARCHAR(50) NOT NULL,
    bodega_destino_codigo VARCHAR(50) NOT NULL,
    fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_entrega DATETIME,
    estado VARCHAR(20) NOT NULL
    ) ;
	

CREATE TABLE  movimiento_detalle (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    movimiento_id BIGINT NOT NULL,
    item_codigo VARCHAR(20) NOT NULL,
    cantidad_enviada DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (movimiento_id) REFERENCES movimiento(id) ON DELETE CASCADE ON UPDATE CASCADE
);

--Insert movimiento




INSERT INTO `testswisslub`.`movimiento`  (
`id_empresa`,
`descripcion`,
`bodega_origen_codigo`,
`bodega_destino_codigo`,
`fecha_creacion`,
`fecha_entrega`,
`estado`) VALUES ('1001','Traslado Mercaderia Auto de Lujo','BOD-01','BOD-02','2024-12-14 07:36:45','2024-12-15 15:00:00','P');


INSERT INTO `testswisslub`.`movimiento`  (
`id_empresa`,
`descripcion`,
`bodega_origen_codigo`,
`bodega_destino_codigo`,
`fecha_creacion`,
`fecha_entrega`,
`estado`) VALUES ('1001','Traslado Mercaderia','BOD-01','BOD-02','2024-12-14 08:36:45','2024-12-15 16:00:00','P');



INSERT INTO `testswisslub`.`movimiento`  (
`id_empresa`,
`descripcion`,
`bodega_origen_codigo`,
`bodega_destino_codigo`,
`fecha_creacion`,
`fecha_entrega`,
`estado`) VALUES ('1001','Traslado Mercaderia Radios y luces','BOD-02','BOD-03','2024-12-14 09:36:45','2024-12-15 15:30:00','P');




INSERT INTO `testswisslub`.`movimiento`  (
`id_empresa`,
`descripcion`,
`bodega_origen_codigo`,
`bodega_destino_codigo`,
`fecha_creacion`,
`fecha_entrega`,
`estado`) VALUES ('1002','Traslado Mercaderia sensores','BOD-03','BOD-04','2024-12-15 09:36:45','2024-12-16 15:30:00','P');



INSERT INTO `testswisslub`.`movimiento`  (
`id_empresa`,
`descripcion`,
`bodega_origen_codigo`,
`bodega_destino_codigo`,
`fecha_creacion`,
`fecha_entrega`,
`estado`) VALUES ('1002','Traslado Mercaderia para Camioneta','BOD-03','BOD-04','2024-12-15 09:50:45','2024-12-16 11:30:00','P');



INSERT INTO `testswisslub`.`movimiento`  (
`id_empresa`,
`descripcion`,
`bodega_origen_codigo`,
`bodega_destino_codigo`,
`fecha_creacion`,
`fecha_entrega`,
`estado`) VALUES ('1002','Traslado Mercaderia para Camioneta Dmax','BOD-03','BOD-04','2024-12-15 09:50:45','2024-12-16 11:30:00','P');


-- insert 

INSERT INTO `testswisslub`.`movimiento_detalle`(`movimiento_id`,`item_codigo`,`cantidad_enviada`) VALUES (1,'5247001',200);
INSERT INTO `testswisslub`.`movimiento_detalle`(`movimiento_id`,`item_codigo`,`cantidad_enviada`) VALUES (1,'5347001',300);
INSERT INTO `testswisslub`.`movimiento_detalle`(`movimiento_id`,`item_codigo`,`cantidad_enviada`) VALUES (1,'5487001',120);
INSERT INTO `testswisslub`.`movimiento_detalle`(`movimiento_id`,`item_codigo`,`cantidad_enviada`) VALUES (7,'001',500);
INSERT INTO `testswisslub`.`movimiento_detalle`(`movimiento_id`,`item_codigo`,`cantidad_enviada`) VALUES (2,'5547001',200);
INSERT INTO `testswisslub`.`movimiento_detalle`(`movimiento_id`,`item_codigo`,`cantidad_enviada`) VALUES (3,'5247001',200);
INSERT INTO `testswisslub`.`movimiento_detalle`(`movimiento_id`,`item_codigo`,`cantidad_enviada`) VALUES (4,'5247001',200);


