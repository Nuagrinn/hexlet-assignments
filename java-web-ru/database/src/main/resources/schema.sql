-- BEGIN
DROP TABLE IF EXISTS products;

CREATE TABLE products (
                          id IDENTITY PRIMARY KEY,
                          title VARCHAR(255) NOT NULL,
                          price INT NOT NULL
);
-- END
