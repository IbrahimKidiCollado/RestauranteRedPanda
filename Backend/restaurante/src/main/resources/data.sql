-- USUARIOS
INSERT INTO usuarios (id, nombre, pwd, preferencia_idioma) VALUES
(1, 'admin', '1234', 'es'),
(2, 'cliente1', 'abcd', 'es');


-- CARTA
INSERT INTO carta (id) VALUES
(1);


-- INGREDIENTES
INSERT INTO ingrediente (id, nombre) VALUES
(1, 'Arroz'),
(2, 'Salmón'),
(3, 'Atún'),
(4, 'Alga Nori'),
(5, 'Fideos'),
(6, 'Caldo'),
(7, 'Soja');


-- SUSHI
INSERT INTO sushi (id, nombre, descripcion, numero_piezas, precio, id_carta) VALUES
(1, 'Sushi Salmón', 'Salmón fresco con arroz', 8, 10.5, 1),
(2, 'Sushi Atún', 'Atún rojo con arroz', 8, 11.0, 1);


-- RAMEN
INSERT INTO ramen (id, nombre, cantidad, precio, id_carta) VALUES
(1, 'Ramen Tonkotsu', 1, 13.5, 1),
(2, 'Ramen Miso', 1, 12.0, 1);


-- BEBIDAS
INSERT INTO bebida (id, nombre, cantidad, precio, id_carta) VALUES
(1, 'Té Verde', 1, 2.5, 1),
(2, 'Ramune', 1, 3.0, 1);


-- ENTRANTES
INSERT INTO entrante (id, nombre, descripcion, precio, id_carta) VALUES
(1, 'Gyozas', 'Empanadillas japonesas', 5.5, 1),
(2, 'Edamame', 'Soja hervida', 4.0, 1);


-- PEDIDOS
INSERT INTO pedido (id, id_usuario, nombre, descripcion, precio, cantidad) VALUES
(1, 2, 'Pedido Sushi', 'Pedido de sushi', 10.5, 1);


-- CARRITO
INSERT INTO carrito (id, id_usuario, nombre, descripcion, precio, cantidad) VALUES
(1, 2, 'Sushi Salmón', '8 piezas de sushi', 10.5, 1);


-- RELACION SUSHI INGREDIENTE
INSERT INTO sushi_ingrediente (id_sushi, id_ingrediente) VALUES
(1,1),
(1,2),
(1,4),
(2,1),
(2,3),
(2,4);


-- RELACION RAMEN INGREDIENTE
INSERT INTO ramen_ingrediente (id_ramen, id_ingrediente) VALUES
(1,5),
(1,6),
(1,7),
(2,5),
(2,6);