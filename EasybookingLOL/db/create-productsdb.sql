/* DELETE 'productsDB' database*/
DROP SCHEMA easyDB;
/* DELETE USER 'products_user' AT LOCAL SERVER*/
DROP USER 'admin'@'%';

/* CREATE ''productsDB' DATABASE */
CREATE SCHEMA easyDB;
/* CREATE THE USER 'products_user' AT LOCAL SERVER WITH PASSWORD 'password' */
CREATE USER 'admin'@'%' IDENTIFIED BY '123';
/* GRANT FULL ACCESS TO THE DATABASE FOR THE USER 'products_user' AT LOCAL SERVER*/
GRANT ALL ON productsDB.* TO 'admin'@'%';
