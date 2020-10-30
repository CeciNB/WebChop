INSERT INTO company (name) VALUES ('black stone');
INSERT INTO company (name) VALUES ('KEA');

INSERT INTO company_description (description) VALUES ('et godt sted');
INSERT INTO company_description (description) VALUES ('super firma');

INSERT INTO category(name) VALUES ('viskende vare');
INSERT INTO category(name) VALUES ('ikke så viskende vare');

INSERT INTO products(description,name,price,company_id,company_description_id)
VALUES('Coloured plaster','KC14 Beige Berry',200.95, 1, 1);
INSERT INTO products(description,name,price,company_id,company_description_id)
VALUES('Coloured plaster','KC14 Warm Teracotta',200.95, 2, 2);
INSERT INTO products(description,name,price,company_id,company_description_id)
VALUES('Coloured plaster','KC14 Dark Plum',200.95 ,1, 2);

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