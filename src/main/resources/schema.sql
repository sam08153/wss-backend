DROP TABLE IF EXISTS food_truck;
CREATE TABLE food_truck (
id INT AUTO_INCREMENT  PRIMARY KEY,
food_truck_id INT,
food_truck_name VARCHAR(80) NOT NULL,
location VARCHAR(255) NOT NULL,
food_name VARCHAR(255) NOT NULL,
food_price VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS order_food;
CREATE TABLE order_food (
id INT AUTO_INCREMENT  PRIMARY KEY,
food_name VARCHAR(255) NOT NULL,
food_truck_name VARCHAR(255) NOT NULL,
food_price VARCHAR(255) NOT NULL,
employee_name VARCHAR(255) NOT NULL,
employee_id VARCHAR(255) NOT NULL
);
