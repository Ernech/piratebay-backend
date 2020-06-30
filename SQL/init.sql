-- INSERTANDO EN LA TABLA USUARIO
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

-- Insertando los features

INSERT INTO feature (feature_code, feature_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('PAGE_USER_MANAGEMENT', 'Gestión de usuarios', 1, 1, 'admin', 'localhost', now());

INSERT INTO feature (feature_code, feature_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('PAGE_PRODUCT_MANAGEMENT', 'Gestión de productos', 1, 1, 'admin', 'localhost', now());

INSERT INTO feature (feature_code, feature_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('BUTTON_DELETE_USER', 'Botón para eliminar un usuario', 1, 1, 'admin', 'localhost', now());

-- Insertando los roles

INSERT INTO role ( role_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('ADMIN', 1,  1, 'admin', 'localhost', now());

INSERT INTO role ( role_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('WAREHOUSE_SUPERVISOR', 1,  1, 'admin', 'localhost', now());

INSERT INTO role ( role_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('WAREHOUSE_EMPLOYEE', 1,  1, 'admin', 'localhost', now());

-- Insertando los features de cada rol
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

-- WAREHOUSE_EMPLOYEE
INSERT INTO role_feature ( role_id, feature_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (3, 2, 1,  1, 'admin', 'localhost', now());

-- Configuración de los usuarios y sus roles

INSERT INTO user_role ( user_id, role_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (2, 2, 1,  1, 'admin', 'localhost', now());

INSERT INTO user_role ( user_id, role_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (2, 1, 1,  1, 'admin', 'localhost', now());

INSERT INTO user_role ( user_id, role_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (2, 3, 1,  1, 'admin', 'localhost', now());

-- Insertando películas

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

-- Agregando más películas

INSERT INTO product
( product_id, product_code, cat_product_type, product_name, product_description,
  format, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_product_id_seq') , '105', 'MOVIE', 'Historia de un matrimonio', 'Un director de teatro y su mujer, actriz, luchan por superar un divorcio que les lleva al extremo tanto en lo personal como en lo creativo.',
   'DVD', 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product
( product_id, product_code, cat_product_type, product_name, product_description,
  format, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_product_id_seq') , '106', 'MOVIE', 'Historia de un matrimonio', 'Un director de teatro y su mujer, actriz, luchan por superar un divorcio que les lleva al extremo tanto en lo personal como en lo creativo.',
   'Blue-Ray', 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product
( product_id, product_code, cat_product_type, product_name, product_description,
  format, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_product_id_seq') , '107', 'MOVIE', 'Parásitos', 'Tanto Gi Taek como su familia están sin trabajo. Cuando su hijo mayor, Gi Woo, empieza a impartir clases particulares en la adinerada casa de los Park, las dos familias, que tienen mucho en común pese a pertenecer a dos mundos totalmente distintos, entablan una relación de resultados imprevisibles.',
   'Blue-Ray', 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product
( product_id, product_code, cat_product_type, product_name, product_description,
  format, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_product_id_seq') , '108', 'MOVIE', 'Forrest Gump', 'La simpleza e inocencia de un sureño lo impulsan a través de hechos importantes de la historia moderna de EE.UU.',
   'DVD', 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product
( product_id, product_code, cat_product_type, product_name, product_description,
  format, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_product_id_seq') , '109', 'MOVIE', 'La la land', 'Sebastian, un pianista de jazz, y Mia, una aspirante a actriz, se enamoran locamente; pero la ambición desmedida que tienen por triunfar en sus respectivas carreras, en una ciudad como Los Ángeles, repleta de competencia y carente de piedad, pone en peligro su amor.',
   'Blue-Ray', 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product
( product_id, product_code, cat_product_type, product_name, product_description,
  format, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_product_id_seq') , '110', 'MOVIE', 'La isla siniestra', 'Un alguacil de los años cincuenta persigue a una asesina que escapó de un sanatorio en una isla remota, y hay pistas de hechos macabros cometidos en su interior.',
   'DVD', 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product
( product_id, product_code, cat_product_type, product_name, product_description,
  format, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_product_id_seq') , '111', 'MOVIE', 'Hambre de poder', 'La historia de cómo, en la década de 1950, un vendedor llamado Ray Croc, sorprendido por la velocidad y eficiencia con la que los hermanos Richard y Maurice McDonald dirigían su hamburguesería en el sur de California, se adueñó del negocio y lo convirtió en la cadena de comida rápida más conocida del mundo.',
   'Blue-Ray', 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product
( product_id, product_code, cat_product_type, product_name, product_description,
  format, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_product_id_seq') , '112', 'MOVIE', 'Amar rezar comer', 'Liz Gilbert pensó que tenía todo lo que ella quería en la vida: una casa, un marido y una carrera exitosa. Pero un día descubre que ya no quiere más esa vida, por lo que decide poner fin a su matrimonio y emprender un viaje de autodescubrimiento que la lleva a Italia, India e Indonesia.',
   'Blue-Ray', 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product
( product_id, product_code, cat_product_type, product_name, product_description,
  format, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_product_id_seq') , '113', 'MOVIE', 'Los siete pecados capitales', 'Somerset es un solitario y veterano detective a punto de retirarse que se encuentra con Mills, un joven impulsivo. Ambos investigan un particular asesinato. Es este el primero de una serie de crímenes que aluden los siete pecados capitales.',
   'Blue-Ray', 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product
( product_id, product_code, cat_product_type, product_name, product_description,
  format, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_product_id_seq') , '114', 'MOVIE', 'Una esposa de mentira', 'El cirujano Danny decide contratar a su ayudante Katherine, una madre soltera con hijos, para que finjan ser su familia. Su intención es demostrarle a Palmer que su amor por ella es tan grande que está a punto de divorciarse de su mujer.',
   'DVD', 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product
( product_id, product_code, cat_product_type, product_name, product_description,
  format, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_product_id_seq') , '115', 'MOVIE', 'La gran apuesta', 'Cuatro sagaces inversores intentan sacar provecho de la crisis económica que comenzó a padecer el mundo en el año 2008. Pero sus inversiones de riesgo les acaban conduciendo al lado más tenebroso de la economía, donde nada ni nadie es lo que parece ser.',
   'DVD', 1, 1, 'root', '127.0.0.1', now()
);

-- Insertando a los proveedores

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

-- Agregando los almacenes

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

-- Agregando órdenes a la tabla

INSERT INTO "order"
( order_id, provider_id, warehouse_id, order_user_id, date_requested,
  status, tx_id, tx_username, tx_host, tx_date, receipt, date_received, concept)
VALUES
(  nextval('order_order_id_seq'), 1, 1, 2, '2020-04-05 15:30:00',
   1, 1, 'root', '127.0.0.1', now(), 'F-1', '2020-04-15 12:00:01', 'Compra'
);

INSERT INTO "order"
( order_id, provider_id, warehouse_id, order_user_id, date_requested,
  status, tx_id, tx_username, tx_host, tx_date, receipt, date_received, concept)
VALUES
(  nextval('order_order_id_seq'), 2, 1, 2, '2020-05-10 10:30:00',
   1, 1, 'root', '127.0.0.1', now(), 'F-2', '2020-05-21 14:05:00', 'Compra'
);

INSERT INTO "order"
( order_id, provider_id, warehouse_id, order_user_id, date_requested,
  status, tx_id, tx_username, tx_host, tx_date, receipt, date_received, concept)
VALUES
(  nextval('order_order_id_seq'), 1, 1, 2, '2020-05-24 11:40:00',
   1, 1, 'root', '127.0.0.1', now(), 'F-3', '2020-06-03 17:10:00', 'Compra'
);

INSERT INTO "order"
( order_id, provider_id, warehouse_id, order_user_id, date_requested,
  status, tx_id, tx_username, tx_host, tx_date, receipt, date_received, concept)
VALUES
(  nextval('order_order_id_seq'), 1, 1, 2, '2020-05-13 15:30:00',
   1, 1, 'root', '127.0.0.1', now(), 'F-4', '2020-05-20 12:00:01', 'Compra'
);

INSERT INTO "order"
( order_id, provider_id, warehouse_id, order_user_id, date_requested,
  status, tx_id, tx_username, tx_host, tx_date, receipt, date_received, concept)
VALUES
(  nextval('order_order_id_seq'), 1, 1, 2, '2020-06-21 19:30:00',
   1, 1, 'root', '127.0.0.1', now(), 'F-5', '2020-06-27 12:30:00', 'Compra'
);

INSERT INTO "order"
( order_id, provider_id, warehouse_id, order_user_id, date_requested,
  status, tx_id, tx_username, tx_host, tx_date, receipt, date_received, concept)
VALUES
(  nextval('order_order_id_seq'), 1, 1, 2, '2020-06-28 11:30:00',
   1, 1, 'root', '127.0.0.1', now(), 'F-6', '2020-07-02 12:30:00', 'Compra'
);

-- Nuevas órdenes para el resto de los almacenes

INSERT INTO "order"
( order_id, provider_id, warehouse_id, order_user_id, date_requested,
  status, tx_id, tx_username, tx_host, tx_date, receipt, date_received, concept)
VALUES
(  nextval('order_order_id_seq'), 1, 2, 2, '2020-04-13 10:30:00',
   1, 1, 'root', '127.0.0.1', now(), 'F-1', '2020-04-20 12:30:00', 'Compra'
);

INSERT INTO "order"
( order_id, provider_id, warehouse_id, order_user_id, date_requested,
  status, tx_id, tx_username, tx_host, tx_date, receipt, date_received, concept)
VALUES
(  nextval('order_order_id_seq'), 2, 2, 2, '2020-05-12 11:30:00',
   1, 1, 'root', '127.0.0.1', now(), 'F-2', '2020-05-15 12:30:00', 'Compra'
);

INSERT INTO "order"
( order_id, provider_id, warehouse_id, order_user_id, date_requested,
  status, tx_id, tx_username, tx_host, tx_date, receipt, date_received, concept)
VALUES
(  nextval('order_order_id_seq'), 1, 2, 2, '2020-06-21 11:30:00',
   1, 1, 'root', '127.0.0.1', now(), 'F-3', '2020-06-26 12:30:00', 'Compra'
);

INSERT INTO "order"
( order_id, provider_id, warehouse_id, order_user_id, date_requested,
  status, tx_id, tx_username, tx_host, tx_date, receipt, date_received, concept)
VALUES
(  nextval('order_order_id_seq'), 2, 3, 2, '2020-04-03 11:30:00',
   1, 1, 'root', '127.0.0.1', now(), 'F-1', '2020-04-07 12:30:00', 'Compra'
);

INSERT INTO "order"
( order_id, provider_id, warehouse_id, order_user_id, date_requested,
  status, tx_id, tx_username, tx_host, tx_date, receipt, date_received, concept)
VALUES
(  nextval('order_order_id_seq'), 2, 3, 2, '2020-05-21 11:30:00',
   1, 1, 'root', '127.0.0.1', now(), 'F-2', '2020-05-28 12:30:00', 'Compra'
);

INSERT INTO "order"
( order_id, provider_id, warehouse_id, order_user_id, date_requested,
  status, tx_id, tx_username, tx_host, tx_date, receipt, date_received, concept)
VALUES
(  nextval('order_order_id_seq'), 1, 3, 2, '2020-06-01 11:30:00',
   1, 1, 'root', '127.0.0.1', now(), 'F-3', '2020-06-05 12:30:00', 'Compra'
);

INSERT INTO "order"
( order_id, provider_id, warehouse_id, order_user_id, date_requested,
  status, tx_id, tx_username, tx_host, tx_date, receipt, date_received, concept)
VALUES
(  nextval('order_order_id_seq'), 1, 4, 2, '2020-04-26 11:30:00',
   1, 1, 'root', '127.0.0.1', now(), 'F-1', '2020-04-30 12:30:00', 'Compra'
);

INSERT INTO "order"
( order_id, provider_id, warehouse_id, order_user_id, date_requested,
  status, tx_id, tx_username, tx_host, tx_date, receipt, date_received, concept)
VALUES
(  nextval('order_order_id_seq'), 1, 4, 2, '2020-05-12 11:30:00',
   1, 1, 'root', '127.0.0.1', now(), 'F-2', '2020-05-17 12:30:00', 'Compra'
);

INSERT INTO "order"
( order_id, provider_id, warehouse_id, order_user_id, date_requested,
  status, tx_id, tx_username, tx_host, tx_date, receipt, date_received, concept)
VALUES
(  nextval('order_order_id_seq'), 2, 4, 2, '2020-06-19 11:30:00',
   1, 1, 'root', '127.0.0.1', now(), 'F-3', '2020-06-23 12:30:00', 'Compra'
);

INSERT INTO "order"
( order_id, provider_id, warehouse_id, order_user_id, date_requested,
  status, tx_id, tx_username, tx_host, tx_date, receipt, date_received, concept)
VALUES
(  nextval('order_order_id_seq'), 2, 5, 2, '2020-04-05 11:30:00',
   1, 1, 'root', '127.0.0.1', now(), 'F-1', '2020-04-10 12:30:00', 'Compra'
);

INSERT INTO "order"
( order_id, provider_id, warehouse_id, order_user_id, date_requested,
  status, tx_id, tx_username, tx_host, tx_date, receipt, date_received, concept)
VALUES
(  nextval('order_order_id_seq'), 2, 5, 2, '2020-05-22 11:30:00',
   1, 1, 'root', '127.0.0.1', now(), 'F-2', '2020-05-26 12:30:00', 'Compra'
);

INSERT INTO "order"
( order_id, provider_id, warehouse_id, order_user_id, date_requested,
  status, tx_id, tx_username, tx_host, tx_date, receipt, date_received, concept)
VALUES
(  nextval('order_order_id_seq'), 1, 5, 2, '2020-06-21 11:30:00',
   1, 1, 'root', '127.0.0.1', now(), 'F-3', '2020-06-29 12:30:00', 'Compra'
);


-- Agregando datos a la tabla product-order

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

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, qtty_received, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 9, 1, 10, 50,
   50, 50, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, qtty_received, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 10, 1, 8, 30,
   25, 25, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, qtty_received, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 11, 1, 9, 40,
   40, 40, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, qtty_received, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 12, 5, 10, 60,
   50, 50, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, qtty_received, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 12, 6, 12, 40,
   35, 35, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, qtty_received, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 12, 7, 10, 30,
   30, 25, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 13, 8, 10, 40,
   40, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, qtty_received, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 14, 9, 8, 50,
   50, 45, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 15, 10, 8, 40,
   38, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 15, 11, 10, 45,
   40, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, qtty_received, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 16, 12, 10, 60,
   55, 50, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, qtty_received, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 17, 13, 8, 60,
   60, 60, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, qtty_received, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 18, 14, 8, 40,
   40, 35, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, qtty_received, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 18, 15, 10, 50,
   45, 45, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 19, 1, 10, 70,
   65, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 19, 2, 10, 30,
   30, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, qtty_received, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 20, 3, 10, 40,
   35, 35, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, qtty_received, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 21, 4, 8, 65,
   60, 60, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, qtty_received, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 22, 5, 10, 40,
   40, 40, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, qtty_received, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 23, 6, 10, 55,
   45, 45, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, qtty_received, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 23, 7, 8, 50,
   50, 50, 1, 1, 'root', '127.0.0.1', now()
);

INSERT INTO product_order
( provider_product_id, order_id, product_id, unit_price, qtty_requested,
  qtty_commit, status, tx_id, tx_username, tx_host, tx_date)
VALUES
(  nextval('product_order_provider_product_id_seq'), 23, 8, 10, 60,
   50, 1, 1, 'root', '127.0.0.1', now()
);


-- QUERYS
-- Query para devolver todos los almacenes
SELECT wrh.warehouse_id, wrh.warehouse_name
FROM warehouse wrh
  WHERE wrh.status = 1
GROUP BY wrh.warehouse_id, wrh.warehouse_name;

-- Query para la lista de películas de un almacén
SELECT prod.product_id, prod.product_code, prod.product_name, prod.format, prod.creation_date, prov.provider_name, sum(prod_or.qtty_received)
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
  AND wrh.warehouse_id = '3'
GROUP BY prod.product_id, prod_or.product_id, prod.product_code, prod.product_name, prod.format, prod.creation_date, prov.provider_name
ORDER BY prod.product_name;

-- Query para buscar una película por su nombre
SELECT prod.product_id, prod.product_code, prod.product_name, prod.format, prod.creation_date, prov.provider_name, sum(prod_or.qtty_received)
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
  AND wrh.warehouse_id = '1'
  AND prod.product_name like '%A%'
GROUP BY prod.product_id, prod_or.product_id, prod.product_code, prod.product_name, prod.format, prod.creation_date, prov.provider_name
ORDER BY product_name;

-- Query para ordenar la lista de películas con un parámetro
SELECT prod.product_id, prod.product_code, prod.product_name, prod.format, prod.creation_date, prov.provider_name, sum(prod_or.qtty_received)
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
  AND wrh.warehouse_id = '1'
GROUP BY prod.product_id, prod_or.product_id, prod.product_code, prod.product_name, prod.format, prod.creation_date, prov.provider_name
ORDER BY prod.product_code ASC;

-- Query para obtener la información general del kardex
SELECT prod.product_code, prod.product_name, prod.format, wrh.warehouse_address, prov.provider_name
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
  AND wrh.warehouse_id = '2'
  AND prod.product_id = '5'
GROUP BY prod.product_code, prod.product_name, prod.format, wrh.warehouse_address, prov.provider_name;

-- Query para obtener el kardex
SELECT ord.date_received, ord.concept, ord.receipt, prod_or.unit_price as ValorUnitario,
       prod_or.qtty_received as EntradaCantidad, prod_or.unit_price*prod_or.qtty_received as EntradaValor,
       SUM(prod_or.qtty_received) over (order by ord.date_received) as SaldoCantidad,
       SUM(prod_or.unit_price*prod_or.qtty_received) over (order by ord.date_received) as SaldoValor
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
  AND wrh.warehouse_id = '3'
  AND prod.product_id = '10'
  AND prod_or.qtty_received > 0
GROUP BY ord.date_received, ord.concept, ord.receipt, prod_or.unit_price, prod_or.qtty_received
ORDER BY ord.date_received;

-- Query para obtener las órdenes no recibidas

SELECT prod_or.provider_product_id, ord.order_id, prov.provider_name, ord.date_requested, ord.date_received, ord.receipt,
       prod_or.qtty_requested, prod_or.qtty_commit,prod_or.qtty_received
FROM product prod JOIN product_order prod_or
                       on prod.product_id = prod_or.product_id
                  JOIN "order" ord on ord.order_id = prod_or.order_id
                  JOIN provider prov on prov.provider_id = ord.provider_id
                  JOIN warehouse wrh on wrh.warehouse_id = ord.warehouse_id
                  JOIN "user" usr on usr.user_id = ord.order_user_id
WHERE prod.status = 1
  AND prod_or.status = 1
  AND ord.status = 1
  AND prov.status = 1
  AND wrh.status = 1
  AND prod_or.qtty_received < prod_or.qtty_commit
  AND wrh.warehouse_id = '3'
  AND prod.product_id = '10'
GROUP BY prod_or.provider_product_id, ord.order_id, prov.provider_name, ord.date_requested, ord.date_received, ord.receipt,
         prod_or.qtty_requested, prod_or.qtty_commit,prod_or.qtty_received;

-- Hacer un update de la cantidad recibida

UPDATE product_order SET qtty_received = null where provider_product_id = 8;


UPDATE product_order SET qtty_received = 0 where provider_product_id = 1;
-- Query para probar si el campo de qtty received esta con 0 por defecto
SELECT *
FROM information_schema.columns
WHERE table_name = 'product_order';

ALTER TABLE product_order ALTER COLUMN qtty_received SET DEFAULT 0;

UPDATE "user" set password = '48536dd79e3e3258ca6874bd3b00b424bab3d1469130a0716b7259f560eb718a' where user_id = 1;