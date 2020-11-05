INSERT INTO company (name) VALUES ('Black Stone');
INSERT INTO company (name) VALUES ('KEA');

INSERT INTO company_description (description) VALUES ('Et godt sted');
INSERT INTO company_description (description) VALUES ('super firma');

INSERT INTO category(name) VALUES ('Viskende vare');
INSERT INTO category(name) VALUES ('Ikke så viskende vare');
INSERT INTO category(name) VALUES ('Shhhh');
INSERT INTO category(name) VALUES ('Stille');

INSERT INTO product(description,name,price)
VALUES('Coloured plaster','KC14 Beige Berry',200.95);
INSERT INTO product(description,name,price)
VALUES('Coloured plaster','KC14 Warm Teracotta',200.95);
INSERT INTO product(description,name,price)
VALUES('Coloured plaster','KC14 Dark Plum',200.95);

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