# myjdbcemployeeapp
#JDBC CRUD Application - No Maven - pure JDBC
##Some DML statements that needs to be executed before the application starts

CREATE DATABASE employee_jdbc_db;
SHOW DATABASES;

USE employee_jdbc_db;

CREATE TABLE `employee` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(200) NOT NULL,
	`email` VARCHAR(200) NOT NULL,
	`sal` FLOAT NOT NULL,
	`addr` VARCHAR(200) NOT NULL,
	`published_at` DATETIME NULL,
	PRIMARY KEY (`id`)
)

SHOW TABLES;
DESC employee;

SELECT * FROM employee;
DELETE FROM employee WHERE id > 5;

UPDATE employee
SET name = 'Jyoti Saxena', email = 'jkhanna@gmail.com', sal = 98999.77, addr = 'Washington, DC'
WHERE id = 3;

SELECT * FROM employee WHERE id = 3

