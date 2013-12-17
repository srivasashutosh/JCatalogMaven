CREATE DATABASE catalog;

USE catalog;

CREATE TABLE IF NOT EXISTS category (
	id int(10) primary key auto_increment, 
	name varchar(50) not null, 
	description varchar(255));

CREATE TABLE IF NOT EXISTS product (
	id varchar(20) primary key, 
	name varchar(50) not null, 
	price decimal(8, 2), 
	width decimal(8, 2), 
	height decimal(8, 2), 
	description longtext);

CREATE TABLE IF NOT EXISTS product_category (
	product_id varchar(20) not null, 
	category_id int(10) not null);

CREATE TABLE IF NOT EXISTS user (
	username varchar(20) primary key, 
	password varchar(20) not null);

ALTER TABLE product_category ADD primary key (product_id, category_id);

ALTER TABLE product_category ADD FOREIGN KEY (productid) 
         REFERENCES product(id) 
         ON DELETE RESTRICT 
         ON UPDATE RESTRICT;

ALTER TABLE product_category ADD FOREIGN KEY (categoryid) 
         REFERENCES category(id) 
         ON DELETE RESTRICT 
         ON UPDATE RESTRICT;
         
COMMIT;