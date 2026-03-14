-- =====================================
-- INGREDIENTES
-- =====================================
INSERT INTO ingrediente (nombre) VALUES ('Arroz');
INSERT INTO ingrediente (nombre) VALUES ('Salmon');
INSERT INTO ingrediente (nombre) VALUES ('Atun');
INSERT INTO ingrediente (nombre) VALUES ('Alga Nori');
INSERT INTO ingrediente (nombre) VALUES ('Aguacate');
INSERT INTO ingrediente (nombre) VALUES ('Pepino');
INSERT INTO ingrediente (nombre) VALUES ('Huevo');
INSERT INTO ingrediente (nombre) VALUES ('Fideos Ramen');
INSERT INTO ingrediente (nombre) VALUES ('Caldo Tonkotsu');
INSERT INTO ingrediente (nombre) VALUES ('Pollo');


-- =====================================
-- SUSHI
-- =====================================
INSERT INTO sushi (nombre, descripcion, numero_piezas, precio)
VALUES ('Maki Salmon', 'Maki relleno de salmon', 8, 9.50);
INSERT INTO sushi (nombre, descripcion, numero_piezas, precio)
VALUES ('Maki Atun', 'Maki relleno de atun', 8, 9.50);
INSERT INTO sushi (nombre, descripcion, numero_piezas, precio)
VALUES ('California Roll', 'Roll con cangrejo, aguacate y pepino', 8, 10.50);


-- =====================================
-- RAMEN
-- =====================================
INSERT INTO ramen (nombre, cantidad, precio)
VALUES ('Tonkotsu Ramen', 1, 13.50);
INSERT INTO ramen (nombre, cantidad, precio)
VALUES ('Chicken Ramen', 1, 12.50);


-- =====================================
-- BEBIDAS
-- =====================================
INSERT INTO bebida (nombre, cantidad, precio)
VALUES ('Agua', 1, 2.00);
INSERT INTO bebida (nombre, cantidad, precio)
VALUES ('Coca-Cola', 1, 2.50);
INSERT INTO bebida (nombre, cantidad, precio)
VALUES ('Te verde japones', 1, 2.20);


-- =====================================
-- ENTRANTES
-- =====================================
INSERT INTO entrante (nombre, descripcion, precio)
VALUES ('Gyozas', 'Empanadillas japonesas de carne', 5.50);
INSERT INTO entrante (nombre, descripcion, precio)
VALUES ('Edamame', 'Vainas de soja hervidas', 4.50);


-- =====================================
-- RELACION SUSHI - INGREDIENTES
-- =====================================
INSERT INTO sushi_ingrediente VALUES (1,1);
INSERT INTO sushi_ingrediente VALUES (1,2);
INSERT INTO sushi_ingrediente VALUES (1,4);
INSERT INTO sushi_ingrediente VALUES (2,1);
INSERT INTO sushi_ingrediente VALUES (2,3);
INSERT INTO sushi_ingrediente VALUES (2,4);
INSERT INTO sushi_ingrediente VALUES (3,1);
INSERT INTO sushi_ingrediente VALUES (3,5);
INSERT INTO sushi_ingrediente VALUES (3,6);


-- =====================================
-- RELACION RAMEN - INGREDIENTES
-- =====================================
INSERT INTO ramen_ingrediente VALUES (1,8);
INSERT INTO ramen_ingrediente VALUES (1,9);
INSERT INTO ramen_ingrediente VALUES (1,7);
INSERT INTO ramen_ingrediente VALUES (2,8);
INSERT INTO ramen_ingrediente VALUES (2,10);


-- =====================================
-- USUARIOS
-- =====================================
INSERT INTO usuarios (pwd, nombre, preferencia_idioma)
VALUES ('1234', 'admin', 'es');
INSERT INTO usuarios (pwd, nombre, preferencia_idioma)
VALUES ('1234', 'iker', 'es');


-- =====================================
-- PEDIDOS
-- =====================================
INSERT INTO pedido (id_usuario, nombre, descripcion, precio, cantidad)
VALUES (2, 'Pedido Sushi', 'Maki Salmon', 9.50, 1);


-- =====================================
-- CARRITO
-- =====================================
INSERT INTO carrito (id_usuario, nombre, descripcion, precio, cantidad, id_pedido)
VALUES (2, 'Maki Salmon', 'Sushi de salmon', 9.50, 1, 1);


-- =====================================
-- CARTA
-- =====================================
INSERT INTO carta (id_sushi) VALUES (1);
INSERT INTO carta (id_sushi) VALUES (2);
INSERT INTO carta (id_sushi) VALUES (3);
INSERT INTO carta (id_ramen) VALUES (1);
INSERT INTO carta (id_ramen) VALUES (2);
INSERT INTO carta (id_entrante) VALUES (1);
INSERT INTO carta (id_entrante) VALUES (2);
INSERT INTO carta (id_bebida) VALUES (1);
INSERT INTO carta (id_bebida) VALUES (2);
INSERT INTO carta (id_bebida) VALUES (3);