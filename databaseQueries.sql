CREATE DATABASE `perfectsolution` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE subscriber (
	id int NOT NULL AUTO_INCREMENT,
	email NVARCHAR(70),
	is_active BOOLEAN,
    code NVARCHAR(20),
	CONSTRAINT pk_subscriber_id PRIMARY KEY (id) 
);


CREATE TABLE client (
	id int NOT NULL AUTO_INCREMENT,
	name_en NVARCHAR(50),
    name_ar NVARCHAR(50),
	is_active BOOLEAN,
    code NVARCHAR(20),
	CONSTRAINT pk_client_id PRIMARY KEY (id) 
);

CREATE TABLE category (
	id int NOT NULL AUTO_INCREMENT,
	category_type int NOT NULL,
	name_en NVARCHAR(50),
    name_ar NVARCHAR(50),
	is_active BOOLEAN,
	CONSTRAINT pk_category_id PRIMARY KEY (id) 
);

CREATE TABLE admin (
	id int NOT NULL AUTO_INCREMENT,
	email VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(60),	
	CONSTRAINT pk_user_id PRIMARY KEY(id)
);
insert into admin (email, role, enabled, password) values ('omar.tareefy@hotmail.com', 'ADMIN', true, 'admin')

CREATE TABLE product (
	id int NOT NULL AUTO_INCREMENT,
	code NVARCHAR(20),
	name_en NVARCHAR(50),
    name_ar NVARCHAR(50),
	description_en TEXT,
    description_ar TEXT,
	is_active BOOLEAN,
	category_id INT,
	CONSTRAINT pk_product_id PRIMARY KEY (id)
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

CREATE TABLE about(
	id int NOT NULL AUTO_INCREMENT,
	description_en TEXT,
    description_ar TEXT,
    mission_en TEXT,
	mission_ar TEXT,
	vision_en TEXT,
	vision_ar TEXT,
	top_img_url NVARCHAR(128),
	desc_img_url NVARCHAR(128),
	CONSTRAINT pk_about_id PRIMARY KEY (id)
);

CREATE TABLE configuration(
	id int NOT NULL AUTO_INCREMENT,
	gmail_sender_mail_username NVARCHAR(128),
    gmail_sender_mail_password NVARCHAR(128),
    company_mail_address NVARCHAR(128),
    email_subject NVARCHAR(128),
	company_phone NVARCHAR(128),
	youtube NVARCHAR(128),
	facebook NVARCHAR(128),
	linkedin NVARCHAR(128),
	twitter NVARCHAR(128)
	CONSTRAINT pk_configuration_id PRIMARY KEY (id)
);
insert into configuration (gmail_sender_mail_username, gmail_sender_mail_password, company_mail_address, email_subject, company_phone)values('Mashagbawebsite', 'mashagbawebsite2017', 'omar.tareefy@hotmail.com', 'Message from a client', '+962-78-650-1066');

alter table about drop column desc_img_url
alter table about drop column top_img_url
alter table product drop foreign key fk_product_category_id

