DROP TABLE IF EXISTS categories CASCADE;
CREATE TABLE categories (id bigserial, title varchar(255), PRIMARY KEY (id));
INSERT INTO categories (id, title) VALUES
(1, 'Приправы, специи, пищевые концентраты'),
(2, 'Кондитерские, хлебобулочные изделия'),
(3, 'Лимонады, квас, минеральная вода'),
(4, 'Фрукты,овощи, орехи'),
(5, 'Готовые блюда'),
(6, 'Рыба, рыбопродукты'),
(7, 'Алкоголь'),
(8, 'Молочная продукция');


DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, category_id integer REFERENCES categories (id), title VARCHAR(255), price numeric(6, 2), sale boolean, OLD_PRICE numeric(6, 2));
INSERT INTO products (title,category_id, price, sale) VALUES
('Аджика Дядя Ваня 140г соус поабхазски ст/б', 1, 79.90, false),
('Батончик Чио Рио 30г с нач.в мягкой карам м/у ', 2, 20.90, false),
('Батон Здоровье 350г изд.х/б м/у ОАО Северодвинский ХК', 2, 41.90, false),
('Вода питьевая Снежок 5л негазированная артезианская пл/б', 3, 39.90, false),
('Грецкий орех очищенный', 4, 999.90, false),
('Драже Вафельное в шок.глазури ООО КДВ Яшкино', 2, 449.90, false),
('Запеканка картофельная с мясным фаршем ИП Федотова Г.В.', 5, 310.90, false),
('КамбалаЕрш вяленый б/г потр.', 6, 1099.90, false),
('Вино Алазанская Долина 0.75л стол.бел.п/сл.11% OLD TELAVI', 7, 499.90, false),
('Вино Киндзмараули 0,75л красное пл/с регион Кахетия ', 7, 499.90, false),
('Вино Киндзмараули 0,75л красное пл/с регион Кахетия ', 7, 399.90, false);
INSERT INTO products (title, category_id, price, sale, OLD_PRICE) VALUES
('Изд.кондитерское Хрустиш в конд.глазури Добр.печеньки', 2, 359.90, true, 409.9),
('Икра из кабачков Фрау Марта 320г консервы стерилиз.ж/б ', 1, 41.90, true, 49.90),
('Йогурт Савушкин 120г персикманго 2% с фр.нап.пл/б БЗМЖ', 8, 15.90, true, 19.9);