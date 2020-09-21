DROP DATABASE if exists webchop;
CREATE DATABASE IF NOT EXISTS webchop;
USE webchop;

CREATE TABLE IF NOT EXISTS company(
	company_id BIGINT PRIMARY KEY NOT NULL UNIQUE,
    company_name VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS company_description(
	company_description_id BIGINT PRIMARY KEY NOT NULL UNIQUE,
    company_description_name VARCHAR(250) NOT NULL
);

CREATE TABLE IF NOT EXISTS category(
	category_id BIGINT PRIMARY KEY NOT NULL UNIQUE,
    category_name VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS products(
    product_id bigint PRIMARY KEY NOT NULL UNIQUE,
    product_name varchar(20) NOT NULL,
    product_description varchar(250) NOT NULL,
    product_price double NOT NULL,
    company_id BIGINT,
    company_description_id BIGINT,
    category_id BIGINT,
    FOREIGN KEY (company_id) REFERENCES company(company_id),
    FOREIGN KEY (company_description_id) REFERENCES company_description(company_description_id),
    FOREIGN KEY (category_id) REFERENCES category(category_id)
);

INSERT INTO company(
company_id,
company_name)
VALUES
(1, 'black stone'),
(2, 'KEA');

INSERT INTO company_description(
company_description_id,
company_description_name)
VALUES
(1, 'et godt sted'),
(2, 'super firma');

INSERT INTO category(
category_id,
category_name)
VALUES
(1, 'viskende vare'),
(2, 'ikke så viskende vare');

INSERT INTO products
    (product_id,
     product_name,
     product_description,
     product_price,
     company_id,
     company_description_id,
     category_id)
VALUES
       (200004,'KC14 Beige Berry',
        'Coloured plaster',
        200.95, 1, 1, 1),
       (200005,'KC14 Warm Teracotta',
        'Coloured plaster',
        200.95, 2, 2, 2),
       (200009,'KC14 Dark Plum',
        'Coloured plaster',
        200.95 ,1, 2, 1);

/*SELECT * FROM products;


UPDATE products
SET product_description = 'KC14 Coloured plaster'
WHERE product_description = 'Coloured plaster ';


SELECT company.company_id, company.company_name
FROM products
INNER JOIN company ON products.company_id = company.company_id
WHERE product_id = 200004;

SELECT category.category_id, category.category_name
FROM products
INNER JOIN category ON products.category_id = category.category_id
WHERE product_id = 200004;

SELECT company_description.company_description_id, company_description.company_description_name
FROM products
INNER JOIN company_description ON products.company_description_id = company_description.company_description_id
WHERE product_id = 200004;

 */