-- Insert data into the sellers table
INSERT INTO sellers (id, seller_name, seller_email, seller_password)
VALUES
    (1, 'Seller1', 'seller1@email.com', 'seller1password'),
    (2, 'Seller2', 'seller2@email.com', 'seller2password'),
    (3, 'Seller3', 'seller3@email.com', 'seller3password');

-- Insert data into the categories table
INSERT INTO categories (id, category_description)
VALUES
    (1, 'Category1'),
    (2, 'Category2'),
    (3, 'Category3');

-- Insert data into the customers table
INSERT INTO customers (id, customer_name, customer_email, customer_password)
VALUES
    (1, 'Raymond', 'ray@email.com', 'qweasd123'),
    (2, 'Joe', 'joe@email.com', 'qweasd123'),
    (3, 'Sarah', 'sarah@email.com', 'qweasd123');

-- Insert data into the shops table
INSERT INTO shops (id, seller_id, shop_name)
VALUES
    (1, 1, 'Shop1'),
    (2, 2, 'Shop2'),
    (3, 3, 'Shop3');

-- Insert data into the products table
INSERT INTO products (id, product_name, product_price, product_quantity, seller_id)
VALUES
    (1, 'Product1', 10, 100, 2),
    (2, 'Product2', 20, 200, 2),
    (3, 'Product3', 30, 300, 3);

-- Insert data into the transactions table
INSERT INTO transactions (id, seller_id, customer_id, product_id)
VALUES
    (1, 1, 2, 1),
    (2, 2, 2, 2),
    (3, 3, 3, 3);

-- Insert data into the product_category table
INSERT INTO product_category (id, product_id, category_id)
VALUES
    (1, 1, 1),
    (2, 1, 2),
    (3, 3, 3);