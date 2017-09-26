CREATE DATABASE `perfectsolution` /*!40100 DEFAULT CHARACTER SET utf8 */;


CREATE TABLE product_category (
	id int NOT NULL AUTO_INCREMENT,
	name_en NVARCHAR(50),
    name_ar NVARCHAR(50),
	description_en NTEXT,
    description_ar NTEXT,
	image_url NVARCHAR(50),
	is_active BOOLEAN,
	CONSTRAINT pk_category_id PRIMARY KEY (id) 
);

CREATE TABLE users (
	id int NOT NULL AUTO_INCREMENT,
	first_name NVARCHAR(50),
	last_name NVARCHAR(50),
    user_name NVARCHAR(100),
	password NVARCHAR(60),
	role NVARCHAR(50),
	enabled BOOLEAN,  
	CONSTRAINT pk_user_id PRIMARY KEY(id)
);

CREATE TABLE product (
	id int NOT NULL AUTO_INCREMENT,
	code NVARCHAR(20),
	name_en NVARCHAR(50),
    name_ar NVARCHAR(50),
	brand_en NVARCHAR(50),
    brand_ar NVARCHAR(50),
	description_en TEXT,
    description_ar TEXT,
	is_active BOOLEAN,
	category_id INT,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
 	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES product_category (id)
);

CREATE TABLE service (
	id int NOT NULL AUTO_INCREMENT,
	code NVARCHAR(20),
	name_en NVARCHAR(50),
    name_ar NVARCHAR(50),
	description_en TEXT,
    description_ar TEXT,
	is_active BOOLEAN,
	category_id INT,
	CONSTRAINT pk_service_id PRIMARY KEY (id),
);
