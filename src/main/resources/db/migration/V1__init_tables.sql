CREATE TABLE sellers(
    id SERIAL PRIMARY KEY,
    seller_name VARCHAR,
    seller_email VARCHAR UNIQUE,
    seller_password VARCHAR
);

CREATE TABLE categories(
    id SERIAL PRIMARY KEY ,
    category_description VARCHAR UNIQUE
);

CREATE TABLE customers(
    id SERIAL PRIMARY KEY,
    customer_name VARCHAR,
    customer_email VARCHAR UNIQUE,
    customer_password VARCHAR
);

CREATE TABLE shops(
    id SERIAL PRIMARY KEY,
    seller_id INTEGER UNIQUE,
    shop_name VARCHAR,

    FOREIGN KEY (seller_id) REFERENCES sellers(id)
);

CREATE TABLE products(
    id SERIAL PRIMARY KEY,
    product_name VARCHAR,
    product_price INTEGER,
    product_quantity INTEGER,
    seller_id INTEGER,

    FOREIGN KEY (seller_id) REFERENCES sellers(id)
);

CREATE TABLE transactions(
    id SERIAL PRIMARY KEY,
    seller_id INTEGER,
    customer_id INTEGER,
    product_id INTEGER,

    FOREIGN KEY (seller_id) REFERENCES sellers(id),
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE product_category (
    id SERIAL PRIMARY KEY,
    product_id INTEGER,
    category_id INTEGER,

    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

