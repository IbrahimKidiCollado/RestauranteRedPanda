-- USUARIOS
INSERT INTO usuarios (id, nombre, pwd, preferencia_idioma) VALUES
(1, 'admin', '1234', 'es'),
(2, 'cliente1', 'abcd', 'es');

-- CARTA
INSERT INTO carta (id) VALUES (1);

-- INGREDIENTES
INSERT INTO ingrediente (id, nombre) VALUES
(1, 'Arroz'), (2, 'Salmón'), (3, 'Atún'), (4, 'Alga Nori'),
(5, 'Fideos'), (6, 'Caldo'), (7, 'Soja'), (8, 'Langostino'),
(9, 'Aguacate'), (10, 'Anguila'), (11, 'Huevo'), (12, 'Cerdo'),
(13, 'Miso'), (14, 'Cebollino'), (15, 'Sésamo');

-- SUSHI (Carpeta: /assets/carta/Shushis/)
INSERT INTO sushi (id, nombre, cantidad, descripcion, numero_piezas, precio, imagen, id_carta) VALUES
(1, 'Sushi Salmón', 3, 'Salmón fresco con arroz', 8, 10.5, '/assets/carta/Shushis/sushi_salmon.webp', 1),
(2, 'Sushi Atún', 4, 'Atún rojo con arroz', 8, 11.0, '/assets/carta/Shushis/sushi_atun.webp', 1),
(3, 'Dragon Roll', 2, 'Langostino tempurizado y aguacate', 8, 14.5, '/assets/carta/Shushis/dragon_roll.webp', 1),
(4, 'Nigiri Unagi', 5, 'Anguila braseada sobre arroz', 2, 6.5, '/assets/carta/Shushis/nigiri_unagi.webp', 1),
(5, 'California Roll', 3, 'Cangrejo, pepino y aguacate', 8, 9.5, '/assets/carta/Shushis/california.webp', 1),
(6, 'Futomaki Veggie', 2, 'Rollo grande de verduras variadas', 6, 8.0, '/assets/carta/Shushis/futomaki.webp', 1),
(7, 'Spicy Tuna', 4, 'Atún picante picado en nido de alga', 2, 7.0, '/assets/carta/Shushis/spicy_tuna.webp', 1);

-- RAMEN (Carpeta: /assets/carta/Ramens/)
INSERT INTO ramen (id, nombre, cantidad, precio, imagen, id_carta, descripcion) VALUES
(1, 'Ramen Tonkotsu', 1, 13.5, '/assets/carta/Ramens/ramen_tonkotsu.webp', 1, 'Caldo de cerdo cremoso con fideos finos'),
(2, 'Ramen Miso', 1, 12.0, '/assets/carta/Ramens/ramen_miso.webp', 1, 'Caldo a base de soja fermentada y verduras'),
(3, 'Shoyu Ramen', 1, 12.5, '/assets/carta/Ramens/shoyu_ramen.webp', 1, 'Caldo ligero de pollo y soja con huevo'),
(4, 'Tantanmen', 1, 14.0, '/assets/carta/Ramens/tantanmen.webp', 1, 'Ramen picante de sésamo y carne picada'),
(5, 'Shio Ramen', 1, 11.5, '/assets/carta/Ramens/shio_ramen.webp', 1, 'Caldo claro a base de sal marina'),
(6, 'Veggie Ramen', 1, 12.0, '/assets/carta/Ramens/veggie_ramen.webp', 1, 'Caldo de verduras, setas y tofu'),
(7, 'Black Garlic Ramen', 1, 15.0, '/assets/carta/Ramens/black_garlic.webp', 1, 'Caldo intenso con aceite de ajo negro');

-- BEBIDAS (Carpeta: /assets/carta/Bebidas/)
INSERT INTO bebida (id, nombre, cantidad, precio, imagen, id_carta, descripcion) VALUES
(1, 'Té Verde', 1, 2.5, '/assets/carta/Bebidas/te_verde.webp', 1, 'Té verde japonés tradicional caliente'),
(2, 'Ramune', 1, 3.0, '/assets/carta/Bebidas/ramune.webp', 1, 'Refresco gaseoso japonés original'),
(3, 'Cerveza Sapporo', 1, 4.5, '/assets/carta/Bebidas/sapporo.webp', 1, 'Cerveza premium japonesa'),
(4, 'Sake Caliente', 1, 6.0, '/assets/carta/Bebidas/sake.webp', 1, 'Licor de arroz tradicional'),
(5, 'Agua Mineral', 1, 1.5, '/assets/carta/Bebidas/agua.webp', 1, 'Agua sin gas 500ml'),
(6, 'Calpis', 1, 3.5, '/assets/carta/Bebidas/calpis.webp', 1, 'Bebida láctea refrescante'),
(7, 'Cerveza Asahi', 1, 4.5, '/assets/carta/Bebidas/asahi.webp', 1, 'Cerveza japonesa seca');

-- ENTRANTES (Carpeta: /assets/carta/Entrantes/)
INSERT INTO entrante (id, nombre, cantidad, descripcion, precio, imagen, id_carta) VALUES
(1, 'Gyozas', 4, 'Empanadillas japonesas', 5.5, '/assets/carta/Entrantes/gyozas.webp', 1),
(2, 'Tempura', 4, 'Gambas fritas', 4.0, '/assets/carta/Entrantes/tempura.webp', 1),
(3, 'Edamame', 1, 'Vainas de soja al vapor', 3.5, '/assets/carta/Entrantes/edamame.webp', 1),
(4, 'Wakame', 1, 'Ensalada de algas aliñadas', 4.5, '/assets/carta/Entrantes/wakame.webp', 1),
(5, 'Takoyaki', 4, 'Bolitas de pulpo fritas', 6.5, '/assets/carta/Entrantes/takoyaki.webp', 1),
(6, 'Karaage', 1, 'Pollo frito al estilo japonés', 7.0, '/assets/carta/Entrantes/karaage.webp', 1),
(7, 'Sopa Miso', 1, 'Sopa tradicional con tofu', 3.0, '/assets/carta/Entrantes/miso_soup.webp', 1);

-- CARNE (Carpeta: /assets/carta/Carnes/)
INSERT INTO carne (id, nombre, cantidad, precio, imagen, id_carta, descripcion) VALUES
(1, 'Wagyu A5', 1, 45.0, '/assets/carta/Carnes/wagyu.webp', 1, 'Corte de buey japonés de máxima calidad'),
(2, 'Pollo Teriyaki', 1, 12.5, '/assets/carta/Carnes/pollo_teriyaki.webp', 1, 'Pollo a la parrilla con salsa dulce'),
(3, 'Tonkatsu', 1, 11.0, '/assets/carta/Carnes/tonkatsu.webp', 1, 'Lomo de cerdo empanado en panko'),
(4, 'Sukiyaki', 1, 18.0, '/assets/carta/Carnes/sukiyaki.webp', 1, 'Ternera cocinada a fuego lento con verduras'),
(5, 'Yakitori Mix', 3, 9.0, '/assets/carta/Carnes/yakitori.webp', 1, 'Brochetas de pollo y puerro'),
(6, 'Tataki de Ternera', 1, 15.0, '/assets/carta/Carnes/beef_tataki.webp', 1, 'Ternera sellada con salsa cítrica'),
(7, 'Gyudon Bowl', 1, 13.0, '/assets/carta/Carnes/gyudon.webp', 1, 'Cuenco de arroz con finas láminas de ternera');

-- PESCADO (Carpeta: /assets/carta/Pescados/)
INSERT INTO pescado (id, nombre, cantidad, precio, imagen, id_carta, descripcion) VALUES
(1, 'Tataki de Atún', 1, 16.0, '/assets/carta/Pescados/tataki_atun.webp', 1, 'Atún sellado con costra de sésamo'),
(2, 'Salmón Teriyaki', 1, 15.5, '/assets/carta/Pescados/salmon_teriyaki.webp', 1, 'Lomo de salmón glaseado'),
(3, 'Bacalao Negro', 1, 22.0, '/assets/carta/Pescados/bacalao_negro.webp', 1, 'Bacalao marinado en miso dulce'),
(4, 'Sashimi Variado', 1, 25.0, '/assets/carta/Pescados/sashimi.webp', 1, 'Cortes de pescado crudo premium'),
(5, 'Hamachi Grill', 1, 14.5, '/assets/carta/Pescados/hamachi.webp', 1, 'Pescado amarillo a la brasa'),
(6, 'Unagi Kabayaki', 1, 19.0, '/assets/carta/Pescados/unagi_kaba.webp', 1, 'Anguila entera glaseada'),
(7, 'Caballa Salada', 1, 10.5, '/assets/carta/Pescados/caballa.webp', 1, 'Caballa asada al estilo tradicional');

-- POSTRE (Carpeta: /assets/carta/Postres/)
INSERT INTO postre (id, nombre, cantidad, precio, imagen, id_carta, descripcion) VALUES
(1, 'Mochi Fresa', 2, 4.5, '/assets/carta/Postres/mochi_fresa.webp', 1, 'Pastel de arroz relleno de crema'),
(2, 'Dorayaki', 1, 3.8, '/assets/carta/Postres/dorayaki.webp', 1, 'Pancakes rellenos de judía roja'),
(3, 'Tarta Matcha', 1, 6.0, '/assets/carta/Postres/tarta_matcha.webp', 1, 'Tarta cremosa de queso y té verde'),
(4, 'Helado Sésamo', 1, 4.0, '/assets/carta/Postres/helado_sesamo.webp', 1, 'Helado artesanal de sésamo negro'),
(5, 'Taiyaki', 1, 4.2, '/assets/carta/Postres/taiyaki.webp', 1, 'Bizcocho en forma de pez con chocolate'),
(6, 'Gelatina Sake', 1, 5.0, '/assets/carta/Postres/gelatina_sake.webp', 1, 'Postre ligero con aroma de sake'),
(7, 'Fruta Matcha', 1, 3.5, '/assets/carta/Postres/fruta_matcha.webp', 1, 'Selección de frutas con sirope de té');

-- PEDIDOS
INSERT INTO pedido (id, id_usuario, nombre, descripcion, precio, cantidad) VALUES
(1, 2, 'Pedido Sushi', 'Pedido de sushi', 10.5, 1),
(2, 2, 'Cena Japonesa', 'Ramen y bebidas', 25.0, 1),
(3, 1, 'Prueba Admin', 'Entrantes varios', 15.0, 1),
(4, 2, 'Pedido Carne', 'Wagyu especial', 45.0, 1),
(5, 2, 'Postres Casa', 'Mochis y Dorayakis', 12.0, 3),
(6, 1, 'Menu Diario', 'Ramen Miso', 12.0, 1),
(7, 2, 'Pack Familiar', 'Sushi variado 32 piezas', 40.0, 1);

-- RELACIONES SUSHI
INSERT INTO sushi_ingrediente (id_sushi, id_ingrediente) VALUES
(1,1), (1,2), (1,4), (2,1), (2,3), (2,4), (3,1), (3,8), (3,9), (4,1), (4,10), (5,1), (5,9), (5,4), (6,4), (6,9), (7,1), (7,3), (7,15);

-- RELACIONES RAMEN
INSERT INTO ramen_ingrediente (id_ramen, id_ingrediente) VALUES
(1,5), (1,6), (1,12), (2,5), (2,6), (2,13), (3,5), (3,6), (3,11), (4,5), (4,14), (4,15), (5,5), (5,6), (6,5), (6,14), (7,5), (7,6), (7,14);

-- 2. Insertar los datos exactos de tu JSON
INSERT INTO categoria (nombre, slug) VALUES 
('tienda.categorias.todos', 'todos'),
('tienda.categorias.sushi', 'sushi'),
('tienda.categorias.ramen', 'ramen'),
('tienda.categorias.carne', 'carne'),
('tienda.categorias.pescado', 'pescado'),
('tienda.categorias.postres', 'postre'),
('tienda.categorias.bebidas', 'bebida');