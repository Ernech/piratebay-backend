
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

<<<<<<< HEAD

=======
>>>>>>> 6b0f4fad66d116a1a8f908b9a89400b321e48cbb
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