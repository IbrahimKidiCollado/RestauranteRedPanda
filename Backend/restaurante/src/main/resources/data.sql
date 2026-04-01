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
INSERT INTO sushi (id, nombre, cantidad, descripcion, numero_piezas, precio, imagen, id_carta) VALUES
(1, 'Sushi Salmón', 3, 'Salmón fresco con arroz', 8, 10.5, '/assets/carta/sushi_salmon.webp', 1),
(2, 'Sushi Atún', 4, 'Atún rojo con arroz', 8, 11.0, '/assets/carta/sushi_atun.webp', 1);


-- RAMEN
INSERT INTO ramen (id, nombre, cantidad, precio, imagen, id_carta, descripcion) VALUES
(1, 'Ramen Tonkotsu', 1, 13.5, '/assets/carta/ramen_tonkotsu.webp', 1, 'Caldo de cerdo cremoso con fideos finos'),
(2, 'Ramen Miso', 1, 12.0, '/assets/carta/ramen_miso.webp', 1, 'Caldo a base de soja fermentada y verduras');


-- BEBIDAS
INSERT INTO bebida (id, nombre, cantidad, precio, imagen, id_carta, descripcion) VALUES
(1, 'Té Verde', 1, 2.5, '/assets/carta/te_verde.webp', 1, 'Té verde japonés tradicional caliente'),
(2, 'Ramune', 1, 3.0, '/assets/carta/ramune.webp', 1, 'Refresco gaseoso japonés original');


-- ENTRANTES
INSERT INTO entrante (id, nombre, cantidad descripcion, precio, imagen, id_carta) VALUES
(1, 'Gyozas', 4, 'Empanadillas japonesas', 5.5, '/assets/carta/gyozas.webp', 1),
(2, 'tempura', 4, 'gambas fritas', 4.0, '/assets/carta/tempura.webp', 1);


-- PEDIDOS
INSERT INTO pedido (id, id_usuario, nombre, descripcion, precio, cantidad) VALUES
(1, 2, 'Pedido Sushi', 'Pedido de sushi', 10.5, 1);


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