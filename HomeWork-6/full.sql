BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), price numeric(6, 2));
INSERT INTO products (title, price) VALUES
('milk', 79.90),
('bread', 24.90),
('butter', 220.00),
('cheese', 350.55),
('coca-cola', 69.90);
ALTER TABLE public.products
    OWNER to admin;

DROP TABLE IF EXISTS costumers CASCADE;
CREATE TABLE costumers
(id bigserial NOT NULL PRIMARY KEY, name VARCHAR(50) NOT NULL, sex "char",
 birthday date, phone numeric(10, 0) NOT NULL);
INSERT INTO costumers(name, sex, birthday, phone) VALUES
('John', 'M', '1987-07-06', 9601112233);
INSERT INTO costumers(name, sex, phone) VALUES
('Polly', 'W', 9604442233),
('Robert', 'M', 9605552233);
ALTER TABLE public.costumers
    OWNER to admin;

DROP TABLE IF EXISTS orders CASCADE;
CREATE TABLE orders
(
    id bigserial NOT NULL PRIMARY KEY,
    number bigserial NOT NULL,
    product_id bigserial NOT NULL,
    costumer_id bigserial NOT NULL,
    CONSTRAINT costumer_id FOREIGN KEY (costumer_id)
        REFERENCES public.costumers (id) MATCH SIMPLE,
    CONSTRAINT product_id FOREIGN KEY (product_id)
        REFERENCES public.products (id) MATCH SIMPLE);
INSERT INTO orders(number, product_id, costumer_id) VALUES
(10000, 1, 3),
(10000, 2, 3),
(10001, 1, 1),
(10001, 2, 1),
(10001, 3, 1),
(10002, 4, 2),
(10002, 3, 2),
(10002, 2, 2);


COMMIT;