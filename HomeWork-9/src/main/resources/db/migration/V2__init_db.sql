DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), price numeric(6, 2), sale boolean, OLD_PRICE numeric(6, 2));
INSERT INTO products (title, price, sale) VALUES
('Аджика Дядя Ваня 140г соус поабхазски ст/б', 79.90, false),
('Батончик Чио Рио 30г с нач.в мягкой карам м/у ', 20.90, false),
('Батон Здоровье 350г изд.х/б м/у ОАО Северодвинский ХК', 41.90, false),
('Вода питьевая Снежок 5л негазированная артезианская пл/б', 39.90, false),
('Грецкий орех очищенный', 999.90, false),
('Драже Вафельное в шок.глазури ООО КДВ Яшкино', 449.90, false),
('Ж/р Orbit Белоснежный 13,6г Нежная мята с аром.мяты б/сах', 25.90, false),
('Запеканка картофельная с мясным фаршем ИП Федотова Г.В.', 310.90, false),
('КамбалаЕрш вяленый б/г потр.', 1099.90, false),
('Вино Алазанская Долина 0.75л стол.бел.п/сл.11% OLD TELAVI', 499.90, false),
('Вино Киндзмараули 0,75л красное пл/с регион Кахетия ', 499.90, false),
('Вино Киндзмараули 0,75л красное пл/с регион Кахетия ', 399.90, false);
INSERT INTO products (title, price, sale, OLD_PRICE) VALUES
('Изд.кондитерское Хрустиш в конд.глазури Добр.печеньки', 359.90, true, 409.9),
('Икра из кабачков Фрау Марта 320г консервы стерилиз.ж/б ', 41.90, true, 49.90),
('Йогурт Савушкин 120г персикманго 2% с фр.нап.пл/б БЗМЖ', 15.90, true, 19.9);