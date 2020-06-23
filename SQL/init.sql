
INSERT INTO "user"
    ( user_id, username, password, email, phone_number,
    cat_user_status, status, tx_id, tx_username, tx_host,
    tx_date)
VALUES
    (  nextval('user_user_id_seq') , 'mgomez', '12345678', 'mgomez@gmail.com', '70655567',
        'ACTIVE', 1, 1, 'root', '127.0.0.1',
        now()
    );


INSERT INTO "user"
( user_id, username, password, email, phone_number,
  cat_user_status, status, tx_id, tx_username, tx_host,
  tx_date)
VALUES
(  nextval('user_user_id_seq') , 'jperez', '123456', 'jperez@gmail.com', '70655570',
   'ACTIVE', 1, 1, 'root', '127.0.0.1',
   now()
);




INSERT INTO "user"
( user_id, username, password, email, phone_number,
  cat_user_status, status, tx_id, tx_username, tx_host,
  tx_date)
VALUES
(  nextval('user_user_id_seq') , 'pedrop', '12345', 'pedrop@gmail.com', '70534211',
   'ACTIVE', 1, 1, 'root', '127.0.0.1',
   now()
);

INSERT INTO "user"
( user_id, username, password, email, phone_number,
  cat_user_status, status, tx_id, tx_username, tx_host,
  tx_date)
VALUES
(  nextval('user_user_id_seq') , 'lmolina', '12345', 'lmolina@gmail.com', '70642331',
   'ACTIVE', 1, 1, 'root', '127.0.0.1',
   now()
);

INSERT INTO "user"
( user_id, username, password, email, phone_number,
  cat_user_status, status, tx_id, tx_username, tx_host,
  tx_date)
VALUES
(  nextval('user_user_id_seq') , 'hugoavila', '12345', 'hugoa@gmail.com', '6771277',
   'ACTIVE', 1, 1, 'root', '127.0.0.1',
   now()
);

/* Borrando features */

UPDATE "user_role"
SET status = 0
WHERE user_role_id = 3;


INSERT INTO feature (feature_code, feature_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('PAGE_USER_MANAGEMENT', 'Gestión de usuarios', 1, 1, 'admin', 'localhost', now());

INSERT INTO feature (feature_code, feature_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('PAGE_PRODUCT_MANAGEMENT', 'Gestión de productos', 1, 1, 'admin', 'localhost', now());

INSERT INTO feature (feature_code, feature_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('BUTTON_DELETE_USER', 'Botón para eliminar un usuario', 1, 1, 'admin', 'localhost', now());


INSERT INTO role ( role_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('ADMIN', 1,  1, 'admin', 'localhost', now());

INSERT INTO role ( role_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('WAREHOUSE_SUPERVISOR', 1,  1, 'admin', 'localhost', now());

INSERT INTO role ( role_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('WAREHOUSE_EMPLOYEE', 1,  1, 'admin', 'localhost', now());

-- ADMIN role
INSERT INTO role_feature ( role_id, feature_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (1, 1, 1,  1, 'admin', 'localhost', now());

INSERT INTO role_feature ( role_id, feature_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (1, 3, 1,  1, 'admin', 'localhost', now());

-- WAREHOUSE_SUPERVISOR
INSERT INTO role_feature ( role_id, feature_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (2, 1, 1,  1, 'admin', 'localhost', now());

INSERT INTO role_feature ( role_id, feature_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (2, 2, 1,  1, 'admin', 'localhost', now());

-- WAREHOUSE_EMPLOYY
INSERT INTO role_feature ( role_id, feature_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (3, 2, 1,  1, 'admin', 'localhost', now());

-- CONFIGURACIÓN DE USUARIOS

INSERT INTO user_role ( user_id, role_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (2, 2, 1,  1, 'admin', 'localhost', now());

INSERT INTO user_role ( user_id, role_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (2, 1, 1,  1, 'admin', 'localhost', now());

INSERT INTO user_role ( user_id, role_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (2, 3, 1,  1, 'admin', 'localhost', now());

-- CAMBIOS A LA BASE DE DATOS

ALTER TABLE warehouse ALTER COLUMN warehouse_name TYPE varchar(100);

ALTER TABLE provider ALTER COLUMN provider_name TYPE varchar(100);

ALTER TABLE "order" ADD COLUMN receipt varchar(100);

-- ALTER TABLE product RENAME COLUMN product_attributes TO format;

ALTER TABLE product ALTER COLUMN product_description TYPE text;

ALTER TABLE product ADD COLUMN creation_date timestamp;

-- CONFIGURACIÓN TABLA PRODUCT

INSERT INTO product
( product_id, product_code, cat_product_type, product_name, product_description,
  format, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_product_id_seq') , '101', 'MOVIE', 'A la hora señalada', 'Un asesino y sus compadres planean venganza contra un alguacil abandonado por el pueblo.',
   'DVD', 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product
( product_id, product_code, cat_product_type, product_name, product_description,
  format, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_product_id_seq') , '102', 'MOVIE', 'Africa mía', 'La Baronesa Bixen, quien utiliza como escritora el seudónimo de Isak Denisen, se enamora del cazador británico Denys Finch Hatton a principios del siglo XX en Kenia.',
   'Blue-Ray', 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product
( product_id, product_code, cat_product_type, product_name, product_description,
  format, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_product_id_seq') , '103', 'MOVIE', 'Al otro lado del viento', 'Después de años de exilio en Europa, un inconformista director regresa a Hollywood para terminar su película "The Other Side of the Wind".',
   'DVD', 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product
( product_id, product_code, cat_product_type, product_name, product_description,
  format, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_product_id_seq') , '104', 'MOVIE', 'Blade Runner: The Final Cut', 'En un futuro sombrío y lluvioso, un expolicía vuelve al servicio para buscar y destruir a un grupo de androides que fingen ser humanos para, integrados en la sociedad, encontrar a su creador y matarlo.',
   'Blue-Ray', 1, 1, 'root', '127.0.0.1', now()
);

UPDATE product SET format = 'DVD' WHERE product_id = 1;
UPDATE product SET format = 'DVD' WHERE product_id = 3;
UPDATE product SET format = 'Blu-Ray' WHERE product_id = 2;
UPDATE product SET format = 'Blu-Ray' WHERE product_id = 4;

UPDATE product SET creation_date = '2020-01-15' WHERE product_id = 1;
UPDATE product SET creation_date = '2020-01-16' WHERE product_id = 2;
UPDATE product SET creation_date = '2020-01-17' WHERE product_id = 3;
UPDATE product SET creation_date = '2020-01-18' WHERE product_id = 4;

-- CONFIGURACION TABLA DE PROVIDER

INSERT INTO provider
( provider_id, provider_name, cat_country,
  status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('provider_provider_id_seq') , 'Piratas Perú', 'PERÚ',
   1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO provider
( provider_id, provider_name, cat_country,
  status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('provider_provider_id_seq') , 'Colopeliculas', 'COLOMBIA',
   1, 1, 'root', '127.0.0.1', now()
);

-- CONFIGURACION TABLA DE WAREHOUSE

INSERT INTO warehouse
( warehouse_id, warehouse_name, warehouse_address,
  status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('warehouse_warehouse_id_seq') , 'La Paz', 'Calle 10 de Calacoto Av. Ballivián N100',
   1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO warehouse
( warehouse_id, warehouse_name, warehouse_address,
  status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('warehouse_warehouse_id_seq') , 'Santa Cruz', 'Av. Irala N° 585 Of. 201, Primer Anillo',
   1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO warehouse
( warehouse_id, warehouse_name, warehouse_address,
  status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('warehouse_warehouse_id_seq') , 'Cochabamba', '590 Calle B. de las Casas',
   1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO warehouse
( warehouse_id, warehouse_name, warehouse_address,
  status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('warehouse_warehouse_id_seq') , 'Tarija', 'Calle Delfín Pino Nº 734 (Entre O`Connor y Ejército)',
   1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO warehouse
( warehouse_id, warehouse_name, warehouse_address,
  status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('warehouse_warehouse_id_seq') , 'Sucre', 'Calle Bustillos #284 (Zona Central)',
   1, 1, 'root', '127.0.0.1', now()
);

-- CONFIGURACION TABLA DE ORDER

INSERT INTO "order"
( order_id, provider_id, warehouse_id, order_user_id, date_requested,
  status, tx_id, tx_username, tx_host, tx_date, receipt, date_received)
VALUES
(  nextval('order_order_id_seq'), 1, 1, 2, '2020-04-05 15:30:00',
   1, 1, 'root', '127.0.0.1', now(), 'F-1', '2020-04-15 12:00:01'
);

INSERT INTO "order"
( order_id, provider_id, warehouse_id, order_user_id, date_requested,
  status, tx_id, tx_username, tx_host, tx_date, receipt, date_received)
VALUES
(  nextval('order_order_id_seq'), 2, 1, 2, '2020-05-10 10:30:00',
   1, 1, 'root', '127.0.0.1', now(), 'F-1', '2020-05-21 14:05:00'
);

INSERT INTO "order"
( order_id, provider_id, warehouse_id, order_user_id, date_requested,
  status, tx_id, tx_username, tx_host, tx_date, receipt, date_received)
VALUES
(  nextval('order_order_id_seq'), 1, 1, 2, '2020-05-24 11:40:00',
   1, 1, 'root', '127.0.0.1', now(), 'F-1', '2020-06-03 17:10:00'
);

-- CONFIGURACION TABLA DE PRODUCT-ORDER

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, qtty_received, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 1, 1, 10, 60,
   60, 60, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, qtty_received, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 1, 3, 10, 80,
   80, 70, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, qtty_received, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 2, 2, 10, 50,
   50, 45, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, qtty_received, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 2, 4, 10, 90,
   90, 90, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, qtty_received, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 3, 1, 10, 40,
   40, 40, 1, 1, 'root', '127.0.0.1', now()
);

SELECT prod.product_code, prod.product_name, prod.format, prod.creation_date, prov.provider_name, sum(prod_or.qtty_received)
FROM product prod JOIN product_order prod_or
on prod.product_id = prod_or.product_id
JOIN "order" ord on ord.order_id = prod_or.order_id
JOIN provider prov on prov.provider_id = ord.provider_id
JOIN warehouse wrh on wrh.warehouse_id = ord.warehouse_id
WHERE prod.status = 1
AND prod_or.status = 1
AND ord.status = 1
AND prov.status = 1
AND wrh.status = 1
AND wrh.warehouse_name = 'La Paz'
GROUP BY prod_or.product_id, prod.product_code, prod.product_name, prod.format, prod.creation_date, prov.provider_name ;

