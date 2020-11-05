INSERT INTO company (name)
VALUES
    ('Black Stone'),
    ('KEA');

INSERT INTO company_description (description)
VALUES
    ('KC14 is the first Nordic coloured plaster with a specially developed Topcoat'),
    ('It creates tactile and beautiful walls, which can be maintained and cared for just like a regular painted wall Shine 10.'),
    ('One set consists of 10L KC14 filler + 1L Topcoat. ​');

INSERT INTO category(name)
VALUES
    ('Viskende vare'),
    ('Ikke så viskende vare'),
    ('Shhhh'),
    ('Stille');

INSERT INTO product(description,name,price,company_id,company_description_id)
VALUES
    ('Coloured plaster','KC14 Beige Berry',200.95,1,1),
    ('Coloured plaster','KC14 Warm Teracotta',200.95,1,2),
    ('Coloured plaster','KC14 Dark Plum',200.95,1,3);

INSERT INTO PRODUCT_CATEGORY (product_id, category_id)
VALUES
    (1,1),
    (1,2),
    (1,4);