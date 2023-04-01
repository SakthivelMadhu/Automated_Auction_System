-- Users table 
CREATE TABLE users (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL UNIQUE,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  address VARCHAR(255),
  mobile_no VARCHAR(20),
  password VARCHAR(255),
  is_deleted INT DEFAULT 0
);


-- items table 
CREATE TABLE items (
  item_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  price DECIMAL(10, 2),
  quantity INT,
  description TEXT,
  sold_status INT DEFAULT 0,
  category ENUM('Clothing', 'Electronics', 'Grocery', 'Miscellaneous'),
  seller_id INT NOT NULL,
  FOREIGN KEY (seller_id) REFERENCES users(user_id),
  is_deleted INT DEFAULT 0
);


-- transactions table 
CREATE TABLE transactions (
  transaction_id INT AUTO_INCREMENT PRIMARY KEY,
  item_id INT NOT NULL,
  buyer_id INT NOT NULL,
  seller_id INT NOT NULL,
  transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  refund_status INT DEFAULT 0,
  FOREIGN KEY (item_id) REFERENCES items(item_id),
  FOREIGN KEY (buyer_id) REFERENCES users(user_id),
  FOREIGN KEY (seller_id) REFERENCES users(user_id),
  is_deleted INT DEFAULT 0
);


-- disputes table 
CREATE TABLE disputes (
  dispute_id INT AUTO_INCREMENT PRIMARY KEY,
  transaction_id INT NOT NULL,
  raised_by INT NOT NULL,
  description TEXT,
  verdict ENUM('Refund to buyer', 'No refund'),
  FOREIGN KEY (transaction_id) REFERENCES transactions(transaction_id),
  FOREIGN KEY (raised_by) REFERENCES users(user_id),
  is_deleted INT DEFAULT 0
);


-- gst_rates table 
CREATE TABLE gst_rates (
  category ENUM('Clothing', 'Electronics', 'Grocery', 'Miscellaneous') PRIMARY KEY,
  gst_rate DECIMAL(10, 2) NOT NULL,
  is_deleted INT DEFAULT 0
);




-- admin table 
CREATE TABLE admin (
  admin_id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(50) NOT NULL
);


-- to register or login for admin : 
INSERT INTO users (username , password) VALUES ('admin', 'admin');


-- To register a user:  
INSERT INTO users (username, first_name, last_name, address, mobile_no, password)
VALUES ('john_doe', 'John', 'Doe', '123 Main St', '555-555-5555', 'password123');

INSERT INTO users (username, first_name, last_name, address, mobile_no, password)
VALUES ('sakthi', 'sa', 'kthi', '123 something', '741852963', '12345sa');

INSERT INTO users (username, first_name, last_name, address, mobile_no, password)
VALUES ('jack sparrow', 'jack', 'sparrow', '007 in St', '12345678', 'jackjack12');



-- insert items into items:
INSERT INTO items (name, price, quantity, description, sold_status , category , seller_id)
VALUES ('watch', 100.99, 2, 'you know watches', 1, 'Electronics' , 001);

INSERT INTO items (name, price, quantity, description, sold_status , category , seller_id)
VALUES ('shoe', 79.99, 1, 'you know shoes', 12, 'Clothing' , 002);

INSERT INTO items (name, price, quantity, description, sold_status , category , seller_id)
VALUES ('shirt', 150.99, 5, 'you know shirts', 5, 'Clothing' , 001);

INSERT INTO items (name, price, quantity, description, sold_status , category , seller_id)
VALUES ('rice', 29.99, 10, 'you know rice', 7, 'Grocery' , 003);


-- insert transactions into transactions: 
INSERT INTO transactions (item_id, buyer_id, seller_id) 
VALUES (1, 2, 3);

--insert disputes : 
INSERT INTO disputes (transaction_id, raised_by, description, verdict)
VALUES (1, 2, 'Item received was not as described', 'Refund to buyer');


--insert gst_rates: 
INSERT INTO gst_rates (category, gst_rate)
VALUES ('Clothing', 18.00);

INSERT INTO gst_rates (category, gst_rate)
VALUES ('Electronics', 18.00);

INSERT INTO gst_rates (category, gst_rate)
VALUES ('Grocery', 12.00);

INSERT INTO gst_rates (category, gst_rate)
VALUES ('Miscellaneous', 9.00);




-- To retrieve all users: 
SELECT * FROM users WHERE is_deleted = 0;


-- To retrieve all products to be sold: 
SELECT * FROM Product WHERE is_deleted = 0 AND sold_status = 0;


-- To retrieve all sold products:
SELECT * FROM Product WHERE is_deleted = 0 AND sold_status = 1;

-- To retrieve all products by category:
SELECT * FROM Product WHERE is_deleted = 0 AND category = <category_name>;


-- To retrieve all transactions:
SELECT * FROM transaction WHERE is_deleted = 0;


-- To retrieve all transactions for a date range:
SELECT * FROM transaction WHERE is_deleted = 0 AND transaction_date BETWEEN <start_date> AND <end_date>;

-- To retrieve transaction by transaction id: 
SELECT * FROM transaction WHERE is_deleted = 0 AND transaction_id = <transaction_id>;


-- To retrieve all refunded products for a date range: 
SELECT * FROM transaction WHERE is_deleted = 0 AND refund_status = 1 AND transaction_date BETWEEN <start_date> AND <end_date>;




