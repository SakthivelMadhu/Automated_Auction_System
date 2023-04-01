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
  comment TEXT,
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

-- product table 
CREATE TABLE Product (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    quantity INT NOT NULL,
    description VARCHAR(100) NOT NULL,
    sold_status INT NOT NULL DEFAULT 0,
    category ENUM('Clothing', 'Electronics', 'Grocery', 'Miscellaneous') NOT NULL,
    seller_id INT NOT NULL,
    FOREIGN KEY (seller_id) REFERENCES users(user_id),
    is_deleted INT NOT NULL DEFAULT 0
);


-- admin table 
CREATE TABLE admin (
  admin_id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(50) NOT NULL
);


-- To retrieve all users: 
SELECT * FROM User WHERE is_deleted = 0;


-- To retrieve all products to be sold: 
SELECT * FROM Product WHERE is_deleted = 0 AND sold_status = 0;


-- To retrieve all sold products:
SELECT * FROM Product WHERE is_deleted = 0 AND sold_status = 1;

-- To retrieve all products by category:
SELECT * FROM Product WHERE is_deleted = 0 AND category = <category_name>;


-- To retrieve all transactions:
SELECT * FROM Transaction WHERE is_deleted = 0;


-- To retrieve all transactions for a date range:
SELECT * FROM Transaction WHERE is_deleted = 0 AND transaction_date BETWEEN <start_date> AND <end_date>;

-- To retrieve transaction by transaction id: 
SELECT * FROM Transaction WHERE is_deleted = 0 AND transaction_id = <transaction_id>;


-- To retrieve all refunded products for a date range: 
SELECT * FROM Transaction WHERE is_deleted = 0 AND refund_status = 1 AND transaction_date BETWEEN <start_date> AND <end_date>;


-- To register a user:  
INSERT INTO User (username, first_name, last_name, address, mobile_no, password) VALUES (<username>, <first_name>,
